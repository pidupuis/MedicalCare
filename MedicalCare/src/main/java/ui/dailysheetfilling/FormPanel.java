package ui.dailysheetfilling;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTree;
import ui.dailysheetfilling.listeners.ListenerLotNumber;
import ui.dailysheetfilling.listeners.ListenerPresSys;
import ui.dailysheetfilling.listeners.PatientChanging;
import ui.loginframe.panels.ErrorPane;

import javax.swing.SwingConstants;

public class FormPanel extends JPanel {
<<<<<<< HEAD

=======
	
>>>>>>> branch 'develop' of https://github.com/pidupuis/MedicalCare.git
	private static final long serialVersionUID = 1L;
	private JTextField lot_number_txf;
	private JTextField room_number_txf;
	private JTextField pres_sys_txf;
	private JTextField pres_dyas_txf;
	private JTextField bat_txf;

	private JTextArea obs_txf;

	private JLabel header_name_lbl;
	private JLabel lot_number_lbl;
	private JLabel room_number_lbl;
	private JLabel pres_sys_lbl;
	private JLabel pres_dyas_lbl;
	private JLabel bat_lbl;
	private JLabel obs_lbl;
	private ErrorPane warning_lbl;

	private JButton suivant_btn;

	private ArrayList<PatientNode> myPatientNodes;
	
	private ArrayList<Boolean> correct;

	/**
	 * Create the panel.
	 */
	public FormPanel(JTree myTree) {

		this.correct = new ArrayList<Boolean>();
		for (int i = 0; i < 4; i++)
			this.correct.add(false);
		
		// TODO : remove it when listeners will be implemented
		this.correct.set(2, true);
		this.correct.set(3, true);
		
		setLayout(new MigLayout("", "[][][][grow][]", "[][][][][][][][][][][][][][][][]"));

		this.myPatientNodes = new ArrayList<PatientNode>();

		for (int i=0; i< myTree.getModel().getChildCount(myTree.getModel().getRoot()); i++) {
			this.myPatientNodes.add((PatientNode) ((PatientNode) myTree.getModel().getRoot()).getChildAt(i));
		}

		header_name_lbl = new JLabel(myPatientNodes.get(0).getMyPatient().getLastName() + " " + myPatientNodes.get(0).getMyPatient().getFirstName());
		add(header_name_lbl, "cell 3 0");

		warning_lbl = new ErrorPane();//
		warning_lbl.setErrorMessage("warning_message");
		//warning_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		add(warning_lbl, "cell 0 2 4 1");
		warning_lbl.setVisible(false);

		lot_number_lbl = new JLabel("Numéro de Lot :");
		add(lot_number_lbl, "cell 0 3");

		lot_number_txf = new JTextField();
		add(lot_number_txf, "cell 3 3,growx");
		lot_number_txf.addActionListener(new ListenerLotNumber(this));
		lot_number_txf.addFocusListener(new ListenerLotNumber(this));
		lot_number_txf.setColumns(10);

		room_number_lbl = new JLabel("Numéro de chambre :");
		add(room_number_lbl, "cell 0 5");

		room_number_txf = new JTextField();
		add(room_number_txf, "cell 3 5,growx");
		room_number_txf.setColumns(10);

		JLabel pres_sys_lbl = new JLabel("Pression Systolique :");
		add(pres_sys_lbl, "cell 0 7");

		pres_sys_txf = new JTextField();
		pres_sys_txf.addActionListener(new ListenerPresSys(this));
		pres_sys_txf.addFocusListener(new ListenerPresSys(this));
		add(pres_sys_txf, "cell 3 7,growx");
		pres_sys_txf.setColumns(10);

		JLabel pres_dyas_lbl = new JLabel("Pression Diastolique :");
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

		obs_txf = new JTextArea(10, 10);
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

	public JTextArea getObs_txf() {
		return obs_txf;
	}

	public void setObs_txf(JTextArea obs_txf) {
		this.obs_txf = obs_txf;
	}

	public ErrorPane getWarning_lbl() {
		return warning_lbl;
	}

	/*public void setWarning_lbl(JLabel warning_lbl) {
		this.warning_lbl = warning_lbl;
	}*/

	public JButton getSuivant_btn() {
		return suivant_btn;
	}

	public void setSuivant_btn(JButton suivant_btn) {
		this.suivant_btn = suivant_btn;
	}

	public ArrayList<PatientNode> getMyPatientNodes() {
		return myPatientNodes;
	}

	public void setMyPatientNodes(ArrayList<PatientNode> myPatientNodes) {
		this.myPatientNodes = myPatientNodes;
	}

	public void setCorrect(int index, boolean correct) {
		this.correct.set(index, correct);
	}
	
	public void cleanCorrect() {
		for (int i = 0; i < 4; i++)
			this.correct.set(i, false);
		
		// TODO : remove it when listeners will be implemented
		this.correct.set(2, true);
		this.correct.set(3, true);
	}
	
	public boolean isCorrect() {
		for (Boolean b : this.correct) {
			if (!b)
				return false; 
		}
		return true;
	}
	
	public void cleanPanel() {
		this.lot_number_txf.setText("");
		this.room_number_txf.setText("");
		this.pres_sys_txf.setText("");
		this.pres_dyas_txf.setText("");
		this.bat_txf.setText("");
		
		this.lot_number_txf.setBackground(Color.white);
		this.room_number_txf.setBackground(Color.white);
		this.pres_sys_txf.setBackground(Color.white);
		this.pres_dyas_txf.setBackground(Color.white);
		this.bat_txf.setBackground(Color.white);
	}
	
	
	
}
