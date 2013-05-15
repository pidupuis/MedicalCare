package ui.loginframe.panels;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PasswordRecoveryPane extends JPanel {

	/** */
	private static final long serialVersionUID = 1L;

	private JTextField txtLogin;
	
	private JTextField newPasswd;
	private JTextField newPasswd2;
	
	private JLabel question;
	private JTextField answer;
	
	private JLabel lblError;
	
	/**
	 * Create the panel.
	 */
	public PasswordRecoveryPane() {

	}
	
	public String getLogin() {
		return txtLogin.getText();
	}
	
	/**
	 * 
	 * @return
	 */
	public String getNewPasswd() {
		return newPasswd.getText();
	}
	
	/**
	 * 
	 * @return
	 */
	public String getNewPasswd2() {
		return newPasswd2.getText();
	}
	
	/**
	 * 
	 * @return
	 */
	public String getAnswer() {
		return answer.getText();
	}
	
	/**
	 * 
	 * @param error
	 */
	public void displayError(String error) {
		lblError.setText(error);
	}
	
	
	public void displayQuestion(String question) {
		this.question.setText(question);
	}
	
	public void displayPassword() {
		
	}
	
	/**
	 * 
	 * @return 0 login, 1 question, 2 password
	 */
	public int getScreen() {
		return 0;
	}
}
