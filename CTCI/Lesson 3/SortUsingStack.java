import java.util.Stack;
class SortUsingStack {
	Stack<Integer> resultSt = new Stack<Integer>();
	public void sort(Stack<Integer> st) {
		while(!st.isEmpty()) {
			int tmp = st.pop();
			while(!resultSt.isEmpty() && resultSt.peek() > tmp) {
				st.push(resultSt.pop());
			}
			resultSt.push(tmp);
		}
	}

	public void printSortedStack() {
		while(!resultSt.isEmpty()) {
			System.out.println(resultSt.pop());
		}
	}

	public static void main(String[] args) {
		SortUsingStack sus = new SortUsingStack();
		Stack<Integer> s = new Stack<Integer>();
		s.push(10);
		s.push(80);
		s.push(30);
		s.push(20);
		s.push(50);
		s.push(60);
		s.push(40);
		s.push(70);
		sus.sort(s);
		sus.printSortedStack();
	}
}