class Power
{
	public static void main(String args[])
	{
		int a,b,c;
		a=c=(int)(Math.random()*10);
		b=(int)(Math.random()*10);
		if(b==0)
		{
			a=c=1;
		}
		System.out.print("a= "+a+"\nb= "+b);
		for(int i=0;i<b-1;i++)
		{
			a=a*c;
		}
		System.out.print("\n'a' raise to the power 'b' is: "+a);
	}
}