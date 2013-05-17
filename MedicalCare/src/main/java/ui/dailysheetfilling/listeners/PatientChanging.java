package ui.dailysheetfilling.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import persons.Patient;
import ui.dailysheetfilling.FormPanel;
import ui.dailysheetfilling.PatientNode;
import ui.dailysheetfilling.TreePanel;

/**
 * Allow to change the patient from the button clic or the tree modification
 * @author Mathieu
 *
 */

public class PatientChanging implements ActionListener {
	
	private FormPanel fp;
	int current_index = 1;
	
	public PatientChanging(FormPanel fp) {
		this.fp = fp;
	}

	public void actionPerformed(ActionEvent e) {

		//back up the patient node list
		ArrayList<PatientNode> myPatientNodes = fp.getMyPatientNodes();
		
		//we take the max iteration of the list
		int last_p = myPatientNodes.size() - 1;
		
		//when the button is click
		
		if (myPatientNodes.get(current_index).isValide()) { // If the current patient is not validated
			
			myPatientNodes.get(current_index-1).setFocused(false);
			myPatientNodes.get(current_index).setFocused(true);
			this.fp.getParent().repaint();

			//case 1 : to change the patient in the array
			if (current_index < last_p)
			{
				//Control conditions are OK
				String header_name = myPatientNodes.get(current_index).getMyPatient().getLastName() + " " + myPatientNodes.get(current_index).getMyPatient().getFirstName();
				fp.setHeader_name_lbl(header_name);					
				current_index++;
				//Control conditions are NOT OK
			}
			//case 2 : the last patient of the array
			else if (current_index == last_p)
			{
				String header_name = myPatientNodes.get(current_index).getMyPatient().getLastName() + " " + myPatientNodes.get(current_index).getMyPatient().getFirstName();
				fp.setHeader_name_lbl(header_name);
				fp.getSuivant_btn().setText("Valider et Finir");

			}
		
		}
		
		
		
	}

	
}
