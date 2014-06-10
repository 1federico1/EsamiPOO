package guru.mfilippi.febbraio2010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class Risorsa {
	private Utente proprietario;
	private String nome;
	private Map<Permesso, Set<Utente>> permessi;
	private List<Utente> possonoLeggere;
	private List<Utente> possonoModificare;

	public Risorsa(String nome, Utente proprietario) {
		this.nome = nome;
		this.proprietario = proprietario;
		this.permessi = new HashMap<>();
		this.possonoLeggere = new ArrayList<Utente>();
		this.possonoModificare = new ArrayList<Utente>();
	}

	public Utente getProprietario() {
		return this.proprietario;
	}

	public String getNome() {
		return this.nome;
	}
	
	public boolean haIlPermesso(Permesso permesso, Utente utente){
			return this.permessi.containsKey(permesso) && 
					this.permessi.get(permesso) !=null &&
					this.permessi.get(permesso).contains(utente);
	}
	
	public void concediPermesso(Permesso permesso, Utente utente){
		Set<Utente> permessi = this.permessi.get(permesso);
		if (permessi == null) permessi = new HashSet<Utente>();
		permessi.add(utente);
		this.permessi.put(permesso, permessi);
	}
	
	public List<Permesso> permessiDi(Utente	utente){
		List<Permesso> permessiUtente = new ArrayList<>();
		for(Entry<Permesso, Set<Utente>> lista : this.permessi.entrySet()){
			if (lista.getValue().contains(utente)) permessiUtente.add(lista.getKey());
		}
		return permessiUtente;
	}
	
	abstract public int getDimensioni();
		
}
