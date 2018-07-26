package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class handleData
{
	
	private ObservableList<Day> dayData = FXCollections.observableArrayList();

    public handleData()
    {
    	for(int i =1;i>30;i++)
    	{
    		dayData.add(new Day(i));
    	}
    	
    	
    }
    
    
    public ObservableList<Day> getDayData()
    {
    	return dayData;
    }
}
