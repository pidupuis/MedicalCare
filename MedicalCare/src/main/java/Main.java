/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import main.*;
import persons.*;

/**
 *
 * @author Katia
 */
public class Main {
    public static void main (String[] args) throws Exception {
        DB_connector db = null;
        Patient p = new Patient("aurelien", "JORON", 1980, 2, 8, true, null);
        DataManager dm = new DataManager("katia", "chiron");
        Actor tmp;
        ArrayList<Patient> tmpListPatient = new ArrayList<Patient>();
        
        try {
            db = DB_connector.getInstance();
            System.out.println("Connection !");
        } catch (Exception ex) {
            System.out.println("Connection failed !");
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tmp = db.getUser(db.getUserId("katia", "chiron", 1), 1);
        tmpListPatient = db.getListPatientFromDoctor("1");
        
        for(Patient pat : tmpListPatient){
        	System.out.println(pat.getFirstName());
        }
        
        //tmp = db.getUserById(db.getUserId("katia", "chiron", 1), 1);
        //db.addDataManager(dm);
        //db.getUserId("katia", "chiron", 1);
        //db.addPatient(p);
        //db.getPatient("CHIRON", "katia", "30/12/83");
        //db.checkUser("ajoron");
        //db.addUser(tmp.getId(), "kchiron", "kchiron", 1);
        //db.getGroupId("TP");
        System.out.println("Question : " + db.getUserQuestion(tmp));
        //System.out.println("Question : " + db.getUserQuestion(tmp));
        //System.out.println("Correct ? " + db.checkUserAnswer("pataate", tmp));
        //tmp = db.connectionUser("kchiron", "kchiron", "Data Manager");
    }
}
