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
	
	JTable tableCalendar;
	JScrollPane tableScroll;
	JButton nextMonthButton,prevMonthButton;
	
	public Calander()
	{
		
		tableCalendar = new JTable(10,5);
		tableScroll = new JScrollPane();
		nextMonthButton = new JButton();
		prevMonthButton = new JButton();
		
		
	   setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
	   setLayout(new GridBagLayout());
	   GridBagConstraints gc = new GridBagConstraints();
	   //maybe have a counter for this
	    int count =1;
	   tableCalendar.setModel(new DefaultTableModel(
			   new Object [][] {
	                {count++, count++, count++, count++,count++,count++,count++},
	                {count++, count++, count++, count++,count++,count++,count++},
	                {count++, count++, count++, count++,count++,count++,count++},
	                {count++, count++, count++, count++,count++,count++,count++},
	                {count++, count++, count++}
	            },
			   
	           new String [] {
	                "Sunday", "Monday", "Wednesday", "Thursday","Friday","Saturday"
	            }
	        ));
	        tableCalendar.getTableHeader().setReorderingAllowed(false);
	        tableCalendar.setRowSelectionAllowed(false);
	        
	        tableCalendar.setRowHeight(100);
	        tableCalendar.setRowHeight(100);
	   tableScroll.setViewportView(tableCalendar);
	   
	   
	   gc.gridx = 0;
	   gc.gridy = 1;
	   gc.gridwidth = 2;
	   gc.fill = GridBagConstraints.BOTH;
	   gc.ipadx = 400;
	   gc.ipady = 430;
	  // gc.anchor = GridBagConstraints.NORTHWEST;
	   gc.weightx = 1.0;
	   gc.weighty = 1.0;
	  
	   add(tableScroll, gc);

	   gc.fill = 0;
	   nextMonthButton.setText("->");
	   gc.ipadx = 0;
	   gc.ipady =0;
	   gc.gridx = 1;
	   gc.gridy = 0;
	   gc.gridwidth = 3;
	 //  gc.anchor = GridBagConstraints.NORTHWEST;
	   gc.insets = new Insets(1, 100, 0, 1);
	   add(nextMonthButton, gc);

	   prevMonthButton.setText("<-");
	   gc.gridx = 0;
	   gc.gridy = 0;
	 //  gc.anchor = GridBagConstraints.NORTHWEST;
	   gc.insets = new Insets(1, 1, 0, 0);
	   add(prevMonthButton, gc);

	    
	   gc.gridx = 0;
	   gc.gridy = 1;
	   gc.anchor = GridBagConstraints.NORTHWEST;
	  
	   
	   
	}
	
	
}
