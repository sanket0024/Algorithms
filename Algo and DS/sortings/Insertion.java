/**
 * Insertion sort
 * This will sort the input integer array in the non decreasing order
 * 
 * Properties:
 * Time Complexity: O(n*n)
 * Space Complexity: O(1)
 * In place sorting
 * Stable: means numbers with the same value appear in the output array
 * in the same order as they do in the input array.
 * 
 * Beneficial when sorting an almost sorted array
 * as it will reduce the number of times the
 * inner loop will be executed
 */

/**
 * @author sanketmathur
 *
 */
public class Insertion {
	
	/**
	 * Idea is to check whether all the elements to the left of the
	 * current element (in this case key) is smaller than the itself.
	 * So, keep on shifting the elements to the left of the key until
	 * we find an element less than the key.
	 * 
	 * @param nums - input array
	 * @return sorted array
	 * 
	 */
	public int[] insertionSort(int[] nums) {
		for(int i=1; i<nums.length; i++) {
			int key = nums[i];
			int j=i-1;
			while(j>=0 && key < nums[j]) {
				nums[j+1] = nums[j];
				j--;
			}
			nums[j+1] = key;
		}
		return nums;
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
		Insertion i = new Insertion();
		int[] nums = {11, 10, 19, 8, 17, 26};
		nums = i.insertionSort(nums);
		i.printArray(nums);
	}

}
