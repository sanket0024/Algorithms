package complex;
public class Complex
{
	private int a,b,c,d,l,m,count=0;
	public void set(int x,int y)
	{
		count++;
		if(count==1)
		{	
			a=x;
			b=y;
		}
		else
		{
			c=x;
			d=y;
		}
	}
	public void sum()
	{
		l=a+c;
		m=b+d;
	}
	public void sub()
	{
		l=a-c;
		m=b-d;
	}
	public void show()
	{
		System.out.print("\nComplex term is: "+l+"+i"+m);
	}
}
