import java.util.Set;
import java.util.HashSet;
class AllUnique {
	static public boolean allUnique(String s) {
		char[] chToStr = s.toCharArray();
		Set<Character> setChar = new HashSet<Character>();
		for(int i=0; i<chToStr.length; i++) {
			setChar.add(chToStr[i]);
		}
		if(s.length() == setChar.size())
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		System.out.println(allUnique ("Sasnket"));
	}
}