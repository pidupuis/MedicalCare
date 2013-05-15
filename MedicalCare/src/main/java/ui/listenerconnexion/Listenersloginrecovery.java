/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.listenerconnexion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.loginframe.panels.LoginPane;
import ui.loginframe.panels.PasswordRecoveryPane;

/**
 *
 * @author Julien_Lavigne
 */
public class Listenersloginrecovery implements ActionListener {

	private PasswordRecoveryPane connexion;

	public Listenersloginrecovery (PasswordRecoveryPane interf)
	{
		connexion = interf;        
	}

	public void actionPerformed(ActionEvent e) 
	{
		try {
			// String login = connexion.getLogin2();
			//connexion.setQuestion(DB_connector.getInstance().getUserQuestion(login);

		} catch (Exception ex) {
			//connexion.displayError2(ex.getMessage());
		}
	}
}