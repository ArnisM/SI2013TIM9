package ba.unsa.etf.si2013.tim9;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Login {

	protected Shell shell;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Login window = new Login();
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
		shell.setSize(360, 300);
		shell.setText("SWT Application");
		
		Label lblUsername = new Label(shell, SWT.NONE);
		lblUsername.setBounds(53, 79, 55, 15);
		lblUsername.setText("Username:");
		
		Label lblPassword = new Label(shell, SWT.NONE);
		lblPassword.setBounds(53, 116, 61, 15);
		lblPassword.setText("Password:");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(136, 76, 154, 21);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(136, 113, 154, 21);
		
		Button btnLogin = new Button(shell, SWT.NONE);
		btnLogin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			
			
				if(text.getText().equals("operater") && text_1.getText().equals("operater")){
					GlavnaForm2 gl2 =new GlavnaForm2();
					shell.dispose();
					gl2.open();
				}
				
				if(text.getText().equals("sef") && text_1.getText().equals("sef")){
					GlavnaForm gl2 =new GlavnaForm();
					shell.dispose();
					gl2.open();
				}
				
				else{	Shell shell = new Shell();
					MessageDialog.openInformation(shell, "Login", "Podaci za šefa: password-sef username-sef. Podaci za operatera: password-operater username-operater.");
				    
				}
				
				
			}
		});
		btnLogin.setBounds(136, 169, 154, 38);
		btnLogin.setText("Login");

	}
}
