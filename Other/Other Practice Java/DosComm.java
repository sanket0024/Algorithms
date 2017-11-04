import java.io.IOException;
public class DosComm
{
	public DosComm()
	{
		try
		{
            String command = "ping";  
            Process process = Runtime.getRuntime().exec(command);  
            System.out.println("Executing command: " + command);  
        }
        catch (IOException e)
        {
            System.err.println(e);  
        }
    }
    public static void main(String args[])
    {
        DosComm d=new DosComm();
    }  
}