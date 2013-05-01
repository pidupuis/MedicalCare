package persons;
import main.*;

public class Doctor extends Actor {

	private String login;
	private String password;
    
    /**
     * 
     * Constructor of the doctor's class. It throws an exception if the names are 
     * not correct.
     * @param id
     * @param firstName
     * @param lastName
     * @param password
     * @param login  
     */
    public Doctor(String firstName, String lastName) throws Exception {
        super(firstName, lastName);
        this.generateLogin(firstName, lastName);
    }

    /**
     *
     * @return String
     */
    public String getLogin() {
        return login;
    }

    /**
     *
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) throws Exception {
        if (this.checkPassword(password)) {
            this.password = password;
        }
        else 
        {
            throw new Exception("Mot de passe non conforme");
        }
    }
    
    private boolean checkPassword(String pass) {
        if (pass.length() < 4 && pass.length() > 15) {
            return false;
        }
        else {
            return true;
        }
    }
    
    private void generateLogin(String firstName, String lastName) throws Exception {
        String log = firstName.substring(0, 1) + lastName;

        DB_connector db = DB_connector.getInstance();
        
        log = log.replace(" ","");
        log = log.replace("-","");
        log = log.toLowerCase();
        this.login = log;
        boolean continueLoop = true;
        int i = 1;
        while (continueLoop) {
            if (db.checkUser(this.login)) {
                this.login = log + String.valueOf(i);
            }
            else {
                continueLoop = false;
            }
        }
    }

}
