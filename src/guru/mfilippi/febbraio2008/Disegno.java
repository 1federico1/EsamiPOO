package guru.mfilippi.febbraio2008;

import java.util.*;

public class Disegno {
	private Map<Integer, List<Forma>> livello2forma;
	
	private class OrdinamentoLuminanza implements Comparator<Forma>{

		@Override
		public int compare(Forma o1, Forma o2) {
			return o1.getColore().luminosita() - o2.getColore().luminosita();
		}
		
	}

	public Disegno() {
		this.livello2forma = new TreeMap<Integer, List<Forma>>();
	}

	public void aggiungiForma(Forma forma, int livello) {
		List<Forma> lista = this.livello2forma.get(livello);
		if (lista == null){
			lista = new ArrayList<>();
		}
		lista.add(forma);
		this.livello2forma.put(livello, lista);
	}



	public Set<Colore> coloriPresentiNelDisegno() {
		Set<Colore> coloriNelDisegno = new HashSet<>();
		for (List<Forma> lista: this.livello2forma.values()){
			for(Forma forma: lista){
				coloriNelDisegno.add(forma.getColore());
			}
		}
		return coloriNelDisegno;
	}

	public Map<Colore, List<Forma>> colore2forme() {
		Map<Colore, List<Forma>> colore2forme = new HashMap<>();
		Set<Colore> coloriNelDisegno = new HashSet<>();
		for (List<Forma> lista: this.livello2forma.values()){
			for(Forma forma: lista){
				List<Forma> insieme = this.colore2forme().get(forma.getColore());
				if (insieme == null) insieme = new ArrayList<>();
				insieme.add(forma);
				Collections.sort(insieme);
				colore2forme.put(forma.getColore(), insieme);
			}
		}
		return colore2forme;
	}
	
	public List <Forma> formeOrdinatePerLuminosita(){
		List<Forma> list = new ArrayList<>();
		for (List<Forma> lista: this.livello2forma.values()){
			for(Forma forma: lista){
				list.add(forma);
			}
		}
		Collections.sort(list, new OrdinamentoLuminanza());
		return list;
	}
}
