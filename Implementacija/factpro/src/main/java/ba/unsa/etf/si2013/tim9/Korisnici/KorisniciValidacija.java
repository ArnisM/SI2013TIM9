package ba.unsa.etf.si2013.tim9.Korisnici;

public class KorisniciValidacija 
{
	public KorisniciValidacija(){}
	
	//adresa
	protected Boolean ValidacijaAdresaUneseno(String _adresa)
	{
		return (_adresa.length()<3 || _adresa=="");
	}
	
	//telefon
	protected Boolean ValidacijaTelefonUneseno(String _telefon)
	{
<<<<<<< HEAD
		return (_telefon.length()<3 || _telefon=="");
	}
	protected Boolean ValidacijaTelefonFormatDobar(String _telefon)
	{
		return (!_telefon.matches("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{3}$"));
	}
	
	//email
	protected Boolean ValidacijaEmailUnesen(String _email)
	{
		return (_email.length()<3 || _email=="");		
	}
	protected Boolean ValidacijaEmailFormatDobar(String _email)
	{
		return (!_email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"));		
	}
	
	//ime
	protected Boolean ValidacijaImeUneseno(String _ime)
	{
		return (_ime.length()<3 || _ime=="");//!text.getText().matches("[A-Z]([a-z]+|\\s[a-z]+)?")		
	}
	protected Boolean ValidacijaImeFormatDobar(String _ime)
	{
		return (!_ime.matches("[A-Z]([a-z]+|\\s[a-z]+)?"));		
	}
	
	//Prezime
	protected Boolean ValidacijaPrezimeUneseno(String _prezime)
	{
		return (_prezime.length()<3 || _prezime=="");
	}
	protected Boolean ValidacijaPrezimeFormatDobar(String _prezime)
	{
		return (!_prezime.matches("[a-zA-z]+([ '-][a-zA-Z]+)*"));	
	}
	
	//password
	protected Boolean ValidacijaPasswordUnesen(String _password)
	{
		return null;
	}
	protected Boolean ValidacijaPasswordFormatDobar(String _password)
	{
		return null;
	}
	
	//password ponovo unesen
	protected Boolean ValidacijaPasswordPotvrdaUnesen(String _password)
	{
		return null;
		
	}
	protected Boolean ValidacijaPasswordPotvrda(String _password)
	{
		return null;		
	}
	
	//datum
	protected Boolean ValidacijaDatumZaposlenja()
	{
		return null;
=======
		return (_telefon.length()<3 || _telefon=="")||(_telefon==null);
	}
	protected Boolean ValidacijaTelefonFormatDobar(String _telefon)
	{
		return (!_telefon.matches("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{3}$"));
	}
	
	//email
	protected Boolean ValidacijaEmailUnesen(String _email)
	{
		return (_email.length()<3 || _email=="")||(_email==null);		
	}
	protected Boolean ValidacijaEmailFormatDobar(String _email)
	{
		return (!_email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"));		
	}
	
	//ime
	protected Boolean ValidacijaImeUneseno(String _ime)
	{
		return (_ime.length()<3 || _ime=="")||(_ime==null);//!text.getText().matches("[A-Z]([a-z]+|\\s[a-z]+)?")		
	}
	protected Boolean ValidacijaImeFormatDobar(String _ime)
	{
		return (!_ime.matches("[A-Z]([a-z]+|\\s[a-z]+)?"));		
	}
	
	//Prezime
	protected Boolean ValidacijaPrezimeUneseno(String _prezime)
	{
		return (_prezime.length()<3 || _prezime=="")||(_prezime==null);
	}
	protected Boolean ValidacijaPrezimeFormatDobar(String _prezime)
	{
		return (!_prezime.matches("[a-zA-z]+([ '-][a-zA-Z]+)*"));	
	}
	
	//password
	protected Boolean ValidacijaPasswordUnesen(String _password)
	{
		return _password.length()!=0||_password ==null;
	}
	protected Boolean ValidacijaPasswordFormatDobar(String _password)
	{
		return true;
	}
	
	//password ponovo unesen
	protected Boolean ValidacijaPasswordPotvrdaUnesen(String _password)
	{
		return _password.length()!=0||_password==null;
		
	}
	protected Boolean ValidacijaPasswordPotvrda(String _password1,String _password2)
	{
		return (_password1==_password2);		
	}
	
	//datum
	protected Boolean ValidacijaDatumZaposlenja()
	{
		return true;
>>>>>>> refs/heads/101korisnik
		
	}
}
