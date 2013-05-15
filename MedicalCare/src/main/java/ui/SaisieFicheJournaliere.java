package ui;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import persons.Actor;
import persons.Doctor;
/**
 * JPanel to insert new daily form
 * 
 * @author Mathieu
 *
 */
public class SaisieFicheJournaliere extends JPanel {

	/**
	 * Create the panel.
	 */
	public SaisieFicheJournaliere(Actor user) {
		
		//partie de gauche de mon panel
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode((user.getLastName()+" "+user.getFirstName()).toString());
		
		DefaultMutableTreeNode child1 = new DefaultMutableTreeNode("Child 1");
		root.add(child1);
		DefaultMutableTreeNode child2 = new DefaultMutableTreeNode("Child 2");
		root.add(child2);
		
		DefaultMutableTreeNode grandchild1 = new DefaultMutableTreeNode("grandchild 1");
		child2.add(grandchild1);
		DefaultMutableTreeNode grandchild2 = new DefaultMutableTreeNode("grandchild 2");
		child2.add(grandchild2);
		
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
			actor = new Doctor("John","Doeuf","doc1");
			plop.add(new SaisieFicheJournaliere(actor));
			plop.setVisible(true);
		} catch (Exception e) {
		}

		
	}

}


