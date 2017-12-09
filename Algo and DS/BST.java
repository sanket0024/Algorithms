import java.util.Scanner;
class BST {

	Node root;
	//constructor
	private BST(Node root) {
		this.root = root;
	}
	/*
	* 1. BST: all the small elements will be present in the
	*    left subtree and all the larger elements will be present
	*    in the right sub tree of the root node
	*/
	public Node search(int element) {
		// if root is null or it is the element then return root
		if(root == null || root.data == element)
			return root;
		// if elememt is smaller than root then look for the element in the left subtree
		if(element < root.data)
			return new BST(root.left).search(element);
		// if elememt is greater than root then look for the element in the right subtree
		else
			return new BST(root.right).search(element);
	}

	public Node insert(int element) {
		//if no element, then return the new node with the given element
		if(root == null) {
			return new Node(element);
		}
		//if element already exists then return the same tree
		if(this.search(element) != null) {
			return root;
		}
		// if the new element is smaller than the root node, the insert into the left subtree
		else if(root.data > element) {
			root.left = new BST(root.left).insert(element);
		}
		// if the new element is greater than the root node then insert into the right subtree
		else
			root.right = new BST(root.right).insert(element);
		return root;
	}

	//Inorder: Left Root Right
	public static void inOrderPrint(Node root) {
		if(root != null) {
			BST.inOrderPrint(root.left);
			System.out.print(root.data + "  ");
			BST.inOrderPrint(root.right);
		}
	}

	// PreOrder: Root Left Right
	public static void preOrderPrint(Node root) {
		if(root != null) {
			System.out.print(root.data + "  ");
			BST.preOrderPrint(root.left);
			BST.preOrderPrint(root.right);
		}
	}

	//PostOrder: Left Right Root
	public static void postOrderPrint(Node root) {
		if(root != null) {
			BST.postOrderPrint(root.left);
			BST.postOrderPrint(root.right);
			System.out.print(root.data + "  ");
		}
	}

	public static void main(String[] args) {
		Node binTree = new Node(10);
		binTree.left = new Node(5);
		binTree.left.left = new Node(3);
		binTree.left.right = new Node(6);
		binTree.left.left.left = new Node(1);
		binTree.left.left.right = new Node(4);
		binTree.right = new Node(15);
		binTree.right.left = new Node(13);
		binTree.right.right = new Node(17);
		binTree.right.left.left = new Node(12);
		binTree.right.left.right = new Node(14);

		Scanner scan = new Scanner(System.in);
		System.out.print("Search or Insert?? ");
		String str = scan.nextLine();
		if(str.equalsIgnoreCase("Search")) {
			System.out.print("Enter the number to search in the binary tree: ");
			int element = scan.nextInt();
			BST binSearchTree = new BST(binTree);
			Node res = binSearchTree.search(element);
			if(res != null)
				System.out.println("Found: " + res.data);
			else
				System.out.println("Not found");
		}
		else {
			System.out.print("Enter the number to insert in the binary tree: ");
			int element = scan.nextInt();
			BST binSearchTree = new BST(binTree);
			Node res = binSearchTree.insert(element);
			System.out.println("Pre Order");
			binSearchTree.preOrderPrint(res);
			System.out.println("\nIn Order");
			binSearchTree.inOrderPrint(res);
			System.out.println("\nPost Order");
			binSearchTree.postOrderPrint(res);
			System.out.println();
		}
	}
}