//ref: http://www.geeksforgeeks.org/searching-for-patterns-set-3-rabin-karp-algorithm/
// Parrern matching algorithm
// Complexity O(m+n)

/*
The average and best case running time of the Rabin-Karp algorithm is O(n+m), 
but its worst-case time is O(nm). 
Worst case of Rabin-Karp algorithm occurs when all characters of pattern and text 
are same as the hash values of all the substrings of txt[] match with hash value of pat[]. 
For example pat[] = “AAA” and txt[] = “AAAAAAA”.



Rabin-Karp algorithm also slides the pattern one by one. 
Rabin Karp algorithm matches the hash value of the pattern with the hash value of current substring of text, 
and if the hash values match then only it starts matching individual characters.

To do rehashing, we need to take off the most significant digit and 
add the new least significant digit for in hash value. Rehashing is done using the following formula.

hash( txt[s+1 .. s+m] ) = ( d ( hash( txt[s .. s+m-1]) – txt[s]*h ) + txt[s + m] ) mod q

hash( txt[s .. s+m-1] ) : Hash value at shift s.
hash( txt[s+1 .. s+m] ) : Hash value at next shift (or shift s+1)
d: Number of characters in the alphabet
q: A prime number
h: d^(m-1)
*/
class KarpRabinAlgo {
	public static final int d = 256;
	public void search(String pat, String txt, int q) {
		int M = pat.length();			// length of the pattern
		int N = txt.length();			// length of the text
		int h = 1;						// d^(M-1)
		int p = 0;						// hash value of pattern
		int t = 0;						// hash value of text
		int j = 0;

		//calculate h
		for(int i=0; i<M-1; i++) {
			h = (h*d)%q;
		}

		// calculate hash value for pattern and initial pattern size text
		for(int i=0; i<M; i++) {
			p = (d*p + pat.charAt(i))%q;
			t = (d*t + txt.charAt(i))%q;
		}

		// calculate the hash value for the remaining txt and compare
		for(int i=0; i<=N-M; i++) {
			if(p == t) {
				for(j=0; j<M; j++) {
					if(pat.charAt(j) != txt.charAt(i+j)) {
						break;
					}
				}
				if(j == M) {
					System.out.println("Matched at: " + i);
				}
			}
			// next hash for text
			if(i < N-M) {
				t = (d*(t - txt.charAt(i)*h) + txt.charAt(i+M))%q;
				if(t<0) {
					t = t + q;
				}
			}
		}
	}
	public static void main(String[] args) {
		KarpRabinAlgo kp = new KarpRabinAlgo();
		kp.search("bcd", "abcdefghijklmnopabcd", 17);
	}
}