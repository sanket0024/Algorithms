public class Rational
{
	private int numerator,denomerator;
	public Rational(int a, int b) throws InvalidAmountException
	{
		if(a>=0&&b>=0)
		{
			numerator=a;
			denomerator=b;
		}
		else
		{
			InvalidAmountException e=new InvalidAmountException("Amount can't be negative");
			throw e;
		}
	}
	public Rational(int a) throws InvalidAmountException
	{
		this(a,1);
	}
	public Rational() throws InvalidAmountException
	{
		this(1,1);
	}
	public Rational(Rational r) throws InvalidAmountException
	{
		this(r.numerator,r.denomerator);
	}
	public void set(int a, int b) throws InvalidAmountException
	{
		if(a>=0 && b>=0)
		{
			numerator=a;
			denomerator=b;
		}
		else
		{
			throw new InvalidAmountException("Amount can't be negative");
		}
	}
	public void set(int a) throws InvalidAmountException
	{
		set(a,1);
	}
	public void set() throws InvalidAmountException
	{
		set(1,1);
	}
	public Rational add(Rational r1) throws InvalidAmountException
	{
		Rational temp=new Rational();
		temp.numerator=(numerator*r1.denomerator)+(denomerator*r1.numerator);
		temp.denomerator=denomerator*r1.denomerator;
		return temp;
	}
	public Rational subtract(Rational r2) throws InvalidAmountException
	{
		Rational temp=new Rational();
		temp.numerator=(numerator*r2.denomerator)-(denomerator*r2.numerator);
		temp.denomerator=denomerator*r2.denomerator;
		return temp;
	}
	public Rational multiply(Rational r3) throws InvalidAmountException
	{
		Rational temp=new Rational();
		temp.numerator=numerator*r3.numerator;
		temp.denomerator=denomerator*r3.denomerator;
		return temp;
	}
	public Rational divide(Rational r4) throws InvalidAmountException
	{
		Rational temp=new Rational();
		temp.numerator=numerator*r4.denomerator;
		temp.denomerator=denomerator*r4.numerator;
		return temp;
	}
	public void show()
	{
		System.out.print("Fraction is: "+numerator+"/"+denomerator+"\n");
	}
}