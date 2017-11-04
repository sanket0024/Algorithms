class Occurance
{
	public static void main(String args[])
	{
		int no,count=1,a=0,max=0;
		System.out.print("Numbers are: ");
		for(int i=0;i<10;i++)
		{
			no=(int)(Math.random()*10);
			System.out.print(no+"  ");
			if(max<no)
			{
				count=0;
			}
			if(a<no)
			{
				if(no>max)
					max=no;
			}
			a=no;
			if(max==no)
			{
				count++;
			}
		}
		System.out.print("\nMaximum number is: "+max+"\nIt occured "+count+" times.");
	}
}