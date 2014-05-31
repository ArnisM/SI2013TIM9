package ba.unsa.etf.si2013.tim9.Fakture;

import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si2013.tim9.HibernateUtil;

import java.io.Serializable;
@Table (name = "stavka_faktura")

public class Stavka_faktura implements Serializable {

	long ID;
	long IDfaktura;
	long IDUsluga;
	
	
	public Stavka_faktura()
	{}
	
	public Stavka_faktura(long idf, long idu)
	{
		IDfaktura=idf;
		IDUsluga=idu;
	}
	
	public void spasiUBazu() {
		
	 	Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(this);
		t.commit();
		session.close();
	 	}
	
	public long getIDfaktura() {
		return IDfaktura;
	}
	public void setIDfaktura(long iDfaktura) {
		IDfaktura = iDfaktura;
	}
	public long getIDUsluga() {
		return IDUsluga;
	}
	public void setIDUsluga(long iDUsluga) {
		IDUsluga = iDUsluga;
	}
	
	
	
}
