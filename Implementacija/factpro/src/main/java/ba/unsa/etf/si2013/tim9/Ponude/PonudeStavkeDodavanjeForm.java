package ba.unsa.etf.si2013.tim9.Ponude;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;



import ba.unsa.etf.si2013.tim9.Ponude.PonudeDodavanjeForm;


public class PonudeStavkeDodavanjeForm extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
//	protected Shell this;
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			PonudeStavkeDodavanjeForm shell = new PonudeStavkeDodavanjeForm(
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
	public PonudeStavkeDodavanjeForm(Display display) {
		super(display, SWT.SHELL_TRIM);
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
		
			}
		});
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
//		this = new Shell();
		this.setImage(SWTResourceManager.getImage(PonudeStavkeDodavanjeForm.class, "/images/1396674680_document_text.png"));
		this.setSize(351, 402);
		this.setText("Dodavanje stavki ponude");
		
		final List list_dodaj = new List(this, SWT.BORDER);
		list_dodaj.setItems(new String[] {"Servisiranje ra\u010Dunara ", "Instalacija microsoft oficce-a", "Instaliranje i pode\u0161avanje operativnog sistema", "Promjena licence"});
		list_dodaj.setBounds(10, 57, 310, 249);
		
		Label lblOdaberiteStavkuKoju = new Label(this, SWT.NONE);
		lblOdaberiteStavkuKoju.setText("Odaberite stavku koju \u017Eelite dodati:");
		lblOdaberiteStavkuKoju.setBounds(10, 36, 204, 15);
		
		Button button = new Button(this, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
				
				PonudeDodavanjeForm a = new PonudeDodavanjeForm(getDisplay());
				int ind = list_dodaj.getSelectionIndex();
				
				//TableItem ti = a.table.getItem(2); 
				//ti.setText(2, list_dodaj.getItem(ind));

				//a.open();
				
				MessageDialog.openInformation(shell, "Info", "Stavka je dodana.");
			}
		});
		button.setText("Dodaj");
		button.setImage(SWTResourceManager.getImage(PonudeStavkeDodavanjeForm.class, "/images/1398195801_tick_32.png"));
		button.setBounds(74, 312, 116, 42);
		
		Button button_1 = new Button(this, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		button_1.setText("Izlaz");
		button_1.setImage(SWTResourceManager.getImage(PonudeStavkeDodavanjeForm.class, "/images/1398195841_DeleteRed.png"));
		button_1.setBounds(204, 312, 116, 42);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
