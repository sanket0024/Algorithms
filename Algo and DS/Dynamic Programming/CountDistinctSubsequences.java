import java.util.Arrays;
class CountDistinctSubsequences {
	public int countDistinctSubsequences(String s) {
		// base case
		if(s == null) {
			return 0;
		}
		if(s == "") {
			return 1;
		}
		int n = s.length();
		int[] dp = new int[n+1];
		dp[0] = 1;
		int[] chars = new int[26];
		Arrays.fill(chars, -1);
		for(int i=1; i<dp.length; i++) {
			dp[i] = 2*dp[i-1];
			if(chars[s.charAt(i-1)-'a'] != -1) {
				dp[i] = dp[i] - dp[chars[s.charAt(i-1)-'a']];
			}
			chars[s.charAt(i-1)-'a'] = i-1;
		}
		return dp[n];
	}
	public static void main(String[] args) {
		CountDistinctSubsequences c = new CountDistinctSubsequences();
		int res = c.countDistinctSubsequences("gfg");
		System.out.println(res);
	}
}