class SelectionSort {
	public int[] sort(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			int keyId = i;
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j] < arr[keyId]) {
					keyId = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[keyId];
			arr[keyId] = temp;
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
		SelectionSort is = new SelectionSort();
		int[] arr = {1,4,7,2,4,7,9,4,2,5,8,9};
		arr = is.sort(arr);
		is.printArray(arr);
	}
}