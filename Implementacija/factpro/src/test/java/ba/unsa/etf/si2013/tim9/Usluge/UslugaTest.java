package ba.unsa.etf.si2013.tim9.Usluge;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ba.unsa.etf.si2013.tim9.Klijenti.Klijenti;

public class UslugaTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	public void testDodajUslugu() {
		Usluga _klijent =  new Usluga();
		//parsiranje datuma
		_klijent=new Usluga(
				"nekausluga",
				"servis",
				12.12,
				12.12,
				"opis usluge"
				
				);
		_klijent.spasiUBazu();
		assertEquals((Boolean)true,(Boolean) _klijent.daLiPostoji());
	} 
	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
	}
}
