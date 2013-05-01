package persons;

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
     */
    public CRA( String firstName, String lastName, String password, String login) throws Exception {
        super(firstName, lastName);
        this.login = firstName.substring(0, 1) + lastName;
        this.login = this.login.replace(" ","");
        this.login = this.login.replace("-","");
        this.login = this.login.toLowerCase();
        this.password = password;
        this.login = login;
    }
    
    /**
     *
     * @param login
     * @return
     */
    public boolean CreateLogin(String login) {
        if( (this.login.length() >= 2)){
                return true;
                
        }
        else 
            return false;
    }
        /**
     *
     * @param password
     * @return
     */
    public boolean CreatePassword(String password) {
        if( (this.password.length() >= 4) && (this.password.length() <= 15)){
            password = login ;
                return true;
        }
        else 
            return false;
    }

    /**
     *
     * @param login
     * @param password
     * @return
     */
    public boolean CheckLogin(String login, String password) {
        if ((this.login.equals(login)) && (this.password == password)) {
            return true;
        } else {
            return false;
        }
    }  
    /**
     *
     * @return 
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
}