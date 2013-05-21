package ui.messages;

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
public abstract class MessagePane extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblMessage;
	private Color myColor, myColorTransp;
	private ImageIcon myIcon;
	
	/**
	 * Constructs an message panel with a centered label with icon
	 */
	public MessagePane(String messageType, Color myColor, String myIconName) {
		this.myColor = myColor;
		this.myColorTransp = new Color(myColor.getRed(), myColor.getGreen(), myColor.getBlue(), 40);
		this.myIcon = new ImageIcon(getClass().getResource(myIconName));
		
		setLayout(new FlowLayout());
		lblMessage = new JLabel(messageType);
		
		lblMessage.setOpaque(true);
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
		
		this.add(lblMessage);
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		
		add(lblMessage);
		
		setBorder(BorderFactory.createEmptyBorder());
	}
	
	/**
	 * Changes the displayed message
	 * @param message the message to display
	 */
	public void setMessage(String message) {
		lblMessage.setText(message);
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
