package persons;

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
        this.login = firstName.substring(0, 1) + lastName;
        this.login = this.login.replace(" ","");
        this.login = this.login.replace("-","");
        this.login = this.login.toLowerCase();
        //System.out.println(this.login);
        // Faire une boucle qui check si le login est bien unique et ajoute un chiffre si non.
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

}
