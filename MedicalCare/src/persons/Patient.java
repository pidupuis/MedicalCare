package persons;

import java.text.SimpleDateFormat;
import java.util.*;
import main.*;

/**
 * This class is about Patient and his/her information like the firstname, the lastname, the gender, the birthdate, the roomer number and the status of the Patient (if he/she is excluded or not)
 * This class also inherits the Actor class to have access main infomations like the name.
 * @author Katia
 */

public class Patient extends Actor {

    private String id;
    private String firstName;
    private String lastName;
    //if gender = true then the patient is a male, else the patient is a female
    private boolean gender;
    private GregorianCalendar birthDate;
    private String roomNumber;
    private boolean excluded;

    /**
     *
     * @param firstname - Firstname of the patient
     * @param lastname - Lastname of the patient
     * @param year - Year of birth of the patient
     * @param month - Month of birth of the patient
     * @param day - Day of birth of the patient  
     * @param gender - Gender of the patient (male = 1 and female = 0)
     */
    public Patient(String firstname, String lastname, int year, int month, int day, boolean gender) {
        super(null, firstname.toLowerCase(), lastname.toUpperCase());
        this.gender = gender;
        this.birthDate = new GregorianCalendar(year, month - 1, day);
        this.roomNumber = "001";
        this.excluded = false;
    }

    /**
     *  This method allows the main program to get the gender of the patient
     * @return 'True' if the Patient is a male or 'False' if the Patient is a male.
     */
    public boolean getGender() {
        return this.gender;
    }

    /**
     * This method returns the birthdate of the Patient.
     * @return a GregorianCalendar class which contains the birthdate of the Patient.
     */
    public GregorianCalendar getBirthDate() {
        return this.birthDate;
    }

    /**
     *
     * @param year - Year of the birthdate of the Patient.
     * @param month - Month of the birthdate of the Patient.
     * @param day - Day of the birthdate of the Patient.
     */

    /**
     * This method permits to get the room number of a specific Patient using his/her identifier.
     * @return the room number of the Patient.
     */
    public String getRoomNumber(String id) {
        return this.roomNumber;
    }

    /**
     * This method is used to set a room number for one Patient.
     * @param roomNumber - Corresponds to room number of the Patient.
     */
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

//    public boolean getPatientEligibility() {
//        null;
//    }

    /**
     * This method is allows the external program to get the Patient identifier.
     * @return the Patient identifier.
     */
    public String getId() {
        return this.id;
    }

    /**
     * This method is allows the external program to get the firstname of the Patient.
     * @return the firstname of the Patient.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * This method is allows the external program to get the lastname of the Patient.
     * @return the lastname of the Patient.
     */
    public String getLastName() {
        return this.lastName;
    }
    
    /**
     * This method is used to update the current status of a Patient (excluded or not).
     * @param Exclusion - Corresponds to the current status of a Patient (excluded or not).
     */
    public void setExclusion(boolean Exclusion) {
        throw new UnsupportedOperationException();
    }

    /**
     * This method is used to get the current status of a Patient (excluded or not).
     * @return the status of the patient.
     */
    public boolean getExclusion() {
        throw new UnsupportedOperationException();
    }
}