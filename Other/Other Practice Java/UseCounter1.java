class UseCounter1 extends Thread
{
	Counter c1;
	public UseCounter1(Counter c)
	{
		c1=c;
	}
	public void run()
	{
		for(int i=0;i<5;i++)
		{
			c1.setCount(i);
			System.out.println("UseCounter1 : "+c1.getCount());
		}
	}
}