class MinMax
{
	public static void main(String args[])
	{
		int min,min1,min2,max,max1,max2,a,b,c,d;
		a=(int)(Math.random()*100);
		b=(int)(Math.random()*100);
		c=(int)(Math.random()*100);
		d=(int)(Math.random()*100);
		System.out.println("a="+a+"\nb="+b+"\nc="+c+"\nd="+d);
		if(a>b)
		{
			max1=a;
			min1=b;
		}
		else
		{
			max1=b;
			min1=a;
		}
		if(c>d)
		{
			max2=c;
			min2=d;
		}
		else
		{
			max2=d;
			min2=c;
		}
		if(max1>max2)
			System.out.print("Maximum is="+max1);
		else
			System.out.print("Maximum is="+max2);
		if(min1>min2)
			System.out.print("Minimum is="+min2);
		else
			System.out.print("Minimum is="+min1);
	}
}