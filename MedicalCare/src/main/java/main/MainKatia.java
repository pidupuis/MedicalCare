package main;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.sun.org.apache.xerces.internal.impl.dv.xs.DayDV;
import java.util.ArrayList;

import javax.swing.UIManager;

import main.*;
import persons.*;
import tests.*;
import ui.MainWindow;
import ui.loginframe.LoginFrame;

/**
 *
 * @author Katia
 */
public class MainKatia {
    private static Actor user=null;
    private static LoginFrame loginFrame;
    private static MainWindow mainWindow;
    
    public static void main (String[] args) throws Exception {
    	
        DB_connector db = null;
        Patient p;
        //DataManager dm = new DataManager("katia", "chiron");
        //DailyTest d = new DailyTest(12, 8, 70, "Aucune observation particulière", true, true, true, null, p, null);
        Actor tmp;
        ArrayList<Patient> tmpListPatient = new ArrayList<Patient>();
        
        try {
            db = DB_connector.getInstance();
            System.out.println("Connection !");
        } catch (Exception ex) {
            System.out.println("Connection failed !");
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("MAIN KATIA");
        
//        tmp = db.getUserById(db.getUserId("katia", "chiron", 1), 1);
        //tmpListPatient = db.getListPatientFromDoctor("1");
        //tmp = db.getUserById(db.getUserId("katia", "chiron", 1), 1);
       // tmpListPatient = db.getListPatientFromDoctor(tmp);
        
//        for(Patient pat : tmpListPatient){
//        	System.out.println(pat.getFirstName());
//        }
        
        //tmp = db.getUserById(db.getUserId("katia", "chiron", 1), 1);
        //db.addDataManager(dm);
        //db.getUserId("katia", "chiron", 1);
        //db.addPatient(p);
        p = db.getPatient("Smith", "John", "12/12/75");
        //db.checkUser("ajoron");
        //db.addUser(tmp.getId(), "kchiron", "kchiron", 1);
        //db.getGroupId("TP");
        //System.out.println("Question : " + db.getUserQuestion(tmp));
        //System.out.println("Question : " + db.getUserQuestion(tmp));
        //System.out.println("Correct ? " + db.checkUserAnswer("pataate", tmp));
        //tmp = db.connectionUser("kchiron", "kchiron", "Data Manager");
        //db.addDailyTest(new DailyTest(12, 8, 70, "Aucune observation particulière", true, true, true, null, p, null), p);
        //db.setState(d, "en_cours");
        //System.out.println("Patient : " + db.getPatientById("1"));
        Doctor dct = db.getDoctorById("21");
        DailyTest d = db.getDailyTests("1", "05");
        //System.out.println("D1 : " + d.getObservations());
        BloodTest bt = new BloodTest(13, 4, 6, 40, 250, p);
        //db.addBloodTest(bt, "1");
        EEG eeg = new EEG(8);
        //db.addEEG(eeg, "1");
        EffortTest et = new EffortTest(70, 180, 100);
        //db.addEffortTest(et, "1");
        //db.addDailyTest(d, p, dct, eeg, bt, et);
        //d = db.getDailyTests("1", "09");
        //System.out.println("patient : " + d.getPatient().getFirstName());
        //Lot l = db.getLotByIdPatient("1565");
        //l = db.getLotByIdFiche("1");
        
    }

    public static void setUser(Actor user) {
        MainKatia.user = user;
    }

    public static Actor getUser() {
        return user;
    }
    
    public static void launchMainWindow() {
    	if(user != null) {
    		loginFrame.dispose();
    		mainWindow.setVisible(true);
    	}
    }
    
    /**
     * 
     */
    public static void exit() {
    	System.exit(0);
    }
    
}
