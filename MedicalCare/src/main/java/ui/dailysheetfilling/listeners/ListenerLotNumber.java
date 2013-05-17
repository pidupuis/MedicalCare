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

	/**
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		
		String content = fp.getLot_number_txf().getText();
		int cpt = content.length();
		
		if (cpt == 6)
		{
			try {
				int errorTry = Integer.valueOf(content);
				
				fp.setCorrect(0, true);
				fp.getLot_number_txf().setBackground(Color.WHITE);
				fp.getWarning_lbl().setVisible(false);
				fp.getSuivant_btn().setEnabled(true);
			} catch (Exception e1) {
				fp.setCorrect(0, false);
				fp.getLot_number_txf().setBackground(Color.RED);
				fp.getWarning_lbl().setVisible(true);
				fp.getWarning_lbl().setErrorMessage("Cette saisie contient des lettres ou caractères interdits");
				fp.getSuivant_btn().setEnabled(false);			
			}
		}
		else
		{
			fp.setCorrect(0, false);
			fp.getLot_number_txf().setBackground(Color.RED);
			fp.getWarning_lbl().setVisible(true);
			fp.getWarning_lbl().setErrorMessage("La valeur du champ Numéro de Lot est invalide");
			fp.getSuivant_btn().setEnabled(false);
		}
		
	}

	public void focusLost(FocusEvent e) {
		
		String content = fp.getLot_number_txf().getText();
		int cpt = content.length();
		
		if (cpt == 6)
		{
			try {
				int errorTry = Integer.valueOf(content);
				
				fp.setCorrect(0, true);
				fp.getLot_number_txf().setBackground(Color.WHITE);
				fp.getWarning_lbl().setVisible(false);
				fp.getSuivant_btn().setEnabled(true);
			} catch (Exception e1) {
				fp.setCorrect(0, false);
				fp.getLot_number_txf().setBackground(Color.RED);
				fp.getWarning_lbl().setVisible(true);
				fp.getWarning_lbl().setErrorMessage("Cette saisie contient des lettres ou caractères interdits");
				fp.getSuivant_btn().setEnabled(false);			
			}
		}
		else
		{
			fp.setCorrect(0, false);
			fp.getLot_number_txf().setBackground(Color.RED);
			fp.getWarning_lbl().setVisible(true);
			fp.getWarning_lbl().setErrorMessage("La valeur du champ Numéro de Lot est invalide");
			fp.getSuivant_btn().setEnabled(false);
		}
		
	}

	public void focusGained(FocusEvent e) {
		
	}
	

}
