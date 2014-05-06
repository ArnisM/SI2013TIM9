package org.eclipse.wb.swt;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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

public class IzmjenaKorisnikaForm {

	protected Shell shlIzmjenaKorisnika;
	private Text text;
	private Table table;
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
			IzmjenaKorisnikaForm window = new IzmjenaKorisnikaForm();
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
		shlIzmjenaKorisnika.open();
		shlIzmjenaKorisnika.layout();
		while (!shlIzmjenaKorisnika.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlIzmjenaKorisnika = new Shell();
		shlIzmjenaKorisnika.setImage(SWTResourceManager.getImage("src/1396674475_user_male2.png"));
		shlIzmjenaKorisnika.setSize(660, 488);
		shlIzmjenaKorisnika.setText("Izmjena Korisnika");
		
		Group group = new Group(shlIzmjenaKorisnika, SWT.NONE);
		group.setText("Pretraga");
		group.setBounds(10, 21, 575, 107);
		
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
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell=new Shell();
				MessageDialog.openInformation(shell, "Pretraga", "Uspjesna pretraga, korisnicu su u listi ispod.");
				
			}
		});
		
		table = new Table(shlIzmjenaKorisnika, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 134, 626, 84);
		
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
		
		Group grpIzmjenaAtributa = new Group(shlIzmjenaKorisnika, SWT.NONE);
		grpIzmjenaAtributa.setText("Izmjena atributa");
		grpIzmjenaAtributa.setBounds(10, 234, 626, 158);
		
		Label lblIme = new Label(grpIzmjenaAtributa, SWT.NONE);
		lblIme.setBounds(25, 35, 55, 15);
		lblIme.setText("Ime:");
		
		Label lblPrezime = new Label(grpIzmjenaAtributa, SWT.NONE);
		lblPrezime.setText("Prezime:");
		lblPrezime.setBounds(25, 56, 55, 15);
		
		Label lblKorisnikoIme = new Label(grpIzmjenaAtributa, SWT.NONE);
		lblKorisnikoIme.setText("Korisni\u010Dko ime:");
		lblKorisnikoIme.setBounds(25, 85, 90, 15);
		
		Label lblEmail = new Label(grpIzmjenaAtributa, SWT.NONE);
		lblEmail.setText("E-mail:");
		lblEmail.setBounds(234, 35, 55, 15);
		
		Label lblBrojTelefona = new Label(grpIzmjenaAtributa, SWT.NONE);
		lblBrojTelefona.setText("Broj telefona:");
		lblBrojTelefona.setBounds(234, 56, 82, 15);
		
		Label lblNovaifra = new Label(grpIzmjenaAtributa, SWT.NONE);
		lblNovaifra.setText("Nova \u0161ifra:");
		lblNovaifra.setBounds(25, 111, 65, 15);
		
		Group grpUloga = new Group(grpIzmjenaAtributa, SWT.NONE);
		grpUloga.setText("Uloga:");
		grpUloga.setBounds(234, 77, 128, 71);
		
		Button btnOperater = new Button(grpUloga, SWT.RADIO);
		btnOperater.setBounds(10, 20, 90, 16);
		btnOperater.setText("Operater");
		
		Button btnRukovodilac = new Button(grpUloga, SWT.RADIO);
		btnRukovodilac.setBounds(10, 42, 90, 16);
		btnRukovodilac.setText("Rukovodilac");
		
		text_1 = new Text(grpIzmjenaAtributa, SWT.BORDER);
		text_1.setBounds(118, 32, 90, 21);
		
		text_2 = new Text(grpIzmjenaAtributa, SWT.BORDER);
		text_2.setBounds(118, 56, 90, 21);
		
		text_3 = new Text(grpIzmjenaAtributa, SWT.BORDER);
		text_3.setBounds(118, 82, 90, 21);
		
		text_4 = new Text(grpIzmjenaAtributa, SWT.BORDER);
		text_4.setBounds(118, 108, 90, 21);
		
		text_5 = new Text(grpIzmjenaAtributa, SWT.BORDER);
		text_5.setBounds(316, 32, 90, 21);
		
		text_6 = new Text(grpIzmjenaAtributa, SWT.BORDER);
		text_6.setBounds(316, 56, 90, 21);
		
		Button btnNewButton = new Button(grpIzmjenaAtributa, SWT.NONE);
		btnNewButton.setImage(SWTResourceManager.getImage("src/1398203169_change_user.png"));
		btnNewButton.setBounds(514, 35, 102, 50);
		btnNewButton.setText("Izmjeni");
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell=new Shell();
				MessageDialog.openInformation(shell, "Izmjena", "Uspjesno izmjenjeni atributi korisnika.");
				
			}
		});
		
		Button btnNewButton_1 = new Button(shlIzmjenaKorisnika, SWT.NONE);
		btnNewButton_1.setImage(SWTResourceManager.getImage("src/1398195801_tick_32.png"));
		btnNewButton_1.setBounds(392, 398, 116, 42);
		btnNewButton_1.setText("OK");
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell=new Shell();
				MessageDialog.openInformation(shell, "Izmjena korisnika - OK", "Uspjesna izmjena.");
				
			}
		});
		
		Button btnIzlaz = new Button(shlIzmjenaKorisnika, SWT.NONE);
		btnIzlaz.setImage(SWTResourceManager.getImage("src/1398195841_DeleteRed.png"));
		btnIzlaz.setText("Izlaz");
		btnIzlaz.setBounds(520, 398, 116, 42);
		btnIzlaz.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlIzmjenaKorisnika.close();
			}
		});

	}

}
