package ui.dailysheetfilling.listeners;

import javax.swing.JTextField;
import ui.form.StatusField;
import ui.form.StatusFieldEnum;

public class ListenerBattCard {

	public StatusField check(JTextField bat) {
		String content = bat.getText();
		
		int cpt = content.length();
		
		if (cpt < 4) {			
			try {
				int errorTry = Integer.valueOf(content);
				
				System.out.println(errorTry);
				
				if (errorTry<0 || errorTry>300) 
					return new StatusField(StatusFieldEnum.error, "La valeur du rythme cardiaque est invalide.");
				else if (errorTry<25 || errorTry > 220) 
					return new StatusField(StatusFieldEnum.warning, "Veuillez noter que la valeur du rythme cardiaque indiquée "+
							"est hors norme sans pour autant être impossible. La saisie sera validée telle quelle.");
				else
					return new StatusField(StatusFieldEnum.correct, "");
			} 
			catch (Exception e2) {
				return new StatusField(StatusFieldEnum.error, "La saisie de la valeur du rythme cardiaque contient des lettres"+
						" ou caractères interdits.");
			}
		}
		else return new StatusField(StatusFieldEnum.error, "La valeur du rythme cardiaque est invalide.");
	}	
}

