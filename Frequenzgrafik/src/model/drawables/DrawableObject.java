/**
 *
 */
package model.drawables;

import java.util.ArrayList;
import java.util.List;

import model.Face;

/**
 * Basisklasse f�r zeichenbare 3D-Objekte
 *
 * @author Nicolas Neubauer
 *
 */
public abstract class DrawableObject {
	protected List<Face> faces;

	/**
	 * Erzeugt ein neues DrawableObject, initalisiert die Liste der Fl�chen.
	 */
	public DrawableObject() {
		faces = new ArrayList<Face>();
	}

	/**
	 * Gibt eine Liste mit den einzelnen Fl�chen des Objekts zur�ck
	 *
	 * @return Liste mit Fl�chen
	 */
	public List<Face> getFaces() {
		return faces;
	}

	/**
	 * Z�hlt die Vertices des Objekts
	 *
	 * @return Anzahl der Vertices
	 */
	public int countVertices() {
		int count = 0;
		for (Face f : this.faces) {
			count += f.getVertices().size();
		}
		return count;
	}

	/**
	 * Wendet eine affine Transformation in Form einer 4x4 Matrix auf alle
	 * Vertices aller Fl�chen an. Transformiert die Normalen der Fl�chen mit der
	 * transponierten Inversen.
	 *
	 * @param t
	 *            die Transformationsmatrx (4x4)
	 */
	
}