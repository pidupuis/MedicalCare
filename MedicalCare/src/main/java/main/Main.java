package main;

import javax.swing.UIManager;

import persons.*;
import ui.MainWindow;
import ui.loginframe.LoginFrame;

public class Main {
    private static Actor user=null;
    private static String role=null;
    private static LoginFrame loginFrame;
    private static MainWindow mainWindow;
    
    /**
     * Starting point of the program
     * @param args
     * @throws Exception
     */
    public static void main (String[] args) throws Exception {
    	try{
    		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    	} catch(Exception e) {}

    	loginFrame= new LoginFrame();
    	
        try {
            DB_connector.getInstance();
            System.out.println("Connection !");
        } catch (Exception ex) {
            System.out.println("Connection failed !");
        }
    }
    
	public static Actor getUser() {
        return user;
    }
    
    public static void setUser(Actor user) {
        Main.user = user;
    }

    public static String getRole() {
		return role;
	}

	public static void setRole(String role) {
		Main.role = role;
	}
    
    public static void launchMainWindow() {
    	if(user != null) {
    	    try {
				mainWindow = new MainWindow(role, user);
			} catch (Exception e) {
				e.printStackTrace();
			}
			mainWindow.setVisible(true);
    		loginFrame.dispose();
    	}
    }
    
    public static void exit() {
    	System.exit(0);
    }
    
}
