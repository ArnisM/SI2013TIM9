import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;


public class LogInForm {

	protected Shell shell;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LogInForm window = new LogInForm();
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
		shell.setImage(SWTResourceManager.getImage("C:\\Users\\ANYO\\Downloads\\logosi.png"));
		shell.setSize(489, 312);
		shell.setText("FACTPRO");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setImage(SWTResourceManager.getImage("C:\\Users\\ANYO\\Downloads\\1396677183_preferences-desktop-cryptography.png"));
		btnNewButton.setBounds(178, 172, 150, 42);
		btnNewButton.setText("Prijava");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(178, 65, 150, 21);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(178, 119, 150, 21);
		
		Label lblUsername = new Label(shell, SWT.NONE);
		lblUsername.setBounds(94, 68, 78, 35);
		lblUsername.setText("USERNAME:");
		
		Label lblPassword = new Label(shell, SWT.NONE);
		lblPassword.setText("PASSWORD:");
		lblPassword.setBounds(94, 122, 78, 35);

	}
}
