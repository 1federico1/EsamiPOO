package guru.mfilippi.settembre2007;

public class Attivita {
	private String nome;
	private int costo;
	private String responsabile;

	public Attivita(String nome, String responsabile, int costo) {
		this.nome = nome;
		this.responsabile = responsabile;
		this.costo = costo;
	}

	public int getCosto() {
		return this.costo;
	}

	public String getNome() {
		return this.nome;
	}

	public String getResponsabile() {
		return this.responsabile;
	}

	public void setResponsabile(String responsabile) {
		this.responsabile = responsabile;
	}

	public int hashCode() {
		return this.getNome().hashCode();
	}

	public boolean equals(Object obj) {
		Attivita attivita = (Attivita) obj;
		return this.getNome().equals(attivita.getNome());
	}
}
