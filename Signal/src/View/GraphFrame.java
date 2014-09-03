package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.util.LinkedList;

import javax.swing.JComponent;


public class GraphFrame extends JComponent{

	private static class Line{
	    final double x1; 
	    final double y1;
	    final double x2;
	    final double y2;   
	    final Color color;

	    public Line(double x1, double y1, double x2, double y2, Color color) {
	        this.x1 = x1;
	        this.y1 = y1;
	        this.x2 = x2;
	        this.y2 = y2;
	        this.color = color;
	    }               
	}

	private final LinkedList<Line> lines = new LinkedList<Line>();

	public void addLine(double x1, double x2, double x3, double x4) {
	    this.addLine(x1, x2, x3, x4, Color.black);
	}

	public void addLine(double x1, double x2, double x3,double x4, Color color) {
	    lines.add(new Line(x1,x2,x3,x4, color));        
	    repaint();
	    
	}

	public void clearLines() {
	    lines.clear();
	    repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Graphics2D g2 = (Graphics2D) g;
	    g2.translate(0,150);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON);
	    for (Line line : lines) {
	        g2.setColor(line.color);
	        g2.draw(new Line2D.Double(line.x1, line.y1, line.x2, line.y2));
	    }
	}
} 