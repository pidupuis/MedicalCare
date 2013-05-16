package ui.loginframe.panels;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import ui.loginframe.FormRow;
import ui.loginframe.LoginFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class PasswordRecoveryPane extends JPanel {
	private static final long serialVersionUID = 1L;

	private ErrorPane errorPane;

	private LoginFrame parent;

	private FormRow<JLabel, JTextField> user;
	private FormRow<JLabel, JTextField> passwd;
	private FormRow<JLabel, JTextField> passwdConf;
	private FormRow<JLabel, JLabel> question;
	private FormRow<JLabel, JTextField> answer;
	
	private Font defaultFont;
	
	/**
	 * Create the panel.
	 */
	public PasswordRecoveryPane(LoginFrame parent) {
		this.parent = parent;
		this.defaultFont = new Font("Helvetica Neue", Font.PLAIN, 13);
		
		setLayout(new MigLayout("hidemode 3, inset 5 5 5 5", "[grow]", "[30px:n,grow][30px:n,grow][30px:n,grow][30px:n,grow][30px:n,grow][grow][grow]"));
		
		//User
		JLabel lblUser = new JLabel("Utilisateur");
		JTextField txtUser = new JTextField();
		user = new FormRow<JLabel, JTextField>(lblUser, txtUser);
		user.setFont(defaultFont);
		add(user, "cell 0 0, grow");
		
		//Password
		JLabel lblPass = new JLabel("Nouveau mot de passe");
		JTextField txtPass = new JTextField();
		passwd = new FormRow<JLabel, JTextField>(lblPass, txtPass);
		passwd.setVisible(false);
		passwd.setFont(defaultFont);
		add(passwd, "cell 0 1, grow");
		
		//Password
		JLabel lblPassConf = new JLabel("Confirmation");
		JTextField txtPassConf = new JTextField();
		passwdConf = new FormRow<JLabel, JTextField>(lblPassConf, txtPassConf);
		passwdConf.setVisible(false);
		passwdConf.setFont(defaultFont);
		add(passwdConf, "cell 0 2, grow");
		
		//Question
		JLabel lblQuestion = new JLabel("Question");
		JLabel lblQuestionText = new JLabel("the question");
		question = new FormRow<JLabel, JLabel>(lblQuestion, lblQuestionText);
		question.setVisible(false);
		question.setFont(defaultFont);
		add(question, "cell 0 3, grow");
		
		//Answer
		JLabel lblAnswer = new JLabel("R\u00E9ponse");
		JTextField txtAnswer = new JTextField();
		answer = new FormRow<JLabel, JTextField>(lblAnswer, txtAnswer); 
		answer.setFont(defaultFont);
		add(answer, "cell 0 4,grow");
		
		//Error panel
		errorPane = new ErrorPane();
		errorPane.setVisible(false);
		this.add(errorPane, "cell 0 5,grow");
		
		
		//Bottom pane
		{
			JPanel submitPane = new JPanel();
			submitPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			submitPane.setBorder(BorderFactory.createEmptyBorder());
			
			JButton btnOk = new JButton("Ok");
			submitPane.add(btnOk);
			
			JButton btnAnnuler = new JButton("Annuler");
			submitPane.add(btnAnnuler);

			add(submitPane, "cell 0 6,alignx right,growy");
		}
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String getLogin() {
		return user.getText();
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String getNewPasswd() {
		return passwd.getText();
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String getNewPasswd2() {
		return passwdConf.getText();
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
		errorPane.setErrorMessage(error);
	}
	
	
	/**
	 * 
	 * @param error
	 */
	public void displaySuccess(String success) {
		parent.changeToSuccess(success);
	}
	
	
	/**
	 * 
	 * @param question
	 */
	public void displayQuestion(String question) {
		try {
			this.question.setText(question);
		} catch (NoSuchMethodException e) {	}
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
