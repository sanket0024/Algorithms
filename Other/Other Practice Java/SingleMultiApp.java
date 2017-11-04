class SingleMultiApp
{
	public static void main(String args[])
	{
		int count=0,a,rem;
		int b;
		a=(int)(Math.random()*10);
		b=(int)(Math.random()*100000);
		System.out.print("a= "+a);
		System.out.print("\nb= "+b);
		for(int i=1;i<=5;i++)
		{
			rem=b%10;
			b=b/10;
			if(rem==a)
			{
				count++;
			}
		}
		System.out.print("\nNumber of times 'a' appears in 'b' are: "+count);
	}
}