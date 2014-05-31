package ba.unsa.etf.si2013.tim9.Ponude;

import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si2013.tim9.HibernateUtil;

import java.io.Serializable;
@Table (name = "stavka_ponuda")

public class Stavka_ponuda implements Serializable {

	long ID;
	long IDPonuda;
	
	long IDUsluga;
	
	
	public Stavka_ponuda()
	{}
	
	public Stavka_ponuda(long idf, long idu)
	{
		IDPonuda=idf;
		IDUsluga=idu;
	}
	
	public void spasiUBazu() {
		
	 	Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(this);
		t.commit();
		session.close();
	 	}
	public long getIDPonuda() {
		return IDPonuda;
	}

	public void setIDPonuda(long iDPonuda) {
		IDPonuda = iDPonuda;
	}
	
	public long getIDUsluga() {
		return IDUsluga;
	}
	public void setIDUsluga(long iDUsluga) {
		IDUsluga = iDUsluga;
	}
	
	
	
}
