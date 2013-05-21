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
import ui.MessagePane;
import ui.dailysheetfilling.listeners.ListenerBattCard;
import ui.dailysheetfilling.listeners.ListenerLotNumber;
import ui.dailysheetfilling.listeners.ListenerPresDias;
import ui.dailysheetfilling.listeners.ListenerPresSys;
import ui.dailysheetfilling.listeners.PatientChanging;
import ui.loginframe.FormRow;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class FormPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private FormRow<JLabel, JTextField>  lot_number;
	private FormRow<JLabel, JTextField>  pres_sys;
	private FormRow<JLabel, JTextField>  pres_dias;
	private FormRow<JLabel, JTextField>  bat;
	private FormRow<JLabel, JTextArea>  obs;

	private JTextField lot_number_txf;
	private JTextField pres_sys_txf;
	private JTextField pres_dias_txf;
	private JTextField bat_txf;

	private JTextArea obs_txf;

	private JLabel header_name_lbl;
	private JLabel lot_number_lbl;
	private JLabel pres_sys_lbl;
	private JLabel pres_dias_lbl;
	private JLabel bat_lbl;
	private JLabel obs_lbl;
	private MessagePane warning_lbl;

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

		setLayout(new MigLayout("hidemode 3, inset 0 0 0 0", "[][][][grow]", "[][][][][][][100px:n][]"));

		this.myPatientNodes = new ArrayList<PatientNode>();

		for (int i=0; i< myTree.getModel().getChildCount(myTree.getModel().getRoot()); i++) {
			this.myPatientNodes.add((PatientNode) ((PatientNode) myTree.getModel().getRoot()).getChildAt(i));
		}

		header_name_lbl = new JLabel(myPatientNodes.get(0).getMyPatient().getLastName() + " " + myPatientNodes.get(0).getMyPatient().getFirstName());
		add(header_name_lbl, "cell 3 0");

		{
			warning_lbl = new MessagePane();//
			warning_lbl.setErrorDisplayed(false);
			warning_lbl.setInfoMessage("Veuillez remplir l'intégralité du formulaire ci-dessous");
			add(warning_lbl, "cell 0 1 4 1,growx");
			warning_lbl.setVisible(true);
		}

		{
			lot_number_lbl = new JLabel("Numéro de Lot :");
			lot_number_txf = new JTextField();
			lot_number = new FormRow<JLabel, JTextField>(lot_number_lbl, lot_number_txf);
			add(lot_number, "cell 0 2 4 1,grow");

			lot_number_txf.addActionListener(new ListenerLotNumber(this));
			lot_number_txf.addFocusListener(new ListenerLotNumber(this));
			lot_number_txf.setColumns(10);
		}

		{
			JLabel pres_sys_lbl = new JLabel("Pression Systolique :");

			pres_sys_txf = new JTextField();
			pres_sys_txf.addActionListener(new ListenerPresSys(this));
			pres_sys_txf.addFocusListener(new ListenerPresSys(this));
			pres_sys_txf.setColumns(10);
			pres_sys =  new FormRow<JLabel, JTextField>(pres_sys_lbl, pres_sys_txf);
			add(pres_sys, "cell 0 3 4 1,grow");
		}

		{
			JLabel pres_dias_lbl = new JLabel("Pression Diastolique :");

			pres_dias_txf = new JTextField();
			pres_dias_txf.addActionListener(new ListenerPresDias(this));
			pres_dias_txf.addFocusListener(new ListenerPresDias(this));
			pres_dias_txf.setColumns(10);

			pres_dias =  new FormRow<JLabel, JTextField>(pres_dias_lbl, pres_dias_txf);
			add(pres_dias, "cell 0 4 4 1,grow");
		}

		{
			JLabel bat_lbl = new JLabel("Battements par min :");

			bat_txf = new JTextField();
			pres_dias_txf.addActionListener(new ListenerBattCard(this));
			pres_dias_txf.addFocusListener(new ListenerBattCard(this));
			bat_txf.setColumns(10);
			
			bat =  new FormRow<JLabel, JTextField>(bat_lbl, bat_txf);
			add(bat, "cell 0 5 4 1,grow");
		}

		{
			JLabel obs_lbl = new JLabel("Observations :");

			obs_txf = new JTextArea(30, 10);
			obs_txf.setColumns(10);
			obs_txf.setBorder(new LineBorder(new Color(0,0,0, 50)));
			
			obs =  new FormRow<JLabel, JTextArea>(obs_lbl, obs_txf);
			add(obs, "cell 0 6 4 1,grow");
		}

		{
			suivant_btn = new JButton("Suivant >");
			suivant_btn.addActionListener(new PatientChanging(this));
			add(suivant_btn, "cell 0 7 4 1,alignx right");
		}

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

	public JTextField getPres_sys_txf() {
		return pres_sys_txf;
	}

	public void setPres_sys_txf(JTextField pres_sys_txf) {
		this.pres_sys_txf = pres_sys_txf;
	}

	public JTextField getPres_dias_txf() {
		return pres_dias_txf;
	}

	public void setPres_dias_txf(JTextField pres_dyas_txf) {
		this.pres_dias_txf = pres_dyas_txf;
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

	public MessagePane getWarning_lbl() {
		return warning_lbl;
	}

	public void setWarning_lbl(MessagePane message) {
		this.warning_lbl = message;
	}

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
		this.pres_sys_txf.setText("");
		this.pres_dias_txf.setText("");
		this.bat_txf.setText("");

		this.lot_number_txf.setBackground(Color.white);
		this.pres_sys_txf.setBackground(Color.white);
		this.pres_dias_txf.setBackground(Color.white);
		this.bat_txf.setBackground(Color.white);
	}



}
