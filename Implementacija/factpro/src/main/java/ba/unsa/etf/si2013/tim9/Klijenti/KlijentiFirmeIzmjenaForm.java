package ba.unsa.etf.si2013.tim9.Klijenti;

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
import org.eclipse.wb.swt.SWTResourceManager;

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
		
		Combo combo = new Combo(group, SWT.NONE);
		combo.setItems(new String[] {"Naziv", "PDV broj", ""});
		combo.setBounds(112, 35, 142, 23);
		combo.setText("PDV broj");
		
		Label label = new Label(group, SWT.NONE);
		label.setText("Kirterij pretrage:");
		label.setBounds(10, 38, 96, 15);
		
		text = new Text(group, SWT.BORDER);
		text.setBounds(380, 35, 163, 21);
		
		Label label_1 = new Label(group, SWT.NONE);
		label_1.setText("Unesi PDV broj:");
		label_1.setBounds(280, 38, 96, 15);
		
		Button button = new Button(group, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
				MessageDialog.openInformation(shell, "Info", "Uspjesno je izvrsena pretraga, firme su u listi ispod.");
			}
		});
		button.setText("Pretraga");
		button.setImage(SWTResourceManager.getImage(KlijentiFirmeIzmjenaForm.class, "/images/1398199827_search_magnifying_glass_find.png"));
		button.setBounds(427, 62, 116, 35);
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 123, 626, 85);
		
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
				
ControlDecoration text1Error = new ControlDecoration(text_1, SWT.RIGHT | SWT.TOP);
				
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
				
ControlDecoration text6Error = new ControlDecoration(text_6, SWT.RIGHT | SWT.TOP);
				
				if (text_6.getText().length()<3 || text_6.getText()==""){
					text6Error.setDescriptionText("Niste unijeli e-mail!");
					FieldDecoration text6Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text6Error.setImage(text6Field.getImage());
					text6Error.showHoverText("Niste unijeli kontakt e-mail!");
				}
				
ControlDecoration text4Error = new ControlDecoration(text_4, SWT.RIGHT | SWT.TOP);
				
				if (text_4.getText().length()<3 || text_4.getText()==""){
					text4Error.setDescriptionText("Niste unijeli kontakt fax!");
					FieldDecoration text4Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text4Error.setImage(text4Field.getImage());
					text4Error.showHoverText("Niste unijeli kotakt fax!");
				}
				
				
				
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
				
ControlDecoration text6Error = new ControlDecoration(text_6, SWT.RIGHT | SWT.TOP);
				
				if (text_6.getText().length()<3 || text_6.getText()==""){
					text6Error.setDescriptionText("Niste unijeli e-mail!");
					FieldDecoration text6Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text6Error.setImage(text6Field.getImage());
					text6Error.showHoverText("Niste unijeli kontakt e-mail!");
				}
				
ControlDecoration text4Error = new ControlDecoration(text_4, SWT.RIGHT | SWT.TOP);
				
				if (text_4.getText().length()<3 || text_4.getText()==""){
					text4Error.setDescriptionText("Niste unijeli kontakt fax!");
					FieldDecoration text4Field = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
					text4Error.setImage(text4Field.getImage());
					text4Error.showHoverText("Niste unijeli kotakt fax!");
				}
				
				
				MessageDialog.openInformation(shell, "Info", "Uspjesno je izvrsena izmjena.");
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
