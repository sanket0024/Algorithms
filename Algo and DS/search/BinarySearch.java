/**
 * Binary Search
 * 
 * Properties:
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 * 
 * Limitation: the input array should be sorted
 * Paradigm: Divide and Conquer
 */

/**
 * @author sanketmathur
 *
 */
public class BinarySearch {
	
	/**
	 * Idea is to reduce the size of the array by half with every iteration
	 * by updating the lo or hi value.
	 * @param nums
	 * @param target
	 * @return: the index of the target value, else -1
	 */
	public int binarySearch(int[] nums, int target) {
		int lo = 0;
		int hi = nums.length-1;
		while(lo <= hi) {
			int mid = lo + ((hi-lo)>>1);
			if(nums[mid] == target) {
				return mid;
			}
			if(nums[mid] < target) {
				lo = mid+1;
			}
			else {
				hi = mid-1;
			}
		}
		return -1;
	}
	
	/**
	 * driver method
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		int[] nums = {1, 3, 5, 8, 10, 14, 19, 20};
		System.out.println(bs.binarySearch(nums, 19));
		System.out.println(bs.binarySearch(nums, 18));
	}

}
