import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

import javax.management.monitor.GaugeMonitor;

/**
 * 
 */

/**
 * @author JeremyLittel
 *
 */
public class Triangle extends Shape {
	private Point[] verts;
	/**
	 * Constructor
	 * @param theLocation location of triangle
	 * @param theColor color of triangle
	 * @param theIsFilled is the triangle filled
	 * @param v1 vert 1
	 * @param v2 vert 2
	 * @param v3 vert 3
	 */
	public Triangle(Point theLocation, Color theColor, boolean theIsFilled, Point v1, Point v2, Point v3){
		super(theLocation, theColor, theIsFilled);
		verts = new Point[3];
		verts[0] = v1;
		verts[1] = v2;
		verts[2] = v3;
		type = Type.TRIANGLE;
	}
	/* (non-Javadoc)
	 * @see Drawable#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		int[] xPoints = new int[3];
		int[] yPoints = new int[3];
		for (int i = 0; i < verts.length; i++) {
			xPoints[i] = verts[i].x;
			yPoints[i] = verts[i].y;
		}
		g.setColor(color);
		g.drawPolygon(xPoints, yPoints, 3);
		if(isFilled){
			g.setColor(color);
			g.fillPolygon(xPoints, yPoints, 3)
;		}
	}
	public void setVerts(Point[] verts){
		this.verts = verts;
		
	}
}
