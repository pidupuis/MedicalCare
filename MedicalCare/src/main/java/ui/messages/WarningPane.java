package ui.messages;

import java.awt.Color;

public class WarningPane extends MessagePane {

	private static final long serialVersionUID = 1L;
	
	public WarningPane() {
		super("Warning Panel", new Color(255, 127, 0, 100), "/icon/warning.png");
	}

}
