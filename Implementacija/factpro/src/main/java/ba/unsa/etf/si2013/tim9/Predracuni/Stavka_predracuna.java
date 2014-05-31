package ba.unsa.etf.si2013.tim9.Predracuni;

import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si2013.tim9.HibernateUtil;

import java.io.Serializable;
@Table (name = "stavka_predracuna")

public class Stavka_predracuna implements Serializable {

	long ID;
	

	long IDpredracun;
	
	
	long IDUsluga;
	
	
	public Stavka_predracuna()
	{}
	
	public Stavka_predracuna(long idf, long idu)
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
	
	
	public long getIDUsluga() {
		return IDUsluga;
	}
	public void setIDUsluga(long iDUsluga) {
		IDUsluga = iDUsluga;
	}
	public long getIDpredracun() {
		return IDpredracun;
	}

	public void setIDpredracun(long iDPredracun) {
		IDpredracun = iDPredracun;
	}
	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}
	
	
	
}

