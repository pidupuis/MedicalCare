package main;

public enum Pathology {
	Diabetes, Hypertension;

	/**
	 * 
	 * @param mol
	 */
	public void addPathology(String pat) {
            System.out.println("pat : " + pat);
	}

	/**
	 * 
	 * @param mol
	 */
	public void deletePathology(Pathology pat) {
		throw new UnsupportedOperationException();
	}

}