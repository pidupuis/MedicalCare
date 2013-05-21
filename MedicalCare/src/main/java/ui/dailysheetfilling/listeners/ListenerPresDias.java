package ui.dailysheetfilling.listeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.naming.directory.InvalidAttributeValueException;

import ui.dailysheetfilling.FormPanel;

public class ListenerPresDias implements FocusListener, ActionListener {

	
	private FormPanel fp;
	
	public ListenerPresDias(FormPanel fp) {
		this.fp = fp;
	}
	
	public void actionPerformed(ActionEvent e) {
		listenerTreatment();		
	}	

	public void focusGained(FocusEvent e) {
		if (!fp.getPres_dias_txf().getText().equalsIgnoreCase("")) {
			PatientChanging test = new PatientChanging(fp);
			test.actionPerformed(null);
		}
	}

	public void focusLost(FocusEvent e) {
		listenerTreatment();
	}
	
	public void listenerTreatment() {
		String content = fp.getPres_sys_txf().getText();
		
		int cpt = content.length();
		
		if (cpt < 4)
		{
						
			try {
				int errorTry = Integer.valueOf(content);
				
				System.out.println(errorTry);
				
				if (errorTry<30 || errorTry>250){
					throw new InvalidAttributeValueException();
				}
				else if (errorTry<60 || errorTry > 80)
				{
					if (!fp.getWarning_lbl().isErrorDisplayed())
						displayWarning("Veuillez noter que la valeur de la pression systolique indiquée est hors norme sans pour autant être impossible. La saisie sera validée telle quelle.");
				}
				else {
					displayInfo("Veuillez remplir l'intégralité du formulaire ci-dessous");
				}
			}
			catch (InvalidAttributeValueException e1) {
				if (!fp.getWarning_lbl().isErrorDisplayed())
					displayError("La valeur de pression diastolique est invalide");
			}
			catch (Exception e2) {
				if (!fp.getWarning_lbl().isErrorDisplayed())
					displayError("La saisie de la valeur de pression diastolique contient des lettres ou caractères interdits");		
			}
		}
		else
		{
			if (!fp.getWarning_lbl().isErrorDisplayed())
				displayError("La valeur de pression diastolique est invalide");
		}
	}
		
	public void displayError(String message) {
		fp.setCorrect(2, false);
		fp.getPres_dias_txf().setBackground(Color.RED);
		fp.getWarning_lbl().setErrorMessage(message);
		fp.getWarning_lbl().setErrorDisplayed(true);
		fp.getSuivant_btn().setEnabled(false);
		fp.repaint();
	}
	
	public void displayWarning(String message) {
		fp.getPres_dias_txf().setBackground(Color.ORANGE);
		fp.getWarning_lbl().setWarningMessage(message);
		fp.getWarning_lbl().setErrorDisplayed(false);
		fp.getSuivant_btn().setEnabled(true);
		fp.repaint();
	}
	
	public void displayInfo(String message) {
		fp.getPres_dias_txf().setBackground(Color.WHITE);
		fp.getWarning_lbl().setInfoMessage(message);
		fp.getWarning_lbl().setErrorDisplayed(false);
		fp.getSuivant_btn().setEnabled(true);
		fp.repaint();
	}

		
}

