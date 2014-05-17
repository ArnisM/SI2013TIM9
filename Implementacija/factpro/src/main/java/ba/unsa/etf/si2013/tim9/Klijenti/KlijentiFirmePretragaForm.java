package ba.unsa.etf.si2013.tim9.Klijenti;

import org.eclipse.swt.SWT;
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

public class KlijentiFirmePretragaForm extends Shell {

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
			KlijentiFirmePretragaForm shell = new KlijentiFirmePretragaForm(
					display);
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
	public KlijentiFirmePretragaForm(Display display) {
		super(display, SWT.SHELL_TRIM);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
//		this = new Shell();
		this.setImage(SWTResourceManager.getImage(KlijentiFirmePretragaForm.class, "/images/1396674421_Streamline-61.png"));
		this.setSize(653, 421);
		this.setText("Pretraga i ispis firmi");
		
		Button button = new Button(this, SWT.NONE);
		button.setText("Generi\u0161i .pdf");
		button.setImage(SWTResourceManager.getImage(KlijentiFirmePretragaForm.class, "/images/1398206257_pdf.png"));
		button.setBounds(5, 329, 119, 47);
		
		Button button_1 = new Button(this, SWT.NONE);
		button_1.setText("OK");
		button_1.setImage(SWTResourceManager.getImage(KlijentiFirmePretragaForm.class, "/images/1398195801_tick_32.png"));
		button_1.setBounds(376, 331, 116, 42);
		
		Button button_2 = new Button(this, SWT.NONE);
		button_2.setText("Izlaz");
		button_2.setImage(SWTResourceManager.getImage(KlijentiFirmePretragaForm.class, "/images/1398195841_DeleteRed.png"));
		button_2.setBounds(511, 331, 116, 42);
		
		Group group = new Group(this, SWT.NONE);
		group.setText("Pretraga");
		group.setBounds(5, 10, 575, 107);
		
		Combo combo = new Combo(group, SWT.NONE);
		combo.setItems(new String[] {"Ime", "Prezime", "Korisni\u010Dko ime", "E-mail", "Uloga"});
		combo.setBounds(112, 35, 142, 23);
		combo.setText("PDV broj");
		
		Label label = new Label(group, SWT.NONE);
		label.setText("Kirterij pretrage:");
		label.setBounds(10, 38, 96, 15);
		
		text = new Text(group, SWT.BORDER);
		text.setBounds(380, 35, 163, 21);
		
		Label label_1 = new Label(group, SWT.NONE);
		label_1.setText("Unesi PDV broj:");
		label_1.setBounds(280, 38, 96, 15);
		
		Button button_3 = new Button(group, SWT.NONE);
		button_3.setText("Pretraga");
		button_3.setImage(SWTResourceManager.getImage(KlijentiFirmePretragaForm.class, "/images/1398199827_search_magnifying_glass_find.png"));
		button_3.setBounds(427, 62, 116, 35);
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(5, 126, 626, 179);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("Naziv firme");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("PDV broj");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("IDPDV broj");
		
		TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(100);
		tableColumn_3.setText("Adresa");
		
		TableColumn tableColumn_4 = new TableColumn(table, SWT.NONE);
		tableColumn_4.setWidth(120);
		tableColumn_4.setText("Broj telefona");
		
		TableColumn tableColumn_5 = new TableColumn(table, SWT.NONE);
		tableColumn_5.setWidth(100);
		tableColumn_5.setText("E-mail");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
