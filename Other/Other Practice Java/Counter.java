public class Counter
{
	int count=0;
	public int getCount() throws Exception
	{
		return count;
	}
	public void setCount(int count) throws Exception
	{
		this.count = count;
		Thread.sleep(1000);
	}
}