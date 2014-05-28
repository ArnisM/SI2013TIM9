package org.eclipse.wb.swt;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class PretragaKlijenataForm {

	protected Shell shlPretragaIIspis;
	private Text text;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PretragaKlijenataForm window = new PretragaKlijenataForm();
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
		shlPretragaIIspis.open();
		shlPretragaIIspis.layout();
		while (!shlPretragaIIspis.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlPretragaIIspis = new Shell();
		shlPretragaIIspis.setImage(SWTResourceManager.getImage("src/1396674421_Streamline-61.png"));
		shlPretragaIIspis.setSize(631, 445);
		shlPretragaIIspis.setText("Pretraga i ispis fizi\u010Dkih lica");
		
		Group group = new Group(shlPretragaIIspis, SWT.NONE);
		group.setText("Pretraga");
		group.setBounds(10, 10, 575, 107);
		
		Combo combo = new Combo(group, SWT.NONE);
		combo.setItems(new String[] {"Ime", "Prezime", "Korisni\u010Dko ime", "E-mail", "Uloga"});
		combo.setBounds(112, 35, 142, 23);
		combo.setText("Ime");
		
		Label label = new Label(group, SWT.NONE);
		label.setText("Kirterij pretrage:");
		label.setBounds(10, 38, 96, 15);
		
		text = new Text(group, SWT.BORDER);
		text.setBounds(380, 35, 163, 21);
		
		Label label_1 = new Label(group, SWT.NONE);
		label_1.setText("Unesite ime:");
		label_1.setBounds(292, 38, 65, 15);
		
		Button button = new Button(group, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
				MessageDialog.openInformation(shell, "Pretraga klijenata", "Uspješno je izvršena pretraga klijenata na osnovu odabranog kriterija.");
			}
		});
		button.setText("Pretraga");
		button.setImage(SWTResourceManager.getImage("src/1398199827_search_magnifying_glass_find.png"));
		button.setBounds(427, 62, 116, 35);
		
		Button button_1 = new Button(shlPretragaIIspis, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
				MessageDialog.openInformation(shell, "Generiši .pdf", "Uspješno je generisan .pdf dokument za odabranog klijenta.");
			
			}
		});
		button_1.setText("Generi\u0161i .pdf");
		button_1.setImage(SWTResourceManager.getImage("src/1398206257_pdf.png"));
		button_1.setBounds(10, 350, 119, 47);
		
		table = new Table(shlPretragaIIspis, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 143, 595, 195);
		
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
		
		Label label_2 = new Label(shlPretragaIIspis, SWT.NONE);
		label_2.setText("Ozna\u010Dite \u017Eeljeni red:");
		label_2.setBounds(10, 123, 154, 15);
		
		Button button_2 = new Button(shlPretragaIIspis, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlPretragaIIspis.close();
			}
		});
		button_2.setText("OK");
		button_2.setImage(SWTResourceManager.getImage("src/1398195801_tick_32.png"));
		button_2.setBounds(362, 352, 116, 42);
		
		Button button_3 = new Button(shlPretragaIIspis, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlPretragaIIspis.close();
			}
		});
		button_3.setText("Izlaz");
		button_3.setImage(SWTResourceManager.getImage("src/1398195841_DeleteRed.png"));
		button_3.setBounds(484, 352, 116, 42);

	}

}
