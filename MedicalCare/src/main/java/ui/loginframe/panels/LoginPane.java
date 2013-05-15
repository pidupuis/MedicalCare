package ui.loginframe.panels;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ui.listenerconnexion.ListenersButtonConnexion;
import ui.listenerconnexion.ListenersButtonRecovery;
import ui.loginframe.LoginFrame;

import net.miginfocom.swing.MigLayout;
import java.awt.Color;

public class LoginPane extends JPanel {
	/** */
	private static final long serialVersionUID = 1L;

	private LoginFrame loginFrame;
	
	private JTextField txtLogin;
	private JPasswordField passwordField;
	private JComboBox<String> cbRole;
	private JLabel lblError;

	/**
	 * Create the panel.
	 */
	public LoginPane(LoginFrame loginFrame) {
		String[] roles = {"Médecin", "Assistant de recherche clinique", "Data Manager"};
		
		this.loginFrame = loginFrame;
		
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setLayout(new MigLayout("inset 5", "[120px:n][grow][]", "[][grow][][grow][][grow][30px:n][grow][]"));
		
		JLabel lblUtilisateur = new JLabel("Utilisateur");
		this.add(lblUtilisateur, "cell 0 0");
		lblUtilisateur.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		
		txtLogin = new JTextField();
		this.add(txtLogin, "cell 1 0,growx");
		txtLogin.setColumns(10);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		this.add(lblMotDePasse, "cell 0 2");
		lblMotDePasse.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		
		passwordField = new JPasswordField();
		this.add(passwordField, "cell 1 2,growx");
		
		JLabel lblRle = new JLabel("R\u00F4le");
		this.add(lblRle, "cell 0 4");
		lblRle.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		cbRole = new JComboBox(roles);
		this.add(cbRole, "cell 1 4,growx");
		
		lblError = new JLabel("Error Label");
		lblError.setOpaque(true);
		lblError.setBackground(new Color(240, 128, 128));
		lblError.setForeground(Color.BLACK);
		this.add(lblError, "cell 0 6 3 1,grow");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		lblError.setVisible(false);
		
		JPanel submitPane = new JPanel();
		this.add(submitPane, "cell 0 8 3 1,alignx right,aligny center");
		submitPane.setLayout(new BoxLayout(submitPane, BoxLayout.X_AXIS));
		submitPane.setBorder(BorderFactory.createEmptyBorder());
		
		JButton btnConnexion = new JButton("Connexion");
		submitPane.add(btnConnexion);
		btnConnexion.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		
		JButton btnRecovery = new JButton("?");
		submitPane.add(btnRecovery);
		btnRecovery.addActionListener( new ListenersButtonRecovery(this));
		btnConnexion.addActionListener(new ListenersButtonConnexion(this));
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
	public String getPassword() {
		return new String(passwordField.getPassword());
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String getRole() {
		return (String)cbRole.getSelectedItem();
	}
	

	/**
	 * 
	 * @param error
	 */
	public void displayError(String error) {
		lblError.setText(error);
		lblError.setVisible(true);
	}
	
	public void resetError() {
		lblError.setText("");
		lblError.setVisible(false);
	}
	
	/**
	 * 
	 * @param error
	 */
	public void displaySuccess(String success) {
		loginFrame.changeToSuccess(success);
	}
	
	
	/**
	 * 
	 */
	public void changeToPasswordRecovery() {
		
	}
}
