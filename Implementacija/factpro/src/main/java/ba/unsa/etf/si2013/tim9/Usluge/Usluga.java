package ba.unsa.etf.si2013.tim9.Usluge;
import java.io.Serializable;

public class Usluga implements Serializable {
	

	long id;
	String  naziv, opisUsluge;
	int cijena, ukupanTrosak;
	
	public Usluga () {}
	
	public Usluga(String naziv, int cijena, int ukupanTrosak,
			Tip tipUsluge, String opisUsluge) {
		super();
		this.naziv = naziv;
		this.cijena = cijena;
		this.ukupanTrosak = ukupanTrosak;
		this.tipUsluge = tipUsluge;
		this.opisUsluge = opisUsluge;
	}
	
	public enum Tip {Servis, Konsultacije};
    Tip tipUsluge;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getCijena() {
		return cijena;
	}

	public void setCijena(int cijena) {
		this.cijena = cijena;
	}

	public int getUkupanTrosak() {
		return ukupanTrosak;
	}

	public void setUkupanTrosak(int ukupanTrosak) {
		this.ukupanTrosak = ukupanTrosak;
	}

	public Tip getTipUsluge() {
		return tipUsluge;
	}

	public void setTipUsluge(Tip tipUsluge) {
		this.tipUsluge = tipUsluge;
	}

	public String getOpisUsluge() {
		return opisUsluge;
	}

	public void setOpisUsluge(String opisUsluge) {
		this.opisUsluge = opisUsluge;
	}

}
