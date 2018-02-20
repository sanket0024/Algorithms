class Sqrt {
	public int sqrt(int n) {
		int lo = 0;
		int hi = Integer.MAX_VALUE;
		int mid=0;
		while(hi>=lo) {
			mid = lo + (hi-lo)/2;
			if(mid*mid == n) {
				return mid;
			}
			else if(mid*mid < n) {
				lo = mid+1;
			}
			else {
				hi = mid-1;
			}
		}
		return mid;
	}
}