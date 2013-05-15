package ui.loginframe.panels;

import javax.swing.JPanel;
import javax.swing.JLabel;

import ui.loginframe.LoginFrame;

public class SuccessPane extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblSuccess;
	private LoginFrame loginFrame;
	
	/**
	 * Create the panel.
	 */
	public SuccessPane(LoginFrame loginFrame) {
		this.loginFrame = loginFrame;
		lblSuccess = new JLabel("Success");
		add(lblSuccess);
	}
	
	public void setSuccessMessage(String message) {
		lblSuccess.setText(message);
	}

}
