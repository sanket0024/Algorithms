class Pattern4
{
	public static void main(String args[])
	{
		short no,j,k=0;
		no=(short)(Math.random()*10);
		System.out.print("Number is: "+no+"\n");
		for(int i=0;i<=no;i++)
		{
			for(j=0;j<i;j++)
			{
				System.out.print(k++);
				if(k==10)
				{
					k=0;
				}
			}
			
			System.out.println();
		}
	}
}
