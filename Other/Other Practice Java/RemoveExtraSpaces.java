class RemoveExtraSpaces
{
	public static void main(String args[]) throws IOException
	{
		if(args.length>1)
		{
			System.out.print("Too many parameters");
			System.exit(0);
		}
		if(args.length<1)
		{
			System.out.print("Too few parameters");
			System.exit(0);
		}
		File f=new File(args[0]);
		if(!f.exists())
		{
			System.out.print("No such file in the directory");
			System.exit(0);
		}
		File temp=new File("temp.txt");
		temp.createNewFile();
		FileInputStream fis= new FileInputStream(args[0]);
		BufferedInputStream bis= new BufferedInputStream(fis);
		FileOutputStream fos=new FileOutputStream("temp.txt");
		BufferedOutputStream bos= new BufferedOutputStream(fos);
		int ch, x=' ';
		while((ch=bis.read())!=-1)
		{
			
		}
	}
}