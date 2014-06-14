package guru.mfilippi.febbraio2006;

public class Libro extends Articolo {
	public Libro(String codice, int costoUnitario) {
		super(codice, costoUnitario);
	}

	public boolean equals(Object o) {
		Libro l = (Libro) o;
		return this.getCodice().equals(l.getCodice());
	}

	public int hashCode() {
		return this.getCodice().hashCode();
	}
}
