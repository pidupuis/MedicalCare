package ui.dailysheetfilling.listeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import ui.dailysheetfilling.FormPanel;

public class ListenerLotNumber implements ActionListener, FocusListener {
	
	private FormPanel fp; // This is the form Panel 

	/**
	 * 
	 * @param fp the form panel to have access at all buttons and textfield
	 */
	public ListenerLotNumber(FormPanel fp) {
		this.fp = fp;
	}

	public void actionPerformed(ActionEvent e) {
		listenerTreatment();		
	}	

	public void focusGained(FocusEvent e) {
		if (!fp.getLot_number_txf().getText().equalsIgnoreCase("")) {
			PatientChanging test = new PatientChanging(fp);
			test.actionPerformed(null);
		}
	}

	public void focusLost(FocusEvent e) {
		listenerTreatment();
	}
	
	public void listenerTreatment() {
		String content = fp.getLot_number_txf().getText();
		int cpt = content.length();
		
		if (cpt == 6)
		{
			try {
				int errorTry = Integer.valueOf(content);
				
				displayInfo("Veuillez remplir l'intégralité du formulaire ci-dessous");
			} catch (Exception e1) {
				if (!fp.getWarning_lbl().isErrorDisplayed())
					displayError("La saisie du numéro de lot contient des lettres ou caractères interdits");
			}
		}
		else
		{
			if (!fp.getWarning_lbl().isErrorDisplayed())
				displayError("La valeur du champ Numéro de Lot est invalide");
		}
	}
	
	public void displayError(String message) {
		fp.setCorrect(0, false);
		fp.getLot_number_txf().setBackground(Color.RED);
		fp.getWarning_lbl().setErrorMessage(message);
		fp.getWarning_lbl().setErrorDisplayed(true);
		fp.getSuivant_btn().setEnabled(false);
		fp.repaint();
	}
	
	public void displayInfo(String message) {
		fp.setCorrect(0, true);
		fp.getLot_number_txf().setBackground(Color.WHITE);
		fp.getWarning_lbl().setInfoMessage(message);
		fp.getWarning_lbl().setErrorDisplayed(false);
		fp.getSuivant_btn().setEnabled(true);
		fp.repaint();
	}

}
