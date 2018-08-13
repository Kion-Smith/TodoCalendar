package Calendar;

import java.io.File;

public class CalendarData 
{
	

	// might want to save user data with an xml file or some other markup language
	// need to save the month, the date, the year and all the information
	// Prioritize close distances when talking about events in the future, and then things in the far future, and then finally events that have already happened
	
	File curCalander;
	
	
	public CalendarData()
	{
		
	}
	
	public CalendarData(File f)
	{
		curCalander =f;
	}
	
	public void readData() {
		
	}
}
