package ba.unsa.etf.si2013.tim9.Predracuni;

import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si2013.tim9.HibernateUtil;

import java.io.Serializable;
@Table (name = "stavka_predracun")

public class Stavka_predracun implements Serializable {

	long ID;
	long IDpredracun;
	long IDUsluga;
	
	
	public Stavka_predracun()
	{}
	
	public Stavka_predracun(long idf, long idu)
	{
		IDpredracun=idf;
		IDUsluga=idu;
	}
	
	public void spasiUBazu() {
		
	 	Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(this);
		t.commit();
		session.close();
	 	}
	
	public long getIDpredracun() {
		return IDpredracun;
	}
	public void setIDpredracun(long iDpredracun) {
		IDpredracun = iDpredracun;
	}
	public long getIDUsluga() {
		return IDUsluga;
	}
	public void setIDUsluga(long iDUsluga) {
		IDUsluga = iDUsluga;
	}
	
	
	
}
