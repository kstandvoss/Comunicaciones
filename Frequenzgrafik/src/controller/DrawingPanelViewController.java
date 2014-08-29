package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import controller.listener.KeyListener;
import controller.listener.MoveListener;
import model.Camera;
import model.Vertex;
import model.drawables.Curve;
import model.drawables.DrawableObject;
import view.DrawingPanelView;
import view.InputPanel;
import view.Renderer;

/**
 * Der Controller, der eine DrawingPanelView verwaltet und das dazugehörige
 * Model in Form einer Liste von DrawableObjects.
 *
 * @author Nicolas Neubauer
 *
 */
public class DrawingPanelViewController {
	// View
	private DrawingPanelView drawingPanelView;
	// Model, die Szene
	private LinkedList<DrawableObject> drawableObjects;
	// Renderer
	private Renderer renderer;
	private Curve curve;

	/**
	 * Der Konstruktor initialisiert die View und legt die Listener an.
	 */
	public DrawingPanelViewController() {
		boolean[] bits = new boolean[8];
		curve = new Curve(bits, 0, 0, 0);
		// Liste von 3D-Objekten initalisieren
		drawableObjects = new LinkedList<DrawableObject>();
		// Renderer initialisieren
		// Zunächst Kamera festlegen
		Vertex eyePoint = new Vertex(0, 0, -20, 1);
		Vertex upVector = new Vertex(0, 1, 0, 1); // Einfach 1 hoeher als die
		// Kamera
		Vertex lookAtPoint = new Vertex(0, 0, 0, 1);
		// Eine neue Kamera erstellen mit obigen Eigenschaften, einer Brennweit
		// von 35° und
		// einer nearPlane bei 0.1 und einer farPlane bei 100
		// Außerdem wird der Kamera die Bildgröße übergeben, damit das
		// Seitenverhältnis
		// berechnet werden kann
		Camera c = new Camera(eyePoint, lookAtPoint, upVector, 35, 640, 480,
				0.1, 100);
		// Der Renderer kennt die Kamera und weiß was zu rendern ist
		renderer = new Renderer(c, drawableObjects);
		// Die DrawingPanelView wird mit der gleichen Auflösung wie oben
		// initalisiert
		drawingPanelView = new DrawingPanelView(640, 480, renderer);
		MoveListener m = new MoveListener(this);
		KeyListener k = new KeyListener(this);
		ActionListener addCurve = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setAll();
				curve.create();
				drawableObjects.add(curve);
				getView().repaint();
			}
		};
		drawingPanelView.getDrawingPanel().addMouseListener(m);
		drawingPanelView.getDrawingPanel().addMouseMotionListener(m);
		drawingPanelView.addKeyListener(k);
		drawingPanelView.getInputPanel().getMoveButton().addKeyListener(k);
		drawingPanelView.getInputPanel().getAddButton()
				.addActionListener(addCurve);
		// Neu rendern
		this.getView().repaint();
	}

	/**
	 * Gibt die verwaltete View zurück
	 *
	 * @return die View
	 */
	public DrawingPanelView getView() {
		return drawingPanelView;
	}

	/**
	 * Setzt den Augenpunkt auf den übergebenen Vertex und rendert neu
	 *
	 * @param p
	 *            neuer Augenpunkt
	 */
	public void changeEyePointTo(Vertex p) {
		renderer.getCamera().setEyePoint(p);
		this.getView().repaint();
	}

	/**
	 * Liefert Kopie des aktuellen Augenpunkts
	 *
	 * @return Augenpunkt
	 */
	public Vertex getEyePoint() {
		return new Vertex(renderer.getCamera().getEyePoint());
	}

	/**
	 * Setzt dem UpVektor neu und rendert anschließend neu
	 *
	 * @param p
	 *            der neue UpVektor
	 */
	public void changeUpVectorTo(Vertex p) {
		renderer.getCamera().setUpVector(p);
		this.getView().repaint();
	}

	/**
	 * Liefert Kopie des aktuellen UpVektors
	 *
	 * @return UpVektor
	 */
	public Vertex getUpVector() {
		return new Vertex(renderer.getCamera().getUpVector());
	}

	public Vertex getLookAtVector() {
		// TODO Auto-generated method stub
		return new Vertex(renderer.getCamera().getLookAtVector());
	}

	public void changeLookAtVector(Vertex d) {
		renderer.getCamera().setLookAtPoint(d);
		this.getView().repaint();
	}

	private void setH() {
		curve.setHarmonic(Integer.parseInt(drawingPanelView.getInputPanel()
				.getHarmonics().getText()));
	}

	private void setBps() {
		curve.setBps(Integer.parseInt(drawingPanelView.getInputPanel().getBps()
				.getText()));
	}

	private void setF() {
		curve.setFrequency(Integer.parseInt(drawingPanelView.getInputPanel()
				.getFrequency().getText()));
	}

	private void setBits() {
		String string = drawingPanelView.getInputPanel().getBits().getText();
		String[] parts = string.split("");
		boolean[] bits = new boolean[parts.length - 1];
		for (int i = 1; i < parts.length; i++) {
			if (parts[i].equals("1"))
				bits[i - 1] = true;
		}
		curve.setBits(bits);
	}

	private void setAll() {
		setH();
		setBits();
		setBps();
		setF();
	}
}