package MedicalCare.group;

import MedicalCare.persons.*;

public class SubGroup {

	Patient belongsTo;
	private String id;
	private int size;

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

	public int getSize() {
		return this.size;
	}

	/**
	 * 
	 * @param size
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * 
	 * @param id
	 */
	public SubGroup(String id) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param list
	 */
	public SubGroup addSubGroupInList(ArrayList[] list) {

	}

}