package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import persons.Actor;
import ui.dailysheetfilling.SaisieFicheJournaliere;

/**
 * Main software window
 */
public class MainWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public MainWindow(String role, Actor user) throws Exception {
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		
		if (role.equalsIgnoreCase("médecin"))
		{
		JComponent panel1 = new SaisieFicheJournaliere(user, this.getRootPane());
        tabbedPane.addTab("Suivi Journalier",null, panel1,"Does nothing");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_3);
		JComponent panel2 = makeTextPanel("D'autres fonctionnalités finiront bien par arriver ...");
        tabbedPane.addTab("Autres Fonctionnalités",null, panel2,"Does nothing twice");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_3);
		}
		else if (role.equalsIgnoreCase("Attaché de recherche clinique"))
		{
			JComponent panel1 = makeTextPanel("Aucune fonctionnalité encore implantée pour l'ARC");
	        tabbedPane.addTab("Fonctionnalité Absente",null, panel1,"Does nothing twice");
	        tabbedPane.setMnemonicAt(0, KeyEvent.VK_3);
		}
		contentPane.add(tabbedPane);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		this.setSize(800,600);
	}
	
	  protected JComponent makeTextPanel(String text) {
	        JPanel panel = new JPanel(false);
	        JLabel filler = new JLabel(text);
	        filler.setHorizontalAlignment(JLabel.CENTER);
	        panel.setLayout(new GridLayout(1, 1));
	        panel.add(filler);
	        return panel;
	    }
	
	
}
