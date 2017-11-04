class pattern3
{
	public static void main(String args[])
	{
		int no,x,i,j,k,l;
		no=(int)(Math.random()*10);
		x=no;
		System.out.print("Number is: "+no+"\n");
		for(i=1;i<=no;i++)
		{
			for(j=x-1;j>=1;j--)
			{
				System.out.print(" ");
			}
			for(k=1;k<=i;k++)
			{
				System.out.print(k);
			}
			for(l=k-2;l>0;l--)
			{
				System.out.print(l);
			}
			x--;
			System.out.print("\n");
		}
	}
}
