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

public class KlijentiIzmjenaForm extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
//	protected Shell this;
	private Table table;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_5;
	private Text text_6;
	
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			KlijentiIzmjenaForm shell = new KlijentiIzmjenaForm(display);
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
	public KlijentiIzmjenaForm(Display display) {
		super(display, SWT.SHELL_TRIM);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
//		this = new Shell();
		this.setImage(SWTResourceManager.getImage(KlijentiIzmjenaForm.class, "/images/1396674421_Streamline-61.png"));
		this.setSize(631, 490);
		this.setText("Izmjena fizi\u010Dkog lica");
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 149, 595, 78);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(91);
		tableColumn.setText("Ime");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("Prezime");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(124);
		tableColumn_2.setText("Adresa");
		
		TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(109);
		tableColumn_3.setText("Telefon");
		
		TableColumn tableColumn_4 = new TableColumn(table, SWT.NONE);
		tableColumn_4.setWidth(167);
		tableColumn_4.setText("E-mail");
		
		Group group = new Group(this, SWT.NONE);
		group.setText("Pretraga");
		group.setBounds(10, 10, 575, 107);
		
		Combo combo = new Combo(group, SWT.NONE);
		combo.setItems(new String[] {"Ime", "Prezime", "Korisni\u010Dko ime", "E-mail", "Uloga"});
		combo.setBounds(112, 35, 142, 23);
		combo.setText("Prezime");
		
		Label label = new Label(group, SWT.NONE);
		label.setText("Kirterij pretrage:");
		label.setBounds(10, 38, 96, 15);
		
		text = new Text(group, SWT.BORDER);
		text.setBounds(380, 35, 163, 21);
		
		Label label_1 = new Label(group, SWT.NONE);
		label_1.setText("Unesite prezime:");
		label_1.setBounds(282, 38, 92, 15);
		
		Button button = new Button(group, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell ();
				MessageDialog.openInformation(shell, "Pretraga klijenta", "Klijenti su uspješno pretražen i dostupn su u tabel ispod.");
			}
		});
		button.setText("Pretraga");
		button.setImage(SWTResourceManager.getImage(KlijentiIzmjenaForm.class, "/images/1398199827_search_magnifying_glass_find.png"));
		button.setBounds(427, 62, 116, 35);
		
		Label lblOznaiteKlijenta = new Label(this, SWT.NONE);
		lblOznaiteKlijenta.setText("Ozna\u010Dite \u017Eeljenog klijenta:");
		lblOznaiteKlijenta.setBounds(10, 128, 154, 15);
		
		Group group_1 = new Group(this, SWT.NONE);
		group_1.setText("Izmjena atributa");
		group_1.setBounds(10, 238, 595, 158);
		
		Label label_2 = new Label(group_1, SWT.NONE);
		label_2.setText("Ime:");
		label_2.setBounds(25, 35, 55, 15);
		
		Label label_3 = new Label(group_1, SWT.NONE);
		label_3.setText("Prezime:");
		label_3.setBounds(25, 56, 55, 15);
		
		Label label_5 = new Label(group_1, SWT.NONE);
		label_5.setText("E-mail:");
		label_5.setBounds(234, 35, 55, 15);
		
		Label label_6 = new Label(group_1, SWT.NONE);
		label_6.setText("Broj telefona:");
		label_6.setBounds(234, 56, 82, 15);
		
		text_1 = new Text(group_1, SWT.BORDER);
		text_1.setBounds(118, 32, 90, 21);
		
		text_2 = new Text(group_1, SWT.BORDER);
		text_2.setBounds(118, 56, 90, 21);
		
		text_3 = new Text(group_1, SWT.BORDER);
		text_3.setBounds(118, 82, 90, 21);
		
		text_5 = new Text(group_1, SWT.BORDER);
		text_5.setBounds(316, 32, 90, 21);
		
		text_6 = new Text(group_1, SWT.BORDER);
		text_6.setBounds(316, 56, 90, 21);
		
		Button button_3 = new Button(group_1, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell ();
				MessageDialog.openInformation(shell, "Izmjena klijenta", "Podaci o klijentu su uspješno izmijenjeni.");
			}
		});
		button_3.setText("Izmjeni");
		button_3.setImage(SWTResourceManager.getImage(KlijentiIzmjenaForm.class, "/images/1398203169_change_user.png"));
		button_3.setBounds(483, 35, 102, 50);
		
		Label lblAdresa = new Label(group_1, SWT.NONE);
		lblAdresa.setText("Adresa:");
		lblAdresa.setBounds(25, 85, 55, 15);
		
		Button button_1 = new Button(this, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		button_1.setText("OK");
		button_1.setImage(SWTResourceManager.getImage(KlijentiIzmjenaForm.class, "/images/1398195801_tick_32.png"));
		button_1.setBounds(355, 402, 116, 42);
		
		Button button_2 = new Button(this, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		button_2.setText("Izlaz");
		button_2.setImage(SWTResourceManager.getImage(KlijentiIzmjenaForm.class, "/images/1398195841_DeleteRed.png"));
		button_2.setBounds(487, 402, 116, 42);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
