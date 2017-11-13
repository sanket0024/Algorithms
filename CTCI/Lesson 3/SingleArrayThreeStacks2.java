class SingleArrayThreeStacks2 {
	int stackSize = 5;
	int indexUsed = -1;
	int[] top = {-1, -1, -1};
	Node[] arr = new Node[stackSize * 3];

	class Node {
		int previousIndex;
		int currentValue;
		public Node(int p, int v) {
			previousIndex = p;
			currentValue = v;
		}
	}
	public void push(int stackNumber, int value) {
		int i=0;
		while(i < arr.length && arr[i] != null)
			i++;
		if(i == arr.length)
			return;
		indexUsed = i;
		int previousIndex = top[stackNumber];
		top[stackNumber] = indexUsed;
		arr[top[stackNumber]] = new Node(previousIndex, value);
	}

	public Integer pop(int stackNumber) {
		if(top[stackNumber] < 0)
			return null;
		Node popedElement = arr[top[stackNumber]];
		arr[top[stackNumber]] = null;
		top[stackNumber] = popedElement.previousIndex;
		return popedElement.currentValue;
	}

	public Integer peek(int stackNumber) {
		if(top[stackNumber] < 0)
			return null;
		Node popedElement = arr[top[stackNumber]];
		return popedElement.currentValue;
	}

	private void printStack() {
		System.out.println();
		for(int i=0; i<arr.length; i++) {
			Integer n = arr[i]!=null ? arr[i].currentValue : null;
			System.out.print(n + "  ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		SingleArrayThreeStacks2 s = new SingleArrayThreeStacks2();
		s.push(0, 10);
		s.push(1, 20);
		s.push(2, 30);
		s.push(0, 40);
		s.push(1, 50);
		s.printStack();
		s.pop(0);
		s.pop(2);
		s.printStack();
		s.push(1, 60);
		s.push(1, 70);
		s.push(1, 80);
		s.push(1, 80);
		s.printStack();
		System.out.println(s.peek(0));
		System.out.println(s.peek(1));
		System.out.println(s.peek(2));
	}
}