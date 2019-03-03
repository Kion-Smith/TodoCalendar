import java.util.*;
import java.io.*;
public class fileType
{
	/*Year <>
	 *Month ()
	 *Date	[]
	 *Entries {}
	 *Reminder date (if any) !!
	 *Timer/notification (if any) **
	 */
	 
	private int year;
	private int date;
	private ArrayList<String> entryList;//either need to make another data obj to store date/timer or just 2 other arrays, this doubles space
	 
	public fileType Array[] = new fileType[2];
	
	public fileType()
	{
		
	}
	
	public static void main(String args[])
	{
	
		try
		{
			//Adding file to the scanner
			File file = new File("fileType1.csk");
			Scanner sc = new Scanner(file);
			
			while(sc.hasNextLine())
			{
				System.out.println(sc.nextLine());
			}
			
			sc.close();
			System.out.println("Scanner Closed");
			
		}
		catch(Exception e)
		{
			//An error has happened,either not found or when loading
			System.out.println("An error occured when reading the file");
		}
	
	}
	
	
	
	
}