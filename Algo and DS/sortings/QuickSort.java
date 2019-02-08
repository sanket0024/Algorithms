import java.util.Random;

/**
 * Quick sort
 * This will sort the input integer array in the non decreasing order
 * 
 * Properties:
 * Time Complexity: O(n*logn)
 * Space Complexity: O(1)
 * Approach - divide and conquer
 * In place sorting
 * Preferred over merge sort because no extra space is required.
 */

/**
 * @author sanketmathur
 *
 */
public class QuickSort {
	
	/**
	 * The idea is to divide the array at an index position.
	 * At every recursive call the element at the index
	 * from the array will be moved to its actual position as
	 * it should be in the sorted array.
	 * Apply quick sort to the sub array present in the left of the
	 * element and to the  sub array present in the right of the element
	 * @param nums - input array
	 * @param lo - start index of sub array
	 * @param hi - end index of the sub array
	 */
	public void quickSort(int[] nums, int lo, int hi) {
		if(lo < hi) {
			int part = partition(nums, lo, hi);
			quickSort(nums, lo, part-1);
			quickSort(nums, part+1, hi);
		}
	}
	
	/**
	 * Selects a random element from the sub array between hi and lo inclusive
	 * and place it in the correct position in the actual array as it should be
	 * when the array is sorted.
	 * @param nums
	 * @param lo
	 * @param hi
	 * @return - that index position of the element placed
	 */
	private int partition(int[] nums, int lo, int hi) {
		Random random = new Random();
		int r = lo + random.nextInt(hi-lo);
		swap(nums, r, hi);
		
		int pivot = nums[hi];
		int k=lo-1;
		for(int i=lo; i<hi; i++) {
			if(nums[i] <= pivot) {
				k++;
				swap(nums, k, i);
			}
		}
		swap(nums, ++k, hi);
		return k;
	}
	
	/**
	 * Swap two elements of the given array at the specified index position
	 * @param nums - array
	 * @param i
	 * @param j
	 */
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
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
		QuickSort q = new QuickSort();
		int[] nums = {11, 10, 9, 8, 7, 6, 5, 2, 4, 3, 7,6,9,0};
		q.quickSort(nums, 0, nums.length-1);
		q.printArray(nums);
	}
}
