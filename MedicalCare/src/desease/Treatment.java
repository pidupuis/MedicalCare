package MedicalCare.desease;

import java.util.*;
import MedicalCare.group.*;

public class Treatment {

	Collection<Pathology> treatedBy;
	private date startDate;
	private date endDate;
	private Molecules[] attribute;
	private Molecules[] treat;

	public void setAttribute(Molecules[] attribute) {
		this.attribute = attribute;
	}

	public Treatment() {
		throw new UnsupportedOperationException();
	}

	public date getStartDate() {
		return this.startDate;
	}

	/**
	 * 
	 * @param startDate
	 */
	public void setStartDate(date startDate) {
		this.startDate = startDate;
	}

	public date getEndDate() {
		return this.endDate;
	}

	/**
	 * 
	 * @param endDate
	 */
	public void setEndDate(date endDate) {
		this.endDate = endDate;
	}

	public Molecules[] getTreat() {

	}

	/**
	 * 
	 * @param treat
	 */
	public void setTreat(Molecules[] treat) {

	}

}