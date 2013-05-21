package ui.messages;

import java.awt.Color;

/**
 * Panel managing success messages
 */
public class SuccessPane extends MessagePane {

	private static final long serialVersionUID = 1L;
	
	public SuccessPane() {
		super("Success Panel", new Color(0, 255, 0, 100), "/icon/success.png");
	}

}