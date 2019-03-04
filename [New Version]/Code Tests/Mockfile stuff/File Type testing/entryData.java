import java.util.*;
public class entryData
{
	private double remTimer;
	private int remDate;
	private int remMonth;
	private int remYear;
	
	private String entry;
	
	//default constructor
	public entryData()
	{
		remTimer = -1;
		remDate = -1;
		remMonth = -1;
		remYear = -1;
		
		entry = "";
	}
	
	//overloaded constructors
	//*This is the one for just the entry
	public entryData(String e)
	{
		remTimer = -1;
		remDate = -1;
		remMonth = -1;
		remYear = -1;
		
		entry = e;
	}
	//*This is for just a timer
	public entryData(String e, double t)
	{
		remTimer = t;
		remDate = -1;
		remMonth = -1;
		remYear = -1;
		
		entry = e;
	}
	//*just the date
	public entryData(String e,int d, int m,int y )
	{
		remTimer = -1;
		remDate = d;
		remMonth = m;
		remYear = y;
		
		entry = e;
	}
	//*Fully overloaded with all items
	public entryData(String e,double t,int d, int m,int y )
	{
		remTimer = t;
		remDate = d;
		remMonth = m;
		remYear = y;
		
		entry = e;
	}
	
	
	//getters
	public double getRemTimer()
	{
		return remTimer;
	}
	public int getRemDate()
	{
		return remDate;
	}	
	public int getRemMonth()
	{
		return remMonth;
	}
	public int getRemYear()
	{
		return remYear;
	}
	private String getEntry()
	{
		return entry;
	}
	
	
	//setters
	public void setRemTimer(double t)
	{
		remTimer = t;
	}
	public void setRemDate(int d)
	{
		remDate = d;
	}	
	public void setRemMonth(int m)
	{
		remMonth = m;
	}
	public void setRemYear(int y)
	{
		remYear = y;
	}
	private void setEntry(String e)
	{
		entry = e;
	}
	
}