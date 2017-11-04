public class RQ800_80
{
	static String compute(long... ls)
	{
		return "one";
	}
	static String compute(Long... ls)
	{
		return "two";
	}
	static String compute(Integer i1, Integer i2)
	{
		return "three";
	}
	static String compute(Long l1, Long l2)
	{
		return "four";
	}
	static String compute(Number n1, Number n2)
	{
		return "five";
	}
	public static void main(String str[])
	{
		System.out.println(compute((byte)5, (byte)10) + ","+ compute(5,10));
		System.out.println(compute(5L,10)+","+compute(5l,10l));
	}
}