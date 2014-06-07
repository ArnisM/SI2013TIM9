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
	double cijena, ukupanTrosak;
	int deleted;
    String tipUsluge;
	
	public Usluga () {}
	
	public Usluga(String naziv, String tipUsluge, double cijena, double ukupanTrosak,
			 String opisUsluge) {
		super();
		this.naziv = naziv;
		this.cijena = cijena;
		this.ukupanTrosak = ukupanTrosak;
		this.tipUsluge = tipUsluge;
		this.opisUsluge = opisUsluge;
		this.deleted=0;
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

	public double getCijena() {
		return cijena;
	}

	public void setCijena(double cijena) {
		this.cijena = cijena;
	}

	public double getUkupanTrosak() {
		return ukupanTrosak;
	}

	public void setUkupanTrosak(double ukupanTrosak) {
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
