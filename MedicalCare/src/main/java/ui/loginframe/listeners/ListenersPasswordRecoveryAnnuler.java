/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.loginframe.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.Main;
import ui.loginframe.LoginFrame;

/**
 *
 * @author Julien_Lavigne
 */
public class ListenersPasswordRecoveryAnnuler implements ActionListener {
    
    private LoginFrame interf;
    public ListenersPasswordRecoveryAnnuler(LoginFrame interf)
    {
        this.interf=interf;
    }
    
    
    
    public void actionPerformed(ActionEvent e)
	{
		interf.changeToLogin();
	}
    
}
