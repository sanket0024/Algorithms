class CountDistinctOccurrencesSubsequences {
	public int countDistinctOccurrencesSubsequences (String s1, String s2) {
		if(s1 == null || s2 == null) {
			return 0;
		}
		if(s1 == "" || s2 == "") {
			return 0;
		}

		int m = s1.length();
		int n = s2.length();

		int[][] dp = new int[m+1][n+1];

		for(int i=0; i<dp[0].length; i++) {
			dp[0][i] = 1;
		}
		for(int j=1; j<dp.length; j++) {
			dp[j][0] = 0;
		}
		for(int i=1; i<dp.length; i++) {
			for(int j=1; j<dp[0].length; j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
				}
				else {
					dp[i][j] = dp[i][j-1];
				}
			}
		}
		for (int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				System.out.print(dp[i][j] + "  ");
			}
			System.out.println();
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		CountDistinctOccurrencesSubsequences c = new CountDistinctOccurrencesSubsequences();
		int res = c.countDistinctOccurrencesSubsequences("ge", "geeksforgeeks");
		System.out.println(res);
	}
}