class Money
{
	private int rs,paisa;
	
	public void set(int a,int b)
	{
		if(a<=0 || b<=0)
		{
			rs=a;
			paisa=b;
		}
	}
	public void show()
	{
		System.out.print(rs+"."+paisa);
	}
}
