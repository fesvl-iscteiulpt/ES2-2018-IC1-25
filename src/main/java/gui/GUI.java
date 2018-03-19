package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import util.ConfigManager;
import util.Email;

public class GUI {

	private JFrame frame;
	private JComboBox<String> nameComboBox;
	private JTextField descriptionTextField;
	private JTextField durationTextField;
	private JTextField rulesNameTextField;
	private JTable table;
	private JTextField rowsTextField;
	private JComboBox<String> typeComboBox;
	private JTextField fromTextField;
	private JTextField toTextField;

	public GUI() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		// frame.setSize(1600, 1000);
		// frame.setTitle("User");
		frame.setJMenuBar(createMenuBar());
		addComponents();
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	@SuppressWarnings("serial")
	private void addComponents() {
		JPanel problemDescriptionPanel = new javax.swing.JPanel();
		JLabel nameLabel = new javax.swing.JLabel();
		nameComboBox = new javax.swing.JComboBox<String>();
		descriptionTextField = new javax.swing.JTextField();
		JLabel descriptionLabel = new javax.swing.JLabel();
		JLabel durationLabel = new javax.swing.JLabel();
		durationTextField = new javax.swing.JTextField();
		JLabel rulesNameLabel = new javax.swing.JLabel();
		rulesNameTextField = new javax.swing.JTextField();
		JPanel VariablesPanel = new javax.swing.JPanel();
		JScrollPane scrollPane = new javax.swing.JScrollPane();
		table = new javax.swing.JTable();
		JLabel rowsLabel = new javax.swing.JLabel();
		rowsTextField = new javax.swing.JTextField();
		typeComboBox = new javax.swing.JComboBox<>();
		JLabel typeLabel = new javax.swing.JLabel();
		JPanel intervalPanel = new javax.swing.JPanel();
		JLabel fromLabel = new javax.swing.JLabel();
		JLabel toLabel = new javax.swing.JLabel();
		fromTextField = new javax.swing.JTextField();
		toTextField = new javax.swing.JTextField();

		problemDescriptionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Problem Description"));
		problemDescriptionPanel.setToolTipText("");

		nameLabel.setText("Name:");

		nameComboBox.setModel(
				new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

		descriptionLabel.setText("Description:");

		durationLabel.setText("Max Duration (Minutes) :");

		durationTextField.setText("60");
		rulesNameLabel.setText("Rules Name:");

		javax.swing.GroupLayout problemDescriptionPanelLayout = new javax.swing.GroupLayout(problemDescriptionPanel);
		problemDescriptionPanel.setLayout(problemDescriptionPanelLayout);
		problemDescriptionPanelLayout.setHorizontalGroup(problemDescriptionPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(problemDescriptionPanelLayout.createSequentialGroup().addContainerGap()
						.addGroup(problemDescriptionPanelLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(problemDescriptionPanelLayout.createSequentialGroup().addComponent(nameLabel)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(nameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(problemDescriptionPanelLayout.createSequentialGroup()
										.addComponent(durationLabel)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(durationTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
						.addGroup(problemDescriptionPanelLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(problemDescriptionPanelLayout.createSequentialGroup()
										.addComponent(descriptionLabel)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(descriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 338,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(problemDescriptionPanelLayout.createSequentialGroup()
										.addComponent(rulesNameLabel)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(rulesNameTextField)))));
		problemDescriptionPanelLayout.setVerticalGroup(problemDescriptionPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(problemDescriptionPanelLayout.createSequentialGroup().addContainerGap()
						.addGroup(problemDescriptionPanelLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(nameLabel)
								.addComponent(nameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(descriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(descriptionLabel))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(problemDescriptionPanelLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(durationLabel)
								.addComponent(durationTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(rulesNameLabel).addComponent(rulesNameTextField,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(18, Short.MAX_VALUE)));

		VariablesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Variables"));

		table.setModel(new javax.swing.table.DefaultTableModel(new Object[][] { { null, null }, { null, null },
				{ null, null }, { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
				{ null, null }, { null, null }, { null, null } }, new String[] { "Rules", "Values" }) {
			Class[] types = new Class[] { java.lang.String.class, java.lang.String.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		if (table.getColumnModel().getColumnCount() > 0) {
			table.getColumnModel().getColumn(0).setResizable(false);
			table.getColumnModel().getColumn(1).setResizable(false);
		}

		rowsLabel.setText("Rows:");

		rowsTextField.setText("30");
		typeComboBox.setModel(
				new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

		typeLabel.setText("Type:");

		intervalPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Interval"));

		fromLabel.setText("From:");

		toLabel.setText("To:");

		fromTextField.setText("-5");

		toTextField.setText("5");
		toTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

		javax.swing.GroupLayout intervalPanelLayout = new javax.swing.GroupLayout(intervalPanel);
		intervalPanel.setLayout(intervalPanelLayout);
		intervalPanelLayout.setHorizontalGroup(intervalPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(intervalPanelLayout.createSequentialGroup().addGroup(intervalPanelLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(intervalPanelLayout.createSequentialGroup().addComponent(toLabel)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(toTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 18,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(intervalPanelLayout.createSequentialGroup().addComponent(fromLabel)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35,
										Short.MAX_VALUE)
								.addComponent(fromTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));
		intervalPanelLayout.setVerticalGroup(intervalPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(intervalPanelLayout.createSequentialGroup()
						.addGroup(intervalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(fromLabel).addComponent(fromTextField,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(intervalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(toLabel).addComponent(toTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));

		javax.swing.GroupLayout VariablesPanelLayout = new javax.swing.GroupLayout(VariablesPanel);
		VariablesPanel.setLayout(VariablesPanelLayout);
		VariablesPanelLayout.setHorizontalGroup(VariablesPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(VariablesPanelLayout.createSequentialGroup().addGap(18, 18, 18)
						.addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 268,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(VariablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(VariablesPanelLayout.createSequentialGroup().addComponent(rowsLabel)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(rowsTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(VariablesPanelLayout.createSequentialGroup().addComponent(typeLabel)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(intervalPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		VariablesPanelLayout.setVerticalGroup(VariablesPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(VariablesPanelLayout.createSequentialGroup().addGroup(VariablesPanelLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 191,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(VariablesPanelLayout.createSequentialGroup().addGroup(VariablesPanelLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(rowsLabel)
								.addComponent(rowsTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(VariablesPanelLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(typeLabel).addComponent(typeComboBox,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18).addComponent(intervalPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
										77, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(28, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
		frame.getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(problemDescriptionPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(VariablesPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(problemDescriptionPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(VariablesPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(108, Short.MAX_VALUE)));

		frame.pack();
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(Box.createHorizontalGlue()); // Makes the menus appear at the right edge of the menu bar

		// Create Menus Here

		// Options Menu - KEY O
		JMenu optionsMenu = new JMenu("Options");
		optionsMenu.setMnemonic(KeyEvent.VK_O);
		JMenuItem menuItemSetEmail = new JMenuItem("Setup Email");
		menuItemSetEmail.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new EmailSetupDialog(frame);
			}
		});
		optionsMenu.add(menuItemSetEmail);
		menuBar.add(optionsMenu);
		// End of options menu

		// Help Menu - KEY H
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic(KeyEvent.VK_H);
		JMenuItem menuItemFAQ = new JMenuItem("FAQ");
		menuItemFAQ.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new FAQDialog(frame);
			}
		});

		JMenuItem menuItemEmail = new JMenuItem("Contact Administrator");
		menuItemEmail.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new EmailDialog(frame);
			}
		});
		helpMenu.add(menuItemFAQ);
		helpMenu.add(menuItemEmail);
		menuBar.add(helpMenu);
		// End of help menu

		return menuBar;
	}

	public static void main(String[] args) {
		GUI g = new GUI();
		try {
			ConfigManager.getInstance().loadConfig(ConfigManager.getConfigFile());
		} catch (XPathExpressionException | ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void showEmailSetup() {
		new EmailSetupDialog(frame);
	}

}