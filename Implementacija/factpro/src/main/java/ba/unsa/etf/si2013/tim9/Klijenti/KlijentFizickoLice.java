package ba.unsa.etf.si2013.tim9.Klijenti;

import java.io.Serializable;

public class KlijentFizickoLice extends Klijenti implements Serializable{
	
	String ime, prezime;
	
	public KlijentFizickoLice (){}
	public KlijentFizickoLice (String ime, String prezime, String adresa, String telefon, String mail){
		super(adresa, telefon, mail);
		this.ime=ime;
		this.prezime=prezime;
	}

	
	public String getIme(){
		return this.ime;
	}
	
	public void setIme (String ime){
		this.ime=ime;
	}
	
	public String getPrezime(){
		return this.prezime;
	}
	
	public void setPrezime(String prezime){
		this.prezime=prezime;
	}
}
