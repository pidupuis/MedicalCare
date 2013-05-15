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
		DefaultMutableTreeNode racine2 = new DefaultMutableTreeNode("Racine");
		
		for (int i = 0; i < 3; i++){
			//on recupere les patients
			 racine2.add(new DefaultMutableTreeNode("fils"+ i));
			//pour chaque patient ajouter les fiches
			 for (int j = 0; j < 3; j++){
				// String nd = ("fils"+ i).toString();
				 //nd.add(new DefaultMutableTreeNode("petit-fils"+ j));
			 }
		}
		JTree monArbre2 = new JTree(racine2) ;
		this.add(monArbre2);
		//partie de droite
		
			// remplissage de la fiche journaliere
		
			//Remplissage des analyses si besoin
		
			//fleches qui permettent de faire passer les patients
		
	}

}
