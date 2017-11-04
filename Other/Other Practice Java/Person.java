package employee.contact.person;
class Person
{
	private String name;
	private String sname;
	public Person(String a,String b)
	{
		name=a;
		sname=b;
	}
	public Person(String a)
	{
		name=a;
		sname=null;
	}
	public Person()
	{
		this("unknown");
	}
	public void show()
	{
		System.out.print("Enter full name: "+name+" "+sname);
	}
}