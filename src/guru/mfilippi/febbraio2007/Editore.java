package guru.mfilippi.febbraio2007;

public class Editore {
	private String nazionalita;
	private String nome;

	public Editore(String nome, String nazionalita) {
		this.nome = nome;
		this.nazionalita = nazionalita;
	}

	public String getNome() {
		return this.nome;
	}

	public String getNazionalita() {
		return this.nazionalita;
	}
}
