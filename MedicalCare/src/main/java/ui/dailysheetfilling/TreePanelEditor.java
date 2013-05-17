package ui.dailysheetfilling;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellEditor;

public class TreePanelEditor extends AbstractCellEditor implements TreeCellEditor {

	private JButton myButton;
	private JLabel label;
	
	public TreePanelEditor() {
		this.myButton = new JButton();
		this.myButton.setBackground(Color.white);
		this.label = new JLabel();
		this.myButton.add(this.label);
	}
	
	public Object getCellEditorValue() {
		return null;
	}

	public Component getTreeCellEditorComponent(JTree tree, Object value,
			boolean isSelected, boolean expanded, boolean leaf, int row) {

		Object o = ((DefaultMutableTreeNode) value).getUserObject();
		
		if (((DefaultMutableTreeNode) value).isRoot()) {
			label.setIcon(null);
			label.setText("" + value);
		}
		else {
			label.setIcon(new ImageIcon(getClass().getResource("/icon/valide.png")));
			label.setText("" + value);
		}
		
		if (((DefaultMutableTreeNode) value).isLeaf()) {
			this.myButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,  "plop");
				}
			});
		}
		
		return myButton;
	}

}
