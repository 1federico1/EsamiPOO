package guru.mfilippi.luglio2011;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Simulatore {

	private static final int PASSI = Integer.MAX_VALUE;
	private static final int DIMENSIONE = 100;

	private Parco parco;
	private Visualizzatore visualizzatore;

	public Simulatore(){
		this.parco = new Parco(DIMENSIONE);
		this.parco.popolaTerritorio();
		this.visualizzatore = new Visualizzatore(DIMENSIONE);
	}

	public void run(){
		for(int i=0;i<PASSI; i++) {
			List<Animale> animali = new ArrayList<Animale>(this.parco.getAnimale());
			Collections.shuffle(animali);
			for(Animale s : animali) {
				s.agisci(parco);
			}
			this.visualizzatore.aggiornaSchermata(i, this.parco);
		}
	}

	public static void main(String[] args) {
		Simulatore s = new Simulatore();
		s.run();
	}
}
