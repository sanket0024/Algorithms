class InsertionSort {
	public int[] sort(int[] arr) {
		for(int i=1; i<arr.length; i++) {
			int key = arr[i];
			int j = i-1;
			while(j>=0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
		return arr;
	}

	public void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		InsertionSort is = new InsertionSort();
		int[] arr = {1,4,7,2,4,7,9,4,2,5,8,9};
		arr = is.sort(arr);
		is.printArray(arr);
	}
}