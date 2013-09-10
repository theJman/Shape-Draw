import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.stream.FileImageInputStream;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * 
 */

/**
 * @author JeremyLittel
 *
 */
public class DrawMenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;

	private JMenuItem miOpen;
	private JMenuItem miSave;
	private JMenuItem miNew;
	private JMenu mFile;
	private DrawPanel drawPanel;
	
	/**
	 * Constructs a new menubar with a file menu
	 */
	public DrawMenuBar(DrawPanel drawPanel){
		setBackground(Color.gray);
		this.drawPanel = drawPanel;
		//create file menu
		mFile = new JMenu("File");
		add(mFile);
		mFile.setBackground(Color.gray);
		//create menu items
		miNew = new JMenuItem("New");
		miOpen = new JMenuItem("Open");
		miSave = new JMenuItem("Save");
		//add menu items
		mFile.add(miNew);
		mFile.add(miOpen);
		mFile.add(miSave);
		//add action listeners
		miNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newClicked();
			}
		});
		miOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openClicked();
			}
		});
		miSave.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				saveClicked();
			}
		});
	}
	/**
	 * Saves the shape set to a file
	 */
	private void saveClicked(){
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter extentions = new FileNameExtensionFilter("Shape Sets", "shps");
		fileChooser.setFileFilter(extentions);
		int retunedVal = fileChooser.showSaveDialog(this);
		File file = null;
		if(retunedVal == JFileChooser.APPROVE_OPTION){
			file = fileChooser.getSelectedFile();
			//make sure file has the right extention
			file = new File(file.getAbsolutePath()+".shps");
		}
		//only continue if a file is selected
		if(file != null){
			ShapeSet newSet = null;
			try {
				//read in file
				ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
				output.writeObject(drawPanel.getShapeSet());
				output.close();
				System.out.println("Save Success");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	/**
	 * Opens a shapeset from a file and clears drawwindow
	 */
	private void openClicked(){
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter extentions = new FileNameExtensionFilter("Shape Sets", "shps");
		fileChooser.setFileFilter(extentions);
		int retunedVal = fileChooser.showOpenDialog(this);
		File file = null;
		if(retunedVal == JFileChooser.APPROVE_OPTION){
			file = fileChooser.getSelectedFile();
		}
		//only continue if a file is selected
		if(file != null){
			ShapeSet newSet = null;
			try {
				//read in file
				ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
				newSet = (ShapeSet) input.readObject();
				input.close();
				System.out.println("Open Success");
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(newSet != null){
				drawPanel.setShapeSet(newSet);
			}
		}
		
	}
	/**
	 * clears the drawPanel
	 */
	private void newClicked(){
		drawPanel.clearWindow();
	}
	
}
