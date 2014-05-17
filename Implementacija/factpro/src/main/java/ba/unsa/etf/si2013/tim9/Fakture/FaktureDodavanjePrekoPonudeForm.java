package ba.unsa.etf.si2013.tim9.Fakture;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.wb.swt.SWTResourceManager;

public class FaktureDodavanjePrekoPonudeForm extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
//	protected Shell this;
	private Table table;
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			FaktureDodavanjePrekoPonudeForm shell = new FaktureDodavanjePrekoPonudeForm(
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
	public FaktureDodavanjePrekoPonudeForm(Display display) {
		super(display, SWT.SHELL_TRIM);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
//		this = new Shell();
		this.setImage(SWTResourceManager.getImage(FaktureDodavanjePrekoPonudeForm.class, "/images/1396674611_invoice.png"));
		this.setSize(610, 485);
		this.setText("Dodavanje fakture na osnovu ponude");
		
		Group grpPretragaPonude = new Group(this, SWT.NONE);
		grpPretragaPonude.setText(" Pretraga ponude");
		grpPretragaPonude.setBounds(10, 10, 575, 162);
		
		Combo combo = new Combo(grpPretragaPonude, SWT.NONE);
		combo.setItems(new String[] {"Naziv firme\t", "PDV broj"});
		combo.setBounds(112, 84, 142, 23);
		combo.setText("Naziv firme");
		
		Label label = new Label(grpPretragaPonude, SWT.NONE);
		label.setText("Kirterij pretrage:");
		label.setBounds(10, 87, 96, 15);
		
		Button button = new Button(grpPretragaPonude, SWT.NONE);
		button.setText("Pretraga");
		button.setImage(SWTResourceManager.getImage(FaktureDodavanjePrekoPonudeForm.class, "/images/1398575960_search_magnifying_glass_find.png"));
		button.setBounds(427, 117, 116, 35);
		
		Group grpOdabir = new Group(grpPretragaPonude, SWT.NONE);
		grpOdabir.setText("Odabir");
		grpOdabir.setBounds(10, 22, 142, 56);
		
		Button btnFirma = new Button(grpOdabir, SWT.RADIO);
		btnFirma.setSelection(true);
		btnFirma.setBounds(54, 10, 90, 16);
		btnFirma.setText("Firma");
		
		Button btnFizikoLice = new Button(grpOdabir, SWT.RADIO);
		btnFizikoLice.setBounds(54, 32, 78, 16);
		btnFizikoLice.setText("Fizi\u010Dko lice");
		
		Combo combo_1 = new Combo(grpPretragaPonude, SWT.NONE);
		combo_1.setBounds(394, 84, 149, 23);
		combo_1.setText("Mercator");
		
		Label lblOdabirFirme = new Label(grpPretragaPonude, SWT.NONE);
		lblOdabirFirme.setBounds(302, 87, 91, 15);
		lblOdabirFirme.setText("Odabir firme:");
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 210, 575, 179);
		
		TableColumn tblclmnIdPonude = new TableColumn(table, SWT.NONE);
		tblclmnIdPonude.setWidth(100);
		tblclmnIdPonude.setText("ID ponude");
		
		TableColumn tblclmnNazivFirme = new TableColumn(table, SWT.NONE);
		tblclmnNazivFirme.setWidth(137);
		tblclmnNazivFirme.setText("Ukupna cijena sa pdf");
		
		TableColumn tblclmnDatum = new TableColumn(table, SWT.NONE);
		tblclmnDatum.setWidth(100);
		tblclmnDatum.setText("Datum kreiranja");
		
		TableColumn tblclmnPdvBroj = new TableColumn(table, SWT.NONE);
		tblclmnPdvBroj.setWidth(100);
		tblclmnPdvBroj.setText("Naziv firme");
		
		TableColumn tblclmnPdvBroj_1 = new TableColumn(table, SWT.NONE);
		tblclmnPdvBroj_1.setWidth(132);
		tblclmnPdvBroj_1.setText("PDV broj");
		
		Button btnKreirajFakturu = new Button(this, SWT.NONE);
		btnKreirajFakturu.setText("Kreiraj fakturu");
		btnKreirajFakturu.setImage(SWTResourceManager.getImage(FaktureDodavanjePrekoPonudeForm.class, "/images/1398629480_Generate-tables.png"));
		btnKreirajFakturu.setBounds(317, 395, 136, 42);
		
		Button button_2 = new Button(this, SWT.NONE);
		button_2.setText("Izlaz");
		button_2.setImage(SWTResourceManager.getImage(FaktureDodavanjePrekoPonudeForm.class, "/images/1398195841_DeleteRed.png"));
		button_2.setBounds(459, 395, 126, 42);
		
		Label lblIzaberiteeljenuPonudu = new Label(this, SWT.NONE);
		lblIzaberiteeljenuPonudu.setBounds(10, 194, 136, 15);
		lblIzaberiteeljenuPonudu.setText("Izaberite \u017Eeljenu ponudu:");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
