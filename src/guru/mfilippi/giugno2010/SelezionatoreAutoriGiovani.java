package guru.mfilippi.giugno2010;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SelezionatoreAutoriGiovani implements Selezionatore {
	
	private class OrdinatoreGiovani implements Comparator<Autore>{

		@Override
		public int compare(Autore o1, Autore o2) {
			return o2.getAnnoNascita() - o1.getAnnoNascita();
		}
		
	}
	@Override
	public List<Autore> eseguiSelezione(List<Libro> libriInBiblioteca) {
		List<Autore> autori = new ArrayList<>();
		for(Libro libro: libriInBiblioteca){
			autori.addAll(libro.getAutori());
		}
		Collections.sort(autori, new OrdinatoreGiovani());
		return autori;
	}

}
