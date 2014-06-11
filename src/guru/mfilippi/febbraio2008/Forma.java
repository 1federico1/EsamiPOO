package guru.mfilippi.febbraio2008;

public abstract class Forma implements Comparable<Forma>{

	private Colore colore;
	
	public Forma(Colore colore){
		this.colore = colore;
	}
	
	abstract public double superficie();
	
	public Colore getColore() {
		return this.colore;
	}
	
	@Override
	public int compareTo(Forma that){
		return (int)(this.superficie() - that.superficie());
	}
	
}
