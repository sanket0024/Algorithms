import java.util.*;
class MinOperations {
	public int minOperationsCount(int x, int target) {
		LinkedList<OperationNode> que = new LinkedList<OperationNode>();
		OperationNode temp = new OperationNode(x, 0, false);
		que.add(temp);
		while(!que.isEmpty() && x!=0) {
			temp = que.poll();
			if(temp.val == target) {
				return temp.level;
			}
			temp.visited = true;
			if(temp.val * 2 == target || temp.val - 1 == target) {
				return temp.level+1;
			}
			OperationNode t = new OperationNode(temp.val*2, temp.level+1, false);
			que.add(t);
			t = new OperationNode(temp.val-1, temp.level+1, false);
			que.add(t);
		}
		return 0;
	}
	public static void main(String[] args) {
		MinOperations m = new MinOperations();
		System.out.println(m.minOperationsCount(7, 10));
	}
}

class OperationNode {
	int val;
	int level;
	boolean visited;
	OperationNode(int val, int level, boolean visited) {
		this.val = val;
		this.level = level;
		this.visited = visited;
	}
}