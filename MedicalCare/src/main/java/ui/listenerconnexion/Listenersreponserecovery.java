/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.listenerconnexion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.loginframe.LoginFrame;
import ui.loginframe.panels.PasswordRecoveryPane;

/**
 *
 * @author Julien_Lavigne
 */
public class Listenersreponserecovery implements ActionListener{
	private PasswordRecoveryPane connexion;


	public Listenersreponserecovery(PasswordRecoveryPane interf)
	{
		connexion = interf;
	}

	public void actionPerformed(ActionEvent e) 
	{
		try {
			//String pass = connexion.setReponse();
			//String login = connexion.setLogin2();
		} catch (Exception ex) {
			//connexion.displayError(ex.getMessage());
		}
	}
}