package ui.loginframe;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

import ui.loginframe.panels.LoginPane;
import ui.loginframe.panels.PasswordRecoveryPane;
import ui.messages.SuccessPane;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel lblTitle;
	
	private LoginPane loginPane;
	private PasswordRecoveryPane psswdPane;
	private SuccessPane successPane;
	
	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		super();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 327);
		getContentPane().setLayout(new MigLayout("inset 5", "[400px:n,grow]", "[70px][grow]"));
		
		lblTitle = new JLabel("Medical Care Connect");
		lblTitle.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		try {
			lblTitle.setIcon(new ImageIcon(getClass().getResource("/icon/globe.png")));
			lblTitle.setHorizontalTextPosition(SwingConstants.LEFT);
		} catch (Exception e) { }
		getContentPane().add(lblTitle, "cell 0 0,grow");
		
		loginPane =  new LoginPane(this);
		psswdPane = new PasswordRecoveryPane(this);
		successPane = new SuccessPane();
		getContentPane().add(loginPane, "cell 0 1,grow");

		setLocationRelativeTo(null);
		setUndecorated(true);
		getRootPane().setBorder(new LineBorder(new Color(0, 0, 0, 70), 1));
		setResizable(false);
		refreshUI();
		setVisible(true);
	}
	
	/**
	 * Changes the main panel to the password recovery panel
	 */
	public void changeToPasswordRecovery() {
		try {
			remove(loginPane);
			remove(psswdPane);
			remove(successPane);
		} catch (Exception e) { }
		
		psswdPane.displayUser();
		getContentPane().add(psswdPane, "cell 0 1,grow");
		refreshUI();
		psswdPane.requestFocus();
	}
	
	/**
	 * Changes the main panel to the success panel
	 */
	public void changeToSuccess(String message) {
		try {
			remove(loginPane);
			remove(psswdPane);
			remove(successPane);
		} catch (Exception e) { }
		
		successPane.setMessage(message);
		getContentPane().add(successPane, "cell 0 1,grow");
		refreshUI();
	}
	
	/**
	 * Changes the main panel to the login form
	 */
	public void changeToLogin() {
		try {
			remove(loginPane);
			remove(psswdPane);
			remove(successPane);
		} catch (Exception e) { }
		
		loginPane.clearAll();
		getContentPane().add(loginPane, "cell 0 1,grow");
		refreshUI();
		loginPane.requestFocus();
	}
	
	/**
	 * Reloads the panel graphics, repack and replace the window
	 */
	public void refreshUI() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				pack();
				setLocationRelativeTo(null);
				validate();
				repaint();
			}
		});
	}
}
