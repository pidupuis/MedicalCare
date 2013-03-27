

/**
 * rôle de la personne sera récupéré dans la base et permettra le cast de l'objet Java dans le rôle adequat
 */
public abstract class Actor {

	private String id;
	private String firstName;
	private String lastName;
	private String login;
	private String password;

	/**
	 * 
	 * @param id
	 * @param firstName
	 * @param lastName
	 */
	public Actor(String id, String firstName, String lastName) {
		throw new UnsupportedOperationException();
	}

	public String getId() {
		return this.id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		throw new UnsupportedOperationException();
	}

	public String getLastName() {
		return this.lastName;
	}

	/**
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}