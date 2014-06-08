package guru.mfilippi.luglio2007;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class File extends Risorsa{
	private int dimensione;

	public File(String nome, int dimensione, String proprietario) {
		super(nome, proprietario);
		this.dimensione = dimensione;
	}
	
	@Override
	public int getDimensione() {
		return this.dimensione;
	}

	public int hashCode() {
		return this.getNome().hashCode();
	}

	public boolean equals(Object obj) {
		File file = (File) obj;
		return this.getNome().equals(file.getNome());
	}

	@Override
	public Map<String, Set<Risorsa>> proprietario2risorsa() {
		Map<String, Set<Risorsa>> proprietario2risorsa = new HashMap<String, Set<Risorsa>>();
		Set<Risorsa> risorsa = new HashSet<>();
		risorsa.add(this);
		proprietario2risorsa.put(super.getProprietario(), risorsa);
		return	proprietario2risorsa;
	}
}
