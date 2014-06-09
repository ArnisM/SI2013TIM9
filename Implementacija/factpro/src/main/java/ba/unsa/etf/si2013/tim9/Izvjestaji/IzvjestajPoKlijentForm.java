package ba.unsa.etf.si2013.tim9.Izvjestaji;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.wb.swt.SWTResourceManager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import ba.unsa.etf.si2013.tim9.Fakture.Faktura;
import ba.unsa.etf.si2013.tim9.Klijenti.Klijenti;

public class IzvjestajPoKlijentForm {

	protected Shell shell;
	java.util.List klijenti;
	java.util.List fakture;
	java.util.List faktureg;
	java.util.List fakturem;
	java.util.List faktured;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			IzvjestajPoKlijentForm window = new IzvjestajPoKlijentForm();
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
		shell.setImage(SWTResourceManager.getImage(IzvjestajPoKlijentForm.class, "/images/1396674755_519958-021_Document_Text.png"));
		shell.setSize(419, 499);
		shell.setText("Izvje\u0161taj po klijentu");
		
		TabFolder tabFolder = new TabFolder(shell, SWT.NONE);
		tabFolder.setBounds(10, 10, 383, 441);
		
		TabItem tbtmGodinji = new TabItem(tabFolder, SWT.NONE);
		tbtmGodinji.setText("Godi\u0161nji");
		
		Group group = new Group(tabFolder, SWT.NONE);
		tbtmGodinji.setControl(group);
		
