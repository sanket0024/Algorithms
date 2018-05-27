/**
 * The node of a singly linked list
 * which will have a value and a pointer to the
 * next SinglyLinkedListNode
 * 
 */
package CircularLinkedList;

/**
 * @author sanketmathur
 *
 */
public class CircularLinkedListNode {
	
	int val;
	CircularLinkedListNode next;
	
	/**
	 * default constructor
	 */
	public CircularLinkedListNode() {
		this.val = Integer.MAX_VALUE;
		this.next = null;
	}
	
	/**
	 * paramaterized constructor
	 * @param val
	 */
	public CircularLinkedListNode(int val) {
		this.val = val;
		this.next = null;
	}
}
