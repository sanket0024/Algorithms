/*
* Two arrays will be required
* 1. Store the pattern
* 2. Store the current window
* 
*
* 1. Loop through the pattern and update the characters in the pattern array and first window array
* 2. Loop through the remaining text characters
* 3.  Compare the two array. If they are identical, then pattern found
* 4.  Increase the window to include the next character
* 5.  Remove first character from the beginning
*    End of loop
* 6. Manually check for the last text window, as it won't get checked
*/

class AnagramSubstring {
	public boolean compare(char[] pat, char[] txt) {
		for(int i=0; i<256; i++) {
			if(pat[i] != txt[i]) {
				return false;
			}
		}
		return true;
	}

	public void anagramSubstring (String pat, String txt) {
		// two arrays
		char[] arrPat = new char[256];
		char[] arrTxtWindow = new char[256];

		// initialize the above arrays with the pattern and initial window
		for(int i=0; i<pat.length(); i++) {
			arrPat[pat.charAt(i)]++;
			arrTxtWindow[txt.charAt(i)]++;
		}

		//loop through the remaining txt characters and increment the window
		for(int i=pat.length(); i<txt.length(); i++) {
			if(compare(arrPat, arrTxtWindow)) {
				System.out.println("Found at: " + (i-pat.length()));
			}
			arrTxtWindow[txt.charAt(i)]++;
			arrTxtWindow[txt.charAt(i-pat.length())]--;
		}
		if(compare(arrPat, arrTxtWindow)) {
			System.out.println("Found at: " + (txt.length() - pat.length()));
		}
	}

	public static void main(String[] args) {
		AnagramSubstring as = new AnagramSubstring();
		as.anagramSubstring("AA", "BGAAAA");
	}
}