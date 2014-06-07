package guru.mfilippi.carnivoro;


import java.util.List;

public class Carnivoro extends Animale {
	private static int FORZA_CARNIVORO = 5;
	private static double PROBABILITA_RIPRODUZIONE = 0.45;
	public Carnivoro(){
		this(FORZA_CARNIVORO);	
	}
	
	private Carnivoro(int forza){
		this.forza = forza;
		this.livelloCibo = 2;
		this.anni = 0;
	}

	public void agisci(Territorio territorio) {
		if (this.isMorto()) {
			territorio.rimuoviAnimale(this);
			return;
		}
		this.riproduci(territorio);	
		
		Posizione nuovaPosizione;
		Animale vittima = cercaVittima(territorio);
		if (vittima != null) {		
			this.incrementaCibo(1);
			territorio.rimuoviAnimale(vittima);
			nuovaPosizione = vittima.getPosizione();
		} else {
			this.incrementaCibo(-1);
			nuovaPosizione = territorio.posizioneLiberaVicino(this.getPosizione());
		}
		if (nuovaPosizione!=null){
			territorio.sposta(this, nuovaPosizione);
		}		
		this.incrementaAnni();
	}

	private Animale cercaVittima(Territorio territorio) {
		List<Posizione> adiacenti = territorio.adiacenti(this.getPosizione()); 
		for(Posizione p : adiacenti) {
			Animale a = territorio.getAnimale(p);
			if ((a!=null) && (this.getForza()>a.getForza())) {
				return a;
			}
		}
		return null;
	}

	public void riproduci(Territorio territorio) {
		Double random = Math.random();
		Posizione posizioneFiglio = territorio.posizioneLiberaVicino(this.posizione);
		
		if ((posizioneFiglio!= null) && (PROBABILITA_RIPRODUZIONE > random)) {
			Carnivoro figlio = this.creaFiglio();
			territorio.setAnimale(figlio, posizioneFiglio);
		}
	}

	public Carnivoro creaFiglio() {
		return new Carnivoro();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anni;
		result = prime * result + forza;
		result = prime * result + livelloCibo;
		result = prime * result
				+ ((posizione == null) ? 0 : posizione.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carnivoro other = (Carnivoro) obj;
		if (anni != other.anni)
			return false;
		if (forza != other.forza)
			return false;
		if (livelloCibo != other.livelloCibo)
			return false;
		if (posizione == null) {
			if (other.posizione != null)
				return false;
		} else if (!posizione.equals(other.posizione))
			return false;
		return true;
	}	
	
	
}

