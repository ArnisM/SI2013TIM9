package ba.unsa.etf.si2013.tim9.Ponude;

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
import org.eclipse.swt.widgets.Text;
//import org.eclipse.wb.swt.DodavanjeStavkiFaktureForm;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.DisposeEvent;








import javax.persistence.GeneratedValue; 
import javax.persistence.Id;
import javax.persistence.Transient;

import java.util.Date;	
import java.util.List;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.hql.internal.ast.util.SessionFactoryHelper;

import ba.unsa.etf.si2013.tim9.HibernateUtil;
import ba.unsa.etf.si2013.tim9.Klijenti.Klijenti;

import org.hibernate.Query;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.TableItem;

import ba.unsa.etf.si2013.tim9.HibernateUtil;
import ba.unsa.etf.si2013.tim9.Usluge.Usluga;


public class PonudeDodavanjeForm extends Shell {

	
//	protected Shell this;
	// SVI FINI ATRBIBUTI !!!
	private Table table;
	private Text text;
	private ArrayList<String> _usluge;
	private	Label lblStavkeFakture ;
	private List stavka;
	private ArrayList<Long> _uzete;
	private int br_stavki;
	
	
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			PonudeDodavanjeForm shell = new PonudeDodavanjeForm(display);
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

	
	// KONSTRUKTOR DA SE FINO SVE MOZE KORISTIT
	public PonudeDodavanjeForm(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		_usluge=new ArrayList<String>();
		_uzete=new ArrayList<Long>();
		br_stavki=0;
		
		lblStavkeFakture= new Label(this, SWT.NONE);
		lblStavkeFakture.setBounds(10, 158, 132, 15);
		lblStavkeFakture.setText("Dodavanje stavki ponude:");
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setSelection(-1);
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
		
		
		createContents();
	}

	
	// FUNKCIJA POZOVE CHILD FORMA DA POPUNI INSTANTO
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
        item.setText(3, Double.toString(k.getCijena()));
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
       // this = new Shell();
		
		
		this.setImage(SWTResourceManager.getImage(PonudeDodavanjeForm.class, "/images/1396674611_invoice.png"));
		this.setSize(697, 677);
		this.setText("Dodavanje nove ponude");
		
		
		
		final Group grpKlijent = new Group(this, SWT.NONE);
		grpKlijent.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent arg0) {
			}
		});
		
		grpKlijent.setText("Klijent");
		grpKlijent.setBounds(10, 10, 649, 123);
		
		final Label lblIzaberiteFirmu = new Label(grpKlijent, SWT.NONE);
		lblIzaberiteFirmu.setBounds(170, 36, 95, 15);
		lblIzaberiteFirmu.setText("Odaberite firmu:");
		
		final Combo combo = new Combo(grpKlijent, SWT.NONE);
		
		combo.setBounds(271, 33, 141, 23);
		
		Group grpOdabir = new Group(grpKlijent, SWT.NONE);
		grpOdabir.setText("Odabir");
		grpOdabir.setBounds(10, 20, 123, 82);
		
		
		// ZA FIRMA RADIO BUTTON
		Button btnFirma = new Button(grpOdabir, SWT.RADIO);
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
		        
			}});
		btnFirma.setBounds(10, 23, 90, 16);
		btnFirma.setText("Firma");
		
		
		//ZA FIZICKO LICE RADIO 
		Button btnFizikoLice = new Button(grpOdabir, SWT.RADIO);
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
		
		
	    //BITNO !!!!
		final PonudeDodavanjeForm f =this;
		
		
		// DODAVANJE USLUGA REFERENCIRANJE U NOVOJ FORMI MAJKAAAAAAAAAAAAAAAAA
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				PonudeStavkeDodavanjeForm a = new PonudeStavkeDodavanjeForm(null,_usluge,f);
				a.open();
			
			}
		});
		btnNewButton.setImage(SWTResourceManager.getImage(PonudeDodavanjeForm.class, "/images/1398624464_plus-sign.png"));
		btnNewButton.setBounds(148, 146, 120, 38);
		btnNewButton.setText("Dodaj stavku");
		
		// TEXTUALNO POLJEEE
				text = new Text(this, SWT.BORDER);
				text.setBounds(10, 441, 611, 135);
		
		//DODAVANJE U BAZU USPJESNOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
		Button button_1 = new Button(this, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
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
		        
				Date d=new Date();
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
				
				
				Ponuda f=new Ponuda(1,id,cijena,k.getNaziv(),k.getAdresa(), Integer.toString(k.getPdv()), Integer.toString(k.getPdv()),random , "Sarajevo",d,text.getText());
				f.spasiUBazu();
				
				
				
				//DIO ZA ID FAKTURE SPASENE
				List vidi_broj;
				session = HibernateUtil.getSessionFactory().openSession();
				t = session.beginTransaction();			
				q = session.createQuery("from Ponuda where broj_ponude=:brojic");
		        q.setString("brojic", Integer.toString(random));
		        vidi_broj=q.list();
		        t.commit();
		        session.close();
		        
				Ponuda ff=new Ponuda();
				
				if(!vidi_broj.isEmpty())
				{
				ff=(Ponuda)vidi_broj.get(0);
				
				// dodavanje stavka_ponuda u bazu
				for(int i = 0; i<br_stavki;i++)
				{
					Long x= (Long)_uzete.get(i);
					Stavka_ponuda s=new Stavka_ponuda(ff.getId(),x);
					s.spasiUBazu();
				}
				
				Shell shell = new Shell();
			    MessageDialog.openInformation(shell, "Info", "Uspjesno dodana ponuda!");
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
			
			
			}});
		button_1.setText("Dodaj");
		button_1.setImage(SWTResourceManager.getImage(PonudeDodavanjeForm.class, "/images/1398195801_tick_32.png"));
		button_1.setBounds(431, 591, 116, 42);
		
		
		// ZATVARANJE FORMEEEE
		Button button_2 = new Button(this, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		button_2.setText("Izlaz");
		button_2.setImage(SWTResourceManager.getImage(PonudeDodavanjeForm.class, "/images/1398195841_DeleteRed.png"));
		button_2.setBounds(554, 591, 116, 42);
		
		
		
		Label lblDodatniZahtjeviVezani = new Label(this, SWT.NONE);
		lblDodatniZahtjeviVezani.setBounds(10, 420, 258, 15);
		lblDodatniZahtjeviVezani.setText("Dodatni zahtjevi vezani za ponudu(tekstualno):");
		
		// DUGME ZA BRISANJE NSTAVKI
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
		btnNewButton_1.setBounds(288, 146, 116, 38);
		btnNewButton_1.setText("Bri\u0161i stavku");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
