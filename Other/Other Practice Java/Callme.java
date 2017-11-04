class Callme
{
	public void call(String msg) throws InterruptedException
	{
		synchronized(this)
		{
			System.out.print("["+msg);
			Thread.sleep(2000);
			System.out.print("]");
		}
	}
}