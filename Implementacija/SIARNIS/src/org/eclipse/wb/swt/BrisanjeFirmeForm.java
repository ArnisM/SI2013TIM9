package org.eclipse.wb.swt;

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

public class BrisanjeFirmeForm {

	protected Shell shlBrisanjeFirme;
	private Text text;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BrisanjeFirmeForm window = new BrisanjeFirmeForm();
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
		shlBrisanjeFirme.open();
		shlBrisanjeFirme.layout();
		while (!shlBrisanjeFirme.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlBrisanjeFirme = new Shell();
		shlBrisanjeFirme.setImage(SWTResourceManager.getImage("src/1396674421_Streamline-61.png"));
		shlBrisanjeFirme.setSize(652, 444);
		shlBrisanjeFirme.setText("Brisanje firme");
		
		Group group = new Group(shlBrisanjeFirme, SWT.NONE);
		group.setText("Pretraga");
		group.setBounds(10, 10, 575, 107);
		
		Combo combo = new Combo(group, SWT.NONE);
		combo.setItems(new String[] {"Ime", "Prezime", "Korisni\u010Dko ime", "E-mail", "Uloga"});
		combo.setBounds(112, 35, 142, 23);
		combo.setText("PDV broj");
		
		Label label = new Label(group, SWT.NONE);
		label.setText("Kirterij pretrage:");
		label.setBounds(10, 38, 96, 15);
		
		text = new Text(group, SWT.BORDER);
		text.setBounds(380, 35, 163, 21);
		
		final Label lblUnesiPdvBroj = new Label(group, SWT.NONE);
		lblUnesiPdvBroj.setText("Unesi PDV broj:");
		lblUnesiPdvBroj.setBounds(280, 38, 96, 15);
		
		Button button = new Button(group, SWT.NONE);
		button.setText("Pretraga");
		button.setImage(SWTResourceManager.getImage("src/1398199827_search_magnifying_glass_find.png"));
		button.setBounds(427, 62, 116, 35);
		
		table = new Table(shlBrisanjeFirme, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 158, 626, 179);
		
		TableColumn tblclmnNazivFirme = new TableColumn(table, SWT.NONE);
		tblclmnNazivFirme.setWidth(100);
		tblclmnNazivFirme.setText("Naziv firme");
		
		TableColumn tblclmnPdvBroj = new TableColumn(table, SWT.NONE);
		tblclmnPdvBroj.setWidth(100);
		tblclmnPdvBroj.setText("PDV broj");
		
		TableColumn tblclmnIdpdvBroj = new TableColumn(table, SWT.NONE);
		tblclmnIdpdvBroj.setWidth(100);
		tblclmnIdpdvBroj.setText("IDPDV broj");
		
		TableColumn tblclmnAdresa = new TableColumn(table, SWT.NONE);
		tblclmnAdresa.setWidth(100);
		tblclmnAdresa.setText("Adresa");
		
		TableColumn tableColumn_4 = new TableColumn(table, SWT.NONE);
		tableColumn_4.setWidth(120);
		tableColumn_4.setText("Broj telefona");
		
		TableColumn tblclmnEmail = new TableColumn(table, SWT.NONE);
		tblclmnEmail.setWidth(100);
		tblclmnEmail.setText("E-mail");
		
		Button button_1 = new Button(shlBrisanjeFirme, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
		});
		button_1.setText("Bri\u0161i");
		button_1.setImage(SWTResourceManager.getImage("src/1398201739_Trash.png"));
		button_1.setBounds(361, 350, 123, 46);
		
		Button button_2 = new Button(shlBrisanjeFirme, SWT.NONE);
		button_2.setText("Izlaz");
		button_2.setImage(SWTResourceManager.getImage("src/1398195841_DeleteRed.png"));
		button_2.setBounds(503, 350, 123, 46);
		
		Label lblOznaiteeljeneFirme = new Label(shlBrisanjeFirme, SWT.NONE);
		lblOznaiteeljeneFirme.setText("Ozna\u010Dite \u017Eeljene firme:");
		lblOznaiteeljeneFirme.setBounds(10, 137, 154, 15);

	}

}
