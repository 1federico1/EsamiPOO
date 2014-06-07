package guru.mfilippi.luglio2012;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class UtilityTeste {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testUtente2docs_Nullo() {
		assertNull("La mappa restituita dovrebbe essere nulla", Utility.utente2docs(null, "prova"));
		assertNull("La mappa restituita dovrebbe essere nulla", Utility.utente2docs(null, null));
		assertNull("La mappa restituita dovrebbe essere nulla", Utility.utente2docs(new ArrayList<Documento>(), null));
	}
	
	@Test
	public void testUtente2docs_Vuoto() {
		assertEquals("La mappa restituita dovrebbe essere nulla", new HashMap<Utente, List<Documento>>(), Utility.utente2docs(new ArrayList<Documento>(), "prova"));
	}

	@Test
	public void testUtente2docs_Normale() {
		Utente matteo = new Utente("Matteo");
		Utente giulia = new Utente("Giulia");
		Utente luigi = new Utente("Luigi");
		Utente carlo = new Utente("Carlo");
		
		PermessoAccesso lettura = new PermessoAccesso("Lettura");
		lettura.addUtente(matteo);
		lettura.addUtente(giulia);
		
		PermessoAccesso modifica = new PermessoAccesso("Modifica");
		modifica.addUtente(luigi);
		modifica.addUtente(carlo);
		
		PermessoAccesso rimozione = new PermessoAccesso("Rimozione");
		rimozione.addUtente(giulia);
		rimozione.addUtente(carlo);
		
		PermessoAccesso creazione = new PermessoAccesso("Creazione");
		creazione.addUtente(matteo);
		creazione.addUtente(luigi);
		
		Documento doc1 = new Documento("Documento N1", 3, "08/09/2013", lettura);
		doc1.addPermessoAccesso(modifica);
		
		Documento doc2 = new Documento("Documento n2", 4, "14/12/2012", modifica);
		doc2.addPermessoAccesso(creazione);
		
		Documento doc3 = new Documento("Documento N3", 5, "20/01/2011", rimozione);
		doc3.addPermessoAccesso(modifica);
		
		List<Documento> listaDocumenti = new ArrayList<Documento>();
		listaDocumenti.add(doc1);
		listaDocumenti.add(doc2);
		listaDocumenti.add(doc3);
		
		Map<Utente, List<Documento>> prova1 = new HashMap<>();
		List<Documento> listaDocumentiModifica = new ArrayList<>();
		listaDocumentiModifica.add(doc1);
		listaDocumentiModifica.add(doc2);
		listaDocumentiModifica.add(doc3);
		prova1.put(luigi, listaDocumentiModifica);
		prova1.put(carlo, listaDocumentiModifica);
		assertEquals(prova1.toString(), prova1, Utility.utente2docs(listaDocumenti, "Modifica"));
		
		Map<Utente, List<Documento>> prova2 = new HashMap<>();
		List<Documento> listaDocumentiLettura = new ArrayList<>();
		listaDocumentiLettura.add(doc1);
		prova2.put(matteo, listaDocumentiLettura);
		prova2.put(giulia, listaDocumentiLettura);
		assertEquals(prova2.toString(), prova2, Utility.utente2docs(listaDocumenti, "Lettura"));
		
		Map<Utente, List<Documento>> prova3 = new HashMap<>();
		assertEquals(prova3.toString(), prova3, Utility.utente2docs(listaDocumenti, "Distruzione"));
		
		Map<Utente, List<Documento>> prova4 = new HashMap<>();
		List<Documento> listaDocumentiCreazione = new ArrayList<>();
		listaDocumentiCreazione.add(doc2);
		prova4.put(matteo, listaDocumentiCreazione);
		prova4.put(luigi, listaDocumentiCreazione);
		assertEquals(prova4.toString(), prova4, Utility.utente2docs(listaDocumenti, "Creazione"));
		
		Map<Utente, List<Documento>> prova5 = new HashMap<>();
		List<Documento> listaDocumentiRimozione = new ArrayList<>();
		listaDocumentiRimozione.add(doc3);
		prova5.put(giulia, listaDocumentiRimozione);
		prova5.put(carlo, listaDocumentiRimozione);
		assertEquals(prova5.toString(), prova5, Utility.utente2docs(listaDocumenti, "Rimozione"));
	}
}
