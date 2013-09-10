import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author JeremyLittel
 *
 */
public class DrawPanel extends JPanel {
	private ShapeSet shapeSet;
	private DrawOptions drawOptions;
	private Point startPoint;
	private Point endPoint;
	/**
	 * Constructs a DrawPanel and creates a Shape Set
	 */
	public DrawPanel(DrawOptions drawOptions){
		shapeSet = new ShapeSet();
		this.drawOptions = drawOptions;
		addMouseListener(new MouseAdapter() {
			/*
			public void mouseClicked(MouseEvent e){
				createShape(e.getPoint());
				
			}
			*/
			public void mousePressed(MouseEvent e){
				startPoint = e.getPoint();
			}
			public void mouseReleased(MouseEvent e){
				endPoint = e.getPoint();
				createShape(e.getPoint());
			}
		});
	}
	/**
	 * Adds a shape to the shape list
	 * @param shape shape to add
	 */
	public void addShape(Shape shape){
		shapeSet.add(shape);
	}
	/**
	 * Paints the shapes in shape list
	 */
	protected void paintComponent(Graphics g){
		System.out.println("Paint");

		shapeSet.draw(g);
	}
	private void createShape(Point loc){
		System.out.println("Click");
		Shape shape = drawOptions.getShape();
		//set location
		if(startPoint.x < endPoint.x){
			loc.x = startPoint.x;
		}
		else{
			loc.x = endPoint.x;
		}
		if(startPoint.y < endPoint.y){
			loc.y = startPoint.y;
		}
		else{
			loc.y = endPoint.y;
		}
		shape.setLocation(loc);
		
		switch (shape.getType()) {
		case CIRCLE: 
				((Circle)shape).setSize(Math.abs(startPoint.x-endPoint.x), Math.abs(startPoint.y-endPoint.y));
			break;
		case RECTANGLE:
			((Rectangle)shape).setSize(Math.abs(startPoint.x-endPoint.x), Math.abs(startPoint.y-endPoint.y));
			break;
		case TRIANGLE:
			int width = Math.abs(startPoint.x-endPoint.x);
			int height = Math.abs(startPoint.y-endPoint.y);
			Point[] verts = {
					new Point(loc.x,loc.y+height),
					new Point(loc.x+width,loc.y+height),
					new Point(loc.x+width/2,loc.y)
			};
			((Triangle)shape).setVerts(verts);
			break;
		default:
			break;
		}
		
		addShape(shape);
		
		paintComponent(getGraphics());
		
		System.out.println("\n");


	}
	/**
	 * Gets the ShapeSet
	 * @return the ShapeSet
	 */
	public ShapeSet getShapeSet(){
		return shapeSet;
	}
	/**
	 * Sets the ShapeSet
	 * @param shapeSet
	 */
	public void setShapeSet(ShapeSet shapeSet){
		clearWindow();
		this.shapeSet = shapeSet;
		//redraw
		paintComponent(getGraphics());
	}
	/**
	 * Clears the panel
	 */
	public void clearWindow(){
		shapeSet.clear();
		//redraw
		super.paintComponent(getGraphics());
		

	}
	
}
