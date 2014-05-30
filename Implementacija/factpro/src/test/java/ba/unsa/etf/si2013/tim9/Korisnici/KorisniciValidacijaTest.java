package ba.unsa.etf.si2013.tim9.Korisnici;

import static org.junit.Assert.*;

import org.junit.Test;

public class KorisniciValidacijaTest {


	@Test
	public void testValidacijaAdresaUneseno() {
		KorisniciValidacija k = new KorisniciValidacija();
		assertEquals(k.ValidacijaAdresaUneseno("a") , true );
	}

	@Test
	public void testValidacijaTelefonUneseno() {
		KorisniciValidacija k = new KorisniciValidacija();
		assertEquals(k.ValidacijaTelefonUneseno("ab") , true );
	}
	
	@Test
	public void testValidacijaTelefonUnesenoTest2() {
		KorisniciValidacija k = new KorisniciValidacija();
		assertEquals(k.ValidacijaTelefonUneseno("123123444") , false );
	}

	@Test
	public void testValidacijaTelefonFormatDobar() {
		KorisniciValidacija k = new KorisniciValidacija();
		assertEquals(k.ValidacijaTelefonFormatDobar("1231232") , true );
	}
	
	@Test
	public void testValidacijaTelefonFormatDobarTest2() {
		KorisniciValidacija k = new KorisniciValidacija();
		assertEquals(k.ValidacijaTelefonFormatDobar("123-sas-453") , true );
	}

	@Test
	public void testValidacijaEmailUnesen() {
		KorisniciValidacija k = new KorisniciValidacija();
		assertEquals(k.ValidacijaEmailUnesen("") , true );
	}

	@Test
	public void testValidacijaEmailFormatDobar() {
		KorisniciValidacija k = new KorisniciValidacija();
		assertEquals(k.ValidacijaEmailFormatDobar("sad@sad") , true );
	}
	
	@Test
	public void testValidacijaEmailFormatDobarTest2() {
		KorisniciValidacija k = new KorisniciValidacija();
		assertEquals(k.ValidacijaEmailFormatDobar("sad@hotmail.com") , false );
	}
	
	@Test
	public void testValidacijaEmailFormatDobarTest3() {
		KorisniciValidacija k = new KorisniciValidacija();
		assertEquals(k.ValidacijaEmailFormatDobar("sad@hotmail") , true );
	}

	@Test
	public void testValidacijaImeUneseno() {
		KorisniciValidacija k = new KorisniciValidacija();
		assertEquals(k.ValidacijaImeUneseno("sa") , true );
	}

	@Test
	public void testValidacijaImeFormatDobar() {
		KorisniciValidacija k = new KorisniciValidacija();
		assertEquals(k.ValidacijaImeFormatDobar("sasada") , true );
	}
	
	@Test
	public void testValidacijaImeFormatDobarTest2() {
		KorisniciValidacija k = new KorisniciValidacija();
		assertEquals(k.ValidacijaImeFormatDobar("Sasas32") , true );
	}
	
	@Test
	public void testValidacijaImeFormatDobarTest3() {
		KorisniciValidacija k = new KorisniciValidacija();
		assertEquals(k.ValidacijaImeFormatDobar("Sasas.") , true );
	}

	@Test
	public void testValidacijaPrezimeUneseno() {
		KorisniciValidacija k = new KorisniciValidacija();
		assertEquals(k.ValidacijaPrezimeUneseno("sa") , true );
	}

	@Test
	public void testValidacijaPrezimeFormatDobar() {
		KorisniciValidacija k = new KorisniciValidacija();
		assertEquals(k.ValidacijaPrezimeFormatDobar("Sasas.") , true );
	}
	
	@Test
	public void testValidacijaPrezimeFormatDobarTest2() {
		KorisniciValidacija k = new KorisniciValidacija();
		assertEquals(k.ValidacijaPrezimeFormatDobar("Sasas-3ads") , true );
	}
	
	@Test
	public void testValidacijaPrezimeFormatDobarTest3() {
		KorisniciValidacija k = new KorisniciValidacija();
		assertEquals(k.ValidacijaPrezimeFormatDobar("Sasas-Lds") , false );
	}

	@Test
	public void testValidacijaPasswordUnesen() {
		KorisniciValidacija k = new KorisniciValidacija();
		assertEquals(k.ValidacijaPasswordUnesen("Sasas-Lds") , true );
	}
	
	@Test
	public void testValidacijaPasswordUnesenTest2() {
		KorisniciValidacija k = new KorisniciValidacija();
		assertEquals(k.ValidacijaPasswordUnesen("") , false );
	}


	@Test
	public void testValidacijaPasswordPotvrdaUnesen() {
		KorisniciValidacija k = new KorisniciValidacija();
		assertEquals(k.ValidacijaPasswordPotvrdaUnesen("") , false );
	}

	@Test
	public void testValidacijaPasswordPotvrda() {
		KorisniciValidacija k = new KorisniciValidacija();
		assertEquals(k.ValidacijaPasswordPotvrda("sifra1","sifra") , false );
	}
	
	@Test
	public void testValidacijaPasswordPotvrdaTest2() {
		KorisniciValidacija k = new KorisniciValidacija();
		assertEquals(k.ValidacijaPasswordPotvrda("sifranova","sifranova") , true );
	}

}
