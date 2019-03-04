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
			/*
			while(sc.hasNextLine())
			{
				System.out.println(sc.nextLine());
			}*/
			
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
		
	}
	
	
	
	
}

