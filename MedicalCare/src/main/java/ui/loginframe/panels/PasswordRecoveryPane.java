package ui.loginframe.panels;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.loginframe.FormRow;
import ui.loginframe.LoginFrame;
import ui.loginframe.listeners.ListenersPasswordRecovery;
import ui.loginframe.listeners.ListenersPasswordRecoveryAnnuler;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

/**
 *
 */
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
	
	private int currentScreen;

	/**
	 * Constructs the different part of the password recovery panel
	 */
	public PasswordRecoveryPane(LoginFrame parent) {
		this.parent = parent;
		this.defaultFont = new Font("Helvetica Neue", Font.PLAIN, 13);
		this.currentScreen = 0;

		setLayout(new MigLayout("hidemode 3, inset 5 5 5 5", "[grow]", "[30px:n][grow][grow][grow][grow][grow][::58px,grow][]"));

		JLabel lblTitle = new JLabel("R\u00E9cup\u00E9ration de mot de passe");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(defaultFont.deriveFont(Font.ITALIC));
		add(lblTitle, "cell 0 0,growx,aligny top");
		
		{ //User
			JLabel lblUser = new JLabel("Utilisateur");
			JTextField txtUser = new JTextField();
			user = new FormRow<JLabel, JTextField>(lblUser, txtUser);
			user.setFont(defaultFont);
			add(user, "cell 0 1,growx,aligny top");
		}

		{ //New Password
			JLabel lblPass = new JLabel("Nouveau mot de passe");
			JTextField txtPass = new JTextField();
			passwd = new FormRow<JLabel, JTextField>(lblPass, txtPass);
			passwd.setVisible(false);
			passwd.setFont(defaultFont);
			add(passwd, "cell 0 2,growx,aligny top");
		}

		{ //New Password confirm
			JLabel lblPassConf = new JLabel("Confirmation");
			JTextField txtPassConf = new JTextField();
			passwdConf = new FormRow<JLabel, JTextField>(lblPassConf, txtPassConf);
			passwdConf.setVisible(false);
			passwdConf.setFont(defaultFont);
			add(passwdConf, "cell 0 3,growx,aligny top");
		}


		{ //Question
			JLabel lblQuestion = new JLabel("Question");
			JLabel lblQuestionText = new JLabel("...");
			question = new FormRow<JLabel, JLabel>(lblQuestion, lblQuestionText);
			question.setVisible(false);
			question.setFont(defaultFont);
			add(question, "cell 0 4,growx,aligny top");
		}

		{ //Answer
			JLabel lblAnswer = new JLabel("R\u00E9ponse");
			JTextField txtAnswer = new JTextField();
			answer = new FormRow<JLabel, JTextField>(lblAnswer, txtAnswer); 
			answer.setVisible(false);
			answer.setFont(defaultFont);
			add(answer, "cell 0 5,growx,aligny top");
		}

		{ //Error panel
			errorPane = new ErrorPane();
			errorPane.setVisible(false);
			this.add(errorPane, "cell 0 6,grow");
		}

		{ //Bottom pane
			JPanel submitPane = new JPanel();
			submitPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			submitPane.setBorder(BorderFactory.createEmptyBorder());

			JButton btnOk = new JButton("Ok");
			parent.getRootPane().setDefaultButton(btnOk);
			btnOk.addActionListener(new ListenersPasswordRecovery(this));
			submitPane.add(btnOk);

			JButton btnAnnuler = new JButton("Annuler");
			btnAnnuler.addActionListener(new ListenersPasswordRecoveryAnnuler(parent));
			submitPane.add(btnAnnuler);

			add(submitPane, "cell 0 7,alignx right,growy");
		}
		
		user.getField().requestFocus();
	}


	/**
	 * 
	 * @return
	 */
	public String getLogin() {
		return user.getField().getText();
	}


	/**
	 * 
	 * @return
	 */
	public String getNewPasswd() {
		return passwd.getField().getText();
	}


	/**
	 * 
	 * @return
	 */
	public String getNewPasswdConf() {
		return passwdConf.getField().getText();
	}


	/**
	 * 
	 * @return
	 */
	public String getAnswer() {
		return answer.getField().getText();
	}


	/**
	 * 
	 * @param error
	 */
	public void displayError(String error) {
		errorPane.setErrorMessage(error);
		errorPane.setVisible(true);
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
	 */
	public void displayUser() {
		errorPane.setVisible(false);
		question.setVisible(false);
		answer.setVisible(false);
		passwd.setVisible(false);
		passwd.setVisible(false);
		user.setVisible(true);
		currentScreen = 0;
		clearAll();
	}
	

	/**
	 * 
	 * @param question
	 */
	public void displayQuestion(String questionText) {
		this.question.getField().setText(questionText);
		errorPane.setVisible(false);
		user.setVisible(false);
		passwd.setVisible(false);
		passwd.setVisible(false);
		question.setVisible(true);
		answer.setVisible(true);
		currentScreen = 1;
	}


	/**
	 * 
	 */
	public void displayPassword() {
		errorPane.setVisible(false);
		user.setVisible(false);
		question.setVisible(false);
		answer.setVisible(false);
		passwd.setVisible(true);
		passwdConf.setVisible(true);
		currentScreen = 2;
	}
	
	/**
	 * Clears all existent error message
	 */
	public void clearError() {
		/*user.setError(false);
		passwd.setError(false);*/

		errorPane.setErrorMessage("");
		errorPane.setVisible(false);
		
		parent.refreshUI();
	}
	
	/**
	 * Clears all form fields
	 */
	public void clearFields() {
		user.getField().setText("");
		passwd.getField().setText("");
		passwdConf.getField().setText("");
		question.getField().setText("");
		answer.getField().setText("");
	}
	
	/**
	 * Clears all existent error message, clears content of form fields and goes back to the first screen
	 */
	public void clearAll() {
		clearFields();
		clearError();
	}


	/**
	 * 
	 * @return 0 login, 1 question, 2 password
	 */
	public int getCurrentScreen() {
		return currentScreen;
	}
}
