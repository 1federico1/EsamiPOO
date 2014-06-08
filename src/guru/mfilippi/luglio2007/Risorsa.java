package guru.mfilippi.luglio2007;

import java.util.*;

public abstract class Risorsa {
	private String nome;
	private String proprietario;

	public Risorsa(String nome, String proprietario) {
		this.nome = nome;
		this.proprietario = proprietario;
	}

	public String getNome() {
		return this.nome;
	}

	public String getProprietario() {
		return this.proprietario;
	}

	public abstract int getDimensione();

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public abstract Map<String, Set<Risorsa>> proprietario2risorsa();

	public int hashCode() {
		return this.nome.hashCode();
	}

	public boolean equals(Object obj) {
		Risorsa risorsa = (Risorsa) obj;
		return this.nome.equals(risorsa.getNome());
	}
}
