package ui.dailysheetfilling.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import main.DB_connector;

import oracle.jdbc.driver.DBConversion;
import tests.DailyTest;
import persons.Doctor;
import ui.dailysheetfilling.FormPanel;
import ui.dailysheetfilling.PatientNode;
import ui.dailysheetfilling.SaisieFicheJournaliere;

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
				
				String header_name = myPatientNodes.get(current_index).getMyPatient().getLastName() + " " + myPatientNodes.get(current_index).getMyPatient().getFirstName();
				fp.setHeader_name_lbl(header_name);					
				current_index++;
				
				DailyTest dt;
				try {
					dt = new DailyTest(Integer.parseInt(fp.getPres_sys_txf().getText()), Integer.parseInt(fp.getPres_dias_txf().getText()), Integer.parseInt(fp.getBat_txf().getText()), fp.getObs_txf().getText(), false, false, false, (new Date()).getDay(), myPatientNodes.get(current_index-1).getMyPatient());
					DB_connector.getInstance().addDailyTest(dt, myPatientNodes.get(current_index-1).getMyPatient(), ((Doctor) SaisieFicheJournaliere.getActor()), null, null, null);
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
				fp.cleanPanel();
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

				fp.cleanPanel();
			}
			else {
				myPatientNodes.get(current_index-1).setFocused(false);
				myPatientNodes.get(current_index-1).setValide(true);
				

				fp.correctPanel();
			}
			
			fp.cleanCorrect();
			this.fp.getParent().repaint();
		}
		else {
			//fp.getWarning_lbl().setVisible(true);
			this.fp.getParent().repaint();
			fp.getMessagePane().setErrorMessage("Veuillez remplir correctement le formulaire");
		}


	}


}
