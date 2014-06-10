package ba.unsa.etf.si2013.tim9.Predracuni;

import java.io.File;

import com.itextpdf.text.pdf.PdfPCell;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import ba.unsa.etf.si2013.tim9.HibernateUtil;
import ba.unsa.etf.si2013.tim9.Klijenti.Klijenti;
import ba.unsa.etf.si2013.tim9.Usluge.Usluga;

public class PredracunPretragaForm extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
//	protected Shell this;
	private Table table;
	List<Predracun> _fakture;
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			PredracunPretragaForm shell = new PredracunPretragaForm(display);
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
	public PredracunPretragaForm(Display display) {
		super(display, SWT.SHELL_TRIM);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
//		this = new Shell();
		this.setImage(SWTResourceManager.getImage(PredracunPretragaForm.class, "/images/1396674611_invoice.png"));
		this.setSize(623, 479);
		this.setText("Pretraga i ispis predracuna");
		
		Group group = new Group(this, SWT.NONE);
		group.setText("Pretraga predracuna");
		group.setBounds(10, 10, 575, 141);
		
		final Combo combo_1 = new Combo(group, SWT.NONE);
		combo_1.setBounds(339, 44, 149, 23);
		
		
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
				Query q = session.createQuery("from Predracun where naziv_firme=:naziv and deleted=:del");
		        q.setString("naziv", x);
		        q.setString("del", Integer.toString(0));
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
				MessageDialog.openInformation(shell, "Info", "UspjeÅ¡no je izvrÅ¡ena pretraga. Listu klijenata moÅ¾ete vidjeti u tabeli ispod.");
				
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
		button.setImage(SWTResourceManager.getImage(PredracunPretragaForm.class, "/images/1398199827_search_magnifying_glass_find.png"));
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
		label_2.setText("Izaberite \u017Eeljenu fakturu:");
		label_2.setBounds(10, 162, 136, 15);
		
		Button button_3 = new Button(this, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		button_3.setText("Izlaz");
		button_3.setImage(SWTResourceManager.getImage(PredracunPretragaForm.class, "/images/1398195841_DeleteRed.png"));
		button_3.setBounds(469, 389, 116, 42);
		
		Button button_4 = new Button(this, SWT.NONE);
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				List<Predracun> fakture;
				Session session = HibernateUtil.getSessionFactory().openSession();
			      FileOutputStream file;
				try {
					file = new FileOutputStream(new File("target/predracun.pdf"));
				List<Stavka_predracuna>stavka_fakture;
				List<Usluga>usluge;
				List<Klijenti>klijenti;
			      Document document = new Document();
			      PdfWriter.getInstance(document, file);
			      document.open();
			      int i=table.getSelectionIndex();
			       document.addTitle("predracun");
			       Transaction tk = session.beginTransaction();			
	        		Query qk = session.createQuery("from Klijenti where id=:id");
	        		qk.setLong("id",_fakture.get(i).getIdklijent());
	                klijenti=qk.list();
	                tk.commit();
	               
		        		//Session session = HibernateUtil.getSessionFactory().openSession();
		        				             	
		             	Klijenti k=klijenti.get(0);
				     document.add(new Paragraph("Naziv klijenta: " + k.getNaziv() ));
				     document.add(new Paragraph("PDV broj: " + k.getPdvbroj()));
				      
			      Paragraph p=new Paragraph("Mjesto izdavanja:"+_fakture.get(i).getMjesto_izdavanja());
			      p.setAlignment(Element.ALIGN_RIGHT);
			      document.add(p);
			      Paragraph p1=new Paragraph("Datum izdavanja:"+_fakture.get(i).getDatum_izdavanja());
			      p1.setAlignment(Element.ALIGN_RIGHT);
			      document.add(p1);
			      
			      Paragraph fi=new Paragraph("predracun");
			      fi.setAlignment(Element.ALIGN_CENTER);
			      document.add(fi);
			      
			      Paragraph p2=new Paragraph("Broj predracun:"+_fakture.get(i).getBroj_predracuna());
			      p2.setAlignment(Element.ALIGN_LEFT);
			      document.add(p2);
			      
			     
		            
		            PdfPTable my_first_table = new PdfPTable(5);            
		            
		            my_first_table.addCell("Pos"); 
		            my_first_table.addCell(new PdfPCell(new Phrase("Opis"))); 
		            my_first_table.addCell(new PdfPCell(new Phrase("Količina"))); 
		            my_first_table.addCell(new PdfPCell(new Phrase("Jed.cijena bez PDV"))); 
		            my_first_table.addCell(new PdfPCell(new Phrase("Cijena sa PDV"))); 
		            Transaction t = session.beginTransaction();			
	        		Query q = session.createQuery("from predracun where id=:brojic");
	        		q.setLong("brojic",_fakture.get(i).getId());
	                fakture=q.list();
	                t.commit();
	                session.close();
	                Predracun f=new Predracun();
	                
	                f=(Predracun)fakture.get(0);
	                

	               List _ss;
	        		session = HibernateUtil.getSessionFactory().openSession();
	        		t = session.beginTransaction();			
	        		q = session.createQuery("from Stavka_predracun where idpredracun=:idpredracun");
	                q.setLong("idpredracun",_fakture.get(i).getId());
	               _ss=q.list();
	                t.commit();
	               session.close();
	               

	               Stavka_predracuna s = new Stavka_predracuna();
	               
	               List _usluge1;
	               for(int ilj=0; ilj<_ss.size(); ilj++)
	               {
	            	   s=(Stavka_predracuna)_ss.get(ilj);
	            	   
	            	   session = HibernateUtil.getSessionFactory().openSession();
	           		   t = session.beginTransaction();			
	           		   q = session.createQuery("from Usluga where id=:id");
	                   q.setString("id",Long.toString(s.getIDUsluga()));
	                   
	                  
	                   _usluge1=q.list();
	                   t.commit();
	                  session.close();
	                  for (int ui=0; ui<_usluge1.size(); ui++){
	                  Usluga u= new Usluga();
	                  u=(Usluga)_usluge1.get(0);
	                  my_first_table.completeRow();
	                  my_first_table.addCell(new PdfPCell(new Phrase(u.getId()))); 
			            my_first_table.addCell(new PdfPCell(new Phrase(u.getNaziv()))); 
			            my_first_table.addCell(new PdfPCell(new Phrase(f.getBroj_usluga()))); 
			            my_first_table.addCell(new PdfPCell(new Phrase(Double.toString(u.getCijena())))); 
			            my_first_table.addCell(new PdfPCell(new Phrase(Double.toString(u.getCijena()))));
	                  
	                  }
	               }
		             	
	               my_first_table.completeRow();
		            
		          
		            document.add(my_first_table);                       
		            document.add(new Paragraph("Ukupna cijena sa PDV:" + _fakture.get(i).getCijena())); 
		            document.add(new Paragraph(_fakture.get(i).getKomentar()));
			      
			      document.close();
			      file.close();
			      
			      Shell shell1 = new Shell();
				MessageDialog.openInformation(shell1, "Generisanje pdf", "PDF je generisan!");
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
		
				
			
				
			}
		});
		button_4.setText("Generi\u0161i .pdf");
		button_4.setImage(SWTResourceManager.getImage(PredracunPretragaForm.class, "/images/1398206257_pdf.png"));
		button_4.setBounds(10, 389, 132, 42);
		
		Button btnOk = new Button(this, SWT.NONE);
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			    
			}
		});
		btnOk.setText("Ok");
		btnOk.setImage(SWTResourceManager.getImage(PredracunPretragaForm.class, "/images/1398195801_tick_32.png"));
		btnOk.setBounds(344, 389, 116, 42);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}

