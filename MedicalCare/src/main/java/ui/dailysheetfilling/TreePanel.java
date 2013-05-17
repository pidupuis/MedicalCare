package ui.dailysheetfilling;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import main.DB_connector;
import persons.Actor;
import persons.Doctor;
import persons.Patient;

public class TreePanel extends JPanel {
	
	public TreePanel(Actor user) {
		
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
				
				JTree tree = new JTree(root);
				
				tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
					
					public void valueChanged(TreeSelectionEvent e) {
						JFrame plop = new JFrame();
						plop.setSize(100, 100);
						plop.setVisible(true);
					}
					
				});
				
		this.add(tree);
	}
}
