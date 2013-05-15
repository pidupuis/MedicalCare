package ui.loginframe;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.JPasswordField;

import ui.loginframe.panels.LoginPane;
import ui.loginframe.panels.PasswordRecoveryPane;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	
	private JTextField txtLogin;
	private JPasswordField passwordField;
	private JComboBox comboBox;
	
	private LoginPane loginPane;
	private PasswordRecoveryPane psswdPane;
	

	/**
	 * Create the frame.
	 */
	public LoginFrame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[150px:n,grow]", "[30px:n:100px,grow][grow]"));
		
		JLabel lblMedicalCareConnect = new JLabel("Medical Care Connect");
		lblMedicalCareConnect.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		lblMedicalCareConnect.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblMedicalCareConnect, "cell 0 0,grow");
		
		loginPane =  new LoginPane();
		psswdPane = new PasswordRecoveryPane();
		contentPane.add(loginPane, "cell 0 1,growx,aligny center");
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	
	/**
	 * 
	 * @param error
	 */
	public void displayError(String error) {
		
	}

	/**
	 * 
	 */
	public void resetError() {
		
	}
	
	/**
	 * 
	 */
	public void displaySuccess() {
		
	}
}
