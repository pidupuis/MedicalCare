/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.listenerconnexion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.loginframe.LoginFrame;
import ui.loginframe.panels.LoginPane;

/**
 *
 * @author Julien_Lavigne
 */
public class Listenersrecovery implements ActionListener{
	private LoginPane connexion;


	public Listenersrecovery(LoginPane interf)
	{
		connexion = interf;

	}

	public void actionPerformed(ActionEvent e) 
	{
		//connexion.changepassword();   
	}
}
