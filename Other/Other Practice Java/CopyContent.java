import java.io.*;
class CopyContent 
{
	public static void main(String args[]) throws IOException
	{
		if(args.length<3)
		{
			System.out.print("Too few parameters\n");
			System.exit(0);
		}
		if(args.length>3)
		{
			System.out.print("Too many parameters");
			System.exit(0);
		}
		File f=new File(args[0]);
		File f1=new File(args[1]);
		if((!f.exists()) && (!f1.exists()))
		{
			System.out.print("file does not exists");
			System.exit(0);
		}
		FileInputStream fis= new FileInputStream(args[0]);
		BufferedInputStream bis= new BufferedInputStream(fis);
		FileOutputStream fos= new FileOutputStream(args[2]);
		BufferedOutputStream bos= new BufferedOutputStream(fos);
		int ch;
		while((ch=bis.read())!=-1)
		{
			bos.write(ch);
		}
		bis.close();
		bos.close();
		fis=new FileInputStream(args[1]);
		bis=new BufferedInputStream(fis);
		fos=new FileOutputStream(args[2],true);
		bos=new BufferedOutputStream(fos);
		int ch1;
		while((ch1=bis.read())!=-1)
		{
			bos.write(ch1);
		}
		bis.close();
		bos.close();
	}
}