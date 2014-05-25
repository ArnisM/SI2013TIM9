package ba.unsa.etf.si2013.tim9.Usluge;
import java.io.Serializable;

public class Usluga implements Serializable {
	long id;
	String  naziv;
	int cijena, ukupanTrosak;
	
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

}
