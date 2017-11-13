class StackMinimum {
	int stackSize = 10;
	Node[] arr = new Node[stackSize];
	int top = -1;
	int minimum;
	class Node {
		int minValue;
		int value;
		public Node(int m, int v) {
			minValue = m;
			value = v;
		}
	}
	public void push (int value) {
		if(top == arr.length)
			return;
		if(top < 0)
			minimum = value;
		top++;
		arr[top] = new Node(Math.min(minimum, value), value);
	}

	public Integer pop() {
		if(top < 0)
			return null;
		int popedValue = arr[top].value;
		arr[top] = null;
		top--;
		return popedValue;
	}

	public Integer min() {
		if(top < 0)
			return null;
		return arr[top].minValue;
	}

	public Integer peek() {
		if(top < 0)
			return null;
		return arr[top].value;
	}

	private void printStack() {
		System.out.println();
		for(int i=0; i<arr.length; i++) {
			Integer n = arr[i]!=null ? arr[i].value : null;
			System.out.print(n + "  ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		StackMinimum s = new StackMinimum();
		s.push(10);
		s.push(20);
		s.push(40);
		s.push(30);
		s.push(50);
		s.printStack();
		s.pop();
		s.pop();
		s.push(1);
		//s.pop();
		s.printStack();
		System.out.println("Minimum Value: " + s.min());
	}
}