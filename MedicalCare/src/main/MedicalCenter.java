package main;

/**
 *
 * @author Vincent Emonet
 */
public class MedicalCenter {

	private String name;
	private String address;
        
        /**
	 * Constructor of the MedicalCenter class. Needs 2 parameters : the name and the address.
         * It throws an exception if the names are not correct.
	 * @param name
         * @param address
	 */
        public MedicalCenter(String name, String address) throws Exception {
            if (this.checkName(name) && this.checkAddress(address)) {
                this.name = name;
                this.address = address;
            }
            else {
                throw new Exception("Renseignements du centre médical non conformes.");
            }
        }
        

        /**
	 * Return the medical center name's.
	 */
	public String getName() {
            return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) throws Exception {
            if (this.checkName(name)) {
                this.name = name;
            }
            else {
                throw new Exception("Nom du centre médical non conformes.");
            }
	}

	public String getAddress() {
            return this.address;
	}

	/**
	 * Set the address
	 * @param address
	 */
	public void setAddress(String address) throws Exception {
            if (this.checkName(address)) {
                this.address = address;
            }
            else {
                throw new Exception("Addresse du centre médical non conformes.");
            }
	}
        
        /**
	 * Method that check if the name contains only acceptable caracters.
	 * @param name
         * @return String
	 */
        private boolean checkName(String name) {
            if (name.length() < 2 || name.length() > 250) {
                return false;
            }
            else {
                return true;
            }
        }
        
        /**
	 * Method that check if the address is correct.
         * @return String
	 */
        private boolean checkAddress(String ad) {
            if (ad.length() < 2 || ad.length() > 1000) {
                return false;
            }
            else {
                return true;
            }
        }

}