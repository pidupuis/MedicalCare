/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import persons.*;

/**
 *
 * @author Katia
 */
public class Main {
    public static void main (String[] args) {
        DB_connector db = null;
        //Patient p = new Patient("Katia", "CHIRON", 1991, 12, 16, true, Pathology.None);
        
        try {
            db = DB_connector.getInstance();
            System.out.println("Connection !");
        } catch (SQLException | IOException ex) {
            System.out.println("Connection failed !");
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //p.getBirthDate();
                
//        try {
//            //db.addUser("kchiron", "kchiron", "ARC");
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
