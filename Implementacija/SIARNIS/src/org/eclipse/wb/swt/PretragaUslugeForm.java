package org.eclipse.wb.swt;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class PretragaUslugeForm {

	protected Shell shlPretragaIIspis;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PretragaUslugeForm window = new PretragaUslugeForm();
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
		shlPretragaIIspis.open();
		shlPretragaIIspis.layout();
		while (!shlPretragaIIspis.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlPretragaIIspis = new Shell();
		shlPretragaIIspis.setImage(SWTResourceManager.getImage("src/1396674353_services.png"));
		shlPretragaIIspis.setSize(399, 440);
		shlPretragaIIspis.setText("Pretraga i ispis usluga");
		
		Group grpPretraga = new Group(shlPretragaIIspis, SWT.NONE);
		grpPretraga.setText("Pretraga");
		grpPretraga.setBounds(10, 10, 356, 95);
		
		Combo combo = new Combo(grpPretraga, SWT.NONE);
		combo.setItems(new String[] {"ID usluge", "Naziv", "Datum kreiranja", "Datum promjene", "Tip usluge", "Cijena"});
		combo.setBounds(103, 18, 120, 23);
		
		Label lblPretragaPo = new Label(grpPretraga, SWT.NONE);
		lblPretragaPo.setBounds(10, 21, 105, 15);
		lblPretragaPo.setText("Kriterij pretrage:");
		
		Label lblUnesiteNaziv = new Label(grpPretraga, SWT.NONE);
		lblUnesiteNaziv.setBounds(10, 59, 93, 15);
		lblUnesiteNaziv.setText("Unesite naziv:");
		
		text = new Text(grpPretraga, SWT.BORDER);
		text.setBounds(100, 59, 123, 21);
		
		Button btnPretraga = new Button(grpPretraga, SWT.NONE);
		btnPretraga.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
				MessageDialog.openInformation(shell, "Pretraga usluga", "Pretraga je završena. Usluge koje zadovoljavaju kriterij su ispisane.");
			}
		});
		btnPretraga.setImage(SWTResourceManager.getImage("src/1398575960_search_magnifying_glass_find.png"));
		btnPretraga.setBounds(249, 18, 97, 25);
		btnPretraga.setText("Pretraga");
		
		Label lblOdaberiteeljeneUsluge = new Label(shlPretragaIIspis, SWT.NONE);
		lblOdaberiteeljeneUsluge.setText("Odaberite \u017Eeljene usluge za ispis:");
		lblOdaberiteeljeneUsluge.setBounds(10, 133, 183, 15);
		
		List list = new List(shlPretragaIIspis, SWT.BORDER);
		list.setItems(new String[] {"Servisiranje ra\u010Dunara ", "Instalacija microsoft oficce-a", "Instaliranje i pode\u0161avanje operativnog sistema", "Promjena licence"});
		list.setBounds(10, 154, 367, 204);
		
		Button button = new Button(shlPretragaIIspis, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
				MessageDialog.openInformation(shell, "OK", "Završeno.");
			}
		});
		button.setText("Ok");
		button.setImage(SWTResourceManager.getImage("src/1398195801_tick_32.png"));
		button.setBounds(169, 364, 98, 33);
		
		Button button_1 = new Button(shlPretragaIIspis, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlPretragaIIspis.close();
			}
		});
		button_1.setText("Izlaz");
		button_1.setImage(SWTResourceManager.getImage("src/1398195841_DeleteRed.png"));
		button_1.setBounds(273, 364, 104, 33);
		
		Button btnGeneriipdf = new Button(shlPretragaIIspis, SWT.NONE);
		btnGeneriipdf.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
				MessageDialog.openInformation(shell, "Ispis usluga", "PDF je uspješno kreiran.");
			}
		});
		btnGeneriipdf.setText("Generi\u0161i .pdf");
		btnGeneriipdf.setImage(SWTResourceManager.getImage("src/1398206257_pdf.png"));
		btnGeneriipdf.setBounds(10, 364, 118, 33);

	}
}
