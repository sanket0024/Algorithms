package StringComp;
class StringComparison
{
	public static void main(String args[])
	{
		String a="hello";
		String b="hello";
		String c=b;
		String d="Hello";
		System.out.println(a==b);
		System.out.println(b==c);
		System.out.println(c==d);
		System.out.println(c.equals(d));
	}
}