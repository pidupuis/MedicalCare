package ui.loginframe;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

/**
 * A panel build with a label displayed at the left of the panel and a field which is displayed at the right of the panel
 * @param <L> a JComponent to be used as a label
 * @param <F> a JComponent to be used as a field
 */
public class FormRow<L extends JComponent, F extends JComponent> extends JPanel {

	private static final long serialVersionUID = 1L;
	private L label;
	private F field;
	private JLabel status;
	
	/**
	 * Constructs a form row with a label and a field.
	 * @param label A label that can be any type of swing JComponent
	 * @param field A field that can be any type of swing JComponent
	 */
	public FormRow(L label, F field) {
		this.label = label;
		this.field = field;
		this.status = new JLabel();
		
		setLayout(new MigLayout("hidemode 3, inset 0 20 10 20", "[120px:n][grow][28px:28px:28px]", "[::30px,grow]"));
		
		add(this.label, "cell 0 0,grow");
		add(this.field, "cell 1 0,grow");
		add(this.status, "cell 2 0,grow");
		
		setBorder(BorderFactory.createEmptyBorder());
	}
	
	/**
	 * Makes the form row visible or invisible.
	 * @param aFlag
	 */
	@Override
	public void setVisible(boolean aFlag) {
		super.setVisible(aFlag);
		field.setEnabled(aFlag);
	}
	
	/**
	 * Display the field as invalid with red color and error icon
	 * @param arg true to make the row appear with error; false otherwise
	 */
	public void setError(boolean arg) {
		setError(arg, "");
	}
	
	/**
	 * Display the field as invalid with red color, error icon and reason in tooltip
	 * @param arg true to make the row appear with error; false otherwise
	 * @param reason the reason of the error
	 */
	public void setError(boolean arg, String reason) {
		if(arg) {
			try {
				status.setIcon(new ImageIcon(getClass().getResource("/icon/error_mini.png")));
			} catch (Exception e) {
				status.setText("/!\\");
			}
			status.setToolTipText(reason);
			field.setBackground(new Color(255, 215, 215));
		}
		else {
			status.setText("");
			status.setToolTipText("");
			status.setIcon(null);
			field.setBackground(Color.WHITE);
		}
		status.revalidate();
	}
	
	/**
	 * Gets the JComponent set as label of the form row
	 * @return the JComponent label
	 */
	public L getLabel() {
		return label;
	}
	
	/**
	 * Gets the JComponent set as field of the form row
	 * @return the JComponent field
	 */
	public F getField() {
		return field;
	}
	
	/**
	 * Changes the font of the label and field component
	 * @param f the desired Font for this component
	 */
	@Override
	public void setFont(Font f) {
		try {
			label.setFont(f);
			field.setFont(f);
		} catch (Exception e) {}
	}
}
