package ba.unsa.etf.si2013.tim9.Klijenti;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
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
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64.OutputStream;

public class KlijentiPretragaForm extends Shell {

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
			KlijentiPretragaForm shell = new KlijentiPretragaForm(display);
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
	public KlijentiPretragaForm(Display display) {
		super(display, SWT.SHELL_TRIM);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
//		this = new Shell();
		this.setImage(SWTResourceManager.getImage(KlijentiPretragaForm.class, "/images/1396674475_user_male2.png"));
		this.setSize(631, 445);
		this.setText("Pretraga i ispis fizi\u010Dkih lica");
		
		Group group = new Group(this, SWT.NONE);
		group.setText("Pretraga");
		group.setBounds(10, 10, 575, 107);
		
		final Combo combo = new Combo(group, SWT.NONE);
		combo.setItems(new String[] {"Ime i prezime"});
		combo.setBounds(112, 35, 142, 23);
		combo.setText("Izaberite kriterij");
		
		Label label = new Label(group, SWT.NONE);
		label.setText("Kirterij pretrage:");
		label.setBounds(10, 38, 96, 15);
		
		text = new Text(group, SWT.BORDER);
		text.setBounds(380, 35, 163, 21);
		
		Label lblUnesiteImeI = new Label(group, SWT.NONE);
		lblUnesiteImeI.setText("Unesite ime i prezime:");
		lblUnesiteImeI.setBounds(292, 38, 65, 15);
		
		Button button = new Button(group, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
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
		        }}
		});
		button.setText("Pretraga");
		button.setImage(SWTResourceManager.getImage(KlijentiPretragaForm.class, "/images/1398199827_search_magnifying_glass_find.png"));
		button.setBounds(427, 62, 116, 35);
		
		Button button_1 = new Button(this, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

			      FileOutputStream file;
				try {
					file = new FileOutputStream(new File("C:\\example.pdf\\"));
				
			      Document document = new Document();
			      PdfWriter.getInstance(document, file);
			      document.open();
			      int i=table.getSelectionIndex();
			      document.addTitle("Podaci o klijentu");
			      document.add(new Paragraph("Naziv firme: " + klijenti.get(i).getNaziv() ));
			      document.add(new Paragraph("Adresa firme: " + klijenti.get(i).getAdresa() ));
			      document.add(new Paragraph("Kontakt telefon: " + klijenti.get(i).getBrojtelefona() ));
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
		button_1.setText("Generi\u0161i .pdf");
		button_1.setImage(SWTResourceManager.getImage(KlijentiPretragaForm.class, "/images/1398206257_pdf.png"));
		button_1.setBounds(10, 350, 119, 47);
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 143, 595, 195);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(91);
		tableColumn.setText("Ime");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("Prezime");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(124);
		tableColumn_2.setText("Adresa");
		
		TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(109);
		tableColumn_3.setText("Telefon");
		
		TableColumn tableColumn_4 = new TableColumn(table, SWT.NONE);
		tableColumn_4.setWidth(167);
		tableColumn_4.setText("E-mail");
		
		Label label_2 = new Label(this, SWT.NONE);
		label_2.setText("Ozna\u010Dite \u017Eeljeni red:");
		label_2.setBounds(10, 123, 154, 15);
		
		Button button_2 = new Button(this, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		button_2.setText("OK");
		button_2.setImage(SWTResourceManager.getImage(KlijentiPretragaForm.class, "/images/1398195801_tick_32.png"));
		button_2.setBounds(362, 352, 116, 42);
		
		Button button_3 = new Button(this, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		button_3.setText("Izlaz");
		button_3.setImage(SWTResourceManager.getImage(KlijentiPretragaForm.class, "/images/1398195841_DeleteRed.png"));
		button_3.setBounds(484, 352, 116, 42);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
