package guru.mfilippi.carnivoro;



public class Erbivoro extends Animale {
	private static int FORZA_ERBIVORO = 2;
	private static double PROBABILITA_RIPRODUZIONE = 0.45;
	public Erbivoro(){
		this(FORZA_ERBIVORO);	
	}
	
	private Erbivoro(int forza){
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
		nuovaPosizione = territorio.posizioneLiberaVicino(this.getPosizione());
		if (nuovaPosizione!=null){
			super.incrementaCibo(1);
			territorio.sposta(this, nuovaPosizione);
		} else {
			this.incrementaCibo(-1);
		}
		this.incrementaAnni();
	}
	
	public void riproduci(Territorio territorio) {
		Double random = Math.random();
		Posizione posizioneFiglio = territorio.posizioneLiberaVicino(this.posizione);
		
		if ((posizioneFiglio!= null) && (PROBABILITA_RIPRODUZIONE > random)) {
			Erbivoro figlio = this.creaFiglio();
			territorio.setAnimale(figlio, posizioneFiglio);
		}
	}

	public Erbivoro creaFiglio() {
		return new Erbivoro();
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
		Erbivoro other = (Erbivoro) obj;
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

