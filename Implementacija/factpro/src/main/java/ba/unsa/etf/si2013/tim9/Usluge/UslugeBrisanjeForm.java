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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.DisposeEvent;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si2013.tim9.HibernateUtil;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;

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
		addShellListener(new ShellAdapter() {
			@Override
			public void shellActivated(ShellEvent e) {
				
			        }
			
		});
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent arg0) {
				
			}
		});
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
		
		final List list = new List(this, SWT.BORDER);
		list.setBounds(10, 67, 310, 209);
		list.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			
			}
		});
		
		
		
		Button btnBrii = new Button(this, SWT.NONE);
		btnBrii.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t = session.beginTransaction();
				Usluga u=new Usluga();
				int ind=list.getSelectionIndex();
				String s=list.getItem(ind);
				 String[] parts = s.split(" ");
			        String part1 = parts[0]; // 004
			        String part2 = parts[1]; // 034556
				
				Usluga myObject = (Usluga) session.load(Usluga.class,(long)(Integer.parseInt(part1)));
			    session.delete(myObject);
			    session.getTransaction().commit();
				
				list.remove(ind);
				
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
		
		Button btnProba = new Button(this, SWT.NONE);
		btnProba.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t = session.beginTransaction();
				java.util.List<Usluga> usluge;
				
					
			        Query q = session.createQuery("from Usluga");
			       
			        usluge=q.list();
			        t.commit();
			        session.close();
			        Usluga k=new Usluga();
			        		        
			        for (int i=0; i<usluge.size(); i++){
			        	k = (Usluga) usluge.get(i);
			        	list.add(k.getNaziv(), i);
			       
			        }
			}
		});
		btnProba.setBounds(10, 10, 310, 30);
		btnProba.setText("Ispis usluga");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
