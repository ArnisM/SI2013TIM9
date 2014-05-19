package ba.unsa.etf.si2013.tim9.Klijenti;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.hibernate.HibernateException;
import org.hibernate.Session;





import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sun.java_cup.internal.runtime.Scanner;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;
import ba.unsa.etf.si2013.tim9.Klijenti.*;

public class KlijentiDodavanjeForm extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
//	protected Shell this;
	private static SessionFactory factory; 
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text txt_nazivFirme;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private Text text_8;
	private Text text_9;
	private Text text_10;
	private Text text_11;
	private Text text_12;
	
	public static void main(String args[]) {
		try {
			
			Display display = Display.getDefault();
			KlijentiDodavanjeForm shell = new KlijentiDodavanjeForm(display);
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

	private static void dodajKlijenta(Session session) throws IllegalStateException, SystemException, SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
		
		session = HibernateUtil.getSessionFactory().openSession();
		 
        session.beginTransaction();
        Klijenti stock = new Klijenti();
 
        stock.setAdresa("adresa");
        stock.setEmail("email");
        stock.setTelefon("telefon");
 
        session.save(stock);
        session.getTransaction().commit();
		// TODO Auto-generated method stub
		 Shell shell = new Shell();
		 MessageDialog.openInformation(shell, "Doodavanje klijenta", "Klijent je uspješno dodan.");
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public KlijentiDodavanjeForm(Display display) {
		super(display, SWT.SHELL_TRIM);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
//		this = new Shell();
		this.setImage(SWTResourceManager.getImage(KlijentiDodavanjeForm.class, "/images/1396674421_Streamline-61.png"));
		this.setSize(354, 488);
		this.setText("Dodavanje klijenta");
		
		TabFolder tabFolder = new TabFolder(this, SWT.NONE);
		tabFolder.setBounds(10, 10, 321, 430);
		
		TabItem tbtmFirma = new TabItem(tabFolder, SWT.NONE);
		tbtmFirma.setText("Firma");
		
		Group group_1 = new Group(tabFolder, SWT.NONE);
		tbtmFirma.setControl(group_1);
		
		final Label lblNazivFirme = new Label(group_1, SWT.NONE);
		lblNazivFirme.setText("Naziv firme:");
		lblNazivFirme.setBounds(37, 55, 75, 15);
		
		Label lblPdvBroj = new Label(group_1, SWT.NONE);
		lblPdvBroj.setText("PDV broj:");
		lblPdvBroj.setBounds(37, 122, 55, 15);
		
		Label lblIdpdvBroj = new Label(group_1, SWT.NONE);
		lblIdpdvBroj.setText("IDPDV broj:");
		lblIdpdvBroj.setBounds(37, 149, 75, 15);
		
		txt_nazivFirme = new Text(group_1, SWT.BORDER);
		txt_nazivFirme.setBounds(118, 52, 126, 21);
		
		text_5 = new Text(group_1, SWT.BORDER);
		text_5.setBounds(118, 119, 126, 21);
		
		text_6 = new Text(group_1, SWT.BORDER);
		text_6.setBounds(118, 146, 126, 21);
		
		Button button_2 = new Button(group_1, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell=new Shell();
				
				ControlDecoration text8Error = new ControlDecoration(text_8, SWT.RIGHT | SWT.TOP);
				ControlDecoration text9Error = new ControlDecoration(text_9, SWT.RIGHT | SWT.TOP);
				ControlDecoration text7Error = new ControlDecoration(text_7, SWT.RIGHT | SWT.TOP);
				ControlDecoration text6Error = new ControlDecoration(text_6, SWT.RIGHT | SWT.TOP);
				ControlDecoration nazivFirmeError = new ControlDecoration(txt_nazivFirme, SWT.RIGHT | SWT.TOP);
				ControlDecoration text10Error = new ControlDecoration(text_10, SWT.RIGHT | SWT.TOP);
				ControlDecoration text5Error = new ControlDecoration(text_5, SWT.RIGHT | SWT.TOP);
				
				if (txt_nazivFirme.getText().length()<3 || txt_nazivFirme.getText()==""){
					nazivFirmeError.setDescriptionText("Niste unijeli naziv firme!");
					FieldDecoration nazivFirmeField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					nazivFirmeError.setImage(nazivFirmeField.getImage());
					nazivFirmeError.showHoverText("Niste unijeli naziv firme!");
				}
				
				
				
				else if (text_10.getText().length()<3 || text_10.getText()==""){
					text10Error.setDescriptionText("Niste unijeli adresu firme!");
					FieldDecoration text10Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text10Error.setImage(text10Field.getImage());
					text10Error.showHoverText("Niste unijeli adresu firme!");
				}
				
				
				
				else if (text_5.getText().length()<3 || text_5.getText()==""){
					text5Error.setDescriptionText("Niste unijeli PDV broj!");
					FieldDecoration text5Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text5Error.setImage(text5Field.getImage());
					text5Error.showHoverText("Niste unijeli PDV broj!");
				}
				

				
				else if (text_6.getText().length()<3 || text_6.getText()==""){
					text6Error.setDescriptionText("Niste unijeli IDPDV broj!");
					FieldDecoration text6Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text6Error.setImage(text6Field.getImage());
					text6Error.showHoverText("Niste unijeli IDPDV broj!");
				}
				

				
				else if (text_7.getText().length()<3 || text_7.getText()==""){
					text7Error.setDescriptionText("Niste unijeli kontakt telefon!");
					FieldDecoration text7Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text7Error.setImage(text7Field.getImage());
					text7Error.showHoverText("Niste unijeli kontakt telefon!");
				}
				
				else if (!text_7.getText().matches("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{3}$")){
					text7Error.setDescriptionText("Telefon nije u ispravnom formatu!");
					FieldDecoration text7Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text7Error.setImage(text7Field.getImage());
					text7Error.showHoverText("Telefon nije u ispravnom formatu!");
				}
				

				
				else if (text_8.getText().length()<3 || text_8.getText()==""){
					text8Error.setDescriptionText("Niste unijeli kontakt fax!");
					FieldDecoration text8Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text8Error.setImage(text8Field.getImage());
					text8Error.showHoverText("Niste unijeli kontakt fax!");
				}
				
				else if (!text_8.getText().matches("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{3}$")){
					text8Error.setDescriptionText("Fax nije u ispravnom formatu!");
					FieldDecoration text8Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text8Error.setImage(text8Field.getImage());
					text8Error.showHoverText("Fax nije u ispravnom formatu!");
				}
				

				else if (text_9.getText().length()<3 || text_9.getText()==""){
					text7Error.setDescriptionText("Niste unijeli e-mail!");
					FieldDecoration text9Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text9Error.setImage(text9Field.getImage());
					text9Error.showHoverText("Niste unijeli e-mail!");
				}
				else if (!text_9.getText().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
					text9Error.setDescriptionText("E-mail nije u ispravnom formatu!");
					FieldDecoration text9Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text9Error.setImage(text9Field.getImage());
					text9Error.showHoverText("E-mail nije u ispravnom formatu!");
				}
				
				else {
					Session session = HibernateUtil.getSessionFactory().openSession();
					try {
						dodajKlijenta(session);
					} catch (IllegalStateException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SecurityException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SystemException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (RollbackException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (HeuristicMixedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (HeuristicRollbackException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				      
					
					
				}
				
				
			}
		});
		button_2.setText("Dodaj");
		button_2.setImage(SWTResourceManager.getImage(KlijentiDodavanjeForm.class, "/images/1398195801_tick_32.png"));
		button_2.setBounds(58, 350, 117, 42);
		
		Button button_3 = new Button(group_1, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		button_3.setText("Izlaz");
		button_3.setImage(SWTResourceManager.getImage(KlijentiDodavanjeForm.class, "/images/1398195841_DeleteRed.png"));
		button_3.setBounds(186, 350, 117, 42);
		
		Group grpKontakt = new Group(group_1, SWT.NONE);
		grpKontakt.setText("Kontakt");
		grpKontakt.setBounds(28, 184, 243, 116);
		
		text_7 = new Text(grpKontakt, SWT.BORDER);
		text_7.setBounds(74, 22, 126, 21);
		
		text_8 = new Text(grpKontakt, SWT.BORDER);
		text_8.setBounds(74, 49, 126, 21);
		
		Label lblTel = new Label(grpKontakt, SWT.NONE);
		lblTel.setText("Tel:");
		lblTel.setBounds(20, 28, 48, 15);
		
		Label lblFax = new Label(grpKontakt, SWT.NONE);
		lblFax.setText("Fax:");
		lblFax.setBounds(20, 52, 48, 15);
		
		text_9 = new Text(grpKontakt, SWT.BORDER);
		text_9.setBounds(74, 76, 126, 21);
		
		Label lblEmail = new Label(grpKontakt, SWT.NONE);
		lblEmail.setText("E-mail:");
		lblEmail.setBounds(20, 79, 48, 15);
		
		Label lblAdresa = new Label(group_1, SWT.NONE);
		lblAdresa.setText("Adresa:");
		lblAdresa.setBounds(37, 82, 75, 15);
		
		text_10 = new Text(group_1, SWT.BORDER);
		text_10.setBounds(118, 79, 126, 21);
		
		TabItem tbtmFizikoLice = new TabItem(tabFolder, SWT.NONE);
		tbtmFizikoLice.setText("Fizi\u010Dko lice");
		
		Group group = new Group(tabFolder, SWT.NONE);
		tbtmFizikoLice.setControl(group);
		
		Label label = new Label(group, SWT.NONE);
		label.setText("Ime:");
		label.setBounds(37, 50, 55, 15);
		
		Label label_1 = new Label(group, SWT.NONE);
		label_1.setText("Prezime:");
		label_1.setBounds(37, 77, 55, 15);
		
		text = new Text(group, SWT.BORDER);
		text.setBounds(120, 47, 126, 21);
		
		text_1 = new Text(group, SWT.BORDER);
		text_1.setBounds(120, 74, 126, 21);
		
		Button button = new Button(group, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell=new Shell();
				
ControlDecoration textError = new ControlDecoration(text, SWT.RIGHT | SWT.TOP);
				
				if (text.getText().length()<3 || text.getText()==""){
					textError.setDescriptionText("Niste unijeli ime!");
					FieldDecoration textField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					textError.setImage(textField.getImage());
					textError.showHoverText("Niste unijeli ime!");
				}
				
				else if (!text.getText().matches("[A-Z]([a-z]+|\\s[a-z]+)?")){
					textError.setDescriptionText("Ime nije u ispravnom formatu!");
					FieldDecoration textField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					textError.setImage(textField.getImage());
					textError.showHoverText("Ime nije u ispravnom formatu!");
				}
				
ControlDecoration text1Error = new ControlDecoration(text_1, SWT.RIGHT | SWT.TOP);
				
				if (text_1.getText().length()<3 || text_1.getText()==""){
					text1Error.setDescriptionText("Niste unijeli prezime!");
					FieldDecoration text1Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text1Error.setImage(text1Field.getImage());
					text1Error.showHoverText("Niste unijeli prezime!");
				}
								
				else if (!text_1.getText().matches("[a-zA-z]+([ '-][a-zA-Z]+)*")){
					text1Error.setDescriptionText("Prezime nije u ispravnom formatu!");
					FieldDecoration text1Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text1Error.setImage(text1Field.getImage());
					text1Error.showHoverText("Prezime nije u ispravnom formatu!");
				}
				
				
ControlDecoration text11Error = new ControlDecoration(text_11, SWT.RIGHT | SWT.TOP);
				
				if (text_11.getText().length()<3 || text_11.getText()==""){
					text11Error.setDescriptionText("Niste unijeli adresu!");
					FieldDecoration text11Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text11Error.setImage(text11Field.getImage());
					text11Error.showHoverText("Niste unijeli adresu!");
				}
								
				/*else if (text_11.getText().matches("")){
					text11Error.setDescriptionText("Adresa nije u validnom formatu!");
					FieldDecoration text11Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text11Error.setImage(text11Field.getImage());
					text11Error.showHoverText("Adresa nije u valdnom formatu!");
				}*/
				
				
				
ControlDecoration text2Error = new ControlDecoration(text_2, SWT.RIGHT | SWT.TOP);
				
				if (text_2.getText().length()<3 || text_2.getText()==""){
					text2Error.setDescriptionText("Niste unijeli kontakt telefon!");
					FieldDecoration text2Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text2Error.setImage(text2Field.getImage());
					text2Error.showHoverText("Niste unijeli kontakt telefon!");
				}
				
				else if (!text_2.getText().matches("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{3}$")){
					text2Error.setDescriptionText("Telefon nije u ispravnom formatu!");
					FieldDecoration text2Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text2Error.setImage(text2Field.getImage());
					text2Error.showHoverText("Telefon nije u ispravnom formatu!");
				}
				
ControlDecoration text12Error = new ControlDecoration(text_12, SWT.RIGHT | SWT.TOP);
				
				if (text_12.getText().length()<3 || text_12.getText()==""){
					text12Error.setDescriptionText("Niste unijeli kontakt fax!");
					FieldDecoration text12Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text12Error.setImage(text12Field.getImage());
					text12Error.showHoverText("Niste unijeli kontakt fax!");
				}
				
				else if (!text_12.getText().matches("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{3}$")){
					text12Error.setDescriptionText("Fax nije u ispravnom formatu!");
					FieldDecoration text12Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text12Error.setImage(text12Field.getImage());
					text12Error.showHoverText("Fax nije u ispravnom formatu!");
				}
				
ControlDecoration text3Error = new ControlDecoration(text_3, SWT.RIGHT | SWT.TOP);
				
				if (text_3.getText().length()<3 || text_3.getText()==""){
					text3Error.setDescriptionText("Niste unijeli e-mail!");
					FieldDecoration text3Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text3Error.setImage(text3Field.getImage());
					text3Error.showHoverText("Niste unijeli e-mail!");
				}
				
				else if (!text_3.getText().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
					text3Error.setDescriptionText("E-mail nije u ispravnom formatu!");
					FieldDecoration text3Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text3Error.setImage(text3Field.getImage());
					text3Error.showHoverText("E-mail nije u ispravnom formatu!");
				}
				
				
				//MessageDialog.openInformation(shell, "Doodavanje klijenta", "Klijent je uspješno dodan.");
				
			}
		});
		button.setText("Dodaj");
		button.setImage(SWTResourceManager.getImage(KlijentiDodavanjeForm.class, "/images/1398195801_tick_32.png"));
		button.setBounds(58, 350, 117, 42);
		
		Button button_1 = new Button(group, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		button_1.setText("Izlaz");
		button_1.setImage(SWTResourceManager.getImage(KlijentiDodavanjeForm.class, "/images/1398195841_DeleteRed.png"));
		button_1.setBounds(186, 350, 117, 42);
		
		Label lblAdresa_1 = new Label(group, SWT.NONE);
		lblAdresa_1.setBounds(37, 130, 55, 15);
		lblAdresa_1.setText("Adresa:");
		
		Group grpKontakt_1 = new Group(group, SWT.NONE);
		grpKontakt_1.setText("Kontakt");
		grpKontakt_1.setBounds(25, 173, 247, 132);
		
		text_3 = new Text(grpKontakt_1, SWT.BORDER);
		text_3.setBounds(95, 83, 126, 21);
		
		Label lblTel_1 = new Label(grpKontakt_1, SWT.NONE);
		lblTel_1.setBounds(10, 32, 75, 15);
		lblTel_1.setText("Tel:");
		
		text_2 = new Text(grpKontakt_1, SWT.BORDER);
		text_2.setBounds(95, 29, 126, 21);
		
		Label label_2 = new Label(grpKontakt_1, SWT.NONE);
		label_2.setBounds(10, 86, 55, 15);
		label_2.setText("E-mail:");
		
		text_12 = new Text(grpKontakt_1, SWT.BORDER);
		text_12.setBounds(95, 56, 126, 21);
		
		Label lblFax_1 = new Label(grpKontakt_1, SWT.NONE);
		lblFax_1.setText("Fax:");
		lblFax_1.setBounds(10, 56, 75, 15);
		
		text_11 = new Text(group, SWT.BORDER);
		text_11.setBounds(120, 127, 126, 21);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
