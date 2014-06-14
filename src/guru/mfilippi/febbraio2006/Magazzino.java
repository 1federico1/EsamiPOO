package guru.mfilippi.febbraio2006;

import java.util.*;
import java.util.Map.Entry;

public class Magazzino {
	private Map<Articolo, Integer> articolo2quantita;
	
	private class OrdinatoreCostoUnitario implements Comparator<Articolo>{

		@Override
		public int compare(Articolo o1, Articolo o2) {
			return o1.getCostoUnitario() - o2.getCostoUnitario();
		}
		
	}

	public Magazzino() {
		this.articolo2quantita = new HashMap<Articolo, Integer>();
	}

	public void aggiungiArticolo(Articolo articolo, int quantita) {
		articolo2quantita.put(articolo, quantita);
	}

	public int calcolaValoreMagazzino() {
		int valore = 0;
		for(Entry<Articolo, Integer> entry: this.articolo2quantita.entrySet()){
			valore += entry.getKey().getCostoUnitario() * entry.getValue().intValue();	
		}
		return valore;
	}

	public Map<Integer, Set<String>> articoliEconomici(int soglia) {
		// costo -> insieme di codici di articoli con il costo della chiave
		Map<Integer, Set<String>> costo2insiemeCodiceArticoli;
		costo2insiemeCodiceArticoli = new HashMap<Integer, Set<String>>();
		
		for(Articolo articolo: this.articolo2quantita.keySet()){
			if (articolo.getCostoUnitario() < soglia){
				Set<String> insieme = costo2insiemeCodiceArticoli.get(new Integer(articolo.getCostoUnitario()));
				if (insieme == null) insieme = new HashSet<>();
				insieme.add(articolo.getCodice());
				costo2insiemeCodiceArticoli.put(new Integer(articolo.getCostoUnitario()), insieme);
			}
		}
		
		return costo2insiemeCodiceArticoli;
	}

	public List<Articolo> articoliOrdinatiPerCosto() {
		List<Articolo> listaArticoli = new LinkedList<Articolo>(this.articolo2quantita.keySet());
		Collections.sort(listaArticoli, new OrdinatoreCostoUnitario());
		return listaArticoli;
	}
}