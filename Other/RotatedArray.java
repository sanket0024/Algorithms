class RotatedArray {
	public int findK(int[] arr) {
		int lo = 0;
		int hi = arr.length-1;
		int mid = 0;
		while(hi-lo > 1) {
			mid = lo+(hi-lo)/2;
			if(arr[mid] < arr[lo] && arr[mid] < arr[hi]) {
				hi = mid;
			}
			else {
				lo = mid;
			}
		}
		if(arr[lo] < arr[hi]) {
			return lo;
		}
		else {
			return hi;
		}
	}

	public static void main(String[] args) {
		int[] arr = {71, 5, 15, 20, 30, 40, 44, 54};
		RotatedArray r = new RotatedArray();
		System.out.println(r.findK(arr));
	}
}