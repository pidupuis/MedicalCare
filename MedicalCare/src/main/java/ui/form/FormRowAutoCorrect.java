package ui.form;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JComponent;

public abstract class FormRowAutoCorrect<L extends JComponent, F extends JComponent> extends FormRow<L, F> {

	private static final long serialVersionUID = 1L;

	public FormRowAutoCorrect(L label, F field) {
		super(label, field);
		field.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
				StatusField s = check();
				switch (s.getStatus()) {
				case correct:
					setCorrect();
					break;
				case warning:
					setWarning(s.getReason());
					break;
				case error:
					setError(s.getReason());
					break;
				}
			}

			public void focusGained(FocusEvent e) {
				setCorrect();
			}
		});
	}

	public abstract StatusField check();
}
