package ui.loginframe.panels;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Timer;

import ui.form.FormRow;
import ui.loginframe.LoginFrame;
import ui.loginframe.listeners.ListenersButtonConnexion;
import ui.loginframe.listeners.ListenersButtonQuit;
import ui.loginframe.listeners.ListenersButtonRecovery;
import ui.MessagePane;

import main.Main;
import main.exception.UnknownUsernameException;
import main.exception.WrongPasswordException;
import main.exception.WrongRoleException;
import net.miginfocom.swing.MigLayout;

/**
 * Panel containing the login form screen
 */
public class LoginPane extends JPanel {
	private static final long serialVersionUID = 1L;

	private LoginFrame parent;

	private FormRow<JLabel, JTextField>  user;
	private FormRow<JLabel, JPasswordField> passwd;
	private FormRow<JLabel, JComboBox<String>> role;
	private MessagePane errorPane;

	private Font defaultFont;
	private JButton btnConnexion;
	
	/**
	 * Constructs the login form with user, password, role and action buttons
	 */
	public LoginPane(LoginFrame parent) {
		this.parent = parent;
		this.defaultFont = new Font("Helvetica Neue", Font.PLAIN, 13);

		setBorder(BorderFactory.createEmptyBorder());
		MigLayout layout = new MigLayout("hidemode 3, inset 5 5 5 5", "[grow]", "[30px:n,grow][30px:n,grow][30px:n,grow][::58px,grow][]");
		setLayout(layout);

		{ //User
			JLabel lblUtilisateur = new JLabel("Utilisateur");
			lblUtilisateur.setFont(defaultFont);
			JTextField txtFUtilisateur = new JTextField();
			txtFUtilisateur.setFont(defaultFont);
			user = new FormRow<JLabel, JTextField>(lblUtilisateur, txtFUtilisateur);
			this.add(user, "cell 0 0,grow");
		}

		{ //Password
			JLabel lblMotDePasse = new JLabel("Mot de passe");
			lblMotDePasse.setFont(defaultFont);
			JPasswordField psswdMotDePasse = new JPasswordField();
			psswdMotDePasse.setFont(defaultFont);
			passwd = new FormRow<JLabel, JPasswordField>(lblMotDePasse, psswdMotDePasse);
			this.add(passwd, "cell 0 1,grow");
		}

		{ //Role
			JLabel lblRole = new JLabel("R\u00F4le");
			lblRole.setFont(defaultFont);
			JComboBox<String> cbRole = new JComboBox(new String[]{"Médecin", "Attaché de recherche clinique", "Data Manager"});
			cbRole.setFont(defaultFont);
			role = new FormRow<JLabel, JComboBox<String>>(lblRole, cbRole);
			this.add(role, "cell 0 2,grow");
		}

		{ //Error pane
			errorPane = new MessagePane();
			errorPane.setVisible(false);
			this.add(errorPane, "cell 0 3,grow");
		}

		{ //Submit pane
			JPanel submitPane = new JPanel();
			submitPane.setLayout(new BoxLayout(submitPane, BoxLayout.X_AXIS));
			submitPane.setBorder(BorderFactory.createEmptyBorder());

			//Connexion Button
			btnConnexion = new JButton("Connexion");
			btnConnexion.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
			btnConnexion.addActionListener(new ListenersButtonConnexion(this));
			submitPane.add(btnConnexion);

			//Annuler Button
			JButton btnQuit = new JButton("Quitter");
			btnQuit.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
			btnQuit.addActionListener(new ListenersButtonQuit());
			submitPane.add(btnQuit);

			//Recovery Button
			JButton btnRecovery = new JButton();
			try {
				btnRecovery.setIcon(new ImageIcon(getClass().getResource("/icon/help.png")));
				btnRecovery.setBorder(BorderFactory.createEmptyBorder());
			} catch (Exception e) {
				btnRecovery.setText("?");
			}
			btnRecovery.addActionListener(new ListenersButtonRecovery(parent));
			submitPane.add(btnRecovery);

			add(submitPane, "cell 0 4,alignx right,aligny center");
		}

		user.getField().requestFocus();
		parent.getRootPane().setDefaultButton(btnConnexion);
	}

	/**
	 * Gets the entered user name in the form
	 * @return
	 */
	public String getUser() {
		return user.getField().getText();
	}


	/**
	 * Gets the entered password in the form
	 * @return
	 */
	public String getPassword() {
		return new String(passwd.getField().getPassword());
	}


	/**
	 * Gets the selected role in the form
	 * @return
	 */
	public String getRole() {
		return (String)role.getField().getSelectedItem();
	}


	/**
	 * Displays an error message in the form
	 * @param ex
	 */
	public void displayError(Exception ex) {
		if(ex instanceof UnknownUsernameException)
			user.setError(ex.getMessage());
		else if(ex instanceof WrongPasswordException)
			passwd.setError(ex.getMessage());
		else if(ex instanceof WrongRoleException)
			role.setError(ex.getMessage());

		if(ex instanceof SQLException && ex.getMessage().contains("E/S"))
			errorPane.setErrorMessage("Erreur: La connexion au serveur a échouée (Veuillez vérifier la connexion internet ou la connexion au serveur).");
		else
			errorPane.setErrorMessage(ex.getMessage());
		
		errorPane.setVisible(true);
		parent.refreshUI();
	}

	/**
	 * Clears all existent error message
	 */
	public void clearError() {
		user.setCorrect();
		passwd.setCorrect();
		role.setCorrect();

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
		role.getField().setSelectedIndex(0);
	}
	
	/**
	 * Clears all existent error message and clear content of form fields
	 */
	public void clearAll() {
		clearFields();
		clearError();

		parent.getRootPane().setDefaultButton(btnConnexion);
		user.getField().requestFocus();
	}

	/**
	 * Changes the parent frame to display a success message
	 * @param success
	 */
	public void displaySuccess(String success) {
		parent.changeToSuccess(success);
		
		Timer t = new Timer(3000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.launchMainWindow();
			}
		});
		t.start();
		t.setRepeats(false);
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
