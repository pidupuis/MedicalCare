/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.listenerconnexion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import main.DB_connector;
import persons.Actor;
import ui.LoginFrame;

/**
 *
 * @author Julien_Lavigne
 */
public class Listenersloginrecovery {
 
    private LoginFrame connexion;
    
    public Listenersloginrecovery (LoginFrame interf)
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

    

