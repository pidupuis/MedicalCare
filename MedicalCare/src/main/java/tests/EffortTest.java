package tests;

/**
 *
 * @author Vincent Emonet
 */
public class EffortTest extends Analysis {

	private int beforeEffort;
	private int postEffort;
	private int timePlusOne;

	/**
	 * 
	 * @param before
	 * @param after
	 * @param oneMinAfter
	 */
	public EffortTest(int before, int after, int oneMinAfter) throws Exception {
            if (this.checkEffort(before) && this.checkEffort(after) && this.checkEffort(oneMinAfter))
            {
                this.beforeEffort = before;
                this.postEffort = after;
                this.timePlusOne = oneMinAfter;
            }
            else {
                throw new Exception("Erreur de saisie pour les résultats des tests d'efforts.");
            }
	}

	public int getBeforeEffort() {
            return this.beforeEffort;
	}

	/**
	 * 
	 * @param beforeEffort
	 */
	public void setBeforeEffort(int beforeEffort) throws Exception {
            if (this.checkEffort(beforeEffort))
            {
                this.beforeEffort = beforeEffort;
            }
            else 
            {
                throw new Exception("Erreur de saisie pour les résultats des tests d'efforts.");
            }
	}

	public int getPostEffort() {
            return this.postEffort;
	}

	/**
	 * 
	 * @param postEffort
	 */
	public void setPostEffort(int postEffort) throws Exception {
            
            if (this.checkEffort(postEffort))
            {
                this.postEffort = postEffort;
            }
            else 
            {
                throw new Exception("Erreur de saisie pour les résultats des tests d'efforts.");
            }
	}

	public int getTimePlusOne() {
            return this.timePlusOne;
	}

	/**
	 * 
	 * @param timePlusOne
	 */
	public void setTimePlusOne(int timePlusOne) throws Exception {
            if (this.checkEffort(timePlusOne))
            {
                this.timePlusOne = timePlusOne;
            }
            else 
            {
                throw new Exception("Erreur de saisie pour les résultats des tests d'efforts.");
            }
	}
        
        
        /**
	 * Method that check if the integer entered is correct.
	 * @param x
         * @return boolean
	 */
        private boolean checkEffort(int x) {
            if (x < 30 || x > 220) {
                return false;
            }
            else {
                return true;
            }
        }

}