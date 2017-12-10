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

	public Node remove(int element) {
		/*
		* 1. Check if the root is empty: return root
		* 2. If the element is less than the root: call remove on the left sub tree
		* 3. If the elemtnt is greater than the root: call remove on the right sub tree
		* 4. Else root is the element: if right sub tree is null, return left sub tree
		*    	else min of right sub tree will be the new root.
		*		new_root.left = root.left
		*		new_root.right = root.right
		*/

		if(root == null) {
			return root;
		}
		else if(element < root.data) {
			root.left = new BST(root.left).remove(element);
		}
		else if(element > root.data) {
			root.right = new BST(root.right).remove(element);
		}
		else {
			if(root.right == null) {
				return root.left;
			}
			else {
				root.data = Node.minValue(root.right);
				root.right = new BST(root.right).remove(root.data);
			}
		}
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
		System.out.println("***************\nINPUT TREE\n***************");
		System.out.println("\nPre Order");
		BST.preOrderPrint(binTree);
		System.out.println("\nIn Order");
		BST.inOrderPrint(binTree);
		System.out.println("\nPost Order");
		BST.postOrderPrint(binTree);
		System.out.println();

		Scanner scan = new Scanner(System.in);
		System.out.println("\nSelect one number:");
		System.out.println("1. Search \n2. Insert \n3. Remove\n");
		int operation = scan.nextInt();
		if(operation == 1) {
			System.out.println("*************SEARCH***************");
			System.out.print("Enter the number to search in the binary tree: ");
			int element = scan.nextInt();
			BST binSearchTree = new BST(binTree);
			Node res = binSearchTree.search(element);
			if(res != null)
				System.out.println("Found: " + res.data);
			else
				System.out.println("Not found");
			System.out.println("*************************************");
		}
		else if(operation == 2) {
			System.out.println("*************INSERT***************");
			System.out.print("Enter the number to insert in the binary tree: ");
			boolean more = true;
			while(more){
				int element = scan.nextInt();
				binTree = new BST(binTree).insert(element);
				System.out.print("Add more? ");
				String str = scan.nextLine();
				String str1 = scan.nextLine();
				if(str1.equalsIgnoreCase("N")) {
					more = false;
				}
			}
			System.out.println("\nPre Order");
			BST.preOrderPrint(binTree);
			System.out.println("\nIn Order");
			BST.inOrderPrint(binTree);
			System.out.println("\nPost Order");
			BST.postOrderPrint(binTree);
			System.out.println("\n****************************");
		}
		else {
			System.out.println("*************REMOVE***************");
			System.out.print("Enter the number to delete in the binary tree: ");
			int element = scan.nextInt();
			BST binSearchTree = new BST(binTree);
			Node res = binSearchTree.remove(element);
			System.out.println("\nPre Order");
			BST.preOrderPrint(res);
			System.out.println("\nIn Order");
			BST.inOrderPrint(res);
			System.out.println("\nPost Order");
			BST.postOrderPrint(res);
			System.out.println("\n****************************");
		}
	}
}