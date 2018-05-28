/**
 * Counting sort
 * This will sort the input integer array in the non decreasing order
 * Limitation: not suitable for floating point numbers
 * 
 * Counting sort is not a comparison based sort.
 * It determines for each input element x, the number of elements less than x.
 * It uses this information to place this element directly into the output array
 * 
 * Properties:
 * Time Complexity: theta(n+k)
 * Space Complexity: theta(n+k)
 * Stable: means numbers with the same value appear in the output array
 * in the same order as they do in the input array.
 * 
 * Usually counting sort is used when the size of auxiliary array is O(n)
 * 
 */

/**
 * @author sanketmathur
 *
 */

public class CountingSort {

	/**
	 * It is a linear time sorting algorithm.
	 * The first for loop will count frequency of every element 
	 * and store them corresponding to the index position in the
	 * auxiliary array
	 * The second for loop counts how many elements are smaller 
	 * than this index element and update the aux array
	 * The third for loop will get the value from the input array
	 * check its index position in the aux array and then store it into the
	 * output array 
	 * @param nums
	 * @return sorted result array
	 */
	public int[] countingSort(int[] nums, int k) {
		int[] result = new int[nums.length];
		int[] aux = new int[k+1];
		for(int i=0; i<nums.length; i++) {
			aux[nums[i]]++;
		}
		for(int i=1; i<aux.length; i++) {
			aux[i] += aux[i-1];
		}
		for(int i=0; i<nums.length; i++) {
			result[aux[nums[i]]-1] = nums[i];
			aux[nums[i]]--;
		}
		return result;
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
		CountingSort c = new CountingSort();
		int[] nums = {6,0,2,0,1,3,4,6,1,3,2};
		c.printArray(c.countingSort(nums, 6));
	}
}
