import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * 
 */

/**
 * @author JeremyLittel
 *
 */
public class Circle extends Shape {
	private int width;
	private int height;
	/**
	 * Constructor for circle
	 * @param theLoc
	 * @param theColor
	 * @param theIsFilled
	 * @param width width of circle
	 * @param height height of circle
	 */
	public Circle(Point theLoc, Color theColor, boolean theIsFilled, int width, int height) {
		super(theLoc, theColor, theIsFilled);
		this.width = width;
		this.height = height;
		type = Type.CIRCLE;
	}
	/**
	 * Constructor for radius
	 * @param theLoc location of circle
	 * @param theColor color of circle
	 * @param theIsFilled is the circle filled
	 * @param radius radius of the circle
	 */
	public Circle(Point theLoc, Color theColor, boolean theIsFilled, int radius){
		super(theLoc, theColor, theIsFilled);
		width = 2 * radius;
		height = 2 * radius;
	}
	/* (non-Javadoc)
	 * @see Drawable#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		System.out.println("Draw");
		g.setColor(color);
		g.drawOval(loc.x, loc.y, width, height);
		if (isFilled) {
			g.setColor(color);
			g.fillOval(loc.x, loc.y, width, height);
		}
	}
	
	public void setSize(int width,int height){
		this.width = width;
		this.height = height;
	}

}
