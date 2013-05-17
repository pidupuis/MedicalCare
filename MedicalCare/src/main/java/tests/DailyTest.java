package tests;

import persons.Doctor;
import persons.Patient;

/**
 *
 * @author Vincent Emonet
 */
public class DailyTest extends Analysis {
        private int id;
        private Patient patientTested;
        private Doctor med;
	private int[] bloodPressure;
	private int heartBeats;
	private String numeroLot;
	private String numeroChambre;
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
	private int date;
	private String reasonExclusion;
        private boolean prescEffort;
        private boolean prescEEG;
        private boolean prescBlood;
        private EEG EEGTest;
        private EffortTest effortTest;
        private BloodTest bloodTest;

	/**
         * Constructor of the DailyTest class.
	 * 
	 * @param systole
	 * @param diastole
	 * @param heart
	 * @param observations
	 * @param prescEffort
	 * @param prescEEG
	 * @param prescBlood
	 */
	public DailyTest(int systole, int diastole, int heart, String observations, boolean prescEffort, boolean prescEEG, boolean prescBlood, int date, Patient p) throws Exception {
            super(observations);
            if (this.checkBeat(heart) && this.checkPressure(systole) && this.checkPressure(diastole)) {
                this.heartBeats = heart;
                this.prescBlood = prescBlood;
                this.prescEffort = prescEffort;
                this.prescEEG = prescEEG;
                this.date = date;
                this.patientTested = p;
                
                this.bloodPressure = new int[2];
                this.bloodPressure[0] = systole;
                this.bloodPressure[1] = diastole;
                
                this.checked = false;
            }
	}

        public DailyTest() {}
        
        /**
         * This method returns the identifier of the daily sheet
         * @return the identifier of the daily sheet
         */
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
        
        /**
	 * Returns the blood pressure.
	 * @return int[]
	 */
	public int[] getBloodPressure() {
		return this.bloodPressure;
	}
        
        /**
	 * Returns the systole pressure.
	 * @return int
	 */
	public int getCystole() {
		return this.bloodPressure[0];
	}
        
        /**
	 * Returns the diastole pressure.
	 * @return int
	 */
	public int getDiastole() {
		return this.bloodPressure[1];
	}

	/**
	 * 
	 * @param bloodPressure
	 */
	public void setBloodPressure(int systole, int diastole) throws Exception {
            if (this.checkPressure(systole) && this.checkPressure(diastole)) {
                this.bloodPressure[0] = systole;
                this.bloodPressure[1] = diastole;
            }
            else {
                throw new Exception("Pression sanguine hors normes.");
            }
	}

	public int getHeartBeats() {
		return this.heartBeats;
	}

	/**
	 * 
	 * @param heartBeats
	 */
	public void setHeartBeats(int heartBeats) throws Exception {
            if (this.checkBeat(heartBeats)) {
                this.heartBeats = heartBeats;
            }
            else {
                throw new Exception("Le poul n'est pas correct.");
            }
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

	public int getDailyDate() {
		return this.date;
	}

	/**
	 * 
	 * @param dailyDate
	 */
	public void setDailyDate(int date) {
		this.date = date;
	}

	public String getReasonExclusion() {
		return this.reasonExclusion;
	}

	/**
         * Set the reason of the exclusion of a patient.
	 * 
	 * @param reasonExclusion
	 */
	public void setReasonExclusion(String reasonExclusion) {
		this.reasonExclusion = reasonExclusion;
	}        
        
        /**
         * Checks if the pressure is correct.
	 * 
	 * @param pressure
	 */
        private boolean checkPressure(int pressure) {
            if (pressure < 0 || pressure > 25) {
                return false;
            }
            else {
                return true;
            }
        }
        
        /**
         * Checks if the beat is correct.
	 * 
	 * @param beat
	 */
        private boolean checkBeat(int beat) {
            if (beat < 20 || beat > 250) {
                return false;
            }
            else {
                return true;
            }
        }
        
        
        /**
         * Returns the patient tested.
	 * 
	 * @return Patient
	 */
        public Patient getPatient() {
		return this.patientTested;
	}
        
        /**
         * Returns the doctor.
	 * 
	 * @return Doctor
	 */
        public Doctor getMed() {
            return this.med;
        }
        
        /**
         * Returns if there is a blood test prescription.
	 * 
	 * @return boolean
	 */
        public boolean getPrescEffort() {
            return this.prescEffort;
        }
        
        /**
         * Returns if there is a blood test prescription.
	 * 
	 * @return boolean
	 */
        public boolean getPrescBlood() {
            return this.prescBlood;
        }
        
        /**
         * Returns if there is an EEG test prescription.
	 * 
	 * @return boolean
	 */
        public boolean getPrescEEG() {
            return this.prescEEG;
        }
        
        
        /**
         * Returns the daily blood test.
	 * 
	 * @return BloodTest
	 */
        public BloodTest getBloodTest() {
		return this.bloodTest;
	}
        
        /**
         * Add a blood test to the daily tests.
	 * 
	 * @param Hb
         * @param GR
         * @param GB
         * @param hemato
         * @param P
         * @param p
	 */
	public void addBlood(float Hb, float GR, float GB, float hemato, float P, Patient p) throws Exception {
		this.bloodTest = new BloodTest(Hb, GR, GB, hemato, P, p);
	}
        
        
        /**
         * Returns the daily EEG test.
	 * 
	 * @return EEG
	 */
        public EEG getEEGTest() {
		return this.EEGTest;
	}
        
        
        /**
         * Add a EEG test to the daily tests.
	 * 
	 * @param result
	 */
	public void addEEG(int result) throws Exception {
		this.EEGTest = new EEG(result);
	}
        
        
        /**
         * Returns the daily effort test.
	 * 
	 * @return EffortTest
	 */
        public EffortTest getEffortTest() {
		return this.effortTest;
	}
        
        
        /**
         * Add an effort test to the daily tests.
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
