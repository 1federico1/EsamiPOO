package guru.mfilippi.luglio2012;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Documento extends Archivio {
	public Documento(String nome, int dimensione, String dataCreazione, PermessoAccesso permessoAccesso) {
		super(nome, dimensione, dataCreazione, permessoAccesso);
	}

	@Override
	public List<Archivio> archiviCreatiIl(String data) {
		if (super.getDataCreazione().equals(data)){
			List<Archivio> lista = new ArrayList<Archivio>();
			lista.add(this);
			return lista;
		}
		return null;
	}
		
	
	/*	
	public List<Archivio> archiviCreatiIl(String data) {
		// codice omesso: domanda 5. 
	}
	*/

}
