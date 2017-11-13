class StackArray {
	int top = -1;
	int[] stack = new int[10];
	boolean isFull() {
		if(stack.length-1 <= top)
			return true;
		else
			return false;
	}
	boolean isEmpty() {
		if(top < 0)
			return true;
		else
			return false;
	}
	public Integer peek() {
		if(!this.isEmpty()) {
			return stack[top];
		}
		else {
			System.out.println("Error: Stack is empty");
			return null;
		}
	}
	/*
	1. Check if the stack is full
		if yes: return Error and exit
		else: increment the top by 1
				and add the data element to the stack location
				where the top is pointing
			retutn success
	*/
	public void push (int element) {
		if(this.isFull()) {
			System.out.println("Error: Stack is full. Cannot enter: " + element);
			return;
		}
		else {
			top++;
			stack[top] = element;
		}
	}
	/*
	1. Check if the stack is empty
		if yes: return Error and exit
		else: access the data element where the top is pointing
				and decrement the top by 1
	*/
	public Integer pop() {
		if(this.isEmpty()) {
			System.out.println("Error: Stack is empty. Nothing to pop");
			return null;
		}
		else {
			int d = stack[top];
			top--;
			return d;
		}
	}
	public static void main(String[] args) {
		StackArray st = new StackArray();
		System.out.println("Stack's top has: " + st.peek());
		System.out.println("Poped item from stack: " + st.pop());
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		st.push(6);
		st.push(7);
		st.push(8);
		st.push(9);
		st.push(10);
		st.push(11);
		System.out.println("Stack's top has: " + st.peek());
		System.out.println("Poped item from stack: " + st.pop());
		System.out.println("Stack's top has: " + st.peek());
	}
}