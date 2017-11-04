public class TopLevel
{
	static final Integer i1=1;
	final Integer i2=2;
	Integer i3=3;
	public static void main(String args[])
	{
		final Integer i4=4;
		Integer i5=5;
		class Inner
		{
			final Integer i6=6;
			Integer i7=7;
			public Inner(final Integer i8, Integer i9)
			{
				System.out.println(i1);
				System.out.println(i2);
				System.out.println(i3);
				System.out.println(i4);
				System.out.println(i5);
				System.out.println(i6);
				System.out.println(i7);
				System.out.println(i8);
				System.out.println(i9);
			}
		}
		new Inner(8,9);
	}
}