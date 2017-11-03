/*
@author - Sanket Mathur
*/
import java.util.*;
class Anagram {
	public static void main(String args[]) {
		System.out.println(anagrams("anad", "dana"));
	}
	public static Boolean anagrams(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;
		else {
			List<Character> l1 = new ArrayList<Character>();
			List<Character> l2 = new ArrayList<Character>();
			for(int i=0; i<str1.length(); i++) {
				l1.add(str1.charAt(i));
				l2.add(str2.charAt(i));	
			}
			Collections.sort(l1);
			Collections.sort(l2);
			Iterator it1 = l1.iterator();
			Iterator it2 = l2.iterator();
			while(it1.hasNext()) {
				if(it1.next() != it2.next())
					return false;
			}
			//int numnerOfAnagrams = countAnagram(l1);
			//System.out.println("Numner of Anagrams : " + countAnagram(str1));
			//int x = repeation(str1);
			return true;
		}
	}
	public static int countAnagram(String str1) {
		int num = (factorialStringLength(str1.length()))/repeation(str1);
		return num;
	}
	public static int factorialStringLength(long a) {
		int fact = 1;
		for(long i=a; i>0; i--) {
			fact *= i;
		}
		return fact;
	}
	public static int repeation(String str1) {
		int repeationMultiply = 1;
		String strNew = "";
		Set<Character> s = new HashSet<Character>();
		for(int i=0; i<str1.length(); i++) {
			s.add(str1.charAt(i));
		}
		Iterator it = s.iterator();
		/*while(it.hasNext()) {
			strNew.concat("" + it.next());
		}*/
		while(it.hasNext()) {
			repeationMultiply *= factorialStringLength(str1.chars().mapToObj(i -> (char)i)
				.filter(c -> c == it.next()).count());
			//System.out.println(it.next());
		}
		return repeationMultiply;
	}
}