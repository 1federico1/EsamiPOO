package guru.mfilippi.luglio2006;

import java.util.*;
import java.util.Map.Entry;

public class Disegno {
	private Map<Forma, Integer> forma2livello;
	
	private class OrdinatoreLivello implements Comparator<Entry<Forma, Integer>>{

		@Override
		public int compare(Entry<Forma, Integer> o1, Entry<Forma, Integer> o2) {
			return o1.getValue().intValue() - o2.getValue().intValue();
		}
		
	}

	public Disegno() {
		this.forma2livello = new HashMap<Forma, Integer>();
	}

	public void aggiungiForma(Forma forma, int livello) {
		forma2livello.put(forma, livello);
	}

	public Set<Colore> coloriNelDisegno() {
		Set<Colore> coloriNelDisegno = new HashSet<Colore>();
		for(Forma forma: this.forma2livello.keySet()){
			coloriNelDisegno.add(forma.getColore());
		}
		return coloriNelDisegno;
	}

	public Map<Integer, List<Forma>> formeAffioranti(int livelloMinimo) {
		// livello -> lista di forme al livello della chiave
		Map<Integer, List<Forma>> livello2forme = new HashMap<Integer, List<Forma>>();
		for(Entry<Forma, Integer> entry: this.forma2livello.entrySet()){
			if (entry.getValue().intValue() >= livelloMinimo){
				List<Forma> lista = livello2forme.get(entry.getValue());
				if (lista == null) lista = new ArrayList<>();
				lista.add(entry.getKey());
				livello2forme.put(entry.getValue(), lista);
			}
		}
		return livello2forme;
	}

	public List<Forma> formeOrdinatePerLivello() {
		List<Forma> listaFormeOrdinata = new ArrayList<Forma>();
		List<Entry<Forma, Integer>> set = new ArrayList<>(this.forma2livello.entrySet());
		Collections.sort(set, new OrdinatoreLivello());
		for(Entry<Forma, Integer> entry: set){
			listaFormeOrdinata.add(entry.getKey());
		}
		return listaFormeOrdinata;
	}
}
