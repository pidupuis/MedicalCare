package ui.dailysheetfilling;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.swing.JPanel;

import main.DB_connector;
import net.miginfocom.swing.MigLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import oracle.jdbc.driver.DBConversion;

import persons.Actor;
import persons.Doctor;
import persons.Patient;
import tests.Analysis;
import tests.BloodTest;
import tests.EEG;
import tests.EffortTest;
/**
 * JPanel to insert new daily form
 * 
 * @author Mathieu
 *
 */
public class SaisieFicheJournaliere extends JPanel {

	private JPanel subpanelTree;
	private JPanel subpanelForm;
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public SaisieFicheJournaliere(Actor user, ArrayList<Patient> myPatients ) throws Exception {
		
		this.setLayout(new GridLayout(1, 2));
		
		this.subpanelTree = new TreePanel(user);
		this.subpanelForm = new FormPanel(myPatients);
		
		this.add(this.subpanelTree);
		//this.add(new JSeparator());
		this.add(this.subpanelForm);
		
	}
	
	public static void main (String[] args) {
		
		JFrame plop = new JFrame();
		
		Actor actor;
		ArrayList<Patient> myPatients = null;
		
		try {
			actor = new Doctor("Super","Docteur","1");

			try {
				myPatients = DB_connector.getInstance().getListPatientFromDoctor((Doctor) actor);
			} catch (Exception e) {
				e.printStackTrace();
			}

			plop.add(new SaisieFicheJournaliere(actor, myPatients));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		plop.setVisible(true);
		plop.setMinimumSize(new Dimension(1000, 500));
		plop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
	}

}


