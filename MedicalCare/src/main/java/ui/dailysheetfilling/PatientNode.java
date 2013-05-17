package ui.dailysheetfilling;

import javax.swing.tree.DefaultMutableTreeNode;

import persons.Patient;

public class PatientNode extends DefaultMutableTreeNode {

	private static final long serialVersionUID = 1L;
	
	private Patient myPatient;
	
	public PatientNode(Patient myPatient) {
		super(myPatient.getFirstName()+" "+myPatient.getLastName());
		this.myPatient = myPatient;
	}
	
	public Patient getMyPatient() {
		return myPatient;
	}
}
