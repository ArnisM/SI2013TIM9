package org.eclipse.wb.swt;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class BrisanjeUslugeForm {

	protected Shell shlBrisanjeUsluge;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BrisanjeUslugeForm window = new BrisanjeUslugeForm();
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
		shlBrisanjeUsluge.open();
		shlBrisanjeUsluge.layout();
		while (!shlBrisanjeUsluge.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlBrisanjeUsluge = new Shell();
		shlBrisanjeUsluge.setImage(SWTResourceManager.getImage("src/1396674353_services.png"));
		shlBrisanjeUsluge.setSize(347, 391);
		shlBrisanjeUsluge.setText("Brisanje usluge");
		
		Label lblOdaberiteUsluguKoju = new Label(shlBrisanjeUsluge, SWT.NONE);
		lblOdaberiteUsluguKoju.setText("Odaberite uslugu koju \u017Eelite obrisati:");
		lblOdaberiteUsluguKoju.setBounds(10, 46, 204, 15);
		
		List list = new List(shlBrisanjeUsluge, SWT.BORDER);
		list.setItems(new String[] {"Servisiranje ra\u010Dunara ", "Instalacija microsoft oficce-a", "Instaliranje i pode\u0161avanje operativnog sistema", "Promjena licence"});
		list.setBounds(10, 67, 310, 209);
		
		Button btnBrii = new Button(shlBrisanjeUsluge, SWT.NONE);
		btnBrii.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
				MessageDialog.openInformation(shell, "Brisanje usluga", "Usluga je uspješno izbrisana.");
			}
		});
		btnBrii.setText("Bri\u0161i");
		btnBrii.setImage(SWTResourceManager.getImage("src/1398201739_Trash.png"));
		btnBrii.setBounds(75, 303, 116, 42);
		
		Button button_1 = new Button(shlBrisanjeUsluge, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlBrisanjeUsluge.close();
			}
		});
		button_1.setText("Izlaz");
		button_1.setImage(SWTResourceManager.getImage("src/1398195841_DeleteRed.png"));
		button_1.setBounds(204, 303, 116, 42);

	}

}
