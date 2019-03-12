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
			String curLine = s.nextLine();
			String noSpace = curLine.replaceAll("\\s","");//replacing all whitespace
			
			int offset = 1;
			/*
			switch(noSpace.charAt(0)+"")
			{
				case "<":
					offset = getOffset(noSpace.charAt(1)); // end of a statement
					if(isDigit(noSpace.substring(offset,noSpace.length()-1)))
					{
						System.out.println(noSpace.substring(offset,noSpace.length()-1));
					}
					break;
				case "(":
					System.out.println(""+noSpace);
					break;
				case "[":
					System.out.println("[::"+noSpace);
					break;
				case "{":
					System.out.println("{::"+noSpace);
					break;
				default:
					break;
			}
			*/ //neded to rethink this
			
		}	
	}
	
	public static void writeKionFile(FileWriter fw,calObj cal)
	{
		
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
	
	public static int getOffset(char c)
	{
		if(c == '/')
		{
			return 2;
		}
		
		return 1;
	}
	
	
}

