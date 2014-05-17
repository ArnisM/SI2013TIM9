package ba.unsa.etf.si2013.tim9.Fakture;

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

public class FaktureStavkeDodavanjeForm extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
//	protected Shell this;
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			FaktureStavkeDodavanjeForm shell = new FaktureStavkeDodavanjeForm(
					display);
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
	public FaktureStavkeDodavanjeForm(Display display) {
		super(display, SWT.SHELL_TRIM);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
//		this = new Shell();
		this.setImage(SWTResourceManager.getImage(FaktureStavkeDodavanjeForm.class, "/images/1396674611_invoice.png"));
		this.setSize(351, 402);
		this.setText("Dodavanje stavki fakture");
		
		List list = new List(this, SWT.BORDER);
		list.setItems(new String[] {"Servisiranje ra\u010Dunara ", "Instalacija microsoft oficce-a", "Instaliranje i pode\u0161avanje operativnog sistema", "Promjena licence"});
		list.setBounds(10, 57, 310, 249);
		
		Label lblOdaberiteStavkuKoju = new Label(this, SWT.NONE);
		lblOdaberiteStavkuKoju.setText("Odaberite stavku koju \u017Eelite dodati:");
		lblOdaberiteStavkuKoju.setBounds(10, 36, 204, 15);
		
		Button button = new Button(this, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
				MessageDialog.openInformation(shell, "Info", "Stavka je dodana.");
			}
		});
		button.setText("Dodaj");
		button.setImage(SWTResourceManager.getImage(FaktureStavkeDodavanjeForm.class, "/images/1398195801_tick_32.png"));
		button.setBounds(74, 312, 116, 42);
		
		Button button_1 = new Button(this, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		button_1.setText("Izlaz");
		button_1.setImage(SWTResourceManager.getImage(FaktureStavkeDodavanjeForm.class, "/images/1398195841_DeleteRed.png"));
		button_1.setBounds(204, 312, 116, 42);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
