package ui.dailysheetfilling;

import java.util.ArrayList;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import persons.Patient;
import ui.dailysheetfilling.listeners.PatientChanging;

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

	private ArrayList<Patient> myPatients;
	
	/**
	 * Create the panel.
	 */
	public FormPanel(ArrayList<Patient> myPatients) {
		
		this.myPatients = myPatients;
		
		setLayout(new MigLayout("", "[][][][grow][]", "[][][][][][][][][][][][][][][][]"));
		
		header_name_lbl = new JLabel(myPatients.get(0).getLastName() + " " + myPatients.get(0).getFirstName());
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
		
		suivant_btn = new JButton("Suivant >");
		suivant_btn.addActionListener(new PatientChanging(this));
		add(suivant_btn, "cell 4 15");

	}

	public JLabel getHeader_name_lbl() {
		return header_name_lbl;
	}

	public void setHeader_name_lbl(String str) {
		this.header_name_lbl.setText(str);
	}

	public JTextField getLot_number_txf() {
		return lot_number_txf;
	}

	public void setLot_number_txf(JTextField lot_number_txf) {
		this.lot_number_txf = lot_number_txf;
	}

	public JTextField getRoom_number_txf() {
		return room_number_txf;
	}

	public void setRoom_number_txf(JTextField room_number_txf) {
		this.room_number_txf = room_number_txf;
	}

	public JTextField getPres_sys_txf() {
		return pres_sys_txf;
	}

	public void setPres_sys_txf(JTextField pres_sys_txf) {
		this.pres_sys_txf = pres_sys_txf;
	}

	public JTextField getPres_dyas_txf() {
		return pres_dyas_txf;
	}

	public void setPres_dyas_txf(JTextField pres_dyas_txf) {
		this.pres_dyas_txf = pres_dyas_txf;
	}

	public JTextField getBat_txf() {
		return bat_txf;
	}

	public void setBat_txf(JTextField bat_txf) {
		this.bat_txf = bat_txf;
	}

	public JTextField getObs_txf() {
		return obs_txf;
	}

	public void setObs_txf(JTextField obs_txf) {
		this.obs_txf = obs_txf;
	}

	public JLabel getWarning_lbl() {
		return warning_lbl;
	}

	public void setWarning_lbl(JLabel warning_lbl) {
		this.warning_lbl = warning_lbl;
	}

	public JButton getSuivant_btn() {
		return suivant_btn;
	}

	public void setSuivant_btn(JButton suivant_btn) {
		this.suivant_btn = suivant_btn;
	}

	public ArrayList<Patient> getMyPatients() {
		return myPatients;
	}

	public void setMyPatients(ArrayList<Patient> myPatients) {
		this.myPatients = myPatients;
	}

}
