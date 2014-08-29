package controller;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * Eine Applikation, um zweidimensionale Objekte in eine Zeichenfl�che zu
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
	 *            nicht unterst�tzt
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Draw3D");
		DrawingPanelViewController c = new DrawingPanelViewController();
		frame.add(c.getView(), BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}