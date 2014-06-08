package guru.mfilippi.luglio2007;

import java.util.*;
import java.util.Map.Entry;

public class Cartella extends Risorsa{
	private Set<Risorsa> elencoRisorse;
	
	private class OrdinatoreAlfaberticoRisorse implements Comparator<Risorsa>{

		@Override
		public int compare(Risorsa o1, Risorsa o2) {
			return o1.getNome().compareTo(o2.getNome());
		}
		
	}

	public Cartella(String nome, String proprietario) {
		super(nome, proprietario);
		this.elencoRisorse = new HashSet<Risorsa>();
	}

	public void addRisorsa(Risorsa risorsa) {
		this.elencoRisorse.add(risorsa);
	}
	
	@Override
	public int getDimensione() {
		int dimensione = 0;
		for (Risorsa risorsa : this.elencoRisorse)
			dimensione += risorsa.getDimensione();
		return dimensione;
	}

	public int hashCode() {
		return this.getNome().hashCode();
	}

	public boolean equals(Object obj) {
		Cartella cartella = (Cartella) obj;
		return this.getNome().equals(cartella.getNome());
	}
	
	private void aggiuntaRisorsa(Map<String, Set<Risorsa>> mappa, String proprietario, Risorsa risorsa){
		Set<Risorsa> risorse = mappa.get(proprietario);
		if (risorse == null)
			risorse = new TreeSet<Risorsa>(new OrdinatoreAlfaberticoRisorse());
		risorse.add(risorsa);
		
		mappa.put(proprietario, risorse);
	}
	
	private void aggiuntaRisorsaSet(Map<String, Set<Risorsa>> mappa, String proprietario,Set<Risorsa> risorsa){
		Set<Risorsa> risorse = mappa.get(proprietario);
		if (risorse == null)
			risorse = new TreeSet<Risorsa>(new OrdinatoreAlfaberticoRisorse());
		risorse.addAll(risorsa);
		
		mappa.put(proprietario,  risorse);
	}
	
	@Override
	public Map<String, Set<Risorsa>> proprietario2risorsa() {
		Map<String, Set<Risorsa>> proprietario2risorsa = new HashMap<String, Set<Risorsa>>();
		
		aggiuntaRisorsa(proprietario2risorsa, this.getProprietario(), this);
		
		for (Risorsa risorsa : this.elencoRisorse) {
			aggiuntaRisorsa(proprietario2risorsa, risorsa.getProprietario(), risorsa);
			for(Entry<String, Set<Risorsa>> elemento: risorsa.proprietario2risorsa().entrySet()){
				aggiuntaRisorsaSet(proprietario2risorsa, elemento.getKey(), elemento.getValue());
			}
		}
		return proprietario2risorsa;
	}
	
	
}
