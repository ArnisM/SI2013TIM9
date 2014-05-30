package ba.unsa.etf.si2013.tim9.Korisnici;

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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
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

public class KorisniciIzmjenaForm extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
	//protected Shell this;
	private Text text;
	private Table table;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			KorisniciIzmjenaForm shell = new KorisniciIzmjenaForm(display);
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
	public KorisniciIzmjenaForm(Display display) {
		super(display, SWT.SHELL_TRIM);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		//this = new Shell();
		this.setImage(SWTResourceManager.getImage(KorisniciIzmjenaForm.class, "/images/1396674475_user_male2.png"));
		this.setSize(660, 488);
		this.setText("Izmjena Korisnika");
		
		Group group = new Group(this, SWT.NONE);
		group.setText("Pretraga");
		group.setBounds(10, 21, 575, 107);
		
		final Combo combo = new Combo(group, SWT.NONE);
		combo.setItems(new String[] {"Ime", "Prezime", "Korisni\u010Dko ime", "E-mail", "Uloga"});
		combo.setBounds(112, 35, 142, 23);
		combo.setText("Ime");
		
		Label label = new Label(group, SWT.NONE);
		label.setText("Kirterij pretrage:");
		label.setBounds(10, 38, 96, 15);
		
		text = new Text(group, SWT.BORDER);
		text.setBounds(380, 35, 163, 21);
		
		Label label_1 = new Label(group, SWT.NONE);
		label_1.setText("Unesite ime:");
		label_1.setBounds(292, 38, 65, 15);
		
		Button button = new Button(group, SWT.NONE);
		button.setText("Pretraga");
		button.setImage(SWTResourceManager.getImage(KorisniciIzmjenaForm.class, "/images/1398199827_search_magnifying_glass_find.png"));
		button.setBounds(427, 62, 116, 35);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				List<Korisnik> korisnici;
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t = session.beginTransaction();
				if(combo.getSelectionIndex()==0){
											
		        Query q = session.createQuery("from Korisnik where ime=:ime");
		        q.setString("ime", text.getText());
		        korisnici=q.list();
		        t.commit();
		        session.close();
		        Korisnik k=new Korisnik();
		        		        
		        for (int i=0; i<korisnici.size(); i++){
		        	k = (Korisnik) korisnici.get(i);
		        	if(k.getDeleted()==0){
		        TableItem item = new TableItem(table, 0, i);
		        item.setText(0,Integer.toString((int)k.getId()));
           	    item.setText(1,k.getIme());
             	item.setText(2,k.getPrezime());
             	item.setText(3,k.getUsername());
           	    item.setText(4,k.getAdresa());
           	    item.setText(5,k.getTelefon()); 
           	    item.setText(6, k.getPozicija());
		       }
		        }
			}
				
				if(combo.getSelectionIndex()==1){
					
			        Query q = session.createQuery("from Korisnik where prezime=:prezime");
			        q.setString("prezime", text.getText());
			        korisnici=q.list();
			        t.commit();
			        session.close();
			        Korisnik k=new Korisnik();
			        		        
			        for (int i=0; i<korisnici.size(); i++){
			        	k = (Korisnik) korisnici.get(i);
			        	
			        TableItem item = new TableItem(table, 0, i);
			        item.setText(0,Integer.toString((int)k.getId()));
	           	    item.setText(1,k.getIme());
	             	item.setText(2,k.getPrezime());
	             	item.setText(3,k.getUsername());
	           	    item.setText(4,k.getAdresa());
	           	    item.setText(5,k.getTelefon()); 
	           	    item.setText(6, k.getPozicija());
			       }
			        
				}
				
				if(combo.getSelectionIndex()==2){
					
			        Query q = session.createQuery("from Korisnik where pozicija=:pozicija");
			        q.setString("pozicija", "operater");
			        korisnici=q.list();
			        t.commit();
			        session.close();
			        Korisnik k=new Korisnik();
			        		        
			        for (int i=0; i<korisnici.size(); i++){
			        	k = (Korisnik) korisnici.get(i);
			        	
			        TableItem item = new TableItem(table, 0, i);
			        item.setText(0,Integer.toString((int)k.getId()));
	           	    item.setText(1,k.getIme());
	             	item.setText(2,k.getPrezime());
	             	item.setText(3,k.getUsername());
	           	    item.setText(4,k.getAdresa());
	           	    item.setText(5,k.getTelefon()); 
	           	    item.setText(6, k.getPozicija());
			       }
			        
				}
				
if(combo.getSelectionIndex()==2){
					
			        Query q = session.createQuery("from Korisnik where pozicija=:pozicija");
			        q.setString("pozicija", "rukovodilac");
			        korisnici=q.list();
			        t.commit();
			        session.close();
			        Korisnik k=new Korisnik();
			        		        
			        for (int i=0; i<korisnici.size(); i++){
			        	k = (Korisnik) korisnici.get(i);
			        	
			        TableItem item = new TableItem(table, 0, i);
			        item.setText(0,Integer.toString((int)k.getId()));
	           	    item.setText(1,k.getIme());
	             	item.setText(2,k.getPrezime());
	             	item.setText(3,k.getUsername());
	           	    item.setText(4,k.getAdresa());
	           	    item.setText(5,k.getTelefon()); 
	           	    item.setText(6, k.getPozicija());
			       }
			        
				}
				
				
				
			}
				
			
		});
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 134, 626, 84);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("Ime");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("Prezime");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("Korisni\u010Dko ime");
		
		TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(100);
		tableColumn_3.setText("E-mail");
		
		TableColumn tableColumn_4 = new TableColumn(table, SWT.NONE);
		tableColumn_4.setWidth(120);
		tableColumn_4.setText("Broj telefona");
		
		TableColumn tableColumn_5 = new TableColumn(table, SWT.NONE);
		tableColumn_5.setWidth(100);
		tableColumn_5.setText("Uloga");
		
		Group grpIzmjenaAtributa = new Group(this, SWT.NONE);
		grpIzmjenaAtributa.setText("Izmjena atributa");
		grpIzmjenaAtributa.setBounds(10, 234, 626, 158);
		
		Label lblIme = new Label(grpIzmjenaAtributa, SWT.NONE);
		lblIme.setBounds(25, 35, 55, 15);
		lblIme.setText("Ime:");
		
		Label lblPrezime = new Label(grpIzmjenaAtributa, SWT.NONE);
		lblPrezime.setText("Prezime:");
		lblPrezime.setBounds(25, 56, 55, 15);
		
		Label lblKorisnikoIme = new Label(grpIzmjenaAtributa, SWT.NONE);
		lblKorisnikoIme.setText("Korisni\u010Dko ime:");
		lblKorisnikoIme.setBounds(25, 85, 90, 15);
		
		Label lblEmail = new Label(grpIzmjenaAtributa, SWT.NONE);
		lblEmail.setText("E-mail:");
		lblEmail.setBounds(234, 35, 55, 15);
		
		Label lblBrojTelefona = new Label(grpIzmjenaAtributa, SWT.NONE);
		lblBrojTelefona.setText("Broj telefona:");
		lblBrojTelefona.setBounds(234, 56, 82, 15);
		
		Label lblNovaifra = new Label(grpIzmjenaAtributa, SWT.NONE);
		lblNovaifra.setText("Nova \u0161ifra:");
		lblNovaifra.setBounds(25, 111, 65, 15);
		
		Group grpUloga = new Group(grpIzmjenaAtributa, SWT.NONE);
		grpUloga.setText("Uloga:");
		grpUloga.setBounds(234, 77, 128, 71);
		
		Button btnOperater = new Button(grpUloga, SWT.RADIO);
		btnOperater.setBounds(10, 20, 90, 16);
		btnOperater.setText("Operater");
		
		Button btnRukovodilac = new Button(grpUloga, SWT.RADIO);
		btnRukovodilac.setBounds(10, 42, 90, 16);
		btnRukovodilac.setText("Rukovodilac");
		
		text_1 = new Text(grpIzmjenaAtributa, SWT.BORDER);
		text_1.setBounds(118, 32, 90, 21);
		
		text_2 = new Text(grpIzmjenaAtributa, SWT.BORDER);
		text_2.setBounds(118, 56, 90, 21);
		
		text_3 = new Text(grpIzmjenaAtributa, SWT.BORDER);
		text_3.setBounds(118, 82, 90, 21);
		
		text_4 = new Text(grpIzmjenaAtributa, SWT.BORDER);
		text_4.setBounds(118, 108, 90, 21);
		
		text_5 = new Text(grpIzmjenaAtributa, SWT.BORDER);
		text_5.setBounds(316, 32, 90, 21);
		
		text_6 = new Text(grpIzmjenaAtributa, SWT.BORDER);
		text_6.setBounds(316, 56, 90, 21);
		
		Button btnNewButton = new Button(grpIzmjenaAtributa, SWT.NONE);
		btnNewButton.setImage(SWTResourceManager.getImage(KorisniciIzmjenaForm.class, "/images/1398203169_change_user.png"));
		btnNewButton.setBounds(514, 35, 102, 50);
		btnNewButton.setText("Izmjeni");
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
				
				Session session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				Korisnik k=new Korisnik();
				int ind=table.getSelectionIndex();
				TableItem ti=table.getItem(ind);
				Korisnik kor = 
	                    (Korisnik)session.get(Korisnik.class, (long)(Integer.parseInt(ti.getText(0)))); 
				
				if(text_1.getText()!=""){
				
		         kor.setIme( text_1.getText() );
				 ti.setText(1, text_1.getText());
					
				}
				if(text_2.getText()!=""){
				
		         kor.setPrezime( (text_2.getText()) );
		         ti.setText(2, text_2.getText());
					
				}
				
				if(text_3.getText()!=""){
				 
		         kor.setUsername( (text_3.getText()) );
		         ti.setText(3, text_3.getText());
					
				}
				
				if(text_4.getText()!=""){
				
		         kor.setPassword( (text_4.getText()) );
		         ti.setText(4, text_4.getText());
					
				}
				
				if(text_6.getText()!=""){
					ControlDecoration text5Error = new ControlDecoration(text_6, SWT.RIGHT | SWT.TOP);
					if (!text_6.getText().matches("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{3}$")){
						text5Error.setDescriptionText("Telefon nije u ispravnom formatu!");
						FieldDecoration text5Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
						text5Error.setImage(text5Field.getImage());
						text5Error.showHoverText("Telefon nije u ispravnom formatu!");
					}
				
					 kor.setTelefon( (text_6.getText()) );
					 ti.setText(5, text_6.getText());
					
				}
				
				if(text_5.getText()!=""){
					ControlDecoration text6Error = new ControlDecoration(text_5, SWT.RIGHT | SWT.TOP);
					if (!text_5.getText().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
						text6Error.setDescriptionText("E-mail nije u ispravnom formatu!");
						FieldDecoration text6Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
						text6Error.setImage(text6Field.getImage());
						text6Error.showHoverText("E-mail nije u ispravnom formatu!");
					}
					
			 
		         kor.setAdresa( (text_5.getText()) );
		         ti.setText(6, text_5.getText());	
					
				}
				
				session.update(kor); 
		        session.getTransaction().commit();
			MessageDialog.openInformation(shell, "Info", "Uspjesno je izvrsena izmjena.");
			
			
			//	Shell shell=new Shell();
				MessageDialog.openInformation(shell, "Izmjena", "Uspjesno izmjenjeni atributi korisnika.");
				
			}
		});
		
		Button btnNewButton_1 = new Button(this, SWT.NONE);
		btnNewButton_1.setImage(SWTResourceManager.getImage(KorisniciIzmjenaForm.class, "/images/1398195801_tick_32.png"));
		btnNewButton_1.setBounds(392, 398, 116, 42);
		btnNewButton_1.setText("OK");
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell=new Shell();
				MessageDialog.openInformation(shell, "Izmjena korisnika - OK", "Uspjesna izmjena.");
				
			}
		});
		
		Button btnIzlaz = new Button(this, SWT.NONE);
		btnIzlaz.setImage(SWTResourceManager.getImage(KorisniciIzmjenaForm.class, "/images/1398195841_DeleteRed.png"));
		btnIzlaz.setText("Izlaz");
		btnIzlaz.setBounds(520, 398, 116, 42);
		btnIzlaz.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});


	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
