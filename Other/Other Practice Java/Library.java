//package library;
//import library.Item;
//import library.Book;
//import library.Dvd;
import java.io.*;
class Library
{
	public static void main(String args[])
	{
		int ch;
		Console con=System.console();
		Item a;
		System.out.print("Types of items are: "+Item.TYPES_OF_ITEMS);
		for(int i=0;i<=1;i++)
		{
			System.out.print("Enter choice 'b' or 'd': ");
			ch=Integer.parseInt(con.readLine());
			if(ch=='b')
			{
				a=new Book();
				a.read();
			}
			else
			{
				a=new Dvd();
				a.read();
			}
		}
		a=new Book();
		a.show();
		a=new Dvd();
		a.show();
	}
}
