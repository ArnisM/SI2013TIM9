package ba.unsa.etf.si2013.tim9.Klijenti;


import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
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

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64.OutputStream;

import ba.unsa.etf.si2013.tim9.HibernateUtil;import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.util.Date;




import org.eclipse.swt.widgets.Control;

import org.eclipse.swt.widgets.Event;

import org.eclipse.swt.widgets.Listener;






import ba.unsa.etf.si2013.tim9.HibernateUtil;

import org.eclipse.swt.events.DisposeListener;

public class KlijentiFirmePretragaForm extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
//	protected Shell this;
	private Text text;
	private Table table;
	private List<Klijenti>klijenti;
	
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			KlijentiFirmePretragaForm shell = new KlijentiFirmePretragaForm(
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
	public KlijentiFirmePretragaForm(Display display) {
		super(display, SWT.SHELL_TRIM);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
//		this = new Shell();
		this.setImage(SWTResourceManager.getImage(KlijentiFirmePretragaForm.class, "/images/1396674421_Streamline-61.png"));
		this.setSize(653, 421);
		this.setText("Pretraga i ispis firmi");
		
		Button button = new Button(this, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				 
				Document document = new Document(PageSize.A4, 50, 50, 50, 50);
				try {
					File f = new File(System.getProperty("user.home")+"\\factpro\\pdfovi\\");
					f.mkdirs();
					PdfWriter.getInstance(document,new FileOutputStream(System.getProperty("user.home")+"\\factpro\\pdfovi\\klijentFirma.pdf"));
					//PdfWriter.getInstance(document,new FileOutputStream("target/klijentFirma.pdf"));
		          //SADRZAJ
		            document.open();
		            //zaglavlje dokumenta

		            document.addAuthor("Factpro");
		            document.addCreationDate();
		            document.addLanguage("EN");

		            document.add(new Paragraph("Factpro",new Font(Font.FontFamily.HELVETICA  , 5, Font.BOLD)));
		            document.add(new Paragraph("________________________________________________________________________"
		            		+ "_________________________________________________________________________________"
		            		+ "_________________________",new Font(Font.FontFamily.HELVETICA  , 5, Font.BOLD)));
		            
		            Paragraph naslov=new Paragraph("\n Podaci o korisniku",new Font(Font.FontFamily.HELVETICA  , 18, Font.BOLD));
		            naslov.setAlignment(Element.ALIGN_CENTER);
		            document.add(naslov);
		            Font pisanje=new Font(Font.FontFamily.HELVETICA  , 14, Font.NORMAL);
		            
		            document.add(new Chunk("\n",pisanje));        
		            
		            Klijenti ulogika=new Klijenti(); 
		            int i=table.getSelectionIndex();
		            
		            document.add(new Chunk("\n Naziv: "+klijenti.get(i).getNaziv(),pisanje)); 
		            document.add(new Chunk("\n Email: "+klijenti.get(i).getEmail(),pisanje)); 
		            document.add(new Chunk("\n Telefon: "+klijenti.get(i).getBrojtelefona(),pisanje));
		            document.add(new Chunk("\n Tip: "+klijenti.get(i).getTip(),pisanje));
		            document.add(new Chunk("\n Fax: "+klijenti.get(i).getFax(),pisanje));
		            Font pisanje2=new Font(Font.FontFamily.HELVETICA  , 14, Font.ITALIC);
		            Paragraph potpis=new Paragraph("\n \n \n \n \n \n __________________________________________  \n \n Potpis izdavaca ",new Font(Font.FontFamily.HELVETICA  , 5, Font.BOLD));
		            potpis.setAlignment(Element.ALIGN_RIGHT);
		            document.add(potpis);
		            Paragraph footer= new Paragraph("________________________________________________________________________"
		            		+ "_________________________________________________________________________________"
		            		+ "_________________________",new Font(Font.FontFamily.HELVETICA  , 5, Font.BOLD));
		            footer.setAlignment(Element.ALIGN_BASELINE);
		            document.add(footer);
		            //KRAJ
		            document.close();;
			      
			      Shell shell1 = new Shell();
				MessageDialog.openInformation(shell1, "Generisanje pdf", "PDF je generisan!");
				
				
			//	Desktop.getDesktop().open((new FileOutputStream("target/korisnk.pdf"));
				
					
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
		button.setText("Generi\u0161i .pdf");
		button.setImage(SWTResourceManager.getImage(KlijentiFirmePretragaForm.class, "/images/1398206257_pdf.png"));
		button.setBounds(5, 329, 119, 47);
		
		Button button_1 = new Button(this, SWT.NONE);
		button_1.setText("OK");
		button_1.setImage(SWTResourceManager.getImage(KlijentiFirmePretragaForm.class, "/images/1398195801_tick_32.png"));
		button_1.setBounds(376, 331, 116, 42);
		
		Button button_2 = new Button(this, SWT.NONE);
		button_2.setText("Izlaz");
		button_2.setImage(SWTResourceManager.getImage(KlijentiFirmePretragaForm.class, "/images/1398195841_DeleteRed.png"));
		button_2.setBounds(511, 331, 116, 42);
		
		Group group = new Group(this, SWT.NONE);
		group.setText("Pretraga");
		group.setBounds(5, 10, 575, 107);
		
		final Combo combo = new Combo(group, SWT.NONE);
		combo.setItems(new String[] {"Naziv"});
		combo.setBounds(112, 35, 142, 23);
		combo.setText("Izaberite kriterij");
		
		Label label = new Label(group, SWT.NONE);
		label.setText("Kirterij pretrage:");
		label.setBounds(10, 38, 96, 15);
		
		text = new Text(group, SWT.BORDER);
		text.setBounds(380, 35, 163, 21);
		
		Label lblUnesiNaziv = new Label(group, SWT.NONE);
		lblUnesiNaziv.setText("Unesi naziv:");
		lblUnesiNaziv.setBounds(280, 38, 96, 15);
		
		Button button_3 = new Button(group, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t = session.beginTransaction();
				if(combo.getSelectionIndex()==0){
											
		        Query q = session.createQuery("from Klijenti where naziv=:naziv");
		        q.setString("naziv", text.getText());
		        klijenti=q.list();
		        t.commit();
		        session.close();
		        Klijenti k=new Klijenti();
		        		        
		        for (int i=0; i<klijenti.size(); i++){
		        	k = (Klijenti) klijenti.get(i);
		        	if(k.getDeleted()==0){
		        	
		        TableItem item = new TableItem(table, 0, i);
		        
           	    item.setText(0,k.getNaziv());
           	    /*item.setText(1,k.(getPdv()));
             	item.setText(2,k.getPdvbroj());*/
           	    item.setText(3,k.getAdresa());
           	    item.setText(4,k.getBrojtelefona());
           	    item.setText(7,k.getEmail());
           	    item.setText(5,k.getBrojtelefona());
           	    item.setText(6, k.getFax());
		        }}
		        }
				
				
				
			}
		});
		button_3.setText("Pretraga");
		button_3.setImage(SWTResourceManager.getImage(KlijentiFirmePretragaForm.class, "/images/1398199827_search_magnifying_glass_find.png"));
		button_3.setBounds(427, 62, 116, 35);
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(5, 126, 626, 179);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("Naziv firme");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("PDV broj");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("IDPDV broj");
		
		TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(100);
		tableColumn_3.setText("Adresa");
		
		TableColumn tableColumn_4 = new TableColumn(table, SWT.NONE);
		tableColumn_4.setWidth(120);
		tableColumn_4.setText("Broj telefona");
		
		TableColumn tableColumn_5 = new TableColumn(table, SWT.NONE);
		tableColumn_5.setWidth(100);
		tableColumn_5.setText("E-mail");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
