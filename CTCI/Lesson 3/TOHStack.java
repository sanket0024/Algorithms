import java.util.Stack;
class TOHStack {
	Stack<Integer>[] tower = new Stack[3];
	public void stepsForTOH(int size) {
		for(int i = 0; i<tower.length; i++) {
			tower[i] = new Stack<Integer>();
		}
		for(int i = size; i>=1; i--) {
			tower[0].push(i);
		}
		towerOperations(size, 0, 1, 2);
	}

	public void towerOperations(int n, int a, int b, int c) {
		if(n == 0)
			return;
		if(n == 1) {
			System.out.println(a + " --> " + c);
			return;
		}
		towerOperations(n-1, a, c, b);
		tower[c].push(tower[a].pop());
		System.out.println(a + " --> " + c);
		towerOperations(n-1, b, a, c);
	}

	public static void main(String[] args) {
		TOHStack t = new TOHStack();
		t.stepsForTOH(3);
	}
}