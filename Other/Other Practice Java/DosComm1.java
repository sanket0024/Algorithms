import java.io.IOException;
class DosComm
{
	public static void main(String args[])
	{
		try
		{
            //String command = "ping";  
            Process process = Runtime.getRuntime().exec(args);  
            System.out.println("Executing command: "+args);  
        }
        catch (IOException e)
        {
            System.err.println(e);  
        }
    }  
}