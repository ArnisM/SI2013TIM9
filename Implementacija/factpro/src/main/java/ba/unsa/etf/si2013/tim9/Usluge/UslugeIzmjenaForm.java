package ba.unsa.etf.si2013.tim9.Usluge;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

public class UslugeIzmjenaForm extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
//	protected Shell this;
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			UslugeIzmjenaForm shell = new UslugeIzmjenaForm(display);
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
	public UslugeIzmjenaForm(Display display) {
		super(display, SWT.SHELL_TRIM);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
//		this = new Shell();
		this.setImage(SWTResourceManager.getImage(UslugeIzmjenaForm.class, "/images/1396674353_services.png"));
		this.setSize(399, 445);
		this.setText("Izmjena usluge");
		
		Group group = new Group(this, SWT.NONE);
		group.setBounds(10, 10, 361, 313);
		
		List list = new List(group, SWT.BORDER);
		list.setBounds(26, 62, 310, 183);
		list.setItems(new String[] {"Servisiranje ra\u010Dunara ", "Instalacija microsoft oficce-a", "Instaliranje i pode\u0161avanje operativnog sistema", "Promjena licence"});
		
		Label lblOdaberiteUslugu = new Label(group, SWT.NONE);
		lblOdaberiteUslugu.setBounds(26, 41, 105, 15);
		lblOdaberiteUslugu.setText("Odaberite uslugu:");
		
		Button btnIzmjeni = new Button(group, SWT.NONE);
		btnIzmjeni.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
				MessageDialog.openInformation(shell, "Izmjena usluga", "Otvara se forma gdje se unosee novi podaci za uslugu.");
				
			}
		});
		btnIzmjeni.setBounds(26, 251, 105, 50);
		btnIzmjeni.setImage(SWTResourceManager.getImage(UslugeIzmjenaForm.class, "/images/1396674353_services.png"));
		btnIzmjeni.setText("Izmijeni");
		
		Button button = new Button(this, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		button.setText("Izlaz");
		button.setImage(SWTResourceManager.getImage(UslugeIzmjenaForm.class, "/images/1398195841_DeleteRed.png"));
		button.setBounds(255, 355, 116, 42);
		
		Button btnOk = new Button(this, SWT.NONE);
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
				MessageDialog.openInformation(shell, "Potvrda", "Izmjene završene.");
			}
		});
		btnOk.setText("Ok");
		btnOk.setImage(SWTResourceManager.getImage(UslugeIzmjenaForm.class, "/images/1398195801_tick_32.png"));
		btnOk.setBounds(124, 355, 116, 42);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
