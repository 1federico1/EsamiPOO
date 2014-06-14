package guru.mfilippi.febbraio2006;

public class Disco extends Articolo {
	public Disco(String codice, int costoUnitario) {
		super(codice, costoUnitario);
	}

	public boolean equals(Object o) {
		Disco d = (Disco) o;
		return this.getCodice().equals(d.getCodice());
	}
	
	public int hashCode() {
		return this.getCodice().hashCode();
	}
}
