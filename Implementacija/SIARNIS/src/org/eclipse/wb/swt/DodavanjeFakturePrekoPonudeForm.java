package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
//import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class DodavanjeFakturePrekoPonudeForm {

	protected Shell shlDodavanjeFaktureNa;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DodavanjeFakturePrekoPonudeForm window = new DodavanjeFakturePrekoPonudeForm();
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
		shlDodavanjeFaktureNa.open();
		shlDodavanjeFaktureNa.layout();
		while (!shlDodavanjeFaktureNa.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlDodavanjeFaktureNa = new Shell();
		shlDodavanjeFaktureNa.setImage(SWTResourceManager.getImage("src/1396674611_invoice.png"));
		shlDodavanjeFaktureNa.setSize(610, 485);
		shlDodavanjeFaktureNa.setText("Dodavanje fakture na osnovu ponude");
		
		Group grpPretragaPonude = new Group(shlDodavanjeFaktureNa, SWT.NONE);
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
		button.setImage(SWTResourceManager.getImage("src/1398199827_search_magnifying_glass_find.png"));
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
		
		table = new Table(shlDodavanjeFaktureNa, SWT.BORDER | SWT.FULL_SELECTION);
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
		
		Button btnKreirajFakturu = new Button(shlDodavanjeFaktureNa, SWT.NONE);
		btnKreirajFakturu.setText("Kreiraj fakturu");
		btnKreirajFakturu.setImage(SWTResourceManager.getImage("src/1398629480_Generate-tables.png"));
		btnKreirajFakturu.setBounds(317, 395, 136, 42);
		
		Button button_2 = new Button(shlDodavanjeFaktureNa, SWT.NONE);
		button_2.setText("Izlaz");
		button_2.setImage(SWTResourceManager.getImage("src/1398195841_DeleteRed.png"));
		button_2.setBounds(459, 395, 126, 42);
		
		Label lblIzaberiteeljenuPonudu = new Label(shlDodavanjeFaktureNa, SWT.NONE);
		lblIzaberiteeljenuPonudu.setBounds(10, 194, 136, 15);
		lblIzaberiteeljenuPonudu.setText("Izaberite \u017Eeljenu ponudu:");

	}

}
