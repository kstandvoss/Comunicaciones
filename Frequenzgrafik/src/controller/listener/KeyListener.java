/**
 *
 */
package controller.listener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import controller.DrawingPanelViewController;
import model.Vertex;

/**
 * Ein Listener, der den Augenpunkt parallel zur Bildfläche wandern lässt
 * 
 * @author Nicolas Neubauer
 * 
 */
public class KeyListener extends KeyAdapter {
	private Vertex lookAtVector;
	private Vertex eyePoint;
	private DrawingPanelViewController controller;
	// 30 Pixel entsprechen einer Einheit im 3D-Raum (per autoritärer Willkür)
	private static final double PX23DVAL = 1.0;

	/**
	 * Erstellt einen neuen Listerner
	 * 
	 * @param controller
	 *            der zugehörige Controller
	 */
	public KeyListener(DrawingPanelViewController controller) {
		this.controller = controller;
		this.lookAtVector = controller.getLookAtVector();
		this.eyePoint = controller.getEyePoint();
	}

	public void keyTyped(KeyEvent e) {
		/*if (e.getKeyChar() == 'a') {
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

		if (e.getKeyChar() == 'q') {
			lookAtVector.z += PX23DVAL;
			controller.changeLookAtVector(lookAtVector);
		}
		if (e.getKeyChar() == 'e') {
			lookAtVector.z -= PX23DVAL;
			controller.changeLookAtVector(lookAtVector);
		}*/
		if (e.getKeyChar() == 'a') {
			eyePoint.x += PX23DVAL;
			controller.changeEyePoint(eyePoint);
		}
		if (e.getKeyChar() == 'd') {
			eyePoint.x -= PX23DVAL;
			controller.changeEyePoint(eyePoint);
		}
		if (e.getKeyChar() == 'w') {
			eyePoint.y += PX23DVAL;
			controller.changeEyePoint(eyePoint);
		}
		if (e.getKeyChar() == 's') {
			eyePoint.y -= PX23DVAL;
			controller.changeEyePoint(eyePoint);
		}

		if (e.getKeyChar() == 'q') {
			eyePoint.z += PX23DVAL;
			controller.changeEyePoint(eyePoint);
		}
		if (e.getKeyChar() == 'e') {
			eyePoint.z -= PX23DVAL;
			controller.changeEyePoint(eyePoint);
		}
		
		System.out.println(eyePoint);

	}
}