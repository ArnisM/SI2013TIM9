package org.eclipse.wb.swt;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

public class IzvjestajPoKlijentForm {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			IzvjestajPoKlijentForm window = new IzvjestajPoKlijentForm();
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setImage(SWTResourceManager.getImage("src/1396674755_519958-021_Document_Text.png"));
		shell.setSize(419, 499);
		shell.setText("Izvje\u0161taj po klijentu");
		
		TabFolder tabFolder = new TabFolder(shell, SWT.NONE);
		tabFolder.setBounds(10, 10, 383, 441);
		
		TabItem tbtmGodinji = new TabItem(tabFolder, SWT.NONE);
		tbtmGodinji.setText("Godi\u0161nji");
		
		Group group = new Group(tabFolder, SWT.NONE);
		tbtmGodinji.setControl(group);
		
		final Combo combo = new Combo(group, SWT.NONE);
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
		});
		combo.setItems(new String[] {"Mercator", "Interex", "Robot", "Bingo"});
		combo.setBounds(205, 69, 126, 23);
		
		Group grpKlijenti = new Group(group, SWT.NONE);
		grpKlijenti.setText("Klijenti");
		grpKlijenti.setBounds(10, 10, 154, 82);
		
		Button btnFirme = new Button(grpKlijenti, SWT.RADIO);
		btnFirme.setSelection(true);
		btnFirme.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnFirme.setBounds(29, 24, 90, 16);
		btnFirme.setText("Firme");
		
		Button btnFizikaLica = new Button(grpKlijenti, SWT.RADIO);
		btnFizikaLica.setBounds(29, 46, 90, 16);
		btnFizikaLica.setText("Fizi\u010Dka lica");
		
		Label lblIzaberiteKlijenta = new Label(group, SWT.NONE);
		lblIzaberiteKlijenta.setBounds(205, 46, 88, 15);
		lblIzaberiteKlijenta.setText("Izaberite klijenta:");
		
		Group grpRezultatIzvjetaja = new Group(group, SWT.NONE);
		grpRezultatIzvjetaja.setText("Rezultat izvje\u0161taja");
		grpRezultatIzvjetaja.setBounds(10, 108, 355, 251);
		
		Label lblUkupniPromet = new Label(grpRezultatIzvjetaja, SWT.NONE);
		lblUkupniPromet.setBounds(10, 30, 92, 15);
		lblUkupniPromet.setText("Ukupni promet:");
		
		final Label label = new Label(grpRezultatIzvjetaja, SWT.NONE);
		label.setBounds(116, 30, 55, 15);
		label.setText("0");
		
		final List list = new List(grpRezultatIzvjetaja, SWT.BORDER);
		list.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
		});
		list.setItems(new String[] {});
		list.setBounds(10, 71, 171, 170);
		
		Label lblFakture = new Label(grpRezultatIzvjetaja, SWT.NONE);
		lblFakture.setText("Izlazne fakture:");
		lblFakture.setBounds(10, 50, 92, 15);
		
		Button btnOk = new Button(group, SWT.NONE);
		btnOk.setBounds(119, 365, 117, 38);
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				list.removeAll();
				if(combo.getSelectionIndex()==0) {
				list.add("01.01.2014, 500KM");
				list.add("07.02.2014, 700KM");
				list.add("08.08.2014, 800KM");
				label.setText("2000");
				}
				
				if(combo.getSelectionIndex()==1) {
					list.add("02.02.2014, 600KM");
					list.add("08.02.2014, 800KM");
					list.add("10.08.2014, 900KM");
					label.setText("2300");
					}
				
				if(combo.getSelectionIndex()==2) {
					list.add("03.01.2014, 700KM");
					list.add("09.02.2014, 800KM");
					list.add("11.08.2014, 900KM");
					label.setText("2400");
					}
				
				if(combo.getSelectionIndex()==3) {
					list.add("04.01.2014, 800KM");
					list.add("10.02.2014, 900KM");
					list.add("12.08.2014, 1000KM");
					label.setText("2700");
					}
				Shell shell = new Shell ();
				MessageDialog.openInformation(shell, "Generisanje izvještaja", "Uspješno je kreiran godišnji izvještaj za klijenta na osnovu izabranih podataka.");
				
			}
		});
		btnOk.setText("Ok");
		btnOk.setImage(SWTResourceManager.getImage("src/1398195801_tick_32.png"));
		
		Button button_1 = new Button(group, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		button_1.setBounds(248, 365, 117, 38);
		button_1.setText("Izlaz");
		button_1.setImage(SWTResourceManager.getImage("src/1398195841_DeleteRed.png"));
		
		TabItem tbtmMjeseni = new TabItem(tabFolder, SWT.NONE);
		tbtmMjeseni.setText("Mjese\u010Dni");
		
		Group group_1 = new Group(tabFolder, SWT.NONE);
		tbtmMjeseni.setControl(group_1);
		
		Combo combo_1 = new Combo(group_1, SWT.NONE);
		combo_1.setItems(new String[] {"Interex", "Bingo", "Robot"});
		combo_1.setBounds(205, 43, 126, 23);
		combo_1.setText("Mercator\r\n");
		
		Group group_2 = new Group(group_1, SWT.NONE);
		group_2.setText("Klijenti");
		group_2.setBounds(10, 10, 154, 82);
		
		Button button = new Button(group_2, SWT.RADIO);
		button.setText("Firme");
		button.setSelection(true);
		button.setBounds(29, 24, 90, 16);
		
		Button button_2 = new Button(group_2, SWT.RADIO);
		button_2.setText("Fizi\u010Dka lica");
		button_2.setBounds(29, 46, 90, 16);
		
		Label label_1 = new Label(group_1, SWT.NONE);
		label_1.setText("Izaberite klijenta:");
		label_1.setBounds(205, 22, 88, 15);
		
		Group group_3 = new Group(group_1, SWT.NONE);
		group_3.setText("Rezultat izvje\u0161taja");
		group_3.setBounds(10, 108, 355, 251);
		
		Label label_2 = new Label(group_3, SWT.NONE);
		label_2.setText("Ukupni promet:");
		label_2.setBounds(10, 30, 92, 15);
		
		final Label label_3 = new Label(group_3, SWT.NONE);
		label_3.setText("0");
		label_3.setBounds(116, 30, 55, 15);
		
		final List list_1 = new List(group_3, SWT.BORDER);
		list_1.setItems(new String[] {});
		list_1.setBounds(10, 71, 171, 170);
		
		Label label_4 = new Label(group_3, SWT.NONE);
		label_4.setText("Izlazne fakture:");
		label_4.setBounds(10, 50, 92, 15);
		
		Button button_3 = new Button(group_1, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				list_1.removeAll();
				list_1.add("19.03.2014, 500KM");
				list_1.add("20.01.2014, 600KM");
				list_1.add("21.01.2014, 700KM");
				list_1.add("22.01.2014, 800KM");
				list_1.add("23.01.2014, 900KM");
				list_1.add("24.01.2014, 1000KM");
				label_3.setText("4500");			
				Shell shell = new Shell ();
				MessageDialog.openInformation(shell, "Generisanje izvjestaja", "Uspješno je kreiran mjesečni izvještaj.");
			}
		});
		button_3.setText("Ok");
		button_3.setImage(SWTResourceManager.getImage("src/1398195801_tick_32.png"));
		button_3.setBounds(119, 365, 117, 38);
		
		Button button_4 = new Button(group_1, SWT.NONE);
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		button_4.setText("Izlaz");
		button_4.setImage(SWTResourceManager.getImage("src/1398195841_DeleteRed.png"));
		button_4.setBounds(248, 365, 117, 38);
		
		Label lblMjesec = new Label(group_1, SWT.NONE);
		lblMjesec.setBounds(205, 83, 55, 15);
		lblMjesec.setText("Mjesec:");
		
		Spinner spinner = new Spinner(group_1, SWT.BORDER);
		spinner.setMaximum(12);
		spinner.setMinimum(1);
		spinner.setSelection(3);
		spinner.setBounds(261, 80, 47, 22);
		
		TabItem tbtmSedmini = new TabItem(tabFolder, SWT.NONE);
		tbtmSedmini.setText("Sedmični");
		
		Group group_4 = new Group(tabFolder, SWT.NONE);
		tbtmSedmini.setControl(group_4);
		
		Group group_5 = new Group(group_4, SWT.NONE);
		group_5.setBounds(0, 0, 375, 415);
		
		Combo combo_2 = new Combo(group_5, SWT.NONE);
		combo_2.setItems(new String[] {"Interex", "Bingo", "Robot"});
		combo_2.setBounds(205, 43, 126, 21);
		combo_2.setText("Mercator\r\n");
		
		Group group_6 = new Group(group_5, SWT.NONE);
		group_6.setText("Klijenti");
		group_6.setBounds(10, 10, 154, 82);
		
		Button button_5 = new Button(group_6, SWT.RADIO);
		button_5.setText("Firme");
		button_5.setSelection(true);
		button_5.setBounds(29, 24, 90, 16);
		
		Button button_6 = new Button(group_6, SWT.RADIO);
		button_6.setText("Fizička lica");
		button_6.setBounds(29, 46, 90, 16);
		
		Label label_5 = new Label(group_5, SWT.NONE);
		label_5.setText("Izaberite klijenta:");
		label_5.setBounds(205, 22, 88, 15);
		
		Group group_7 = new Group(group_5, SWT.NONE);
		group_7.setText("Rezultat izvještaja");
		group_7.setBounds(10, 108, 355, 251);
		
		Label label_6 = new Label(group_7, SWT.NONE);
		label_6.setText("Ukupni promet:");
		label_6.setBounds(10, 30, 92, 15);
		
		final Label label_7 = new Label(group_7, SWT.NONE);
		label_7.setText("0");
		label_7.setBounds(116, 30, 55, 15);
		
		final List list_2 = new List(group_7, SWT.BORDER);
		list_2.setItems(new String[] {});
		list_2.setBounds(10, 71, 171, 170);
		
		Label label_8 = new Label(group_7, SWT.NONE);
		label_8.setText("Izlazne fakture:");
		label_8.setBounds(10, 50, 92, 15);
		
		Button button_7 = new Button(group_5, SWT.NONE);
		button_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				list_2.removeAll();
				list_2.add("01.03.2014, 500KM");
				list_2.add("02.01.2014, 600KM");
				list_2.add("03.01.2014, 700KM");
				list_2.add("04.01.2014, 800KM");
				list_2.add("05.01.2014, 900KM");
				list_2.add("06.01.2014, 1000KM");
				label_7.setText("4500");			
				Shell shell = new Shell ();
				MessageDialog.openInformation(shell, "Generisanje izvjestaja", "Uspješno je kreiran sedmični izvještaj");
			
			}
		});
		button_7.setText("Ok");
		button_7.setImage(SWTResourceManager.getImage("src/1398195801_tick_32.png"));
		button_7.setBounds(119, 365, 117, 38);
		
		Button button_8 = new Button(group_5, SWT.NONE);
		button_8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		button_8.setText("Izlaz");
		button_8.setImage(SWTResourceManager.getImage("src/1398195841_DeleteRed.png"));
		button_8.setBounds(248, 365, 117, 38);
		
		

	}

}
