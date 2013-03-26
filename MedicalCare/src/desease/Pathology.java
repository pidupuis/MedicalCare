package MedicalCare.desease;

public class Pathology {

	private int id;
	private String denomination;
	private boolean excluding;
	private boolean risky;

	public Pathology() {
		throw new UnsupportedOperationException();
	}

	public int getId() {
		return this.id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	public String getDenomination() {
		return this.denomination;
	}

	/**
	 * 
	 * @param denomination
	 */
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public boolean getExcluding() {
		return this.excluding;
	}

	/**
	 * 
	 * @param excluding
	 */
	public void setExcluding(boolean excluding) {
		this.excluding = excluding;
	}

	public boolean getRisky() {
		return this.risky;
	}

	/**
	 * 
	 * @param risky
	 */
	public void setRisky(boolean risky) {
		this.risky = risky;
	}

}