package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class IzmjenaFirmeForm {

	protected Shell shlIzmjenaFirme;
	private Text text;
	private Table table;
	private Text text_1;
	private Text text_2;
	private Text text_5;
	private Text text_6;
	private Text text_3;
	private Text text_4;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			IzmjenaFirmeForm window = new IzmjenaFirmeForm();
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
		shlIzmjenaFirme.open();
		shlIzmjenaFirme.layout();
		while (!shlIzmjenaFirme.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlIzmjenaFirme = new Shell();
		shlIzmjenaFirme.setImage(SWTResourceManager.getImage("src/1396674421_Streamline-61.png"));
		shlIzmjenaFirme.setSize(656, 447);
		shlIzmjenaFirme.setText("Izmjena firme");
		
		Group group = new Group(shlIzmjenaFirme, SWT.NONE);
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
		button.setImage(SWTResourceManager.getImage("src/1398199827_search_magnifying_glass_find.png"));
		button.setBounds(427, 62, 116, 35);
		
		table = new Table(shlIzmjenaFirme, SWT.BORDER | SWT.FULL_SELECTION);
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
		
		Group group_1 = new Group(shlIzmjenaFirme, SWT.NONE);
		group_1.setText("Izmjena atributa");
		group_1.setBounds(10, 228, 626, 115);
		
		Label lblNazivFirme = new Label(group_1, SWT.NONE);
		lblNazivFirme.setText("Naziv firme:");
		lblNazivFirme.setBounds(25, 35, 55, 15);
		
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
				MessageDialog.openInformation(shell, "Info", "Uspjesno je izvrsena izmjena.");
			}
		});
		button_3.setText("Izmjeni");
		button_3.setImage(SWTResourceManager.getImage("src/1398203169_change_user.png"));
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
		
		Button button_1 = new Button(shlIzmjenaFirme, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = new Shell();
				MessageDialog.openInformation(shell, "Info", "Uspjesno je izvrsena izmjena.");
			}
		});
		button_1.setText("OK");
		button_1.setImage(SWTResourceManager.getImage("src/1398195801_tick_32.png"));
		button_1.setBounds(385, 357, 116, 42);
		
		Button button_2 = new Button(shlIzmjenaFirme, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlIzmjenaFirme.close();
			}
		});
		button_2.setText("Izlaz");
		button_2.setImage(SWTResourceManager.getImage("src/1398195841_DeleteRed.png"));
		button_2.setBounds(520, 357, 116, 42);

	}

}
