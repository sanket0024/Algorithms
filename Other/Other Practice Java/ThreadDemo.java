class ThreadDemo
{
	public static void main(String args[])
	{
		try
		{
			OneTh o=new OneTh();
			TwoTh t=new TwoTh();
			ThreeTh th=new ThreeTh();
			o.start();
			t.start();
			th.start();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}