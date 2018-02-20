public class CheckPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(hasPalindrome("abczxy1yxzabc".toCharArray()));
		System.out.println(hasPalindrome("xmadedame".toCharArray()));
		System.out.println(hasPalindrome("1234abba5671".toCharArray()));
		System.out.println(hasPalindrome("madam".toCharArray()));
		System.out.println(hasPalindrome("abcc".toCharArray()));
		System.out.println(hasPalindrome("a".toCharArray()));
		
	}
	
	public static boolean hasPalindrome(char[] s) {
		int j = s.length - 1;
		int midPoint = s.length / 2;
		boolean hasPalindrome = false;
		for (int i=0;i<=midPoint; i++) {
			if (s[i] == s[j]) {
				hasPalindrome = true;
			} else {
				hasPalindrome = false;
			}
			j--;
		}
		return hasPalindrome;
	}
}