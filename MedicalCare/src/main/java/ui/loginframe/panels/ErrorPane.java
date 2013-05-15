package ui.loginframe.panels;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;

public class ErrorPane extends JPanel {

	/**  */
	private static final long serialVersionUID = 1L;
	private JLabel lblError;
	
	/**
	 * Create the panel.
	 */
	public ErrorPane() {
		setLayout(new FlowLayout());
		lblError = new JLabel("Error Panel");
		
		lblError.setOpaque(true);
		lblError.setBackground(new Color(255, 0, 0, 40));
		lblError.setBorder(
				new CompoundBorder(
					new LineBorder(new Color(255, 0, 0, 100), 1),
					new EmptyBorder(5, 10, 5, 10)
				)
			);
		
		try {
			lblError.setIcon(new ImageIcon(getClass().getResource("/icon/warning.png")));
		} catch (Exception e) {	}
		
		this.add(lblError);
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		
		add(lblError);
		
		setBorder(BorderFactory.createEmptyBorder());
	}
	
	public void setErrorMessage(String message) {
		lblError.setText(message);
	}

}
