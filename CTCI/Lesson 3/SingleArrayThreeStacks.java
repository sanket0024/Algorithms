// Sinle array to implement 3 stacks
// Approach 1: Limited array space. Divide array into 3 and then process

class SingleArrayThreeStacks {
	int[] arr = new int[10];
	int[] top = {-1, arr.length/3 - 1, 2 * arr.length/3 - 1};
	int[] maxSize = {(arr.length/3) - 1, (2 * arr.length/3) -1, arr.length - 1};
	public void push (int stackNumber, int value) {
		if(top[stackNumber-1] == maxSize[stackNumber-1])
			return;
		else {
			top[stackNumber-1]++;
			arr[top[stackNumber-1]] = value;
		}
	}

	public Integer pop(int stackNumber) {
		if(top[stackNumber-1] < 0)
			return null;
		else {
			return arr[top[stackNumber-1]--];
		}
	}

	public Integer peek(int stackNumber) {
		if(top[stackNumber-1] < 0)
			return null;
		else
			return arr[top[stackNumber-1]];
	}

	public static void main(String[] args) {
		SingleArrayThreeStacks s = new SingleArrayThreeStacks();
		s.push(1, 10);
		s.push(1, 20);
		s.push(2, 40);
		s.push(2, 50);
		s.push(2, 60);
		s.push(2, 70);
		s.push(3, 90);
		s.push(3, 100);
		s.pop(1);
		s.pop(2);
		s.pop(3);
		System.out.println("Top pointing at: " + s.peek(1));
		System.out.println("Top pointing at: " + s.peek(2));
		System.out.println("Top pointing at: " + s.peek(3));
		for(int i : s.arr) {
			System.out.println(i);
		}
	}
}