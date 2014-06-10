/**
 * 
 */
package ba.unsa.etf.si2013.tim9.Korisnici;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ba.unsa.etf.si2013.tim9.Klijenti.Klijenti;

/**
 * @author Work
 *
 */
public class KorisnikTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	public void testDaLiPostojiKorisnik() {

		Korisnik _klijent =  new Korisnik();
		_klijent.setUsername("nekinaziv");
		
		assertEquals((Boolean)false,(Boolean) _klijent.daLiPostoji());
		}
	
	public void testDodajKorisnika() {
		Korisnik _k =  new Korisnik();
		//parsiranje datuma
		_k=new Korisnik(
				"Samra",
				"Mrso",
				"sef",
				"061 111 111",
				"Adresa 23",
				"username",
				"password",
				null
				
				);
		_k.spasiUBazu();
		assertEquals((Boolean)true,(Boolean) _k.daLiPostoji());
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
