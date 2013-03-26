package MedicalCare.tests;

public abstract class Analysis {

	private String observations;

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