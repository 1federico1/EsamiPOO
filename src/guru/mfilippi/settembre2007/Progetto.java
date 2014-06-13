package guru.mfilippi.settembre2007;

import java.util.*;

public class Progetto {
	private List<Attivita> elencoAttivita;
	private String nome;
	private String responsabile;

	public Progetto(String nome, String responsabile) {
		this.nome = nome;
		this.responsabile = responsabile;
		this.elencoAttivita = new ArrayList<Attivita>();
	}

	public void addAttivita(Attivita attivita) {
		this.elencoAttivita.add(attivita);
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

	public int getCosto() {
		int costo = 0;
		for (Attivita attivita : this.elencoAttivita)
			costo += attivita.getCosto();
		return costo;
	}

	public int hashCode() {
		return this.getNome().hashCode();
	}

	public boolean equals(Object obj) {
		Progetto progetto = (Progetto) obj;
		return this.getNome().equals(progetto.getNome());
	}

	public Map<String, List<Attivita>> responsabile2attivita() {
		Map<String, List<Attivita>> resp2attivita = new HashMap<String, List<Attivita>>();
		// codice omesso
		return resp2attivita;
	}
}