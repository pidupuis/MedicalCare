package ui.dailysheetfilling;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.UIManager;
import main.DB_connector;
import javax.swing.JFrame;
import persons.Actor;
import persons.Doctor;
import persons.Patient;
import net.miginfocom.swing.MigLayout;
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
	public SaisieFicheJournaliere(Actor doctor, JRootPane parentRootPane) throws Exception {
		
		ArrayList<Patient> myPatients = null;

		try {
			myPatients = DB_connector.getInstance().getListPatientFromDoctor((Doctor) doctor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setLayout(new MigLayout("", "[225px][-67.00][225px][77.00][][23.00]", "[300px]"));
		
		JPanel panel = new JPanel();
		add(panel, "cell 0 0,grow");
		
		this.subpanelTree = new TreePanel(doctor, myPatients);
		subpanelTree.setMinimumSize(new Dimension(100, 1500));
		panel.add(subpanelTree);
		this.subpanelForm = new FormPanel(this.subpanelTree.getTree(), parentRootPane);
		this.add(this.subpanelForm, "cell 1 0 4 1,alignx left,growy");
		
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
		try {
			actor = new Doctor("1", "Super","Docteur");
			plop.getContentPane().add(new SaisieFicheJournaliere(actor, plop.getRootPane()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		plop.setVisible(true);
		plop.setMinimumSize(new Dimension(1000, 500));
		plop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
	}

}


