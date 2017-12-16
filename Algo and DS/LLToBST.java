/*
* Sorted LinkedList to BST
* 1. Make the middle element the root of the tree
* 2. Recursively do the step 1 for the left and the right of the element found in step 1
*/

class LLToBST {
	LinkedListNode lNode;
	public LLToBST(LinkedListNode lNode) {
		this.lNode = lNode;
	}

	/*public TreeNode makeBST(double beg, double end, boolean left, boolean right) {
		System.out.println("Left: " + left + "          Right: " + right);
		int size = (int)(end-beg);
		int mid = (int) Math.ceil((beg+end)/2);
		System.out.println("beg: " + beg + "       end: " + end + "       mid: " + mid);
		if(size < 0) {
			return null;
		}
		TreeNode tnRoot = new TreeNode(this.lNode.get(mid));
		TreeNode tnLeft = this.makeBST(0, mid-1, true, false);
		if(tnLeft != null)
			tnRoot.left = tnLeft;
		TreeNode tnRight = this.makeBST(mid+1, end, false, true);
		if(tnRight != null)
			tnRoot.right = tnRight;
		return tnRoot;
	}*/
	public TreeNode makeBST(int size) {
		if(size <= 0) {
			return null;
		}
		TreeNode tnLeft = this.makeBST(size/2);
		TreeNode tnRoot = new TreeNode(lNode.data);
		tnRoot.left = tnLeft;
		lNode = lNode.next;
		tnRoot.right = this.makeBST(size - size/2 - 1);
		return tnRoot;
	}
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.addNodeAtEnd(1);
		ll.addNodeAtEnd(2);
		ll.addNodeAtEnd(3);
		ll.addNodeAtEnd(4);
		ll.addNodeAtEnd(5);
		ll.addNodeAtEnd(6);
		LLToBST lltoBST = new LLToBST(ll.head);
		TreeNode tn = lltoBST.makeBST(ll.size());
		System.out.println("************INORDER*************");
		BST.inOrderPrint(tn);
		System.out.println("\n**********LEVEL ORDER**********");
		BST.levelOrderPrint(tn);
		System.out.println();
	}
}