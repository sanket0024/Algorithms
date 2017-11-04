import java.io.*;
class FileSplitter
{
	public static void main(String args[]) throws IOException
	{
		Console con= System.console();
		System.out.print("Enter the file name: ");
		String str;
		str=con.readLine();
		File f= new File(str);
		if(!f.exists())
		{
			System.out.print("\nNo such File in the directory:");
			System.exit(0);
		}
		long x;
		x=f.length();
		System.out.print("\nLength of the file is: "+x);
		System.out.print("\nEnter length of destination file: ");
		int y;
		y=Integer.parseInt(con.readLine());
		if(y>x)
		{
			System.out.print("\nCannot create partition");
			System.exit(0);
		}
		long z;
		z=x/y;
		FileInputStream fis=new FileInputStream(str);
		int ch;
		for(int i=0;i<=z;i++)
		{
			FileOutputStream fos=new FileOutputStream(i+"."+str);
			for(int j=0;j<y;j++)
			{
				ch=fis.read();
				if(ch!=-1)
					fos.write(ch);
			}
		}
		fis.close();
		f.delete();
	}
}