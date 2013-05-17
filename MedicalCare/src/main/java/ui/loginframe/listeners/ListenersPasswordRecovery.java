/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.loginframe.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.DB_connector;

import ui.loginframe.panels.LoginPane;
import ui.loginframe.panels.PasswordRecoveryPane;

/**
 *listeners sur le bouton Ok de l'interface de récupération de mot de passe 
 * @author Julien_Lavigne
 */
public class ListenersPasswordRecovery implements ActionListener {

	private PasswordRecoveryPane connexion;

	public ListenersPasswordRecovery (PasswordRecoveryPane interf)
	{
		connexion = interf;        
	}

         /**
          * Le bouton sert plusieurs action , on a spécifier ces actions par l'utilisation d'un type d'écran 
          * 0 = Fenêtre de recherche de question avec le login 
          * 
          * Recherche de la question grâce au login rentrér par l'utilisateur
          * Si il n'y a pas de question alors il y a un message d'erreur pour mauvais login
          * 
          * 1 = Fenêtre de question avec remise de la réponse à celle-ci.
          * 
          * On récupére la réponse à la question ensuite on test si celle-ci correspond à la réponse enregistrer.
          * Si c'est juste alors on change l'écran sinon on envoie un message d'erreur
          * 
          * Autre = Fenêtre changement de password !
          * 
          * L'utilisateur change de password , si les deux password ne sont pas identique alors on lui demande de
          * recommencer sinon on lui remet la fênetre de connexion.

          * @param e 
          */
	public void actionPerformed(ActionEvent e) 
	{
		if(0==connexion.getCurrentScreen())
		{
			try {
				String login = connexion.getLogin();
				String question =DB_connector.getInstance().getUserQuestion(login);
				if(question!=null)
				{
					connexion.displayQuestion(question);
				}

			} catch (Exception ex) {
				connexion.displayError(ex.getMessage());
			}
		}
		else if(1==connexion.getCurrentScreen())
		{
			try {
				String login = connexion.getLogin();
				String answer = connexion.getAnswer();

				if(DB_connector.getInstance().checkUserAnswer(answer, login))
				{
					connexion.displayPassword();
				}
				else
				{
					connexion.displayError("La réponse est fausse !");
				}


			} catch (Exception ex) {
				connexion.displayError(ex.getMessage());
			}
		}
		else
		{
			try {
				String login = connexion.getLogin();
				String pass = connexion.getNewPasswd();
				String pass2 = connexion.getNewPasswdConf();
				if(pass.equals(pass2))
				{
					DB_connector.getInstance().resetPassword(login,pass);
                                       connexion.displaySuccess("Mot de passe réinialisé ");
				}
				else
				{
					connexion.displayError("Les deux passwords ne sont pas identique");
				}


			} catch (Exception ex) {
				connexion.displayError(ex.getMessage());
			}
		}
	}
}
