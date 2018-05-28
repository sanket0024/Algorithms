/**
 * Bubble sort
 * This will sort the input integer array in the non decreasing order
 * 
 * Properties:
 * Time complexity: O(n*n)
 * Space Complexity: O(1)
 * In place sorting
 * Stable: means numbers with the same value appear in the output array
 * in the same order as they do in the input array.
 * 
 * Generally used by other sorting algorithms to prove that they are better. :D
 * 
 */

/**
 * 
 * @author sanketmathur
 */

class Bubble {
	
	/**
	 * Idea is to put largest element in the last of the array in every outer loop iteration
	 * 1. for i: 0 to number of elements - 1
	 * 2. for j: 0 to number of elements -i-1 (since the last element is the greatest among all the elements
	 * so no need to check again for that element)
	 * 3. if number[j] > number[j+1] (means the next element is greater)
	 * 4. swap number[j] with number[j+1]
	 * 
	 * @param nums - input integer array
	 * @return a sorted array
	 */
	public int[] bubbleSort(int[] nums) {
		for(int i=0; i<nums.length-1; i++) {
			for(int j=0; j<nums.length-i-1; j++) {
				if(nums[j] > nums[j+1]) {
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
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
		Bubble b = new Bubble();
		int[] nums = {11, 10, 9, 8, 7, 6};
		nums = b.bubbleSort(nums);
		b.printArray(nums);
	}
}