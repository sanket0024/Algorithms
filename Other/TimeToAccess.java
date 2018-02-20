import java.util.List;
import java.util.ArrayList;
class TimeToAccess {
	public static void main(String[] args) {
		//int[] arr = new int[100000000];
		List<Integer> arr = new ArrayList<Integer>();
		for(int i=0; i<10000000; i++) {
			arr.add(1);
		}
		long startTime = System.nanoTime();
		System.out.println(arr.get(9999999));
        long endTime   = System.nanoTime();
        System.out.println("Approx run time1: " + (endTime - startTime));

		startTime = System.nanoTime();
		System.out.println(arr.get(1));
		endTime   = System.nanoTime();
        System.out.println("Approx run time2: " + (endTime - startTime));

        System.out.println(Runtime.getRuntime());
	}
}