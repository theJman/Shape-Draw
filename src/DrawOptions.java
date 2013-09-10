import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * 
 */

/**
 * @author JeremyLittel
 *
 */
public class DrawOptions extends JPanel {

	private static final long serialVersionUID = 1L;
	private DrawPanel drawPanel;
	private JRadioButton rbTrinagle;
	private JRadioButton rbRectangle;
	private JRadioButton rbCircle;
	private ButtonGroup radioButtons;
	private JCheckBox cbFill;
	private JButton colorButton;
	private Shape shape;
	private Color color;
	private int shapeWidth;
	private int shapeHeight;
	//vertacies for triangle
	private Point v1;
	private Point v2;
	private Point v3;
	
	public DrawOptions(int x, int y, int width, int height){
		setBounds(x, y, width, height);
		setLayout(null);
		setBorder(BorderFactory.createLineBorder(Color.black));
		v1 = new Point(0,0);
		v2 = new Point(0,0);
		v3 = new Point(0,0);
		//create buttons
		colorButton = new JButton("Color");
		cbFill = new JCheckBox("Fill");
		rbCircle = new JRadioButton("Circle");
		rbCircle.setSelected(true);
		rbRectangle = new JRadioButton("Rectangle");
		rbTrinagle = new JRadioButton("Triangle");
		radioButtons = new ButtonGroup();
		//add radio buttons to the group
		radioButtons.add(rbCircle);
		radioButtons.add(rbRectangle);
		radioButtons.add(rbTrinagle);
		//set bounds for buttons
		cbFill.setBounds(20, 150, 100, 20);
		colorButton.setBounds(20, 200, 100, 20);
		rbCircle.setBounds(20, 20, 70, 20);
		rbTrinagle.setBounds(20, 60, 90, 20);
		rbRectangle.setBounds(20, 100, 100, 20);
		//add buttons to panel
		add(rbCircle);
		add(rbRectangle);
		add(rbTrinagle);
		add(cbFill);
		add(colorButton);
		
		//listeners
		colorButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				color = JColorChooser.showDialog(colorButton, "Fill Color", Color.black);
				colorButton.setForeground(color);
			}
		});
	}
	public Shape getShape(){
		shapeHeight = 50;
		shapeWidth = 50;
		if(rbCircle.isSelected()){
			shape = new Circle(new Point(10, 10), color, cbFill.isSelected(),shapeWidth,shapeHeight);
		}
		else if(rbRectangle.isSelected()){
			shape = new Rectangle(null, color, cbFill.isSelected(), shapeWidth, shapeHeight);
		}
		else{
			shape = new Triangle(null, color, cbFill.isSelected(), v1, v2, v3);
		}
		return shape;
	}

}
