package Main;

import javax.swing.JFrame;

public class Launcher extends JFrame
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Calander");
		frame.setSize(1280, 768);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
