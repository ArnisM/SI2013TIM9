package ba.unsa.etf.si2013.tim9.Ponude;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;






import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;






import ba.unsa.etf.si2013.tim9.HibernateUtil;
import ba.unsa.etf.si2013.tim9.Klijenti.Klijenti;
import ba.unsa.etf.si2013.tim9.Fakture.Faktura;

public class PonudeTest  extends TestCase {

	
	
	public void testPonudaImalll() {

		Ponuda _f =  new Ponuda();
		_f.setBroj_ponude(1111);
		
		assertEquals((Boolean)false,(Boolean) _f.daLiPostoji());
		
		}
	
public void testDodajPonudu() {
		
		
		Date d=new Date();
		
		Ponuda _f =  new Ponuda(1,2,1212,"lala","bebe","123","4123",13,"Sarajevo",d,"ludilo");
		
		
		_f.spasiUBazu();
		
		assertEquals((Boolean)true,(Boolean) _f.daLiPostoji());
	} 
	

public void testDajeistiBrojFaktura()
{
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction t = session.beginTransaction();

    List fakture = session.createQuery("from Ponuda").list();
    t.commit();
    session.close();
    
    Ponuda f=new Ponuda();
    List x=f.dajPonude();
    
    assertEquals( fakture.size(), x.size() );
    
    
}


public void testBriselDobro()
{
	Date d=new Date();
	Ponuda _f =  new Ponuda(1,1,1212,"laasasla","bebasase","1231","41123",166,"Sarajevo",d,"ludilo");
	
	_f.spasiUBazu();
	
	List _fakture;
	Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction t = session.beginTransaction();
	Query q = session.createQuery("from Ponuda where broj_ponude=:broj_ponude ");
    q.setString("broj_ponude", Integer.toString(166));
    
    _fakture=q.list();
    t.commit();
    session.close();
    Ponuda f=new Ponuda();
	f=(Ponuda)_fakture.get(0);
	
	_f.izbrisiIzBaze(f.getId());
	
	assertEquals((Boolean)true,(Boolean)_f.daLiJeIzbrisan());
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
		//fail("Not yet implemented");
	}
}
