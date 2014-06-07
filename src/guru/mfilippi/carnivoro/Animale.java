package guru.mfilippi.carnivoro;

public abstract class Animale {

	protected int anni;
	protected int forza;
	protected Posizione posizione;
	protected int livelloCibo;

	public Animale() {
		super();
	}

	public void setPosizione(Posizione posizione) {
		this.posizione = posizione;
	}

	public Posizione getPosizione() {
		return this.posizione;
	}

	public int getForza() {
		return this.forza;
	}

	public int getAnni() {
		return this.anni;
	}

	public boolean isMorto() {
		return (this.livelloCibo==0)||(this.anni==5);
	}

	public void incrementaAnni() {
		this.anni++;
	}
	
	public void incrementaCibo(int cibo){
		this.livelloCibo+=cibo;
	}
	
	abstract public void agisci(Territorio territorio);
	
	abstract public void riproduci(Territorio territorio);
	
	abstract public Animale creaFiglio();
}