package persons;

/**
 * Role de la personne sera recupere dans la base et permettra le cast de
 * l'objet Java dans le role adequat.
 *
 * @author Vincent Emonet, Kévin Gravouil
 */
public abstract class Actor {

    /**
     * Identifier as set in the database.
     */
    private String id;
    /**
     * First name as set in the database.
     */
    private String firstName;
    /**
     * Last name as set in the database.
     */
    private String lastName;

	/**
	 * Constructor of the actor's class. Needs 2 parameters : the first and the last name.
         * It throws an exception if the names are not correct.
         * 
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
	 * Constructor of the actor's class. Needs 3 parameters : the first, the last name and the ID.
         * It throws an exception if the names are not correct.
         * 
	 * @param firstName
	 * @param lastName
	 */
	public Actor(String firstName, String lastName, String id) throws Exception {
            if (this.checkName(firstName) && this.checkName(lastName)) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.id = id;
            }
            else {
                throw new Exception();
            }
	}
        
        /**
        * Returns the id of the actor.
        * 
        * @return String
        */
	public String getId() {
		return this.id;
	}
        
        /**
	 * Set a new id to the actor.
         * 
	 * @param name
	 */
        public void setId(String id) {
            this.id = id;
	}

    /**
     * Returns the first name of the actor.
     *
     * @return String
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Set a new first name to the actor.
     *
     * @param name
     */
    public void setFirstName(String firstName) throws Exception {
        if (this.checkName(firstName)) {
            this.firstName = firstName;
        } else {
            throw new Exception("Nom non conforme");
        }
    }

    /**
     * Get the last name.
     *
     * @return String
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Set the last name if it is OK
     *
     * @param lastName
     */
    public void setLastName(String lastName) throws Exception {
        if (this.checkName(lastName)) {
            this.lastName = lastName;
        } else {
            throw new Exception("Nom non conforme");
        }
    }

        /**
	 * Method that check if the name contains only acceptable caracters.
	 * @param lastName
         * @return String
	 */
        private boolean checkName(String name) {
            if (name.matches("^[a-zA-Z][a-zA-Z -]{2,50}$")) {
                // "^(([a-zA-Z][- ]{1})+){2,50}$" Par Katia.
                return true;
            }
            else {
                return false;
            }
        }
}