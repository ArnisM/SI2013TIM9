package ba.unsa.etf.si2013.tim9.Fakture;

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
import org.eclipse.wb.swt.SWTResourceManager;

public class FakturePretragaForm extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
//	protected Shell this;
	private Table table;
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			FakturePretragaForm shell = new FakturePretragaForm(display);
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
	public FakturePretragaForm(Display display) {
		super(display, SWT.SHELL_TRIM);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
//		this = new Shell();
		this.setImage(SWTResourceManager.getImage(FakturePretragaForm.class, "/images/1396674611_invoice.png"));
		this.setSize(623, 479);
		this.setText("Pretraga i ispis fakture");
		
		Group group = new Group(this, SWT.NONE);
		group.setText("Pretraga fakture");
		group.setBounds(10, 10, 575, 162);
		
		Combo combo = new Combo(group, SWT.NONE);
		combo.setItems(new String[] {"Naziv firme\t", "PDV broj"});
		combo.setBounds(112, 84, 142, 23);
		combo.setText("Naziv firme");
		
		Label label = new Label(group, SWT.NONE);
		label.setText("Kirterij pretrage:");
		label.setBounds(10, 87, 96, 15);
		
		Button button = new Button(group, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
				MessageDialog.openInformation(shell, "Info", "Uspješno je izvršena pretraga faktura. Fakture su prikazane u tabeli ispod.");
			
			}
		});
		button.setText("Pretraga");
		button.setImage(SWTResourceManager.getImage(FakturePretragaForm.class, "/images/1398199827_search_magnifying_glass_find.png"));
		button.setBounds(427, 117, 116, 35);
		
		Group group_1 = new Group(group, SWT.NONE);
		group_1.setText("Odabir");
		group_1.setBounds(10, 22, 142, 56);
		
		Button button_1 = new Button(group_1, SWT.RADIO);
		button_1.setText("Firma");
		button_1.setSelection(true);
		button_1.setBounds(54, 10, 90, 16);
		
		Button button_2 = new Button(group_1, SWT.RADIO);
		button_2.setText("Fizi\u010Dko lice");
		button_2.setBounds(54, 32, 78, 16);
		
		Combo combo_1 = new Combo(group, SWT.NONE);
		combo_1.setBounds(394, 84, 149, 23);
		combo_1.setText("Mercator");
		
		Label label_1 = new Label(group, SWT.NONE);
		label_1.setText("Odabir firme:");
		label_1.setBounds(302, 87, 91, 15);
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 194, 575, 179);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("ID fakture");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(137);
		tableColumn_1.setText("Ukupna cijena sa pdf");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("Datum kreiranja");
		
		TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(100);
		tableColumn_3.setText("Naziv firme");
		
		TableColumn tableColumn_4 = new TableColumn(table, SWT.NONE);
		tableColumn_4.setWidth(132);
		tableColumn_4.setText("PDV broj");
		
		Label label_2 = new Label(this, SWT.NONE);
		label_2.setText("Izaberite \u017Eeljenu fakturu:");
		label_2.setBounds(10, 178, 136, 15);
		
		Button button_3 = new Button(this, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		button_3.setText("Izlaz");
		button_3.setImage(SWTResourceManager.getImage(FakturePretragaForm.class, "/images/1398195841_DeleteRed.png"));
		button_3.setBounds(469, 389, 116, 42);
		
		Button button_4 = new Button(this, SWT.NONE);
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
				MessageDialog.openInformation(shell, "Info", "Uspjesno je kreiran '.pdf' fakture.");
			
			}
		});
		button_4.setText("Generi\u0161i .pdf");
		button_4.setImage(SWTResourceManager.getImage(FakturePretragaForm.class, "/images/1398206257_pdf.png"));
		button_4.setBounds(10, 389, 132, 42);
		
		Button btnOk = new Button(this, SWT.NONE);
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
				MessageDialog.openInformation(shell, "Info", "Uspješno je izvršena pretraga faktura.");
			
			}
		});
		btnOk.setText("Ok");
		btnOk.setImage(SWTResourceManager.getImage(FakturePretragaForm.class, "/images/1398195801_tick_32.png"));
		btnOk.setBounds(344, 389, 116, 42);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
