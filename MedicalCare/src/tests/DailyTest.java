package MedicalCare.tests;

public class DailyTest {

	private int[] bloodPressure;
	private int heartBeats;
	private String observations;
	/**
	 * The datamanager writes notes about which informations are not correct and need to be modified by the CRA.
	 */
	private String checkNotes;
	/**
	 * True if the informations have been checked by a Datamanager.
	 * False if the informations need to be checked by a Datamanager.
	 */
	private boolean checked;
	/**
	 * Date of the test.
	 */
	private date dailyDate;
	private String reasonExclusion;

	/**
	 * 
	 * @param cystole
	 * @param diastole
	 * @param heart
	 * @param observations
	 * @param prescEffort
	 * @param prescEEG
	 * @param prescBlood
	 */
	public DailyTest(int cystole, int diastole, int heart, String observations, boolean prescEffort, boolean prescEEG, boolean prescBlood) {
		throw new UnsupportedOperationException();
	}

	public int[] getBloodPressure() {
		return this.bloodPressure;
	}

	/**
	 * 
	 * @param bloodPressure
	 */
	public void setBloodPressure(int[2] bloodPressure) {
		throw new UnsupportedOperationException();
	}

	public int getHeartBeats() {
		return this.heartBeats;
	}

	/**
	 * 
	 * @param heartBeats
	 */
	public void setHeartBeats(int heartBeats) {
		this.heartBeats = heartBeats;
	}

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

	public String getCheckNotes() {
		return this.checkNotes;
	}

	/**
	 * 
	 * @param checkNotes
	 */
	public void setCheckNotes(String checkNotes) {
		this.checkNotes = checkNotes;
	}

	public boolean getChecked() {
		return this.checked;
	}

	/**
	 * 
	 * @param checked
	 */
	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public date getDailyDate() {
		return this.dailyDate;
	}

	/**
	 * 
	 * @param dailyDate
	 */
	public void setDailyDate(date dailyDate) {
		this.dailyDate = dailyDate;
	}

	public String getReasonExclusion() {
		return this.reasonExclusion;
	}

	/**
	 * 
	 * @param reasonExclusion
	 */
	public void setReasonExclusion(String reasonExclusion) {
		this.reasonExclusion = reasonExclusion;
	}

	public void displayInformations() {
		throw new UnsupportedOperationException();
	}

}