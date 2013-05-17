package ui.dailysheetfilling;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FormPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the panel.
	 */
	public FormPanel() {
		setLayout(new MigLayout("", "[][][][grow][]", "[][][][][][][][][][][][][][][][]"));
		
		JLabel lblClientname = new JLabel("NOM Prenom");
		add(lblClientname, "cell 3 0");
		
		JLabel lblNumlot = new JLabel("Numéro de Lot :");
		add(lblNumlot, "cell 0 3");
		
		textField = new JTextField();
		add(textField, "cell 3 3,growx");
		textField.setColumns(10);
		
		JLabel lblNumroom = new JLabel("Numéro de chambre :");
		add(lblNumroom, "cell 0 5");
		
		textField_1 = new JTextField();
		add(textField_1, "cell 3 5,growx");
		textField_1.setColumns(10);
		
		JLabel lblPressys = new JLabel("Pression Systolique :");
		add(lblPressys, "cell 0 7");
		
		textField_2 = new JTextField();
		add(textField_2, "cell 3 7,growx");
		textField_2.setColumns(10);
		
		JLabel lblPresdyast = new JLabel("Pression Dyastolique :");
		add(lblPresdyast, "cell 0 9");
		
		textField_3 = new JTextField();
		add(textField_3, "cell 3 9,growx");
		textField_3.setColumns(10);
		
		JLabel lblBattements = new JLabel("Battements par min :");
		add(lblBattements, "cell 0 11");
		
		textField_4 = new JTextField();
		add(textField_4, "cell 3 11,growx");
		textField_4.setColumns(10);
		
		JLabel lblObservations = new JLabel("Observations :");
		add(lblObservations, "cell 0 13");
		
		textField_5 = new JTextField();
		add(textField_5, "cell 3 13,growx");
		textField_5.setColumns(10);
		
		JButton btnSuivant = new JButton("Suivant :");
		add(btnSuivant, "cell 4 15");

	}

}
