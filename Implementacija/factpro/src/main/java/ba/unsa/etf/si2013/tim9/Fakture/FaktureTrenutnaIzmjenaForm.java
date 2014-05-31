package ba.unsa.etf.si2013.tim9.Fakture;

import java.util.Date;
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
//import org.eclipse.wb.swt.DodavanjeStavkiFaktureForm;
import org.eclipse.wb.swt.SWTResourceManager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.unsa.etf.si2013.tim9.HibernateUtil;
import ba.unsa.etf.si2013.tim9.Klijenti.Klijenti;
import ba.unsa.etf.si2013.tim9.Usluge.Usluga;

import java.util.ArrayList;
public class FaktureTrenutnaIzmjenaForm extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
//	protected Shell this;
	private ArrayList<Long> _uzete;
	private ArrayList<String> _usluge;
	private List stavka;
	private int br_stavki;
	private Table table;
	private Text text;
	private Long id_broj;
	private ArrayList<String> lista;
	private Group grpKlijent;
	private Group grpOdabir;
	private Button btnFirma;
	private Label lblIzaberiteFirmu;
	private Combo combo;
	private Button btnFizikoLice;
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			FaktureTrenutnaIzmjenaForm shell = new FaktureTrenutnaIzmjenaForm(display,null);
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
	public FaktureTrenutnaIzmjenaForm(Display display,Long id) {
		super(display, SWT.SHELL_TRIM);
		id_broj=id;
		br_stavki=0;
		_usluge=new ArrayList<String>();
		_uzete=new ArrayList<Long>();
		
		grpKlijent = new Group(this, SWT.NONE);
		grpKlijent.setText("Klijent");
		grpKlijent.setBounds(10, 10, 649, 123);
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(10, 441, 611, 135);
		
		grpOdabir = new Group(grpKlijent, SWT.NONE);
		grpOdabir.setText("Odabir");
		grpOdabir.setBounds(10, 20, 123, 82);
		
		combo = new Combo(grpKlijent, SWT.NONE);
		combo.setBounds(271, 33, 154, 23);
		
		
		btnFirma = new Button(grpOdabir, SWT.RADIO);
		btnFirma.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				lblIzaberiteFirmu.setText("Odaberite firmu:");
				combo.removeAll();
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
		        combo.add(k.getNaziv(),i);
		        
		        }
				}
				
			}
		});
		btnFirma.setBounds(10, 23, 90, 16);
		btnFirma.setText("Firma");
		
		 lblIzaberiteFirmu = new Label(grpKlijent, SWT.NONE);
		lblIzaberiteFirmu.setBounds(170, 36, 95, 15);
		lblIzaberiteFirmu.setText("Odaberite firmu:");
		
		
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 194, 660, 207);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnRedniBr = new TableColumn(table, SWT.NONE);
		tblclmnRedniBr.setWidth(62);
		tblclmnRedniBr.setText("Redni br.");
		
		TableColumn tblclmnNazivUsluge = new TableColumn(table, SWT.NONE);
		tblclmnNazivUsluge.setWidth(100);
		tblclmnNazivUsluge.setText("Naziv usluge");
		
		TableColumn tblclmnOpis = new TableColumn(table, SWT.NONE);
		tblclmnOpis.setWidth(217);
		tblclmnOpis.setText("Opis");
		
		TableColumn tblclmnJedCijenaBez = new TableColumn(table, SWT.NONE);
		tblclmnJedCijenaBez.setWidth(123);
		tblclmnJedCijenaBez.setText("Jed. cijena bez pdv");
		
		TableColumn tblclmnKol = new TableColumn(table, SWT.NONE);
		tblclmnKol.setWidth(59);
		tblclmnKol.setText("Kol.");
		
		TableColumn tblclmnCijenaSaPdv = new TableColumn(table, SWT.NONE);
		tblclmnCijenaSaPdv.setWidth(94);
		tblclmnCijenaSaPdv.setText("Cijena sa pdv");
		
	    btnFizikoLice = new Button(grpOdabir, SWT.RADIO);
	    btnFizikoLice.addSelectionListener(new SelectionAdapter() {
	    	@Override
	    	public void widgetSelected(SelectionEvent e) {
	    		
	    		lblIzaberiteFirmu.setText("Izaberite lice:");
				combo.removeAll();
				
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t = session.beginTransaction();			
				List klijenti = session.createQuery("from Klijenti where tip='fizickoLice'").list();
		        t.commit();
		        session.close();
		        Klijenti k=new Klijenti();
		        
		        if(!klijenti.isEmpty())
		        {
		        for(int i=0; i<klijenti.size();i++)
		        {
		        	
		        k=(Klijenti)klijenti.get(i);
		        combo.add(k.getNaziv(),i);
		        
		        }
				}
	    		
	    		
	    		
	    	}
	    });
		btnFizikoLice.setBounds(10, 56, 90, 16);
		btnFizikoLice.setText("Fizi\u010Dko lice");
		
		//U KONSTRUKTORU PUNJENJE FORME sa fakturom izabranom
		
		List broj;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();			
		Query q = session.createQuery("from Faktura where id=:brojic");
		q.setString("brojic",Long.toString(id_broj));
        broj=q.list();
        t.commit();
        session.close();
        Faktura f=new Faktura();
        
        f=(Faktura)broj.get(0);
        
        List kli;
        long id_klijent= f.getIdklijent();
       
        session = HibernateUtil.getSessionFactory().openSession();
		 t = session.beginTransaction();			
		 q = session.createQuery("from Klijenti where id=:brojic");
		q.setString("brojic",Long.toString(id_klijent));
       kli=q.list();
       t.commit();
       session.close();
       Klijenti k= new Klijenti();
       k=(Klijenti)kli.get(0);
       
       if(k.getTip().equals("fizickoLice"))
       {
    	  
       }
       if(k.getTip().equals("firma"))
       {
    	   
       }
       
        List _ss;
		session = HibernateUtil.getSessionFactory().openSession();
		t = session.beginTransaction();			
		q = session.createQuery("from Stavka_faktura where idfaktura=:brojic");
        q.setString("brojic",Long.toString(id_broj));
       _ss=q.list();
        t.commit();
       session.close();
       
       Stavka_faktura s = new Stavka_faktura();
       
       List _usluge1;
       for(int i=0; i<_ss.size(); i++)
       {
    	   s=(Stavka_faktura)_ss.get(i);
    	   
    	   session = HibernateUtil.getSessionFactory().openSession();
   		   t = session.beginTransaction();			
   		   q = session.createQuery("from Usluga where id=:brojic");
           q.setString("brojic",Long.toString(s.getIDUsluga()));
           _uzete.add(s.getIDUsluga());
          
           _usluge1=q.list();
           t.commit();
          session.close();
          
          Usluga u= new Usluga();
          u=(Usluga)_usluge1.get(0);
          
          TableItem item = new TableItem(table, 0, br_stavki);
          item.setText(0,Integer.toString(br_stavki+1));
          item.setText(1,u.getNaziv());
          item.setText(2, u.getOpisUsluge());
          item.setText(3, Integer.toString(u.getCijena()));
          item.setText(4, "1");
          double cijena= u.getCijena() + u.getCijena()*0.17;
          item.setText(5,Double.toString(cijena) );
          
          br_stavki++;
          
       }
       text.setText(f.getKomentar());
       
       
       
       
       createContents();
		
	}
       
	
	public void Provjeri()
	{
		
		if(!_usluge.isEmpty())
		{
	   
		String x=new String();	
		x =(String)_usluge.get(0);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
        Query q = session.createQuery("from Usluga where naziv=:naziv");
        q.setString("naziv", x);
        stavka=q.list();
        t.commit();
        session.close();
        Usluga k=new Usluga();
		
        
        
        
        k = (Usluga) stavka.get(0);
        _uzete.add(k.getId());
        TableItem item = new TableItem(table, 0, br_stavki);
        item.setText(0,Integer.toString(br_stavki+1));
        item.setText(1,k.getNaziv());
        item.setText(2, k.getOpisUsluge());
        item.setText(3, Integer.toString(k.getCijena()));
        item.setText(4, "1");
        double cijena= k.getCijena() + k.getCijena()*0.17;
        item.setText(5,Double.toString(cijena) );
   	    
        
        stavka.clear();
   	    _usluge.clear();
   	     br_stavki++;
		}
        
	}

	/**
	 * Create contents of the shell.
	 */
	
	
	protected void createContents() {
		
		
//		this = new Shell();
		this.setImage(SWTResourceManager.getImage(FaktureTrenutnaIzmjenaForm.class, "/images/1396674611_invoice.png"));
		this.setSize(697, 677);
		this.setText("Izmjena fakture");
		
		
		
		
		
		
		
		
		
		
		
		
		Label lblStavkeFakture = new Label(this, SWT.NONE);
		lblStavkeFakture.setBounds(10, 158, 132, 15);
		lblStavkeFakture.setText("Dodavanje stavki fakture:");
		
		
		
		final FaktureTrenutnaIzmjenaForm f =this;
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				FaktureStavkeDodavanjeForm2 a = new FaktureStavkeDodavanjeForm2(null,_usluge,f);
				a.open();

			}
		});
		btnNewButton.setImage(SWTResourceManager.getImage(FaktureTrenutnaIzmjenaForm.class, "/images/1398624464_plus-sign.png"));
		btnNewButton.setBounds(148, 146, 120, 38);
		btnNewButton.setText("Dodaj stavku");
		
		Button btnIzmjeni = new Button(this, SWT.NONE);
		btnIzmjeni.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				ControlDecoration textError = new ControlDecoration(text, SWT.RIGHT | SWT.TOP);
				if (text.getText().length()>199)
				{
					textError.setDescriptionText("Manje od 200 karaktera mora komentar  biti!");
					FieldDecoration text10Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					textError.setImage(text10Field.getImage());
					textError.showHoverText("Manje od 200 karaktera mora biti komentar!");
				}
				else
				{
					
				if(br_stavki!=0 && combo.getSelectionIndex()!=-1)
				{
				//trazim id od klijenta
					
				List broj;
				String value=combo.getItem(combo.getSelectionIndex()).toString();
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction t = session.beginTransaction();			
				Query q = session.createQuery("from Klijenti where naziv=:naziv");
		        q.setString("naziv", value);
		        broj=q.list();
		        t.commit();
		        session.close();
		        Klijenti k=new Klijenti();
		        if(!broj.isEmpty())
		        {
		          k=(Klijenti)broj.get(0);
		        }
		        long id =k.getId();
		        //uzmem koja je faktura
		        List vidi_f;
				session = HibernateUtil.getSessionFactory().openSession();
				t = session.beginTransaction();			
				q = session.createQuery("from Faktura where id=:brojic");
		        q.setString("brojic", Long.toString(id_broj));
		        vidi_f=q.list();
		        t.commit();
		        session.close();
		        Faktura stara = new Faktura();
		        stara=(Faktura)vidi_f.get(0);
		        
		        
		        
				
				int random = 5 + (int)(Math.random() * ((50000 - 10000) + 1));
				//UPIS u bazu
				List _usluge;
				Usluga ug= new Usluga();
				double cijena=0;
				for(int i =0; i<_uzete.size(); i++)
				{
					
					long id_u=_uzete.get(i);
					session = HibernateUtil.getSessionFactory().openSession();
					t = session.beginTransaction();			
					q = session.createQuery("from Usluga where id=:brojic");
			        q.setString("brojic", Long.toString(id_u));
			       _usluge=q.list();
			        t.commit();
			        session.close();
			        ug=(Usluga)_usluge.get(0);
			        cijena+=ug.getCijena();
				}
				
				
				Faktura f=new Faktura(1,id,cijena,k.getNaziv(),k.getAdresa(), Integer.toString(k.getPdv()), Integer.toString(k.getPdv()),stara.getBroj_fakture() , "Sarajevo",stara.getDatum_izdavanja(),text.getText());
				f.spasiUBazu();
				
				
				// IZBRISI STARU
				 session = HibernateUtil.getSessionFactory().openSession();
				 t = session.beginTransaction();
				Faktura myObject = (Faktura) session.load(Faktura.class,id_broj);
				myObject.setDeleted(1);
				session.update(myObject);
			    session.getTransaction().commit();
				
				//DIO ZA ID FAKTURE SPASENE
				List vidi_broj;
				session = HibernateUtil.getSessionFactory().openSession();
				t = session.beginTransaction();			
				q = session.createQuery("from Faktura where broj_fakture=:brojic and deleted=:del");
		        q.setString("brojic", Integer.toString(stara.getBroj_fakture()));
		        q.setString("del", Integer.toString(0));
		        vidi_broj=q.list();
		        t.commit();
		        session.close();
		        
				Faktura ff=new Faktura();
				
				if(!vidi_broj.isEmpty())
				{
				ff=(Faktura)vidi_broj.get(0);
				
				// dodavanje stavka_faktura u bazu
				for(int i = 0; i<br_stavki;i++)
				{
					Long x= (Long)_uzete.get(i);
					Stavka_faktura s=new Stavka_faktura(ff.getId(),x);
					s.spasiUBazu();
				}
				
				Shell shell = new Shell();
			    MessageDialog.openInformation(shell, "Info", "Uspjesno je izmjenjena faktura!");
			    
			    table.removeAll();
			    br_stavki=0;
			    text.setText("");
				}
				}
				else
				{
					Shell shell = new Shell();
				    MessageDialog.openInformation(shell, "Info", "Niste unijeli sva polja.");
				}
				
				}
				
				
				
				
				
				
			}
		});
		btnIzmjeni.setText("Izmjeni!");
		btnIzmjeni.setImage(SWTResourceManager.getImage(FaktureTrenutnaIzmjenaForm.class, "/images/1398574614_switch_on.png"));
		btnIzmjeni.setBounds(431, 591, 116, 42);
		
		Button button_2 = new Button(this, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		button_2.setText("Izlaz");
		button_2.setImage(SWTResourceManager.getImage(FaktureTrenutnaIzmjenaForm.class, "/images/1398195841_DeleteRed.png"));
		button_2.setBounds(554, 591, 116, 42);
		
		
		
		Label lblDodatniZahtjeviVezani = new Label(this, SWT.NONE);
		lblDodatniZahtjeviVezani.setBounds(10, 420, 258, 15);
		lblDodatniZahtjeviVezani.setText("Dodatni zahtjevi vezani za fakturu(tekstualno):");
		
		Button btnNewButton_1 = new Button(this, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if(table.getSelectionIndex()!=-1)
				{
					
					
					
					int iti = table.getSelectionIndex();
					TableItem ti=table.getItem(iti);
					String xn=ti.getText(1);
					double xc=Double.parseDouble(ti.getText(3));
					
					
				    
					List lbroj;
					Session session = HibernateUtil.getSessionFactory().openSession();
					Transaction t = session.beginTransaction();
			        Query q = session.createQuery("from Usluga where naziv=:naziv and cijena=:cijena");
			        q.setString("naziv", xn);
			        q.setString("cijena", Double.toString(xc));
			        lbroj=q.list();
			        t.commit();
			        session.close();
			        Usluga k=new Usluga();
			        k=(Usluga)lbroj.get(0);
			        
			        
			        
			        for(int i = 0; i<_uzete.size();i++)
			        {
			        	long x= _uzete.get(i);
			        	if(x==k.getId())
			        	{
			        		_uzete.remove(i);
			        		br_stavki--;
			        		break;
			        	}
			        }
			        table.remove(iti);
			        table.setSelection(-1);
			        
				}
				else 
				{
					Shell shell = new Shell();
				    MessageDialog.openInformation(shell, "Info", "Nije selektovana stavka.");
				}
				
			}
		});
		btnNewButton_1.setBounds(301, 145, 116, 38);
		btnNewButton_1.setText("Bri\u0161i stavku");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
