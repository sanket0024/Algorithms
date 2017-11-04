class Fcatorial
{
	public static void main(String args[])
	{
		int no;
		no=(int)(Math.random()*10);
		System.out.print("Number is: "+no);
		if(no==0)
		{
			no=1;
		}
		for(int i=no-1;i>0;i--)
		{
			no=no*i;
		}
		System.out.print("\nFactorial is: "+no);
	}
}