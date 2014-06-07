package guru.mfilippi.luglio2012;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public abstract class Archivio {

	protected String nome;
	protected int dimensione;
	protected String dataCreazione;
	protected Map<String, PermessoAccesso> permessi;

	public Archivio(String nome2, int dimensione2, String dataCreazione2, PermessoAccesso permessoAccesso) {
		this.nome = nome;
		this.dataCreazione = dataCreazione;
		this.permessi = new HashMap<String, PermessoAccesso>();
		this.permessi.put(permessoAccesso.getNome(), permessoAccesso);
	}

	public String getDataCreazione() {
		return this.dataCreazione;
	}

	public String getNome() {
		return this.nome;
	}

	public PermessoAccesso getPermessoAccesso(String nomePermesso) {
		return this.permessi.get(nomePermesso);
	}
	
	public void addPermessoAccesso(PermessoAccesso permesso){
		this.permessi.put(permesso.getNome(), permesso);
	}

	public int getDimensione() {
		return this.dimensione;
	}
	
	public abstract List<Archivio> archiviCreatiIl(String data);
}