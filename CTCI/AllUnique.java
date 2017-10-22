import java.util.Set;
class AllUnique {
	static public allUnique(String s) {
		char[] chToStr = s.toChar();
		Set<Character> setChar = new Set<Character>();
		for(int i=0; i<chToStr.length; i++) {
			setChar.add(chToStr[i]);
		}
		if(s.length == setChar.size())
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		System.out.println(allUnique ("Sanket"));
	}
}