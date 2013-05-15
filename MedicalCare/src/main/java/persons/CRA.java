package persons;

import main.*;

public class CRA extends Actor {

    private String login;
    private String password;

    /**
     *
     * @param id
     * @param firstName
     * @param lastName
     * @param password
     * @param login
     * the constructor create a new CRA (Clinical Research Associate) in the database
     */
    public CRA( String firstName, String lastName) throws Exception {
        super(firstName, lastName);
        this.generateLogin(firstName, lastName);
       this.password = this.login;

    }
    /**
     *
     * @param login
     * @param password
     * @return
     */
    
    public boolean CheckPassword( String password)  throws Exception{
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
