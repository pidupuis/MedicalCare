package MedicalCare.persons;

import MedicalCare.group.*;
import MedicalCare.desease.*;

public class Patient extends Actor {

	Batch takes;
	private String id;
	private String firstName;
	private String lastName;
	private boolean sex;
	private date birthDate;
	private String roomNumber;
	private boolean Exclusion;

	public Patient() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @param age
	 * @param sex
	 * @param patho
	 * @param treatments
	 */
	public Patient(String firstname, String lastname, age age, boolean sex, ArrayList<Pathology> patho, ArrayList<Treatment> treatments) {

	}

	public boolean getSex() {
		return this.sex;
	}

	/**
	 * 
	 * @param sex
	 */
	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public date getBirthDate() {
		return this.birthDate;
	}

	/**
	 * 
	 * @param birthDate
	 */
	public void setBirthDate(date birthDate) {
		this.birthDate = birthDate;
	}

	public String getRoomNumber() {
		return this.roomNumber;
	}

	/**
	 * 
	 * @param roomNumber
	 */
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public boolean getPatientEligibility() {
		throw new UnsupportedOperationException();
	}

	public String getId() {
		return this.id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	/**
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * 
	 * @param Exclusion
	 */
	public void setExclusion(boolean Exclusion) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public void DeletPatient(String id) {
		throw new UnsupportedOperationException();
	}

	public boolean getExclusion() {
		throw new UnsupportedOperationException();
	}

}