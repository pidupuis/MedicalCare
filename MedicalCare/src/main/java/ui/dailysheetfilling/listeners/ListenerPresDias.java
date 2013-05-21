package ui.dailysheetfilling.listeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import ui.dailysheetfilling.FormPanel;

public class ListenerPresDias implements FocusListener, ActionListener {

	
	private FormPanel fp;
	
	public ListenerPresDias(FormPanel fp) {
		this.fp = fp;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String content = fp.getPres_dias_txf().getText();
		
		int cpt = content.length();
		
		if (cpt < 4)
		{
						
			try {
				int errorTry = Integer.valueOf(content);
				
				System.out.println(errorTry);
				
				if (errorTry<30 || errorTry>250){
					throw new Exception();
				}
				else if (errorTry<60 || errorTry > 80)
				{
					fp.getPres_dias_txf().setBackground(Color.ORANGE);
					fp.getWarning_lbl().setVisible(false);
					fp.getSuivant_btn().setEnabled(true);
				}
				else {
					fp.getPres_dias_txf().setBackground(Color.WHITE);
					fp.getWarning_lbl().setVisible(false);
					fp.getSuivant_btn().setEnabled(true);
				}
			} catch (Exception e1) {
				fp.setCorrect(2, false);
				fp.getPres_dias_txf().setBackground(Color.RED);
				fp.getWarning_lbl().setVisible(true);
				fp.getWarning_lbl().setMessage("Cette saisie contient des lettres ou caractères interdits");
				fp.getSuivant_btn().setEnabled(false);			
			}
		}
		else
		{
			fp.setCorrect(2, false);
			fp.getPres_dias_txf().setBackground(Color.RED);
			fp.getWarning_lbl().setVisible(true);
			fp.getWarning_lbl().setMessage("La valeur de pression systolique est invalide");
			fp.getSuivant_btn().setEnabled(false);
		}
		
	}	


	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void focusLost(FocusEvent e) {
		
		String content = fp.getPres_dias_txf().getText();
		
		int cpt = content.length();
		
		if (cpt < 4)
		{
						
			try {
				int errorTry = Integer.valueOf(content);
				
				System.out.println(errorTry);
				
				if (errorTry<30 || errorTry>250){
					throw new Exception();
				}
				else if (errorTry<60 || errorTry > 80)
				{
					fp.getPres_dias_txf().setBackground(Color.ORANGE);
					fp.getWarning_lbl().setVisible(false);
					fp.getSuivant_btn().setEnabled(true);
				}
				else {
					fp.getPres_dias_txf().setBackground(Color.WHITE);
					fp.getWarning_lbl().setVisible(false);
					fp.getSuivant_btn().setEnabled(true);
				}
			} catch (Exception e1) {
				fp.setCorrect(2, false);
				fp.getPres_dias_txf().setBackground(Color.RED);
				fp.getWarning_lbl().setVisible(true);
				fp.getWarning_lbl().setMessage("Cette saisie contient des lettres ou caractères interdits");
				fp.getSuivant_btn().setEnabled(false);			
			}
		}
		else
		{
			fp.setCorrect(2, false);
			fp.getPres_dias_txf().setBackground(Color.RED);
			fp.getWarning_lbl().setVisible(true);
			fp.getWarning_lbl().setMessage("La valeur de pression systolique est invalide");
			fp.getSuivant_btn().setEnabled(false);
		}
		
	}	

		
}

