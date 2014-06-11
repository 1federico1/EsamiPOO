package guru.mfilippi.luglio2006;

public abstract class Forma {

	private Colore colore;
	
	public Forma(Colore colore){
		this.colore = colore;
	}
	
	public Colore getColore() {
		return this.colore;
	}

}
