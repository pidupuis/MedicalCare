package tests;

/**
 *
 * @author Vincent Emonet
 */
public class EEG extends Analysis {
        /**
         * Contains the result of the EEG analysis
         */
	private int result;

	/**
	 * Constructor of the EffortTest class. It needs one integer between 0 and 10.
	 * 
	 * @param result
	 */
	public EEG(int result) throws Exception {
            if (this.checkEEG(result))
            {
                this.result = result;
            }
            else {
                throw new Exception("Erreur de saisie pour les résultats des tests d'EEG.");
            }
	}

	public EEG() {}

	public int getResult() {
		return this.result;
	}

	/**
	 * 
	 * @param Result
	 */
	public void setResult(int result) throws Exception {
            if (this.checkEEG(result))
            {
                this.result = result;
            }
            else {
                throw new Exception("Erreur de saisie pour les résultats des tests d'EEG.");
            }
	}
        
        
        /**
	 * Method that check if the integer entered is correct.
         * 
	 * @param x
         * @return boolean
	 */
        public boolean checkEEG(int x) {
            if (x > 10 || x < 0) {
                return false;
            }
            else {
                return true;
            }
        }

}