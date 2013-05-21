package ui.messages;

import java.awt.Color;

/**
 * Panel managing error messages
 */
public class ErrorPane extends MessagePane {

	private static final long serialVersionUID = 1L;
	
	public ErrorPane() {
		super("Error Panel", new Color(255, 0, 0, 100), "/icon/error.png");
	}

}