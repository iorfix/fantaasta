package org.fasta.dati;

import java.util.Comparator;

import org.fasta.dati.struct.GiocatoreElaborazione;

public class GiocatoreElaborazioneComparator implements Comparator<GiocatoreElaborazione>{

	@Override
	public int compare(GiocatoreElaborazione o1, GiocatoreElaborazione o2) {
		int cmp = Integer.compare(o1.getQuotacap(), o2.getQuotacap());
		if (cmp!=0) {
			//nota l'ordine per quota e' INVERSO
			return -cmp;
		}
		//parita di quota, si vede la posizione nel ranking
		cmp = Integer.compare(o1.getOrdine(), o2.getOrdine());
		if (cmp!=0) {
			return cmp;
		}
		//si vede il valore iniziale non cappato
		cmp = Integer.compare(o1.getQuotaorg(), o2.getQuotaorg());
		if (cmp!=0) {
			//nota l'ordine per quota e' INVERSO
			return -cmp;
		} 
		// si va random
		cmp = Integer.compare(o1.getRandom(), o2.getRandom());
		return cmp;
	}
}
