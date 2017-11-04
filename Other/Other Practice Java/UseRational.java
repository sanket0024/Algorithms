class UseRational
{
	public static void main(String args[]) throws InvalidAmountException
	{
		Rational r5=new Rational();
		Rational r6=new Rational();
		Rational r7=new Rational();
		try
		{
			r5.set(100,10);
			r5.show();
			r6.set(5,-12);
			r6.show();
			System.out.print("Fraction after addition: ");
			r7=r5.add(r6);
			r7.show();
			System.out.print("Fraction after subtraction: ");
			r7=r5.subtract(r6);
			r7.show();
			System.out.print("Fraction after multiplication: ");
			r7=r5.multiply(r6);
			r7.show();
			System.out.print("Fraction after division: ");
			r7=r5.divide(r6);
			r7.show();
		}
		catch(InvalidAmountException e)
		{
			System.out.print(e.getMessage());
		}
		
	}
}