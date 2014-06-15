package guru.mfilippi.febbraio2007;

import java.util.*;

public class Biblioteca {
	private Map<String, Libro> codice2libro;

	public Biblioteca() {
		this.codice2libro = new HashMap<String, Libro>();
	}

	public List<Libro> libriAntichi() {
		return this.seleziona(new SelettoreLibriAntichi());
	}

	public void aggiungiLibro(Libro libro) {
		this.codice2libro.put(libro.getCodice(), libro);
	}

	public List<Libro> getListaLibri() {
		return new LinkedList<>(this.codice2libro.values());
	}

	public Map<String, Set<Libro>> nomeEditore2libri() {
		Map<String, Set<Libro>> mappa = new HashMap<>();
		for(Libro libro: this.codice2libro.values()){
			Set<Libro> insieme = mappa.get(libro.getEditore().getNome());
			if (insieme == null) insieme = new HashSet<>();
			insieme.add(libro);
			mappa.put(libro.getEditore().getNome(),	 insieme);
		}
		return mappa;
	}
	
	public List<Libro> seleziona(Selettore selettore){
		return selettore.seleziona(this.getListaLibri());
	}
}
