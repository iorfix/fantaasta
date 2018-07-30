package org.fasta.dati;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.fasta.dati.struct.CreditiResiduiRuolo;
import org.fasta.dati.struct.GiocatoreElaborazione;
import org.fasta.dati.struct.Proposta;
import org.fasta.dati.struct.PropostaGiocatore;
import org.fasta.dati.struct.Propostaruolo;
import org.fasta.dati.struct.Proposte;
import org.fasta.dati.struct.SetupRuolo;
import org.fasta.dati.struct.SquadraRuoloElaborazione;

public class AstaMain {

	public static void main(String[] args) throws Exception {
		if (args.length < 1) {
			System.err.println("Usage: java -jar asta-1.0.jar <filename>");
		}
		String fileName = args[0];
		File file = new File(fileName);
		Proposte proposte = AcquisizioneSquadre.leggiProposte(file);
		Random random = new Random(1L);
		
		
		Proposte risultato = new Proposte();
		risultato.getProposta().addAll(proposte.getProposta().stream().map(
				x -> x.getSquadra()).map(x-> {Proposta p = new Proposta(); p.setSquadra(x); return p;}).collect(Collectors.toList())); 
		
		RuoloProcessor portieriProc = processaRuolo(random, 3, proposte, Proposta::getPortieri, null);
		assegnaGiocatori(portieriProc, Proposta::setPortieri, risultato.getProposta());
		List<CreditiResiduiRuolo> creditiResidui = portieriProc.calculateCreditiResidui();
		System.out.println("Crediti residui:" + creditiResidui);
		RuoloProcessor difensoriProc = processaRuolo(random, 8, proposte, Proposta::getDifensori, creditiResidui);
		assegnaGiocatori(difensoriProc, Proposta::setDifensori, risultato.getProposta());
		creditiResidui = difensoriProc.calculateCreditiResidui();
		System.out.println("Crediti residui:" + creditiResidui);
		RuoloProcessor centroProc = processaRuolo(random, 8, proposte, Proposta::getCentrocampisti, creditiResidui);
		assegnaGiocatori(centroProc, Proposta::setCentrocampisti, risultato.getProposta());
		creditiResidui =  centroProc.calculateCreditiResidui();
		System.out.println("Crediti residui:" + creditiResidui);
		RuoloProcessor attaccantiProc = processaRuolo(random, 6, proposte, Proposta::getAttaccanti, creditiResidui);
		assegnaGiocatori(attaccantiProc, Proposta::setAttaccanti, risultato.getProposta());

		creditiResidui =  centroProc.calculateCreditiResidui();
		System.out.println("Crediti residui:" + creditiResidui);
		String xmlRisultato = AcquisizioneSquadre.scriviProposte(risultato);
		System.out.println("ASTA FINALE: " + xmlRisultato);
		
	}
	
	private static void assegnaGiocatori(RuoloProcessor ruoloProc, BiConsumer<Proposta, Propostaruolo> f, List<Proposta> proposte) {
		List<SquadraRuoloElaborazione> squadreAssegnate = ruoloProc.getSquadre();
		Map<String, SquadraRuoloElaborazione> squadreMap=  squadreAssegnate.stream().collect(Collectors.toMap(SquadraRuoloElaborazione::getSquadra, Function.identity()));
		proposte.stream().forEach(
				x-> { 
					String nome = x.getSquadra(); 
					f.accept(x, new Propostaruolo(creaRisultatoProposta(squadreMap.get(nome)), 0));} );
		
	}

	private static List<PropostaGiocatore> creaRisultatoProposta(SquadraRuoloElaborazione assegnati) {
		List<GiocatoreElaborazione> giocatori = assegnati.getAssegnato();
		return giocatori.stream().map(x-> new PropostaGiocatore(x.getNome(), x.getQuotafinale())).collect(Collectors.toList()); 
	}
	
	private static RuoloProcessor processaRuolo(Random random, int numGiocatoriRuolo, Proposte proposte, Function<Proposta, Propostaruolo> f, List<CreditiResiduiRuolo> creditiResidui) {
		List<SetupRuolo> ruoloSetup = AcquisizioneSquadre.creaRuolo(proposte, creditiResidui, f);
		RuoloProcessor ruoloProcessor = new RuoloProcessor(random, numGiocatoriRuolo);
		ruoloProcessor.init(ruoloSetup);
//		System.out.println("ranking: " + ruoloProcessor.getRanking());
//		System.out.println("squadre: " + ruoloProcessor.getSquadre());
		ruoloProcessor.assegnaTutti();
		return ruoloProcessor;
	}
}
