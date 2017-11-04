class SumFiveDigits
{
	public static void main(String args[])
	{
		long a;
		long sum=0,rem;
		a=(long)(Math.random()*100000);
		System.out.print("a=: "+a);
		for(int i=1;i<=5;i++)
		{
			rem=a%10;
			a=a/10;
			sum=sum+rem;
		}
		System.out.print("\nsum is: "+sum);
	}
}