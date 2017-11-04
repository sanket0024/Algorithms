import java.io.*;
import java.util.StringTokenizer;
import java.util.*;
class FrequencyCount
{
	public static void main(String args[]) throws IOException
	{
		int count=0;
		System.out.print("Enter file name: ");
		Console con=System.console();
		StreamTokenizer st=null;
		try
		{
			String s;
			args[0]=con.readLine();
			st=new StreamTokenizer(new FileInputStream(args[0]));
			HashMap hm=new HashMap();
			while(st.nextToken() !=StreamTokenizer.TT_EOF)
			{
				if (st.ttype == StreamTokenizer.TT_WORD)
				{
					s=st.sval;
					hm.put(s,new Integer(count++));
				}
			}
			Set set=hm.entrySet();
			Iterator i = set.iterator();
			while(i.hasNext())
			{
				Map.Entry me = (Map.Entry)i.next();
				System.out.print(me.getKey()+": ");
				System.out.println(count);
			}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.print(e.getMessage());
		}
	}
}