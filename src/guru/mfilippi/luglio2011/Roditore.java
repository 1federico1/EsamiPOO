package guru.mfilippi.luglio2011;

public class Roditore extends Animale{
	private static int PESO_RODITORE = 2;
	private static double PROBABILITA_RIPRODUZIONE = 0.45;

	public Roditore(){
		this(PESO_RODITORE);
	}

	private Roditore(int peso){
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
		nuovaPosizione = parco.posizioneLiberaVicino(this.getPosizione());
		if (nuovaPosizione!=null){
			this.incrementaCibo(1);
			parco.muovi(this, nuovaPosizione);
		} else {
			this.incrementaCibo(-1);
		}
		this.invecchia();
	}
	
	@Override
	public void riproduci(Parco parco) {
		Double random = Math.random();
		Posizione posizioneFiglio = parco.posizioneLiberaVicino(this.getPosizione());

		if ((posizioneFiglio!= null) && (PROBABILITA_RIPRODUZIONE > random)) {
			Animale figlio = this.creaFiglio();
			parco.setAnimale(figlio, posizioneFiglio);
		}
	}
	
	@Override
	public Animale creaFiglio() {
		return new Roditore();
	}
}

