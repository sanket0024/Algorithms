import java.util.*;
class Stack
{
	static public void push(Stack st,int a)
	{
		//st.push(st,a);
		System.out.print("Entered numbr is:"+a);
		System.out.print("\nStack is: "+st);
	}
	static public void pop()
	{
		//int a=st.pop();
		System.out.print(a);
		System.out.print("\nStack.is: "+st);
		//return a;
	}
	public static void main(String s[])
	{
		Stack st=new Stack();
		System.out.print("Stack is: "+st);
		push(st,22);
		push(st,44);
		push(st,56);
		push(st,11);
		try
		{
			int a=pop();
		}
		catch(EmptyStackException e)
		{
			System.out.print("Stack is empty");
		}
	}
}	