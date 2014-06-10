package guru.mfilippi.febbraio2010;

import java.util.*;

public class Directory extends Risorsa{
	private Set<Risorsa> risorse;

	public Directory(String nome, Utente proprietario) {
		super(nome, proprietario);
		this.risorse = new HashSet<Risorsa>();
	}
	
	@Override
	public int getDimensioni() {
		int dimensioni = 0;
		for (Risorsa risorsa : this.risorse)
			dimensioni += risorsa.getDimensioni();
		return dimensioni;
	}
}
