import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class MinimumVial {
	int minimumVials(List<Integer> input, int m, List<Integer> capacity) {
		int vileCount = 0;
		while(m > 0) {

			/**
			* check if it is available, otherwise remove it
			*/
			for(int i=0; i<capacity.size(); i++) {
				if(capacity.get(i) == 0) {
					capacity.remove(i);
					input.remove(i);
				}
			}

			int i = findJustSmaller(input, m);
			
			/**
			* Check if the amount to be dispended is possible or not
			*/
			if(i < 0) {
				System.out.println("Not possible to dispense the amount");
				System.exit(0);
			}

			// update the availability
			int temp = capacity.remove(i);
			capacity.add(i, temp - 1);

			//print capacity - uncomment to print capacity
			//System.out.println(Arrays.toString(capacity.toArray()));

			m = m - input.get(i);
			vileCount++;
			System.out.println(input.get(i));
		}
		return vileCount;
	}

	int findJustSmaller(List<Integer> input, int m) {
		int lo = 0;
		int hi = input.size() - 1;
		while(lo<=hi) {
			int mid = (lo+hi)/2;
			if(input.get(mid) == m) {
				return mid;
			}
			else if(input.get(mid) < m) {
				lo = mid + 1;
			}
			else {
				hi = mid - 1;
			}
		}
		//System.out.println("hi : " + hi);
		return hi;
	}

	public static void main(String[] args) {
		MinimumVial vials = new MinimumVial();
		List<Integer> input = new ArrayList<>();
		input.add(1);
		input.add(5);
		input.add(10);
		input.add(20);
		input.add(50);

		List<Integer> capacity = new ArrayList<>();
		capacity.add(100);
		capacity.add(0);
		capacity.add(0);
		capacity.add(3);
		capacity.add(1);

		System.out.println(vials.minimumVials(input, 60, capacity));
	}
}