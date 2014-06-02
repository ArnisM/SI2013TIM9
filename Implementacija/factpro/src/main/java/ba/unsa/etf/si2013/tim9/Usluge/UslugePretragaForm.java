package ba.unsa.etf.si2013.tim9.Usluge;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.eclipse.jface.dialogs.MessageDialog;

//import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si2013.tim9.*;

import org.eclipse.osgi.util.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
public class UslugePretragaForm extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
//	protected Shell this;
	private Text text;
	java.util.List<Usluga> usluge;
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			UslugePretragaForm shell = new UslugePretragaForm(display);
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
	public UslugePretragaForm(Display display) {
		super(display, SWT.SHELL_TRIM);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
//		this = new Shell();
		this.setImage(SWTResourceManager.getImage(UslugePretragaForm.class, "/images/1396674353_services.png"));
		this.setSize(399, 440);
		this.setText("Pretraga i ispis usluga");
		
		Group grpPretraga = new Group(this, SWT.NONE);
		grpPretraga.setText("Pretraga");
		grpPretraga.setBounds(10, 10, 356, 95);
		
		final Combo combo = new Combo(grpPretraga, SWT.NONE);
		combo.setItems(new String[] {"Naziv"});
		combo.setBounds(103, 18, 120, 23);
		combo.setText("Izaberite kriterij pretrage");
		
		Label lblPretragaPo = new Label(grpPretraga, SWT.NONE);
		lblPretragaPo.setBounds(10, 21, 105, 15);
		lblPretragaPo.setText("Kriterij pretrage:");
		
		Label lblUnesiteNaziv = new Label(grpPretraga, SWT.NONE);
		lblUnesiteNaziv.setBounds(10, 59, 93, 15);
		lblUnesiteNaziv.setText("Unesite naziv:");
		
		text = new Text(grpPretraga, SWT.BORDER);
		text.setBounds(100, 59, 123, 21);
		

		final List list = new List(this, SWT.BORDER);
		//list.setItems(new String[] {"Servisiranje ra\u010Dunara ", "Instalacija microsoft oficce-a", "Instaliranje i pode\u0161avanje operativnog sistema", "Promjena licence"});
		((Control) list).setBounds(10, 154, 367, 204);
		
		Button btnPretraga = new Button(grpPretraga, SWT.NONE);
		btnPretraga.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t = session.beginTransaction();
				
				if(combo.getSelectionIndex()==0){
					
			        Query q = session.createQuery("from Usluga where naziv=:naziv");
			        q.setString("naziv", text.getText());
			        usluge=q.list();
			        t.commit();
			        session.close();
			        Usluga k=new Usluga();
			        		        
			        for (int i=0; i<usluge.size(); i++){
			        	k = (Usluga) usluge.get(i);
			        	if(k.getDeleted()==0)
			        	list.add(k.getNaziv(), i);
			       
			        }}
				
				}
		});
		btnPretraga.setImage(SWTResourceManager.getImage(UslugePretragaForm.class, "/images/1398199827_search_magnifying_glass_find.png"));
		btnPretraga.setBounds(249, 18, 97, 25);
		btnPretraga.setText("Pretraga");
		
		Label lblOdaberiteeljeneUsluge = new Label(this, SWT.NONE);
		lblOdaberiteeljeneUsluge.setText("Odaberite \u017Eeljene usluge za ispis:");
		lblOdaberiteeljeneUsluge.setBounds(10, 133, 183, 15);
		
		
		Button button = new Button(this, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
				MessageDialog.openInformation(shell, "OK", "Završeno.");
			}
		});
		button.setText("Ok");
		button.setImage(SWTResourceManager.getImage(UslugePretragaForm.class, "/images/1398195801_tick_32.png"));
		button.setBounds(169, 364, 98, 33);
		
		Button button_1 = new Button(this, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		button_1.setText("Izlaz");
		button_1.setImage(SWTResourceManager.getImage(UslugePretragaForm.class, "/images/1398195841_DeleteRed.png"));
		button_1.setBounds(273, 364, 104, 33);
		
		Button btnGeneriipdf = new Button(this, SWT.NONE);
		btnGeneriipdf.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				FileOutputStream file;
				try {
					
					file = new FileOutputStream(new File("D:/usluge.pdf"));
				
			      Document document = new Document();
			      PdfWriter.getInstance(document, file);
			      document.open();
			      int i=list.getSelectionIndex();
			      document.addTitle("Podaci o klijentu");
			      document.add(new Paragraph("Naziv usluge: " + usluge.get(i).getNaziv() ));
			      document.add(new Paragraph("Cijena: " + usluge.get(i).getCijena() ));
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
			  
			
		
				
				Shell shell = new Shell();
				MessageDialog.openInformation(shell, "Ispis usluga", "PDF je uspješno kreiran.");
			}
		});
		btnGeneriipdf.setText("Generi\u0161i .pdf");
		btnGeneriipdf.setImage(SWTResourceManager.getImage(UslugePretragaForm.class, "/images/1398206257_pdf.png"));
		btnGeneriipdf.setBounds(10, 364, 118, 33);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
