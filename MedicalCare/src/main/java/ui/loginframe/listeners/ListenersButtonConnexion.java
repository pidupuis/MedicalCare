package ui.loginframe.listeners;

import java.awt.event.*;
import main.DB_connector;
import main.Main;
import persons.Actor;
import ui.loginframe.panels.LoginPane;

/**
 * Listener sur le bouton connexion de l'interface de connexion
 * @author Julien_Lavigne
 */
public class ListenersButtonConnexion implements ActionListener {

	private LoginPane parent;


	public ListenersButtonConnexion(LoginPane interf)
	{
		parent = interf;
	}
        /**
         * Fonction qui après clique du bouton 
         * récupere les informations mit par l'utilisateur sur le login 
         * Et envoie celle-ci au DB-connetor qui lui renvoie une erreur ou un Actor qui correspond au login.
         * L'erreur est ciblé par mauvais login , mauvais mot de passe et mauvais rôle.
         * @param e 
         */
	public void actionPerformed(ActionEvent e)
	{
		parent.clearError();
		String login = parent.getUser();
		System.out.println(login);
		String mdp = parent.getPassword();
		String role = parent.getRole();
		try {
			Actor act =DB_connector.getInstance().connectionUser(login,mdp,role);

			if(act != null)
			{
				Main.setUser(act);
				Main.setRole(role);
				parent.displaySuccess("Vous êtes connecté sur Medical Care sous "+login+" en tant que "+role+" !");
			}
		} catch (Exception ex) {
			parent.displayError(ex);
		}
	}
}
