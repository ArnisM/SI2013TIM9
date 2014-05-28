package ba.unsa.etf.si2013.tim9.Izvjestaji;

import java.io.Serializable;

import javax.persistence.GeneratedValue; 
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.util.Date;	

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;


@Entity 
@Table (name = "Izvjestaj")
public class Izvjestaj implements Serializable {
	

	 @Id 
	 @GeneratedValue 
	 long id;
	 // private Zaposlenik zaposlenik; // ovdje treba dodati korisnika
	 
	 String tip;
	 private Date datum_izvjestaja;
	 private String korisnik; // ovo je malo nasilu ************
		
		public Izvjestaj(){} 
		public Izvjestaj(String tip, Date datum) {
			this.tip=tip;
			this.setKorisnik("edin"); // ovo takodjer
			this.setDatum_izvjestaja(datum);
		// TODO Auto-generated constructor stub
	}
		public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(String korisnik) {
		this.korisnik = korisnik;
	}
	public Date getDatum_izvjestaja() {
		return datum_izvjestaja;
	}
	public void setDatum_izvjestaja(Date datum_izvjestaja) {
		this.datum_izvjestaja = datum_izvjestaja;
	}
		
	
	
}
