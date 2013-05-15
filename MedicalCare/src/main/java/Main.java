/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.sql.SQLException;
import main.*;
import persons.*;
import ui.LoginFrame;

/**
 *
 * @author Katia
 */
public class Main {
    public static void main (String[] args) throws Exception {
    	new LoginFrame();
    	
        DB_connector db = null;
        Patient p = new Patient("aurelien", "JORON", 1980, 2, 8, true);
        DataManager dm = new DataManager("katia", "chiron");
        Actor tmp;
        
        try {
            db = DB_connector.getInstance();
            System.out.println("Connection !");
        } catch (Exception ex) {
            System.out.println("Connection failed !");
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tmp = db.getUser(db.getUserId("katia", "chiron", 1), 1);
        //db.addDataManager(dm);
        //db.getUserId("katia", "chiron", 1);
        //db.addPatient(p);
        //db.getPatient("CHIRON", "katia", "30/12/83");
        //db.checkUser("ajoron");
        //db.addUser(tmp.getId(), "kchiron", "kchiron", 1);
        //db.getGroupId("TP");
        System.out.println("Question : " + db.getUserQuestion(tmp));
        
    }
}
