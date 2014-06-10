package guru.mfilippi.luglio2008;

import java.util.*;
import java.util.Map.Entry;

public class Consorzio extends Societa implements Comparable<Consorzio> {
	private Map<String, Societa> societa;
	
	private class OrdinamentoCostituzione implements Comparator<Societa> {

		@Override
		public int compare(Societa o1, Societa o2) {
			return o1.getAnnoDiCostituzione() - o2.getAnnoDiCostituzione();
		}
		
	}
	
	public Consorzio(int annoCostituzione, String nazione, String nome) {
		super(annoCostituzione, nazione, nome);
		this.societa = new HashMap<String, Societa>();
	}

	@Override
	public int getNumeroDipendenti() {
		int numero = super.getNumeroDipendenti();
		for(Societa societa: this.societa.values()){
			numero += societa.getNumeroDipendenti();
		}
		return numero;
	}

	public int compareTo(Consorzio that) {
		return this.getNome().compareTo(that.getNome());
	}

	public void aggiungiConsorziata(Societa societa) {
		this.societa.put(societa.getNome(), societa);
	}

	private void aggiugiSocieta(Map<String, List<Societa>> mappa, String nazione, Societa societa){
		List<Societa> presenti = mappa.get(nazione);
		if (presenti == null) presenti = new LinkedList<>();
		
		presenti.add(societa);
		Collections.sort(presenti, new OrdinamentoCostituzione());
		mappa.put(nazione, presenti);
		
	}
	
	private void aggiugiSocieta(Map<String, List<Societa>> mappa, String nazione, List<Societa> societa){
		List<Societa> presenti = mappa.get(nazione);
		if (presenti == null) presenti = new LinkedList<>();
		
		presenti.addAll(societa);
		Collections.sort(presenti, new OrdinamentoCostituzione());
		mappa.put(nazione, presenti);
	}
	
	@Override
	public Map<String, List<Societa>> nazione2consorziate() {
		Map<String, List<Societa>> mappa = new HashMap<>();
		
		aggiugiSocieta(mappa, this.getNazione(), this);
		
		for(Societa societa: this.societa.values()){
			for(Entry<String, List<Societa>> elemento: societa.nazione2consorziate().entrySet()){
				aggiugiSocieta(mappa, elemento.getKey(), elemento.getValue());
			}
		}
		
		return null;
	}
}
