package guru.mfilippi.giugno2010;

import java.util.List;

public interface Selezionatore {
	public List<Autore> eseguiSelezione(List<Libro> livriInBiblioteca);
}
