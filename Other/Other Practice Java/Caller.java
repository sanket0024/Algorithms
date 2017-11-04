class Caller extends Thread
{
	String msg;
	Callme target;
	public Caller(Callme targ, String str)
	{
		target=targ;
		msg=str;
		start();
	}
	public void run()
	{
		try
		{
			target.call(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}