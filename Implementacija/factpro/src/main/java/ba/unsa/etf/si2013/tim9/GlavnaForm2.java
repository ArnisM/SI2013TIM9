package ba.unsa.etf.si2013.tim9;


import java.io.InputStream;

import org.eclipse.swt.widgets.Display;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;

import ba.unsa.etf.si2013.tim9.Fakture.FaktureBrisanjeForm;
import ba.unsa.etf.si2013.tim9.Fakture.FaktureDodavanjeForm;
import ba.unsa.etf.si2013.tim9.Fakture.FaktureIzmjenaForm;
import ba.unsa.etf.si2013.tim9.Fakture.FakturePretragaForm;
import ba.unsa.etf.si2013.tim9.Izvjestaji.IzvjestajPoKlijentForm;
import ba.unsa.etf.si2013.tim9.Izvjestaji.IzvjestajiPerdiodForm;
import ba.unsa.etf.si2013.tim9.Klijenti.KlijentiBrisanjeForm;
import ba.unsa.etf.si2013.tim9.Klijenti.KlijentiDodavanjeForm;
import ba.unsa.etf.si2013.tim9.Klijenti.KlijentiFirmeBrisanjeForm;
import ba.unsa.etf.si2013.tim9.Klijenti.KlijentiFirmeIzmjenaForm;
import ba.unsa.etf.si2013.tim9.Klijenti.KlijentiIzmjenaForm;
import ba.unsa.etf.si2013.tim9.Klijenti.KlijentiPretragaForm;
import ba.unsa.etf.si2013.tim9.Korisnici.KorisniciBrisanjeForm;
import ba.unsa.etf.si2013.tim9.Korisnici.KorisniciDodavanjeForm;
import ba.unsa.etf.si2013.tim9.Korisnici.KorisniciIzmjenaForm;
import ba.unsa.etf.si2013.tim9.Korisnici.KorisniciPretragaForm;
import ba.unsa.etf.si2013.tim9.Ponude.PonudeBrisanjeForm;
import ba.unsa.etf.si2013.tim9.Ponude.PonudeDodavanjeForm;
import ba.unsa.etf.si2013.tim9.Ponude.PonudeIzmjenaForm;
import ba.unsa.etf.si2013.tim9.Ponude.PonudePretragaForm;
import ba.unsa.etf.si2013.tim9.Predracuni.PredracunBrisanjeForm;
import ba.unsa.etf.si2013.tim9.Predracuni.PredracunDodavanjeForm;
import ba.unsa.etf.si2013.tim9.Predracuni.PredracunIzmjenaForm;
import ba.unsa.etf.si2013.tim9.Predracuni.PredracunPretragaForm;
import ba.unsa.etf.si2013.tim9.Usluge.UslugeBrisanjeForm;
import ba.unsa.etf.si2013.tim9.Usluge.UslugeDodavanjeForm;
import ba.unsa.etf.si2013.tim9.Usluge.UslugeIzmjenaForm;
import ba.unsa.etf.si2013.tim9.Usluge.UslugePretragaForm;
import ba.unsa.etf.si2013.tim9.Klijenti.*;
public class GlavnaForm2 {

	protected Shell shell;
	//final Display display = new Display();
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GlavnaForm2 window = new GlavnaForm2();
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
		shell.setMaximized(true);
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
		shell.setBackground(SWTResourceManager.getColor(30, 144, 255));
		shell.setToolTipText("");
		shell.setImage(SWTResourceManager.getImage(GlavnaForm2.class, "/images/logosi.png"));
		shell.setSize(1291, 675);
		shell.setText("FACTPRO");
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		MenuItem mntmNewSubmenu = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu.setImage(SWTResourceManager.getImage(GlavnaForm2.class, "/images/1396674475_user_male2.png"));
		mntmNewSubmenu.setText("Korisnici");
		
		Menu menu_1 = new Menu(mntmNewSubmenu);
		mntmNewSubmenu.setMenu(menu_1);
		
