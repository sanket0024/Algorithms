import java.util.Queue;
import java.util.LinkedList;
class BFSTree {
	Node root;
	public void bFSPrintTree() {
		Queue<Node> que = new LinkedList<Node>();
		que.add(root);
		while(!que.isEmpty()) {
			Node temp = que.poll();
			System.out.println(temp.data);
			if(temp.left != null)
				que.add(temp.left);
			if(temp.right != null)
				que.add(temp.right);
		}
	}
	public static void main(String[] args) {
		BFSTree t = new BFSTree();
		t.root = new Node(1);
		t.root.left = new Node(2);
		t.root.right = new Node(3);
		t.root.left.left = new Node(4);
		t.root.left.right = new Node(5);
		t.root.right.left = new Node(6);
		t.root.right.right = new Node(7);
		t.bFSPrintTree();
	}
}