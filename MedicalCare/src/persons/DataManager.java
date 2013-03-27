package persons;

/**
 *
 * @author Cogotch
 */
public class DataManager extends Actor {
        private String password;
        private String login;
	/**
	 * 
	 * @param id
	 * @param firstName
	 * @param lastName
         * @param password
         * @param login  
	 */
	public DataManager(String id, String firstName, String lastName, String password, String login) {
		super(id, firstName, lastName);
                this.password=password;
                this.login=login;
	}
        
        /**
     *
     * @return
     */
    public String getLogin(){
            return this.login;
        }
        /**
     *
     * @param login
     */
    public void setLogin(String login){
            this.login=login;
        }
        /**
     *
     * @return
     */
    public String getPassword(){
            return this.password;
        }
        /**
     *
     * @param password
     */
    public void setPassword(String password){
            this.password=password;
        }

}