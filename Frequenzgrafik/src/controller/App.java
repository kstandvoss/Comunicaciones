package controller;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * Eine Applikation, um zweidimensionale Objekte in eine Zeichenfläche zu
 * zeichnen.
 *
 * @author Nicolas Neubauer
 *
 */
public class App {
	/**
	 * Startet die Applikation als JFrame.
	 *
	 * @param args
	 *            nicht unterstützt
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Draw3D");
		DrawingPanelViewController c = new DrawingPanelViewController();
		frame.add(c.getView(), BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setSize(1366, 768);
		frame.setVisible(true);
		JOptionPane.showMessageDialog(null, "Displays signal in an intervall of 8 seconds.\n"
				+ " If T(bits/bps) is bigger , you won't see the whole signal. \n"
				+ "If T is smaller, the signal repeats itself.");
	}
}