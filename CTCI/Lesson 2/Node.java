class Node {
	int data;
	Node(int data) {
		this.data = data;
	}
	void createNode(int d) {
		Node addNewNode = new Node(1);
		Node n = this;
		while(n.next() != null) {
			//n.next();
			System.out.println(n.next());
		}
		n.next = addNewNode;
	}
	public static void main(String[] args) {
		Node n = new Node(1);
		n.createNode(2);
	}
}