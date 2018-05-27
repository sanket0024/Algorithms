/**
 * The node of a singly linked list
 * which will have a value and a pointer to the
 * next SinglyLinkedListNode
 * 
 */
package SinglyLinkedList;

/**
 * @author sanketmathur
 *
 */
public class SinglyLinkedListNode {
	
	int val;
	SinglyLinkedListNode next;
	
	/**
	 * default constructor
	 */
	public SinglyLinkedListNode() {
		this.val = Integer.MAX_VALUE;
		this.next = null;
	}
	
	/**
	 * paramaterized constructor
	 * @param val
	 */
	public SinglyLinkedListNode(int val) {
		this.val = val;
		this.next = null;
	}
}
