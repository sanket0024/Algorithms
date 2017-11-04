class UseCaller
{
	public static void main(String args[])
	{
		Callme target=new Callme();
		Caller ob1=new Caller(target, "Hello");
		Caller ob2=new Caller(target, "Sanket");
		Caller ob3=new Caller(target, "Mathur");
	}
}