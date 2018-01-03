class MergeSort {
	/*
	* Divide and conquer algorthim.
	*/
	public void merge(int[] arr, int l, int m, int r) {
		int[] temp1 = new int[m-l+1];
		int[] temp2 = new int[r-m];
		for(int i=0; i<temp1.length; i++) {
			temp1[i] = arr[l+i];
		}
		for(int j=0; j<temp2.length; j++) {
			temp2[j] = arr[m+1+j];
		}
		int k=l, i=0, j=0;
		while(i<temp1.length && j<temp2.length) {
			if(temp1[i] < temp2[j]) {
				arr[k] = temp1[i];
				i++;
			}
			else {
				arr[k] = temp2[j];
				j++;
			}
			k++;
		}
		while(i<temp1.length) {
			arr[k] = temp1[i];
			i++;
			k++;
		}
		while(j<temp2.length) {
			arr[k] = temp2[j];
			j++;
			k++;
		}
	}

	public void mergeSort(int[] arr, int l, int r) {
		if(l<r) {
			int m = (l+r)/2;
			
			// splitting the array
			mergeSort(arr, l, m);
			mergeSort(arr, m+1, r);

			// merging the arrays in sorted manner
			merge(arr, l, m, r);
		}
	}

	public void printArray(int[] a) {
		for(int x: a)
			System.out.println(x);
	}
	public static void main(String args[]){
		int array[] = {1,2,5,7,2,41,3,53,0};
		MergeSort ms = new MergeSort();
		ms.mergeSort(array, 0, array.length-1);
		ms.printArray(array);
	}


	/*public static void main(String args[]){
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
	}*/
}