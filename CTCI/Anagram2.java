class Anagram2 {
	public static void main(String args[]) {
		System.out.println(isAnagram("abca", "aabc"));
	}
	/*
	*It will take 2 strings to compare */
	public static Boolean isAnagram(String str1, String str2) {
		if(str1.length() != str2.length()){
			System.out.println("From Here");
			return false;
		}
		/*
		*an array of size 256 that will keep the count for every character
		*/
		int[] letters = new int[256];
		//Number of unique characters in the str1
		int uniqueChar = 0;
		//Number of characters processed in srt2
		int processedChar = 0;
		for(int i=0; i<str1.length(); i++) {
			/*
			*check if the count for the character is 0
			*if it is 0 then it is a unique character, so increase it by 1
			*/
			if(letters[str1.charAt(i)] == 0)
				uniqueChar++;

			letters[str1.charAt(i)]++;
		}
		for(int i=0; i<str2.length(); i++) {
			int ch = str2.charAt(i);
			if(letters[ch] == 0) {
				System.out.println("****From Here");
				return false;
			}
			letters[ch]--;
			if(letters[ch] == 0) {
				processedChar++;
				if(processedChar == uniqueChar)
					return i == str2.length()-1;
			}
		}
		System.out.println("From Here$$$$$$$$$$$$$$");
		return false;
	}
}