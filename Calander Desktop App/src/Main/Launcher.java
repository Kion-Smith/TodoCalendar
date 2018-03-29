package Main;

import javax.swing.JFrame;

import Menus.CalanderFrame;

public class Launcher extends JFrame
{
	public static void main(String[] args)
	{
		//maybe redo this in javafx
		CalanderFrame cf = new CalanderFrame();
		cf.setTitle("Calander App");
		cf.setSize(1280, 768);
		cf.setVisible(true);
		cf.setLocationRelativeTo(null);
		cf.setResizable(false);
		cf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
