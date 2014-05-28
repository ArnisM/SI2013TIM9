package org.eclipse.wb.swt;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class DodavanjeStavkiFaktureForm {

	protected Shell shlDodavanjeStavkiFakture;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DodavanjeStavkiFaktureForm window = new DodavanjeStavkiFaktureForm();
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
		shlDodavanjeStavkiFakture.open();
		shlDodavanjeStavkiFakture.layout();
		while (!shlDodavanjeStavkiFakture.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlDodavanjeStavkiFakture = new Shell();
		shlDodavanjeStavkiFakture.setImage(SWTResourceManager.getImage("src/1396674611_invoice.png"));
		shlDodavanjeStavkiFakture.setSize(351, 402);
		shlDodavanjeStavkiFakture.setText("Dodavanje stavki fakture");
		
		List list = new List(shlDodavanjeStavkiFakture, SWT.BORDER);
		list.setItems(new String[] {"Servisiranje ra\u010Dunara ", "Instalacija microsoft oficce-a", "Instaliranje i pode\u0161avanje operativnog sistema", "Promjena licence"});
		list.setBounds(10, 57, 310, 249);
		
		Label lblOdaberiteStavkuKoju = new Label(shlDodavanjeStavkiFakture, SWT.NONE);
		lblOdaberiteStavkuKoju.setText("Odaberite stavku koju \u017Eelite dodati:");
		lblOdaberiteStavkuKoju.setBounds(10, 36, 204, 15);
		
		Button button = new Button(shlDodavanjeStavkiFakture, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
				MessageDialog.openInformation(shell, "Info", "Stavka je dodana.");
			}
		});
		button.setText("Dodaj");
		button.setImage(SWTResourceManager.getImage("src/1398195801_tick_32.png"));
		button.setBounds(74, 312, 116, 42);
		
		Button button_1 = new Button(shlDodavanjeStavkiFakture, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlDodavanjeStavkiFakture.close();
			}
		});
		button_1.setText("Izlaz");
		button_1.setImage(SWTResourceManager.getImage("src/1398195841_DeleteRed.png"));
		button_1.setBounds(204, 312, 116, 42);

	}

}
