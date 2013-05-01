package persons;

import java.util.*;
import java.util.regex.*;

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
    public Patient(String firstname, String lastname, int year, int month, int day, boolean gender) throws Exception {
        super(null, firstname.toLowerCase(), lastname.toUpperCase());
        
        int d, m, y, maxNbOfDays;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        
        HashMap nbDayInMonth = new HashMap<>();
        nbDayInMonth.put("1", 31);
        nbDayInMonth.put("2", 29);
        nbDayInMonth.put("3", 31);
        nbDayInMonth.put("4", 30);
        nbDayInMonth.put("5", 31);
        nbDayInMonth.put("6", 30);
        nbDayInMonth.put("7", 31);
        nbDayInMonth.put("8", 31);
        nbDayInMonth.put("9", 30);
        nbDayInMonth.put("10", 31);
        nbDayInMonth.put("11", 30);
        nbDayInMonth.put("12", 31);

        this.gender = gender;
        
        //check the month of the birthdate
        if (month<1 || month >12)   {
            throw new Exception("Mois de naissance incorrect !");
        }
        else    {
            m = month-1;        
       
            //check the day of the birthdate
            maxNbOfDays = (Integer)nbDayInMonth.get(String.valueOf(month));
            if (day<1 || day>maxNbOfDays)   {
                throw new Exception("Jour de naissance incorrect !");
            }
            else    {
                d = day;
            }
        }
        
        //check the year of the birthdate
        if (year<(currentYear-65) || year > currentYear || year > (currentYear-25))   {
            throw new Exception("Année de naissance non acceptable !");
        }
        else    {
            y = year;
        }
        this.birthDate = new GregorianCalendar(y, m, d);
        
        this.roomNumber = "";
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
    public Calendar getBirthDate() {
        return this.birthDate;
    }
    
    public int getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - this.birthDate.get(Calendar.YEAR);
    }

    /**
     * This method permits to get the room number of a specific Patient using his/her identifier.
     * @return the room number of the Patient.
     */
    public String getRoomNumber() {
        return this.roomNumber;
    }

    /**
     * This method is used to set a room number for one Patient.
     * @param roomNumber - Corresponds to room number of the Patient.
     */
    public void setRoomNumber(String roomNumber) throws Exception {
        Pattern p = Pattern.compile("\\d{3}+");
        Matcher match = p.matcher(roomNumber);
        
        if (match.find())   {
            this.roomNumber = roomNumber;
        }
        else    {
            throw new Exception("Numéro de chambre non conforme !");
        }
    }

    /**
     * This method is allows the external program to get the Patient identifier.
     * @return the Patient identifier.
     */
    @Override
    public String getId() {
        return this.id;
    }

    /**
     * This method is allows the external program to get the firstname of the Patient.
     * @return the firstname of the Patient.
     */
    public String getFirstName() {
        return super.getName();
    }

    /**
     * This method is allows the external program to get the lastname of the Patient.
     * @return the lastname of the Patient.
     */
    @Override
    public String getLastName() {
        return super.getLastName();
    }
    
    /**
     * This method is used to update the current status of a Patient (excluded or not).
     * @param Exclusion - Corresponds to the current status of a Patient (excluded or not).
     */
    public void setExclusion(boolean Exclusion) {
        this.excluded = true;
    }

    /**
     * This method is used to get the current status of a Patient (excluded or not).
     * @return the status of the patient.
     */
    public boolean getExclusion() {
        return excluded;
    }
}