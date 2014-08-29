package view;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 * Eine DrawingPanelView besteht aus einem großen DrawingPanel sowie darunter
 * einer ComboBox und einem Button. Sie ist beliebig skalierbar.
 *
 * @author Nicolas Neubauer
 *
 */
@SuppressWarnings("serial")
public class DrawingPanelView extends JPanel {
	// View-Components
	private DrawingPanel drawingPanel;
	private InputPanel inputPanel;

	/**
	 * Konstruktor, der eine neue View anlegt.
	 *
	 * @param preferedWidthOfDrawingPanel
	 * @param preferedHeightOfDrawingPanel
	 * @param drawableObjectsModel
	 *            das Model, das an das DrawingPanel übergeben wird
	 */
	public DrawingPanelView(int preferedWidthOfDrawingPanel,
			int preferedHeightOfDrawingPanel, Renderer renderer) {
		if (preferedWidthOfDrawingPanel < 1 || preferedHeightOfDrawingPanel < 1)
			throw new IllegalArgumentException(
					"Groesse des DrawingPanels muss 1x1 oder groesser sein.");
		this.setLayout(new BorderLayout());
		// Besorge ein DrawingPanel und übergebe den Renderer
		drawingPanel = new DrawingPanel(preferedWidthOfDrawingPanel,
				preferedHeightOfDrawingPanel, renderer);
		this.add(drawingPanel, BorderLayout.CENTER);
		inputPanel = new InputPanel();
		this.add(inputPanel, BorderLayout.EAST);
	}

	/**
	 * @return the drawingPanel
	 */
	public DrawingPanel getDrawingPanel() {
		return drawingPanel;
	}

	public InputPanel getInputPanel() {
		// TODO Auto-generated method stub
		return inputPanel;
	}
}