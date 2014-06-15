package guru.mfilippi.febbraio2007;

import java.util.LinkedList;
import java.util.List;

public class SelettoreLibriItaliani implements Selettore {

	@Override
	public List<Libro> seleziona(List<Libro> lista) {
		List<Libro> list = new LinkedList<>();
		for(Libro libro: lista){
			if (libro.getEditore().getNazionalita().equals("IT")) list.add(libro);
		}
		return list;
	}

}
