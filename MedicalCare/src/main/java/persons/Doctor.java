package persons;

import java.util.ArrayList;
import main.*;

/**
 *
 * @author Vincent Emonet
 */
public class Doctor extends Actor {

    /**
     * Login of the doctor on the database
     */
    private String login;
    /**
     * Password of this Doctor on the database
     */
    private String password;
    /**
     * The CRA whose supervise this Doctor
     */
    private CRA cra;

    /**
     * List of patients supervised by the doctor
     */
    private ArrayList<Patient> patientList = new ArrayList<Patient>();
    
    /**
     * Constructor of the doctor's class. 
     * @param firstName
     * @param lastName
     * @param id
     * @param cra
     * @throws Exception 
     */
    public Doctor(String firstName, String lastName, String id, CRA cra) throws Exception {
        super(firstName, lastName, id);
        this.generateLogin();
        this.password = this.login;
        this.cra = cra;
    }
    


    public Doctor(String id, String firstName, String lastName) throws Exception {
    	super(id, firstName, lastName);
	}



	/**
     * Getter of the login of this instance of Doctor
     *
     * @return String
     */
    public String getLogin() {
        return login;
    }

    /**
     * Getter of the password of this instance of Doctor
     *
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter of the password
     *
     * @param password Take a new string in order to modify the previous
     * password
     */
    public void setPassword(String password) throws Exception {
        if (this.checkPassword(password)) {
            this.password = password;
        } else {
            throw new Exception("Mot de passe non conforme");
        }
    }

    /**
     * Check the password. If the length of it is not between 4 and 15, the
     * password is not good
     *
     * @param pass The password to check
     * @return A boolean of the validity of the password
     */
    private boolean checkPassword(String pass) {
        if (pass.length() < 4 || pass.length() > 15) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * It generate a password from the first and last name of an Doctor
     *
     * @param firstName
     * @param lastName
     * @throws Exception
     */
    private void generateLogin() throws Exception {
        String log = super.getFirstName().substring(0, 1) + super.getLastName();

        DB_connector db = DB_connector.getInstance();

        log = log.replace(" ", "");
        log = log.replace("-", "");
        log = log.toLowerCase();
        this.login = log;
        boolean continueLoop = true;
        int i = 1;
        while (continueLoop) {
            if (db.checkUser(this.login)) {
                this.login = log + String.valueOf(i);
            } else {
                continueLoop = false;
            }
        }
    }

    /**
     * Getter of the CRA whose supervise this instance of Doctor
     *
     * @return CRA
     */
    public CRA getCra() {
        return cra;
    }

    /**
     * Setter of the CRA whose supervise this instance of Doctor
     *
     * @param cra
     */
    public void setCra(CRA cra) {
        this.cra = cra;
    }

    /**
     * Get the list of patient supervised by the doctor.
     *
     * @return
     */
    public ArrayList<Patient> getPatientList() {
        return patientList;
    }
    
    /**
     * Set the list of patient
     * @param patientList 
     */
    public void setPatientList(ArrayList<Patient> patientList) {
        this.patientList = patientList;
    }

}
