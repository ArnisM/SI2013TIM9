package ba.unsa.etf.si2013.tim9.Usluge;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

public class UslugeBrisanjeForm extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
//	protected Shell this;
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			UslugeBrisanjeForm shell = new UslugeBrisanjeForm(display);
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
	public UslugeBrisanjeForm(Display display) {
		super(display, SWT.SHELL_TRIM);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
//		this = new Shell();
		this.setImage(SWTResourceManager.getImage(UslugeBrisanjeForm.class, "/images/1396674353_services.png"));
		this.setSize(347, 391);
		this.setText("Brisanje usluge");
		
		Label lblOdaberiteUsluguKoju = new Label(this, SWT.NONE);
		lblOdaberiteUsluguKoju.setText("Odaberite uslugu koju \u017Eelite obrisati:");
		lblOdaberiteUsluguKoju.setBounds(10, 46, 204, 15);
		
		List list = new List(this, SWT.BORDER);
		list.setItems(new String[] {"Servisiranje ra\u010Dunara ", "Instalacija microsoft oficce-a", "Instaliranje i pode\u0161avanje operativnog sistema", "Promjena licence"});
		list.setBounds(10, 67, 310, 209);
		
		Button btnBrii = new Button(this, SWT.NONE);
		btnBrii.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
				MessageDialog.openInformation(shell, "Brisanje usluga", "Usluga je uspješno izbrisana.");
			}
		});
		btnBrii.setText("Bri\u0161i");
		btnBrii.setImage(SWTResourceManager.getImage(UslugeBrisanjeForm.class, "/images/1398201739_Trash.png"));
		btnBrii.setBounds(75, 303, 116, 42);
		
		Button button_1 = new Button(this, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		button_1.setText("Izlaz");
		button_1.setImage(SWTResourceManager.getImage(UslugeBrisanjeForm.class, "/images/1398195841_DeleteRed.png"));
		button_1.setBounds(204, 303, 116, 42);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
