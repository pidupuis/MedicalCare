package ui.dailysheetfilling;

import java.util.ArrayList;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import persons.Patient;

public class FormPanel extends JPanel {
	
	private JTextField lot_number_txf;
	private JTextField room_number_txf;
	private JTextField pres_sys_txf;
	private JTextField pres_dyas_txf;
	private JTextField bat_txf;
	private JTextField obs_txf;
	
	private JLabel header_name_lbl;
	private JLabel lot_number_lbl;
	private JLabel room_number_lbl;
	private JLabel pres_sys_lbl;
	private JLabel pres_dyas_lbl;
	private JLabel bat_lbl;
	private JLabel obs_lbl;
	private JLabel warning_lbl;
	
	private JButton suivant_btn;

	
	/**
	 * Create the panel.
	 */
	public FormPanel(ArrayList<Patient> myPatients) {
		setLayout(new MigLayout("", "[][][][grow][]", "[][][][][][][][][][][][][][][][]"));
		
		header_name_lbl = new JLabel("NOM Prenom");
		add(header_name_lbl, "cell 3 0");
		
		warning_lbl = new JLabel("warning_message");
		add(warning_lbl, "cell 3 2");
		warning_lbl.setVisible(false);
		
		lot_number_lbl = new JLabel("Numéro de Lot :");
		add(lot_number_lbl, "cell 0 3");
		
		lot_number_txf = new JTextField();
		add(lot_number_txf, "cell 3 3,growx");
		lot_number_txf.setColumns(10);
		
		room_number_lbl = new JLabel("Numéro de chambre :");
		add(room_number_lbl, "cell 0 5");
		
		room_number_txf = new JTextField();
		add(room_number_txf, "cell 3 5,growx");
		room_number_txf.setColumns(10);
		
		JLabel pres_sys_lbl = new JLabel("Pression Systolique :");
		add(pres_sys_lbl, "cell 0 7");
		
		pres_sys_txf = new JTextField();
		add(pres_sys_txf, "cell 3 7,growx");
		pres_sys_txf.setColumns(10);
		
		JLabel pres_dyas_lbl = new JLabel("Pression Dyastolique :");
		add(pres_dyas_lbl, "cell 0 9");
		
		pres_dyas_txf = new JTextField();
		add(pres_dyas_txf, "cell 3 9,growx");
		pres_dyas_txf.setColumns(10);
		
		JLabel bat_lbl = new JLabel("Battements par min :");
		add(bat_lbl, "cell 0 11");
		
		bat_txf = new JTextField();
		add(bat_txf, "cell 3 11,growx");
		bat_txf.setColumns(10);
		
		JLabel obs_lbl = new JLabel("Observations :");
		add(obs_lbl, "cell 0 13");
		
		obs_txf = new JTextField();
		add(obs_txf, "cell 3 13,growx");
		obs_txf.setColumns(10);
		
		suivant_btn = new JButton("Suivant");
		add(suivant_btn, "cell 4 15");

	}

}
