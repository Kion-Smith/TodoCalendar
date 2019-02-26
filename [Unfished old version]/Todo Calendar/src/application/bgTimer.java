package application;

import java.util.TimerTask;

public class bgTimer extends TimerTask
{
	
	public void run()
	{
		//do saving stuff here ; probably want to call file data object
		//dont need to save file on first run call
		//need to check to see if the file exists, if not create one
		
		System.out.println("Saving file");
		
	}
		
	
	
}
