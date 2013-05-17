package ui.loginframe.listeners;

import java.awt.event.*;

import main.Main;

import ui.loginframe.panels.LoginPane;

/**
 *Listeners sur le bouton quitter de l'interface de connexion qui permet de quitter l'interface de connexion
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
