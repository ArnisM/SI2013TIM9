package ba.unsa.etf.si2013.tim9.Predracuni;

import static org.junit.Assert.*;

import org.junit.Test;





import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ba.unsa.etf.si2013.tim9.HibernateUtil;
import ba.unsa.etf.si2013.tim9.Fakture.Faktura;
import ba.unsa.etf.si2013.tim9.Klijenti.Klijenti;


public class PredracunTest  extends TestCase {

	
	
	
	
	public void testPredracunImalll() {

		Predracun _f =  new Predracun();
		_f.setBroj_predracuna(1111);
		assertEquals((Boolean)false,(Boolean) _f.daLiPostoji());
		
		}
	
    public void testDodajPredracun() {
		
		
		Date d=new Date();
		
		Predracun _f =  new Predracun(1,2,1212,"lala","bebe","123","4123",13,"Sarajevo",d,"ludilo");
		
		
		_f.spasiUBazu();
		
		assertEquals((Boolean)true,(Boolean) _f.daLiPostoji());
	} 
	
    
    public void testDajeistiBrojPredracuna()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
 
        List fakture = session.createQuery("from Predracun").list();
        t.commit();
        session.close();
        
        Predracun f=new Predracun();
        List x=f.dajPredracune();
        
        assertEquals( fakture.size(), x.size() );
        
        
	}
    
    public void testBriselDobro()
	{
		Date d=new Date();
		Predracun _f =  new Predracun(1,1,1212,"laasasla","bebasase","1231","41123",166,"Sarajevo",d,"ludilo");
		
		_f.spasiUBazu();
		
		List _fakture;
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction t = session.beginTransaction();
		Query q = session.createQuery("from Predracun where broj_predracuna=:broj_predracuna ");
        q.setString("broj_predracuna", Integer.toString(166));
        
        _fakture=q.list();
        t.commit();
        session.close();
        Predracun f=new Predracun();
		f=(Predracun)_fakture.get(0);
		
		_f.izbrisiIzBaze(f.getId());
		
		assertEquals((Boolean)true,(Boolean)_f.daLiJeIzbrisan());
	}
    
    
    
    
    
    
    
    
	@Test
	public void test() {
		//fail("Not yet implemented");
	}

}
