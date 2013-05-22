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
		if (fp.isCorrect())
		{
			
			//case 1 : to change the patient in the array
			if (current_index < last_p)
			{
				myPatientNodes.get(current_index-1).setFocused(false);
				myPatientNodes.get(current_index).setFocused(true);
				myPatientNodes.get(current_index-1).setValide(true);
				
				//Control conditions are OK
				String header_name = myPatientNodes.get(current_index).getMyPatient().getLastName() + " " + myPatientNodes.get(current_index).getMyPatient().getFirstName();
				fp.setHeader_name_lbl(header_name);					
				current_index++;
				//Control conditions are NOT OK
			}
			//case 2 : the last patient of the array
			else if (current_index == last_p)
			{
				myPatientNodes.get(current_index-1).setFocused(false);
				myPatientNodes.get(current_index).setFocused(true);
				myPatientNodes.get(current_index-1).setValide(true);
				
				String header_name = myPatientNodes.get(current_index).getMyPatient().getLastName() + " " + myPatientNodes.get(current_index).getMyPatient().getFirstName();
				fp.setHeader_name_lbl(header_name);
				fp.getSuivant_btn().setText("Valider et Finir");
				current_index++;
			}
			else {
				myPatientNodes.get(current_index-1).setFocused(false);
				myPatientNodes.get(current_index-1).setValide(true);
			}
			
			fp.cleanCorrect();
			fp.cleanPanel();
			this.fp.getParent().repaint();
		}
		else {
			//fp.getWarning_lbl().setVisible(true);
			this.fp.getParent().repaint();
			if (!fp.getWarning_lbl().isErrorDisplayed())
				fp.getWarning_lbl().setErrorMessage("Veuillez remplir correctement le formulaire");
		}


	}


}
