package org.eclipse.wb.swt;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class DodavanjeUslugaForm {

	protected Shell shlDodavanjeUsluga;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DodavanjeUslugaForm window = new DodavanjeUslugaForm();
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
		shlDodavanjeUsluga.open();
		shlDodavanjeUsluga.layout();
		while (!shlDodavanjeUsluga.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlDodavanjeUsluga = new Shell();
		shlDodavanjeUsluga.setImage(SWTResourceManager.getImage("src/1396674353_services.png"));
		shlDodavanjeUsluga.setSize(393, 540);
		shlDodavanjeUsluga.setText("Dodavanje usluga");
		
		Label lblNazivUsluge = new Label(shlDodavanjeUsluga, SWT.NONE);
		lblNazivUsluge.setBounds(28, 58, 78, 15);
		lblNazivUsluge.setText("Naziv usluge:");
		
		text = new Text(shlDodavanjeUsluga, SWT.BORDER);
		text.setBounds(112, 55, 246, 21);
		
		Group grpTipUsluge = new Group(shlDodavanjeUsluga, SWT.NONE);
		grpTipUsluge.setText("Tip usluge");
		grpTipUsluge.setBounds(28, 104, 252, 82);
		
		Button btnServis = new Button(grpTipUsluge, SWT.RADIO);
		btnServis.setBounds(88, 22, 90, 16);
		btnServis.setText("Servis");
		
		Button btnKonsultacije = new Button(grpTipUsluge, SWT.RADIO);
		btnKonsultacije.setBounds(88, 56, 90, 16);
		btnKonsultacije.setText("Konsultacije");
		
		text_1 = new Text(shlDodavanjeUsluga, SWT.BORDER);
		text_1.setBounds(28, 288, 330, 141);
		
		Label lblOpisUsluge = new Label(shlDodavanjeUsluga, SWT.NONE);
		lblOpisUsluge.setText("Opis usluge:");
		lblOpisUsluge.setBounds(28, 267, 78, 15);
		
		Label lblCijenaUsluge = new Label(shlDodavanjeUsluga, SWT.NONE);
		lblCijenaUsluge.setBounds(28, 195, 100, 15);
		lblCijenaUsluge.setText("Cijena usluge(KM):");
		
		Spinner spinner = new Spinner(shlDodavanjeUsluga, SWT.BORDER);
		spinner.setBounds(189, 192, 91, 22);
		
		Label lblTroakIzvrenjakm = new Label(shlDodavanjeUsluga, SWT.NONE);
		lblTroakIzvrenjakm.setText("Tro\u0161ak izvr\u0161enja usluge(KM):");
		lblTroakIzvrenjakm.setBounds(28, 234, 150, 15);
		
		Spinner spinner_1 = new Spinner(shlDodavanjeUsluga, SWT.BORDER);
		spinner_1.setBounds(189, 227, 91, 22);
		
		Button btnDodaj = new Button(shlDodavanjeUsluga, SWT.NONE);
		btnDodaj.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
				MessageDialog.openInformation(shell, "Doodavanje usluga", "Usluga je uspješno dodana.");
			}
		});
		btnDodaj.setText("Dodaj");
		btnDodaj.setImage(SWTResourceManager.getImage("src/1398195801_tick_32.png"));
		btnDodaj.setBounds(112, 450, 116, 42);
		
		Button button_1 = new Button(shlDodavanjeUsluga, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlDodavanjeUsluga.close();
			}
		});
		button_1.setText("Izlaz");
		button_1.setImage(SWTResourceManager.getImage("src/1398195841_DeleteRed.png"));
		button_1.setBounds(242, 450, 116, 42);

	}
}
