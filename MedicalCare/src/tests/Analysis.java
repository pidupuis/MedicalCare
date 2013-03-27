package tests;

/**
 *
 * @author Cogotch
 */
public abstract class Analysis {

	private String observations;

	/**
     *
     * @return
     */
    public String getObservations() {
		return this.observations;
	}

	/**
	 * 
	 * @param observations
	 */
	public void setObservations(String observations) {
		this.observations = observations;
	}

}