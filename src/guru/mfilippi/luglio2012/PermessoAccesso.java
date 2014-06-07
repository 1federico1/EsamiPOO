package guru.mfilippi.luglio2012;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PermessoAccesso {
	private String nomePermesso;
	private Set<Utente> utenti;
	
	public PermessoAccesso(String nomePermesso) {
		this.nomePermesso = nomePermesso;
		this.utenti = new HashSet<Utente>();
	}
	
	public String getNome(){
		return this.nomePermesso;
	}

	public boolean addUtente(Utente utente) {
		return this.utenti.add(utente);
	}
	
	public boolean haPermesso(Utente utente) {
		return this.utenti.contains(utente);
	}
	
	public Set<Utente> getUtenti(){
		return Collections.unmodifiableSet(this.utenti);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nomePermesso == null) ? 0 : nomePermesso.hashCode());
		result = prime * result + ((utenti == null) ? 0 : utenti.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PermessoAccesso other = (PermessoAccesso) obj;
		if (nomePermesso == null) {
			if (other.nomePermesso != null)
				return false;
		} else if (!nomePermesso.equals(other.nomePermesso))
			return false;
		if (utenti == null) {
			if (other.utenti != null)
				return false;
		} else if (!utenti.equals(other.utenti))
			return false;
		return true;
	}
	
	
}