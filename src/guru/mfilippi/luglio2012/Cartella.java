package guru.mfilippi.luglio2012;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Cartella extends Archivio{
	private Set<Archivio> elementi;
		
	public Cartella(String nome, String dataCreazione, PermessoAccesso permessoAccesso) {
		super(nome, 0, dataCreazione, permessoAccesso);
		this.elementi = new HashSet<Archivio>();
	}

	@Override
	public int getDimensione() {
		return this.elementi.size();
	}
	
	public boolean addArchivio(Archivio archivio) {
		return this.elementi.add(archivio);
	}
			
	public List<Archivio> archiviCreatiIl(String data) {
		List<Archivio> lista = new ArrayList<>();
		if (super.getDataCreazione().equals(data)) lista.addAll(this.elementi);
		for(Archivio elemento: this.elementi){
			if (elemento.getClass() == Cartella.class && elemento.getDataCreazione().equals(data)){
				lista.add(elemento);
			}
		}
		return lista;
	}
}
