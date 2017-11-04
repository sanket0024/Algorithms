import java.util.*;
public class RQ200_60
{
	private Map<String, Integer> accounts = new HashMap<String, Integer>();
	public int getBalance(String accountName)
	{
		Integer total=(Integer)accounts.get(accountName);
		if(total==null)
			total=new Integer(0);
		return total.intValue();
	}
	public void setBalance(String accountName, int amount)
	{
		accounts.put(accountName, new Integer(amount));
	}
}