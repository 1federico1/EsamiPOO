package guru.mfilippi.luglio2008;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class Societa {
	private int annoDiCostituzione;
	private String nazione;
	private String nome;
	private Set<Dipendente> dipendenti;
	
	public Societa(int annoDiCostituzione, String nazione, String nome) {
		this.annoDiCostituzione = annoDiCostituzione;
		this.nazione = nazione;
		this.nome = nome;
		this.dipendenti = new HashSet<Dipendente>();
	}
	
	public int getAnnoDiCostituzione() {
		return this.annoDiCostituzione;
	}

	public String getNazione() {
		return this.nazione;
	}

	public void aggiungiDipendente(Dipendente dipendente) {
		this.dipendenti.add(dipendente);
	}

	public String getNome() {
		return this.nome;
	}

	public int compareTo(Impresa that) {
		return this.getNome().compareTo(that.getNome());
	}
	
	public int getNumeroDipendenti(){
		return this.dipendenti.size();
	}
	
	abstract public Map<String, List<Societa>> nazione2consorziate();
}
