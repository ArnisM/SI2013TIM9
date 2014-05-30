package ba.unsa.etf.si2013.tim9.Korisnici;

import java.io.Serializable;



import java.util.Date;

import org.eclipse.swt.widgets.DateTime;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si2013.tim9.HibernateUtil;

public class Korisnik implements Serializable {

	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;
	long id;
	String  Adresa,
			Telefon,
			Pozicija,
			Ime,
			Prezime,
			Username,
			Password;
	Date DatumZaposlenja;
	
	public Korisnik(){}
	
	public Korisnik(String ime, String prezime, String pozicija, String telefon, String adresa, String username, String password, Date datumzaposlenja){
		this.Ime=ime;
		this.Prezime=prezime;
		this.Pozicija=pozicija;
		this.Telefon=telefon;
		this.Adresa=adresa;
		this.Username=username;
		this.Password=password;
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
	public void spasiUBazu() {
	 	Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(this);
		t.commit();
		session.close();
	 	}
}
