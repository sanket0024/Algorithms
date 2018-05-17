public class HeapSort {
	private void heapify(int arr[], int n, int root) {
		int max = root;
		int left = 2*root+1;
		int right = 2*root+2;
		if(left < n && arr[root] < arr[left]) {
			max = left;
		}
		if(right < n && arr[max] < arr[right]) {
			max = right;
		}
		if(max != root) {
			int temp = arr[root];
			arr[root] = arr[max];
			arr[max] = temp;
			heapify(arr, n, max);
		}
	}

	public void heapSort(int arr[]) {
		for (int i=arr.length/2 - 1; i>=0; i--) {
			heapify(arr, arr.length, i);
		}
		for(int i=arr.length-1; i>=0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, i, 0);
		}
	}

	public void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		HeapSort is = new HeapSort();
		int[] arr = {1,4,7,2,4,7,9,4,2,5,8,9};
		is.heapSort(arr);
		is.printArray(arr);
	}

}