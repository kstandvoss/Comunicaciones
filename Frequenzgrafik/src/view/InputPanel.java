package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	private JTextField bandwidth = new JTextField();
	// Buttons
	private JButton addButton;
	//private JButton infoButton;
	private JButton moveButton;
	private JTextField intervall = new JTextField();

	public JTextField getHarmonics() {
		return harmonics;
	}

	public JTextField getBits() {
		return bits;
	}

	public JTextField getBps() {
		return bps;
	}

	public JTextField getBandwidth() {
		return bandwidth;
	}

	public JTextField getIntervall() {

		return intervall;
	}

	/**
	 * Erzeugt ein neues Panel mit der Möglichkeit zur Matrizeneingabe und
	 * Listendarstellung.
	 */
	public InputPanel() {
		this.setLayout(new GridLayout(8, 0));
		// Create Label
		JLabel l = new JLabel("Display harmonics of a signal");
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
		JLabel label5 = new JLabel("Intervall(seconds):");
		JPanel panel5 = new JPanel();
		panel5.setLayout(new BorderLayout());
		JLabel label4 = new JLabel("Bandwidth(Hz):");
		panel1.add(harmonics, BorderLayout.CENTER);
		panel1.add(label1, BorderLayout.NORTH);
		panel2.add(bits, BorderLayout.CENTER);
		panel2.add(label2, BorderLayout.NORTH);
		panel3.add(bps, BorderLayout.CENTER);
		panel3.add(label3, BorderLayout.NORTH);
		panel4.add(bandwidth, BorderLayout.CENTER);
		panel4.add(label4, BorderLayout.NORTH);
		panel5.add(intervall, BorderLayout.CENTER);
		panel5.add(label5, BorderLayout.NORTH);
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.add(panel4);
		this.add(panel5);
		// Buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout());
		addButton = new JButton("Create Curve");
	//	infoButton = new JButton("Camera Info");
		moveButton = new JButton("Move Camera");

		moveButton.setToolTipText("Up: w Down: s Right: d Left: a" +
				" Forward: q Backward: e");
		intervall.setToolTipText("Intervall in which the signal is displayed");
		harmonics.setToolTipText("Requested amount of harmonics");
		bits.setToolTipText("Requested signal");
		bps.setToolTipText("Requested bits per second to be transmitted");
		bandwidth.setToolTipText("Requested bandwidth");
		
		
		buttonPanel.add(addButton, BorderLayout.NORTH);
		buttonPanel.add(moveButton, BorderLayout.CENTER);
		//buttonPanel.add(infoButton, BorderLayout.SOUTH);
		
		this.add(buttonPanel);
	}

	/**
	 * @return the addButton
	 */
	public JButton getAddButton() {
		return addButton;
	}
	/*public JButton getInfoButton() {
		return infoButton;
	}*/

	public JButton getMoveButton() {
		// TODO Auto-generated method stub
		return moveButton;
	}

}