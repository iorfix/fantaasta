package org.fasta.dati;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.fasta.dati.struct.CreditiResiduiRuolo;
import org.fasta.dati.struct.CreditiRuolo;
import org.fasta.dati.struct.GiocatoreElaborazione;
import org.fasta.dati.struct.PropostaGiocatore;
import org.fasta.dati.struct.SetupRuolo;
import org.fasta.dati.struct.SquadraRuoloElaborazione;

public class RuoloProcessor {

	private List<GiocatoreElaborazione> ranking;
	private List<SquadraRuoloElaborazione> squadre;
	private final Random randomGen;
	private final int numGiocatoriRuolo;
	private final static Comparator<GiocatoreElaborazione> CMP = new GiocatoreElaborazioneComparator();
	private int posizioneAssegnazione;
	
	public RuoloProcessor(Random randomGen, int numGiocatoriRuolo) {
		this.randomGen = randomGen;
		this.numGiocatoriRuolo = numGiocatoriRuolo;
	}
	
	public List<GiocatoreElaborazione> getRanking() {
		return ranking;
	}

	public List<SquadraRuoloElaborazione> getSquadre() {
		return squadre;
	}



	/** definisce il primo ranking */
	public void init(List<SetupRuolo> setup ) {
		posizioneAssegnazione=0;
		squadre = setup.stream().map(x-> setupRuoloSquadra(randomGen, x)).collect(Collectors.toList());
		ranking = defineRanking(squadre);
	}
	
	
	public void assegnaTutti() {
		//completa tutto il ranking
		while (assegnaProssimo()!=null) {
			
		}
	}
	
	public List<CreditiResiduiRuolo> calculateCreditiResidui() {
		List<CreditiResiduiRuolo> crediti = new ArrayList<>();
		for (SquadraRuoloElaborazione squadra : squadre) {
			CreditiResiduiRuolo credito = new CreditiResiduiRuolo(squadra.getSquadra(), squadra.getCrediti().getCreditiResidui());
			crediti.add(credito);
		}
		return crediti;
//		for (SquadraRuoloElaborazione squadra : squadre) {
//			int consumati = squadra.getAssegnato().stream().mapToInt(x-> x.getQuotafinale()).sum();
//			int residui = squadra.getCrediti().getCreditiResidui()
//		}
//		squadre.stream().map(x-> x.g)
	}
	
	
	public GiocatoreElaborazione assegnaProssimo() {
		if (ranking.isEmpty()) {
			return null;
		}
		GiocatoreElaborazione giocatore = ranking.get(0);
		posizioneAssegnazione++;
		ranking.remove(0);
		String nomeGioc = giocatore.getNome();
		int valoreAssegnato = calcolaAstaGiocatore(giocatore, ranking);
		SquadraRuoloElaborazione squadra = squadre.stream().filter(x->x.getSquadra().equals(giocatore.getSquadra())).findFirst().get();
		giocatore.setQuotafinale(valoreAssegnato);
		giocatore.setPosizioneAssegnazione(posizioneAssegnazione);
		String nomeSquadra = squadra.getSquadra();
		System.out.println("assegnato " + nomeGioc + " a "+ giocatore.getSquadra() + " a " + valoreAssegnato);
		squadra.getAssegnato().add(giocatore);
		//diminuisci i crediti
		int residui = squadra.getCrediti().getCreditiResidui()-valoreAssegnato;
		squadra.getCrediti().setCreditiResidui(residui);
		//se e il primo giocatore, cappa tutti gli altri del 20%
		int numAssegnatiSquadra = squadra.getAssegnato().size();
		//fai in modo che ci sia almeno un credito per giocatore
		final int maxCapGiocatore = residui - (numGiocatoriRuolo - numAssegnatiSquadra -1);
		final double coeffDivisione = numAssegnatiSquadra==1 ? 0.8 : 0.5;
		squadra.getPapabile().stream().forEach(x-> correggiCapping(x, maxCapGiocatore, coeffDivisione));
		
		boolean isSquadraCompleta = numAssegnatiSquadra==numGiocatoriRuolo;
		
		//rimuovi i giocatori delle altre squadre con stesso nome, e tutti quelli della squadra se completa
		//e riordina la lista
		Iterator<GiocatoreElaborazione> remoteIter = ranking.iterator();
		while (remoteIter.hasNext()) {
			GiocatoreElaborazione giocRank = remoteIter.next();
			if ((giocRank.getSquadra().equals(nomeSquadra) && isSquadraCompleta) || giocRank.getNome().equals(nomeGioc)) {
				remoteIter.remove();
			}
		}
		//riordina dopo l'operazione
		ranking.sort(CMP);
		return giocatore;
	}
	

