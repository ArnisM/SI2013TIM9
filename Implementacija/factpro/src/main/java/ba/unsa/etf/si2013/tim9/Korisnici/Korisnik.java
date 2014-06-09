package ba.unsa.etf.si2013.tim9.Korisnici;

import java.io.Serializable;



import java.util.Date;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si2013.tim9.HibernateUtil;

public class Korisnik implements Serializable {

	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;
	long id;
	private int deleted=0;
	String  Adresa,
			Telefon,
			Pozicija,
			Ime,
			Prezime;
	private String Username;
	private String Password;
	Date DatumZaposlenja;
	
	public Korisnik(){}
	
	public Korisnik(String ime, String prezime, String pozicija, String telefon, String adresa, String username, String password, Date datumzaposlenja){
		this.Ime=ime;
		this.Prezime=prezime;
		this.Pozicija=pozicija;
		this.Telefon=telefon;
		this.Adresa=adresa;
		this.setUsername(username);
		this.setPassword(password);
		this.DatumZaposlenja=datumzaposlenja;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAdresa() {
		return Adresa;
	}
	public void setAdresa(String adresa) {
		Adresa = adresa;
	}
	public String getTelefon() {
		return Telefon;
	}
	public void setTelefon(String telefon) {
		Telefon = telefon;
	}
	public String getPozicija() {
		return Pozicija;
	}
	public void setPozicija(String pozicija) {
		Pozicija = pozicija;
	}
	public String getIme() {
		return Ime;
	}
	public void setIme(String ime) {
		Ime = ime;
	}
	public String getPrezime() {
		return Prezime;
	}
	public void setPrezime(String prezime) {
		Prezime = prezime;
	}
	public Date getDatumZaposlenja() {
		return DatumZaposlenja;
	}
	public void setDatumZaposlenja(Date datumZaposlenja) {
		DatumZaposlenja = datumZaposlenja;
	}
	boolean daLiPostoji(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		 
		Query q = session.createQuery("from Korisnik where username=:ime and deleted=:deleted");
		 q.setString("ime", this.getUsername());
		
		 q.setInteger("deleted", 0);
		 List<Korisnik> c = q.list();
		 t.commit();
		 
		 if (c.size()>0) {
			 Shell shell1 = new Shell();
			 MessageDialog.openInformation(shell1, "Doodavanje korisnika", "Korisnik već postoji u bazi.");
			 return true;
		 }
		 return false;
	}
	public void spasiUBazu() {
		try{
	 	Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		 
		
		if(!daLiPostoji()){
		session.save(this);
		t.commit();
		session.close();
		Shell shell1 = new Shell();
		MessageDialog.openInformation(shell1, "Doodavanje korisnika", "Korisnik je uspješno dodan.");
		}
		 } catch(Exception e){}
	 	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public void daliPostoji() {
		
	
		
	}
}
