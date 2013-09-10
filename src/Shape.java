import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

/**
 * 
 */

/**
 * @author JeremyLittel
 *
 */
public abstract class Shape implements Drawable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Point loc;
	protected Color color;
	protected boolean isFilled;
	public enum Type{
		RECTANGLE, CIRCLE, TRIANGLE
	}
	protected Type type;
	/**
	 * Constructor 
	 * @param theLoc location of shape
	 * @param theColor color of shape
	 * @param theIsFilled is the shape filled
	 */
	public Shape(Point theLoc, Color theColor, boolean theIsFilled){
		loc = theLoc;
		color = theColor;
		if (color == null){
			color = Color.black;
		}
		isFilled = theIsFilled;
	}
	/**
	 * Sets the location of the shape
	 * @param loc the location
	 */
	public void setLocation(Point loc){
		this.loc = loc; 
	}
	public Type getType(){
		return type;
	}
	public abstract void draw(Graphics g);
	
}
