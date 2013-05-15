/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.listenerconnexion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.DB_connector;

import ui.loginframe.panels.LoginPane;
import ui.loginframe.panels.PasswordRecoveryPane;

/**
 *
 * @author Julien_Lavigne
 */
public class ListenersPasswordRecovery implements ActionListener {

	private PasswordRecoveryPane connexion;

	public ListenersPasswordRecovery (PasswordRecoveryPane interf)
	{
		connexion = interf;        
	}

	public void actionPerformed(ActionEvent e) 
	{
            if(0==connexion.getScreen())
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
            else if(1==connexion.getScreen())
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
                        String pass2 = connexion.getNewPasswd2();
                        if(pass==pass2)
                        {
                            DB_connector.getInstance().setChangePassword(pass,login);
                        }
                        else
                        {
                            connexion.displayError("Les deux password ne sont pas identique");
                        }
                        

		} catch (Exception ex) {
			connexion.displayError(ex.getMessage());
		}
            }
	}
}