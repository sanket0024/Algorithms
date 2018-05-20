/**
 * Selection sort
 * This will sort the input integer array in the non decreasing order
 * 
 * Properties:
 * Time Complexity: O(n*n)
 * Space Complexity: O(1)
 * In place sorting
 * 
 */

/**
 * @author sanketmathur
 *
 */
public class Selection {
	
	/**
	 * The idea is to put the smallest element at the
	 * start of the current loop index.
	 * 
	 * @param nums
	 * @return nums - a sorted array
	 */
	public int[] selectionSort(int[] nums) {
		for(int i=0; i<nums.length-1; i++) {
			int index = i;
			for(int j=i+1; j<nums.length; j++) {
				if(nums[index] > nums[j]) {
					index = j;
				}
			}
			int temp = nums[index];
			nums[index] = nums[i];
			nums[i] = temp;
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
		Selection s = new Selection();
		int[] nums = {11, 10, 19, 8, 17, 26};
		nums = s.selectionSort(nums);
		s.printArray(nums);
	}
}
