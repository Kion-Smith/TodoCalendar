package Calendar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileData 
{
	

	//I could store everything dealing with saving and file stuff/ arrays in here, not sure about this though
	
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
			System.out.println("~~~ Error:Could not get calendar date");
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public void OrgonizeDates(File file)
	{
		
	}
	
	public void writeBackData(ArrayList<CalendarData> cList) 
	{
		
		try
		{
			
			
			if(!curCalendar.exists())
			{
				curCalendar.createNewFile();
			}
			else
			{
				BufferedWriter bw = new BufferedWriter(new FileWriter(curCalendar));
				
				for(int i=0;i<cList.size();i++)
				{
					bw.write(cList.get(i).toString());
					bw.newLine();
				}
				
			}
		}
		catch(Exception e)
		{
		 System.out.println("~~~ Error: Could not write/find the file");
		 e.printStackTrace();
		}
		
	
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
