package Calendar;

import java.util.ArrayList;

public class CalendarData 
{
	private int year;
	private int month;
	private int day;
	
	ArrayList<String> Notes = new ArrayList();
	
	public CalendarData(int y, int m,int d)
	{
		year =y;
		month =m;
		day = d;
	}
	
	//setters
	public void setYear(int y)
	{
		year =y;
	}
	public void setMonth(int m)
	{
		month =m;
	}
	public void setDay(int d)
	{
		day =d;
	}
	
	
	public void addToNotesList(String s)
	{
		Notes.add(s);
	}
	public void removeFromNotesList(int index)
	{
		if(!Notes.isEmpty())
		{
			Notes.remove(index);
		}
	}
	public boolean isNotesListEmpty()
	{
		return Notes.isEmpty();
	}
	//getters
	public int getYear()
	{
		return year;
	}
	public int getMonth()
	{
		return month;
	}
	public int getDay()
	{
		return day;
	}
	
	public int getDateCombined()
	{
		return day+month+year;
	}
	public boolean isIdenticalDate(int y,int m,int d)
	{
		if( year == y && month == m && day == d)
		{
			return true;
		}
		
		return false;
	}
	
	
	public String toString()
	{
		String temp = "["+year+"/"+month+"/"+day+"]:{";
		for(int i=0;i<Notes.size();i++)
		{
			temp+= "\""+Notes.get(i).toString() +"\";";
		}
		temp+="}";
		return temp;
	}
}
