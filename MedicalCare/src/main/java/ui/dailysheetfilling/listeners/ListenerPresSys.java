package ui.dailysheetfilling.listeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.naming.directory.InvalidAttributeValueException;

import ui.dailysheetfilling.FormPanel;

public class ListenerPresSys implements ActionListener, FocusListener {
	
	private FormPanel fp;
	
	public ListenerPresSys(FormPanel fp) {
		this.fp = fp;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String content = fp.getPres_sys_txf().getText();
		
		int cpt = content.length();
		
		if (cpt < 4)
		{
						
			try {
				int errorTry = Integer.valueOf(content);
				
				System.out.println(errorTry);
				
				if (errorTry<30 || errorTry>300){
					throw new Exception();
				}
				else if (errorTry<60 || errorTry > 140)
				{
					fp.getPres_sys_txf().setBackground(Color.ORANGE);
					fp.getWarning_lbl().setVisible(false);
					fp.getSuivant_btn().setEnabled(true);
				}
				else {
					fp.getPres_sys_txf().setBackground(Color.WHITE);
					fp.getWarning_lbl().setVisible(false);
					fp.getSuivant_btn().setEnabled(true);
				}
			} catch (Exception e1) {
				fp.setCorrect(1, false);
				fp.getPres_sys_txf().setBackground(Color.RED);
				fp.getWarning_lbl().setVisible(true);
				fp.getWarning_lbl().setErrorMessage("Cette saisie contient des lettres ou caractères interdits");
				fp.getSuivant_btn().setEnabled(false);			
			}
		}
		else
		{
			fp.setCorrect(1, false);
			fp.getPres_sys_txf().setBackground(Color.RED);
			fp.getWarning_lbl().setVisible(true);
			fp.getWarning_lbl().setErrorMessage("La valeur de pression systolique est invalide");
			fp.getSuivant_btn().setEnabled(false);
		}
		
	}	

	public void focusGained(FocusEvent e) {}

	public void focusLost(FocusEvent e) {
		
		String content = fp.getPres_sys_txf().getText();
		
		int cpt = content.length();
		
		if (cpt < 4)
		{
						
			try {
				int errorTry = Integer.valueOf(content);
				
				System.out.println(errorTry);
				
				if (errorTry<30 || errorTry>300){
					throw new InvalidAttributeValueException();
				}
				else if (errorTry<60 || errorTry > 140)
				{
					fp.setCorrect(1, true);
					fp.getPres_sys_txf().setBackground(Color.ORANGE);
					fp.getWarning_lbl().setVisible(false);
					fp.getSuivant_btn().setEnabled(true);
				}
				else {
					fp.setCorrect(1, true);
					fp.getPres_sys_txf().setBackground(Color.WHITE);
					fp.getWarning_lbl().setVisible(false);
					fp.getSuivant_btn().setEnabled(true);
				}
			} 
			catch (InvalidAttributeValueException e1) {
				fp.setCorrect(1, false);
				fp.getPres_sys_txf().setBackground(Color.RED);
				fp.getWarning_lbl().setVisible(true);
				fp.getWarning_lbl().setErrorMessage("La valeur de pression systolique est invalide");
				fp.getSuivant_btn().setEnabled(false);	
			}
			catch (Exception e2) {
				fp.setCorrect(1, false);
				fp.getPres_sys_txf().setBackground(Color.RED);
				fp.getWarning_lbl().setVisible(true);
				fp.getWarning_lbl().setErrorMessage("Cette saisie contient des lettres ou caractères interdits");
				fp.getSuivant_btn().setEnabled(false);			
			}
		}
		else
		{
			fp.setCorrect(1, false);
			fp.getPres_sys_txf().setBackground(Color.RED);
			fp.getWarning_lbl().setVisible(true);
			fp.getWarning_lbl().setErrorMessage("La valeur de pression systolique est invalide");
			fp.getSuivant_btn().setEnabled(false);
		}
		
	}	
}