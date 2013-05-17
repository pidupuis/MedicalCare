package ui.loginframe.listeners;

import java.awt.event.*;

import main.Main;

import ui.loginframe.panels.LoginPane;

/**
 *
 * @author Julien_Lavigne
 */
public class ListenersButtonQuit implements ActionListener {
    /**
     * Fonction qui permet de quitter le programme et quitte la fênetre de connexion
     * @param e 
     */
	public void actionPerformed(ActionEvent e)
	{
		Main.exit();
	}
}
