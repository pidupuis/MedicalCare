package tests;

import java.util.Date;

public class DailyTest extends Analysis {

	private int[] bloodPressure;
	private int heartBeats;
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
	private Date dailyDate;
	private String reasonExclusion;
        private boolean prescEffort;
        private boolean prescEEG;
        private boolean prescBlood;
        private EEG EEGTest;
        private EffortTest effortTest;
        private BloodTest bloodTest;

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
	public DailyTest(int cystole, int diastole, int heart, String observations, boolean prescEffort, boolean prescEEG, boolean prescBlood) throws Exception {
            if (this.checkBeat(heart) && this.checkPressure(cystole) && this.checkPressure(diastole)) {
                this.heartBeats = heart;
                this.prescBlood = prescBlood;
                this.prescEffort = prescEffort;
                this.prescEEG = prescEEG;
                
            }
            else {
                throw new Exception("Erreur dans l'entrée des infos pour le test quotidien.");
            }
	}

	public int[] getBloodPressure() {
		return this.bloodPressure;
	}

	/**
	 * 
	 * @param bloodPressure
	 */
	public void setBloodPressure(int[] bloodPressure) {
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

	public Date getDailyDate() {
		return this.dailyDate;
	}

	/**
	 * 
	 * @param dailyDate
	 */
	public void setDailyDate(Date dailyDate) {
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
        
        
        private boolean checkPressure(int pressure) {
            if (pressure < 0 || pressure > 25) {
                return false;
            }
            else {
                return true;
            }
        }
        
        private boolean checkBeat(int beat) {
            if (beat < 20 || beat > 250) {
                return false;
            }
            else {
                return true;
            }
        }
        
        /**
	 * 
	 * @param r1
         * @param r2
         * @param r3
         * @param r4
         * @param r5
	 */
	public void addBlood(int r1, int r2, int r3, int r4, int r5) {
		this.bloodTest = new BloodTest(r1, r2, r3, r4, r5);
	}
        
        /**
	 * 
	 * @param result
	 */
	public void addEEG(int result) throws Exception {
		this.EEGTest = new EEG(result);
	}
        
        /**
	 * 
	 * @param later
         * @param after
         * @param before
	 */
	public void addEffort(int before, int after, int later) throws Exception {
		this.effortTest = new EffortTest(before, after, later);
	}
        
        /**
	 * A method that checks if the tests have been entered when there are
         * prescriptions.
	 * 
	 */
        public void checkTest() throws Exception {
            if (this.prescEffort == true && this.effortTest == null) {
                throw new Exception("Le test effort n'a pas été entré.");
            }
            if (this.prescEEG == true && this.EEGTest == null) {
                throw new Exception("Le test EEG n'a pas été entré.");
            }
            if (this.prescBlood == true && this.bloodTest == null) {
                throw new Exception("Les analyses de sang n'ont pas été entrées.");
            }
        }

}