package ui.form;

import java.awt.Color;
import java.awt.Font;
import java.lang.reflect.Method;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.TextUI;
import javax.swing.plaf.basic.BasicPasswordFieldUI;
import javax.swing.plaf.basic.BasicTextAreaUI;
import javax.swing.plaf.basic.BasicTextFieldUI;

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
	
	private Border defaultBorder;
	private Border errorBorder;
	private Border warningBorder;
	private boolean stylable;

	/**
	 * Constructs a form row with a label and a field.
	 * @param label A label that can be any type of swing JComponent
	 * @param field A field that can be any type of swing JComponent
	 */
	public FormRow(L label, final F field) {
		this.label = label;
		this.field = field;
		this.status = new JLabel();
		
		this.defaultBorder = new CompoundBorder(new LineBorder(new Color(0,0,0, 50)), new EmptyBorder(0, 5, 0, 5));
		this.errorBorder = new CompoundBorder(new LineBorder(new Color(255, 0 , 0, 100)), new EmptyBorder(0, 5, 0, 5));
		this.warningBorder = new CompoundBorder(new LineBorder(new Color(255, 127, 0, 100)), new EmptyBorder(0, 5, 0, 5));

		setLayout(new MigLayout("hidemode 3, inset 0 20 10 20", "[140px:n][grow][28px:28px:28px]", "[30px,grow]"));
		
		this.field.setBackground(Color.WHITE);
		
		//Change field to raw white background and simple border
		Class<?> fieldClass = this.field.getClass();
		try {
			Method getUI = fieldClass.getMethod("getUI");
			Object ui = getUI.invoke(this.field);
			if(ui instanceof TextUI) {
	            this.field.setBorder(defaultBorder);
	            this.stylable = true;
	            if(this.field instanceof JPasswordField)
	            	((JPasswordField)this.field).setUI(new BasicPasswordFieldUI());
	            else if(this.field instanceof JTextField)
	            	((JTextField)this.field).setUI(new BasicTextFieldUI());
	            else if(this.field instanceof JTextArea) 
	    			((JTextArea)this.field).setUI(new BasicTextAreaUI());
			}
		} catch (Exception e) {}

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
	 * Display the field as invalid with red color, error icon and reason in a tool tip
	 * @param arg true to make the row appear with error; false otherwise
	 * @param reason the reason of the error
	 */
	public void setError(String reason) {
		try {
			status.setIcon(new ImageIcon(getClass().getResource("/icon/error_mini.png")));
		} catch (Exception e) { }
		status.setToolTipText(reason);
		field.setBackground(new Color(244, 203, 203));
		if(stylable) this.field.setBorder(errorBorder);

		status.revalidate();
	}

	/**
	 * Display the field as invalid with orange color, orange icon and reason in a tool tip
	 * @param arg true to make the row appear with a warning; false otherwise
	 * @param reason the reason of the warning
	 */
	public void setWarning(String reason) {
		try {
			status.setIcon(new ImageIcon(getClass().getResource("/icon/warning_mini.png")));
		} catch (Exception e) {}

		status.setToolTipText(reason);
		field.setBackground(new Color(255, 234, 215));
		if(stylable) this.field.setBorder(warningBorder);

		status.revalidate();
	}

	/**
	 * Clears errors and warnings making the field appear like default
	 */
	public void setCorrect() {
		status.setToolTipText("");
		status.setIcon(null);
		field.setBackground(Color.WHITE);
		if(stylable) this.field.setBorder(defaultBorder);
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
