class Pattren1
{
	public static void main(String args[])
	{
		int no,i,j;
		no=(int)(Math.random()*10);
		System.out.print("number is: "+no+"\n");
		for(i=1;i<=no;i++)
		{
			for(j=1;j<=i;j++)
			{
				System.out.print(i);
			}
			System.out.println();
		}
	}
}