		final Combo combo = new Combo(group, SWT.NONE);
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				
			}
		});
		//combo.setItems(new String[] {"Mercator", "Interex", "Robot", "Bingo"});
		combo.setBounds(203, 41, 126, 23);
		
		Group grpKlijenti = new Group(group, SWT.NONE);
		grpKlijenti.setText("Klijenti");
		grpKlijenti.setBounds(10, 10, 154, 82);
		
		final Label lblIzaberiteKlijenta = new Label(group, SWT.NONE);
		lblIzaberiteKlijenta.setBounds(203, 20, 88, 15);
		lblIzaberiteKlijenta.setText("Izaberite klijenta:");
		
		Button btnFirme = new Button(grpKlijenti, SWT.RADIO);
		btnFirme.setSelection(true);
		btnFirme.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblIzaberiteKlijenta.setText("Izaberite klijenta:");
				combo.removeAll();
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t = session.beginTransaction();			
				java.util.List<Klijenti> klijenti =  session.createQuery("from Klijenti where tip='firma'").list();
		        t.commit();
		        session.close();
		        Klijenti k=new Klijenti();
		        
		        if(!((java.util.List) klijenti).isEmpty()){
		        for(int i=0; i<klijenti.size();i++)
		        {
		        	
		        k=(Klijenti)klijenti.get(i);
		        combo.add(k.getNaziv(),i);
		        }
			}}
		});
		btnFirme.setBounds(29, 24, 90, 16);
		btnFirme.setText("Firme");
		
		Button btnFizikaLica = new Button(grpKlijenti, SWT.RADIO);
		btnFizikaLica.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblIzaberiteKlijenta.setText("Izaberite klijenta:");
				combo.removeAll();
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t = session.beginTransaction();			
				java.util.List<Klijenti> klijenti =  session.createQuery("from Klijenti where tip='fizickoLice'").list();
		        t.commit();
		        session.close();
		        Klijenti k=new Klijenti();
		        
		        if(!((java.util.List) klijenti).isEmpty()){
		        for(int i=0; i<klijenti.size();i++)
		        {
		        	
		        k=(Klijenti)klijenti.get(i);
		        combo.add(k.getNaziv(),i);
		        }
		        }}
		});
		btnFizikaLica.setBounds(29, 46, 90, 16);
		btnFizikaLica.setText("Fizi\u010Dka lica");
		
		
		
		Group grpRezultatIzvjetaja = new Group(group, SWT.NONE);
		grpRezultatIzvjetaja.setText("Rezultat izvje\u0161taja");
		grpRezultatIzvjetaja.setBounds(10, 108, 355, 251);
		
		Label lblUkupniPromet = new Label(grpRezultatIzvjetaja, SWT.NONE);
		lblUkupniPromet.setBounds(10, 30, 92, 15);
		lblUkupniPromet.setText("Ukupni promet:");
		
		final Label label = new Label(grpRezultatIzvjetaja, SWT.NONE);
		label.setBounds(116, 30, 55, 15);
		label.setText("0");
		
		final List list = new List(grpRezultatIzvjetaja, SWT.BORDER);
		list.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
		});
		list.setItems(new String[] {});
		list.setBounds(10, 71, 171, 170);
		
		Label lblFakture = new Label(grpRezultatIzvjetaja, SWT.NONE);
		lblFakture.setText("Izlazne fakture:");
		lblFakture.setBounds(10, 50, 92, 15);
		
		Button btnOk = new Button(group, SWT.NONE);
		btnOk.setBounds(20, 365, 117, 38);
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Session session = HibernateUtil.getSessionFactory().openSession();
			      FileOutputStream file;
				try {
					file = new FileOutputStream(new File("src/main/resources/dokumenti/poKlijentuGodišnjiIzvještaj.pdf"));
				
			      Document document = new Document();
			      PdfWriter.getInstance(document, file);
			      document.open();
			      int i=list.getSelectionIndex();
			      document.addAuthor("Factpro");
		            document.addCreationDate();
		            document.addLanguage("EN");

		            document.add(new Paragraph("Factpro",new Font(Font.FontFamily.HELVETICA  , 5, Font.BOLD)));
		            document.add(new Paragraph("________________________________________________________________________"
		            		+ "_________________________________________________________________________________"
		            		+ "_________________________",new Font(Font.FontFamily.HELVETICA  , 5, Font.BOLD)));
		          
			       Paragraph naslov=new Paragraph("\n Godišnji izvještaj po klijentu",new Font(Font.FontFamily.HELVETICA  , 18, Font.BOLD));
		            naslov.setAlignment(Element.ALIGN_CENTER);
		            document.add(naslov);
		            Font pisanje=new Font(Font.FontFamily.HELVETICA  , 14, Font.NORMAL);
		            
		            document.add(new Chunk("\n",pisanje));        
		            
		            
				       
				      document.add(new Chunk("ID fakture: " + ((Faktura) faktureg.get(i)).getId(), pisanje ));
				     document.add(new Chunk("Cijena: " + ((Faktura) faktureg.get(i)).getCijena(), pisanje ));
				      document.add(new Chunk("Datum: " + ((Faktura) faktureg.get(i)).getDatum_izdavanja(), pisanje));
				      document.add(new Chunk(new Date().toString(), pisanje));
			      
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
				
				
				
				
				Shell shell = new Shell ();
				MessageDialog.openInformation(shell, "Generisanje izvjestaja", "Uspješno je kreiran mjesečni izvještaj.");
			}
		});
		btnOk.setText("Generiši .pdf");
		btnOk.setImage(SWTResourceManager.getImage(IzvjestajPoKlijentForm.class, "/images/1398206257_pdf.png"));
		
		Button button_1 = new Button(group, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		button_1.setBounds(248, 365, 117, 38);
		button_1.setText("Izlaz");
		button_1.setImage(SWTResourceManager.getImage(IzvjestajPoKlijentForm.class, "/images/1398195841_DeleteRed.png"));
		
		TabItem tbtmMjeseni = new TabItem(tabFolder, SWT.NONE);
		tbtmMjeseni.setText("Mjese\u010Dni");
		
		Group group_1 = new Group(tabFolder, SWT.NONE);
		tbtmMjeseni.setControl(group_1);
		
		final Combo combo_1 = new Combo(group_1, SWT.NONE);
		combo_1.setItems(new String[] {"Interex", "Bingo", "Robot"});
		combo_1.setBounds(239, 17, 126, 23);
		combo_1.setText("Mercator\r\n");
		
		Group group_3 = new Group(group_1, SWT.NONE);
		group_3.setText("Rezultat izvje\u0161taja");
		group_3.setBounds(10, 108, 355, 251);
		
		final List list_1 = new List(group_3, SWT.BORDER);
		list_1.setItems(new String[] {});
		list_1.setBounds(10, 71, 171, 170);
		
		Button btnIspisiFakture = new Button(group, SWT.NONE);
		btnIspisiFakture.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try{
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t = (Transaction) session.beginTransaction();
				Query q = session.createQuery("from Klijenti where naziv=:naziv");
		        q.setString("naziv",combo.getItem(combo.getSelectionIndex()));		        
		        klijenti= q.list(); 
		        t.commit();
		        Klijenti kk=new Klijenti();
		        kk=(Klijenti)klijenti.get(0);
		        
		        Transaction t1 = (Transaction) session.beginTransaction();
				Query q1 = session.createQuery("from Faktura where idklijent=:idklijent");
		        q1.setLong("idklijent",kk.getId());	
		        	
		        faktureg= q1.list(); 
		        t1.commit();
		        
		        Faktura f=new Faktura();
		        
		        for (int i=0; i<faktureg.size(); i++){
		        f =(Faktura)faktureg.get(i);        	
		       
		         String s = Objects.toString(f.getId(), null);
		        list.add(s, i);
		       session.close();
				
		       
			} }catch(Exception e9){}}
		});
		btnIspisiFakture.setBounds(203, 67, 126, 25);
		btnIspisiFakture.setText("Ispisi fakture");
		
	
		
	
		
		Group group_2 = new Group(group_1, SWT.NONE);
		group_2.setText("Klijenti");
		group_2.setBounds(10, 10, 154, 82);
		final Label label_1 = new Label(group_1, SWT.NONE);
		label_1.setText("Izaberite klijenta:");
		label_1.setBounds(170, 20, 55, 15);
		Button button = new Button(group_2, SWT.RADIO);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try{
				label_1.setText("Izaberite klijenta:");
				combo_1.removeAll();
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t = session.beginTransaction();			
				java.util.List<Klijenti> klijenti =  session.createQuery("from Klijenti where tip='firma'").list();
		        t.commit();
		        session.close();
		        Klijenti k=new Klijenti();
		        
		        if(!((java.util.List) klijenti).isEmpty()){
		        for(int i=0; i<klijenti.size();i++)
		        {
		        	
		        k=(Klijenti)klijenti.get(i);
		        combo_1.add(k.getNaziv(),i);
		        }
		        }}
				catch(Exception e8){}}
			
		});
		button.setText("Firme");
		button.setSelection(true);
		button.setBounds(29, 24, 90, 16);
		
		
		
		Button button_2 = new Button(group_2, SWT.RADIO);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try{
				label_1.setText("Izaberite klijenta:");
				combo_1.removeAll();
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t = session.beginTransaction();			
				java.util.List<Klijenti> klijenti =  session.createQuery("from Klijenti where tip='firma'").list();
		        t.commit();
		        session.close();
		        Klijenti k=new Klijenti();
		        
		        if(!((java.util.List) klijenti).isEmpty()){
		        for(int i=0; i<klijenti.size();i++)
		        {
		        	
		        k=(Klijenti)klijenti.get(i);
		        combo_1.add(k.getNaziv(),i);
		        
		        }}
				}catch(Exception e7){}
			}
		});
		button_2.setText("Fizi\u010Dka lica");
		button_2.setBounds(29, 46, 90, 16);
		
		
		
		
		
		Label label_2 = new Label(group_3, SWT.NONE);
		label_2.setText("Ukupni promet:");
		label_2.setBounds(10, 30, 92, 15);
		
		final Label label_3 = new Label(group_3, SWT.NONE);
		label_3.setText("0");
		label_3.setBounds(116, 30, 55, 15);
		
		
		
		Label label_4 = new Label(group_3, SWT.NONE);
		label_4.setText("Izlazne fakture:");
		label_4.setBounds(10, 50, 92, 15);
		
		Button btnGeneriipdf = new Button(group_1, SWT.NONE);
		btnGeneriipdf.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Session session = HibernateUtil.getSessionFactory().openSession();
			      FileOutputStream file;
				try {
					file = new FileOutputStream(new File("src/main/resources/dokumenti/poKlijentuMjesecniIzvještaj.pdf"));
				
			      Document document = new Document();
			      PdfWriter.getInstance(document, file);
			      document.open();
			      int i=list.getSelectionIndex();
			      document.addAuthor("Factpro");
		            document.addCreationDate();
		            document.addLanguage("EN");

		            document.add(new Paragraph("Factpro",new Font(Font.FontFamily.HELVETICA  , 5, Font.BOLD)));
		            document.add(new Paragraph("________________________________________________________________________"
		            		+ "_________________________________________________________________________________"
		            		+ "_________________________",new Font(Font.FontFamily.HELVETICA  , 5, Font.BOLD)));
		          
			       Paragraph naslov=new Paragraph("\n Mjesečni izvještaj po klijentu",new Font(Font.FontFamily.HELVETICA  , 18, Font.BOLD));
		            naslov.setAlignment(Element.ALIGN_CENTER);
		            document.add(naslov);
		            Font pisanje=new Font(Font.FontFamily.HELVETICA  , 14, Font.NORMAL);
		            
		            document.add(new Chunk("\n",pisanje));        
		            
		            
				       
				      document.add(new Chunk("ID fakture: " + ((Faktura) fakturem.get(i)).getId(), pisanje ));
				     document.add(new Chunk("Cijena: " + ((Faktura) fakturem.get(i)).getCijena(), pisanje ));
				      document.add(new Chunk("Datum: " + ((Faktura) fakturem.get(i)).getDatum_izdavanja(), pisanje));
				      document.add(new Chunk(new Date().toString(), pisanje));
			      
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
				
				
				
				
				Shell shell = new Shell ();
				MessageDialog.openInformation(shell, "Generisanje izvjestaja", "Uspješno je kreiran mjesečni izvještaj.");
			}
		});
		btnGeneriipdf.setText("Generiši .pdf");
		btnGeneriipdf.setImage(SWTResourceManager.getImage(IzvjestajPoKlijentForm.class, "/images/1398195801_tick_32.png"));
		btnGeneriipdf.setBounds(10, 365, 117, 38);
		
		Button button_4 = new Button(group_1, SWT.NONE);
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		button_4.setText("Izlaz");
		button_4.setImage(SWTResourceManager.getImage(IzvjestajPoKlijentForm.class, "/images/1398195841_DeleteRed.png"));
		button_4.setBounds(248, 365, 117, 38);
		
		Label lblMjesec = new Label(group_1, SWT.NONE);
		lblMjesec.setBounds(170, 44, 55, 15);
		lblMjesec.setText("Mjesec:");
		
		final Spinner spinner = new Spinner(group_1, SWT.BORDER);
		spinner.setMaximum(12);
		spinner.setMinimum(1);
		spinner.setSelection(3);
		spinner.setBounds(239, 46, 47, 22);
		
		Button btnIspisFaktura = new Button(group_1, SWT.NONE);
		btnIspisFaktura.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t = (Transaction) session.beginTransaction();
				Query q = session.createQuery("from Klijenti where naziv=:naziv");
		        q.setString("naziv",combo_1.getItem(combo_1.getSelectionIndex()));		        
		        klijenti= q.list(); 
		        t.commit();
		        Klijenti kk=new Klijenti();
		        kk=(Klijenti)klijenti.get(0);
		        
		        Transaction t1 = (Transaction) session.beginTransaction();
				Query q1 = session.createQuery("from Faktura where idklijent=:idklijent");
		        q1.setLong("idklijent",kk.getId());	
		        //q1.setString("mjesec", Integer.toString(spinner.getSelection()));	
		        fakturem= q1.list(); 
		        t1.commit();
		        
		        Faktura f=new Faktura();
		        
		        for (int i=0; i<fakturem.size(); i++){
		        f =(Faktura)fakturem.get(i);        	
		       
		         String s = Objects.toString(f.getId(), null);
		         list_1.add(s, i);
		       
           	   
				
				
			}
				
			}
		});
		btnIspisFaktura.setBounds(292, 67, 75, 25);
		btnIspisFaktura.setText("Ispis faktura");
		
		

	}

}
