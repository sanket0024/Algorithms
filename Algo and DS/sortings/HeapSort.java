/**
 * Heap sort
 * This will sort the input integer array in the non decreasing order
 * 
 * Properties:
 * Time Complexity: O(n*logn)
 * Time Complexity of heapify method - log n
 * Space Complexity: O(1)
 * In place sorting
 * Although quick sort is better than heap sort in performance, 
 * but it is used in many important applications, like implementing priority queue.
 */

/**
 * @author sanketmathur
 *
 */
public class HeapSort {
	
	/**
	 * The idea is to max build a heap which has a property that
	 * both the children of the parent is smaller than the parent.
	 * Build this max heap first and then call the heapify method
	 * which is responsible to maintain max heap property every time
	 * there is a change in the array.
	 * After this max heap has been built, extract the top most element
	 * from the max heap which will be the largest element in the array
	 * and put it in the last of array and reduce the heap size by 1.
	 *   
	 * @param nums
	 */
	public void heapSort(int[] nums) {
		buildHeap(nums);
		for(int i=nums.length-1; i>=0; i--) {
			swap(nums, 0, i);
			heapify(nums, 0, i);
		}
	}
	
	/**
	 * Building heap
	 * @param nums
	 */
	private void buildHeap(int[] nums) {
		for(int i=(nums.length/2)-1; i>=0; i--) {
			heapify(nums, i, nums.length-1);
		}
	}
	
	/**
	 * This function maintains the max heap property
	 * @param nums
	 * @param i - index of the root
	 * @param heapSize
	 */
	private void heapify(int[] nums, int i, int heapSize) {
		int left = i*2 + 1;
		int right = i*2 + 2;
		int largest = i;
		if(left < heapSize && nums[left] > nums[i]) {
			largest = left;
		}
		if(right < heapSize && nums[right] > nums[largest]) {
			largest = right;
		}
		if(i != largest) {
			swap(nums, i, largest);
			heapify(nums, largest, heapSize);
		}
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
		HeapSort h = new HeapSort();
		int[] nums = {11, 10, 9, 8, 7, 6, 5};
		h.heapSort(nums);
		h.printArray(nums);
	}
}
