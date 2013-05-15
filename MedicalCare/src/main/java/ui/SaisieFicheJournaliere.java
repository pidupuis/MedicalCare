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
		DefaultMutableTreeNode racine1 = new DefaultMutableTreeNode("Main User") ;
			//recuperer les patients
		for( int i = 0; i < 3; ++i)
			   racine2.add( new DefaultMutableTreeNode("fils N° "+ i));
			JTree monArbre2 = new JTree(racine2) ;
				//pour chaque patient ajouter les fiches
		
		JTree tree = new JTree(racine1);
		this.add(tree);
		//partie de droite
		
			// remplissage de la fiche journaliere
		
			//Remplissage des analyses si besoin
		
			//fleches qui permettent de faire passer les patients
		
	}

}
