/*
 * The panel we will be painting the game onto
 */
package retro_arcade;

import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Panel extends JPanel {
	
	private Painter painter;
	
	public Panel(Painter p) {
		this.painter = p;
	}
	
    /**
     * A built-in method from JPanel that'll allow us to draw on screen.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw shit
        if (painter != null) {
        	painter.paint(g);
        }
    }
    
    public void setPainter(Painter p) {
    	this.painter = p;
    }
	
}
