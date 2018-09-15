package Calendar;

import java.io.File;
import java.util.LinkedList;

public class FileData 
{
	

	// might want to save user data with an xml file or some other markup language
	// need to save the month, the date, the year and all the information
	// Prioritize close distances when talking about events in the future, and then things in the far future, and then finally events that have already happened
	
	//thinking about json or xml still looking
	
	File curCalander;
	String[] curDataList;
	
	LinkedList<CalendarData> calendarList = new LinkedList();
	
	public FileData()
	{
		
	}
	
	public FileData(File f)
	{
		curCalander =f;
	}
	
	public void readData() 
	{
		try
		{
			
		}
		catch(Exception e)
		{
			
		}
	}
	
	public void writeData() 
	{
		
		
	}
	
	public String[] getDateDataList()
	{
		
		return curDataList;
	}
}
