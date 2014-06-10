package guru.mfilippi.luglio2008;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ConsorzioTest {
	private Consorzio consorzio;
	
	private Impresa apple;
	private Impresa google;
	private Impresa ovh;
	
	@Before
	public void setUp() throws Exception {
		this.consorzio = new Consorzio(2000, "USA", "IT");
		this.apple = new Impresa(1980, "USA", "Apple");
		this.google = new Impresa(1960, "USA", "Google");
		this.ovh = new Impresa(2000, "FR", "OVH");
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
