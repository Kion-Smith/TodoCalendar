package Menus;

import javax.swing.JPanel;



public class MainPanel extends JPanel
{
	
	private Calander c;
	private TodoList l;
	
	public MainPanel()
	{
		c = new Calander();
		l = new TodoList();
	}
}
