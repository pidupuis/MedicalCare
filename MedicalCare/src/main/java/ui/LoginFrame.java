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
import javax.swing.JPasswordField;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {

		String[] roles = {"Médecin", "Assistant de recherche clinique", "Data Manager"};
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[150px:n,grow][grow][]", "[30px:n][][][][][][grow]"));
		
		JLabel lblMedicalCareConnect = new JLabel("Medical Care Connect");
		lblMedicalCareConnect.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
		lblMedicalCareConnect.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		lblMedicalCareConnect.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblMedicalCareConnect, "cell 0 0 2 1,growx,aligny center");
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 0 1 2 1,grow");
		panel.setLayout(new MigLayout("", "[][grow][]", "[][][][][][][][]"));
		
		JLabel lblUtilisateur = new JLabel("Utilisateur");
		panel.add(lblUtilisateur, "cell 0 0");
		lblUtilisateur.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		
		textField = new JTextField();
		panel.add(textField, "cell 1 0,growx");
		textField.setColumns(10);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		panel.add(lblMotDePasse, "cell 0 1");
		lblMotDePasse.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		
		passwordField = new JPasswordField();
		panel.add(passwordField, "cell 1 1,growx");
		
		JLabel lblRle = new JLabel("R\u00F4le");
		panel.add(lblRle, "cell 0 2");
		lblRle.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		JComboBox comboBox = new JComboBox(roles);
		panel.add(comboBox, "cell 1 2,growx");
		
		JLabel lblNewLabel = new JLabel("Error Label");
		panel.add(lblNewLabel, "cell 0 3 2 1,growx,aligny center");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		
		JButton btnNewButton = new JButton("Connexion");
		panel.add(btnNewButton, "cell 1 4,alignx right");
		btnNewButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		
		JLabel lblNewLabel_1 = new JLabel("?");
		panel.add(lblNewLabel_1, "cell 2 4");
		
		
		
		//this.pack();
	}
	
	public String getLogin() {
		return "";
	}

	public String getPassword() {
		return "";
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
