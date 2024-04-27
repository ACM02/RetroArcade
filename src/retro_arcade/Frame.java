package retro_arcade;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {

	// Without this it caused a warning, this is just for serialization 
	private static final long serialVersionUID = 1L;
	private static final int SCREEN_WIDTH = 400;
	private static final int SCREEN_HEIGHT = 400;
	
	private JPanel panel;
	
	public Frame() {
		super();
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		
		this.add(panel);
		
		BufferedImage img;
		File f = new File("images\\arcade-icon.png");
		//directory.toPath()
		System.out.println(f.getAbsolutePath());
		System.out.println(f.isFile());
		
		try {
			img = ImageIO.read(f);
			this.setIconImage(img);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		this.setTitle("Retro Arcade");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.pack(); // Sets the frame to fit the panel
		
		
		this.setVisible(true);
	}

}
