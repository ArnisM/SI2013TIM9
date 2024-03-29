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
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si2013.tim9.HibernateUtil;
import ba.unsa.etf.si2013.tim9.Usluge.Usluga;

import java.util.ArrayList;
import java.util.ArrayList;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
public class FaktureStavkeDodavanjeForm extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
//	protected Shell this;
	private ArrayList<String> b;
	private FaktureDodavanjeForm z;
	private List list;
	
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			FaktureStavkeDodavanjeForm shell = new FaktureStavkeDodavanjeForm(display,null,null);
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
	
	public FaktureStavkeDodavanjeForm(Display display , ArrayList<String> a, FaktureDodavanjeForm f) {
		
		super(display, SWT.SHELL_TRIM);
		addShellListener(new ShellAdapter() {
			@Override
			public void shellClosed(ShellEvent e) {
				z.Prebaci();
			}
		});
		b=new ArrayList<String>();
		b=a;
		z=f;
	    list = new List(this, SWT.BORDER);
		list.setItems(new String[] {});
		list.setBounds(10, 57, 310, 249);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		java.util.List<Usluga> usluge;
		
			
	        Query q = session.createQuery("from Usluga where deleted=:del");
	        q.setString("del", Long.toString(0));
	        usluge=q.list();
	        t.commit();
	        session.close();
	        Usluga k=new Usluga();		        		        
	        for (int i=0; i<usluge.size(); i++){
	        	k = (Usluga) usluge.get(i);
	        	list.add(k.getNaziv(), i);
	        }
		
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
		
		
		
		
		Label lblOdaberiteStavkuKoju = new Label(this, SWT.NONE);
		lblOdaberiteStavkuKoju.setText("Odaberite stavku koju \u017Eelite dodati:");
		lblOdaberiteStavkuKoju.setBounds(10, 36, 204, 15);
		
		//UBACIVANJE U LISTU PROSLJEDDJENU KONSTRUKTORU iz FAKTURA DODAJ
		Button button = new Button(this, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				if(list.getSelectionIndex()!=-1)
				{
				String x=list.getItem(list.getSelectionIndex());
				b.add(x);
				
				z.Provjeri();
				Shell shell = new Shell();
				MessageDialog.openInformation(shell, "Info", "Stavka je dodana.");
				}
				else 
				{
					Shell shell = new Shell();
					MessageDialog.openInformation(shell, "Info", "Morate izabrati uslugu za dodati.");
				}
				
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
