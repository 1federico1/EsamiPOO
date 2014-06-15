package guru.mfilippi.febbraio2007;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Collections;

public class SelettoreLibriAntichi implements Selettore {

	private class OrdinatoreAntichi implements
			Comparator<Entry<Integer, List<Libro>>> {

		@Override
		public int compare(Entry<Integer, List<Libro>> o1,
				Entry<Integer, List<Libro>> o2) {
			return o1.getKey().intValue() - o2.getKey().intValue();
		}

	}

	@Override
	public List<Libro> seleziona(List<Libro> lista) {
		Map<Integer, List<Libro>> mappa = new HashMap<>();
		for (Libro libro : lista) {
			List<Libro> libri = mappa.get(libro.getAnnoPubblicazione());
			if (libri == null)
				libri = new LinkedList<>();
			libri.add(libro);
			mappa.put(libro.getAnnoPubblicazione(), libri);
		}
		List<Entry<Integer, List<Libro>>> insieme = new LinkedList<>(mappa.entrySet());
		Collections.sort(insieme, new OrdinatoreAntichi());
		return insieme.get(0).getValue();
	}

}
