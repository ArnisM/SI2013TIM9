package ba.unsa.etf.si2013.tim9.Korisnici;

///import java.awt.FileDialog;

import java.io.File;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.wb.swt.SWTResourceManager;

import sun.security.util.Password;


public class KorisniciDodavanjeForm extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
//	protected Shell this;
	private Text text_Ime;
	private Text text_Prezime;
	private Text text_Email;
	private Text text_Telefon;
	private Text text_Username;
	private Text text_Password;
	private Text text_PasswordPotvrda;
	private Image image_Slika;
	private Display d;
	private Shell s;

	
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			KorisniciDodavanjeForm shell = new KorisniciDodavanjeForm(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public KorisniciDodavanjeForm(Display display) {
		super(display, SWT.SHELL_TRIM);
		createContents();
		d = display;
		s = new Shell(d);
	}

	/**
	 * Create contents of the shell.
	 */
	
	protected void UnosSlike(Canvas _slika)
	{
		//org.eclipse.swt.widgets.FileDialog fd = new FileDialog(null, balloonTitle);
		FileDialog fd = new FileDialog(Display.getCurrent().getActiveShell(),SWT.OPEN);
		fd.setText("Slike:");
		String [] filterExt = {"*.jpg","*.jpeg","*.png","*.gif"};
		fd.setFilterExtensions(filterExt);
		String selected = fd.open();
		File f = new File (selected);
		if(f.exists())
		{
			Image im = (Image)SWTResourceManager.getImage(selected);
			ImageData imgData = im.getImageData();
			imgData = imgData.scaledTo(_slika.getSize().x,_slika.getSize().y);
			im.dispose();
			im = new Image(d, imgData);
			_slika.setBackgroundImage(im);
		}
	}
	
	protected Boolean Validacija()
	{
		Boolean rez = true;
		//Ime
		ControlDecoration textErrorIme = new ControlDecoration(text_Ime, SWT.RIGHT | SWT.TOP);
		KorisniciValidacija a = new KorisniciValidacija();
		if (a.ValidacijaImeUneseno(text_Ime.getText()))
		{
			textErrorIme.setDescriptionText("Niste unijeli ime!");
			FieldDecoration textField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
			textErrorIme.setImage(textField.getImage());
			textErrorIme.showHoverText("Niste unijeli ime!");
			rez = false;
		}		
		else if (a.ValidacijaImeFormatDobar(text_Ime.getText())){
			textErrorIme.setDescriptionText("Ime nije u ispravnom formatu!");
			FieldDecoration textField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
			textErrorIme.setImage(textField.getImage());
			textErrorIme.showHoverText("Ime nije u ispravnom formatu!");
			rez = false;
		}
		
		
		//Prezime
		ControlDecoration textErrorPrezime = new ControlDecoration(text_Prezime, SWT.RIGHT | SWT.TOP);
		if (a.ValidacijaPrezimeUneseno(text_Prezime.getText()))
		{
			textErrorPrezime.setDescriptionText("Niste unijeli prezime!");
			FieldDecoration textField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
			textErrorPrezime.setImage(textField.getImage());
			textErrorPrezime.showHoverText("Niste unijeli prezime!");
			rez = false;
		}		
		else if (a.ValidacijaPrezimeFormatDobar(text_Prezime.getText())){
			textErrorPrezime.setDescriptionText("Prezime nije u ispravnom formatu!");
			FieldDecoration textField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
			textErrorPrezime.setImage(textField.getImage());
			textErrorPrezime.showHoverText("Prezime nije u ispravnom formatu!");
			rez = false;
		}
		
		ControlDecoration textErrorAdresa = new ControlDecoration(text_Ime, SWT.RIGHT | SWT.TOP);
		
		//Telefon
		ControlDecoration textErrorTelefon = new ControlDecoration(text_Telefon, SWT.RIGHT | SWT.TOP);
		if (a.ValidacijaTelefonUneseno(text_Telefon.getText()))
		{
			textErrorTelefon.setDescriptionText("Niste unijeli Telefon!");
			FieldDecoration textField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
			textErrorTelefon.setImage(textField.getImage());
			textErrorTelefon.showHoverText("Niste unijeli Telefon!");
			rez = false;
		}		
		else if (a.ValidacijaTelefonFormatDobar(text_Telefon.getText())){
			textErrorTelefon.setDescriptionText("Telefon nije u ispravnom formatu!");
			FieldDecoration textField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
			textErrorTelefon.setImage(textField.getImage());
			textErrorTelefon.showHoverText("Telefon nije u ispravnom formatu!");
			rez = false;
		}
		
		ControlDecoration textErrorEmail = new ControlDecoration(text_Email, SWT.RIGHT | SWT.TOP);
		if (a.ValidacijaEmailUnesen(text_Email.getText()))
		{
			textErrorEmail.setDescriptionText("Niste unijeli Email!");
			FieldDecoration textField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
			textErrorEmail.setImage(textField.getImage());
			textErrorEmail.showHoverText("Niste unijeli Email!");
			rez = false;
		}		
		else if (a.ValidacijaEmailFormatDobar(text_Email.getText())){
			textErrorEmail.setDescriptionText("Email nije u ispravnom formatu!");
			FieldDecoration textField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
			textErrorEmail.setImage(textField.getImage());
			textErrorEmail.showHoverText("Email nije u ispravnom formatu!");
			rez = false;
		}
		
		ControlDecoration textErrorPassword = new ControlDecoration(text_Password, SWT.RIGHT | SWT.TOP);
		if (a.ValidacijaPasswordUnesen(text_Password.getText()))
		{
			textErrorPassword.setDescriptionText("Niste unijeli Password!");
			FieldDecoration textField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
			textErrorPassword.setImage(textField.getImage());
			textErrorPassword.showHoverText("Niste unijeli Password!");
			rez = false;
		}		
		else if (a.ValidacijaPasswordFormatDobar(text_Password.getText())){
			textErrorPassword.setDescriptionText("Password nije u ispravnom formatu!");
			FieldDecoration textField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
			textErrorPassword.setImage(textField.getImage());
			textErrorPassword.showHoverText("Password nije u ispravnom formatu!");
			rez = false;
		}
		
		ControlDecoration textErrorPasswordPotvrda = new ControlDecoration(text_PasswordPotvrda, SWT.RIGHT | SWT.TOP);
		if (a.ValidacijaPasswordPotvrdaUnesen(text_PasswordPotvrda.getText()))
		{
			textErrorPasswordPotvrda.setDescriptionText("Niste unijeli PasswordPotvrda!");
			FieldDecoration textField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
			textErrorPasswordPotvrda.setImage(textField.getImage());
			textErrorPasswordPotvrda.showHoverText("Niste unijeli PasswordPotvrda!");
			rez = false;
		}		
		else if (a.ValidacijaPasswordPotvrda(text_Password.getText(),text_PasswordPotvrda.getText())){
			textErrorPasswordPotvrda.setDescriptionText("PasswordPotvrda nije u ispravnom formatu!");
			FieldDecoration textField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
			textErrorPasswordPotvrda.setImage(textField.getImage());
			textErrorPasswordPotvrda.showHoverText("PasswordPotvrda nije u ispravnom formatu!");
			rez = false;
		}
		
		
		return rez;
	}
	
	protected void createContents() {
//		this = new Shell();
		this.setImage(SWTResourceManager.getImage(KorisniciDodavanjeForm.class, "/images/1396674475_user_male2.png"));
		this.setSize(461, 455);
		this.setText("Dodavanje korisnika");
		
		Group group = new Group(this, SWT.NONE);
		group.setBounds(10, 10, 424, 347);
		
		Label lblIme = new Label(group, SWT.NONE);
		lblIme.setBounds(37, 40, 55, 15);
		lblIme.setText("Ime:");
		
		Label lblPrezime = new Label(group, SWT.NONE);
		lblPrezime.setBounds(37, 75, 55, 15);
		lblPrezime.setText("Prezime:");
		
		Label lblNewLabel = new Label(group, SWT.NONE);
		lblNewLabel.setBounds(37, 109, 55, 15);
		lblNewLabel.setText("E-mail:");
		
		Label lblNewLabel_1 = new Label(group, SWT.NONE);
		lblNewLabel_1.setBounds(37, 140, 75, 15);
		lblNewLabel_1.setText("Broj telefona:");
		
		Label lblKorisnikoIme = new Label(group, SWT.NONE);
		lblKorisnikoIme.setBounds(37, 172, 87, 15);
		lblKorisnikoIme.setText("Korisni\u010Dko ime:");
		
		Label lblifra = new Label(group, SWT.NONE);
		lblifra.setBounds(37, 201, 55, 15);
		lblifra.setText("\u0160ifra:");
		
		Label lblPonoviteifru = new Label(group, SWT.NONE);
		lblPonoviteifru.setBounds(37, 232, 87, 15);
		lblPonoviteifru.setText("Ponovite \u0161ifru:");
		
		Group grpOdabirUloge = new Group(group, SWT.NONE);
		grpOdabirUloge.setText("Odabir uloge");
		grpOdabirUloge.setBounds(37, 263, 220, 67);
		
		final Button _operater = new Button(grpOdabirUloge, SWT.RADIO);
		final Button _rukovodilac = new Button(grpOdabirUloge, SWT.RADIO);
		_operater.setSelection(true);
		_operater.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				//_rukovodilac.setSelection(false);
			}
		});
		_operater.setBounds(20, 30, 67, 16);
		_operater.setText("Operater");
		
		_rukovodilac.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				//_operater.setSelection(false);
			}
		});
		_rukovodilac.setBounds(106, 30, 90, 16);
		_rukovodilac.setText("Rukovodilac");
		
		text_Ime = new Text(group, SWT.BORDER);
		text_Ime.setBounds(131, 37, 126, 21);
		
		text_Prezime = new Text(group, SWT.BORDER);
		text_Prezime.setBounds(131, 72, 126, 21);
		
		text_Email = new Text(group, SWT.BORDER);
		text_Email.setBounds(131, 106, 126, 21);
		
		text_Telefon = new Text(group, SWT.BORDER);
		text_Telefon.setBounds(131, 140, 126, 21);
		
		text_Username = new Text(group, SWT.BORDER);
		text_Username.setBounds(131, 172, 126, 21);
		
		text_Password = new Text(group, SWT.PASSWORD| SWT.BORDER);
		text_Password.setBounds(131, 201, 126, 21);
		//_test.
		
		text_PasswordPotvrda = new Text(group, SWT.PASSWORD | SWT.BORDER);
		text_PasswordPotvrda.setBounds(131, 232, 126, 21);
		
		final Canvas _slika = new Canvas(group, SWT.NONE);
		_slika.setBounds(281, 37, 118, 141);
		_slika.setBackgroundImage(SWTResourceManager.getImage(KorisniciDodavanjeForm.class, "/images/1396674475_user_male2.png"));
		
		Button IzaberiSliku = new Button(group, SWT.NONE);
		IzaberiSliku.setBounds(304, 184, 75, 25);
		IzaberiSliku.setText("Izaberi sliku");
		IzaberiSliku.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				UnosSlike(_slika);
				
			}
		});
		
		Button _dodaj = new Button(this, SWT.NONE);
		_dodaj.setImage(SWTResourceManager.getImage(KorisniciDodavanjeForm.class, "/images/1398195801_tick_32.png"));
		_dodaj.setBounds(160, 369, 117, 38);
		_dodaj.setText("Dodaj");
		_dodaj.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell=new Shell();
				if(Validacija())
				{
					MessageDialog.openInformation(shell, "Dodavanje", text_Ime.getText());
					close();
				}
				
			}
		});
		
		Button _izlaz = new Button(this, SWT.NONE);
		_izlaz.setImage(SWTResourceManager.getImage(KorisniciDodavanjeForm.class, "/images/1398195841_DeleteRed.png"));
		_izlaz.setBounds(303, 369, 117, 38);
		_izlaz.setText("Izlaz");
		_izlaz.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
