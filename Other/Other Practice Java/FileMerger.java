import java.io.*;
class FileMerger
{
	public static void main(String args[]) throws IOException
	{
		Console con=System.console();
		String str;
		System.out.print("Enter the file to be merged: ");
		str=con.readLine();
		File f=new File(str);
		f.createNewFile();
		FileOutputStream fos=new FileOutputStream(str,true);
		for(int i=0;;i++)
		{
			File f1=new File(i+"."+str);
			if(!f1.exists())
			{
				System.exit(0);
			}
			FileInputStream fis=new FileInputStream(f1);
			int ch;
			while((ch=fis.read())!=-1)
			{
				fos.write(ch);
			}
			fis.close();
			f1.delete();
		}
	}
}