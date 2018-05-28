/**
 * Node of an AVL tree
 */
package avltrees;

/**
 * @author sanketmathur
 *
 */
public class AVLTreeNode {

	public int val;
	public int height;
	public AVLTreeNode right;
	public AVLTreeNode left;
	
	/**
	 * constructor
	 * @param val
	 */
	public AVLTreeNode(int val) {
		this.val = val;
		this.height = 1;
		this.right = null;
		this.left = null;
	}
}
