/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.loginframe.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.loginframe.LoginFrame;

/**
 *
 * @author Julien_Lavigne
 */
public class ListenersButtonRecovery implements ActionListener{
	private LoginFrame connexion;


	public ListenersButtonRecovery(LoginFrame interf)
	{
		connexion = interf;

	}

	public void actionPerformed(ActionEvent e) 
	{
		connexion.changeToPasswordRecovery();   
	}
}
