package ui.loginframe.panels;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ui.loginframe.LoginFrame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

/**
 * Panel managing success messages
 */
public class SuccessPane extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblSuccess;
	private LoginFrame parent;
	
	/**
	 * Create the panel.
	 */
	public SuccessPane(LoginFrame parent) {
		setLayout(new FlowLayout());
		
		this.parent = parent;
		lblSuccess = new JLabel("Success Panel");
		
		lblSuccess.setOpaque(true);
		lblSuccess.setBackground(new Color(0, 255, 0, 40));
		lblSuccess.setBorder(
				new CompoundBorder(
					new LineBorder(new Color(0, 255, 0, 100), 1),
					new EmptyBorder(5, 10, 5, 10)
				)
			);
		
		try {
			lblSuccess.setIcon(new ImageIcon(getClass().getResource("/icon/success.png")));
		} catch (Exception e) {	}
		
		lblSuccess.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		
		add(lblSuccess);
		setBorder(BorderFactory.createEmptyBorder());
	}
	
	/**
	 * Changes the displayed success message
	 * @param message the message to display
	 */
	public void setSuccessMessage(String message) {
		lblSuccess.setText(message);
	}
}
