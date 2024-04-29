/*
 * Frame.java - A class for the window the game will be drawn onto, this controls the game loop as well as which 
 * piece of the game has access to draw to the panel at any time. 
 */
package retro_arcade;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Frame extends JFrame implements ActionListener {

	// Without this it caused a warning, this is just for serialization 
	private static final long serialVersionUID = 1L;
	private static final int SCREEN_WIDTH = 400;
	private static final int SCREEN_HEIGHT = 400;
	private static final String ICON_PATH = "src\\retro_arcade\\images\\arcade-icon.png";
	
	private Panel panel;
	
	public Frame(Painter p) {
		super();
		
		panel = new Panel(p);
		panel.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		
		this.add(panel);
		this.setIconImage(loadIcon());		
		this.setTitle("Retro Arcade");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.pack(); // Sets the frame to fit the panel
		
		this.setVisible(true);
		
		// Start game clock, delay is 20ms for 50fps
		Timer timer = new Timer(20, this);
        timer.start();
	}
	
	/**
	 * Loads the icon for the game window from the local file system
	 * @return The icon loaded as a BufferedImage
	 */
	private BufferedImage loadIcon() {
		BufferedImage img = null;
		File f = new File(ICON_PATH);
		
		try {
			img = ImageIO.read(f);
		} catch (IOException e) {
			System.out.println("Failed to load app icon!");
		}
		return img;
	}

	
	/**
	 * The main loop for the game, this is where each frame can be calculated
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		panel.repaint();
		
	}
	
	/**
	 * Sets the painter for this frame, could be any of the games or menus
	 * @param p The painter which will paint the game frame
	 */
	public void setPainter(Painter p) {
		this.panel.setPainter(p);
	}

}
