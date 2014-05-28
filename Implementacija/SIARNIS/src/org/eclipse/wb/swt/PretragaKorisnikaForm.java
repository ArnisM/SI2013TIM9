package org.eclipse.wb.swt;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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

public class PretragaKorisnikaForm {

	protected Shell shlPretragaKorisnika;
	private Table table;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PretragaKorisnikaForm window = new PretragaKorisnikaForm();
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
		shlPretragaKorisnika.open();
		shlPretragaKorisnika.layout();
		while (!shlPretragaKorisnika.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlPretragaKorisnika = new Shell();
		shlPretragaKorisnika.setImage(SWTResourceManager.getImage("src/1396674475_user_male2.png"));
		shlPretragaKorisnika.setSize(656, 448);
		shlPretragaKorisnika.setText("Pretraga i ispis korisnika");
		
		table = new Table(shlPretragaKorisnika, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 134, 626, 206);
		
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
		
		Group group = new Group(shlPretragaKorisnika, SWT.NONE);
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
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell=new Shell();
				MessageDialog.openInformation(shell, "Pretraga", "Uspjesna pretraga, korisnisi u listi ispod.");
				
			}
		});
		
		Button button_1 = new Button(shlPretragaKorisnika, SWT.NONE);
		button_1.setText("OK");
		button_1.setImage(SWTResourceManager.getImage("src/1398195801_tick_32.png"));
		button_1.setBounds(376, 358, 116, 42);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell=new Shell();
				MessageDialog.openInformation(shell, "Pretraga korisnika - OK", "Uspjesna pretraga.");
				
			}
		});
		
		Button izlazKorisnik = new Button(shlPretragaKorisnika, SWT.NONE);
		izlazKorisnik.setText("Izlaz");
		izlazKorisnik.setImage(SWTResourceManager.getImage("src/1398195841_DeleteRed.png"));
		izlazKorisnik.setBounds(506, 358, 116, 42);
		izlazKorisnik.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlPretragaKorisnika.close();
			}
		});
		
		Button button_3 = new Button(shlPretragaKorisnika, SWT.NONE);
		button_3.setText("Generi\u0161i .pdf");
		button_3.setImage(SWTResourceManager.getImage("src/1398206257_pdf.png"));
		button_3.setBounds(10, 353, 119, 47);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell=new Shell();
				MessageDialog.openInformation(shell, "Generisanje .pdf-a", "Generisan je pdf u kojem se nalaze izabrani korisnici.");
				
			}
		});

	}

}
