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

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public SaisieFicheJournaliere(Actor user) throws Exception {
		
		//partie de gauche de mon panel
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode((user.getLastName()+" "+user.getFirstName()).toString());
		
		LinkedHashMap<Patient, ArrayList<Analysis>> myPatientsWithAnalysis;
		try {
			myPatientsWithAnalysis = DB_connector.getInstance().getPatientsWithAnalysis(user.getId());
		} catch (Exception e) {
			myPatientsWithAnalysis = null;
			e.printStackTrace();
		}
		
		System.out.println("#1 : "+myPatientsWithAnalysis);
		
		if (myPatientsWithAnalysis.isEmpty()) {
			for (int i = 1; i<11; i++) {
				String id = "id"+i;
                String firstname = "prenom"+i;
                String lastname = "nom"+i;
                
                Patient tmpPatient;

                tmpPatient = new Patient(id);
                tmpPatient.setFirstName(firstname);
                tmpPatient.setLastName(lastname);

                ArrayList<Analysis> myAnalysis = new ArrayList<Analysis>();
                if (i%3 == 0)
                	myAnalysis.add(new BloodTest());
                if (i%3 == 0 && i%3 == 1)
                	myAnalysis.add(new EEG());
                if (i%3 == 2)
                	myAnalysis.add(new EffortTest());
                myPatientsWithAnalysis.put(tmpPatient, myAnalysis);
			}
		}
		
		System.out.println("#2 : "+myPatientsWithAnalysis);
		
		DefaultMutableTreeNode child;
		for (Patient p : myPatientsWithAnalysis.keySet()) {
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
	
		this.add(tree);
		
		//partie de droite
		
			// remplissage de la fiche journaliere
		
		
			//Remplissage des analyses si besoin
		
			//fleches qui permettent de faire passer les patients
		
	}
	
	public static void main (String[] args) {
		
		JFrame plop = new JFrame();
		Actor actor;
		try {
			actor = new Doctor("John","Doeuf","123");
			plop.add(new SaisieFicheJournaliere(actor));
		} catch (Exception e) {
			e.printStackTrace();
		}
		plop.setVisible(true);
		plop.setMinimumSize(new Dimension(200, 150));
		
		
		
	}

}


