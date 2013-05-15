package ui.listenerconnexion;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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
			DB_connector.getInstance().connectionUser(login,mdp,role);
		} catch (Exception ex) {
			connexion.displayError(ex.getMessage());
		}


	}
}