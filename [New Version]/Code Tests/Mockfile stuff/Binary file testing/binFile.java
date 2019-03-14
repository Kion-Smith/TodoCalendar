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
			System.out.println("Enter a string, I will convert it into binary file format");
			String input = kb.nextLine();
			
			//write to file
			FileOutputStream fos = new FileOutputStream(f);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			DataOutputStream dos = new DataOutputStream(bos);
			
			//not working how I expect it too need to look into this
			dos.writeUTF(input);
			dos.writeInt(1);
			
			bos.flush();
			fos.close();
			dos.close();
			
			DataInpuStream dis = new DataInputStream(bos);
			
			//boolean eof;

			
		}
		catch(Exception e)
		{
			System.out.println("MAIN-CATCH:Could not create file");
		}
	}
}