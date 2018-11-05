/**
 * In binary trees, the complexity of insertion or deletion
 * or search has an upper bound of O(n) when the tree is skewed.
 * To reduce this upper bound to the height of the tree O(log n), 
 * we can induce the balancing mechanism, which will maintain the
 * height of the tree to the log n.
 * 
 * It includes the balancing factor:
 * BF(Node) = Absolute value of (height of left subtree - height of right subtree)
 * this BF(Node) cannot be greater than 1.
 * Whenever this factor raises above 1, rotation mechanism applied.
 * 
 * There are 4 rotations:
 * Let's assume that BF of node z is greater than 2 after some insertion
 * 1. Left-left rotation: when the element entered is right of the right child of z
 * 2. Right-right rotation: when the element entered is left of the left child of z
 * 3. Left-right rotation: when the element entered is right of the left child of z
 * 4. Right-left rotation: when the element entered is left of the right child of z
 * 
 * Complexities:
 * Time: O(log n)
 * Space: O(n)
 * 
 */
package avltrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sanketmathur
 *
 */
public class AVLTree {
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public int height(AVLTreeNode node) {
		if(node == null) {
			return 0;
		}
		return node.height;
	}
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public int balanceFactor(AVLTreeNode node) {
		if(node == null) {
			return 0;
		}
		return (height(node.left) - height(node.right));
	}
	
	
	/**
	 * left rotation
	 * @param root
	 * @return
	 */
	public AVLTreeNode leftRotation(AVLTreeNode root) {
		AVLTreeNode x = root.right.left;
		AVLTreeNode y = root.right;
		root.right = x;
		y.left = root;
		root.height = Math.max(height(root.left), height(root.right)) + 1;
		y.height = Math.max(height(y.left), height(y.right)) + 1;
		return y;
	}
	
	/**
	 * right rotation
	 * @param root
	 * @return
	 */
	public AVLTreeNode rightRotation(AVLTreeNode root) {
		AVLTreeNode x = root.left.right;
		AVLTreeNode y = root.left;
		root.left = x;
		y.right = root;
		root.height = Math.max(height(root.left), height(root.right)) + 1;
		y.height = Math.max(height(y.left), height(y.right)) + 1;
		return y;
	}
	
	
	/**
	 * Perform BST insertion and update the height of the node.
	 * Calculate balance factor with every insertion and perform
	 * rotations if bf is not in [-1, 1]
	 * @param a
	 * @param root
	 * @return
	 */
	public AVLTreeNode insert(int a, AVLTreeNode root) {
		if(root == null) {
			return new AVLTreeNode(a);
		}
		if(root.val > a) {
			root.left = insert(a, root.left);
		}
		else if(root.val < a) {
			root.right = insert(a, root.right);
		}
		else {
			return root;
		}
		root.height = 1 + Math.max(height(root.left), height(root.right));
		int bf = balanceFactor(root);
		if(bf > 1 && a < root.left.val) {
			return rightRotation(root);
		}
		if(bf < -1 && a > root.right.val) {
			return leftRotation(root);
		}
		if(bf > 1 && a > root.left.val) {
			root.left = leftRotation(root.left);
			return rightRotation(root);
		}
		if(bf < -1 && a < root.right.val) {
			root.right = rightRotation(root.right);
			return leftRotation(root);
		}
		return root;
	}
	
	public AVLTreeNode delete(AVLTreeNode root, int key) {
		if(root == null) {
			return null;
		}
		if(root.val < key) {
			root.right = delete(root.right, key);
		}
		else if(root.val > key) {
			root.left = delete(root.left, key);
		}
		else {
			if(root.left == null) {
				return root.right;
			}
			if(root.right == null) {
				return root.left;
			}
			List<Integer> temp = new ArrayList<>();
			inOrder(root.right, temp);
			root.val = temp.get(0);
			root.right = delete(root.right, root.val);
		}
		root.height = Math.max(height(root.left), height(root.right)) + 1;
		int bf = balanceFactor(root);
		if(bf > 1 &&  balanceFactor(root.left) >= 0) {
			return rightRotation(root);
		}
		if(bf < -1 && balanceFactor(root.right) <= 0) {
			return leftRotation(root);
		}
		if(bf > 1 && balanceFactor(root.left) < 0) {
			root.left = leftRotation(root.left);
			return rightRotation(root);
		}
		if(bf < -1 && balanceFactor(root.right) > 0) {
			root.right = rightRotation(root.right);
			return leftRotation(root);
		}
		return root;
	}

	/**
	 * Root - Left - Right
	 * @param nums
	 * @param result
	 */
	public void preOrder(AVLTreeNode root, List<Integer> result) {
		if(root == null) {
			return;
		}
		result.add(root.val);
		preOrder(root.left, result);
		preOrder(root.right, result);
	}
	
	/**
	 * Left - Root - Right
	 * @param root
	 * @param result
	 */
	public void inOrder(AVLTreeNode root, List<Integer> result) {
		if(root == null) {
			return;
		}
		inOrder(root.left, result);
		result.add(root.val);
		inOrder(root.right, result);
	}
	
	/**
	 * Left - Right- Root
	 * @param root
	 * @param result
	 */
	public void postOrder(AVLTreeNode root, List<Integer> result) {
		if(root == null) {
			return;
		}
		postOrder(root.left, result);
		postOrder(root.right, result);
		result.add(root.val);
	}
	
	/**
	 * Level order traversal using queue
	 * @param root
	 * @param result
	 */
	public void levelOrder(AVLTreeNode root, List<Integer> result) {
		if(root == null) {
			return;
		}
		Queue<AVLTreeNode> que = new LinkedList<>();
		que.add(root);
		while(!que.isEmpty()) {
			AVLTreeNode temp = que.poll();
			result.add(temp.val);
			if(temp.left != null) {
				que.add(temp.left);
			}
			if(temp.right != null) {
				que.add(temp.right);
			}
		}
	}
	
	/**
	 * Prints a given list
	 * @param ls
	 */
	public void printList(List<Integer> ls) {
		for(int a: ls) {
			System.out.print(a + "  ");
		}
		System.out.println();
	}
	
	/**
	 * driver method
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> result = new ArrayList<>();
		AVLTree bst = new AVLTree();
		
		AVLTreeNode root = bst.insert(10, null);
		root = bst.insert(5, root);
		root = bst.insert(20, root);
		root = bst.insert(6, root);
		root = bst.insert(1, root);
		root = bst.insert(8, root);
		System.out.println("Insert: Preorder");
		bst.preOrder(root, result);
		bst.printList(result);
				
		result = new ArrayList<>();
		System.out.println("Insert: LevelOrder");
		bst.levelOrder(root, result);
		bst.printList(result);
		
		root = bst.delete(root, 1);
		root = bst.delete(root, 20);
		root = bst.delete(root, 5);
		result = new ArrayList<>();
		System.out.println("Delete: Preorder");
		bst.preOrder(root, result);
		bst.printList(result);
		
		result = new ArrayList<>();
		System.out.println("Delete: LevelOrder");
		bst.levelOrder(root, result);
		bst.printList(result);
	}
}
