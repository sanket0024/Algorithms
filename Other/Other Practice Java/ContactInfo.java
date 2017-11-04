package employee.contact;
import employee.contact.person.*;
 class ContactInfo extends Person
{
	private long phone;
	public ContactInfo(String a,String b,long c)
	{
		super(a,b);
		phone=c;
	}
	public ContactInfo(String a,String b)
	{
		super(a,b);
		phone=0;
	}
	public void show()
	{
		super.show();
		System.out.print("Enter number: "+phone);
	}
}