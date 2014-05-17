package ba.unsa.etf.si2013.tim9.Klijenti;

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

public class KlijentiDodavanjeForm extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
//	protected Shell this;
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
				MessageDialog.openInformation(shell, "Doodavanje klijenta", "Klijent je uspješno dodan.");
				
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
				MessageDialog.openInformation(shell, "Doodavanje klijenta", "Klijent je uspješno dodan.");
				
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
