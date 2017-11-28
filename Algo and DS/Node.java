class Node {
	int data;
	Node left, right;
	public Node(int item) {
		data = item;
		left = null;
		right = null;
	}
	public void printNodeElement() {
		System.out.print(this.data + " ");
	}
}