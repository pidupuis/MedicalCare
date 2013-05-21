package ui.loginframe.panels;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import ui.ErrorPane;
import ui.loginframe.FormRow;
import ui.loginframe.LoginFrame;
import ui.loginframe.listeners.ListenersPasswordRecovery;
import ui.loginframe.listeners.ListenersPasswordRecoveryAnnuler;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

/**
 * Panel managing the password recovery
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
	
	private JButton btnOk;

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

			btnOk = new JButton("Ok");
			btnOk.addActionListener(new ListenersPasswordRecovery(this));
			submitPane.add(btnOk);

			JButton btnAnnuler = new JButton("Annuler");
			btnAnnuler.addActionListener(new ListenersPasswordRecoveryAnnuler(parent));
			submitPane.add(btnAnnuler);

			add(submitPane, "cell 0 7,alignx right,growy");
		}
	}


	/**
	 * Gets the login name entered on the first screen
	 * @return
	 */
	public String getLogin() {
		return user.getField().getText();
	}


	/**
	 * Gets the new password entered on the third screen
	 * @return
	 */
	public String getNewPasswd() {
		return passwd.getField().getText();
	}


	/**
	 * Gets the new password confirmation entered on the third screen
	 * @return
	 */
	public String getNewPasswdConf() {
		return passwdConf.getField().getText();
	}


	/**
	 * Gets the answer entered on the second screen
	 * @return the answer
	 */
	public String getAnswer() {
		return answer.getField().getText();
	}


	/**
	 * Displays an error message at the bottom of the panel 
	 * @param error the error message
	 */
	public void displayError(String error) {
		errorPane.setErrorMessage(error);
		errorPane.setVisible(true);
		parent.refreshUI();
	}


	/**
	 * Displays an success message on the new panel
	 * @param error
	 */
	public void displaySuccess(String success) {
		parent.changeToSuccess(success);
		Timer t = new Timer(3000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.changeToLogin();
			}
		});
		t.start();
		t.setRepeats(false);
	}

	/**
	 * Displays the first screen with user name field
	 */
	public void displayUser() {
		errorPane.setVisible(false);
		question.setVisible(false);
		answer.setVisible(false);
		passwd.setVisible(false);
		passwdConf.setVisible(false);
		user.setVisible(true);
		currentScreen = 0;
		clearAll();
		parent.getRootPane().setDefaultButton(btnOk);
		user.getField().requestFocus();
	}
	

	/**
	 * Displays the second screen with the question and answer field
	 * @param question
	 */
	public void displayQuestion(String questionText) {
		this.question.getField().setText(questionText);
		errorPane.setVisible(false);
		user.setVisible(false);
		passwd.setVisible(false);
		passwdConf.setVisible(false);
		question.setVisible(true);
		answer.setVisible(true);
		currentScreen = 1;
		parent.refreshUI();
		answer.getField().requestFocus();
	}


	/**
	 * Displays the third screen with the password and password confirmation field
	 */
	public void displayPassword() {
		errorPane.setVisible(false);
		user.setVisible(false);
		question.setVisible(false);
		answer.setVisible(false);
		passwd.setVisible(true);
		passwdConf.setVisible(true);
		currentScreen = 2;
		parent.refreshUI();
		passwd.getField().requestFocus();
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
	 * Gets the currently displayed screen
	 * @return 0 login, 1 question, 2 password
	 */
	public int getCurrentScreen() {
		return currentScreen;
	}
	
	/**
	 * Requests the focus of the panel and the first field
	 */
	@Override
	public void requestFocus() {
		super.requestFocus();
		user.getField().requestFocus();
	}
}
