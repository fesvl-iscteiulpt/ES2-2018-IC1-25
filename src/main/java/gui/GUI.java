package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class GUI {

	private JFrame frame;

	public GUI() {
	}

	public void createAndShowGUI() {
		frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(1600, 1000);
		frame.setLocationRelativeTo(null);
		frame.setTitle("User");

		frame.add(panel);

		frame.setJMenuBar(createMenuBar());

		// frame.add(button);
		frame.setVisible(true);
	}

	public JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(Box.createHorizontalGlue()); // Makes the menus appear at the right edge of the menu bar

		// Create Menus Here

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

		return menuBar;
	}

	public static void main(String[] args) {
		GUI g = new GUI();
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				g.createAndShowGUI();
			}
		});
	}

	public static void showEmailSetup() {
		// TODO Auto-generated method stub

	}

}