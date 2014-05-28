package org.eclipse.wb.swt;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
//import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

public class IzmjenaFaktureTrenutneForm {

	protected Shell shlIzmjenaTrenutne;
	private Table table;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			IzmjenaFaktureTrenutneForm window = new IzmjenaFaktureTrenutneForm();
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
		shlIzmjenaTrenutne.open();
		shlIzmjenaTrenutne.layout();
		while (!shlIzmjenaTrenutne.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlIzmjenaTrenutne = new Shell();
		shlIzmjenaTrenutne.setImage(SWTResourceManager.getImage("src/1396674611_invoice.png"));
		shlIzmjenaTrenutne.setSize(697, 677);
		shlIzmjenaTrenutne.setText("Izmjena fakture");
		
		Group grpKlijent = new Group(shlIzmjenaTrenutne, SWT.NONE);
		grpKlijent.setText("Klijent");
		grpKlijent.setBounds(10, 10, 649, 123);
		
		Group grpOdabir = new Group(grpKlijent, SWT.NONE);
		grpOdabir.setText("Odabir");
		grpOdabir.setBounds(10, 20, 123, 82);
		
		Button btnFirma = new Button(grpOdabir, SWT.RADIO);
		btnFirma.setSelection(true);
		btnFirma.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnFirma.setBounds(10, 23, 90, 16);
		btnFirma.setText("Firma");
		
		Button btnFizikoLice = new Button(grpOdabir, SWT.RADIO);
		btnFizikoLice.setBounds(10, 56, 90, 16);
		btnFizikoLice.setText("Fizi\u010Dko lice");
		
		Combo combo = new Combo(grpKlijent, SWT.NONE);
		combo.setBounds(271, 33, 154, 23);
		combo.setText("Mercator");
		
		Label lblIzaberiteFirmu = new Label(grpKlijent, SWT.NONE);
		lblIzaberiteFirmu.setBounds(170, 36, 95, 15);
		lblIzaberiteFirmu.setText("Odaberite firmu:");
		
		Label lblStavkeFakture = new Label(shlIzmjenaTrenutne, SWT.NONE);
		lblStavkeFakture.setBounds(10, 158, 132, 15);
		lblStavkeFakture.setText("Dodavanje stavki fakture:");
		
		table = new Table(shlIzmjenaTrenutne, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 194, 660, 207);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnRedniBr = new TableColumn(table, SWT.NONE);
		tblclmnRedniBr.setWidth(62);
		tblclmnRedniBr.setText("Redni br.");
		
		TableColumn tblclmnNazivUsluge = new TableColumn(table, SWT.NONE);
		tblclmnNazivUsluge.setWidth(100);
		tblclmnNazivUsluge.setText("Naziv usluge");
		
		TableColumn tblclmnOpis = new TableColumn(table, SWT.NONE);
		tblclmnOpis.setWidth(217);
		tblclmnOpis.setText("Opis");
		
		TableColumn tblclmnJedCijenaBez = new TableColumn(table, SWT.NONE);
		tblclmnJedCijenaBez.setWidth(123);
		tblclmnJedCijenaBez.setText("Jed. cijena bez pdv");
		
		TableColumn tblclmnKol = new TableColumn(table, SWT.NONE);
		tblclmnKol.setWidth(59);
		tblclmnKol.setText("Kol.");
		
		TableColumn tblclmnCijenaSaPdv = new TableColumn(table, SWT.NONE);
		tblclmnCijenaSaPdv.setWidth(94);
		tblclmnCijenaSaPdv.setText("Cijena sa pdv");
		
		Button btnNewButton = new Button(shlIzmjenaTrenutne, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DodavanjeStavkiFaktureForm f =new DodavanjeStavkiFaktureForm();
				f.open();
			}
		});
		btnNewButton.setImage(SWTResourceManager.getImage("src/1398624464_plus-sign.png"));
		btnNewButton.setBounds(148, 146, 120, 38);
		btnNewButton.setText("Dodaj stavku");
		
		Button button = new Button(shlIzmjenaTrenutne, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
				MessageDialog.openInformation(shell, "Info", "Uspjesno je generisan '.pdf' fakture.");
			}
		});
		button.setText("Generi\u0161i .pdf");
		button.setImage(SWTResourceManager.getImage("src/1398206257_pdf.png"));
		button.setBounds(10, 591, 132, 42);
		
		Button btnIzmjeni = new Button(shlIzmjenaTrenutne, SWT.NONE);
		btnIzmjeni.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
				MessageDialog.openInformation(shell, "Info", "Uspjesno je izmjenjena faktura.");
			}
		});
		btnIzmjeni.setText("Izmjeni!");
		btnIzmjeni.setImage(SWTResourceManager.getImage("src/1398574614_switch_on.png"));
		btnIzmjeni.setBounds(431, 591, 116, 42);
		
		Button button_2 = new Button(shlIzmjenaTrenutne, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlIzmjenaTrenutne.close();
			}
		});
		button_2.setText("Izlaz");
		button_2.setImage(SWTResourceManager.getImage("src/1398195841_DeleteRed.png"));
		button_2.setBounds(554, 591, 116, 42);
		
		text = new Text(shlIzmjenaTrenutne, SWT.BORDER);
		text.setBounds(10, 441, 611, 135);
		
		Label lblDodatniZahtjeviVezani = new Label(shlIzmjenaTrenutne, SWT.NONE);
		lblDodatniZahtjeviVezani.setBounds(10, 420, 258, 15);
		lblDodatniZahtjeviVezani.setText("Dodatni zahtjevi vezani za fakturu(tekstualno):");

	}
}