		MenuItem mntmDodaj = new MenuItem(menu_1, SWT.NONE);
		mntmDodaj.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				KorisniciDodavanjeForm a = new KorisniciDodavanjeForm(null);
				a.open();
				//DodavanjeKorisnikaForm dk = new DodavanjeKorisnikaForm();
				//dk.open();
			}
		});
		mntmDodaj.setText("Dodaj");
		
		MenuItem mntmIzmjeni = new MenuItem(menu_1, SWT.NONE);
		mntmIzmjeni.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				KorisniciIzmjenaForm a = new KorisniciIzmjenaForm(null);
				a.open();
				//IzmjenaKorisnikaForm ik = new IzmjenaKorisnikaForm();
				//ik.open();
			}
			
		});
		mntmIzmjeni.setText("Izmjeni");
		
		MenuItem mntmBrii = new MenuItem(menu_1, SWT.NONE);
		mntmBrii.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				KorisniciBrisanjeForm a= new KorisniciBrisanjeForm(null);
				a.open();
				//BrisanjeKorisnikaForm bk= new BrisanjeKorisnikaForm();
				//bk.open();
			}
		});
		mntmBrii.setText("Bri\u0161i");
		
		MenuItem mntmPretragaIIspis = new MenuItem(menu_1, SWT.NONE);
		mntmPretragaIIspis.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				KorisniciPretragaForm a = new KorisniciPretragaForm(null);
				a.open();
			}
		});
		mntmPretragaIIspis.setText("Pretraga i ispis");
		
		//InputStream stream = GlavnaForm2.class.getResourceAsStream("/src/1396674421_Streamline-61.png"); 

       // Image imgTrayIcon = new Image(display, stream);
		
		MenuItem mntmKlijenti = new MenuItem(menu, SWT.CASCADE);
		mntmKlijenti.setImage(SWTResourceManager.getImage(GlavnaForm2.class, "/images/1396674421_Streamline-61.png"));
		//mntmKlijenti.setImage(imgTrayIcon);
		mntmKlijenti.setText("Klijenti");
		
		Menu menu_7 = new Menu(mntmKlijenti);
		mntmKlijenti.setMenu(menu_7);
		
		MenuItem mntmDodaj_1 = new MenuItem(menu_7, SWT.NONE);
		mntmDodaj_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				KlijentiDodavanjeForm a = new KlijentiDodavanjeForm(null);
				a.open();
			}
		});
		mntmDodaj_1.setText("Dodaj");
		
		MenuItem mntmNewSubmenu_1 = new MenuItem(menu_7, SWT.CASCADE);
		mntmNewSubmenu_1.setText("Izmjeni");
		
		Menu menu_9 = new Menu(mntmNewSubmenu_1);
		mntmNewSubmenu_1.setMenu(menu_9);
		
		MenuItem mntmFizikaLica_1 = new MenuItem(menu_9, SWT.NONE);
		mntmFizikaLica_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				KlijentiIzmjenaForm a = new KlijentiIzmjenaForm(null);
				a.open();
			}
		});
		mntmFizikaLica_1.setText("Fizi\u010Dka lica");
		
		MenuItem mntmFirme_1 = new MenuItem(menu_9, SWT.NONE);
		mntmFirme_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				KlijentiFirmeIzmjenaForm a = new KlijentiFirmeIzmjenaForm(null);
				a.open();
			}
		});
		mntmFirme_1.setText("Firme");
		
		MenuItem mntmBrii_2 = new MenuItem(menu_7, SWT.CASCADE);
		mntmBrii_2.setText("Bri\u0161i");
		
		Menu menu_6 = new Menu(mntmBrii_2);
		mntmBrii_2.setMenu(menu_6);
		
		MenuItem mntmFirme = new MenuItem(menu_6, SWT.NONE);
		mntmFirme.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				KlijentiFirmeBrisanjeForm a = new KlijentiFirmeBrisanjeForm(null);
				a.open();
			}
		});
		mntmFirme.setText("Firme");
		
		MenuItem mntmFizikaLica = new MenuItem(menu_6, SWT.NONE);
		mntmFizikaLica.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				KlijentiBrisanjeForm a = new KlijentiBrisanjeForm(null);
				a.open();
				//BrisanjeKlijentaForm bkf = new BrisanjeKlijentaForm ();
				//bkf.open();
			}
		});
		mntmFizikaLica.setText("Fizi\u010Dka lica");
		
		MenuItem mntmPretragaIIspis_2 = new MenuItem(menu_7, SWT.CASCADE);
		mntmPretragaIIspis_2.setText("Pretraga i ispis");
		
		Menu menu_10 = new Menu(mntmPretragaIIspis_2);
		mntmPretragaIIspis_2.setMenu(menu_10);
		
		MenuItem mntmFizikaLica_2 = new MenuItem(menu_10, SWT.NONE);
		mntmFizikaLica_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				KlijentiPretragaForm k=new KlijentiPretragaForm(null);
				k.open();
			}
		});
		mntmFizikaLica_2.setText("Fizi\u010Dka lica");
		
		MenuItem mntmFirma = new MenuItem(menu_10, SWT.NONE);
		mntmFirma.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				KlijentiFirmePretragaForm k=new KlijentiFirmePretragaForm(null);
				k.open();
			}
		});
		mntmFirma.setText("Firma");
		
		MenuItem mntmUsluge = new MenuItem(menu, SWT.CASCADE);
		mntmUsluge.setImage(SWTResourceManager.getImage(GlavnaForm2.class, "/images/1396674353_services.png"));
		mntmUsluge.setText("Usluge");
		
		Menu menu_2 = new Menu(mntmUsluge);
		mntmUsluge.setMenu(menu_2);
		
		MenuItem mntmDodaj_2 = new MenuItem(menu_2, SWT.NONE);
		mntmDodaj_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				UslugeDodavanjeForm a = new UslugeDodavanjeForm(null);
				a.open();
			}
		});
		mntmDodaj_2.setText("Dodaj");
		
		MenuItem mntmIzmjeni_2 = new MenuItem(menu_2, SWT.NONE);
		mntmIzmjeni_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				UslugeIzmjenaForm a = new UslugeIzmjenaForm(null);
				a.open();
			}
		});
		mntmIzmjeni_2.setText("Izmjeni");
		
		MenuItem mntmBrii_1 = new MenuItem(menu_2, SWT.NONE);
		mntmBrii_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				UslugeBrisanjeForm a = new UslugeBrisanjeForm(null);
				a.open();
			}
		});
		mntmBrii_1.setText("Bri\u0161i");
		
		MenuItem mntmPretraga_2 = new MenuItem(menu_2, SWT.NONE);
		mntmPretraga_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				UslugePretragaForm a = new UslugePretragaForm(null);
				a.open();
			}
		});
		mntmPretraga_2.setText("Pretraga i ispis");
		
		MenuItem mntmPonude = new MenuItem(menu, SWT.CASCADE);
		mntmPonude.setImage(SWTResourceManager.getImage(GlavnaForm2.class, "/images/1396674680_document_text.png"));
		mntmPonude.setText("Ponude");
		
		Menu menu_3 = new Menu(mntmPonude);
		mntmPonude.setMenu(menu_3);
		
		MenuItem mntmDodaj_3 = new MenuItem(menu_3, SWT.NONE);
		mntmDodaj_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PonudeDodavanjeForm a = new PonudeDodavanjeForm(null);
				a.open();
				//DodavanjeNovePonudeForm d = new DodavanjeNovePonudeForm();
				//d.open();
			}
		});
		mntmDodaj_3.setText("Dodaj ponudu");
		
		MenuItem mntmIzmjeniPonudu = new MenuItem(menu_3, SWT.NONE);
		mntmIzmjeniPonudu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PonudeIzmjenaForm a = new PonudeIzmjenaForm(null);
				a.open();
				//IzmjenaPonudeForm i = new IzmjenaPonudeForm();
				//i.open();
			}
		});
		mntmIzmjeniPonudu.setText("Izmjeni ponudu");
		
		MenuItem mntmBriiPonudu = new MenuItem(menu_3, SWT.NONE);
		mntmBriiPonudu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PonudeBrisanjeForm a = new PonudeBrisanjeForm(null);
				a.open();
			}
		});
		mntmBriiPonudu.setText("Bri\u0161i ponudu");
		
		MenuItem mntmPretragaIIspis_1 = new MenuItem(menu_3, SWT.NONE);
		mntmPretragaIIspis_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PonudePretragaForm a = new PonudePretragaForm (null);
				a.open();
			}
		});
		mntmPretragaIIspis_1.setText("Pretraga i ispis ponude");
		
		MenuItem mntmPredrauni = new MenuItem(menu, SWT.CASCADE);
		mntmPredrauni.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
			}
		});
		mntmPredrauni.setImage(SWTResourceManager.getImage(GlavnaForm2.class, "/images/1396674611_invoice.png"));
		mntmPredrauni.setText("Predra\u010Duni");
		
		Menu menu_4 = new Menu(mntmPredrauni);
		mntmPredrauni.setMenu(menu_4);
		
		MenuItem mntmDodavanjePredrauna = new MenuItem(menu_4, SWT.NONE);
		mntmDodavanjePredrauna.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PredracunDodavanjeForm a=new PredracunDodavanjeForm(null);
				a.open();
				
			}
		});
		mntmDodavanjePredrauna.setText("Dodavanje predra\u010Duna");
		
		MenuItem mntmBrisanjePredrauna = new MenuItem(menu_4, SWT.NONE);
		mntmBrisanjePredrauna.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PredracunBrisanjeForm a=new PredracunBrisanjeForm(null);
				a.open();
			}
		});
		mntmBrisanjePredrauna.setText("Brisanje predra\u010Duna");
		
		MenuItem mntmPretragaPredrauna = new MenuItem(menu_4, SWT.NONE);
		mntmPretragaPredrauna.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PredracunPretragaForm a=new PredracunPretragaForm(null);
				a.open();
			}
		});
		mntmPretragaPredrauna.setText("Pretraga predra\u010Duna");
		
		MenuItem mntmIzmjenaPredrauna = new MenuItem(menu_4, SWT.NONE);
		mntmIzmjenaPredrauna.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PredracunIzmjenaForm a= new PredracunIzmjenaForm(null);
				a.open();
			}
		});
		mntmIzmjenaPredrauna.setText("Izmjena predra\u010Duna");
		
		MenuItem mntmFakture = new MenuItem(menu, SWT.CASCADE);
		mntmFakture.setImage(SWTResourceManager.getImage(GlavnaForm2.class, "/images/1396674611_invoice.png"));
		mntmFakture.setText("Fakture");
		
		Menu menu_5 = new Menu(mntmFakture);
		mntmFakture.setMenu(menu_5);
		
		MenuItem mntmDodavanjeNoveFakture = new MenuItem(menu_5, SWT.NONE);
		mntmDodavanjeNoveFakture.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FaktureDodavanjeForm a = new FaktureDodavanjeForm(null);
				a.open();
				//DodavanjNoveFaktureForm df = new DodavanjNoveFaktureForm();
				//df.open();
			}
		});
		mntmDodavanjeNoveFakture.setText("Dodavanje nove fakture");
		
		MenuItem mntmIzmjenaFakture = new MenuItem(menu_5, SWT.NONE);
		mntmIzmjenaFakture.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FaktureIzmjenaForm a = new FaktureIzmjenaForm(null);
				a.open();
				//IzmjenaFaktureForm ifo =new  IzmjenaFaktureForm();
				//ifo.open();
			}
		});
		mntmIzmjenaFakture.setText("Izmjena fakture");
		
		MenuItem mntmBrisanjeFakture = new MenuItem(menu_5, SWT.NONE);
		mntmBrisanjeFakture.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FaktureBrisanjeForm a = new FaktureBrisanjeForm(null);
				a.open();
				//BrisanjeFaktureForm bf = new BrisanjeFaktureForm();
				//bf.open();
			}
		});
		mntmBrisanjeFakture.setText("Brisanje fakture");
		
		MenuItem mntmPretragaFaktura = new MenuItem(menu_5, SWT.NONE);
		mntmPretragaFaktura.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FakturePretragaForm a = new FakturePretragaForm(null);
				a.open();
				//PretragaFakturaForm pf = new PretragaFakturaForm();
				//pf.open();
			}
		});
		mntmPretragaFaktura.setText("Pretraga i ispis faktura");

	}
}
