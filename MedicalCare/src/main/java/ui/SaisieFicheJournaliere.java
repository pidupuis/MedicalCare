package ui;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTree;
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
		
		JTree tree = new JTree();
		this.add(tree);
	}

}
