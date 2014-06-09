package ba.unsa.etf.si2013.tim9.Korisnici;

///import java.awt.FileDialog;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.transaction.Transaction;

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
import org.hibernate.Query;
import org.hibernate.Session;

import ba.unsa.etf.si2013.tim9.HibernateUtil;
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

	public Boolean Validacija(){
		ControlDecoration textimeError = new ControlDecoration(text_Ime, SWT.RIGHT | SWT.TOP);
		ControlDecoration prezimeError = new ControlDecoration(text_Prezime, SWT.RIGHT | SWT.TOP);
		ControlDecoration telefonError = new ControlDecoration(text_Telefon, SWT.RIGHT | SWT.TOP);
		ControlDecoration emailError = new ControlDecoration(text_Email, SWT.RIGHT | SWT.TOP);
		ControlDecoration usernameError = new ControlDecoration(text_Username, SWT.RIGHT | SWT.TOP);
		ControlDecoration passwordError = new ControlDecoration(text_Password, SWT.RIGHT | SWT.TOP);
		ControlDecoration passwordpotvrdaError = new ControlDecoration(text_PasswordPotvrda, SWT.RIGHT | SWT.TOP);
		FieldDecoration ImeField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
		
		
		if (text_Ime.getText().length()<3 || text_Ime.getText()==""){
			
			textimeError.setDescriptionText("Niste unijeli ime!");
			textimeError.setImage(ImeField.getImage());
			textimeError.showHoverText("Niste unijeli ime!");
			return false;
		}
		
		if (!text_Ime.getText().matches("[a-zA-z]+([ '-][a-zA-Z]+)*")){
			textimeError.setDescriptionText("Ime je u pogrešnom formatu!");
			//FieldDecoration ImeField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
			textimeError.setImage(ImeField.getImage());			
			textimeError.showHoverText("Ime je u pogrešnom formatu!");
			
			
			return false;
		}
		
		if (text_Prezime.getText().length()<3 || text_Prezime.getText()==""){
			prezimeError.setDescriptionText("Niste unijeli prezime!");
			FieldDecoration prezimeField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
			prezimeError.setImage(prezimeField.getImage());
			prezimeError.showHoverText("Niste unijeli prezime!");
			return false;
		}
		if (!text_Prezime.getText().matches("[a-zA-z]+([ '-][a-zA-Z]+)*")){
			prezimeError.setDescriptionText("Prezime je u pogrešnom formatu!");
			FieldDecoration prezimeField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
			prezimeError.setImage(prezimeField.getImage());
			prezimeError.showHoverText("Prezime je u pogrešnom formatu!");
			return false;
		}
		
		if (text_Telefon.getText().length()<3 || text_Telefon.getText()==""){
			telefonError.setDescriptionText("Niste unijeli telefon!");
			FieldDecoration telefonField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
			telefonError.setImage(telefonField.getImage());
			telefonError.showHoverText("Niste unijeli telefon!");
			return false;
		}
		
		if(!text_Telefon.getText().matches("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{3}$")){
			telefonError.setDescriptionText("Telefon nije u ispravnom formatu! Validni formati: 123-123-123, 123 123 123");
			FieldDecoration telefonField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
			telefonError.setImage(telefonField.getImage());
			telefonError.showHoverText("Telefon nije u ispravnom formatu! Validni formati: 123-123-123, 123 123 123");
			return false;
		}
		
		if (text_Email.getText().length()<3 || text_Email.getText()==""){
			emailError.setDescriptionText("Niste unijeli email!");
			FieldDecoration emailField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
			emailError.setImage(emailField.getImage());
			emailError.showHoverText("Niste unijeli email!");
			return false;
		}
		
		if(!text_Email.getText().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
			emailError.setDescriptionText("Email nije u validnom formatu!");
			FieldDecoration emailField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
			emailError.setImage(emailField.getImage());
			emailError.showHoverText("Email nije u validnom formatu!");
			return false;
		}
		
		if (text_Username.getText().length()<3 || text_Username.getText()==""){
			usernameError.setDescriptionText("Niste unijeli username!");
			FieldDecoration usernameField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
			usernameError.setImage(usernameField.getImage());
			usernameError.showHoverText("Niste unijeli username!");
			return false;
		}
		
		if(!text_Username.getText().matches("^[a-z0-9_-]{3,15}$")){
			usernameError.setDescriptionText("Username nije u validnom formatu!");
			FieldDecoration usernameField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
			usernameError.setImage(usernameField.getImage());
			usernameError.showHoverText("Username nije u validnom formatu!");
			return false;
		}
		
		if (text_Password.getText().length()<3 || text_Password.getText()==""){
			passwordError.setDescriptionText("Niste unijeli password!");
			FieldDecoration passwordField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
			passwordError.setImage(passwordField.getImage());
			passwordError.showHoverText("Niste unijeli password!");
			return false;
		}
		if (!text_Password.getText().matches("^([0-9A-Za-z@.]{1,255})$")){
			passwordError.setDescriptionText("Password nije u validnom formatu!");
			FieldDecoration passwordField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
			passwordError.setImage(passwordField.getImage());
			passwordError.showHoverText("Password nije u validnom formatu!");
			return false;
		}
		
		if(!text_Password.getText().equals(text_PasswordPotvrda.getText())){
			
			passwordpotvrdaError.setDescriptionText("Uneste ponovo!");
			FieldDecoration passwordpotvrdaField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
			passwordpotvrdaError.setImage(passwordpotvrdaField.getImage());
			passwordpotvrdaError.showHoverText("Unesite ponovo!");
			return false;
		}
		
		
		return true;
	}
	/**
	 * Create contents of the shell.
	 */
	
	protected void UnosSlike(Canvas _slika)
	{
		try{
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
		} catch(Exception e43){}
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
				
					
				if(Validacija()){

				try{	
					List<Korisnik> korisnici;
					Session session = HibernateUtil.getSessionFactory().openSession();
					Transaction t = (Transaction) session.beginTransaction();
					Query q = session.createQuery("* from Korisnik");
			        korisnici=q.list();
			        t.commit();
			        
			        
						Korisnik noviK=new Korisnik();
						if(_operater.getSelection()){
				 noviK = new Korisnik(text_Ime.getText(),text_Prezime.getText(),"operater",text_Telefon.getText(),text_Email.getText(), text_Username.getText(), text_Password.getText(), new Date());
				 		//noviK.daliPostoji();
						}
						if(_rukovodilac.getSelection())
							 noviK = new Korisnik(text_Ime.getText(),text_Prezime.getText(),"rukovodilac",text_Telefon.getText(),text_Email.getText(), text_Username.getText(), text_Password.getText(), new Date());
									
						
						noviK.spasiUBazu();
				Shell shell1 = new Shell();
				 MessageDialog.openInformation(shell1, "Doodavanje korisnika", "Korisnik je uspješno dodan.");
					}catch(Exception e3){}
				
				
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
