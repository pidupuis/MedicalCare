package ui.listenerconnexion;

import java.awt.event.*;
import persons.Actor;

import main.DB_connector;
import ui.loginframe.panels.LoginPane;

/**
 *
 * @author Julien_Lavigne
 */
public class Listenersconnexion implements ActionListener {

	private LoginPane connexion;


	public Listenersconnexion(LoginPane interf)
	{
		connexion = interf;

	}

	public void actionPerformed(ActionEvent e)
	{

		String login = connexion.getLogin();
		String mdp = connexion.getPassword();
		String role = connexion.getRole();
		try {
			Actor act =DB_connector.getInstance().connectionUser(login,mdp,role);
			if(act != null)
			{
				// Main.setUser(act);
			}
		} catch (Exception ex) {
			connexion.displayError(ex.getMessage());
		}
	}
}