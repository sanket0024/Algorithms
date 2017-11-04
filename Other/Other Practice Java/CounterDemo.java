class CounterDemo
{
	public static void main(String args[])
	{
		Counter count=new Counter();
		UseCounter1 u1=new UseCounter1(count);
		UseCounter1 u2=new UseCounter1(count);
		u1.start();
		//u2.start();
	}
}