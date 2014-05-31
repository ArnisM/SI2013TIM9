package ba.unsa.etf.si2013.tim9.Predracuni;

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
import org.eclipse.wb.swt.SWTResourceManager;



import javax.persistence.GeneratedValue; 
import javax.persistence.Id;
import javax.persistence.Transient;

import java.util.Date;	
import java.util.List;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.hql.internal.ast.util.SessionFactoryHelper;

import ba.unsa.etf.si2013.tim9.HibernateUtil;
import ba.unsa.etf.si2013.tim9.Klijenti.Klijenti;

import org.hibernate.Query;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.TableItem;

import ba.unsa.etf.si2013.tim9.HibernateUtil;
import ba.unsa.etf.si2013.tim9.Usluge.Usluga;

public class PredracunBrisanjeForm extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
//	protected Shell this;
	private Table table;
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			PredracunBrisanjeForm shell = new PredracunBrisanjeForm(display);
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
	public PredracunBrisanjeForm(Display display) {
		super(display, SWT.SHELL_TRIM);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
//		this = new Shell();
		this.setImage(SWTResourceManager.getImage(PredracunBrisanjeForm.class, "/images/1396674611_invoice.png"));
		this.setSize(612, 469);
		this.setText("Brisanje predracuna");
		
		Group group = new Group(this, SWT.NONE);
		group.setText("Pretraga predracuna");
		group.setBounds(10, 0, 575, 146);
		
		final Combo combo_1 = new Combo(group, SWT.NONE);
		combo_1.setBounds(340, 56, 149, 23);
		
		// PRETRAGA DUGME I VALIDIRANO SVEE
		Button button = new Button(group, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				List _predracuna;
				
				if(combo_1.getSelectionIndex()!=-1)
				{
					table.removeAll();
				String x = combo_1.getItem(combo_1.getSelectionIndex());
				
				Session session = HibernateUtil.getSessionFactory().openSession();
			    Transaction t = session.beginTransaction();
				Query q = session.createQuery("from Predracun where naziv_firme=:naziv and deleted=:deleted");
		        q.setString("naziv", x);
		        q.setString("deleted", Integer.toString(0));
		        _predracuna=q.list();
		        t.commit();
		        session.close();
		        Predracun f =new Predracun();
		        
		        if(!_predracuna.isEmpty())
		        {
		        	
		        for (int i=0; i<_predracuna.size(); i++)
		        {
		        	
		        	f = (Predracun) _predracuna.get(i);	
		        TableItem item = new TableItem(table, 0, i);
		        
		        item.setText(0,Long.toString(f.getId()));
		        item.setText(1,Double.toString(f.getCijena()));
		        item.setText(2, f.getDatum_izdavanja().toString());
           	    item.setText(3,f.getNaziv_firme());
           	    item.setText(4,f.getIdpdv_firme());
		        }
				
				Shell shell = new Shell();
				MessageDialog.openInformation(shell, "Info", "Uspješno je izvršena pretraga. Listu klijenata možete vidjeti u tabeli ispod.");
			    }
				else
				{
					Shell shell = new Shell();
					MessageDialog.openInformation(shell, "Info", "Nema predracun prema ovom klijentu.");
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
		button.setImage(SWTResourceManager.getImage(PredracunBrisanjeForm.class, "/images/1398199827_search_magnifying_glass_find.png"));
		button.setBounds(373, 95, 116, 35);
		
		Group group_1 = new Group(group, SWT.NONE);
		group_1.setText("Odabir");
		group_1.setBounds(10, 22, 142, 56);
		
		final Label label_1 = new Label(group, SWT.NONE);
		label_1.setText("Odabir firme:");
		label_1.setBounds(243, 59, 91, 15);
		
		
		
		// ZA RADIO BUTTON FIRMEE
		Button button_1 = new Button(group_1, SWT.RADIO);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				label_1.setText("Odaberite firmu:");
				combo_1.removeAll();
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t = session.beginTransaction();			
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
		
		// ZA RADIO KLIJENTIII
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
		
		
		
		
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setSelection(-1);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 185, 575, 179);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("ID predracuna");
		
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
		
		Label label_2 = new Label(this, SWT.NONE);
		label_2.setText("Izaberite \u017Eeljenu predracun:");
		label_2.setBounds(10, 164, 136, 15);
		
		
		// BRISANJEEEE
		Button btnBrii = new Button(this, SWT.NONE);
		btnBrii.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				
				
				if(table.getSelectionIndex()!=-1)
				{
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t = session.beginTransaction();
				
				int ind=table.getSelectionIndex();
				TableItem ti=table.getItem(ind);
				
				Predracun myObject = (Predracun) session.load(Predracun.class,(long)(Integer.parseInt(ti.getText(0))));
				myObject.setDeleted(1);
				session.update(myObject);
			    session.getTransaction().commit();
			   
				Shell shell = new Shell();
				MessageDialog.openInformation(shell, "Info", "Uspješno je obrisana predracun.");
				
				table.removeAll();
				}
				else
				{
					Shell shell = new Shell();
					MessageDialog.openInformation(shell, "Info", "Nije selektovan predracun");
				}
				
			}
		});
		btnBrii.setText("Bri\u0161i");
		btnBrii.setImage(SWTResourceManager.getImage(PredracunBrisanjeForm.class, "/images/1398201739_Trash.png"));
		btnBrii.setBounds(346, 379, 116, 42);
		
		Button button_4 = new Button(this, SWT.NONE);
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				close();
				
			}
		});
		button_4.setText("Izlaz");
		button_4.setImage(SWTResourceManager.getImage(PredracunBrisanjeForm.class, "/images/1398195841_DeleteRed.png"));
		button_4.setBounds(469, 379, 116, 42);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
