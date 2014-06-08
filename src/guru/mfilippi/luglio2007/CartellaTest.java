package guru.mfilippi.luglio2007;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class CartellaTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testProprietario2risorsa_Vuoto() {
		Cartella vuota = new Cartella("prova", "luigi");
		Map<String, Set<Risorsa>> mappa = new HashMap<>();
		Set<Risorsa> set = new HashSet<>();
		set.add(vuota);
		mappa.put("luigi", set);
		assertEquals("la mappa non è vuota", mappa , vuota.proprietario2risorsa());
	}
	
	
	@Test
	public void testProprietario2risorse_Normale(){
		Cartella documenti = new Cartella("documenti", "admin");
		Cartella musica = new Cartella("musica","admin");
		Cartella studio = new Cartella("studio", "paolo");
		Cartella POO = new Cartella("POO", "valter");
		
		File time = new File("time.mp3",100, "paolo");
		File money = new File("money.mp3",150,"admin");
		File diadia = new File("diadia.jar", 50, "paolo");
		File pianostudi = new File("pianostudi.doc", 20, "valter");
		File esami = new File("esami.xsl", 80, "paolo");
		File temp = new File("temp.txt", 20, "valter");
		
		documenti.addRisorsa(musica);
		documenti.addRisorsa(studio);
		documenti.addRisorsa(temp);
		
		musica.addRisorsa(time);
		musica.addRisorsa(money);
		
		studio.addRisorsa(POO);
		studio.addRisorsa(pianostudi);
		studio.addRisorsa(esami);
		
		POO.addRisorsa(diadia);
		
		Set<Risorsa> adminSet = new HashSet<>();
		Set<Risorsa> paoloSet = new HashSet<>();
		Set<Risorsa> valterSet = new HashSet<>();
		
		adminSet.add(documenti);
		adminSet.add(musica);
		adminSet.add(money);
		
		paoloSet.add(time);
		paoloSet.add(studio);
		paoloSet.add(diadia);
		paoloSet.add(esami);
		
		valterSet.add(POO);
		valterSet.add(pianostudi);
		valterSet.add(temp);
		
		Map<String, Set<Risorsa>>  mappa = new HashMap<>();
		mappa.put("admin", adminSet);
		mappa.put("paolo", paoloSet);
		mappa.put("valter", valterSet);
		
		assertEquals(mappa.toString(), mappa, documenti.proprietario2risorsa());
	}
}
