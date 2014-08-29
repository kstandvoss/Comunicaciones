/**
 *
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Beschreibt eine Fläche im 3D-Raum
 *
 * @author Nicolas Neubauer
 *
 */
public class Face {
	/**
	 * Konvention: An der i-ten Stelle der Liste der Normalen findet sich die
	 * Normale für den Punkt an der i-ten Stelle der Liste der Vertices.
	 */
	private List<Vertex> vertices;
	private List<Vertex> normals;
	private boolean red;

	/**
	 * Eine Fläche besteht aus einer Menge an Punkten
	 *
	 * @param vertices
	 *            die Punkte
	 */
	public Face(Vertex... vertices) {
		this.vertices = new ArrayList<Vertex>();
		this.normals = new ArrayList<Vertex>();
		for (Vertex v : vertices) {
			this.vertices.add(v);
		}
	}

	/**
	 * Einen Vertex hinzufügen
	 *
	 * @param v
	 *            Vertex
	 */
	public void addVertex(Vertex v) {
		this.vertices.add(v);
	}

	/**
	 * Eine Normale hinzufügen
	 *
	 * @param n
	 *            eine Normale
	 */
	public void addNormal(Vertex n) {
		this.normals.add(n);
	}

	/**
	 * Convenience-Methode. Verschiebt den zweiten Punkt in den Ursprung, dabei
	 * den ersten und dritten um den gleichen Betrag. Betrachtet nun den ersten
	 * und dritten Punkt als Vektor und berechnet das Kreuzprodukt als Normale
	 * der Fläche. Weist die Normale allen Vertices der Fläche zu (löscht vorher
	 * alle vorhandenen Normalen).
	 */
	public void createNormalsForFace() {
		Vertex v1 = vertices.get(0);
		Vertex v2 = new Vertex(vertices.get(1));
		v2.homogenize();
		Vertex v3 = vertices.get(2);
		Matrix translate = Matrix.createTransform(-v2.x, -v2.y, -v2.z);
		v1 = translate.multiply(v1);
		v3 = translate.multiply(v3);
		Vertex normal = v3.crossProduct(v1);
		normal.normalize();
		normal.w = 0;
		normals.clear();
		for (int i = 0; i < vertices.size(); i++) {
			normals.add(normal);
		}
	}

	/**
	 * Liefert die Punkte zurück
	 *
	 * @return die Punkte als Liste
	 */
	public List<Vertex> getVertices() {
		return vertices;
	}

	/**
	 * Liefert die Normalen zurück
	 * 
	 * @return die Normalen als Liste
	 */
	public List<Vertex> getNormals() {
		return normals;
	}

	public boolean isRed() {
		// TODO Auto-generated method stub
		return red;
	}

	public void setRed(boolean b) {
		red = b;
	}
}