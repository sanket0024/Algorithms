class CountingSort {
	public int[] sort(int[] arr) {
		int[] range = new int[10];
		int[] res = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			range[arr[i]]++;
		}
		for(int i=1; i<range.length; i++) {
			range[i] += range[i-1];
		}
		for(int i=0; i<res.length; i++) {
			res[range[arr[i]]-1] = arr[i];
			range[arr[i]]--;
		}
		return res;
	}

	public void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		CountingSort is = new CountingSort();
		int[] arr = {1,4,7,2,4,7,9,4,2,5,8,9};
		arr = is.sort(arr);
		is.printArray(arr);
	}
}