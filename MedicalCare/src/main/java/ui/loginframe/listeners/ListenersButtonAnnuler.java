package ui.loginframe.listeners;

import java.awt.event.*;

import main.Main;

import ui.loginframe.panels.LoginPane;

/**
 *
 * @author Julien_Lavigne
 */
public class ListenersButtonAnnuler implements ActionListener {
	public void actionPerformed(ActionEvent e)
	{
		Main.exit();
	}
}
