class TwoTh extends Thread
{
	public void run()
	{
		for(int i=0;i<5;i++)
		{
			System.out.print("Two ");
			try
			{
				Thread.sleep(5000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}