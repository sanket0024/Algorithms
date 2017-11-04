import java.io.*;
public class Endings
{
	public static void main(String args[])
	{
		try
		{
			FileInputStream fs=new FileInputStream("info.dat");
			DataInputStream dis=new DataInputStream(fs);
			int i=dis.readByte();
			while(i!=-1)
			{
				System.out.println((byte)i+"|");
				i=dis.readByte();
			}
		}
		catch(FileNotFoundException fnf)
		{
			System.out.println("File not found");
		}
		catch(EOFException eofe)
		{
			System.out.println("EOF");
		}
		catch(IOException ioe)
		{
			System.out.println("IOE");
		}
	}
}