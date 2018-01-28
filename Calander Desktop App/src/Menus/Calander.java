package Menus;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Calander extends JPanel
{
	
	JTable tableCalander;
	JScrollPane tableScroll;
	JButton nextMonthButton,prevMonthButton;
	
	public Calander()
	{
		
		tableCalander = new JTable();
		tableScroll = new JScrollPane();
		nextMonthButton = new JButton();
		prevMonthButton = new JButton();
		
		
	   setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
	   setLayout(new GridBagLayout());
	   GridBagConstraints gc = new GridBagConstraints();
	       
	   tableCalander.setModel(new DefaultTableModel(
			   new Object [][] {
	                {null, null, null, null},
	                {null, null, null, null},
	                {null, null, null, null},
	                {null, null, null, null}
	            },
			   
	           new String [] {
	                "Title 1", "Title 2", "Title 3", "Title 4"
	            }
	        ));
	        
	   tableScroll.setViewportView(tableCalander);

	   gc.gridx = 0;
	   gc.gridy = 1;
	   gc.gridwidth = 2;
	   gc.fill = GridBagConstraints.BOTH;
	   gc.ipadx = 203;
	   gc.ipady = 136;
	   gc.anchor = GridBagConstraints.NORTHWEST;
	   gc.weightx = 1.0;
	   gc.weighty = 1.0;
	   gc.insets = new Insets(6, 11, 12, 0);
	   add(tableScroll, gc);

	   nextMonthButton.setText("->");
	   gc.gridx = 1;
	   gc.gridy = 0;
	   gc.gridwidth = 3;
	   gc.anchor = GridBagConstraints.NORTHWEST;
	   gc.insets = new Insets(1, 100, 0, 1);
	   add(nextMonthButton, gc);

	   prevMonthButton.setText("<-");
	   gc.gridx = 0;
	   gc.gridy = 0;
	   gc.anchor = GridBagConstraints.NORTHWEST;
	   gc.insets = new Insets(1, 1, 0, 0);
	   add(prevMonthButton, gc);

	    
	   gc.gridx = 0;
	   gc.gridy = 1;
	   gc.anchor = GridBagConstraints.NORTHWEST;
	   gc.insets = new Insets(18, 10, 0, 0);
	   
	   
	}
	
	
}
