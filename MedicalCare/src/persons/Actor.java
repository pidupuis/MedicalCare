package persons;

/**
 * Role de la personne sera recupere dans la base et permettra le cast de 
 * l'objet Java dans le role adequat.
 */
public abstract class Actor {

	private String id;
	private String firstName;
	private String lastName;

	/**
	 * Constructor of the actor's class. Needs 2 parameters : the first and the last name.
         * It throws an exception if the names are not correct.
	 * @param firstName
	 * @param lastName
	 */
	public Actor(String firstName, String lastName) throws Exception {
            if (this.checkName(firstName) && this.checkName(lastName)) {
                this.firstName = firstName;
                this.lastName = lastName;
            }
            else {
                throw new Exception();
            }
	}
        
        /**
        * Returns the id of the actor.
        * @return String
        */
	public String getId() {
		return this.id;
	}

        /**
        * Returns the first name of the actor.
        * @return String
        */
	public String getFirstName() {
            return this.firstName;
	}

	/**
	 * Set a new first name to the actor.
	 * @param name
	 */
	public void setFirstName(String firstName) throws Exception {
            if (this.checkName(firstName)) {
                this.firstName = firstName;
            }
            else {
                throw new Exception("Nom non conforme");
            }
	}

        /**
        *
        * @return String
        */
	public String getLastName() {
            return this.lastName;
	}

	/**
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) throws Exception {
            if (this.checkName(lastName)) {
                this.lastName = lastName;
            }
            else {
                throw new Exception("Nom non conforme");
            }
	}
        
        /**
	 * Method that check if the name contains only acceptable caracters.
	 * @param lastName
         * @return String
	 */
        private boolean checkName(String name) { // remettre en private après test
            if (name.matches("^[a-zA-Z][a-zA-Z -]{2,50}$")) {
                // "^(([a-zA-Z][- ]{1})+){2,50}$" Par Katia.
                return true;
            }
            else {
                return false;
            }
        }
}