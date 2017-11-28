import java.util.Queue;
import java.util.LinkedList;
class BFSTreeLevelOrderTraversal {
	Node root;
	Node left;
	Node right;

	public void bfs() {
		//1. Create empty queue
		Queue<Node> que = new LinkedList<Node>();
		// 2. Take the first element (root) and add it to queue
		que.add(this.root);
		// 3. Repeat while the queue is not empty
		while(que.peek() != null) {
			// 3.1 Remove the first element from the queue
			// 3.2 Print the data of the removed element
			// 3.3 Add the not null left and right child of the element to the queue 
			// Repeat
			Node temp = que.poll();
			temp.printNodeElement();
			if(temp.left != null)
				que.add(temp.left);
			if(temp.right != null)
				que.add(temp.right);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		BFSTreeLevelOrderTraversal t = new BFSTreeLevelOrderTraversal();
		t.root = new Node(1);
		t.root.left = new Node(2);
		t.root.right = new Node(3);
		t.root.left.left = new Node(4);
		t.root.left.right = new Node(5);
		t.root.right.left = new Node(6);
		t.root.right.right = new Node(7);
		t.root.right.right.right = new Node(8);
		t.bfs();
	}
}