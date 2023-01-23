package logic;

import javax.swing.JFrame;

public class Frame{

	/**
	 * Method to create frame of program
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Never Seen Land");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(new GameCanva()); // Adds Canva to frame
		frame.pack(); // Recalculates frame width and height basend on Canva
		
		frame.setLocationRelativeTo(null); // Centers frame
		frame.setVisible(true);
	}

}
