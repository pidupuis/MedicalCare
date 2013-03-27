package main;

import java.util.ArrayList;
import tests.*;
import persons.*;
/**
 * A class that allows the core to access and modify data in the database.
 */
public class DB_connector {

	/**
	 * Lets to have only one DB connector. The constructor has to be private to avoid to create another object of this class. With this singleton if we modify one parameters of this class, we modify all the objects of this class.
	 */
	private DB_connector Instance;
	private Actor tempActor;
	private Analysis tempAnalysis;

	public DB_connector() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param p
	 */
	public boolean addPatient(Patient p) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param bt
	 */
	public boolean addBloodTest(BloodTest bt) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param electro
	 */
	public boolean addEEG(EEG electro) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param effort
	 */
	public boolean addEffortTest(EffortTest effort) {
		throw new UnsupportedOperationException();
	}

	public void addDoctor() {
		throw new UnsupportedOperationException();
	}

	public void addCRA() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Return all the daily informations that had not been checked.
	 */
	public DailyTest[] getUncheckedInfo() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param login
	 * @param password
	 */
	public void userSelection(String login, String password) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public void delPatient(String id) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idDoctor
	 */
	public ArrayList<Patient> getDoctorConsultations(int idDoctor) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public void getPatient(String id) {
		throw new UnsupportedOperationException();
	}

	public ArrayList<Patient> getListPatient() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idPatient
	 * @param day
	 */
	public void getDailyTests(String idPatient, String day) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idTest
	 */
	public void updateDailyTest(int idTest) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param sg
	 */
	public boolean addSubGroup(Group sg) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param p
	 */
	public boolean setSubGroup(Patient p) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param p
	 * @param g
	 */
	public void addPatientToGroup(Patient p, Group g) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public Group getInfoSubGroup(String id) {
		throw new UnsupportedOperationException();
	}

}