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
public class Rectangle extends Shape {
	
	private double width;
	private double height;
	
	/**
	 * Constructor for Rectangle
	 * @param theLoc location of rectangle
	 * @param theColor color of rectangle
	 * @param theIsFilled is the rectangle filled
	 * @param w width
	 * @param h height
	 */
	public Rectangle(Point theLoc, Color theColor, boolean theIsFilled, double w, double h) {
		super(theLoc, theColor, theIsFilled);
		width = w;
		height = h;
		type = Type.RECTANGLE;
	}

	/* (non-Javadoc)
	 * @see Drawable#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g){ 
		g.setColor(color);
		g.drawRect(loc.x, loc.y, (int)width, (int)height);
		if(isFilled){
			g.setColor(color);
			g.fillRect(loc.x, loc.y, (int)width, (int)height);
		}
	}
	
	public void setSize(int width,int height){
		this.width = width;
		this.height = height;
	}
	
}
