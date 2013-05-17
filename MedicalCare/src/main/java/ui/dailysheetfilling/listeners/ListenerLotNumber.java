package ui.dailysheetfilling.listeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import ui.dailysheetfilling.FormPanel;

public class ListenerLotNumber implements ActionListener {
	
	private FormPanel fp;

	public ListenerLotNumber(FormPanel fp) {
		this.fp = fp;
	}

	public void actionPerformed(ActionEvent e) {
		
		String content = fp.getLot_number_txf().getText();
		int cpt = content.length();
		
		if (cpt == 5)
		{
			try {
				int errorTry = Integer.valueOf(content);
				fp.setAlert(true);
				fp.getLot_number_txf().setBackground(Color.WHITE);
				fp.getWarning_lbl().setVisible(false);
				fp.getSuivant_btn().setEnabled(true);
			} catch (Exception e1) {
				fp.setAlert(false);
				fp.getLot_number_txf().setBackground(Color.RED);
				fp.getWarning_lbl().setVisible(true);
				fp.getWarning_lbl().setText("Cette saisie contient des lettres ou caractères interdits");
				fp.getSuivant_btn().setEnabled(false);			
			}
		}
		else
		{
			fp.setAlert(false);
			fp.getLot_number_txf().setBackground(Color.RED);
			fp.getWarning_lbl().setVisible(true);
			fp.getWarning_lbl().setText("La valeur du champ Numéro de Lot est invalide");
			fp.getSuivant_btn().setEnabled(false);
		}
		
	}
	

}
