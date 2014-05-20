package ba.unsa.etf.si2013.tim9.Klijenti;

import java.io.Serializable;

import javax.persistence.GeneratedValue; 
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.util.Date;	

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@Entity 
@Table (name = "TB_Klijenti")
public class Klijenti implements Serializable {
	

	 @Id 
	 @GeneratedValue 
	 long id;
	 
	 String adresa,email;
	 String brojtelefona;
		
		public Klijenti(){} 
		public Klijenti(String adresa2, String telefon, String email2) {
			this.adresa=adresa2;
			this.brojtelefona=telefon;
			this.email=email2;
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

	
	
	
}
