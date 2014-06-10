package ba.unsa.etf.si2013.tim9.Klijenti;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ba.unsa.etf.si2013.tim9.HibernateUtil;

import com.ibm.icu.text.SimpleDateFormat;

public class KlijentiTest extends TestCase{
	
	
	
	/**
	 * @throws java.lang.Exception
	 */

	public void testDaLiPostojiKlijent() {

		Klijenti _klijent =  new Klijenti();
		_klijent.setNaziv("nekinaziv");
		assertEquals((Boolean)false,(Boolean) _klijent.daLiPostoji());
		}
	
	
	
	public void testDodajKlijenta() {
		Klijenti _klijent =  new Klijenti();
		//parsiranje datuma
		_klijent=new Klijenti(
				"Samra Mrso",
				"fizickoLice",
				"Adresa 23",
				132,
				4132,
				"061 111 111",
				"033 222 222",
				"mail@mail.mail"
				
				);
		_klijent.spasiUBazu();
		assertEquals((Boolean)true,(Boolean) _klijent.daLiPostoji());
	} 
	
	public List<Klijenti> testDajKlijente() {
		 List<Klijenti> _klijenti= new ArrayList<Klijenti>();

		 Session _session= HibernateUtil.getSessionFactory().openSession();
		 Transaction _t = _session.beginTransaction(); 

		 Criteria criteria = _session.createCriteria(Klijenti.class);
		 @SuppressWarnings("unchecked")
		 List<Klijenti> _klijentii = _session.createQuery("from Klijenti").list();
		 for(Klijenti osoba : _klijentii){

			 Klijenti _klijent= new Klijenti(
					    osoba.getNaziv(),
					    osoba.getTip(),
					 	osoba.getAdresa(),
					 	osoba.getPdv(),
						osoba.getPdvbroj(),
					 	osoba.getBrojtelefona(),
						osoba.getFax(),
						
						osoba.getEmail()
					 );
			
			 Klijenti _k =(Klijenti) criteria.add(Restrictions.eq("osobaId", osoba.getId())).uniqueResult();
			 if(_k!=null&&osoba.getDeleted()!=0){
				
				 _klijenti.add(_klijent);
			} 
		 }
		 _t.commit();
		 _session.close();

		 return _klijenti;
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}


	/**
	 * @throws java.lang.Exception
	 */


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
