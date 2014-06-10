package ba.unsa.etf.si2013.tim9.Fakture;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ba.unsa.etf.si2013.tim9.HibernateUtil;
import ba.unsa.etf.si2013.tim9.Klijenti.Klijenti;

public class FaktureTest extends TestCase {
	
	
	
	
	
	public void testFakturaImalll() {

		Faktura _f =  new Faktura();
		_f.setBroj_fakture(1111);
		assertEquals((Boolean)false,(Boolean) _f.daLiPostoji());
		
		}
	
	public void testDodajKlijenta() {
		
		
		Date d=new Date();
		Faktura _f =  new Faktura(1,2,1212,"lala","bebe","123","4123",13,"Sarajevo",d,"ludilo");
		
		
		_f.spasiUBazu();
		assertEquals((Boolean)true,(Boolean) _f.daLiPostoji());
	} 
	
	
	public void testDajeistiBrojFaktura()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
 
        List fakture = session.createQuery("from Faktura").list();
        t.commit();
        session.close();
        
        Faktura f=new Faktura();
        List x=f.dajFakture();
        
        assertEquals( fakture.size(), x.size() );
        
        
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
	
	}
}
