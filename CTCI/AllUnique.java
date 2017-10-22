import java.util.Set;
import java.util.HashSet;
class AllUnique {
	static public boolean allUnique(String s) {
		/*char[] chToStr = s.toCharArray();
		Set<Character> setChar = new HashSet<Character>();
		for(int i=0; i<chToStr.length; i++) {
			setChar.add(chToStr[i]);
		}
		if(s.length() == setChar.size())
			return true;
		else
			return false;*/
		boolean[] char_set = new boolean[256];
		for(int i=0; i<s.length(); i++) {
			int val = s.charAt(i);
			System.out.println(val + "   " + char_set[val]);
			if (char_set[val]) return false;
			char_set[val] = true;
		}
		return true;
	}
	public static void main(String[] args) {
		//System.out.println(allUnique ("SaSnket"));
		System.out.println("sanket".charAt(0));
	}
}