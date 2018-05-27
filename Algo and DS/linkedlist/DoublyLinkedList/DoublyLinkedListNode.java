/**
 * The node of a doubly linked list
 * which will have a value and two pointers to the
 * previous and next DoublyLinkedList
 */
package DoublyLinkedList;

/**
 * @author sanketmathur
 *
 */
public class DoublyLinkedListNode {

	public DoublyLinkedListNode previous;
	public DoublyLinkedListNode next;
	public int val;
	
	/**
	 * default constructor
	 */
	public DoublyLinkedListNode() {
		this.val = Integer.MAX_VALUE;
		this.previous = null;
		this.next = null;
	}
	
	/**
	 * paramaterized constructor with the given value
	 * @param val
	 */
	public DoublyLinkedListNode(int val) {
		this.val = val;
		this.previous = null;
		this.next = null;
	}
}
