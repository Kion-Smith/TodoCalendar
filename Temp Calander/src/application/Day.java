package application;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class Day 
{
	
	//http://code.makery.ch/library/javafx-2-tutorial/part2/
	private final IntegerProperty curDay;
	public ObjectProperty<ArrayList<String>> toDoList;//might change this later to another object
	
	public Day(int cday)
	{
		curDay = new SimpleIntegerProperty(cday);
	}
/*
	
	public Day(int cday, ArrayList<String> tdl)
	{
		curDay = new SimpleIntegerProperty(cday);
		toDoList = new SimpleObjectProperty(tdl);
	}
/*
	public void setToDoList(ArrayList<String> list)
	{
		for(int i=0;i<list.size();i++)
		{
			//need to learn how to add items
		}
	}
	*/
	 public int getCurDay() 
	 {
		 return curDay.get();
	 }

	 public void setCurDay(int cday) 
	 {
		 curDay.set(cday);
	 }

	 public IntegerProperty curdayProperty() 
	 {
		 return curDay;
	 }
	 
	 public void setToDoList(ArrayList<String> list) 
	 {
	        toDoList.set(list);
	 }

	    public ObjectProperty<ArrayList<String>> toDoListProperty() 
	    {
	        return toDoList;
	    }
	 
	 
}
