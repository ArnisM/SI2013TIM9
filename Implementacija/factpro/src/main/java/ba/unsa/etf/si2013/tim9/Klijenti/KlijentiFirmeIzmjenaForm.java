package ba.unsa.etf.si2013.tim9.Klijenti;

import java.util.List;

import javax.transaction.Transaction;

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

import ba.unsa.etf.si2013.tim9.HibernateUtil;

public class KlijentiFirmeIzmjenaForm extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
//	protected Shell this;
	private Text text;
	private Table table;
	private Text text_1;
	private Text text_2;
	private Text text_5;
	private Text text_6;
	private Text text_3;
	private Text text_4;
	private List<Klijenti> klijenti;
	
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			KlijentiFirmeIzmjenaForm shell = new KlijentiFirmeIzmjenaForm(
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
	public KlijentiFirmeIzmjenaForm(Display display) {
		super(display, SWT.SHELL_TRIM);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
//		this = new Shell();
		this.setImage(SWTResourceManager.getImage(KlijentiFirmeIzmjenaForm.class, "/images/1396674421_Streamline-61.png"));
		this.setSize(656, 447);
		this.setText("Izmjena firme");
		
		Group group = new Group(this, SWT.NONE);
		group.setText("Pretraga");
		group.setBounds(10, 10, 575, 107);
		
		final Combo combo = new Combo(group, SWT.NONE);
		combo.setItems(new String[] {"Naziv", ""});
		combo.setBounds(112, 35, 142, 23);
		combo.setText("Unesi kriterij pretrage");
		
		Label label = new Label(group, SWT.NONE);
		label.setText("Kirterij pretrage:");
		label.setBounds(10, 38, 96, 15);
		
		text = new Text(group, SWT.BORDER);
		text.setBounds(380, 35, 163, 21);
		
		Label lblUnesiNaziv = new Label(group, SWT.NONE);
		lblUnesiNaziv.setText("Unesi naziv:");
		lblUnesiNaziv.setBounds(280, 38, 96, 15);
		
		Button button = new Button(group, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				Session session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				if(combo.getSelectionIndex()==0){
											
		        Query q = session.createQuery("from Klijenti where naziv=:naziv");
		        q.setString("naziv", text.getText());
		        klijenti=q.list();
		        session.getTransaction().commit();
		        session.close();
		        Klijenti k=new Klijenti();
		        		        
		        for (int i=0; i<klijenti.size(); i++){
		        	k = (Klijenti) klijenti.get(i);
		        	
		        TableItem item = new TableItem(table, 0, i);
		        
		        item.setText(1,k.getNaziv());
           	    item.setText(2,Integer.toString(k.getPdv()));
             	item.setText(3,Integer.toString(k.getPdvbroj()));
           	    item.setText(4,k.getAdresa());
           	    item.setText(5,k.getBrojtelefona());
           	    item.setText(8,k.getEmail());
           	    item.setText(6,k.getBrojtelefona());
           	    item.setText(7, k.getFax());
           	    item.setText(0,Integer.toString((int)k.getId()));
		        }
		    }
				
				
				}
		});
		button.setText("Pretraga");
		button.setImage(SWTResourceManager.getImage(KlijentiFirmeIzmjenaForm.class, "/images/1398199827_search_magnifying_glass_find.png"));
		button.setBounds(427, 62, 116, 35);
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 123, 626, 85);
		
		TableColumn tblclmnId = new TableColumn(table, SWT.NONE);
		tblclmnId.setWidth(31);
		tblclmnId.setText("ID");
		
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
		
		Group group_1 = new Group(this, SWT.NONE);
		group_1.setText("Izmjena atributa");
		group_1.setBounds(10, 228, 626, 115);
		
		Label lblNazivFirme = new Label(group_1, SWT.NONE);
		lblNazivFirme.setText("Naziv firme:");
		lblNazivFirme.setBounds(25, 35, 63, 15);
		
		Label lblPdvBroj = new Label(group_1, SWT.NONE);
		lblPdvBroj.setText("PDV broj:");
		lblPdvBroj.setBounds(25, 56, 55, 15);
		
		Label label_5 = new Label(group_1, SWT.NONE);
		label_5.setText("E-mail:");
		label_5.setBounds(234, 35, 55, 15);
		
		Label lblTel = new Label(group_1, SWT.NONE);
		lblTel.setText("Tel:");
		lblTel.setBounds(234, 56, 82, 15);
		
		text_1 = new Text(group_1, SWT.BORDER);
		text_1.setBounds(118, 32, 90, 21);
		
		text_2 = new Text(group_1, SWT.BORDER);
		text_2.setBounds(118, 56, 90, 21);
		
		text_5 = new Text(group_1, SWT.BORDER);
		text_5.setBounds(316, 32, 90, 21);
		
		text_6 = new Text(group_1, SWT.BORDER);
		text_6.setBounds(316, 56, 90, 21);
		
		Button button_3 = new Button(group_1, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
				
/*ControlDecoration text1Error = new ControlDecoration(text_1, SWT.RIGHT | SWT.TOP);
				
				if (text_1.getText().length()<3 || text_1.getText()==""){
					text1Error.setDescriptionText("Niste unijeli naziv firme!");
					FieldDecoration text1Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text1Error.setImage(text1Field.getImage());
					text1Error.showHoverText("Niste unijeli naziv firme!");
				}
				
ControlDecoration text2Error = new ControlDecoration(text_2, SWT.RIGHT | SWT.TOP);
				
				if (text_2.getText().length()<3 || text_2.getText()==""){
					text2Error.setDescriptionText("Niste unijeli PDV broj!");
					FieldDecoration text2Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text2Error.setImage(text2Field.getImage());
					text2Error.showHoverText("Niste unijeli PDV broj!");
				}
				
ControlDecoration text3Error = new ControlDecoration(text_3, SWT.RIGHT | SWT.TOP);
				
				if (text_3.getText().length()<3 || text_3.getText()==""){
					text3Error.setDescriptionText("Niste unijeli adresu firme!");
					FieldDecoration text3Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text3Error.setImage(text3Field.getImage());
					text3Error.showHoverText("Niste unijeli adresu firme!");
				}
				
ControlDecoration text5Error = new ControlDecoration(text_5, SWT.RIGHT | SWT.TOP);
				
				if (text_5.getText().length()<3 || text_5.getText()==""){
					text5Error.setDescriptionText("Niste unijeli kontakt telefon!");
					FieldDecoration text5Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text5Error.setImage(text5Field.getImage());
					text5Error.showHoverText("Niste unijeli kontakt telefon!");
				}
				else if (!text_5.getText().matches("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{3}$")){
					text5Error.setDescriptionText("Telefon nije u ispravnom formatu!");
					FieldDecoration text5Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text5Error.setImage(text5Field.getImage());
					text5Error.showHoverText("Telefon nije u ispravnom formatu!");
				}
				
ControlDecoration text6Error = new ControlDecoration(text_6, SWT.RIGHT | SWT.TOP);
				
				if (text_6.getText().length()<3 || text_6.getText()==""){
					text6Error.setDescriptionText("Niste unijeli e-mail!");
					FieldDecoration text6Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text6Error.setImage(text6Field.getImage());
					text6Error.showHoverText("Niste unijeli kontakt e-mail!");
				}
				
				else if (!text_6.getText().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
					text6Error.setDescriptionText("E-mail nije u ispravnom formatu!");
					FieldDecoration text6Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text6Error.setImage(text6Field.getImage());
					text6Error.showHoverText("E-mail nije u ispravnom formatu!");
				}
				
ControlDecoration text4Error = new ControlDecoration(text_4, SWT.RIGHT | SWT.TOP);
				
				if (text_4.getText().length()<3 || text_4.getText()==""){
					text4Error.setDescriptionText("Niste unijeli kontakt fax!");
					FieldDecoration text4Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text4Error.setImage(text4Field.getImage());
					text4Error.showHoverText("Niste unijeli kotakt fax!");
				}
				else if (!text_4.getText().matches("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{3}$")){
					text4Error.setDescriptionText("Fax nije u ispravnom formatu!");
					FieldDecoration text4Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text4Error.setImage(text4Field.getImage());
					text4Error.showHoverText("Fax nije u ispravnom formatu!");
				}
				*/
				
					Session session = HibernateUtil.getSessionFactory().openSession();
					session.beginTransaction();
					Klijenti k=new Klijenti();
					int ind=table.getSelectionIndex();
					TableItem ti=table.getItem(ind);
					Klijenti klijent = 
		                    (Klijenti)session.get(Klijenti.class, (long)(Integer.parseInt(ti.getText(0)))); 
					
					if(text_1.getText()!=""){
					
			         klijent.setNaziv( text_1.getText() );
					
						
					}
					if(text_2.getText()!=""){
					
			         klijent.setPdvbroj( Integer.parseInt(text_2.getText()) );
					 
						
					}
					
					if(text_3.getText()!=""){
					 
			         klijent.setAdresa( (text_3.getText()) );
					
						
					}
					
					if(text_4.getText()!=""){
						
						ControlDecoration text4Error = new ControlDecoration(text_4, SWT.RIGHT | SWT.TOP);
						if (!text_4.getText().matches("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{3}$")){
							text4Error.setDescriptionText("Telefon nije u ispravnom formatu!");
							FieldDecoration text4Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
							text4Error.setImage(text4Field.getImage());
							text4Error.showHoverText("Fax nije u ispravnom formatu!");
						}
					
			         klijent.setFax( (text_4.getText()) );
					 
						
					}
					
					if(text_5.getText()!=""){
						ControlDecoration text5Error = new ControlDecoration(text_5, SWT.RIGHT | SWT.TOP);
						if (!text_5.getText().matches("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{3}$")){
							text5Error.setDescriptionText("Telefon nije u ispravnom formatu!");
							FieldDecoration text5Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
							text5Error.setImage(text5Field.getImage());
							text5Error.showHoverText("Telefon nije u ispravnom formatu!");
						}
					
						 klijent.setBrojtelefona( (text_5.getText()) );
					 
						
					}
					
					if(text_6.getText()!=""){
						ControlDecoration text6Error = new ControlDecoration(text_6, SWT.RIGHT | SWT.TOP);
						if (!text_5.getText().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
							text6Error.setDescriptionText("E-mail nije u ispravnom formatu!");
							FieldDecoration text6Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
							text6Error.setImage(text6Field.getImage());
							text6Error.showHoverText("E-mail nije u ispravnom formatu!");
						}
						
				 
			         klijent.setEmail( (text_6.getText()) );
						
						
					}
					
					session.update(klijent); 
			        session.getTransaction().commit();
				MessageDialog.openInformation(shell, "Info", "Uspjesno je izvrsena izmjena.");
				
				
				
			}
		});
		button_3.setText("Izmjeni");
		button_3.setImage(SWTResourceManager.getImage(KlijentiFirmeIzmjenaForm.class, "/images/1398203169_change_user.png"));
		button_3.setBounds(502, 35, 102, 50);
		
		text_3 = new Text(group_1, SWT.BORDER);
		text_3.setBounds(118, 83, 90, 21);
		
		Label lblAdresa = new Label(group_1, SWT.NONE);
		lblAdresa.setText("Adresa:");
		lblAdresa.setBounds(25, 89, 55, 15);
		
		text_4 = new Text(group_1, SWT.BORDER);
		text_4.setBounds(316, 83, 90, 21);
		
		Label lblFax = new Label(group_1, SWT.NONE);
		lblFax.setText("Fax:");
		lblFax.setBounds(234, 86, 82, 15);
		
		Button button_1 = new Button(this, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
				
ControlDecoration text1Error = new ControlDecoration(text_1, SWT.RIGHT | SWT.TOP);
				/*
				if (text_1.getText().length()<3 || text_1.getText()==""){
					text1Error.setDescriptionText("Niste unijeli naziv firme!");
					FieldDecoration text1Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text1Error.setImage(text1Field.getImage());
					text1Error.showHoverText("Niste unijeli naziv firme!");
				}
				
ControlDecoration text2Error = new ControlDecoration(text_2, SWT.RIGHT | SWT.TOP);
				
				if (text_2.getText().length()<3 || text_2.getText()==""){
					text2Error.setDescriptionText("Niste unijeli PDV broj!");
					FieldDecoration text2Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text2Error.setImage(text2Field.getImage());
					text2Error.showHoverText("Niste unijeli PDV broj!");
				}
				
ControlDecoration text3Error = new ControlDecoration(text_3, SWT.RIGHT | SWT.TOP);
				
				if (text_3.getText().length()<3 || text_3.getText()==""){
					text3Error.setDescriptionText("Niste unijeli adresu firme!");
					FieldDecoration text3Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text3Error.setImage(text3Field.getImage());
					text3Error.showHoverText("Niste unijeli adresu firme!");
				}
				
ControlDecoration text5Error = new ControlDecoration(text_5, SWT.RIGHT | SWT.TOP);
				
				if (text_5.getText().length()<3 || text_5.getText()==""){
					text5Error.setDescriptionText("Niste unijeli kontakt telefon!");
					FieldDecoration text5Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text5Error.setImage(text5Field.getImage());
					text5Error.showHoverText("Niste unijeli kontakt telefon!");
				}
				else if (!text_5.getText().matches("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{3}$")){
					text5Error.setDescriptionText("Telefon nije u ispravnom formatu!");
					FieldDecoration text5Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text5Error.setImage(text5Field.getImage());
					text5Error.showHoverText("Telefon nije u ispravnom formatu!");
				}
				
ControlDecoration text6Error = new ControlDecoration(text_6, SWT.RIGHT | SWT.TOP);
				
				if (text_6.getText().length()<3 || text_6.getText()==""){
					text6Error.setDescriptionText("Niste unijeli e-mail!");
					FieldDecoration text6Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text6Error.setImage(text6Field.getImage());
					text6Error.showHoverText("Niste unijeli kontakt e-mail!");
				}
				
				else if (!text_6.getText().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
					text6Error.setDescriptionText("E-mail nije u ispravnom formatu!");
					FieldDecoration text6Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text6Error.setImage(text6Field.getImage());
					text6Error.showHoverText("E-mail nije u ispravnom formatu!");
				}
				
ControlDecoration text4Error = new ControlDecoration(text_4, SWT.RIGHT | SWT.TOP);
				
				if (text_4.getText().length()<3 || text_4.getText()==""){
					text4Error.setDescriptionText("Niste unijeli kontakt fax!");
					FieldDecoration text4Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text4Error.setImage(text4Field.getImage());
					text4Error.showHoverText("Niste unijeli kotakt fax!");
				}
				else if (!text_4.getText().matches("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{3}$")){
					text4Error.setDescriptionText("Fax nije u ispravnom formatu!");
					FieldDecoration text4Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text4Error.setImage(text4Field.getImage());
					text4Error.showHoverText("Fax nije u ispravnom formatu!");
				}*/
				//MessageDialog.openInformation(shell, "Info", "Uspjesno je izvrsena izmjena.");
			}
		});
		button_1.setText("OK");
		button_1.setImage(SWTResourceManager.getImage(KlijentiFirmeIzmjenaForm.class, "/images/1398195801_tick_32.png"));
		button_1.setBounds(385, 357, 116, 42);
		
		Button button_2 = new Button(this, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		button_2.setText("Izlaz");
		button_2.setImage(SWTResourceManager.getImage(KlijentiFirmeIzmjenaForm.class, "/images/1398195841_DeleteRed.png"));
		button_2.setBounds(520, 357, 116, 42);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
