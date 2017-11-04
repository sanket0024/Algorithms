import java.io.*;
class Matrix
{
	private int arr[][];
	public Matrix(int a,int b)
	{
		Console con=System.console();
		arr=new int[a][b];
		System.out.print("enter values:\n");
		for(int i=0;i<a;i++)
		{
			for(int j=0;j<b;j++)
			{
				arr[i][j]=Integer.parseInt(con.readLine());
			}
		}
	}
	public Matrix(int a)
	{
		this(a,3);
	}
	public Matrix()
	{
		this(3,3);
	}
	public Matrix(Matrix m)
	{
		//Console con=System.console();
		//System.out.print(m.arr.length+" "+m.arr[m.arr.length].length);
		
		//arr=new int[m.arr.length][m.arr[m.arr.length].length];
		//System.out.print("enter values:\n");
		for(int i=0;i<m.arr.length;i++)
		{
			for(int j=0;j<m.arr[i].length;j++)
			{
				arr[i][j]=m.arr[arr.length][arr[i].length]; 
			}
		}
	}
	public void read(int a,int b)
	{
		Console con=System.console();
		arr=new int[a][b];
		System.out.print("enter values:\n");
		for(int i=0;i<=arr.length;i++)
		{
			for(int j=0;j<=arr[i].length;j++)
			{
				arr[i][j]=Integer.parseInt(con.readLine());
			}
		}
	}
	public void read(int a)
	{
		read(a,3);
	}
	public void read()
	{
		read(3,3);
	}
	void show()
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}