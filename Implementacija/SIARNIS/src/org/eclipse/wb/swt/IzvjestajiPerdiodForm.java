package org.eclipse.wb.swt;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class IzvjestajiPerdiodForm {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			IzvjestajiPerdiodForm window = new IzvjestajiPerdiodForm();
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
		shell.setImage(SWTResourceManager.getImage("src/1396674755_519958-021_Document_Text.png"));
		shell.setSize(408, 490);
		shell.setText("Izvje\u0161taji periodi\u010Dni");
		
		TabFolder tabFolder = new TabFolder(shell, SWT.NONE);
		tabFolder.setBounds(10, 10, 375, 432);
		
		TabItem tbtmGodinji = new TabItem(tabFolder, SWT.NONE);
		tbtmGodinji.setText("Godi\u0161nji");
		
		Group group = new Group(tabFolder, SWT.NONE);
		tbtmGodinji.setControl(group);
		
		Group group_2 = new Group(group, SWT.NONE);
		group_2.setText("Rezultat izvje\u0161taja");
		group_2.setBounds(10, 74, 355, 285);
		
		Label label_1 = new Label(group_2, SWT.NONE);
		label_1.setText("Ukupni promet:");
		label_1.setBounds(10, 30, 92, 15);
		
		final Label label_2 = new Label(group_2, SWT.NONE);
		label_2.setBounds(116, 30, 55, 15);
		
		final List list = new List(group_2, SWT.BORDER);
		list.setItems(new String[] {});
		list.setBounds(10, 71, 335, 204);
		
		Label label_3 = new Label(group_2, SWT.NONE);
		label_3.setText("Izlazne fakture:");
		label_3.setBounds(10, 50, 92, 15);
		
		Button button_2 = new Button(group, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				list.removeAll();
				list.add("Mercator, 19.03.2014, 700KM");
				list.add("Interex, 20.01.2014, 800KM");
				list.add("Robot, 28.01.2014, 900KM");
				label_2.setText("2400");				
				Shell shell = new Shell ();
				MessageDialog.openInformation(shell, "Generisanje izvještaja", "Uspješno je kreiran godišnji izvještaj.");
				
			}
		});
		button_2.setText("Ok");
		button_2.setImage(SWTResourceManager.getImage("src/1398195801_tick_32.png"));
		button_2.setBounds(119, 365, 117, 38);
		
		Button button_3 = new Button(group, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		button_3.setText("Izlaz");
		button_3.setImage(SWTResourceManager.getImage("src/1398195841_DeleteRed.png"));
		button_3.setBounds(248, 365, 117, 38);
		
		Spinner spinner = new Spinner(group, SWT.BORDER);
		spinner.setMaximum(5000);
		spinner.setMinimum(1);
		spinner.setSelection(2014);
		spinner.setBounds(125, 28, 70, 22);
		
		Label lblIzaberiteGodinu = new Label(group, SWT.NONE);
		lblIzaberiteGodinu.setBounds(23, 31, 96, 15);
		lblIzaberiteGodinu.setText("Izaberite godinu:");
		
		TabItem tbtmMjeseni = new TabItem(tabFolder, SWT.NONE);
		tbtmMjeseni.setText("Mjese\u010Dni");
		
		Group group_1 = new Group(tabFolder, SWT.NONE);
		tbtmMjeseni.setControl(group_1);
		
		Group group_3 = new Group(group_1, SWT.NONE);
		group_3.setText("Rezultat izvje\u0161taja");
		group_3.setBounds(10, 74, 355, 285);
		
		Label label = new Label(group_3, SWT.NONE);
		label.setText("Ukupni promet:");
		label.setBounds(10, 30, 92, 15);
		
		final Label label_4 = new Label(group_3, SWT.NONE);
		label_4.setBounds(116, 30, 55, 15);
		
		final List list_1 = new List(group_3, SWT.BORDER);
		list_1.setItems(new String[] {});
		list_1.setBounds(10, 71, 335, 204);
		
		Label label_5 = new Label(group_3, SWT.NONE);
		label_5.setText("Izlazne fakture:");
		label_5.setBounds(10, 50, 92, 15);
		
		Button button = new Button(group_1, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				list_1.removeAll();
				list_1.add("Mercator, 19.03.2014, 700KM");
				list_1.add("Interex, 19.03.2014, 800KM");
				list_1.add("Bingo, 19.03.2014, 900KM");
				list_1.add("Škafa, 19.03.2014, 1000KM");
				label_4.setText("3400");
				Shell shell = new Shell ();
				MessageDialog.openInformation(shell, "Generisanje izvještaja", "Uspješno je kreiran mjesecni izvještaj.");
		
			}
		});
		button.setText("Ok");
		button.setImage(SWTResourceManager.getImage("src/1398195801_tick_32.png"));
		button.setBounds(119, 365, 117, 38);
		
		Button button_1 = new Button(group_1, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		button_1.setText("Izlaz");
		button_1.setImage(SWTResourceManager.getImage("src/1398195841_DeleteRed.png"));
		button_1.setBounds(248, 365, 117, 38);
		
		Spinner spinner_1 = new Spinner(group_1, SWT.BORDER);
		spinner_1.setMaximum(5000);
		spinner_1.setMinimum(1);
		spinner_1.setSelection(3);
		spinner_1.setBounds(125, 28, 70, 22);
		
		Label lblIzaberiteMjesec = new Label(group_1, SWT.NONE);
		lblIzaberiteMjesec.setText("Izaberite mjesec:");
		lblIzaberiteMjesec.setBounds(23, 31, 96, 15);

	}

}
