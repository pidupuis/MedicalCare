package ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.JEditorPane;
import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.JSeparator;
import javax.swing.JTextPane;

public class ValidationExclusion extends JPanel {
	private JTextField tfId;
	private JTextField textField;
	private JTextField tfPressionSystolique;
	private JTextField tfPressionDiastolique;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public ValidationExclusion() {
		setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		add(splitPane, BorderLayout.CENTER);
		
		JPanel leftPanel = new JPanel();
		splitPane.setLeftComponent(leftPanel);
		leftPanel.setLayout(new MigLayout("", "[152.00,grow]", "[][396.00,grow]"));
		
		JLabel lblListeMedecin = new JLabel("Liste des médecins");
		lblListeMedecin.setBorder(new EmptyBorder(10, 5, 10, 10));
		lblListeMedecin.setFont(new Font("Tahoma", Font.BOLD, 12));
		leftPanel.add(lblListeMedecin, "cell 0 0");
		
		JTree tree = new JTree();
		leftPanel.add(tree, "cell 0 1,grow");
		
		JPanel rightPanel = new JPanel();
		splitPane.setRightComponent(rightPanel);
		rightPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblJohnDoeuf = new JLabel("John D'Oeuf");
		lblJohnDoeuf.setHorizontalAlignment(SwingConstants.CENTER);
		lblJohnDoeuf.setBorder(new EmptyBorder(25, 0, 25, 0));
		rightPanel.add(lblJohnDoeuf, BorderLayout.NORTH);
		
		JPanel bottomPanel = new JPanel();
		rightPanel.add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setLayout(new MigLayout("", "[][][][][][][]", "[]"));
		
		JButton btnGarderEtude = new JButton("Garde dans l'étude");
		bottomPanel.add(btnGarderEtude, "cell 0 0");
		
		JButton btnExclure = new JButton("Exclure");
		bottomPanel.add(btnExclure, "cell 6 0,alignx right");
		
		JPanel middlePanel = new JPanel();
		rightPanel.add(middlePanel, BorderLayout.CENTER);
		middlePanel.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel middleTopPanel = new JPanel();
		middleTopPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		middleTopPanel.setAutoscrolls(true);
		middleTopPanel.setSize(new Dimension(0, 50));
		middlePanel.add(middleTopPanel);
		middleTopPanel.setLayout(new MigLayout("", "[50px:n,grow 50][50px:n,grow][]", "[16px][16px][16px][16px][16][][grow]"));
		
		JLabel lblId = new JLabel("ID");
		middleTopPanel.add(lblId, "flowx,cell 0 0,grow");
		
		tfId = new JTextField();
		tfId.setEditable(false);
		tfId.setRequestFocusEnabled(false);
		tfId.setText("1234");
		middleTopPanel.add(tfId, "cell 1 0,grow");
		tfId.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		middleTopPanel.add(lblDate, "flowx,cell 0 1,grow");
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText("15/05/13");
		middleTopPanel.add(textField, "cell 1 1,grow");
		textField.setColumns(10);
		
		JLabel lblPressionSystolique = new JLabel("Pression systolique");
		middleTopPanel.add(lblPressionSystolique, "cell 0 2,grow");
		
		tfPressionSystolique = new JTextField();
		tfPressionSystolique.setEditable(false);
		tfPressionSystolique.setText("12");
		middleTopPanel.add(tfPressionSystolique, "cell 1 2,growx");
		tfPressionSystolique.setColumns(10);
		
		JLabel lblMmhg = new JLabel("mmHg");
		middleTopPanel.add(lblMmhg, "cell 2 2");
		
		JLabel lblPressionDiastolique = new JLabel("Pression diastolique");
		middleTopPanel.add(lblPressionDiastolique, "cell 0 3,grow");
		
		tfPressionDiastolique = new JTextField();
		tfPressionDiastolique.setEditable(false);
		tfPressionDiastolique.setText("8");
		middleTopPanel.add(tfPressionDiastolique, "cell 1 3,growx,aligny top");
		tfPressionDiastolique.setColumns(10);
		
		JLabel lblmmHg2 = new JLabel("mmHg");
		middleTopPanel.add(lblmmHg2, "cell 2 3");
		
		JLabel lblNewLabel = new JLabel("Rythme cardiaque");
		middleTopPanel.add(lblNewLabel, "cell 0 4,grow");
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setText("70");
		middleTopPanel.add(textField_1, "cell 1 4,growx");
		textField_1.setColumns(10);
		
		JLabel lblBtmsmin = new JLabel("btms/min");
		middleTopPanel.add(lblBtmsmin, "cell 2 4");
		
		JSeparator separator = new JSeparator();
		middleTopPanel.add(separator, "cell 1 5");
		
		JLabel lblObservations = new JLabel("Observations");
		middleTopPanel.add(lblObservations, "cell 0 6");
		
		JTextPane tpObservations = new JTextPane();
		middleTopPanel.add(tpObservations, "cell 1 6,grow");
		
		JPanel middleBottomPanel = new JPanel();
		middlePanel.add(middleBottomPanel);
		middleBottomPanel.setLayout(new MigLayout("", "[grow]", "[][grow]"));
		
		JLabel lblJustificationExclusion = new JLabel("Justification Exclusion");
		middleBottomPanel.add(lblJustificationExclusion, "cell 0 0");
		
		JTextPane tpJustificationExclusion = new JTextPane();
		tpJustificationExclusion.setSize(new Dimension(0, 25));
		middleBottomPanel.add(tpJustificationExclusion, "cell 0 1,grow");

	}

}
