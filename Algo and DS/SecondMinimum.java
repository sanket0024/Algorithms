/*
* 1. Set min to max integer value
* 2. Follow the inOrder traversal to traverse the whole tree
* 3. If root data is minimum than the min value, then set the second min as
*    the minimum and min as the root.data.
*/
class SecondMinimum {
	int min = Integer.MAX_VALUE;
	int min2 = Integer.MAX_VALUE;
	public void secMin(TreeNode root) {
		if(root != null) {
			if(root.data <= min) {
				min2 = min;
				min = root.data;
			}
			secMin(root.left);
			secMin(root.right);
		}
		return min2;
	}
}