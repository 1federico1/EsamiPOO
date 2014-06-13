package guru.mfilippi.giugno2010;

import java.util.*;

public class Biblioteca {
	private Map<String, Libro> codice2libro;

	public Biblioteca() {
		this.codice2libro = new HashMap<String, Libro>();
	}

	public void addLibro(String codice, Libro libro) {
		this.codice2libro.put(codice, libro);
	}
	
	public List<Autore> seleziona(Selezionatore selezionatore){
		return selezionatore.eseguiSelezione((List<Libro>) this.codice2libro.values());
	}

	public List<Autore> autoriGiovani() {
		return this.seleziona(new SelezionatoreAutoriGiovani());
	}

	public Map<Autore, Set<Libro>> autore2libri() {
		Map<Autore, Set<Libro>> autore2libri = new HashMap<>();
		for(Libro libro: this.codice2libro.values()){
			for(Autore autore: libro.getAutori()){
				Set<Libro> insieme = autore2libri.get(autore);
				if (insieme == null) insieme = new HashSet<>();
				insieme.add(libro);
				autore2libri.put(autore, insieme);
			}
		}
		return autore2libri;
	}
	// altri metodi omessi
}
