package guru.mfilippi.febbraio2006;

public class Articolo {

	private String codice;
	private int costoUnitario;

	public Articolo(String codice, int costoUnitario) {
		this.codice = codice;
		this.costoUnitario = costoUnitario;
	}

	public String getCodice() {
		return this.codice;
	}

	public int getCostoUnitario() {
		return this.costoUnitario;
	}

}