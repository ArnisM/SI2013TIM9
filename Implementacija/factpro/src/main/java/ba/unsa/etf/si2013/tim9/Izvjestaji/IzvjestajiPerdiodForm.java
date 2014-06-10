package ba.unsa.etf.si2013.tim9.Izvjestaji;

import java.io.File;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64.OutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import ba.unsa.etf.si2013.tim9.Fakture.*;
import ba.unsa.etf.si2013.tim9.Klijenti.Klijenti;

public class IzvjestajiPerdiodForm {

	protected Shell shell;
	private Text text;
	private Table table;
	private Text text_1;
	private Table table_1;
	//List<Faktura>fakture;
	private java.util.List <Faktura> fakture;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			IzvjestajiPerdiodForm window = new IzvjestajiPerdiodForm();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setImage(SWTResourceManager.getImage(IzvjestajiPerdiodForm.class, "/images/1396674755_519958-021_Document_Text.png"));
		shell.setSize(523, 490);
		shell.setText("Izvje\u0161taji periodi\u010Dni");
		
		TabFolder tabFolder = new TabFolder(shell, SWT.NONE);
		tabFolder.setBounds(10, 10, 495, 443);
		
		TabItem tbtmGodinji = new TabItem(tabFolder, SWT.NONE);
		tbtmGodinji.setText("Godi\u0161nji");
		
		Group group = new Group(tabFolder, SWT.NONE);
		tbtmGodinji.setControl(group);
		
		Group group_2 = new Group(group, SWT.NONE);
		group_2.setText("Rezultat izvje\u0161taja");
		group_2.setBounds(10, 74, 467, 285);
		
		Label label_1 = new Label(group_2, SWT.NONE);
		label_1.setText("Ukupni promet:");
		label_1.setBounds(10, 30, 92, 15);
		
		final Label label_2 = new Label(group_2, SWT.NONE);
		label_2.setBounds(116, 30, 55, 15);
		
		Label label_3 = new Label(group_2, SWT.NONE);
		label_3.setText("Izlazne fakture:");
		label_3.setBounds(10, 50, 92, 15);
		
		table = new Table(group_2, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 71, 447, 177);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(68);
		tblclmnNewColumn.setText("ID fakture");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(93);
		tblclmnNewColumn_1.setText("Ukupna cijena");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(115);
		tblclmnNewColumn_2.setText("Datum kreiranja");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(111);
		tblclmnNewColumn_3.setText("Naziv klijenta");
		
		TableColumn tblclmnKomentar = new TableColumn(table, SWT.NONE);
		tblclmnKomentar.setWidth(100);
		tblclmnKomentar.setText("PDV broj");
		
		Button btnGenerisiIzvjestaj = new Button(group, SWT.NONE);
		btnGenerisiIzvjestaj.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t = (Transaction) session.beginTransaction();
				Query q = session.createQuery("from Faktura where year(datum_izdavanja)=:godina and deleted=:deleted");
				q.setInteger("deleted", 0);
		        q.setString("godina",text.getText() );		        
		        fakture= q.list(); 
		        t.commit();
		        
		        Faktura f=new Faktura();
		        
