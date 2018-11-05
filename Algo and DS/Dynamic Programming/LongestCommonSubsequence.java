class LongestCommonSubsequence {
	public String longestCommonSubsequence(String s, String t) {
		// base case
		if(s == null || s == "" || t == null || t == "") {
			return "";
		}
		int m = s.length();
		int n = t.length();
		int[][] dp = new int[m+1][n+1];
		//build matrix
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				if(i==0 || j==0) {
					dp[i][j] = 0;
				}
				else if(s.charAt(i-1) == t.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		// return the length of the longest common subsequence
		// return dp[m][n];

		char[] lcs = new char[dp[m][n]];
		int index = lcs.length-1;
		while(m>0 && n>0) {
			if(s.charAt(m-1) == t.charAt(n-1)) {
				lcs[index] = s.charAt(m-1);
				index--;
				m--;
				n--;
			}
			else if(dp[m-1][n] > dp[m][n-1]) {
				m--;
			}
			else {
				n--;
			}
		}
		return String.valueOf(lcs);
	}
	public static void main(String[] args) {
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		String res = lcs.longestCommonSubsequence("BDCABA", "ABCBDAB");
		System.out.println(res);
	}
}