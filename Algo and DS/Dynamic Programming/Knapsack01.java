import java.util.*;
class Knapsack01 {
	public List<Integer> maxValuesAdded(int[] item, int[] weight, int[] value, int maxWeight) {
		int[][] dp = new int[item.length+1][maxWeight+1];
		for(int i=0; i<=maxWeight; i++) {
			dp[0][i] = 0;
		}
		for(int i=0; i<dp.length; i++) {
			dp[i][0] = 0;
		}
		for(int i=1; i<dp.length; i++) {
			for(int j=1; j<dp[0].length; j++) {
				if(j < weight[i-1]) {
					dp[i][j] = dp[i-1][j];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], value[i-1]+dp[i-1][j-weight[i-1]]);
				}
			}
		}

		// for(int i=0; i<dp.length; i++) {
		// 	for(int j=0; j<dp[0].length; j++) {
		// 		System.out.print(dp[i][j] + "  ");
		// 	}
		// 	System.out.println();
		// }

		// return the list of items added to the knapsack
		System.out.println("maximum value: " + dp[item.length][maxWeight]);
		List<Integer> res = new ArrayList<Integer>();
		int i=item.length;
		int j=maxWeight;
		while(i > 0 && j > 0) {
			if(dp[i][j] != dp[i-1][j]) {
				res.add(item[i-1]);
				j-=weight[i-1];
			}
			i--;
		}
		return res;
	}

	static void print(List<Integer> ls) {
		Iterator<Integer> it = ls.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + "  ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] weight = {1,3,4,5};
		int[] item = {12,13,14,15};
		int[] values = {1,4,5,7};
		int maxWeight = 7;
		Knapsack01 k = new Knapsack01();
		List<Integer> res = k.maxValuesAdded(item, weight, values, maxWeight);
		print(res);
	}
}