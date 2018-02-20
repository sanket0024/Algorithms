class NWSE {
	public void nwsePrint(int[][] nums) {
		int i = nums.length-1;
		int j = 0;
		int tempI = nums.length-1;
		int count = nums.length + nums[0].length - 2;
		while(count >= 0) {
			count--;
			if(i<0) {
				tempI = 0;
				j = Math.abs(i);
			}
			else {
				tempI = i;
				j=0;
			}
			while(j<nums[0].length && tempI < nums.length) {
				System.out.print(nums[tempI][j] + " ");
				tempI++;
				j++;
			}
			System.out.println();
			i--;
		}
	}
	public static void main(String[] args) {
		NWSE n = new NWSE();
		int[][] arr = {{1,2,3}, {5,6,7}, {9,10,11}, {12,13,14}, {15,16,17}};
		n.nwsePrint(arr);
	}
}