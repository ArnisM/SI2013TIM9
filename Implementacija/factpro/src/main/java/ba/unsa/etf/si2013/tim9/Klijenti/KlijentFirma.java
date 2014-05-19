package ba.unsa.etf.si2013.tim9.Klijenti;

import java.io.Serializable;


public class KlijentFirma extends Klijenti implements Serializable {
	
	long id;
	String naziv;
	
	public KlijentFirma(){}
	
	public KlijentFirma (long id, String naziv, String adresa, String telefon, String email){
		super (adresa, telefon, email);
		this.naziv=naziv;
	}
	
	public void setNaziv(String naziv){
		this.naziv=naziv;
	}
	
	public String getNaziv(){
		return this.naziv;
	}
}
