class UseMatrix
{
	public static void main(String args[])
	{
		Matrix m1=new Matrix();
		m1.show();
		Matrix m2=new Matrix(2,2);
		m2.show();
		Matrix m3=new Matrix(m2);
		m3.show();
	}
}