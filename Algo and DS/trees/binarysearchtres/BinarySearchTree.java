/**
 * Tree properties:
 * 1. each node will have at most 2 children
 * 2. all the elements in the left subtree will be smaller than roots
 * 3. all the elements in the left subtree will be greater than roots
 * 
 * Assumption: there are no duplicates
 * 
 * Complexity:
 * Time complexity: O(n)
 * Space complexity: O(n)
 * 
 */
package binarysearchtres;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sanketmathur
 *
 */
public class BinarySearchTree {

	/**
	 * 1. if root is null then return the new node with that value
	 * 2. otherwise recursive call the insert method by comparing the
	 * root value with the given value
	 * 
	 * @param a
	 * @param root
	 * @return
	 */
	public BSTNode insert(int a, BSTNode root) {
		if(root == null) {
			return new BSTNode(a); 
		}
		if(root.val > a) {
			root.left = insert(a, root.left);
		}
		else {
			root.right = insert(a, root.right);
		}
		return root;
	}
	
	/**
	 * 1. check if the root is null then return null
	 * 2. find for the key in the BST
	 * 3. if the key node has 1 child then return that subtree
	 * 4. if the key node has no child then return null
	 * 5. if the key node has 2 children then find the inorder successor of the key node,
	 * this inorder successor will take place of the node to be deleted and then delete the
	 * inorder successor node
	 * 
	 * @param key
	 * @param root
	 * @return
	 */
	public BSTNode delete(int key, BSTNode root) {
		if(root == null) {
			return null;
		}
		if(key < root.val) {
			root.left = delete(key, root.left);
		}
		else if(key > root.val) {
			root.right = delete(key, root.right);
		}
		else {
			if(root.left == null) {
				return root.right;
			}
			else if(root.right == null) {
				return root.left;
			}
			else {
				List<Integer> temp = new ArrayList<>();
				inOrder(root.right, temp);
				root.val = temp.get(0);
				root.right = delete(root.val, root.right);
			}
		}
		return root;
	}
	
	/**
	 * Root - Left - Right
	 * @param nums
	 * @param result
	 */
	public void preOrder(BSTNode root, List<Integer> result) {
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
	public void inOrder(BSTNode root, List<Integer> result) {
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
	public void postOrder(BSTNode root, List<Integer> result) {
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
	public void levelOrder(BSTNode root, List<Integer> result) {
		if(root == null) {
			return;
		}
		Queue<BSTNode> que = new LinkedList<>();
		que.add(root);
		while(!que.isEmpty()) {
			BSTNode temp = que.poll();
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
		BinarySearchTree bst = new BinarySearchTree();
		
		BSTNode root = bst.insert(5, null);
		root = bst.insert(3, root);
		root = bst.insert(7, root);
		root = bst.insert(2, root);
		root = bst.insert(4, root);
		root = bst.insert(6, root);
		root = bst.insert(9, root);
		root = bst.insert(8, root);
		System.out.println("Insert: Inorder");
		bst.inOrder(root, result);
		bst.printList(result);
		
		result = new ArrayList<>();
		System.out.println("Insert: Preorder");
		bst.preOrder(root, result);
		bst.printList(result);
		
		result = new ArrayList<>();
		System.out.println("Insert: Postorder");
		bst.postOrder(root, result);
		bst.printList(result);
		
		result = new ArrayList<>();
		System.out.println("Insert: LevelOrder");
		bst.levelOrder(root, result);
		bst.printList(result);
		
		result = new ArrayList<>();
		root = bst.delete(7, root);
		System.out.println("Delete: Inorder");
		bst.inOrder(root, result);
		bst.printList(result);
		
		result = new ArrayList<>();
		System.out.println("Delete: Preorder");
		bst.preOrder(root, result);
		bst.printList(result);
		
		result = new ArrayList<>();
		System.out.println("Delete: Postorder");
		bst.postOrder(root, result);
		bst.printList(result);
		
		result = new ArrayList<>();
		System.out.println("Delete: LevelOrder");
		bst.levelOrder(root, result);
		bst.printList(result);
		
	}
}
