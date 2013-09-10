import java.awt.Graphics;
import java.io.Serializable;
import java.util.HashSet;

/**
 * 
 */

/**
 * @author JeremyLittel
 *
 */
public class ShapeSet extends HashSet<Shape> implements Drawable, Serializable {
	/**
	 * Version
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructs the ShapeSet
	 */
	public ShapeSet(){
		super();
	}

	/**
	 * Draws all of the Shapes in the ShapeSet
	 */
	public void draw(Graphics g) {
		for (Shape shape : this) {
			shape.draw(g);
		}
	}
}
