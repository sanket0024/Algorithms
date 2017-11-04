class MergeSort {
	public static void main(String args[]){
		int array[] = {1,2,5,7,2,41,3,53,0};
		mergeSort(array);
	}
	public static void mergeSort(int[] arr) {
		int[] temp = new int[arr.length];
		mergeSortSplit(arr,temp, 0, arr.length-1);
		for(int a: arr){
			System.out.println(a);
		}
	}
	public static void mergeSortSplit(int arr[], int[] temp, int leftStart, int rightEnd) {
		if(leftStart >= rightEnd)
			return;
		int middle = (leftStart + rightEnd)/2;
		mergeSortSplit(arr, temp, leftStart, middle);
		mergeSortSplit(arr, temp, middle+1, rightEnd);
		mergeSortMerge(arr, temp, leftStart, rightEnd);
	}
	public static void mergeSortMerge(int arr[], int[] temp, int leftStart, int rightEnd) {
		int leftEnd = (leftStart + rightEnd)/2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart + 1;
		int left = leftStart;
		int right = rightStart;
		int index = leftStart;
		while(left <= leftEnd && right <= rightEnd) {
			if(arr[left] <= arr[right]) {
				temp[index] = arr[left];
				left++;
			}
			else {
				temp[index] = arr[right];
				right++;
			}
			index++;
		}
		System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
		System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
		System.arraycopy(temp, leftStart, arr, leftStart, size);
	}
}