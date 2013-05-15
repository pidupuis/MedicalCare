package ui.loginframe.panels;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ui.listenerconnexion.Listenersconnexion;
import ui.listenerconnexion.Listenersrecovery;

import net.miginfocom.swing.MigLayout;

public class LoginPane extends JPanel {

	private JTextField txtLogin;
	private JPasswordField passwordField;
	private JComboBox comboBox;

	/**
	 * Create the panel.
	 */
	public LoginPane() {
		String[] roles = {"Médecin", "Assistant de recherche clinique", "Data Manager"};
		
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setLayout(new MigLayout("inset 5", "[120px:n][grow][]", "[grow][][grow][][grow][][grow][][grow][][grow]"));
		
		JLabel lblUtilisateur = new JLabel("Utilisateur");
		this.add(lblUtilisateur, "cell 0 1");
		lblUtilisateur.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		
		txtLogin = new JTextField();
		this.add(txtLogin, "cell 1 1,growx");
		txtLogin.setColumns(10);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		this.add(lblMotDePasse, "cell 0 3");
		lblMotDePasse.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		
		passwordField = new JPasswordField();
		this.add(passwordField, "cell 1 3,growx");
		
		JLabel lblRle = new JLabel("R\u00F4le");
		this.add(lblRle, "cell 0 5");
		lblRle.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		comboBox = new JComboBox(roles);
		this.add(comboBox, "cell 1 5,growx");
		
		JLabel lblError = new JLabel("Error Label");
		this.add(lblError, "cell 0 7 2 1,growx,aligny center");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		
		JPanel submitPane = new JPanel();
		this.add(submitPane, "cell 0 9 3 1,alignx right,aligny center");
		submitPane.setLayout(new BoxLayout(submitPane, BoxLayout.X_AXIS));
		submitPane.setBorder(BorderFactory.createEmptyBorder());
		
		JButton btnConnexion = new JButton("Connexion");
		submitPane.add(btnConnexion);
		btnConnexion.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		
		JButton btnRecovery = new JButton("?");
		submitPane.add(btnRecovery);
		btnRecovery.addActionListener( new Listenersrecovery(this));
		btnConnexion.addActionListener(new Listenersconnexion(this));
	}
	

	public String getLogin() {
		return txtLogin.getText();
	}

	public String getPassword() {
		return new String(passwordField.getPassword());
	}
	
	public String getRole() {
		return (String)comboBox.getSelectedItem();
	}
	

	/**
	 * 
	 * @param error
	 */
	public void displayError(String error) {
		
	}
	
	

}
