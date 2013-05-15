package ui;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
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
	public SaisieFicheJournaliere() {
		//partie de gauche de mon panel
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
		DefaultMutableTreeNode child1 = new DefaultMutableTreeNode("Child 1");
		root.add(child1);
		DefaultMutableTreeNode child2 = new DefaultMutableTreeNode("Child 2");
		root.add(child2);
		JTree tree = new JTree(root);
	
		this.add(tree);
		//partie de droite
		
			// remplissage de la fiche journaliere
		
			//Remplissage des analyses si besoin
		
			//fleches qui permettent de faire passer les patients
		
	}

}
