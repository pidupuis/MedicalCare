package ui.loginframe;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import ui.loginframe.panels.LoginPane;
import ui.loginframe.panels.PasswordRecoveryPane;
import ui.loginframe.panels.SuccessPane;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	
	private JLabel lblTitle;
	
	private LoginPane loginPane;
	private PasswordRecoveryPane psswdPane;
	private SuccessPane successPane;
	

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
		
		lblTitle = new JLabel("Medical Care Connect");
		lblTitle.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitle, "cell 0 0,grow");
		
		loginPane =  new LoginPane(this);
		psswdPane = new PasswordRecoveryPane(this);
		successPane = new SuccessPane(this);
		contentPane.add(loginPane, "cell 0 1,growx,aligny center");
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	/**
	 * 
	 */
	public void changeToPasswordRecovery() {
		
	}
	
	/**
	 * 
	 */
	public void changeToSuccess(String message) {
		successPane.setSuccessMessage(message);
		removeAll();
		add(lblTitle, "cell 0 0,grow");
		add(successPane, "cell 0 1,growx,aligny center");
		refreshUI();
	}
	
	public void refreshUI() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				validate();
				repaint();
			}
		});
	}
	
}
