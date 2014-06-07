package guru.mfilippi.carnivoro;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Territorio {
	private static final int NUM_INIZIALE_ANIMALI = 2200;
	private static final double PROBABILITA_CARNIVORO = 0.2;

	private int dimensione;	
	private Map<Posizione, Animale> posizione2animale;	
	private Map<Posizione, Carnivoro> posizione2carnivoro;
	
	private class OrdinamentoAnniMaggiori implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.intValue() - o1.intValue();
		}
		
	}

	public Territorio(int dimensione){
		this.dimensione = dimensione;
		this.posizione2animale = new HashMap<Posizione, Animale>();
		this.popolaTerritorio();
	}
	
	public Animale getAnimale(Posizione posizione){
		return posizione2animale.get(posizione);
	}

	public void rimuoviAnimale(Animale animale) {
		this.posizione2animale.remove(animale.getPosizione());
	}

	public void setAnimale(Animale animale, Posizione posizione) {
		if (this.getAnimale(posizione)==null){
			this.posizione2animale.put(posizione, animale);
			animale.setPosizione(posizione);
		} 
	}
	
	public Collection<Animale> getAnimale(){
		return this.posizione2animale.values();
	}
	
	public void sposta(Animale animale, Posizione nuovaPosizione) {
		this.rimuoviAnimale(animale);
		this.setAnimale(animale, nuovaPosizione);		
	}		
	
	public List<Posizione> adiacenti(Posizione posizione) {
		List<Posizione> adiacenti = new LinkedList<Posizione>();
		int x = posizione.getX();
		int y = posizione.getY();
		
		for(int i = -1; i<2; i++) {
			for(int j = -1; j<2; j++) {
				adiacenti.add(new Posizione(x+i, y+j));
				}
			}
		Iterator<Posizione> it = adiacenti.iterator();
		while(it.hasNext()){
			Posizione p = it.next();
			if ((p.getX()<0) || (p.getX()>=this.dimensione) || (p.getY()<0) || 
					(p.getY()>=this.dimensione) || (p.equals(posizione)))
				it.remove();
		}
		Collections.shuffle(adiacenti);
		return adiacenti;
	} 
	
	public Posizione posizioneLiberaVicino(Posizione posizione) {
		for(Posizione p : this.adiacenti(posizione)) {
			if (this.isLibera(p)) {
				return p;
			}
		}
		return null;
	}
	
	public boolean isLibera(Posizione posizione) {
		return this.getAnimale(posizione)==null;
	}

	public int getDimensione() {
		return this.dimensione;
	}
	
	private void popolaTerritorio(){

		int numeroAnimali = 0;

		while (numeroAnimali < NUM_INIZIALE_ANIMALI) {
			int x = (int)(Math.random()*this.dimensione);
			int y = (int)(Math.random()*this.dimensione);
			Posizione posizione = new Posizione(x, y);
			if (this.isLibera(posizione)) {
				if(Math.random() < PROBABILITA_CARNIVORO) {
					Carnivoro nuovoAnimale = new Carnivoro();
					this.setAnimale(nuovoAnimale, posizione);
				} else {
					Erbivoro nuovoAnimale = new Erbivoro();
					this.setAnimale(nuovoAnimale, posizione);
				}
				numeroAnimali++;
			}
		}
	}
	
	public Map<Integer, Set<Animale>> anno2animali(){
		Map<Integer, Set<Animale>> nuovoRaggruppamento = new HashMap<>();
		for(Entry<Posizione, Animale> erbivori: this.posizione2animale.entrySet()){
			Integer key = new Integer(erbivori.getValue().getAnni());
			if (nuovoRaggruppamento.containsKey(key)){
				nuovoRaggruppamento.get(key).add(erbivori.getValue());
			}else{
				Set<Animale> nuovaPosizione = new HashSet<>();
				nuovaPosizione.add(erbivori.getValue());
				nuovoRaggruppamento.put(key, nuovaPosizione);
			}
		}
		return nuovoRaggruppamento;
	}
	
	public Set<Posizione> posizioniAnimaliVecchi(){
		Map<Integer, Set<Posizione>> nuovoRaggruppamento = new HashMap<>();
		for(Entry<Posizione, Animale> posizioni: this.posizione2animale.entrySet()){
			Integer key = new Integer(posizioni.getValue().getAnni());
			if (nuovoRaggruppamento.containsKey(key)){
				nuovoRaggruppamento.get(key).add(posizioni.getKey());
			}else{
				Set<Posizione> nuovaPosizione = new HashSet<>();
				nuovaPosizione.add(posizioni.getKey());
				nuovoRaggruppamento.put(key, nuovaPosizione);
			}
		}
		List<Integer> insiemeAnni = new ArrayList<>(nuovoRaggruppamento.keySet());
		Collections.sort(insiemeAnni, new OrdinamentoAnniMaggiori());
		return nuovoRaggruppamento.get(insiemeAnni.get(0));
	}
}
