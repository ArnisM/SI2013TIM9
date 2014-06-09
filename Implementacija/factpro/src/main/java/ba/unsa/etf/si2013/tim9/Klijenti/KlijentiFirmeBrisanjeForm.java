package ba.unsa.etf.si2013.tim9.Klijenti;


import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;




import ba.unsa.etf.si2013.tim9.HibernateUtil;

import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.DisposeEvent;

public class KlijentiFirmeBrisanjeForm extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
//	protected Shell this;
	private Text text;
	private Table table;
	private List<Klijenti> klijenti;
	
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			KlijentiFirmeBrisanjeForm shell = new KlijentiFirmeBrisanjeForm(
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
	public KlijentiFirmeBrisanjeForm(Display display) {
		super(display, SWT.SHELL_TRIM);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
//		this = new Shell();
		this.setImage(SWTResourceManager.getImage(KlijentiFirmeBrisanjeForm.class, "/images/1396674421_Streamline-61.png"));
		this.setSize(652, 444);
		this.setText("Brisanje firme");
		
		final Group group = new Group(this, SWT.NONE);
		group.setText("Pretraga");
		group.setBounds(10, 10, 575, 107);
		
		final Label lblUnesiPdvBroj = new Label(group, SWT.NONE);
		lblUnesiPdvBroj.setText("Unesi naziv:");
		lblUnesiPdvBroj.setBounds(280, 38, 96, 15);
		
		final Combo combo = new Combo(group, SWT.NONE);
		combo.setItems(new String[] {"Naziv"});
		combo.setBounds(112, 35, 142, 23);
		combo.setText("Odaberite kriterj pretrage");
		
		Label label = new Label(group, SWT.NONE);
		label.setText("Kirterij pretrage:");
		label.setBounds(10, 38, 96, 15);
		
		text = new Text(group, SWT.BORDER);
		text.setBounds(380, 35, 163, 21);
		combo.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent arg0) {
			}
		});
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if (combo.getSelectionIndex()==1){
					lblUnesiPdvBroj.setText("Unesi ime:");
				}
				
			}
		});
		
		
		
		
		table = new Table(getShell(), SWT.MULTI | SWT.FULL_SELECTION | SWT.VIRTUAL | SWT.BORDER);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 158, 626, 179);
		
		TableColumn tblclmnId = new TableColumn(table, SWT.NONE);
		tblclmnId.setWidth(100);
		tblclmnId.setText("ID");
		
		
		final TableColumn tblclmnNazivFirme = new TableColumn(table, SWT.NONE);
		tblclmnNazivFirme.setWidth(80);
		tblclmnNazivFirme.setText("Naziv firme");
		
		TableColumn tblclmnPdvBroj = new TableColumn(table, SWT.NONE);
		tblclmnPdvBroj.setWidth(62);
		tblclmnPdvBroj.setText("PDV broj");
		
		TableColumn tblclmnIdpdvBroj = new TableColumn(table, SWT.NONE);
		tblclmnIdpdvBroj.setWidth(74);
		tblclmnIdpdvBroj.setText("IDPDV broj");
		
		TableColumn tblclmnAdresa = new TableColumn(table, SWT.NONE);
		tblclmnAdresa.setWidth(70);
		tblclmnAdresa.setText("Adresa");
		
		TableColumn tableColumn_4 = new TableColumn(table, SWT.NONE);
		tableColumn_4.setWidth(93);
		tableColumn_4.setText("Broj telefona");
		
		TableColumn tblclmnFax = new TableColumn(table, SWT.NONE);
		tblclmnFax.setWidth(56);
		tblclmnFax.setText("Fax");
		
		TableColumn tblclmnEmail = new TableColumn(table, SWT.NONE);
		tblclmnEmail.setWidth(175);
		tblclmnEmail.setText("E-mail");
		
		Button button_1 = new Button(this, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Klijenti k=new Klijenti();
			int ind=table.getSelectionIndex();
			TableItem ti=table.getItem(ind);
			
			Klijenti myObject = (Klijenti) session.load(Klijenti.class,(long)(Integer.parseInt(ti.getText(0))));
		    myObject.setDeleted(1);
			session.update(myObject);
		    session.getTransaction().commit();

	        Shell shell1 = new Shell();
			MessageDialog.openInformation(shell1, "Brisanje klijenta", "Klijent je uspješno obrisan.");
			
			Control [] controls = table.getChildren(); 
			
			table.clear(ind);
			
			}
		});
		
		
		Button button = new Button(group, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
					Session session = HibernateUtil.getSessionFactory().openSession();
					Transaction t = session.beginTransaction();
					if(combo.getSelectionIndex()==0){
												
			        Query q = session.createQuery("from Klijenti where naziv=:naziv AND deleted=:deleted");
			        q.setString("naziv", text.getText());
			        q.setInteger("deleted", 0);
			        klijenti=q.list();
			        t.commit();
			        session.close();
			        Klijenti k=new Klijenti();
			        table.clearAll();
			        for (int i=0; i<klijenti.size(); i++){
			        	k = (Klijenti) klijenti.get(i);
			        	
			        TableItem item = new TableItem(table, 0, i);
			        
			        item.setText(1,k.getNaziv());
	           	    item.setText(2,Integer.toString(k.getPdv()));
	             	item.setText(3,Integer.toString(k.getPdvbroj()));
	           	    item.setText(4,k.getAdresa());
	           	    item.setText(5,k.getBrojtelefona());
	           	    item.setText(8,k.getEmail());
	           	    item.setText(6,k.getBrojtelefona());
	           	    item.setText(7, k.getFax());
	           	    item.setText(0,Integer.toString((int)k.getId()));
			        }
			    }
					
					
					
					
					
			}
		});
	
		
		button.setText("Pretraga");
		button.setImage(SWTResourceManager.getImage(KlijentiFirmeBrisanjeForm.class, "/images/1398199827_search_magnifying_glass_find.png"));
		button.setBounds(427, 62, 116, 35);
		
		
		button_1.setText("Bri\u0161i");
		button_1.setImage(SWTResourceManager.getImage(KlijentiFirmeBrisanjeForm.class, "/images/1398201739_Trash.png"));
		button_1.setBounds(361, 350, 123, 46);
		
		Button button_2 = new Button(this, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		button_2.setText("Izlaz");
		button_2.setImage(SWTResourceManager.getImage(KlijentiFirmeBrisanjeForm.class, "/images/1398195841_DeleteRed.png"));
		button_2.setBounds(503, 350, 123, 46);
		
		Label lblOznaiteeljeneFirme = new Label(this, SWT.NONE);
		lblOznaiteeljeneFirme.setText("Ozna\u010Dite \u017Eeljene firme:");
		lblOznaiteeljeneFirme.setBounds(10, 137, 154, 15);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
