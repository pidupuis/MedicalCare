/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.loginframe.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.loginframe.LoginFrame;

/**
 * listeners sur le bouton ? de l'interface de connexion
 * @author Julien_Lavigne
 */
public class ListenersButtonRecovery implements ActionListener{
	private LoginFrame connexion;


	public ListenersButtonRecovery(LoginFrame interf)
	{
		connexion = interf;

	}
/**
 * Fonction qui va changer de Panel vers le panel de changer de password
 * @param e 
 */
	public void actionPerformed(ActionEvent e) 
	{
		connexion.changeToPasswordRecovery();   
	}
}
