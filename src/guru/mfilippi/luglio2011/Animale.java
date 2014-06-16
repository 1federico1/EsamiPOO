package guru.mfilippi.luglio2011;

public abstract class Animale {
	
	private Posizione posizione;
	private int peso;
	private int anni;
	private int cibo;

	public Animale(int peso, int cibo, int anni){
		this.peso = peso;
		this.cibo = cibo;
		this.anni = anni;
	}
	
	public void setPosizione(Posizione posizione){
		this.posizione = posizione;
	}

	public Posizione getPosizione() {
		return this.posizione;
	}

	public int getPeso() {
		return this.peso;
	}

	public int getAnni() {
		return this.anni;
	}

	public boolean isMorto(){
		return (this.cibo==0)||(this.anni==5);
	}

	public void invecchia(){
		this.anni++;
	}

	public void incrementaCibo(int cibo){
		this.cibo+=cibo;
	}
	
	public int getCibo() {
		return cibo;
	}
	
	abstract public void riproduci(Parco parco);
	
	abstract public void agisci(Parco parco);
	
	abstract Animale creaFiglio();
}
