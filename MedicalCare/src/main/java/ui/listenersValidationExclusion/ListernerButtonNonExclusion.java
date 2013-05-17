/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.listenersValidationExclusion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import main.Main;
import persons.CRA;
import persons.Patient;
import ui.ValidationExclusion;

/**
 *
 * @author piotr
 */
public class ListernerButtonNonExclusion implements ActionListener {

    private ValidationExclusion interf;
    private Patient pat;

    public ListernerButtonNonExclusion(ValidationExclusion interf, Patient pat) {
        this.interf = interf;
        this.pat = pat;
    }

    public void actionPerformed(ActionEvent e) {
        String why = JOptionPane.showInputDialog(interf, "Pourquoi ne pas exclure " + this.pat.getFirstName() + " " + this.pat.getLastName(), "Raison de la non exclusion");
        ((CRA) Main.getUser()).remove(pat);
    }
}
