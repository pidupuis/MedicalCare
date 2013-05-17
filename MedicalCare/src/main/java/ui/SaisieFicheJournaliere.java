package ui;

import java.awt.Dimension;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.swing.JPanel;

import main.DB_connector;
import net.miginfocom.swing.MigLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
	public SaisieFicheJournaliere(Actor user) throws Exception {
		
		// Subpanel to construct the tree
		DefaultMutableTreeNode root = new DefaultMutableTreeNode((user.getLastName()+" "+user.getFirstName()).toString());
		
		ArrayList<Patient> myPatients = null;
		
		try {
			myPatients = DB_connector.getInstance().getListPatientFromDoctor((Doctor) user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		DefaultMutableTreeNode child;
		for (Patient p : myPatients) {
			child = new DefaultMutableTreeNode(p.getFirstName()+" "+p.getLastName());
			root.add(child);
		}
		
		/*DefaultMutableTreeNode child1 = new DefaultMutableTreeNode("Child 1");
		root.add(child1);
		DefaultMutableTreeNode child2 = new DefaultMutableTreeNode("Child 2");
		root.add(child2);
		
		DefaultMutableTreeNode grandchild1 = new DefaultMutableTreeNode("grandchild 1");
		child2.add(grandchild1);
		DefaultMutableTreeNode grandchild2 = new DefaultMutableTreeNode("grandchild 2");
		child2.add(grandchild2);*/
		
		JTree tree = new JTree(root);
		
		tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
			
			public void valueChanged(TreeSelectionEvent e) {
				JFrame plop = new JFrame();
				plop.setSize(100, 100);
				plop.setVisible(true);
			}
			
		});
	
		this.add(tree);
		
		//partie de droite
		
			// remplissage de la fiche journaliere
		
		
			//Remplissage des analyses si besoin
		
			//fleches qui permettent de faire passer les patients
		//this.add(this.subpanelTree);
		
	}
	
	public static void main (String[] args) {
		
		JFrame plop = new JFrame();
		Actor actor;
		try {
			actor = new Doctor("Super","Docteur","1");
			plop.add(new SaisieFicheJournaliere(actor));
		} catch (Exception e) {
			e.printStackTrace();
		}
		plop.setVisible(true);
		plop.setMinimumSize(new Dimension(200, 150));
		
		
		
	}

}


