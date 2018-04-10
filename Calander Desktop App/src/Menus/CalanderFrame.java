package Menus;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;



public class CalanderFrame extends JFrame implements ActionListener
{
	
	private Calander c;
	private TodoList l;
	
	public CalanderFrame()
	{
		c = new Calander();
		l = new TodoList();
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.ipadx = 200;
		gc.ipady = 200;
		add(c,gc);
		
		gc.ipadx = 200;
		gc.ipady = 200;
		gc.insets = new Insets(30, 50, 0, 30);
		add(l,gc);
		
	}

	
	public void actionPerformed(ActionEvent e)
	{
		
		
	}
}
