package Calendar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class FileData 
{
	

	// might want to save user data with an xml file or some other markup language
	// need to save the month, the date, the year and all the information
	// Prioritize close distances when talking about events in the future, and then things in the far future, and then finally events that have already happened
	
	//thinking about json or xml still looking
	
	File curCalendar;
	
	
	ArrayList<CalendarData> calendarList = new ArrayList();
	
	public FileData(File f)
	{
		curCalendar =f;
	}
	
	public void initializeData() 
	{
		
		try
		{
			if(!curCalendar.exists())
			{
				curCalendar.createNewFile();
			}
			
			BufferedReader bf = new BufferedReader(new FileReader(curCalendar));
			boolean hasThrownError = false;
			
			System.out.println("File Loaded");
			System.out.println("----------------------------");
			System.out.println("");
			
			String curLine;

			while( (curLine =bf.readLine()) != null)
			{
				System.out.println(curLine);
				
				try
				{
					if((curLine.charAt(0)+"").equals("["))
					{
	
						String yearString =curLine.substring(curLine.indexOf("[")+1,curLine.indexOf("/"));
								
						String monthString =curLine.substring(curLine.indexOf("/")+1);
						String dayString = monthString;
						monthString = monthString.substring(0,monthString.indexOf("/"));
							
						String dataItems = dayString;
						dayString = dayString.substring(dayString.indexOf("/")+1,dayString.indexOf("]"));
								
						CalendarData tempObject = new CalendarData(convertStringToInt(yearString),convertStringToInt(monthString),convertStringToInt(dayString));
						
						dataItems = dataItems.substring(dataItems.indexOf("{"));
							
						boolean isBetweenBrace = false;
						boolean isBetweenQuote = false;
						boolean isEndOfString = false;
						
						String temp ="";
						for(int i=0;i<dataItems.length();i++)
						{
							if(hasThrownError)
							{
								return;
							}
							else
							{
								switch( (dataItems.charAt(i)+""))
								{
								
									case "{":
										if(!isBetweenBrace && !isBetweenQuote)
										{
											isBetweenBrace = true;
										}
										
										break;
										
									case "}":
										if(isEndOfString)
										{
											tempObject.addToNotesList(temp);
											calendarList.add(tempObject);
											
											temp = "";
											isEndOfString=false;
										}
										else if(isBetweenBrace && !isBetweenQuote)
										{
											isBetweenBrace = false;
										}
										
										break;
										
									case "\"":
										if(isBetweenBrace && !isBetweenQuote)
										{
											isBetweenQuote = true;
											
										}
										else if(isBetweenBrace && isBetweenQuote)
										{
											
											isBetweenQuote = false;
											
											//
										}
										
										break;
										
									case ";":
										
										if(!isBetweenQuote)
										{
											isEndOfString = true;
										}
										
										break;
										
									default:
										if(isEndOfString)
										{
											temp += dataItems.charAt(i)+"";
											
											tempObject.addToNotesList(temp);
											temp = "";
											isEndOfString=false;
										}
										else if(isBetweenBrace && isBetweenQuote)
										{
											temp += dataItems.charAt(i)+"";
										}
										
										break;
										
								}// end of swith	
							}
							
								
						}// end of for
						
					}
							
				}
				catch(Exception e)
				{
					hasThrownError = true;
					System.out.println("Error while reading");
				} //end of try catch

			}//end while

		} 
		catch (Exception e) 
		{
			System.out.println("File Not Found");
		}
		
		//need to add later
		OrgonizeDates(new File(""));
		
	}
	
	public CalendarData getCalendarData(int y,int m,int d) 
	{
		try
		{
			for(int i =0;i<calendarList.size();i++)
			{
				if(calendarList.get(i).isIdenticalDate(y, m, d))
				{
					return calendarList.get(i);
				}
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Error when getting calendar date");
		}
		
		return null;
		
	}
	
	public void OrgonizeDates(File file)
	{
		
	}
	
	public void writeBackData(ArrayList<CalendarData> cList) 
	{
		
		
	}
	

	
	public CalendarData addStringToData(CalendarData obj)
	{
		System.out.println("Enter a string");
		
		Scanner kb = new Scanner(System.in);
		String temp = kb.nextLine();
		
		obj.addToNotesList(temp);
		System.out.println("Would you like to add another string");
		temp = kb.nextLine();
		
		if(temp.equals("y"))
		{
			return addStringToData(obj);
		}
		
		System.out.println(obj.toString());
		
		return obj;

	}
	
	
	
	public int convertStringToInt(String string)
	{
		try
		{
			return Integer.parseInt(string);
		}
		catch(Exception e)
		{
			return -1;
		}
		
	}

	public int  getFileDataListSize()
	{
		return calendarList.size();
	}
	
	
	public CalendarData getCalendarDataAt(int i)
	{
		return calendarList.get(i);
	}
	
}
