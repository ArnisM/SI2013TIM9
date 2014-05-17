package ba.unsa.etf.si2013.tim9.Klijenti;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class KlijentiBrisanjeForm extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
	
//	protected Shell this;
	private Text text;
	private Table table;
	
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			KlijentiBrisanjeForm shell = new KlijentiBrisanjeForm(display);
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
	public KlijentiBrisanjeForm(Display display) {
		super(display, SWT.SHELL_TRIM);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
//		this = new Shell();
		this.setImage(SWTResourceManager.getImage(KlijentiBrisanjeForm.class, "/images/1396674421_Streamline-61.png"));
		this.setSize(631, 433);
		this.setText("Brisanje fizi\u010Dkog lica");
		
		Group group = new Group(this, SWT.NONE);
		group.setText("Pretraga");
		group.setBounds(10, 29, 575, 107);
		
		Combo combo = new Combo(group, SWT.NONE);
		combo.setItems(new String[] {"Ime", "Prezime", "Korisni\u010Dko ime", "E-mail", "Uloga"});
		combo.setBounds(112, 35, 142, 23);
		combo.setText("Prezime");
		
		Label label = new Label(group, SWT.NONE);
		label.setText("Kirterij pretrage:");
		label.setBounds(10, 38, 96, 15);
		
		text = new Text(group, SWT.BORDER);
		text.setBounds(380, 35, 163, 21);
		
		Label lblUnesitePrezime = new Label(group, SWT.NONE);
		lblUnesitePrezime.setText("Unesite prezime:");
		lblUnesitePrezime.setBounds(282, 38, 92, 15);
		
		Button button = new Button(group, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
				MessageDialog.openInformation(shell, "Info", "Uspješno je izvršena pretraga klijenata. Klijenti su prikazani u tabeli ispod.");
			}
		});
		button.setText("Pretraga");
		button.setImage(SWTResourceManager.getImage(KlijentiBrisanjeForm.class, "/images/1398199827_search_magnifying_glass_find.png"));
		button.setBounds(427, 62, 116, 35);
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 163, 595, 163);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(91);
		tblclmnNewColumn.setText("Ime");
		
		TableColumn tblclmnPrezime = new TableColumn(table, SWT.NONE);
		tblclmnPrezime.setWidth(100);
		tblclmnPrezime.setText("Prezime");
		
		TableColumn tblclmnAdresa = new TableColumn(table, SWT.NONE);
		tblclmnAdresa.setWidth(124);
		tblclmnAdresa.setText("Adresa");
		
		TableColumn tblclmnTelefon = new TableColumn(table, SWT.NONE);
		tblclmnTelefon.setWidth(109);
		tblclmnTelefon.setText("Telefon");
		
		TableColumn tblclmnEmail = new TableColumn(table, SWT.NONE);
		tblclmnEmail.setWidth(167);
		tblclmnEmail.setText("E-mail");
		
		Button button_1 = new Button(this, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
				MessageDialog.openInformation(shell, "Brisanje klijenta", "Klijent je uspješno obrisan.");
			}
		});
		button_1.setText("Bri\u0161i");
		button_1.setImage(SWTResourceManager.getImage(KlijentiBrisanjeForm.class, "/images/1398201739_Trash.png"));
		button_1.setBounds(344, 345, 123, 46);
		
		Button button_2 = new Button(this, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		button_2.setText("Izlaz");
		button_2.setImage(SWTResourceManager.getImage(KlijentiBrisanjeForm.class, "/images/1398195841_DeleteRed.png"));
		button_2.setBounds(482, 345, 123, 46);
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setText("Ozna\u010Dite \u017Eeljeni red:");
		label_1.setBounds(10, 142, 154, 15);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
