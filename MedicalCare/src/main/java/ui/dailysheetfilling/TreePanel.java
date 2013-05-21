package ui.dailysheetfilling;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import persons.Actor;
import persons.Patient;

public class TreePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTree tree;

	public TreePanel(Actor user, ArrayList<Patient> myPatients) {

		PatientNode root = new PatientNode(user);

		PatientNode child;
		boolean firstChild = true;
		for (Patient p : myPatients) {
			child = new PatientNode(p);
			if (firstChild)
				child.setFocused(true);
			firstChild = false;
			root.add(child);
		}

		this.tree = new JTree(root);
		
		this.tree.setCellRenderer(new TreePanelRenderer()); // Add renderer to tree
		
		//tree.setEditable(true);
        //tree.setCellEditor(new TreePanelEditor());

		/*tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {

			public void valueChanged(TreeSelectionEvent e) {
				
				TreePath path = e.getNewLeadSelectionPath();
                PatientNode node = 
                    (PatientNode)path.getLastPathComponent();

                if (node != null) {
                	String plop = node.toString();
                	if (node.isLeaf())
                		JOptionPane.showMessageDialog(null,  plop);
                }
                
			}

		});*/
		
		//this.tree.setSize(width, height)
		
		this.add(new JScrollPane(this.tree));
		
		
		
	}
	
	public JTree getTree() {
		return tree;
	}
}

