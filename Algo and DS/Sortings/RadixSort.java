/**
 * Radix sort
 * This will sort the input integer array in the non decreasing order
 * Limitation: not suitable for floating point numbers
 * 
 * Radix sort is not a comparison based sort. It used other "stable" sorting algorithm
 * to perform the sorting. Here we are using counting sort.
 * When counting sort fails to implement because of the elements are too large as compared
 * to the number of elements, then the complexity of counting sort will become O(n*n).
 * To handle such scenario, radix sort is used.
 * 
 * The idea behind the radix sort is to perform counting sort on the least significant bits
 * of all the elements and then the more significant bit and so on.
 * So, the number of times the loop run will be O(d(n+b)), where:
 * n = number of elements
 * b = base of the elements (here we are taking 10 decimal)
 * d = size of the length of maximum number in the array
 * 
 * Choosing appropriate base and maximum allowed element in the array we can achieve
 * the complexity of O(n)
 * 
 * Properties:
 * Time Complexity: O(n)
 * Space Complexity: O(n+b)
 * Stable: means numbers with the same value appear in the output array
 * in the same order as they do in the input array.
 */

/**
 * @author sanketmathur
 *
 */
public class RadixSort {

	/**
	 * calling the counting sort in a for loop
	 * @param nums
	 */
	public void radixSort(int[] nums) {
		int m = getMax(nums);
		for(int i=1; m/i>0; i*=10) {
			countingSort(nums, i);
		}
	}
	
	/**
	 * counting sort
	 * @param nums
	 * @param place - unit, tens....
	 */
	private void countingSort(int[] nums, int place) {
		int[] result = new int[nums.length];
		// as we are dealing with numbers of base 10
		int[] aux = new int[10];
		for(int i=0; i<nums.length; i++) {
			aux[(nums[i]/place)%10]++;
		}
		for(int i=1; i<aux.length; i++) {
			aux[i] += aux[i-1];
		}
		for(int i=result.length-1; i>=0; i--) {
			int v = (nums[i]/place)%10;
			result[aux[v]-1] = nums[i];
			aux[v]--;
		}
		for(int i=0; i<nums.length; i++) {
			nums[i] = result[i];
		}
	}
	
	/**
	 *
	 * @param nums
	 * @return the maximum value from the array
	 */
	private int getMax(int[] nums) {
		int max = Integer.MIN_VALUE;
		for(int i=0; i<nums.length; i++) {
			if(nums[i] > max) max = nums[i];
		}
		return max;
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
		RadixSort r = new RadixSort();
		int[] nums = {602,134,613};
		r.radixSort(nums);
		r.printArray(nums);
	}
}
