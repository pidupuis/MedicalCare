package ui.loginframe;

import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FormField extends JPanel {
	private JLabel label;
	private JComponent field;
	
	public FormField(JLabel label, JComponent field) {
		this.label = label;
		this.field = field;
		
		setLayout(new BorderLayout());
		add(this.label, BorderLayout.WEST);
		add(this.field, BorderLayout.CENTER);
	}
	
	public JComponent getField() {
		return field;
	}
	
	@Override
	public void setVisible(boolean aFlag) {
		super.setVisible(aFlag);
		field.setEnabled(aFlag);
	}
}
