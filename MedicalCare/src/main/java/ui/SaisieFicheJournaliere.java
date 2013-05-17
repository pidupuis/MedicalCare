package ui;

import java.awt.Dimension;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.swing.JPanel;

import main.DB_connector;
import net.miginfocom.swing.MigLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import oracle.jdbc.driver.DBConversion;

import persons.Actor;
import persons.Doctor;
import persons.Patient;
import tests.Analysis;
import tests.BloodTest;
import tests.EEG;
import tests.EffortTest;
/**
 * JPanel to insert new daily form
 * 
 * @author Mathieu
 *
 */
public class SaisieFicheJournaliere extends JPanel {

	private JPanel subpanelTree;
	private JPanel subpanelForm;
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public SaisieFicheJournaliere(Actor user) throws Exception {
		
		this.subpanelTree = new TreePanel(user);
		this.subpanelForm = new DailyFormPanel();
		
		this.add(this.subpanelTree);
		this.add(this.subpanelForm);
		
	}
	
	public static void main (String[] args) {
		
		JFrame plop = new JFrame();
		Actor actor;
		try {
			actor = new Doctor("Super","Docteur","1");
			plop.add(new SaisieFicheJournaliere(actor));
		} catch (Exception e) {
			e.printStackTrace();
		}
		plop.setVisible(true);
		plop.setMinimumSize(new Dimension(200, 150));

		
	}

}


