package ui.dailysheetfilling;

import javax.swing.tree.DefaultMutableTreeNode;

import persons.Actor;
import persons.Patient;

public class PatientNode extends DefaultMutableTreeNode {

	private static final long serialVersionUID = 1L;
	
	private Patient myPatient;
	private boolean valide;
	private boolean focused;
	
	public PatientNode(Actor a) {
		super(a.getFirstName()+" "+a.getLastName());
		if (a instanceof Patient)
			this.myPatient = (Patient) a;
		this.valide = false;
		this.focused = false;
	}
	
	public Patient getMyPatient() {
		return myPatient;
	}
	
	public boolean isValide() {
		return valide;
	}
	
	public void setValide(boolean valide) {
		this.valide = valide;
	}
	
	public boolean isFocused() {
		return focused;
	}
	
	public void setFocused(boolean focused) {
		this.focused = focused;
	}
	
	
}
