import java.io.*;
class NoOfWLS
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
			int ch,count_words=0,count_lines=0,count_sentences=0;
			String str="A";
			FileInputStream fis= new FileInputStream(args[0]);
			BufferedInputStream bis= new BufferedInputStream(fis);
			while((ch=bis.read())!=-1)
			{
				if(ch==' ' || ch=='.' || ch=='!' || ch=='?')
				{
					count_words++;
				}
				if(ch=='.' || ch=='!' || ch=='?')
				{
					count_sentences++;
				}
				if(ch==13)
				{
					count_lines++;
				}
				if(str==". " || str=="? " || str=="! ")
				{
					count_words--;
					System.out.print("df");
				}
			}
			System.out.print("Number of words are: "+count_words+"\nNumber of Sentences are: "+count_sentences+"\nNumber of Lines are: "+count_lines);
	}
}