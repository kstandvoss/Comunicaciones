package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Matrix;

/**
 * @author Nicolas Neubauer
 *
 */
@SuppressWarnings("serial")
public class InputPanel extends JPanel {
	// TextFields
	private JTextField harmonics = new JTextField();
	private JTextField bits = new JTextField();
	private JTextField bps = new JTextField();
	private JTextField frequency = new JTextField();
	// Buttons
	private JButton addButton;
	private JButton clearButton;
	private JButton moveButton;

	public JTextField getHarmonics() {
		return harmonics;
	}

	public JTextField getBits() {
		return bits;
	}

	public JTextField getBps() {
		return bps;
	}

	public JTextField getFrequency() {
		return frequency;
	}

	/**
	 * Erzeugt ein neues Panel mit der Möglichkeit zur Matrizeneingabe und
	 * Listendarstellung.
	 */
	public InputPanel() {
		this.setLayout(new GridLayout(8, 0));
		// Create Label
		JLabel l = new JLabel("Matrix-Stack");
		this.add(l, BorderLayout.NORTH);
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		JLabel label1 = new JLabel("Harmonics:");
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		JLabel label2 = new JLabel("Bits:");
		JPanel panel3 = new JPanel();
		panel3.setLayout(new BorderLayout());
		JLabel label3 = new JLabel("Bps:");
		JPanel panel4 = new JPanel();
		panel4.setLayout(new BorderLayout());
		JLabel label4 = new JLabel("Frequency");
		panel1.add(harmonics, BorderLayout.CENTER);
		panel1.add(label1, BorderLayout.NORTH);
		panel2.add(bits, BorderLayout.CENTER);
		panel2.add(label2, BorderLayout.NORTH);
		panel3.add(bps, BorderLayout.CENTER);
		panel3.add(label3, BorderLayout.NORTH);
		panel4.add(frequency, BorderLayout.CENTER);
		panel4.add(label4, BorderLayout.NORTH);
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.add(panel4);
		// Buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout());
		addButton = new JButton("Create Curve");
		// clearButton = new JButton("Change Parameter");
		moveButton = new JButton("Move Fixpoint");
		buttonPanel.add(addButton, BorderLayout.WEST);
		// buttonPanel.add(clearButton, BorderLayout.CENTER);
		buttonPanel.add(moveButton, BorderLayout.EAST);
		this.add(buttonPanel);
	}

	/**
	 * @return the addButton
	 */
	public JButton getAddButton() {
		return addButton;
	}

	/**
	 * @return the clearButton
	 */
	public JButton getClearButton() {
		return clearButton;
	}

	public JButton getMoveButton() {
		// TODO Auto-generated method stub
		return moveButton;
	}
}