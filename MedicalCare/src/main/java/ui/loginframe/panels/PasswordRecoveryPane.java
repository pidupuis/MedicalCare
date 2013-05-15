package ui.loginframe.panels;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.loginframe.FormField;
import ui.loginframe.LoginFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;

public class PasswordRecoveryPane extends JPanel {

	/** */
	private static final long serialVersionUID = 1L;

	private JTextField txtLogin;
	
	private JTextField newPasswd;
	private JTextField newPasswd2;
	
	private JLabel question;
	private JTextField answer;
	
	private JLabel lblError;


	private LoginFrame loginFrame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	
	/**
	 * Create the panel.
	 */
	public PasswordRecoveryPane(LoginFrame loginFrame) {
		this.loginFrame = loginFrame;
		setLayout(new MigLayout("", "[150px][grow]", "[][grow][][grow][][grow][][grow][][grow][]"));
		
		
		//FormField user = new FormField(label, field);
		JLabel lblNewLabel = new JLabel("Utilisateur");
		add(lblNewLabel, "cell 0 0,alignx left");
		
		textField = new JTextField();
		add(textField, "cell 1 0,growx");
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nouveau mot de passe");
		add(lblNewLabel_1, "cell 0 2,alignx left");
		lblNewLabel_1.setVisible(false);
		
		textField_1 = new JTextField();
		add(textField_1, "cell 1 2,growx");
		textField_1.setColumns(10);
		textField_1.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("Confirmation");
		add(lblNewLabel_2, "cell 0 4,alignx left");
		lblNewLabel_2.setVisible(false);
		
		textField_2 = new JTextField();
		add(textField_2, "cell 1 4,growx");
		textField_2.setColumns(10);
		textField_2.setVisible(false);
		
		JLabel lblNewLabel_4 = new JLabel("Question");
		add(lblNewLabel_4, "cell 0 6");
		lblNewLabel_4.setVisible(false);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		add(lblNewLabel_5, "cell 1 6");
		lblNewLabel_5.setVisible(false);
		
		JLabel lblNewLabel_3 = new JLabel("R\u00E9ponse");
		add(lblNewLabel_3, "cell 0 8,alignx left");
		lblNewLabel_3.setVisible(false);
		
		textField_3 = new JTextField();
		add(textField_3, "cell 1 8,growx");
		textField_3.setColumns(10);
		textField_3.setVisible(false);
		
		JButton btnOk = new JButton("Ok");
		add(btnOk, "cell 0 10 2 1,alignx right");
	}
	
	
	/**
	 * 
	 * @return
	 */
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
	
	
	/**
	 * 
	 * @param error
	 */
	public void displaySuccess(String success) {
		
	}
	
	
	/**
	 * 
	 * @param question
	 */
	public void displayQuestion(String question) {
		this.question.setText(question);
	}
	
	
	/**
	 * 
	 */
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
