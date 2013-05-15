package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;

import ui.listenerconnexion.Listenersconnexion;
import ui.listenerconnexion.Listenersrecovery;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	
	private JPanel loginPane;
	private JTextField txtLogin;
	private JPasswordField passwordField;
	private JComboBox comboBox;
	

	/**
	 * Create the frame.
	 */
	public LoginFrame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[150px:n,grow][grow][]", "[30px:n][grow]"));
		
		JLabel lblMedicalCareConnect = new JLabel("Medical Care Connect");
		lblMedicalCareConnect.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
		lblMedicalCareConnect.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		lblMedicalCareConnect.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblMedicalCareConnect, "cell 0 0 2 1,growx,aligny center");
		
		/**	 */
		initLoginPane();
		contentPane.add(loginPane, "cell 0 1 2 1,growx,aligny center");
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void initLoginPane() {
		String[] roles = {"Médecin", "Assistant de recherche clinique", "Data Manager"};
		
		loginPane = new JPanel();
		loginPane.setBorder(null);
		loginPane.setLayout(new MigLayout("inset 5", "[120px:n][grow][]", "[grow][][][][][grow][]"));
		
		JLabel lblUtilisateur = new JLabel("Utilisateur");
		loginPane.add(lblUtilisateur, "cell 0 1");
		lblUtilisateur.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		
		txtLogin = new JTextField();
		loginPane.add(txtLogin, "cell 1 1,growx");
		txtLogin.setColumns(10);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		loginPane.add(lblMotDePasse, "cell 0 2");
		lblMotDePasse.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		
		passwordField = new JPasswordField();
		loginPane.add(passwordField, "cell 1 2,growx");
		
		JLabel lblRle = new JLabel("R\u00F4le");
		loginPane.add(lblRle, "cell 0 3");
		lblRle.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		comboBox = new JComboBox(roles);
		loginPane.add(comboBox, "cell 1 3,growx");
		
		JLabel lblError = new JLabel("Error Label");
		loginPane.add(lblError, "cell 0 4 2 1,growx,aligny center");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		
		JButton btnConnexion = new JButton("Connexion");
		loginPane.add(btnConnexion, "cell 1 6,alignx right");
		btnConnexion.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		btnConnexion.addActionListener(new Listenersconnexion(this));
		
		JButton btnRecovery = new JButton("?");
		loginPane.add(btnRecovery, "cell 2 6");
		btnRecovery.addActionListener((ActionListener) new Listenersrecovery(this));
		
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

	public void resetError() {
		
	}
	
	public void displaySuccess() {
		
	}
}
