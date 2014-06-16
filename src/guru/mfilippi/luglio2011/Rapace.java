package guru.mfilippi.luglio2011;

import java.util.List;

public class Rapace extends Animale{
	private static int PESO_RAPACE = 5;
	private static double PROBABILITA_RIPRODUZIONE = 0.45;

	public Rapace(){
		this(PESO_RAPACE);
	}

	private Rapace(int peso){
		super(peso, 2, 0);
	}

	@Override
	public void agisci(Parco parco) {
		if (this.isMorto()) {
			parco.eliminaAnimale(this);
			return;
		}
		this.riproduci(parco);

		Posizione nuovaPosizione;
		Animale roditore;
		roditore = trovaRoditore(parco);
		if (roditore != null) {
			this.incrementaCibo(1);
			parco.eliminaAnimale(roditore);
			nuovaPosizione = roditore.getPosizione();
		} else {
			Animale rapace;
			rapace = rapacePiuDebole(parco);
			if (rapace != null) {
				this.incrementaCibo(1);
				parco.eliminaAnimale(rapace);
				nuovaPosizione = rapace.getPosizione();
			} else {
					this.incrementaCibo(-1);
					nuovaPosizione = parco.posizioneLiberaVicino(this.getPosizione());
			}
		}
		if (nuovaPosizione!=null){
			parco.muovi(this, nuovaPosizione);
		}
		this.invecchia();
	}

	private Animale trovaRoditore(Parco parco) {
		List<Posizione> adiacenti = parco.adiacenti(this.getPosizione());
		for(Posizione p : adiacenti) {
			Animale r = parco.getAnimale(p);
			if ((r!=null) && (this.getPeso()>r.getPeso())) {
				return r;
			}
		}
		return null;
	}

	private Animale rapacePiuDebole(Parco parco) {
		List<Posizione> adiacenti = parco.adiacenti(this.getPosizione());
		for(Posizione p : adiacenti) {
			Animale s = parco.getAnimale(p);
			if ((s!=null) && (this.getPeso()>s.getPeso())) {
				return s;
			}
		}
		return null;
	}
	
	@Override
	public void riproduci(Parco parco) {
		Double random = Math.random();
		Posizione pos = parco.posizioneLiberaVicino(this.getPosizione());

		if ((pos!= null) && (PROBABILITA_RIPRODUZIONE > random)) {
			Animale figlio = this.creaFiglio();
			parco.setAnimale(figlio, pos);
		}
	}

	@Override
	public Animale creaFiglio() {
		return new Rapace();
	}
}

