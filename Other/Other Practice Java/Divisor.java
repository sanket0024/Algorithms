class Divisior
{
	public static void main(String args[])
	{
		int a,b,c=0,min,divisior1=1,divisior2;
		a=(short)(Math.random()*100);
		b=(short)(Math.random()*100);
		System.out.print("Numbers are: "+a+" and "+b);
		if(a<b)
		{
			min=a;
		}
		else if(a==b)
		{
			min=a;
		}
		else
		{
			min=b;
		}
		for(int i=1;i<=min;i++)
		{
			if(a%i==0 && b%i==0)
			{
				divisior1=i;
			}
			divisior2=divisior1;
			c=(divisior1>divisior2)?divisior1:divisior2;
		}
		System.out.print("\nGreatest commom divisior of "+a+" and "+b+" is: "+c);
	}
}