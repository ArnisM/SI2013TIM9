package ba.unsa.etf.si2013.tim9.Klijenti;

import java.io.Serializable;

import javax.persistence.GeneratedValue; 
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.util.Date;	
import java.util.List;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.hql.internal.ast.util.SessionFactoryHelper;

import ba.unsa.etf.si2013.tim9.HibernateUtil;

@Entity 
@Table (name = "Klijenti")
public class Klijenti implements Serializable {
	

	 @Id 
	 @GeneratedValue
	 long id;
	 private int deleted=0;
	 private String naziv;

	private String adresa;

	private String email;
	private int pdv, pdvbroj;

	private String tip;
	 private String brojtelefona, fax;
		
		public Klijenti(){} 
		public Klijenti(String naziv, String tip, String adresa2, int pdv, int pdvbroj, String brojtelefona, String fax, String email) {
			this.setTip(tip);
			this.setNaziv(naziv);
			this.setAdresa(adresa2);
			this.setBrojtelefona(brojtelefona);
			this.setEmail(email);
			this.setPdv(pdv);
			this.setPdvbroj(pdvbroj);
			this.setFax(fax);			
			
		// TODO Auto-generated constructor stub
	}
		public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBrojtelefona() {
		return brojtelefona;
	}
	public void setBrojtelefona(String brojtelefona) {
		this.brojtelefona = brojtelefona;
	}
	String getTip() {
		return tip;
	}
	void setTip(String tip) {
		this.tip = tip;
	}
	String getNaziv() {
		return naziv;
	}
	void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public void spasiUBazu() {
		 	Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			session.save(this);
			t.commit();
			session.close();
		 	}
	
	private static List dajKlijente() { 
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
 
        List klijenti = session.createQuery("from Klijenti").list();
        t.commit();
        session.close();
        return klijenti;
		 }
	
	public void izbrisiIzBaze(){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(this);
		t.commit();
		session.close();
	}
	
	public int getPdv() {
		return pdv;
	}
	public void setPdv(int pdv) {
		this.pdv = pdv;
	}
	public int getPdvbroj() {
		return pdvbroj;
	}
	public void setPdvbroj(int pdvbroj) {
		this.pdvbroj = pdvbroj;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	
	
}
