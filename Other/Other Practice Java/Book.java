//package library;
//import library.Item;
import java.io.*;
class Book implements Item
{
	String title[]=new String[10];
	String author[]=new String[10];
	String publication[]=new String[10];
	public int a=0;
	public void read()
	{
		Console con=System.console();
		for(int i=a;i<=9;i++)
		{
			System.out.print("Enter title of book: ");
			title[i]=con.readLine();
			System.out.println();
			System.out.print("Enter author of the book: ");
			author[i]=con.readLine();
			System.out.println();
			System.out.println("Enter publication house name: ");
			publication[i]=con.readLine();
			System.out.println();
			a=i;
			break;
		}
	}
	public void show()
		{
			for(int i=0;i<a;i++)
			{
				System.out.print("Title: "+title[i]+"   "+"Author: "+author[i]+"   "+"Publication: "+publication[i]+"\n");
			}
		}
}