package ba.unsa.etf.si2013.tim9.Korisnici;

import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si2013.tim9.HibernateUtil;

public class KorisniciPretragaForm extends Shell {

	protected Shell shlPretragaKorisnika;
	private Table table;
	private Text text;
	private Text text_1;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			KorisniciPretragaForm shell = new KorisniciPretragaForm(display);
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
	public KorisniciPretragaForm(Display display) {
		super(display, SWT.SHELL_TRIM);
		setImage(SWTResourceManager.getImage(KorisniciPretragaForm.class, "/images/1396674475_user_male2.png"));
		setSize(656, 448);
		setText("Pretraga i ispis korisnika");
		
		table = new Table(this, SWT.BORDER );
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 134, 626, 206);
		
		TableColumn tblclmnId = new TableColumn(table, SWT.NONE);
		tblclmnId.setWidth(30);
		tblclmnId.setText("ID");
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("Ime");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("Prezime");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("Korisni\u010Dko ime");
		
		TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(100);
		tableColumn_3.setText("E-mail");
		
		TableColumn tableColumn_4 = new TableColumn(table, SWT.NONE);
		tableColumn_4.setWidth(120);
		tableColumn_4.setText("Broj telefona");
		
		TableColumn tableColumn_5 = new TableColumn(table, SWT.NONE);
		tableColumn_5.setWidth(100);
		tableColumn_5.setText("Uloga");
		
		
		Group group = new Group(this, SWT.NONE);
		group.setText("Pretraga");
		group.setBounds(10, 10, 575, 107);
		
		final Combo combo = new Combo(group, SWT.NONE);
		combo.setItems(new String[] {"Ime ", "Prezime", "Uloga"});
		combo.setBounds(112, 35, 142, 23);
		combo.setText("Ime");
		
		Label label = new Label(group, SWT.NONE);
		label.setText("Kirterij pretrage:");
		label.setBounds(10, 38, 96, 15);
		
		text_1 = new Text(group, SWT.BORDER);
		text_1.setBounds(380, 35, 163, 21);
		
		Label lblUnesiteImeI = new Label(group, SWT.NONE);
		lblUnesiteImeI.setText("Unesite podatatk:");
		lblUnesiteImeI.setBounds(292, 38, 65, 15);
		
		Button button = new Button(group, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
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
		        
           	 //  item.setText(0,Integer.toString(k.getId()));
           	    item.setText(1,k.getIme());
             	item.setText(2,k.getPrezime());
           	    item.setText(3,k.getAdresa());
           	    item.setText(4,k.getTelefon());
           	    
           	    
           	    item.setText(5, k.getPozicija());}
		       }
		        }
				
				
			}
		});
		button.setText("Pretraga");
		button.setImage(SWTResourceManager.getImage(KorisniciPretragaForm.class, "/images/1398199827_search_magnifying_glass_find.png"));
		button.setBounds(427, 62, 116, 35);
		
		Button buttonOK = new Button(this, SWT.NONE);
		buttonOK.setText("OK");
		buttonOK.setImage(SWTResourceManager.getImage(KorisniciPretragaForm.class, "/images/1398195801_tick_32.png"));
		buttonOK.setBounds(376, 358, 116, 42);
		
		Button buttonIzlaz = new Button(this, SWT.NONE);
		buttonIzlaz.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		buttonIzlaz.setText("Izlaz");
		buttonIzlaz.setImage(SWTResourceManager.getImage(KorisniciPretragaForm.class, "/images/1398195841_DeleteRed.png"));
		buttonIzlaz.setBounds(506, 358, 116, 42);
		
		Button buttonGenerisiPDF = new Button(this, SWT.NONE);
		buttonGenerisiPDF.setText("Generi\u0161i .pdf");
		buttonGenerisiPDF.setImage(SWTResourceManager.getImage(KorisniciPretragaForm.class, "/images/1398206257_pdf.png"));
		buttonGenerisiPDF.setBounds(10, 353, 119, 47);
		
		
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		shlPretragaKorisnika = new Shell();
		Group group = new Group(shlPretragaKorisnika, SWT.NONE);
		group.setText("Pretraga");
		group.setBounds(10, 10, 575, 107);
	}

	

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
