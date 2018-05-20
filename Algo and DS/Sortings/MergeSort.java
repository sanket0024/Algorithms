/**
 * Merge sort
 * This will sort the input integer array in the non decreasing order
 * 
 * Properties:
 * Time Complexity: O(n*logn)
 * Space Complexity: O(n)
 * Approach - divide and conquer
 * Stable: means numbers with the same value appear in the output array
 * in the same order as they do in the input array.
 */

/**
 * @author sanketmathur
 *
 */
public class MergeSort {
	
	/**
	 * Idea is to divide the arrays into half until no more
	 * division is possible and then merge them together
	 * by comparing their values
	 * 
	 * @param nums - input array
	 * @return sorted array
	 */
	public void mergeSort(int[] nums, int lo, int hi) {
		if(lo < hi) {
			int mid = lo + ((hi-lo) >> 1);
			mergeSort(nums, lo, mid);
			mergeSort(nums, mid+1, hi);
			merge(nums, lo, mid, hi);
		}
	}
	
	/**
	 * A helper method which will merge the two splitted arrays into one
	 * by comparing values
	 * @param nums
	 * @param lo
	 * @param mid
	 * @param hi
	 */
	private void merge(int[] nums, int lo, int mid, int hi) {
		 int[] arr1 = new int[mid-lo+1];
		 int[] arr2 = new int[hi-mid];
		 for(int i=0; i<arr1.length; i++) {
			 arr1[i] = nums[i+lo];
		 }
		 for(int i=0; i<arr2.length; i++) {
			 arr2[i] = nums[i+mid+1];
		 }
		 int i=0;
		 int j=0;
		 while(i<arr1.length && j<arr2.length) {
			 if(arr1[i] < arr2[j]) {
				 nums[lo] = arr1[i];
				 i++;
			 }
			 else {
				 nums[lo] = arr2[j];
				 j++;
			 }
			 lo++;
		 }
		 while(i<arr1.length) {
			 nums[lo] = arr1[i];
			 i++;
			 lo++;
		 }
		 while(j<arr2.length) {
			 nums[lo] = arr2[j];
			 j++;
			 lo++;
		 }
	}

	/**
	 * prints the input array
	 * @param nums
	 */
	private void printArray(int[] nums) {
		for(int n: nums) {
			System.out.print(n + "  ");
		}
		System.out.println();
	}

	/**
	 * driver method
	 * @param args
	 */
	public static void main(String[] args) {
		MergeSort m = new MergeSort();
		int[] nums = {11, 10, 9, 8, 7, 6, 5};
		m.mergeSort(nums, 0, nums.length-1);
		m.printArray(nums);
	}
}
