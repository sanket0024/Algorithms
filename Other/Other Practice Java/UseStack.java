class UseStack
{
	public static void main(String s[])
	{
		Stack <Integer>st=new Stack <Integer>();
		System.out.print("Stack is: "+st);
		push(st,22);
		push(st,44);
		push(st,56);
		push(st,11);
		try
		{
			pop(st);
		}
		catch(EmptyStackException e)
		{
			System.out.print("Stack is empty");
		}
	}
}	