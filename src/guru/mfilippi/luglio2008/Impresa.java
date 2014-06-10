package guru.mfilippi.luglio2008;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Impresa extends Societa implements Comparable<Impresa> {

	public Impresa(int annoDiCostituzione, String nazione, String nome) {
		super(annoDiCostituzione, nazione, nome);
	}

	@Override
	public Map<String, List<Societa>> nazione2consorziate() {
		Map<String, List<Societa>> mappa = new HashMap<>();
		List<Societa> lista = new ArrayList<>();
		lista.add(this);
		mappa.put(this.getNazione(), lista);
		return mappa;
	}
}
