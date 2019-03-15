import java.io.*;
import java.util.*;
import java.nio.charset.*;
public class binFile
{
	public static void main(String []args)
	{
		try
		{
			//create the file
			File f = new File("testBinFile.ksc");
			f.createNewFile();
			System.out.println("MAIN-TRY: ran init file");
			
			//user input
			Scanner kb = new Scanner(System.in);
			System.out.println("What do you want to do?");
			System.out.println("1: Write to a file");
			System.out.println("2: Read from a file");
			int input = kb.nextInt();
			
			DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
			DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(f)));
			
			switch(input)
			{
				case 1:
					dos  = writeToFile(dos,kb);
					System.out.println("Writing from a file");
					dos.close();
					break;
				case 2:
					readFromFile(dis);
					System.out.println("Reading from a file");
					break;
				default:
					main(args);
					System.out.println("Enter a valid input");
					break;
					
			}
			
		
		}
		catch(Exception e)
		{
			System.out.println("MAIN-CATCH:Could not create file");
		}
	}
	
	
	public static void readFromFile(DataInputStream d) throws IOException
	{
		System.out.println("Reading the data from the file");
		//not reading how I expected
		try
		{
			int tempInt = d.readInt();
			String temp = d.readUTF();
			
			System.out.println(tempInt+","+temp);
		}
		catch(Exception e)
		{
			
		}
	}
	
	public static DataOutputStream writeToFile(DataOutputStream d, Scanner s) throws IOException
	{
		System.out.println("Enter data for me to encrypt");
		s = new Scanner(System.in);
		String input = s.nextLine();
		
		d.writeInt(1);
		d.writeUTF(input);
		
		return d;
	}
}