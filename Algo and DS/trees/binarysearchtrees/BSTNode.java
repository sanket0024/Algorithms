/**
 * The node of a binary search tree
 */
package binarysearchtrees;

/**
 * @author sanketmathur
 *
 */
public class BSTNode {

	public int val;
	public BSTNode right;
	public BSTNode left;
	
	/**
	 * constructor
	 * @param val
	 */
	public BSTNode(int val) {
		this.val = val;
		this.right = null;
		this.left = null;
	}
}
