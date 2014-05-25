package ba.unsa.etf.si2013.tim9.Korisnici;

import java.io.Serializable;

<<<<<<< Upstream, based on origin/master
import org.eclipse.swt.widgets.DateTime;

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
			Prezime;
	DateTime DatumZaposlenja;
	
	public Korisnik(){}
	
	public Korisnik(String _adresa, String _telefon){}
	
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
	public DateTime getDatumZaposlenja() {
		return DatumZaposlenja;
	}
	public void setDatumZaposlenja(DateTime datumZaposlenja) {
		DatumZaposlenja = datumZaposlenja;
	}
	
=======
public class Korisnik implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

>>>>>>> 6410d7d Korisnik klasa
}
