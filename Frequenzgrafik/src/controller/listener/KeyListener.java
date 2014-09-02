/**
 *
 */
package controller.listener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import controller.DrawingPanelViewController;
import model.Vertex;

/**
 * Ein Listener, der den Augenpunkt parallel zur Bildfl�che wandern l�sst
 *
 * @author Nicolas Neubauer
 *
 */
public class KeyListener extends KeyAdapter {
	private Vertex lookAtVector;
	private DrawingPanelViewController controller;
	// 30 Pixel entsprechen einer Einheit im 3D-Raum (per autorit�rer Willk�r)
	private static final double PX23DVAL = 1.0;

	/**
	 * Erstellt einen neuen Listerner
	 *
	 * @param controller
	 *            der zugeh�rige Controller
	 */
	public KeyListener(DrawingPanelViewController controller) {
		this.controller = controller;
		this.lookAtVector = controller.getLookAtVector();
	}

	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == 'a') {
			lookAtVector.x += PX23DVAL;
			controller.changeLookAtVector(lookAtVector);
		}
		if (e.getKeyChar() == 'd') {
			lookAtVector.x -= PX23DVAL;
			controller.changeLookAtVector(lookAtVector);
		}
		if (e.getKeyChar() == 'w') {
			lookAtVector.y += PX23DVAL;
			controller.changeLookAtVector(lookAtVector);
		}
		if (e.getKeyChar() == 's') {
			lookAtVector.y -= PX23DVAL;
			controller.changeLookAtVector(lookAtVector);
		}
		/**
		 * if (e.getKeyChar() == '') { lookAtVector.z += PX23DVAL;
		 * controller.changeLookAtVector(lookAtVector); } if (e.getKeyChar() ==
		 * '') { lookAtVector.z -= PX23DVAL;
		 * controller.changeLookAtVector(lookAtVector); }
		 */
	}
}