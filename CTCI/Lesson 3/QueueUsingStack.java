import java.util.Stack;
class QueueUsingStack {
	Stack<Integer> pushSt = new Stack<Integer>();
	Stack<Integer> popSt = new Stack<Integer>();

	public void add(int value) {
		if(popSt.isEmpty()) {
			pushSt.push(value);
			return;
		}
		while(!popSt.isEmpty()) {
			pushSt.push(popSt.pop());
		}
		pushSt.push(value);
	}

	public Integer remove() {
		if(pushSt.isEmpty() && !popSt.isEmpty())
			return popSt.pop();
		else if(pushSt.isEmpty() && popSt.isEmpty())
			return null;
		else {
			while (!pushSt.isEmpty()) {
				popSt.push(pushSt.pop());
			}
		}
		return popSt.pop();
	}

	// This is empty the whole stack. So execute it in the last
	public void printQueue() {
		if(pushSt.isEmpty() && popSt.isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		else if(pushSt.isEmpty() && !popSt.isEmpty()) {
			while(!popSt.isEmpty()) {
				System.out.println(popSt.pop() + "  ");
			}
		}
		else {
			while(!pushSt.isEmpty()) {
				popSt.push(pushSt.pop());
			}
			while(!popSt.isEmpty()) {
				System.out.println(popSt.pop() + "  ");
			}
		}
	}

	public static void main(String[] args) {
		QueueUsingStack st = new QueueUsingStack();
		st.add(1);
		st.add(2);
		st.add(3);
		st.add(4);
		st.add(5);
		st.add(6);
		st.remove();
		st.remove();
		st.printQueue();
	}
}