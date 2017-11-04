//package library;
//import library.Item;
import java.io.*;
class Dvd implements Item
{
	private String title[]=new String[10];
	private String direction[]=new String[10];
	private String category[]=new String[10];
	public int a=0;
	public void read()
	{
		Console con=System.console();
		for(int i=a;i<=9;i++)
		{
			System.out.print("Enter movie title: ");
			title[i]=con.readLine();
			System.out.println();
			System.out.print("Enter director of the movie: "+"\n");
			direction[i]=con.readLine();
			System.out.println();
			System.out.println("Enter movie category: "+"\n");
			category[i]=con.readLine();
			System.out.println();
			a=i;
			break;
		}
	}
	public void show()
	{
		for(int i=0;i<a;i++)
		{
			System.out.print("Title: "+title[i]+"   "+"Director: "+direction[i]+"   "+"Category: "+category[i]+"\n");
		}
	}
}
