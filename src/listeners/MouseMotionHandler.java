package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import logic.GameEngine;

public class MouseMotionHandler implements MouseMotionListener{

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		GameEngine.mouseX = e.getX();
		GameEngine.mouseY = e.getY();
	}

}
