package ba.unsa.etf.si2013.tim9.Ponude;

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
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import ba.unsa.etf.si2013.tim9.Fakture.FaktureStavkeDodavanjeForm;

public class PonudeTrenutnaIzmjenaForm extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
//	protected Shell this;
	private Table table;
	private Text text_dodatni_zahtjevi;
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			PonudeTrenutnaIzmjenaForm shell = new PonudeTrenutnaIzmjenaForm(
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
	public PonudeTrenutnaIzmjenaForm(Display display) {
		super(display, SWT.SHELL_TRIM);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
//		this = new Shell();
		this.setImage(SWTResourceManager.getImage(PonudeTrenutnaIzmjenaForm.class, "/images/1396674680_document_text.png"));
		this.setSize(697, 677);
		this.setText("Izmjena ponude");
		
		Group grpKlijent = new Group(this, SWT.NONE);
		grpKlijent.setText("Klijent");
		grpKlijent.setBounds(10, 10, 649, 123);
		
		Group grpOdabir = new Group(grpKlijent, SWT.NONE);
		grpOdabir.setText("Odabir");
		grpOdabir.setBounds(10, 20, 123, 82);
		final Label lblIzaberiteFirmu = new Label(grpKlijent, SWT.NONE);
		lblIzaberiteFirmu.setBounds(170, 36, 137, 15);
		lblIzaberiteFirmu.setText("Unesite naziv firme:");
		
		final Combo combo = new Combo(grpKlijent, SWT.NONE);
		combo.setItems(new String[] {"Mercator", "Interex", "Bh Telecom", "Telemach"});
		combo.setBounds(313, 33, 154, 23);
		combo.setText("Mercator");
		
		Button btnFirma = new Button(grpOdabir, SWT.RADIO);
		btnFirma.setSelection(true);
		btnFirma.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblIzaberiteFirmu.setVisible(false);
				combo.setVisible(false);
				
			}
		});
		btnFirma.setBounds(10, 23, 90, 16);
		btnFirma.setText("Firma");
		
		
		
		Button btnFizikoLice = new Button(grpOdabir, SWT.RADIO);
		btnFizikoLice.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblIzaberiteFirmu.setVisible(false);
				combo.setVisible(false);
			}
		});
		btnFizikoLice.setBounds(10, 56, 90, 16);
		btnFizikoLice.setText("Fizi\u010Dko lice");
		
		
		
		
		
		Label lblStavkeFakture = new Label(this, SWT.NONE);
		lblStavkeFakture.setBounds(10, 158, 132, 15);
		lblStavkeFakture.setText("Dodavanje stavki ponude:");
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
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
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			//	FaktureStavkeDodavanjeForm a = new FaktureStavkeDodavanjeForm(null);
			//	a.open();
//				DodavanjeStavkiFaktureForm f =new DodavanjeStavkiFaktureForm();
//				f.open();
			}
		});
		btnNewButton.setImage(SWTResourceManager.getImage(PonudeTrenutnaIzmjenaForm.class, "/images/1398624464_plus-sign.png"));
		btnNewButton.setBounds(148, 146, 120, 38);
		btnNewButton.setText("Dodaj stavku");
		
		Button button = new Button(this, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
				MessageDialog.openInformation(shell, "Info", "Uspjesno je generisan '.pdf' ponude.");
			}
		});
		button.setText("Generi\u0161i .pdf");
		button.setImage(SWTResourceManager.getImage(PonudeTrenutnaIzmjenaForm.class, "/images/1398206257_pdf.png"));
		button.setBounds(10, 591, 132, 42);
		
		Button btnIzmjeni = new Button(this, SWT.NONE);
		btnIzmjeni.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
				
ControlDecoration odabirFirmeError = new ControlDecoration(combo, SWT.RIGHT | SWT.TOP);
				
				if (combo.getText().length()<3 || combo.getText()==""){
					odabirFirmeError.setDescriptionText("Niste odabrali firme!");
					FieldDecoration nazivFirmeField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					odabirFirmeError.setImage(nazivFirmeField.getImage());
					odabirFirmeError.showHoverText("Niste odabrali firme!");
				}
				
				ControlDecoration dodatniZahtjeviError = new ControlDecoration(text_dodatni_zahtjevi, SWT.RIGHT | SWT.TOP);
				if (text_dodatni_zahtjevi.getText()==""){
					dodatniZahtjeviError.setDescriptionText("Niste unijeli dodatne zahtjeve vezane za ponudu!");
					FieldDecoration dodatniZahtjevi = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					dodatniZahtjeviError.setImage(dodatniZahtjevi.getImage());
					dodatniZahtjeviError.showHoverText("Niste unijeli dodatne zahtjeve vezane za ponudu!");
				}
				
				MessageDialog.openInformation(shell, "Info", "Uspjesno je izmjenjena ponuda.");
			}
		});
		btnIzmjeni.setText("Izmjeni!");
		btnIzmjeni.setImage(SWTResourceManager.getImage(PonudeTrenutnaIzmjenaForm.class, "/images/1398574614_switch_on.png"));
		btnIzmjeni.setBounds(431, 591, 116, 42);
		
		Button button_2 = new Button(this, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		button_2.setText("Izlaz");
		button_2.setImage(SWTResourceManager.getImage(PonudeTrenutnaIzmjenaForm.class, "/images/1398195841_DeleteRed.png"));
		button_2.setBounds(554, 591, 116, 42);
		
		text_dodatni_zahtjevi = new Text(this, SWT.BORDER);
		text_dodatni_zahtjevi.setBounds(10, 441, 611, 135);
		
		Label lblDodatniZahtjeviVezani = new Label(this, SWT.NONE);
		lblDodatniZahtjeviVezani.setBounds(10, 420, 258, 15);
		lblDodatniZahtjeviVezani.setText("Dodatni zahtjevi vezani za ponudu(tekstualno):");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
