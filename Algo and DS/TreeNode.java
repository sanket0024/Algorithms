class TreeNode {
	int data;
	TreeNode left, right;
	public TreeNode(int item) {
		data = item;
		left = null;
		right = null;
	}
	public void printNodeElement() {
		System.out.print(this.data + " ");
	}

	public static int minValue(TreeNode n) {
		int min = n.data;
		while(n.left != null) {
			n = n.left;
			min = n.data;
		}
		return min;
	}
}