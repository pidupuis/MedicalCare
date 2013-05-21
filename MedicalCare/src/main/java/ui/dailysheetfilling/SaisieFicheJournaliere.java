package ui.dailysheetfilling;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.RootPaneContainer;
import javax.swing.UIManager;

import main.DB_connector;
import javax.swing.JFrame;
import persons.Actor;
import persons.Doctor;
import persons.Patient;
/**
 * JPanel to insert new daily form
 * 
 * @author Mathieu
 *
 */
public class SaisieFicheJournaliere extends JPanel {

	private static final long serialVersionUID = 1L;
	private TreePanel subpanelTree;
	private FormPanel subpanelForm;
	
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public SaisieFicheJournaliere(Actor user, ArrayList<Patient> myPatients, JRootPane parentRootPane) throws Exception {
		
		this.setLayout(new GridLayout(1, 2));
		
		this.subpanelTree = new TreePanel(user, myPatients);
		this.subpanelForm = new FormPanel(this.subpanelTree.getTree(), parentRootPane);
		
		this.add(this.subpanelTree);
		this.add(this.subpanelForm);
		
	}
	
	public TreePanel getSubpanelTree() {
		return subpanelTree;
	}
	
	/**
	 * a transitory main to run our window alone, with anything else
	 * @param args
	 */
	public static void main (String[] args) {
		
		try{
    		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    	} catch(Exception e) {}
		
		JFrame plop = new JFrame();
		
		Actor actor;
		ArrayList<Patient> myPatients = null;
		
		try {
			actor = new Doctor("1", "Super","Docteur");

			try {
				myPatients = DB_connector.getInstance().getListPatientFromDoctor((Doctor) actor);
			} catch (Exception e) {
				e.printStackTrace();
			}

			plop.add(new SaisieFicheJournaliere(actor, myPatients, plop.getRootPane()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		plop.setVisible(true);
		plop.setMinimumSize(new Dimension(1000, 500));
		plop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
	}

}


