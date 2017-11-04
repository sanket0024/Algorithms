class MinMax10
{
	public static void main(String args[])
	{
		short no,a,max=0,min=99;
		System.out.print("Numbers generated are: ");
		a=(short)(Math.random()*100);
		System.out.print(a+"  ");
		for(int i=1;i<=9;i++)
		{
			no=(short)(Math.random()*100);
			System.out.print(no+"  ");
			if(a<no)
			{
				if(no>max)
					max=no;
				if(a<min)
					min=a;
			}
			/*else
			{
				max=a;
				min=no;
			}*/
			a=no;
		}
		System.out.print("Maximum is: "+max+"\nMininum is: "+min);
	}
}