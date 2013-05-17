package ui.dailysheetfilling;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.*;

public class TreePanelRenderer implements TreeCellRenderer {

	//private JButton myButton;
	private JLabel label;
	
	public TreePanelRenderer() {
		//this.myButton = new JButton();
		//this.myButton.setBackground(Color.white);
		//this.myButton.setBorderPainted(false);
		this.label = new JLabel();
		//this.myButton.add(this.label);
	}
	
	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean selected, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {

		//Object o = ((DefaultMutableTreeNode) value).getUserObject();
		
		//DefaultMutableTreeNode defaultNode = ((DefaultMutableTreeNode) value);
		PatientNode node = (PatientNode) value;
		
		if (node.isRoot()) {
			label.setIcon(null);
			label.setText("" + value);
		}
		else {
			if (node.isValide()) {
				label.setIcon(new ImageIcon(getClass().getResource("/icon/success.png")));
				label.setText("" + value);
			}
			else if (node.isFocused()) {
				label.setIcon(new ImageIcon(getClass().getResource("/icon/globe2.png")));
				label.setText("" + value);
			}
			else {
				label.setIcon(new ImageIcon(getClass().getResource("/icon/warning.png")));
				label.setText("" + value);
			}
			
		}
		
		return label;//myButton;
	}

}