	private static int calcolaAstaGiocatore(GiocatoreElaborazione giocatore, List<GiocatoreElaborazione> ranking) {
		int offerta = giocatore.getQuotacap();
		Optional<GiocatoreElaborazione> maxOffertaOpt = ranking.stream().filter(x-> x.getNome().equals(giocatore.getNome())).findFirst();
		if (!maxOffertaOpt.isPresent()) {
			//nessun altra offerta
			return 1;
		}
		int otherCap = maxOffertaOpt.get().getQuotacap();
		if (offerta == otherCap) {
			return offerta;
		} else {
			return otherCap+1;
		}
	}

	private static GiocatoreElaborazione correggiCapping(GiocatoreElaborazione gel, int maxCapGiocatore, double coeffDivisione) {
		int prevCapped = gel.getQuotacap();
		if (prevCapped==0) {
			//vuol dire che il giocatore e' stato già preso o comunque non selezionabile
			return gel;
		}
		int org = gel.getQuotaorg();
		int capped1 = (int)(Math.round((double)org*coeffDivisione));
		int veroCap = capped1<1?1:capped1;
		int capped = Math.min(veroCap, maxCapGiocatore);
		gel.setQuotacap(capped);
		return gel;
	}

	private static SquadraRuoloElaborazione setupRuoloSquadra(Random randomGen, SetupRuolo setupRuolo) {
		SquadraRuoloElaborazione sre = new SquadraRuoloElaborazione();
		final String squadra = setupRuolo.getSquadra();
		sre.setSquadra(squadra);
		CreditiRuolo crediti = new CreditiRuolo();
		int creditiIniziali = setupRuolo.getProposta().getCrediti();
		int creditiRip = setupRuolo.getCreditiRiportati();
		int creditiTotali = creditiIniziali + creditiRip;
		crediti.setCreditiIniziali(creditiIniziali);
		crediti.setCreditiRiportati(creditiRip);
		crediti.setCreditiResidui(creditiTotali);
		sre.setCrediti(crediti);
		
		List<PropostaGiocatore> propostaList = setupRuolo.getProposta().getGiocatore();
		List<GiocatoreElaborazione> giocElabL = propostaList.stream().map(x -> setupGiocatoreElaborazione(squadra, x)).collect(Collectors.toList());
		for (int i=0; i<giocElabL.size(); i++) {
			int randomVal = randomGen.nextInt();
			giocElabL.get(i).setOrdine(i+1);
			giocElabL.get(i).setRandom(randomVal);
		}
		sre.setPapabile(giocElabL);
		return sre;
	}
	
	private static GiocatoreElaborazione setupGiocatoreElaborazione(String squadra, PropostaGiocatore propGioc) {
		GiocatoreElaborazione gel = new GiocatoreElaborazione();
		gel.setSquadra(squadra);
		gel.setNome(propGioc.getNome());
		gel.setQuotaorg(propGioc.getQuota());
		gel.setQuotacap(propGioc.getQuota());
		return gel;
	}
	
	private static List<GiocatoreElaborazione> defineRanking(List<SquadraRuoloElaborazione> squadre) {
		List<GiocatoreElaborazione> unorderList = squadre.stream().flatMap( x -> x.getPapabile().stream()).collect(Collectors.toList());
		 
		LinkedList<GiocatoreElaborazione> ll = new LinkedList<>(unorderList);
		ll.sort(CMP);
		return ll;
	}
	
	public void cleanElaborazione() {
		squadre.stream().forEach(x-> x.getPapabile().clear());
	}
}
