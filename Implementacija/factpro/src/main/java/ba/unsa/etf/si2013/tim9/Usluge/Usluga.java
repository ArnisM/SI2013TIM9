package ba.unsa.etf.si2013.tim9.Usluge;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si2013.tim9.HibernateUtil;

@Entity 
@Table (name = "Usluga")

public class Usluga implements Serializable {
	

	long id;
	String  naziv, opisUsluge;
	int cijena, ukupanTrosak;
	private int deleted=0;
    String tipUsluge;
	
	public Usluga () {}
	
	public Usluga(String naziv, String tipUsluge, int cijena, int ukupanTrosak,
			 String opisUsluge) {
		super();
		this.naziv = naziv;
		this.cijena = cijena;
		this.ukupanTrosak = ukupanTrosak;
		this.tipUsluge = tipUsluge;
		this.opisUsluge = opisUsluge;
	}
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getCijena() {
		return cijena;
	}

	public void setCijena(int cijena) {
		this.cijena = cijena;
	}

	public int getUkupanTrosak() {
		return ukupanTrosak;
	}

	public void setUkupanTrosak(int ukupanTrosak) {
		this.ukupanTrosak = ukupanTrosak;
	}


	public String getOpisUsluge() {
		return opisUsluge;
	}

	public void setOpisUsluge(String opisUsluge) {
		this.opisUsluge = opisUsluge;
	}
	
	public String getTipUsluge() {
		return tipUsluge;
	}

	public void setTipUsluge(String tipUsluge) {
		this.tipUsluge = tipUsluge;
	}
	
	public void spasiUBazu() {
	 	Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(this);
		t.commit();
		session.close();
	 	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	

}
