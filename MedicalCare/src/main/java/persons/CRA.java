package persons;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Set;
import main.*;

public class CRA extends Actor {

    /**
     * CRA login as used to log in the software
     */
    private String login;
    /**
     * CRA password used to log in the software
     */
    private String password;
    /**
     * The exclusion list is a hashmap with patient as key and exclusion
     * justification as value
     */
    private HashMap<Patient, String> exclusionList = new HashMap<Patient, String>();

    public CRA(String id, String firstName, String lastName) throws Exception {
        super(id, firstName, lastName);
    }

    /**
     * Create a new CRA.
     *
     * @param firstName
     * @param lastName
     * @throws Exception
     */
    public CRA(String firstName, String lastName) throws Exception {
        super(firstName, lastName);
        this.generateLogin();
        this.password = this.login;
    }

    /**
     * Get the exclusion list. This is a HashMap<Patient, String>.
     *
     * @return
     */
    public HashMap<Patient, String> getExclusionList() {
        return exclusionList;
    }

    /**
     * Get the exclusion list size.
     *
     * @return size of hashmap = number of patient
     */
    public int size() {
        return exclusionList.size();
    }

    /**
     * Get a justification for a specific patient.
     *
     * @param key
     * @return justification as String
     */
    public String get(Patient pat) {
        return exclusionList.get(pat);
    }

    /**
     * Add a patient and justification to exclusion list.
     *
     * @param pat
     * @param justif
     * @return
     */
    public void askForExclusion(Patient pat, String justif) {
        this.exclusionList.put(pat, justif);
    }
    
    
    /**
     * confirm the exclusion for a patient.
     * @param pat
     * @throws SQLException
     * @throws Exception 
     */
    public void confirmExclusion(Patient pat) throws SQLException, Exception {
        pat.setInclusion(true);
        DB_connector.getInstance().excludePatient(pat.getId(), this.exclusionList.get(pat));
        this.remove(pat);
    }

    /**
     * Remove a patient from exclusion list.
     *
     * @param pat
     * @return
     */
    public void remove(Patient pat) {
       this.exclusionList.remove(pat);
    }

    /**
     * Clear the entire exclusion list.
     */
    public void clear() {
        exclusionList.clear();
    }

    /**
     * Get the list of patient
     *
     * @return Set<Patient>
     */
    public Set<Patient> keySet() {
        return exclusionList.keySet();
    }

    /**
     *
     * @param login
     * @param password
     * @return
     */
    public boolean checkPassword(String password) throws Exception {
        if (password.length() < 4 || password.length() > 15) {
            return true;
        } else {
            throw new Exception("Password is not good!");
        }
    }

    /**
     *
     * @return the login of CRA (Clinical Research Associate)
     */
    public String getLogin() {
        return this.login;
    }

    /**
     *
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return this.password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Auto generate the CRA login.
     *
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
}
