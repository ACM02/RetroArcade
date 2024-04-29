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
	
	private BufferedImage loadIcon() {
		BufferedImage img = null;
		File f = new File("src\\retro_arcade\\images\\arcade-icon.png");
		
		try {
			img = ImageIO.read(f);
		} catch (IOException e) {
			System.out.println("Failed to load app icon!");
		}
		return img;
	}

	
	// Game loop
	@Override
	public void actionPerformed(ActionEvent e) {
		panel.repaint();
		
	}
	
	public void setPainter(Painter p) {
		this.panel.setPainter(p);
	}

}
