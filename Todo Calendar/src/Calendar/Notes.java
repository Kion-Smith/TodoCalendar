package Calendar;

import java.util.ArrayList;

public class Notes 
{
	private ArrayList<String> subNotes = new ArrayList<String>();
	
	public Notes()
	{
		
	}
	
	//maybe add in other functions to this like storing times in the day or adding custom colors
	
	public void addNotes(String newNote)
	{
		subNotes.add("- "+newNote);
	}
	
	public void removeNotes(int index)
	{
		System.out.println(subNotes.get(index));
		subNotes.remove(index);
		
	}
	
	public void clearNotes()
	{
		subNotes.clear();
	
	}
	

	
	public int lengthOfNotes()
	{
		return subNotes.size();
	}
	public boolean subNoteIsEmpty()
	{
		return subNotes.isEmpty();
	}
	
	public String getSubNoteAt(int index)
	{
		return subNotes.get(index);
	}
	//later use this for saving notes
	
}
