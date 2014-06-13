package guru.mfilippi.giugno2010;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SelezionatoreAutoriProlifici implements Selezionatore {

	private class OrdinatoreEntryAutore implements Comparator<Entry<Autore, Integer>>{

		public int compare(Entry<Autore, Integer> o1, Entry<Autore, Integer> o2){
			return o2.getValue().intValue() - o1.getValue().intValue();
		}
	}

	private List<Entry<Autore, Integer>> autori2numeroLibri(List<Libro> libri){
		Map<Autore, Integer> mappa = new HashMap<>();
		for(Libro l: libri){
			for(Autore autore: l.getAutori()){
				Integer numero = mappa.get(autore);
				if (numero == null) numero = new Integer(1);
				else numero = new Integer(numero.intValue() +1);
				mappa.put(autore, numero);
			}
		}
		return new LinkedList<>(mappa.entrySet());
	}

	public List<Autore> eseguiSelezione(List<Libro> libri){
		List<Entry<Autore,Integer>> lista = this.autori2numeroLibri(libri);
		List<Autore> autori = new LinkedList<>();
		Collections.sort(lista, new OrdinatoreEntryAutore());

		int massimo = lista.get(0).getValue().intValue();
		for(Entry<Autore, Integer> entry: lista){
			if (entry.getValue().intValue() == massimo){
				autori.add(entry.getKey());
			}else{
				return autori;
			}
		}
		return autori;
	}

}
