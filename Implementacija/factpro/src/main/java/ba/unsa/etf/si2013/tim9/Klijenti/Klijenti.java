package ba.unsa.etf.si2013.tim9.Klijenti;

import java.io.Serializable;
import java.util.Date;	

import javax.xml.bind.annotation.XmlRootElement;

public class Klijenti implements Serializable {
	
	String adresa, broj_telefona, email;
	
	public Klijenti(){}
	public Klijenti (String ad, String br_tel, String mail){
		this.adresa=ad;
		this.broj_telefona=br_tel;
		this.email=mail;
	}
	
	public String getAdresa(){
		return this.adresa;
	}
	
	public void setAdresa(String ad){
		this.adresa=ad;
	}
	
	public String getTelefon(){
		return this.broj_telefona;
	}
	
	public void setTelefon(String tel){
		this.broj_telefona=tel;
	}
	
	public void setEmail (String mail){
		this.email=mail;
	}
	
	public String getEmail (){
		return this.email;
	}
}
