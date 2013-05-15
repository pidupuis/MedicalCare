/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.listenerconnexion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.loginframe.panels.LoginPane;

/**
 *
 * @author Julien_Lavigne
 */
public class Listenersloginrecovery implements ActionListener {

	private LoginPane connexion;

	public Listenersloginrecovery (LoginPane interf)
	{
		connexion = interf;        
	}

	@Override
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