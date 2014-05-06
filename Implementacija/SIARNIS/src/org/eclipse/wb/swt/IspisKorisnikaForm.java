package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class IspisKorisnikaForm {

	protected Shell shlIspisKorisnika;
	private Table table;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			IspisKorisnikaForm window = new IspisKorisnikaForm();
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
		shlIspisKorisnika.open();
		shlIspisKorisnika.layout();
		while (!shlIspisKorisnika.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlIspisKorisnika = new Shell();
		shlIspisKorisnika.setImage(SWTResourceManager.getImage("src/1396674475_user_male2.png"));
		shlIspisKorisnika.setSize(661, 446);
		shlIspisKorisnika.setText("Ispis korisnika");
		
		table = new Table(shlIspisKorisnika, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 151, 626, 184);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("Ime");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("Prezime");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("Korisni\u010Dko ime");
		
		TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(100);
		tableColumn_3.setText("E-mail");
		
		TableColumn tableColumn_4 = new TableColumn(table, SWT.NONE);
		tableColumn_4.setWidth(120);
		tableColumn_4.setText("Broj telefona");
		
		TableColumn tableColumn_5 = new TableColumn(table, SWT.NONE);
		tableColumn_5.setWidth(100);
		tableColumn_5.setText("Uloga");
		
		Group group = new Group(shlIspisKorisnika, SWT.NONE);
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
		button.setText("Pretraga");
		button.setImage(SWTResourceManager.getImage("src/1398199827_search_magnifying_glass_find.png"));
		button.setBounds(427, 62, 116, 35);
		
		Label lblOznaiteeljeniKorisnike = new Label(shlIspisKorisnika, SWT.NONE);
		lblOznaiteeljeniKorisnike.setText("Ozna\u010Dite \u017Eeljene korisnike:");
		lblOznaiteeljeniKorisnike.setBounds(10, 130, 154, 15);
		
		Button btnNewButton = new Button(shlIspisKorisnika, SWT.NONE);
		btnNewButton.setImage(SWTResourceManager.getImage("src/1398206257_pdf.png"));
		btnNewButton.setBounds(370, 352, 119, 47);
		btnNewButton.setText("Generi\u0161i .pdf");
		
		Button btnIzlaz = new Button(shlIspisKorisnika, SWT.NONE);
		btnIzlaz.setImage(SWTResourceManager.getImage("src/1398195841_DeleteRed.png"));
		btnIzlaz.setText("Izlaz");
		btnIzlaz.setBounds(495, 352, 124, 47);

	}

}
