package ui.dailysheetfilling;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.*;

public class TreePanelRenderer implements TreeCellRenderer {

	private JButton myButton;
	private JLabel label;
	
	public TreePanelRenderer() {
		this.myButton = new JButton();
		this.myButton.setBackground(Color.white);
		this.myButton.setBorderPainted(false);
		this.label = new JLabel();
		this.myButton.add(this.label);
	}
	
	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean selected, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {

		Object o = ((DefaultMutableTreeNode) value).getUserObject();
		
		if (((DefaultMutableTreeNode) value).isRoot()) {
			label.setIcon(null);
			label.setText("" + value);
		}
		else {
			label.setIcon(new ImageIcon(getClass().getResource("/icon/valide.png")));
			label.setText("" + value);
		}
		
		return myButton;
	}

}
