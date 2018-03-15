package gui;

import java.awt.Component;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class FAQDialog extends JDialog {

	// Questions and Answers
	private List<String> QAs = new ArrayList<String>();

	public FAQDialog(Component c) {
		setTitle("Frequently Asked Questions");
		setSize(800, 500);
		setLocationRelativeTo(c);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setResizable(false);
		try {
			readFAQ();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		addLabels();
		setVisible(true);
	}

	private void readFAQ() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src\\main\\resources\\FAQ\\FAQ.txt"));
		while (sc.hasNextLine()) {
			QAs.add(sc.nextLine());
		}
		sc.close();
	}

	private void addLabels() {
		JPanel labels = new JPanel();
		labels.setLayout(new BoxLayout(labels, BoxLayout.Y_AXIS));

		for (String QA : QAs) {
			JLabel l = new JLabel(QA);
			l.setHorizontalAlignment(JLabel.CENTER);
			labels.add(l);

			// Creates a little space between labels
			Dimension minSize = new Dimension(5, 50);
			Dimension prefSize = new Dimension(5, 50);
			Dimension maxSize = new Dimension(Short.MAX_VALUE, 50);
			labels.add(new Box.Filler(minSize, prefSize, maxSize));
		}

		JScrollPane scroll = new JScrollPane(labels);
		scroll.getVerticalScrollBar().setUnitIncrement(10); // Scroll faster
		add(scroll);
	}

}