package ba.unsa.etf.si2013.tim9.Fakture;

import java.io.Serializable;
import java.util.Date;






import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.util.Date;	
import java.util.List;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.hql.internal.ast.util.SessionFactoryHelper;

import ba.unsa.etf.si2013.tim9.HibernateUtil;
import ba.unsa.etf.si2013.tim9.Klijenti.Klijenti;

//blabla
@Table (name = "faktura")
public class Faktura implements Serializable {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;

	long idzaposlenik;
	long idklijent;
	double cijena;
	int broj_usluga;
	private String naziv_firme;
	private String adresa_firme;
	private String id_firme;
	private String idpdv_firme;
	private int broj_fakture;
	private String mjesto_izdavanja;
	private Date datum_izdavanja;
	private String komentar;
	private int deleted;
	
	
	public Faktura() {}
	public Faktura(int idz, long idk, double cij, String n, String adr, String id, String idpdv , int broj, String mjesto, Date datum, String kom)
	{
		idzaposlenik=idz;
		idklijent=idk;
		cijena=cij;
		naziv_firme=n;
		adresa_firme=adr;
		id_firme=id;
		idpdv_firme=idpdv;
		broj_fakture=broj;
		mjesto_izdavanja=mjesto;
		datum_izdavanja=datum;
		komentar=kom;
		deleted=0;
		
	}
	
	
	
	
	
	boolean daLiPostoji(){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		 
		Query q = session.createQuery("from Faktura where broj_fakture=:naziv and deleted=:deleted");
		 q.setString("naziv", Integer.toString(this.getBroj_fakture()));
		
		 q.setInteger("deleted", 0);
		 List<Faktura> c = q.list();
		 t.commit();
		 
		 if (c.size()>0) {
			 
			 return true;
		 }
		 
		 return false;
	}
	
	boolean daLiJeIzbrisan()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		 
		Query q = session.createQuery("from Faktura where broj_fakture=:naziv ");
		 q.setString("naziv", Integer.toString(this.getBroj_fakture()));
		
		 
		 List<Faktura> c = q.list();
		 t.commit();
		 
		 Faktura f=new Faktura();
		 f=(Faktura)c.get(0);
		 
		 if(f.getDeleted()==1){
			 return true; 
		 }
		 return false;
		 
		 
	}
	
	public void spasiUBazu() {
	 	Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(this);
		t.commit();
		session.close();
	 	}
	
	public  List dajFakture() { 
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
 
        List fakture = session.createQuery("from Faktura").list();
        t.commit();
        session.close();
        return fakture;
        
		 }
	
	public void izbrisiIzBaze( long id)
	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		Faktura myObject = (Faktura) session.load(Faktura.class,(id));
		myObject.setDeleted(1);
		 session.update(myObject);
	    session.getTransaction().commit();
	    
	}
	
	
	
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdzaposlenik() {
		return idzaposlenik;
	}
	public void setIdzaposlenik(long idzaposlenika) {
		this.idzaposlenik = idzaposlenika;
	}
	public long getIdklijent() {
		return idklijent;
	}
	public void setIdklijent(long idklijent) {
		this.idklijent = idklijent;
	}
	public double getCijena() {
		return cijena;
	}
	public void setCijena(double cijena) {
		this.cijena = cijena;
	}
	public int getBroj_usluga() {
		return broj_usluga;
	}
	public void setBroj_usluga(int broj_usluga) {
		this.broj_usluga = broj_usluga;
	}
	public String getNaziv_firme() {
		return naziv_firme;
	}
	public void setNaziv_firme(String naziv_firme) {
		this.naziv_firme = naziv_firme;
	}
	public String getAdresa_firme() {
		return adresa_firme;
	}
	public void setAdresa_firme(String adresa_firme) {
		this.adresa_firme = adresa_firme;
	}
	public String getId_firme() {
		return id_firme;
	}
	public void setId_firme(String id_firme) {
		this.id_firme = id_firme;
	}
	public String getIdpdv_firme() {
		return idpdv_firme;
	}
	public void setIdpdv_firme(String idpdv_firme) {
		this.idpdv_firme = idpdv_firme;
	}
	public int getBroj_fakture() {
		return broj_fakture;
	}
	public void setBroj_fakture(int broj_fakture) {
		this.broj_fakture = broj_fakture;
	}
	public String getMjesto_izdavanja() {
		return mjesto_izdavanja;
	}
	public void setMjesto_izdavanja(String mjesto_izdavanja) {
		this.mjesto_izdavanja = mjesto_izdavanja;
	}
	public Date getDatum_izdavanja() {
		return datum_izdavanja;
	}
	public void setDatum_izdavanja(Date datum_izdavanja) {
		this.datum_izdavanja = datum_izdavanja;
	}
	public String getKomentar() {
		return komentar;
	}
	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}
	
	
}
