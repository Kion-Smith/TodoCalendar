import java.util.*;
import java.io.*;
public class fileType
{

	private ArrayList<String> entryList;//either need to make another data obj to store date/timer or just 2 other arrays, this doubles space
	 
	public calObj array[] = new calObj[2];
	
	
	public static void main(String args[])
	{
	
		try
		{
			//Adding file to the scanner
			File file = new File("fileType1.csk");
			Scanner sc = new Scanner(file);
			
			readKionFile(sc);
			

			
			sc.close();
			System.out.println("Scanner Closed");
			
		}
		catch(Exception e)
		{
			//An error has happened,either not found or when loading
			System.out.println("An error occured when reading the file");
		}
	
	}
	
	public static void readKionFile(Scanner s)
	{
		//local vars for testing inputs and out puts
		int year = -1;
		int month = -1;
		int date = -1;
		double timer = -1;
		ArrayList<String> entries;
		
		while(s.hasNextLine())
		{
			String temp = s.nextLine();
			temp = temp.replaceAll("\\s","");//replacing all whitespace
			
			switch(temp.substring(0,1))
			{
				case "<":
					System.out.println("<");
			}
		
			
		}	
	}
	
	public static boolean isDigit(String numS)
	{
		try
		{
			int n = Integer.parseInt(numS);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
	
}

