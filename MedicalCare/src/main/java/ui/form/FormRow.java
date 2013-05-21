package ui.form;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

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

		setLayout(new MigLayout("hidemode 3, inset 0 20 10 20", "[140px:n][grow][28px:28px:28px]", "[30px,grow]"));

		if(this.field instanceof JTextArea || this.field instanceof JTextField || this.field instanceof JPasswordField)
			this.field.setBorder(new LineBorder(new Color(0,0,0, 50)));

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
	 * Display the field as invalid with red color, error icon and reason in tooltip
	 * @param arg true to make the row appear with error; false otherwise
	 * @param reason the reason of the error
	 */
	public void setError(String reason) {
		try {
			status.setIcon(new ImageIcon(getClass().getResource("/icon/error_mini.png")));
		} catch (Exception e) { }
		status.setToolTipText(reason);
		field.setBackground(new Color(255, 0 , 0, 40));
		if(this.field instanceof JTextArea || this.field instanceof JTextField || this.field instanceof JPasswordField)
			this.field.setBorder(new LineBorder(new Color(255, 0 , 0, 100)));

		status.revalidate();
	}

	/**
	 * Display the field as invalid with orange color, orange icon and reason in tooltip
	 * @param arg true to make the row appear with a warning; false otherwise
	 * @param reason the reason of the warning
	 */
	public void setWarning(String reason) {
		try {
			status.setIcon(new ImageIcon(getClass().getResource("/icon/warning_mini.png")));
		} catch (Exception e) {}

		status.setToolTipText(reason);
		field.setBackground(new Color(255, 127, 0, 40));
		if(this.field instanceof JTextArea || this.field instanceof JTextField || this.field instanceof JPasswordField)
			this.field.setBorder(new LineBorder(new Color(255, 127, 0, 100)));

		status.revalidate();
	}

	/**
	 * 
	 */
	public void setCorrect() {
		status.setToolTipText("");
		status.setIcon(null);
		field.setBackground(Color.WHITE);
		if(this.field instanceof JTextArea || this.field instanceof JTextField || this.field instanceof JPasswordField)
			this.field.setBorder(new LineBorder(new Color(0, 0, 0, 50)));
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