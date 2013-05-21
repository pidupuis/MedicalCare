package ui.dailysheetfilling.listeners;

import javax.swing.JTextField;
import ui.form.StatusField;
import ui.form.StatusFieldEnum;

public class CheckLotNumber {
	public StatusField check(JTextField lotNumber) {
		String content = lotNumber.getText();
		int cpt = content.length();

		if (cpt == 6) {
			try {
				Integer.valueOf(content);
				return new StatusField(StatusFieldEnum.correct, "");
			} catch (Exception e1) {
				return new StatusField(StatusFieldEnum.error, "La saisie du numéro de lot contient des lettres ou caractères interdits");
			}
		}
		else {
			return new StatusField(StatusFieldEnum.error, "La valeur du champ Numéro de Lot est invalide");
		}
	}
}
