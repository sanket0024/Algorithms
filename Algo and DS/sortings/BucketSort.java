import java.util.Collections;
import java.util.LinkedList;

/**
 * Bucket sort
 * This will sort the input integer array in the non decreasing order
 * 
 * This sorting algorithm will be based on the assumption that the input
 * will be distributed uniformly among [0, 1).
 * Bucket sort will divide [0,1) into n equal size buckets. Since the
 * input is uniformly distributed, so the elements will not fall into the
 * same bucket. Well if they do, then the complexity will be O(n*n)
 * 
 * The algorithm used to sort every bucket is the insertion sort.
 * Since insertion sort will take only O(n) to sort almost sorted array
 * 
 * Properties:
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Stable: means numbers with the same value appear in the output array
 * in the same order as they do in the input array.
 * 
 */

/**
 * @author sanketmathur
 *
 */
public class BucketSort {
	
	public void bucketSort(float[] nums) {
		int n = nums.length;
		LinkedList<Float>[] result = new LinkedList[n];
		for(int i=0; i<n; i++) {
			result[i] = new LinkedList<Float>();
		}
		for(int i=0; i<n; i++) {
			result[(int) (n*nums[i])].add(nums[i]);
		}
		for(int i=0; i<n; i++) {
			if(!result[i].isEmpty()) {
				Collections.sort(result[i]);
			}
		}
		int index = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<result[i].size(); j++) {
				nums[index++] = result[i].get(j);
			}
		}
	}
	
	/**
	 * prints the input array
	 * @param nums
	 */
	private void printArray(float[] nums) {
		for(float n: nums) {
			System.out.print(n + "  ");
		}
		System.out.println();
	}

	/**
	 * driver method
	 * @param args
	 */
	public static void main(String[] args) {
		BucketSort b = new BucketSort();
		float[] nums = {0.32f,0.32f,0.21f,0.33f};
		b.bucketSort(nums);
		b.printArray(nums);
	}
}
