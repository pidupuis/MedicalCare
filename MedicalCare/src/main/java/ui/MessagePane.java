package ui;

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

/**
 * Panel managing messages
 */
public class MessagePane extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblMessage;
	private Color myColor, myColorTransp;
	private ImageIcon myIcon;
	
	/**
	 * Constructs an message panel with a centered label with icon
	 */
	public MessagePane() {
		setLayout(new FlowLayout());
		lblMessage = new JLabel("Message panel");
		lblMessage.setOpaque(true);
		
		lblMessage.setBackground(null);
		lblMessage.setBorder(null);
		
		try {
			lblMessage.setIcon(null);
		} catch (Exception e) {	}
		
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		
		add(lblMessage);
		
		setBorder(BorderFactory.createEmptyBorder());
	}
	
	/**
	 * Changes the displayed message
	 * @param message the message to display
	 */
	private void setMessage(String message) {
		lblMessage.setText("<html><body><p>"+message+"</p></body></html>");
	}
	
	private void changeLabelType(Color myColor, String myIconName) {
		this.myColor = myColor;
		this.myColorTransp = new Color(myColor.getRed(), myColor.getGreen(), myColor.getBlue(), 40);
		this.myIcon = new ImageIcon(getClass().getResource(myIconName));
		
		lblMessage.setBackground(this.myColorTransp);
		lblMessage.setBorder(
				new CompoundBorder(
					new LineBorder(this.myColor, 1),
					new EmptyBorder(5, 10, 5, 10)
				)
			);
		
		try {
			lblMessage.setIcon(this.myIcon);
		} catch (Exception e) {	}
		
	}
	
	public void setErrorMessage(String message) {
		changeLabelType(new Color(255, 0, 0, 100), "/icon/error.png");
		setMessage(message);
	}
	
	public void setWarningMessage(String message) {
		changeLabelType(new Color(255, 127, 0, 100), "/icon/warning.png");
		setMessage(message);
	}
	
	public void setInfoMessage(String message) {
		changeLabelType(new Color(0, 0, 255, 100), "/icon/info.png");
		setMessage(message);
	}
	
	public void setSuccessMessage(String message) {
		changeLabelType(new Color(0, 255, 0, 100), "/icon/success.png");
		setMessage(message);
	}

	/**
	 * Return the panel color
	 * @return Color
	 */
	public Color getMyColor() {
		return myColor;
	}

	/**
	 * Return the icon
	 * @return ImageIcon
	 */
	public ImageIcon getMyIcon() {
		return myIcon;
	}
	

}
