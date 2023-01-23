package logic;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class GameCanva extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Screen Width and Height
	public static final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	// Dimension of this app (Of this JPanel)
	public static final Dimension APP_DIMENSION = new Dimension(SCREEN_WIDTH - 100, SCREEN_HEIGHT - 100);

	public GameCanva() {
		this.setPreferredSize(APP_DIMENSION);
		
		this.setDoubleBuffered(true);
		this.setFocusable(true);
		
		this.setVisible(true);
	}
}
