package org.fasta.dati;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBException;

import org.fasta.dati.struct.CreditiResiduiRuolo;
import org.fasta.dati.struct.Proposta;
import org.fasta.dati.struct.Propostaruolo;
import org.fasta.dati.struct.Proposte;
import org.fasta.dati.struct.SetupRuolo;

import org.fasta.utils.JaxbUtils;

public class AcquisizioneSquadre {

	
	public static Proposte leggiProposte(File nomeFile) throws IOException {
		FileReader reader = new FileReader(nomeFile);
		Proposte proposte = null;
		try {
			proposte = JaxbUtils.unmarshal(Proposte.class, reader);
		} catch (JAXBException e) {
			throw new IOException(e);
		}
		return proposte;
	}
	
	public static String scriviProposte(Proposte proposte) throws IOException {
		StringWriter sWriter = new StringWriter();
		try {
			JaxbUtils.marshal(proposte, sWriter);
		} catch (Exception e) {
			throw new IOException(e);
		}
		return sWriter.toString();
	}
	
	
	
	public static List<SetupRuolo> creaPortieri(Proposte proposte, List<CreditiResiduiRuolo> creditiResidui) {
		return creaRuolo(proposte, creditiResidui, Proposta::getPortieri);
	}
	
	private static CreditiResiduiRuolo getCreditiResidui(String squadra, List<CreditiResiduiRuolo> crediti) {
		if (crediti == null) {
			return null;
		}
		return crediti.stream().filter(x-> x.getSquadra().equals(squadra)).findFirst().get();
	}
	
	public static SetupRuolo creaSetup(String nomeSquadra, Propostaruolo ruolo, CreditiResiduiRuolo creditiResidui, Boolean riversaCrediti) {
		SetupRuolo setup = new SetupRuolo();
		setup.setSquadra(nomeSquadra);
		boolean riversaCreditiB = riversaCrediti!=null && riversaCrediti.booleanValue();
		setup.setCreditiRiportati(riversaCreditiB && creditiResidui!=null ? creditiResidui.getCrediti(): 0);
		setup.setProposta(ruolo);
		return setup;
	}

	public static List<SetupRuolo> creaRuolo(Proposte proposte, List<CreditiResiduiRuolo> creditiResidui, Function<Proposta, Propostaruolo> f) {
		List<Proposta> propostaL = proposte.getProposta();
		
		List<SetupRuolo> setupRuolo = propostaL.stream().map(
				x-> { 
					return creaSetup(x.getSquadra(), f.apply(x), 
						getCreditiResidui(x.getSquadra(), creditiResidui), 
						x.isRiversacrediti() ); 
					}) 
				 .collect(Collectors.toList());
		return setupRuolo;
	}

}
