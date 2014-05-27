package ba.unsa.etf.si2013.tim9.Usluge;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import java.util.Scanner; 

import org.hibernate.Transaction; 
import org.hibernate.Session; 

import ba.unsa.etf.si2013.tim9.HibernateUtil;
import ba.unsa.etf.si2013.tim9.Usluge.*;



public class UslugeDodavanjeForm extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
//	protected Shell this;
	private Text text;
	private Text text_1;

	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			UslugeDodavanjeForm shell = new UslugeDodavanjeForm(display);
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
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		 dodajUslugu(session);
		  
		 session.close(); 

	}



	/**
	 * Create the shell.
	 * @param display
	 */
	public UslugeDodavanjeForm(Display display) {
		super(display, SWT.SHELL_TRIM);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
//		this = new Shell();
		this.setImage(SWTResourceManager.getImage(UslugeDodavanjeForm.class, "/images/1396674353_services.png"));
		this.setSize(393, 540);
		this.setText("Dodavanje usluga");
		
		Label lblNazivUsluge = new Label(this, SWT.NONE);
		lblNazivUsluge.setBounds(28, 58, 78, 15);
		lblNazivUsluge.setText("Naziv usluge:");
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(112, 55, 246, 21);
		
		Group grpTipUsluge = new Group(this, SWT.NONE);
		grpTipUsluge.setText("Tip usluge");
		grpTipUsluge.setBounds(28, 104, 252, 82);
		
		Button btnServis = new Button(grpTipUsluge, SWT.RADIO);
		btnServis.setBounds(88, 22, 90, 16);
		btnServis.setText("Servis");
		
		Button btnKonsultacije = new Button(grpTipUsluge, SWT.RADIO);
		btnKonsultacije.setBounds(88, 56, 90, 16);
		btnKonsultacije.setText("Konsultacije");
		
		text_1 = new Text(this, SWT.BORDER);
		text_1.setBounds(28, 288, 330, 141);
		
		Label lblOpisUsluge = new Label(this, SWT.NONE);
		lblOpisUsluge.setText("Opis usluge:");
		lblOpisUsluge.setBounds(28, 267, 78, 15);
		
		Label lblCijenaUsluge = new Label(this, SWT.NONE);
		lblCijenaUsluge.setBounds(28, 195, 100, 15);
		lblCijenaUsluge.setText("Cijena usluge(KM):");
		
		Spinner spinner = new Spinner(this, SWT.BORDER);
		spinner.setBounds(189, 192, 91, 22);
		
		Label lblTroakIzvrenjakm = new Label(this, SWT.NONE);
		lblTroakIzvrenjakm.setText("Tro\u0161ak izvr\u0161enja usluge(KM):");
		lblTroakIzvrenjakm.setBounds(28, 234, 150, 15);
		
		Spinner spinner_1 = new Spinner(this, SWT.BORDER);
		spinner_1.setBounds(189, 227, 91, 22);
		
		Button btnDodaj = new Button(this, SWT.NONE);
		btnDodaj.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
ControlDecoration textError = new ControlDecoration(text, SWT.RIGHT | SWT.TOP);
				
				if (text.getText().length()<3 || text.getText()==""){
					textError.setDescriptionText("Niste unijeli naziv!");
					FieldDecoration textField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					textError.setImage(textField.getImage());
					textError.showHoverText("Niste unijeli naziv!");
				}
				
				else if (!text.getText().matches("[A-Za-z0-9 ]*")){
					textError.setDescriptionText("Naziv usluge nije u ispravnom formatu!");
					FieldDecoration textField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					textError.setImage(textField.getImage());
					textError.showHoverText("Naziv usluge nije u ispravnom formatu!");
				}
				else
				MessageDialog.openInformation(shell, "Doodavanje usluga", "Usluga je uspješno dodana.");
			}
		});
		btnDodaj.setText("Dodaj");
		btnDodaj.setImage(SWTResourceManager.getImage(UslugeDodavanjeForm.class, "/images/1398195801_tick_32.png"));
		btnDodaj.setBounds(112, 450, 116, 42);
		
		Button button_1 = new Button(this, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		button_1.setText("Izlaz");
		button_1.setImage(SWTResourceManager.getImage(UslugeDodavanjeForm.class, "/images/1398195841_DeleteRed.png"));
		button_1.setBounds(242, 450, 116, 42);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	private static void dodajUslugu(Session session) {
		// TODO Auto-generated method stub
		Transaction t = session.beginTransaction(); 
		 
		 Usluga u = new Usluga(); 
		 
		 
		 Long id = (Long) session.save(u); 
		  
		 t.commit(); 

	}

}
