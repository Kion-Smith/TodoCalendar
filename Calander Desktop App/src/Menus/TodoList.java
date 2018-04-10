package Menus;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TodoList extends JPanel 
{
	JScrollPane todolistScroll;
	JList todoList;
	JButton removeButton;
	
	public TodoList()
	{
		
		todolistScroll = new JScrollPane();
		todoList = new JList();
		removeButton = new JButton("Remove");
		
		setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        setLayout(new GridBagLayout());

        todoList.setModel(new AbstractListModel<String>() 
        {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        
        todolistScroll.setViewportView(todoList);

        GridBagConstraints gc = new GridBagConstraints();
        
        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LAST_LINE_END;
        gc.insets = new Insets(10, 10, 10, 10);
        add(removeButton, gc);
        
        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth = 2;
        gc.fill = GridBagConstraints.BOTH;
        gc.ipadx = 94;
        gc.ipady = 131;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.weightx = 1.0;
        gc.weighty = 1.0;
        //gc.insets = new Insets(12, 11, 0, 11);
        add(todolistScroll, gc);

     
        /*

        gc.gridx = 1;
        gc.gridy = 1;
        gc.gridheight = 2;
       gc.ipadx = 23;
       gc.ipady = 100;
        gc.anchor = GridBagConstraints.CENTER;
        //gc.insets = new Insets(18, 10, 0, 0);
        add(todoList, gc);
        */



	}
}
