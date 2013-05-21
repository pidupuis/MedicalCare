package ui.dailysheetfilling.listeners;

import javax.swing.JTextField;
import ui.form.StatusField;
import ui.form.StatusFieldEnum;

public class CheckPresDias{
	
	public StatusField check(JTextField presDias) {
		String content = presDias.getText();
		
		int cpt = content.length();
		
		if (cpt < 4) {			
			try {
				int errorTry = Integer.valueOf(content);
				
				System.out.println(errorTry);
				
				if (errorTry<30 || errorTry>250) 
					return new StatusField(StatusFieldEnum.error, "La valeur de pression diastolique est invalide.");
				else if (errorTry<60 || errorTry > 80) 
					return new StatusField(StatusFieldEnum.warning, "Veuillez noter que la valeur de pression diastolique indiquée "+
							"est hors norme sans pour autant être impossible. La saisie sera validée telle quelle.");
				else
					return new StatusField(StatusFieldEnum.correct, "");
			} 
			catch (Exception e2) {
				return new StatusField(StatusFieldEnum.error, "La saisie de la valeur de pression diastolique contient des lettres"+
						" ou caractères interdits.");
			}
		}
		else return new StatusField(StatusFieldEnum.error, "La valeur de pression diastolique est invalide.");
	}
}