import java.awt.*;
 import java.awt.event.*;
import java.io.IOException;
 import javax.swing.*;
 import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.DB_connector;
 import ui.LoginFrame;
 /**
  *
  * @author Julien_Lavigne
  */
 public class Listenersconnexion implements ActionListener {

   private LoginFrame connexion;
     
     
    public Listenersconnexion(LoginFrame interf)
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
        } catch (IOException ex) {
            connexion.displayError(ex.getMessage());
        }
   
        
     }
 }