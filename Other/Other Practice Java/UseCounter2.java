class UseCounter2 extends Thread
{
	Counter c2;
	public UseCounter2(Counter c)
	{
		c2=c;
	}
	public void run()
	{
		for(int i=5;i<10;i++) 
		{
			c2.setCount(i);
			System.out.println("UseCounter2 : "+c2.getCount());
		}
	}
}