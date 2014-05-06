package org.eclipse.wb.swt;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Canvas;

public class DodavanjeKorisnikaForm {

	protected Shell shlDodavanjeKorisnika;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DodavanjeKorisnikaForm window = new DodavanjeKorisnikaForm();
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
		shlDodavanjeKorisnika.open();
		shlDodavanjeKorisnika.layout();
		while (!shlDodavanjeKorisnika.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlDodavanjeKorisnika = new Shell();
		shlDodavanjeKorisnika.setImage(SWTResourceManager.getImage("src/1396674475_user_male2.png"));
		shlDodavanjeKorisnika.setSize(461, 455);
		shlDodavanjeKorisnika.setText("Dodavanje korisnika");
		
		Group group = new Group(shlDodavanjeKorisnika, SWT.NONE);
		group.setBounds(10, 10, 424, 347);
		
		Label lblIme = new Label(group, SWT.NONE);
		lblIme.setBounds(37, 40, 55, 15);
		lblIme.setText("Ime:");
		
		Label lblPrezime = new Label(group, SWT.NONE);
		lblPrezime.setBounds(37, 75, 55, 15);
		lblPrezime.setText("Prezime:");
		
		Label lblNewLabel = new Label(group, SWT.NONE);
		lblNewLabel.setBounds(37, 109, 55, 15);
		lblNewLabel.setText("E-mail:");
		
		Label lblNewLabel_1 = new Label(group, SWT.NONE);
		lblNewLabel_1.setBounds(37, 140, 75, 15);
		lblNewLabel_1.setText("Broj telefona:");
		
		Label lblKorisnikoIme = new Label(group, SWT.NONE);
		lblKorisnikoIme.setBounds(37, 172, 87, 15);
		lblKorisnikoIme.setText("Korisni\u010Dko ime:");
		
		Label lblifra = new Label(group, SWT.NONE);
		lblifra.setBounds(37, 201, 55, 15);
		lblifra.setText("\u0160ifra:");
		
		Label lblPonoviteifru = new Label(group, SWT.NONE);
		lblPonoviteifru.setBounds(37, 232, 87, 15);
		lblPonoviteifru.setText("Ponovite \u0161ifru:");
		
		Group grpOdabirUloge = new Group(group, SWT.NONE);
		grpOdabirUloge.setText("Odabir uloge");
		grpOdabirUloge.setBounds(37, 263, 220, 67);
		
		Button btnOperater = new Button(grpOdabirUloge, SWT.RADIO);
		btnOperater.setBounds(25, 30, 90, 16);
		btnOperater.setText("Operater");
		
		Button btnRukovodilac = new Button(grpOdabirUloge, SWT.RADIO);
		btnRukovodilac.setBounds(107, 30, 90, 16);
		btnRukovodilac.setText("Rukovodilac");
		
		text = new Text(group, SWT.BORDER);
		text.setBounds(131, 37, 126, 21);
		
		text_1 = new Text(group, SWT.BORDER);
		text_1.setBounds(131, 72, 126, 21);
		
		text_2 = new Text(group, SWT.BORDER);
		text_2.setBounds(131, 106, 126, 21);
		
		text_3 = new Text(group, SWT.BORDER);
		text_3.setBounds(131, 140, 126, 21);
		
		text_4 = new Text(group, SWT.BORDER);
		text_4.setBounds(131, 172, 126, 21);
		
		text_5 = new Text(group, SWT.BORDER);
		text_5.setBounds(131, 201, 126, 21);
		
		text_6 = new Text(group, SWT.BORDER);
		text_6.setBounds(131, 232, 126, 21);
		
		Canvas canvas = new Canvas(group, SWT.NONE);
		canvas.setBounds(281, 37, 118, 141);
		
		Button btnIzaberiSliku = new Button(group, SWT.NONE);
		btnIzaberiSliku.setBounds(304, 184, 75, 25);
		btnIzaberiSliku.setText("Izaberi sliku");
		btnIzaberiSliku.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell=new Shell();
				MessageDialog.openInformation(shell, "Slika", "Otvara se opendialiog za sliku.");
				
			}
		});
		
		Button btnNewButton = new Button(shlDodavanjeKorisnika, SWT.NONE);
		btnNewButton.setImage(SWTResourceManager.getImage("src/1398195801_tick_32.png"));
		btnNewButton.setBounds(160, 369, 117, 38);
		btnNewButton.setText("Dodaj");
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell=new Shell();
				MessageDialog.openInformation(shell, "Dodavanje", "Uspjesno je dodan korisnik.");
				
			}
		});
		
		Button btnNewButton_1 = new Button(shlDodavanjeKorisnika, SWT.NONE);
		btnNewButton_1.setImage(SWTResourceManager.getImage("src/1398195841_DeleteRed.png"));
		btnNewButton_1.setBounds(303, 369, 117, 38);
		btnNewButton_1.setText("Izlaz");
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlDodavanjeKorisnika.close();
			}
		});

	}
}
