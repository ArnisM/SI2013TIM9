package ba.unsa.etf.si2013.tim9.Korisnici;

import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
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

public class KorisniciBrisanjeForm extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
	//protected Shell this;
	private Table table;
	private Text text;
	
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			KorisniciBrisanjeForm shell = new KorisniciBrisanjeForm(display);
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
	public KorisniciBrisanjeForm(Display display) {
		super(display, SWT.SHELL_TRIM);
		setImage(SWTResourceManager.getImage(KorisniciBrisanjeForm.class, "/images/1396674475_user_male2.png"));
		setSize(662, 460);
		setText("Brisanje korisnika");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 148, 626, 206);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnId = new TableColumn(table, SWT.NONE);
		tblclmnId.setWidth(30);
		tblclmnId.setText("ID");
		
		TableColumn tblclmnIme = new TableColumn(table, SWT.NONE);
		tblclmnIme.setWidth(100);
		tblclmnIme.setText("Ime");
		
		TableColumn tblclmnPrezime = new TableColumn(table, SWT.NONE);
		tblclmnPrezime.setWidth(100);
		tblclmnPrezime.setText("Prezime");
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("Korisni\u010Dko ime");
		
		TableColumn tblclmnEmail = new TableColumn(table, SWT.NONE);
		tblclmnEmail.setWidth(100);
		tblclmnEmail.setText("E-mail");
		
		TableColumn tblclmnBrojTelefona = new TableColumn(table, SWT.NONE);
		tblclmnBrojTelefona.setWidth(120);
		tblclmnBrojTelefona.setText("Broj telefona");
		
		TableColumn tblclmnUloga = new TableColumn(table, SWT.NONE);
		tblclmnUloga.setWidth(100);
		tblclmnUloga.setText("Uloga");
		
		Group grpPretraga = new Group(this, SWT.NONE);
		grpPretraga.setText("Pretraga");
		grpPretraga.setBounds(10, 10, 575, 107);
		
		
		final Combo combo = new Combo(grpPretraga, SWT.NONE);
		combo.setItems(new String[] {"Ime", "Prezime", "Korisni\u010Dko ime", "E-mail", "Uloga"});
		combo.setBounds(112, 35, 142, 23);
		combo.setText("Ime");
		
		Label lblKirterijPretrage = new Label(grpPretraga, SWT.NONE);
		lblKirterijPretrage.setBounds(10, 38, 96, 15);
		lblKirterijPretrage.setText("Kirterij pretrage:");
		
		text = new Text(grpPretraga, SWT.BORDER);
		text.setBounds(380, 35, 163, 21);
		
		Label lblUnesiteIme = new Label(grpPretraga, SWT.NONE);
		lblUnesiteIme.setBounds(292, 38, 65, 15);
		lblUnesiteIme.setText("Unesite ime:");
		
		Button btnNewButton = new Button(grpPretraga, SWT.NONE);
		btnNewButton.setImage(SWTResourceManager.getImage(KorisniciBrisanjeForm.class, "/images/1398199827_search_magnifying_glass_find.png"));
		btnNewButton.setBounds(427, 62, 116, 35);
		btnNewButton.setText("Pretraga");
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				List<Korisnik> korisnici;
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t = session.beginTransaction();
				if(combo.getSelectionIndex()==0){
											
		        Query q = session.createQuery("from Korisnik where ime=:ime");
		        q.setString("ime", text.getText());
		        korisnici=q.list();
		        t.commit();
		        session.close();
		        Korisnik k=new Korisnik();
		        		        
		        for (int i=0; i<korisnici.size(); i++){
		        	k = (Korisnik) korisnici.get(i);
		        	if(k.getDeleted()==0){
		        TableItem item = new TableItem(table, 0, i);
		        item.setText(0,Integer.toString((int)k.getId()));
           	    item.setText(1,k.getIme());
             	item.setText(2,k.getPrezime());
             	item.setText(3,k.getUsername());
           	    item.setText(4,k.getAdresa());
           	    item.setText(5,k.getTelefon()); 
           	    item.setText(6, k.getPozicija());
		       }}
		        
			}
				
				if(combo.getSelectionIndex()==1){
					
			        Query q = session.createQuery("from Korisnik where prezime=:prezime");
			        q.setString("prezime", text.getText());
			        korisnici=q.list();
			        t.commit();
			        session.close();
			        Korisnik k=new Korisnik();
			        		        
			        for (int i=0; i<korisnici.size(); i++){
			        	k = (Korisnik) korisnici.get(i);
			        	
			        TableItem item = new TableItem(table, 0, i);
			        item.setText(0,Integer.toString((int)k.getId()));
	           	    item.setText(1,k.getIme());
	             	item.setText(2,k.getPrezime());
	             	item.setText(3,k.getUsername());
	           	    item.setText(4,k.getAdresa());
	           	    item.setText(5,k.getTelefon()); 
	           	    item.setText(6, k.getPozicija());
			       }
			        
				}
				
				if(combo.getSelectionIndex()==2){
					
			        Query q = session.createQuery("from Korisnik where pozicija=:pozicija");
			        q.setString("pozicija", "operater");
			        korisnici=q.list();
			        t.commit();
			        session.close();
			        Korisnik k=new Korisnik();
			        		        
			        for (int i=0; i<korisnici.size(); i++){
			        	k = (Korisnik) korisnici.get(i);
			        	
			        TableItem item = new TableItem(table, 0, i);
			        item.setText(0,Integer.toString((int)k.getId()));
	           	    item.setText(1,k.getIme());
	             	item.setText(2,k.getPrezime());
	             	item.setText(3,k.getUsername());
	           	    item.setText(4,k.getAdresa());
	           	    item.setText(5,k.getTelefon()); 
	           	    item.setText(6, k.getPozicija());
			       }
			        
				}
				
