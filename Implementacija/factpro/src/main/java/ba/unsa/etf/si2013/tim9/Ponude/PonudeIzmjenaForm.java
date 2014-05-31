package ba.unsa.etf.si2013.tim9.Ponude;

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
//import org.eclipse.wb.swt.IzmjenaFaktureTrenutneForm;
import org.eclipse.wb.swt.SWTResourceManager;
import org.hibernate.Query;
import org.hibernate.Session;

import ba.unsa.etf.si2013.tim9.HibernateUtil;
import ba.unsa.etf.si2013.tim9.Klijenti.Klijenti;

import org.hibernate.Transaction;
public class PonudeIzmjenaForm extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
//	protected Shell this;
	private Table table;
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			PonudeIzmjenaForm shell = new PonudeIzmjenaForm(display);
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
	public PonudeIzmjenaForm(Display display) {
		super(display, SWT.SHELL_TRIM);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
//		this = new Shell();
		this.setImage(SWTResourceManager.getImage(PonudeIzmjenaForm.class, "/images/1396674611_invoice.png"));
		this.setSize(610, 478);
		this.setText("Izmjena ponude");
		
		Group grpPretragaFakture = new Group(this, SWT.NONE);
		grpPretragaFakture.setText("Pretraga ponude");
		grpPretragaFakture.setBounds(10, 10, 575, 145);
		final Combo combo_1 = new Combo(grpPretragaFakture, SWT.NONE);
		combo_1.setBounds(333, 47, 149, 23);
		
		Button button = new Button(grpPretragaFakture, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
                List _ponude;
				
				if(combo_1.getSelectionIndex()!=-1)
				{
					table.removeAll();
				String x = combo_1.getItem(combo_1.getSelectionIndex());
				
				Session session = HibernateUtil.getSessionFactory().openSession();
			    Transaction t = session.beginTransaction();
				Query q = session.createQuery("from Ponuda where naziv_firme=:naziv and deleted=:del");
		        q.setString("naziv", x);
		        q.setString("del", Integer.toString(0));
		        _ponude=q.list();
		        t.commit();
		        session.close();
		        Ponuda f =new Ponuda();
		        
		        if(!_ponude.isEmpty())
		        {
		        	
		        for (int i=0; i<_ponude.size(); i++)
		        {
		        	
		        	f = (Ponuda) _ponude.get(i);	
		        TableItem item = new TableItem(table, 0, i);
		        
		        item.setText(0,Long.toString(f.getId()));
		        item.setText(1,Double.toString(f.getCijena()));
		        item.setText(2, f.getDatum_izdavanja().toString());
           	    item.setText(3,f.getNaziv_firme());
           	    item.setText(4,f.getIdpdv_firme());
		        }
				
				Shell shell = new Shell();
				MessageDialog.openInformation(shell, "Info", "UspjeA!no je izvrA!ena pretraga. Listu klijenata moA3ete vidjeti u tabeli ispod.");
			    }
				else
				{
					Shell shell = new Shell();
					MessageDialog.openInformation(shell, "Info", "Nema ponuda prema ovom klijentu.");
				}
				}
				else
				{
					Shell shell = new Shell();
					MessageDialog.openInformation(shell, "Info", "Morate izabrati klijenta.");
				}
				
				
				
			}
		});
		button.setText("Pretraga");
		button.setImage(SWTResourceManager.getImage(PonudeIzmjenaForm.class, "/images/1398199827_search_magnifying_glass_find.png"));
		button.setBounds(367, 86, 116, 35);
		
		Group group_1 = new Group(grpPretragaFakture, SWT.NONE);
		group_1.setText("Odabir");
		group_1.setBounds(10, 22, 142, 56);
		
		
		
		final Label label_1 = new Label(grpPretragaFakture, SWT.NONE);
		label_1.setText("Odabir firme:");
		label_1.setBounds(236, 50, 91, 15);
		
		//RADIO BUTTON ZA FIRMU SELECT
		Button button_1 = new Button(group_1, SWT.RADIO);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				label_1.setText("Odaberite firmu:");
				combo_1.removeAll();
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t =  session.beginTransaction();			
				List klijenti = session.createQuery("from Klijenti where tip='firma'").list();
		        t.commit();
		        session.close();
		        Klijenti k=new Klijenti();
		        
		        if(!klijenti.isEmpty()){
		        for(int i=0; i<klijenti.size();i++)
		        {
		        	
		        k=(Klijenti)klijenti.get(i);
		        combo_1.add(k.getNaziv(),i);
		        
		        }
				}
				
			}
		});
		button_1.setText("Firma");
		button_1.setBounds(54, 10, 90, 16);
		
		
		// RADIO ZA KLIJENTEEEE
		Button button_2 = new Button(group_1, SWT.RADIO);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				label_1.setText("Izaberite klijenta:");
				combo_1.removeAll();
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t = session.beginTransaction();			
				List klijenti = session.createQuery("from Klijenti where tip='fizickoLice'").list();
		        t.commit();
		        session.close();
		        Klijenti k=new Klijenti();
		        
		        if(!klijenti.isEmpty()){
		        for(int i=0; i<klijenti.size();i++)
		        {
		        	
		        k=(Klijenti)klijenti.get(i);
		        combo_1.add(k.getNaziv(),i);
		        
		        }
				}
				
			}
		});
		button_2.setText("Fizi\u010Dko lice");
		button_2.setBounds(54, 32, 78, 16);
		
		
		
		
		
		Label lblIzaberiteeljenuFakturu = new Label(this, SWT.NONE);
		lblIzaberiteeljenuFakturu.setText("Izaberite \u017Eeljenu fakturu:");
		lblIzaberiteeljenuFakturu.setBounds(10, 177, 136, 15);
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 198, 575, 179);
		
		TableColumn tblclmnIdFakture = new TableColumn(table, SWT.NONE);
		tblclmnIdFakture.setWidth(100);
		tblclmnIdFakture.setText("ID ponude");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(137);
		tableColumn_1.setText("Ukupna cijena sa pdf");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("Datum kreiranja");
		
		TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(100);
		tableColumn_3.setText("Naziv firme");
		
		TableColumn tableColumn_4 = new TableColumn(table, SWT.NONE);
		tableColumn_4.setWidth(132);
		tableColumn_4.setText("PDV broj");
		
		Button button_3 = new Button(this, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		button_3.setText("Izlaz");
		button_3.setImage(SWTResourceManager.getImage(PonudeIzmjenaForm.class, "/images/1398195841_DeleteRed.png"));
		button_3.setBounds(469, 388, 116, 42);
		
		Button btnIzmjeni = new Button(this, SWT.NONE);
		btnIzmjeni.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				if(table.getSelectionIndex()!=-1)
				{
				int iti = table.getSelectionIndex();
				TableItem ti=table.getItem(iti);
				long x = Long.parseLong(ti.getText(0), 10);
				
				PonudeTrenutnaIzmjenaForm a= new PonudeTrenutnaIzmjenaForm(null,x);
				a.open();
				
				table.removeAll();
				}
				else
				{
					Shell shell = new Shell();
					MessageDialog.openInformation(shell, "Info", "Morate izabrati fakturu.");
				}

			}
		});
		btnIzmjeni.setText("Izmjeni");
		btnIzmjeni.setImage(SWTResourceManager.getImage(PonudeIzmjenaForm.class, "/images/1398574614_switch_on.png"));
		btnIzmjeni.setBounds(346, 388, 116, 42);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
