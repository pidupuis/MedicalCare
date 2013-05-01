package tests;

public class EEG extends Analysis {

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
	 * @param x
         * @return boolean
	 */
        private boolean checkEEG(int x) {
            if (x > 10 || x < 0) {
                return false;
            }
            else {
                return true;
            }
        }

}