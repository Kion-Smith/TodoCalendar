import java.util.*;
public class calObj
{
	/*===============================
	 *Year <>
	 *Month ()
	 *Date	[]
	 *Entries {}
	 *Reminder date (if any) !!
	 *Timer/notification (if any) **
	 *================================
	 *Notes on this later
	*/
	 
	private int year;
	private int date;
	private ArrayList<entryData> listOfEntries;
	
	//default constructor
	public calObj()
	{
		year = -1;
		date = -1;
		
		listOfEntries = null;
	}
	
	public calObj(int y, int d,ArrayList<entryData> eD)
	{
		year = -1;
		date = -1;
		
		for(int i =0;i<eD.size();i++)
		{
			listOfEntries.set(i,eD.get(i));
		}
	}
	
	//getters
	private int getYear()
	{
		return year;
	}
	private int getDate()
	{
		return date;
	}
	private ArrayList<entryData> getListOfEntries()
	{
		return listOfEntries;
	}
	
	//setters
	private void setYear(int y)
	{
		year = y;
	}
	private void setDate(int d)
	{
		date = d;
	}
	private void setListOfEntries(ArrayList<entryData> eD)
	{
		for(int i =0;i<eD.size();i++)
		{
			listOfEntries.set(i,eD.get(i));
		}
	}
	
}