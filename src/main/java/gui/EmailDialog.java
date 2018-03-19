package gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import util.Email;

@SuppressWarnings("serial")
public class EmailDialog extends JDialog {

	private JTextArea body;
	private JLabel title;
	Component c;

	public EmailDialog(Component c) {
		this.c = c;
		setTitle("Contact Administrator");
		setSize(800, 300);
		setLocationRelativeTo(c);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setResizable(false);
		addComponents();
		setVisible(true);
	}

	private void addComponents() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

		// Create title
		JPanel titlepanel = new JPanel();
		title = new JLabel();
		title.setText("<html><h3>If you need extra information or help, write us an email</h3>");
		title.setHorizontalAlignment(JLabel.CENTER);
		titlepanel.add(title);
		panel.add(titlepanel);

		// Create body
		body = new JTextArea();
		body.setWrapStyleWord(true);
		body.setLineWrap(true);
		panel.add(body);

		// Send and cancel buttons
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JButton setButton = new JButton("Send");
		setButton.setActionCommand("Send");
		setButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (Email.getInstance().isAccountSetup()) {
					// Create a new thread that sends the email
					Thread thread = new Thread(new Runnable() {

						public void run() {
							Email.getInstance().sendEmailToAdmins(body.getText());
						}
					});
					thread.start();
					dispose();
				} else
					new EmailSetupDialog(c);
			}
		});

		getRootPane().setDefaultButton(setButton);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
		buttonPane.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
		buttonPane.add(Box.createHorizontalGlue());
		buttonPane.add(setButton);
		buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
		buttonPane.add(cancelButton);

		panel.add(buttonPane);

		add(panel);
	}

}
