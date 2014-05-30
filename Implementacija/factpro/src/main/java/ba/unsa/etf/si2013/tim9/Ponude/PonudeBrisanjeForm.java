package ba.unsa.etf.si2013.tim9.Ponude;

import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
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
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;

public class PonudeBrisanjeForm extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
//	protected Shell this;
	private Table table;
	private List<Ponuda> ponude;
	private Text text_pretraga;
	
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			PonudeBrisanjeForm shell = new PonudeBrisanjeForm(display);
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
	public PonudeBrisanjeForm(Display display) {
		super(display, SWT.SHELL_TRIM);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
//		this = new Shell();
		this.setImage(SWTResourceManager.getImage(PonudeBrisanjeForm.class, "/images/1396674680_document_text.png"));
		this.setSize(612, 469);
		this.setText("Brisanje ponude");
		
		Group grpPretragaPonude = new Group(this, SWT.NONE);
		grpPretragaPonude.setText("Pretraga ponude");
		grpPretragaPonude.setBounds(10, 0, 575, 162);
		
		final Label lblUnesiteNazivFirme = new Label(grpPretragaPonude, SWT.NONE);
		lblUnesiteNazivFirme.setText("Unesite naziv firme:");
		lblUnesiteNazivFirme.setBounds(266, 87, 116, 15);
		
		final Combo combo = new Combo(grpPretragaPonude, SWT.READ_ONLY);
		combo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(combo.getText()=="PDV broj"){
					lblUnesiteNazivFirme.setText("Unesite PDV broj:");
				}
			}
		});
		combo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {

				if(combo.getText()=="PDV broj"){
					lblUnesiteNazivFirme.setText("Unesite PDV broj:");
				}
			}
		});
		combo.setItems(new String[] {"Naziv firme\t", "PDV broj"});
		combo.setBounds(112, 84, 122, 23);
		combo.select(0);
		combo.setText("Naziv firme");
		
		Label label = new Label(grpPretragaPonude, SWT.NONE);
		label.setText("Kirterij pretrage:");
		label.setBounds(10, 87, 96, 15);
		
		
		Group group_1 = new Group(grpPretragaPonude, SWT.NONE);
		group_1.setText("Odabir");
		group_1.setBounds(10, 22, 142, 56);
		
	
		
		final Button button_1 = new Button(group_1, SWT.RADIO);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				combo.setItem(0, "Naziv firme");
				combo.select(0);
				lblUnesiteNazivFirme.setText("Unesite naziv firme:");
			}
		});
		button_1.setText("Firma");
		button_1.setSelection(true);
		button_1.setBounds(54, 10, 90, 16);
		
		
		
		final Button button_2 = new Button(group_1, SWT.RADIO);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				combo.setItem(0, "Ime i prezime");
				combo.select(0);
				lblUnesiteNazivFirme.setText("Unesite ime i prezime:");
				
			}
		});
		button_2.setText("Fizi\u010Dko lice");
		button_2.setBounds(54, 32, 78, 16);
		
		
		Button button = new Button(grpPretragaPonude, SWT.NONE);
		
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
				
		if(button_1.getSelection()){
				ControlDecoration odabirFirmeError = new ControlDecoration(text_pretraga, SWT.RIGHT | SWT.TOP);
				
				if (text_pretraga.getText()==""){
					odabirFirmeError.setDescriptionText("Niste unijeli naziv firme!");
					FieldDecoration nazivFirmeField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					odabirFirmeError.setImage(nazivFirmeField.getImage());
					odabirFirmeError.showHoverText("Niste unijeli naziv firme!");
				}

				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t = session.beginTransaction();
				if(combo.getSelectionIndex()==0){
											
		        Query q = session.createQuery("from Ponude where naziv=:naziv");
		        q.setString("naziv", text_pretraga.getText());
		        ponude=q.list();
		        t.commit();
		        session.close();
		        Ponuda k=new Ponuda();
		        		        
		        for (int i=0; i<ponude.size(); i++){
		        	k = (Ponuda) ponude.get(i);
		        	
		        TableItem item = new TableItem(table, 0, i);
		        
           	/*    item.setText(0,k.getNaziv());
           	    item.setText(1,k.(getPdv()));
             	item.setText(2,k.getPdvbroj());
           	    item.setText(3,k.getAdresa());
           	    item.setText(4,k.getBrojtelefona());
           	    item.setText(7,k.getEmail());
           	    item.setText(5,k.getBrojtelefona());
           	    item.setText(6, k.getFax());*/
		        } 
		        }
				
				
				if(combo.getSelectionIndex()==1){
					
			        Query q = session.createQuery("from Klijenti where pdvbroj=:pdvbroj");
			        q.setString("pdvbroj", text_pretraga.getText());
			        ponude=q.list();
			        t.commit();
			        session.close();
			        Ponuda k=new Ponuda();
			        		        
		        for (int i=0; i<ponude.size(); i++){
			        	k = (Ponuda) ponude.get(i);
			        	
			        TableItem item = new TableItem(table, 0, i);
			        
	           	  /*  item.setText(0,k.getNaziv()); 
	           	    item.setText(1,k.(getPdv()));
	             	item.setText(2,k.getPdvbroj());
	           	    item.setText(3,k.getAdresa());
	           	    item.setText(4,k.getBrojtelefona());
	           	    item.setText(7,k.getEmail());
	           	    item.setText(5,k.getBrojtelefona());
	           	    item.setText(6, k.getFax());*/
			        } 
			        }
		}
		
		else if(button_2.getSelection()){
		
			
			
			ControlDecoration odabirFirmeError = new ControlDecoration(text_pretraga, SWT.RIGHT | SWT.TOP);
			
			if (text_pretraga.getText()==""){
				odabirFirmeError.setDescriptionText("Niste odabrali firmu!");
				FieldDecoration nazivFirmeField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
				odabirFirmeError.setImage(nazivFirmeField.getImage());
				odabirFirmeError.showHoverText("Niste odabrali firmu!");
			}

			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			if(combo.getSelectionIndex()==0){
										
	        Query q = session.createQuery("from Ponude where naziv=:naziv");
	        q.setString("naziv", text_pretraga.getText());
	        ponude=q.list();
	        t.commit();
	        session.close();
	        Ponuda k=new Ponuda();
	        		        
	        for (int i=0; i<ponude.size(); i++){
	        	k = (Ponuda) ponude.get(i);
	        	
	        TableItem item = new TableItem(table, 0, i);
	        
       	   /* item.setText(0,k.getNaziv());
       	    item.setText(1,k.(getPdv()));
         	item.setText(2,k.getPdvbroj());
       	    item.setText(3,k.getAdresa());
       	    item.setText(4,k.getBrojtelefona());
       	    item.setText(7,k.getEmail());
       	    item.setText(5,k.getBrojtelefona());
       	    item.setText(6, k.getFax()); */
	        }
	        }
			
			
			if(combo.getSelectionIndex()==1){
				
		        Query q = session.createQuery("from Klijenti where pdvbroj=:pdvbroj");
		        q.setString("pdvbroj", text_pretraga.getText());
		        ponude=q.list();
		        t.commit();
		        session.close();
		        Ponuda k=new Ponuda();
		        		        
		        for (int i=0; i<ponude.size(); i++){
		        	k = (Ponuda) ponude.get(i);
		        	
		        TableItem item = new TableItem(table, 0, i);
		        
           	   /* item.setText(0,k.getNaziv());
           	    item.setText(1,k.(getPdv()));
             	item.setText(2,k.getPdvbroj());
           	    item.setText(3,k.getAdresa());
           	    item.setText(4,k.getBrojtelefona());
           	    item.setText(7,k.getEmail());
           	    item.setText(5,k.getBrojtelefona());
           	    item.setText(6, k.getFax()); */
		        }
		        }
		
		}
				
				//MessageDialog.openInformation(shell, "Info", "Ponude koje odgovaraju pretrazi su ispisane!");
				
			}
		});
		
		button.setText("Pretraga");
		button.setImage(SWTResourceManager.getImage(PonudeBrisanjeForm.class, "/images/1398199827_search_magnifying_glass_find.png"));
		button.setBounds(427, 117, 116, 35);
		
		text_pretraga = new Text(grpPretragaPonude, SWT.BORDER);
		text_pretraga.setBounds(401, 84, 142, 21);
		
		
		
		
		
		
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 193, 575, 179);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("ID fakture");
		
		TableColumn tblclmnUkupnaCijenaSa = new TableColumn(table, SWT.NONE);
		tblclmnUkupnaCijenaSa.setWidth(137);
		tblclmnUkupnaCijenaSa.setText("Ukupna cijena sa pdv");
		
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
		lblIzaberiteeljenuPonudu.setBounds(10, 177, 136, 15);
		
		Button btnBrii = new Button(this, SWT.NONE);
		btnBrii.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				Shell shell = new Shell();
		
				
				MessageDialog.openInformation(shell, "Info", "Uspješno je obrisana ponuda!");
				
			}
		});
		btnBrii.setText("Bri\u0161i");
		btnBrii.setImage(SWTResourceManager.getImage(PonudeBrisanjeForm.class, "/images/1398201739_Trash.png"));
		btnBrii.setBounds(346, 379, 116, 42);
		
		Button button_4 = new Button(this, SWT.NONE);
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				close();
				
			}
		});
		button_4.setText("Izlaz");
		button_4.setImage(SWTResourceManager.getImage(PonudeBrisanjeForm.class, "/images/1398195841_DeleteRed.png"));
		button_4.setBounds(469, 379, 116, 42);


	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
