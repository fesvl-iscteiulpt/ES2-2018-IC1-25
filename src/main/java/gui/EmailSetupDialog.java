package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import util.Email;

@SuppressWarnings("serial")
public class EmailSetupDialog extends JDialog {

	private JLabel text = new JLabel(
			"<html><h3 align=center>Insert your email adress to recieve help information and progress on the optimization progress</h3>");

	public EmailSetupDialog(Component c) {
		setTitle("Email Setup");
		setSize(400, 180);
		setLocationRelativeTo(c);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setResizable(false);

		addComponents();
		setVisible(true);
	}

	private void addComponents() {
		text.setHorizontalAlignment(JLabel.CENTER);

		add(text, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		JLabel emailLabel = new JLabel("Email: ");
		JTextField emailText = new JTextField("", 15);
		panel.add(emailLabel);
		panel.add(emailText);
		add(panel, BorderLayout.CENTER);

		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (!emailText.getText().isEmpty()) {
					Email.getInstance().setUserMail(emailText.getText());
					dispose();
				}
			}
		});

		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
		buttonPane.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
		buttonPane.add(Box.createHorizontalGlue());
		buttonPane.add(ok);
		buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
		buttonPane.add(cancel);

		add(buttonPane, BorderLayout.PAGE_END);

	}

}
