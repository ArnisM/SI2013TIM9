package org.eclipse.wb.swt;

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


public class GlavnaForm {

	protected Shell shell;
	final Display display = new Display();
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GlavnaForm window = new GlavnaForm();
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
		shell.setImage(SWTResourceManager.getImage("src/logosi.png"));
		shell.setSize(1291, 675);
		shell.setText("FACTPRO");
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		MenuItem mntmNewSubmenu = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu.setImage(SWTResourceManager.getImage("/src/1396674475_user_male2.png"));
		mntmNewSubmenu.setText("Korisnici");
		
		Menu menu_1 = new Menu(mntmNewSubmenu);
		mntmNewSubmenu.setMenu(menu_1);
		
		MenuItem mntmDodaj = new MenuItem(menu_1, SWT.NONE);
		mntmDodaj.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DodavanjeKorisnikaForm dk = new DodavanjeKorisnikaForm();
				dk.open();
			}
		});
		mntmDodaj.setText("Dodaj");
		
		MenuItem mntmIzmjeni = new MenuItem(menu_1, SWT.NONE);
		mntmIzmjeni.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				IzmjenaKorisnikaForm ik = new IzmjenaKorisnikaForm();
				ik.open();
			}
			
		});
		mntmIzmjeni.setText("Izmjeni");
		
		MenuItem mntmBrii = new MenuItem(menu_1, SWT.NONE);
		mntmBrii.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				BrisanjeKorisnikaForm bk= new BrisanjeKorisnikaForm();
				bk.open();
			}
		});
		mntmBrii.setText("Bri\u0161i");
		
		MenuItem mntmPretragaIIspis = new MenuItem(menu_1, SWT.NONE);
		mntmPretragaIIspis.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PretragaKorisnikaForm pk = new PretragaKorisnikaForm();
				pk.open();
			}
		});
		mntmPretragaIIspis.setText("Pretraga i ispis");
		
		InputStream stream = GlavnaForm.class.getResourceAsStream("/src/1396674421_Streamline-61.png"); 

        Image imgTrayIcon = new Image(display, stream);
		
		MenuItem mntmKlijenti = new MenuItem(menu, SWT.CASCADE);
		mntmKlijenti.setImage(imgTrayIcon);
		mntmKlijenti.setText("Klijenti");
		
		Menu menu_7 = new Menu(mntmKlijenti);
		mntmKlijenti.setMenu(menu_7);
		
		MenuItem mntmDodaj_1 = new MenuItem(menu_7, SWT.NONE);
		mntmDodaj_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DodavanjeKlijentaForm dkf = new DodavanjeKlijentaForm ();
				dkf.open();
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
				IzmjenaKlijentaForm i = new IzmjenaKlijentaForm();
				i.open();
			}
		});
		mntmFizikaLica_1.setText("Fizi\u010Dka lica");
		
		MenuItem mntmFirme_1 = new MenuItem(menu_9, SWT.NONE);
		mntmFirme_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				IzmjenaFirmeForm f= new IzmjenaFirmeForm();
				f.open();
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
				BrisanjeFirmeForm bff = new BrisanjeFirmeForm ();
				bff.open();
			}
		});
		mntmFirme.setText("Firme");
		
		MenuItem mntmFizikaLica = new MenuItem(menu_6, SWT.NONE);
		mntmFizikaLica.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				BrisanjeKlijentaForm bkf = new BrisanjeKlijentaForm ();
				bkf.open();
			}
		});
		mntmFizikaLica.setText("Fizi\u010Dka lica");
		
		MenuItem mntmPretraga_1 = new MenuItem(menu_7, SWT.NONE);
		mntmPretraga_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PretragaKlijenataForm pk = new PretragaKlijenataForm ();
				pk.open();
			}
		});
		mntmPretraga_1.setText("Pretraga i ispis");
		
		MenuItem mntmUsluge = new MenuItem(menu, SWT.CASCADE);
		mntmUsluge.setImage(SWTResourceManager.getImage("src/1396674353_services.png"));
		mntmUsluge.setText("Usluge");
		
		Menu menu_2 = new Menu(mntmUsluge);
		mntmUsluge.setMenu(menu_2);
		
		MenuItem mntmDodaj_2 = new MenuItem(menu_2, SWT.NONE);
		mntmDodaj_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DodavanjeUslugaForm du = new DodavanjeUslugaForm();
				du.open();
			}
		});
		mntmDodaj_2.setText("Dodaj");
		
		MenuItem mntmIzmjeni_2 = new MenuItem(menu_2, SWT.NONE);
		mntmIzmjeni_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				IzmjenaUslugeForm iu = new IzmjenaUslugeForm();
				iu.open();
			}
		});
		mntmIzmjeni_2.setText("Izmjeni");
		
		MenuItem mntmBrii_1 = new MenuItem(menu_2, SWT.NONE);
		mntmBrii_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				BrisanjeUslugeForm b =new BrisanjeUslugeForm();
				b.open();
			}
		});
		mntmBrii_1.setText("Bri\u0161i");
		
		MenuItem mntmPretraga_2 = new MenuItem(menu_2, SWT.NONE);
		mntmPretraga_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PretragaUslugeForm pu = new PretragaUslugeForm();
				pu.open();
			}
		});
		mntmPretraga_2.setText("Pretraga i ispis");
		
		MenuItem mntmPonude = new MenuItem(menu, SWT.CASCADE);
		mntmPonude.setImage(SWTResourceManager.getImage("src/1396674680_document_text.png"));
		mntmPonude.setText("Ponude");
		
		Menu menu_3 = new Menu(mntmPonude);
		mntmPonude.setMenu(menu_3);
		
		MenuItem mntmDodaj_3 = new MenuItem(menu_3, SWT.NONE);
		mntmDodaj_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DodavanjeNovePonudeForm d = new DodavanjeNovePonudeForm();
				d.open();
			}
		});
		mntmDodaj_3.setText("Dodaj ponudu");
		
		MenuItem mntmIzmjeniPonudu = new MenuItem(menu_3, SWT.NONE);
		mntmIzmjeniPonudu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				IzmjenaPonudeForm i = new IzmjenaPonudeForm();
				i.open();
			}
		});
		mntmIzmjeniPonudu.setText("Izmjeni ponudu");
		
		MenuItem mntmBriiPonudu = new MenuItem(menu_3, SWT.NONE);
		mntmBriiPonudu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				BrisanjePonudeForm b  =new BrisanjePonudeForm();
				b.open();
			}
		});
		mntmBriiPonudu.setText("Bri\u0161i ponudu");
		
		MenuItem mntmPretragaIIspis_1 = new MenuItem(menu_3, SWT.NONE);
		mntmPretragaIIspis_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PretragaPonudaForm p = new PretragaPonudaForm();
				p.open();
			}
		});
		mntmPretragaIIspis_1.setText("Pretraga i ispis ponude");
		
		MenuItem mntmPredrauni = new MenuItem(menu, SWT.CASCADE);
		mntmPredrauni.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
			}
		});
		mntmPredrauni.setImage(SWTResourceManager.getImage("src/1396674611_invoice.png"));
		mntmPredrauni.setText("Predra\u010Duni");
		
		Menu menu_4 = new Menu(mntmPredrauni);
		mntmPredrauni.setMenu(menu_4);
		
		MenuItem mntmNijeImplementirano = new MenuItem(menu_4, SWT.NONE);
		mntmNijeImplementirano.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
				MessageDialog.openInformation(shell, "Info", "Nije imlementirano.");
				
			}
		});
		mntmNijeImplementirano.setText("Nije implementirano.");
		
		MenuItem mntmFakture = new MenuItem(menu, SWT.CASCADE);
		mntmFakture.setImage(SWTResourceManager.getImage("src/1396674611_invoice.png"));
		mntmFakture.setText("Fakture");
		
		Menu menu_5 = new Menu(mntmFakture);
		mntmFakture.setMenu(menu_5);
		
		MenuItem mntmDodavanjeNoveFakture = new MenuItem(menu_5, SWT.NONE);
		mntmDodavanjeNoveFakture.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DodavanjNoveFaktureForm df = new DodavanjNoveFaktureForm();
				df.open();
			}
		});
		mntmDodavanjeNoveFakture.setText("Dodavanje nove fakture");
		
		MenuItem mntmDodavanjaFaktureNa = new MenuItem(menu_5, SWT.NONE);
		mntmDodavanjaFaktureNa.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DodavanjeFakturePrekoPonudeForm dp = new DodavanjeFakturePrekoPonudeForm();
				dp.open();
			}
		});
		mntmDodavanjaFaktureNa.setText("Dodavanja fakture na osnovu ponude");
		
		MenuItem mntmIzmjenaFakture = new MenuItem(menu_5, SWT.NONE);
		mntmIzmjenaFakture.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				IzmjenaFaktureForm ifo =new  IzmjenaFaktureForm();
				ifo.open();
			}
		});
		mntmIzmjenaFakture.setText("Izmjena fakture");
		
		MenuItem mntmBrisanjeFakture = new MenuItem(menu_5, SWT.NONE);
		mntmBrisanjeFakture.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				BrisanjeFaktureForm bf = new BrisanjeFaktureForm();
				bf.open();
			}
		});
		mntmBrisanjeFakture.setText("Brisanje fakture");
		
		MenuItem mntmPretragaFaktura = new MenuItem(menu_5, SWT.NONE);
		mntmPretragaFaktura.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PretragaFakturaForm pf = new PretragaFakturaForm();
				pf.open();
			}
		});
		mntmPretragaFaktura.setText("Pretraga i ispis faktura");
		
		MenuItem mntmIzvjetaji = new MenuItem(menu, SWT.CASCADE);
		mntmIzvjetaji.setImage(SWTResourceManager.getImage("src/1396674755_519958-021_Document_Text.png"));
		mntmIzvjetaji.setText("Izvje\u0161taji");
		
		Menu menu_8 = new Menu(mntmIzvjetaji);
		mntmIzvjetaji.setMenu(menu_8);
		
		MenuItem mntmPeriodini = new MenuItem(menu_8, SWT.RADIO);
		mntmPeriodini.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				IzvjestajPoKlijentForm ipk = new IzvjestajPoKlijentForm ();
				ipk.open();
			}
		});
		mntmPeriodini.setText("Po klijentu");
		
		MenuItem mntmPeriodini_1 = new MenuItem(menu_8, SWT.NONE);
		mntmPeriodini_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				IzvjestajiPerdiodForm pk = new IzvjestajiPerdiodForm();
				pk.open();
			}
		});
		mntmPeriodini_1.setText("Periodi\u010Dni");

	}
}
