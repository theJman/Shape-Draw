import java.awt.Color;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

/**
 * 
 */

/**
 * @author JeremyLittel
 *
 */
public class DrawFrame extends JFrame {
	private DrawPanel drawPanel;
	private DrawOptions drawOptions;
	/**
	 * Constructs a new Frame
	 */
	public DrawFrame(){
		drawOptions = new DrawOptions(400, 20, 150, 400);
		drawPanel = new DrawPanel(drawOptions);
		drawPanel.setBounds(0, 20, 400, 400);
		setBounds(500, 300, 550, 420);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setTitle("Shape Draw");
		add(drawPanel);
		add(drawOptions);
		setVisible(true);
		//create menu bar
		DrawMenuBar menuBar = new DrawMenuBar(drawPanel);
		menuBar.setBounds(0, 0, getWidth(), 20);
		menuBar.setVisible(true);
		setJMenuBar(menuBar);
		
	}
	/**
	 * Adds shape s to the panel
	 * @param s shape
	 */
	public void addShape(Shape s){
		drawPanel.addShape(s);
	}
	public static void main(String[] args){
		DrawFrame frame = new DrawFrame();
		
		//frame.addShape(new Rectangle(new Point(200, 50), Color.blue, true, 50, 80));
		//frame.addShape(new Triangle(new Point(50,50), Color.red, true, new Point(60,50), new Point(60, 100), new Point(100, 70)));
		//frame.addShape(new Circle(new Point(100, 200), Color.cyan, false, 60));
		
	}
}
