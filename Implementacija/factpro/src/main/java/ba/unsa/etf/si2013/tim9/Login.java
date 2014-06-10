package ba.unsa.etf.si2013.tim9;

import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

import ba.unsa.etf.si2013.tim9.Fakture.FaktureStavkeDodavanjeForm;
import ba.unsa.etf.si2013.tim9.Korisnici.Korisnik;

import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Login {

	protected Shell shlLogin;
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
		shlLogin.open();
		shlLogin.layout();
		while (!shlLogin.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlLogin = new Shell();
		shlLogin.setSize(360, 251);
		shlLogin.setText("LOGIN");
		
		Label lblUsername = new Label(shlLogin, SWT.NONE);
		lblUsername.setBounds(53, 79, 55, 15);
		lblUsername.setText("Username:");
		
		Label lblPassword = new Label(shlLogin, SWT.NONE);
		lblPassword.setBounds(53, 116, 61, 15);
		lblPassword.setText("Password:");
		
		text = new Text(shlLogin, SWT.BORDER);
		text.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent arg0) {
				
				
				
				
				
			}
		});
		text.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
	
				}
				
			
		});
		text.setBounds(136, 76, 154, 21);
		
		text_1 = new Text(shlLogin, SWT.BORDER | SWT.PASSWORD);
		text_1.setBounds(136, 113, 154, 21);
		
		Button btnLogin = new Button(shlLogin, SWT.NONE);
		btnLogin.setImage(SWTResourceManager.getImage(Login.class, "/images/1402423546_preferences-desktop-cryptography.png"));
		
		btnLogin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			String username=text.getText();
			String password=text_1.getText();
				Korisnik k = new Korisnik();
				k.setUsername(username);
				try{
					if(k.daLiPostoji()){
						
						Session session = HibernateUtil.getSessionFactory().openSession();
						Transaction t = session.beginTransaction();
						
						 
						Query q = session.createQuery("from Korisnik where username=:ime and deleted=:deleted");
						 q.setString("ime", username);
						
						 q.setInteger("deleted", 0);
						 List<Korisnik> c = q.list();
						 t.commit();
						if(c.get(0).getPassword().equals(password)){
							if(c.get(0).getPozicija().equals("operater")){
								GlavnaForm2 gl2 =new GlavnaForm2();
								shlLogin.dispose();
								gl2.open();
							}
							if(c.get(0).getPozicija().equals("rukovodilac")){
								GlavnaForm gl2 =new GlavnaForm();
								shlLogin.dispose();
								gl2.open();
							}
							
						}
						else if(!c.get(0).getPassword().equals(password)){
							ControlDecoration textimeError = new ControlDecoration(text_1, SWT.RIGHT | SWT.TOP);
							FieldDecoration ImeField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
							textimeError.setDescriptionText("Password nije validan!");
							textimeError.setImage(ImeField.getImage());
							textimeError.showHoverText("Password nije validan!");
						}
					}
					else if(!k.daLiPostoji()){
						
						ControlDecoration textimeError = new ControlDecoration(text, SWT.RIGHT | SWT.TOP);
						FieldDecoration ImeField = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
						textimeError.setDescriptionText("Username ne postoji u vazi!");
						textimeError.setImage(ImeField.getImage());
						textimeError.showHoverText("Username ne postoji u bazi!");
						
					}
					
					else {
						if(text.getText().equals("operater") && text_1.getText().equals("operater")){
						GlavnaForm2 gl2 =new GlavnaForm2();
						shlLogin.dispose();
						gl2.open();
					}
					
					if(text.getText().equals("sef") && text_1.getText().equals("sef")){
						GlavnaForm gl2 =new GlavnaForm();
						shlLogin.dispose();
						gl2.open();
					}
					
					else{	Shell shell = new Shell();
						MessageDialog.openInformation(shell, "Login", "Podaci za šefa: password-sef username-sef. Podaci za operatera: password-operater username-operater.");
					    
					}
					
					
					}
				}catch(Exception e2){}
				
				
			}
		});
		btnLogin.setBounds(136, 151, 154, 52);
		btnLogin.setText("Login");

	}
}
