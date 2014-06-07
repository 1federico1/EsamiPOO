package guru.mfilippi.luglio2012;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utility {

	static public Map<Utente, List<Documento>> utente2docs(List<Documento> docs, String nomePermesso) {
		if (docs == null || nomePermesso == null) return null;
		
		Map<Utente, List<Documento>> mappa = new HashMap<>();
		for(Documento doc: docs){
			PermessoAccesso permessiUtente = doc.getPermessoAccesso(nomePermesso);
			if (permessiUtente != null){
				for(Utente utente: permessiUtente.getUtenti()){
					if (mappa.containsKey(utente)){
						mappa.get(utente).add(doc);
					}else{
						List<Documento> listDocumenti = new ArrayList<>();
						listDocumenti.add(doc);
						mappa.put(utente, listDocumenti);
					}
				}
			}
		}
		return mappa;
	}

}
