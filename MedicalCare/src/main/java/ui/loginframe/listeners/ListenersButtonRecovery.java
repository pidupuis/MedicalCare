/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.loginframe.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.loginframe.LoginFrame;
import ui.loginframe.panels.LoginPane;

/**
 *
 * @author Julien_Lavigne
 */
public class ListenersButtonRecovery implements ActionListener{
	private LoginPane connexion;


	public ListenersButtonRecovery(LoginPane interf)
	{
		connexion = interf;

	}

	public void actionPerformed(ActionEvent e) 
	{
		//connexion.changepassword();   
	}
}
