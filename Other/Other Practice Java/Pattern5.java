class Pattern5
{
	public static void main(String args[])
	{
		int no,i;
		no=(int)(Math.random()*10);
		System.out.print("Number is: "+no+"\n");
		for(i=no-1;i>=0;i--)
		{
			for(int j=i;j>=0;j--)
			{
				System.out.print(" ");
			}
			for(int k=i;k<no;k++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
}