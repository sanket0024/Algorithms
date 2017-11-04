class AnagramSubstring {
	public static void main(String[] args) {
		anagramSubStringSearch("aabcacbbca", "abc");
	}
	public static Boolean compare(int[] arr1, int[] arr2) {
		for(int i=0; i<arr1.length; i++) {
			if(arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
	public static void anagramSubStringSearch(String text, String pat) {
		int[] countText = new int[256];
		int[] countPattern = new int[256];
		for(int i = 0; i<pat.length(); i++) {
			countText[text.charAt(i)]++;
			countPattern[pat.charAt(i)]++;
		}
		for(int i=pat.length(); i<text.length(); i++) {
			if(compare(countText, countPattern)) {
				System.out.println("Match found : " + (i - pat.length()));
			}
			countText[text.charAt(i)]++;
			countText[text.charAt(i - pat.length())]--;
		}
		if(compare(countText, countPattern)) {
			System.out.println("Match found : " + (text.length() - pat.length()));
		}
	}
}