		        for (int i=0; i<fakture.size(); i++){
		        f = (Faktura) ((java.util.List) fakture).get(i);        	
		        Transaction t1 = (Transaction) session.beginTransaction();
		         TableItem item = new TableItem(table, 0, i);
		         DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		         String datum = df.format(f.getDatum_izdavanja());
		         String s = Objects.toString(f.getId(), null);
		        item.setText(0,s);
           	    item.setText(1,Double.toString(f.getCijena()));
             	item.setText(2,datum);
             	Query q1= session.createQuery("from Klijenti where id=:id");
             	q1.setLong("id",f.getIdklijent());
             	java.util.List <Klijenti> k = q1.list();
             	t1.commit();
           	    item.setText(3,k.get(0).getNaziv());
           	    item.setText(4,Integer.toString(k.get(0).getPdvbroj()));
           	    
           	 
		        
           	    
		        }
		        
		        
		        session.close();
		        
		        
				
								
				Shell shell = new Shell ();
				MessageDialog.openInformation(shell, "Generisanje izvjeï¿½taja", "Uspjeï¿½no je kreiran godiï¿½nji izvjeï¿½taj.");
				
			}
		});
		btnGenerisiIzvjestaj.setText("Generisi izvjestaj");
		btnGenerisiIzvjestaj.setImage(SWTResourceManager.getImage(IzvjestajiPerdiodForm.class, "/images/1398195801_tick_32.png"));
		btnGenerisiIzvjestaj.setBounds(183, 365, 133, 38);
		
		Button button_3 = new Button(group, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		button_3.setText("Izlaz");
		button_3.setImage(SWTResourceManager.getImage(IzvjestajiPerdiodForm.class, "/images/1398195841_DeleteRed.png"));
		button_3.setBounds(360, 365, 117, 38);
		
		Label lblIzaberiteGodinu = new Label(group, SWT.NONE);
		lblIzaberiteGodinu.setBounds(10, 31, 96, 15);
		lblIzaberiteGodinu.setText("Unesite godinu:");
		
		text = new Text(group, SWT.BORDER);
		text.setText("2014");
		text.setBounds(133, 28, 76, 19);
		
		Button button_2 = new Button(group, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Session session = HibernateUtil.getSessionFactory().openSession();
			      FileOutputStream file;
				try {
					
					File fu = new File(System.getProperty("user.home")+"\\factpro\\pdfovi\\");
					fu.mkdirs();
					//PdfWriter.getInstance(document,new FileOutputStream(System.getProperty("user.home")+"\\factpro\\pdfovi\\usluga.pdf"));
					file = new FileOutputStream(new File(System.getProperty("user.home")+"\\factpro\\pdfovi\\mjesečniIzvještaj.pdf"));
				
			      Document document = new Document();
			      PdfWriter.getInstance(document, file);
			      document.open();
			      int i=table.getSelectionIndex();
			      document.addAuthor("Factpro");
		            document.addCreationDate();
		            document.addLanguage("EN");

		            document.add(new Paragraph("Factpro",new Font(Font.FontFamily.HELVETICA  , 5, Font.BOLD)));
		            document.add(new Paragraph("________________________________________________________________________"
		            		+ "_________________________________________________________________________________"
		            		+ "_________________________",new Font(Font.FontFamily.HELVETICA  , 5, Font.BOLD)));
		            
			       document.addTitle("Mjesečni izvještaj");
			       Paragraph naslov=new Paragraph("\n Mjesečni izvještaj",new Font(Font.FontFamily.HELVETICA  , 18, Font.BOLD));
		            naslov.setAlignment(Element.ALIGN_CENTER);
		            document.add(naslov);
		            Font pisanje=new Font(Font.FontFamily.HELVETICA  , 14, Font.NORMAL);
		            
		            document.add(new Chunk("\n",pisanje));        
		            
			      document.add(new Chunk("ID fakture: " + fakture.get(i).getId(), pisanje ));
			      document.add(new Chunk("Cijena: " + fakture.get(i).getCijena(), pisanje ));
			      document.add(new Chunk("Datum: " + fakture.get(i).getDatum_izdavanja(), pisanje));
			      
			      Transaction t1 = (Transaction) session.beginTransaction();
			      Query q1= session.createQuery("from Klijenti where id=:id and deleted=:deleted");
			      	q1.setInteger("deleted", 0);
	             	q1.setLong("id",fakture.get(1).getIdklijent());
	             	java.util.List <Klijenti> k = q1.list();
	             	t1.commit();
	             	session.close();
			     document.add(new Paragraph("Naziv klijenta: " + k.get(0).getNaziv() ));
			     document.add(new Paragraph("PDV broj: " + k.get(0).getPdvbroj()));
			      document.add(new Paragraph(new Date().toString()));
			      
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
		button_2.setText("Generi\u0161i .pdf");
		button_2.setImage(SWTResourceManager.getImage(IzvjestajiPerdiodForm.class, "/images/1398206257_pdf.png"));
		button_2.setBounds(10, 365, 132, 42);
		
		TabItem tbtmMjeseni = new TabItem(tabFolder, SWT.NONE);
		tbtmMjeseni.setText("Mjese\u010Dni");
		
		Group group_1 = new Group(tabFolder, SWT.NONE);
		tbtmMjeseni.setControl(group_1);
		
		Group group_3 = new Group(group_1, SWT.NONE);
		group_3.setText("Rezultat izvje\u0161taja");
		group_3.setBounds(10, 74, 467, 285);
		
		Label label = new Label(group_3, SWT.NONE);
		label.setText("Ukupni promet:");
		label.setBounds(10, 30, 92, 15);
		
		final Label label_4 = new Label(group_3, SWT.NONE);
		label_4.setBounds(116, 30, 55, 15);
		
		Label label_5 = new Label(group_3, SWT.NONE);
		label_5.setText("Izlazne fakture:");
		label_5.setBounds(10, 50, 92, 15);
		
		table_1 = new Table(group_3, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setLinesVisible(true);
		table_1.setHeaderVisible(true);
		table_1.setBounds(10, 70, 447, 177);
		
		TableColumn tableColumn = new TableColumn(table_1, SWT.NONE);
		tableColumn.setWidth(68);
		tableColumn.setText("ID fakture");
		
		TableColumn tableColumn_1 = new TableColumn(table_1, SWT.NONE);
		tableColumn_1.setWidth(83);
		tableColumn_1.setText("Ukupna cijena");
		
		TableColumn tableColumn_2 = new TableColumn(table_1, SWT.NONE);
		tableColumn_2.setWidth(115);
		tableColumn_2.setText("Datum kreiranja");
		
		TableColumn tableColumn_3 = new TableColumn(table_1, SWT.NONE);
		tableColumn_3.setWidth(111);
		tableColumn_3.setText("Naziv klijenta");
		
		TableColumn tableColumn_4 = new TableColumn(table_1, SWT.NONE);
		tableColumn_4.setWidth(100);
		tableColumn_4.setText("PDV broj");
		
		Button btnGenerisiIzvjestaj_1 = new Button(group_1, SWT.NONE);
		btnGenerisiIzvjestaj_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t = (Transaction) session.beginTransaction();
				Query q = session.createQuery("from Faktura where month(datum_izdavanja)=:mjesec");
		        q.setString("mjesec",text.getText() );		        
		        fakture= q.list(); 
		        t.commit();
		        
		        Faktura f=new Faktura();
		        
		        for (int i=0; i<fakture.size(); i++){
		        f = (Faktura) ((java.util.List) fakture).get(i);        	
		        Transaction t1 = (Transaction) session.beginTransaction();
		         TableItem item = new TableItem(table, 0, i);
		         DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		         String datum = df.format(f.getDatum_izdavanja());
		         String s = Objects.toString(f.getId(), null);
		        item.setText(0,s);
           	    item.setText(1,Double.toString(f.getCijena()));
             	item.setText(2,datum);
             	Query q1= session.createQuery("from Klijenti where id=:id");
             	q1.setLong("id",f.getIdklijent());
             	java.util.List <Klijenti> k = q1.list();
             	t1.commit();
           	    item.setText(3,k.get(0).getNaziv());
           	    item.setText(4,Integer.toString(k.get(0).getPdvbroj()));
           	    
           	 
		        
           	    
		        }
		        
		        
		        session.close();
		        
		        
				
								
				Shell shell = new Shell ();
				MessageDialog.openInformation(shell, "Generisanje izvjeï¿½taja", "Uspjeï¿½no je kreiran mjesecni izvjeï¿½taj.");
				
			}
		});
		btnGenerisiIzvjestaj_1.setText("Generisi izvjestaj");
		btnGenerisiIzvjestaj_1.setImage(SWTResourceManager.getImage(IzvjestajiPerdiodForm.class, "/images/1398195801_tick_32.png"));
		btnGenerisiIzvjestaj_1.setBounds(198, 365, 133, 38);
		
		Button button_1 = new Button(group_1, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		button_1.setText("Izlaz");
		button_1.setImage(SWTResourceManager.getImage(IzvjestajiPerdiodForm.class, "/images/1398195841_DeleteRed.png"));
		button_1.setBounds(360, 365, 117, 38);
		
		Label lblIzaberiteMjesec = new Label(group_1, SWT.NONE);
		lblIzaberiteMjesec.setText("Unesite mjesec:");
		lblIzaberiteMjesec.setBounds(23, 31, 96, 15);
		
		text_1 = new Text(group_1, SWT.BORDER);
		text_1.setText("1");
		text_1.setBounds(133, 28, 76, 19);
		
		Button btnGenerisipdf = new Button(group_1, SWT.NONE);
		btnGenerisipdf.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Session session = HibernateUtil.getSessionFactory().openSession();
			      FileOutputStream file;
				try {
					file = new FileOutputStream(new File("target/fakture.pdf\\"));
				
			      Document document = new Document();
			      PdfWriter.getInstance(document, file);
			      document.open();
			      int i=table.getSelectionIndex();
			       document.addTitle("Godišnji izvještaj");
			      document.add(new Paragraph("ID fakture: " + fakture.get(i).getId() ));
			      document.add(new Paragraph("Cijena: " + fakture.get(i).getCijena() ));
			      document.add(new Paragraph("Datum: " + fakture.get(i).getDatum_izdavanja()));
			      
			      Transaction t1 = (Transaction) session.beginTransaction();
			      Query q1= session.createQuery("from Klijenti where id=:id");
	             	q1.setLong("id",fakture.get(1).getIdklijent());
	             	java.util.List <Klijenti> k = q1.list();
	             	t1.commit();
	             	session.close();
			     document.add(new Paragraph("Naziv klijenta: " + k.get(0).getNaziv() ));
			     document.add(new Paragraph("PDV broj: " + k.get(0).getPdvbroj()));
			      document.add(new Paragraph(new Date().toString()));
			      
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
		btnGenerisipdf.setText("Generisi .pdf");
		btnGenerisipdf.setImage(SWTResourceManager.getImage(IzvjestajiPerdiodForm.class, "/images/1398206257_pdf.png"));
		btnGenerisipdf.setBounds(20, 361, 132, 42);

	}
}