class QuickSort {
	public int partition(int[] arr, int lo, int hi) {
		int pivot = arr[hi];
		int left = lo-1;
		for(int i=lo; i<hi; i++) {
			if(arr[i] <= pivot) {
				left++;
				int temp = arr[left];
				arr[left] = arr[i];
				arr[i] = temp;
			}
		}
		left++;
		int temp = arr[left];
		arr[left] = arr[hi];
		arr[hi] = temp;
		return left;
	}

	public void sort (int[] arr, int lo, int hi) {
		if(lo < hi) {
			int pivot = partition(arr, lo, hi);
			sort(arr, lo, pivot-1);
			sort(arr, pivot+1, hi);
		}
	}

	public void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		QuickSort is = new QuickSort();
		int[] arr = {1,4,7,2,4,7,9,4,2,5,8,9};
		is.sort(arr, 0 , arr.length-1);
		is.printArray(arr);
	}
}