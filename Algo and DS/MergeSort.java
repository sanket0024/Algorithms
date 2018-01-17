// divide and conquer
class MergeSort {
	public void sort(int[] arr, int l, int r) {
		if(l<r) {
			int mid = (l+r)/2;
			sort(arr, l, mid);
			sort(arr, mid+1, r);
			merge(arr, l, mid, r);
		}
	}

	public void merge(int[] arr, int l, int m, int r) {
		int n1 = m-l+1;
		int n2 = r-m;
		int[] L = new int[n1];
		int[] R = new int[n2];
		for(int i=0; i<L.length; i++) {
			L[i] = arr[l+i];
		}
		for(int i=0; i<R.length; i++) {
			R[i] = arr[m+1+i];
		}
		int i=0;
		int j=0;
		int k=l;
		while(i<n1 && j<n2) {
			if(L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			}
			else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		while(i<n1) {
			arr[k] = L[i];
			k++;
			i++;
		}
		while(j<n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	public void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MergeSort is = new MergeSort();
		int[] arr = {1,4,7,2,4,7,9,4,2,5,8,9};
		is.sort(arr, 0 , arr.length-1);
		is.printArray(arr);
	}

}