if(combo.getSelectionIndex()==2){
					
			        Query q = session.createQuery("from Korisnik where pozicija=:pozicija");
			        q.setString("pozicija", "rukovodilac");
			        korisnici=q.list();
			        t.commit();
			        session.close();
			        Korisnik k=new Korisnik();
			        		        
			        for (int i=0; i<korisnici.size(); i++){
			        	k = (Korisnik) korisnici.get(i);
			        	
			        TableItem item = new TableItem(table, 0, i);
			        item.setText(0,Integer.toString((int)k.getId()));
	           	    item.setText(1,k.getIme());
	             	item.setText(2,k.getPrezime());
	             	item.setText(3,k.getUsername());
	           	    item.setText(4,k.getAdresa());
	           	    item.setText(5,k.getTelefon()); 
	           	    item.setText(6, k.getPozicija());
			       }
			        
				}
				
				
				
			}
		});
		
		Label lblOznaiteeljeniRed = new Label(this, SWT.NONE);
		lblOznaiteeljeniRed.setBounds(10, 127, 154, 15);
		lblOznaiteeljeniRed.setText("Ozna\u010Dite \u017Eeljene klijente:");
		
		Button btnNewButton_1 = new Button(this, SWT.NONE);
		btnNewButton_1.setImage(SWTResourceManager.getImage(KorisniciBrisanjeForm.class, "/images/1398201739_Trash.png"));
		btnNewButton_1.setBounds(368, 360, 123, 46);
		btnNewButton_1.setText("Bri\u0161i");
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t = session.beginTransaction();
				Korisnik k=new Korisnik();
				int ind=table.getSelectionIndex();
				TableItem ti=table.getItem(ind);
				
				Korisnik myObject = (Korisnik) session.load(Korisnik.class,(long)(Integer.parseInt(ti.getText(0))));
			    myObject.setDeleted(1);
				session.update(myObject);
			    session.getTransaction().commit();

		        
				//Control [] controls = table.getChildren(); 
				
				table.clear(ind);
				Shell shell=new Shell();
				MessageDialog.openInformation(shell, "Brisanje", "Izabrani korisnik je obrisan.");
				
			}
		});
		
		Button btnIzlaz = new Button(this, SWT.NONE);
		btnIzlaz.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		btnIzlaz.setImage(SWTResourceManager.getImage(KorisniciBrisanjeForm.class, "/images/1398195841_DeleteRed.png"));
		btnIzlaz.setText("Izlaz");
		btnIzlaz.setBounds(497, 360, 123, 46);
		

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
