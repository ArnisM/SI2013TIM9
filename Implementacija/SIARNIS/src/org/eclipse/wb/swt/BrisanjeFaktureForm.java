package org.eclipse.wb.swt;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class BrisanjeFaktureForm {

	protected Shell shlBrisanjeFakture;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BrisanjeFaktureForm window = new BrisanjeFaktureForm();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlBrisanjeFakture.open();
		shlBrisanjeFakture.layout();
		while (!shlBrisanjeFakture.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlBrisanjeFakture = new Shell();
		shlBrisanjeFakture.setImage(SWTResourceManager.getImage("src/1396674611_invoice.png"));
		shlBrisanjeFakture.setSize(612, 469);
		shlBrisanjeFakture.setText("Brisanje fakture");
		
		Group group = new Group(shlBrisanjeFakture, SWT.NONE);
		group.setText("Pretraga fakture");
		group.setBounds(10, 0, 575, 162);
		
		Combo combo = new Combo(group, SWT.NONE);
		combo.setItems(new String[] {"Naziv Firme", "PDV broj"});
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
				MessageDialog.openInformation(shell, "Info", "Uspje�no je izvr�ena pretraga. Listu klijenata mo�ete vidjeti u tabeli ispod.");
			}
		});
		button.setText("Pretraga");
		button.setImage(SWTResourceManager.getImage("src/1398199827_search_magnifying_glass_find.png"));
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
		combo_1.setText("Interex");
		
		Label label_1 = new Label(group, SWT.NONE);
		label_1.setText("Odabir firme:");
		label_1.setBounds(302, 87, 91, 15);
		
		table = new Table(shlBrisanjeFakture, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 193, 575, 179);
		
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
		
		Label label_2 = new Label(shlBrisanjeFakture, SWT.NONE);
		label_2.setText("Izaberite \u017Eeljenu fakturu:");
		label_2.setBounds(10, 177, 136, 15);
		
		Button btnBrii = new Button(shlBrisanjeFakture, SWT.NONE);
		btnBrii.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				Shell shell = new Shell();
				MessageDialog.openInformation(shell, "Info", "Uspje�no je obrisana faktura.");
				
			}
		});
		btnBrii.setText("Bri\u0161i");
		btnBrii.setImage(SWTResourceManager.getImage("src/1398201739_Trash.png"));
		btnBrii.setBounds(346, 379, 116, 42);
		
		Button button_4 = new Button(shlBrisanjeFakture, SWT.NONE);
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				shlBrisanjeFakture.close();
				
			}
		});
		button_4.setText("Izlaz");
		button_4.setImage(SWTResourceManager.getImage("src/1398195841_DeleteRed.png"));
		button_4.setBounds(469, 379, 116, 42);

	}

}
