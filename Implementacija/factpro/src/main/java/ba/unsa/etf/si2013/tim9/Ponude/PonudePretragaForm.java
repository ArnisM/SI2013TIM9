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
import org.eclipse.wb.swt.SWTResourceManager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si2013.tim9.HibernateUtil;
import ba.unsa.etf.si2013.tim9.Klijenti.Klijenti;

public class PonudePretragaForm extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
//	protected Shell this;
	private Table table;
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			PonudePretragaForm shell = new PonudePretragaForm(display);
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
	public PonudePretragaForm(Display display) {
		super(display, SWT.SHELL_TRIM);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
//		this = new Shell();
		this.setImage(SWTResourceManager.getImage(PonudePretragaForm.class, "/images/1396674611_invoice.png"));
		this.setSize(623, 479);
		this.setText("Pretraga i ispis ponude");
		
		Group group = new Group(this, SWT.NONE);
		group.setText("Pretraga ponude");
		group.setBounds(10, 10, 575, 141);
		
		final Combo combo_1 = new Combo(group, SWT.NONE);
		combo_1.setBounds(339, 44, 149, 23);
		
		
		Button button = new Button(group, SWT.NONE);
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
		button.setImage(SWTResourceManager.getImage(PonudePretragaForm.class, "/images/1398199827_search_magnifying_glass_find.png"));
		button.setBounds(372, 85, 116, 35);
		
		Group group_1 = new Group(group, SWT.NONE);
		group_1.setText("Odabir");
		group_1.setBounds(10, 22, 142, 56);
		
		final Label label_1 = new Label(group, SWT.NONE);
		label_1.setText("Odabir firme:");
		label_1.setBounds(242, 47, 91, 15);
		
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
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 183, 575, 179);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("ID ponude");
		
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
		
		Label lblIzaberiteeljenuPonudu = new Label(this, SWT.NONE);
		lblIzaberiteeljenuPonudu.setText("Izaberite \u017Eeljenu ponudu:");
		lblIzaberiteeljenuPonudu.setBounds(10, 162, 136, 15);
		
		Button button_3 = new Button(this, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		button_3.setText("Izlaz");
		button_3.setImage(SWTResourceManager.getImage(PonudePretragaForm.class, "/images/1398195841_DeleteRed.png"));
		button_3.setBounds(469, 389, 116, 42);
		
		Button button_4 = new Button(this, SWT.NONE);
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				
				Shell shell = new Shell();
				MessageDialog.openInformation(shell, "Info", "Uspjesno je kreiran '.pdf' ponude.");
				/*
				 * File f = new File(System.getProperty("user.home")+"\\factpro\\pdfovi\\");
f.mkdirs();
PdfWriter.getInstance(document,new FileOutputStream(System.getProperty("user.home")+"\\factpro\\pdfovi\\usluga.pdf"));
				 * */
			}
		});
		button_4.setText("Generi\u0161i .pdf");
		button_4.setImage(SWTResourceManager.getImage(PonudePretragaForm.class, "/images/1398206257_pdf.png"));
		button_4.setBounds(10, 389, 132, 42);
		
		Button btnOk = new Button(this, SWT.NONE);
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			    
			}
		});
		btnOk.setText("Ok");
		btnOk.setImage(SWTResourceManager.getImage(PonudePretragaForm.class, "/images/1398195801_tick_32.png"));
		btnOk.setBounds(344, 389, 116, 42);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
