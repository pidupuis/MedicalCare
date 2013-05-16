package ui.loginframe.listeners;

import java.awt.event.*;

import persons.Actor;

import main.DB_connector;
import main.Main;
import ui.loginframe.panels.LoginPane;

/**
 *
 * @author Julien_Lavigne
 */
public class ListenersButtonConnexion implements ActionListener {

	private LoginPane parent;


	public ListenersButtonConnexion(LoginPane interf)
	{
		parent = interf;
	}

	public void actionPerformed(ActionEvent e)
	{
		parent.clearAll();
		String login = parent.getUser();
		String mdp = parent.getPassword();
		String role = parent.getRole();
		try {
			Actor act =DB_connector.getInstance().connectionUser(login,mdp,role);

			if(act != null)
			{
				Main.setUser(act);
				parent.displaySuccess("Vous êtes connecté sur Medical Care sous "+login+" en tant que "+role+" !");
			}
		} catch (Exception ex) {
			parent.displayError(ex);
			//JOptionPane.showMessageDialog(null, "Error");
			//ex.printStackTrace();
		}
	}
}
