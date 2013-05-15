package persons;

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
     * The exclusion list is a hashmap with patient as key and exclusion justification as value
     */
    private HashMap<Patient, String> exclusionList = new HashMap<Patient, String>();

    /**
     *
     * @param id
     * @param firstName
     * @param lastName
     * @param password
     * @param login the constructor create a new CRA (Clinical Research
     * Associate) in the database
     */
    public CRA(String firstName, String lastName) throws Exception {
        super(firstName, lastName);
        this.generateLogin(firstName, lastName);
        this.password = this.login;

    }

    /**
     * Get the exclusion list. This is a HashMap<Patient, String>.
     * @return 
     */
    public HashMap<Patient, String> getExclusionList() {
        return exclusionList;
    }

    /**
     * Get the exclusion list size.
     * @return size of hashmap = number of patient
     */
    public int size() {
        return exclusionList.size();
    }

    /**
     * Get a justification for a specific patient.
     * @param key
     * @return justification as String
     */
    public String get(Patient pat) {
        return exclusionList.get(pat);
    }

    /**
     * Add a patient and justification to exclusion list.
     * @param pat
     * @param justif
     * @return 
     */
    public String put(Patient pat, String justif) {
        return exclusionList.put(pat, justif);
    }

    /**
     * Remove a patient from exclusion list.
     * @param pat
     * @return 
     */
    public String remove(Patient pat) {
        return exclusionList.remove(pat);
    }

    /**
     * Clear the entire exclusion list.
     */
    public void clear() {
        exclusionList.clear();
    }

    /**
     * Get the list of patient
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
    public boolean CheckPassword(String password) throws Exception {
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

    private void generateLogin(String firstName, String lastName) throws Exception {
        String log = firstName.substring(0, 1) + lastName;

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
