/**
 * All the nodes are connected to each other in the form of circle
 * 1. Any node can be starting point
 * 2. Singly or doubly linked list can be converted to circular linked list
 * 
 * Properties:
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * 
 */
package CircularLinkedList;

/**
 * @author sanketmathur
 *
 */

public class CircularLinkedList {
	
	/**
	 * Idea is to use another pointer last will point to the last node
	 * 1. check if the last is null
	 * 
	 * @param last: last node pointer
	 * @param a
	 * @return - the last node of the linked list
	 */
	public CircularLinkedListNode insertLast(CircularLinkedListNode last, int a) {
		CircularLinkedListNode newNode = new CircularLinkedListNode(a);
		if(last == null) {
			newNode.next = newNode;
			return newNode;
		}
		newNode.next = last.next;
		last.next = newNode;
		return newNode;
	}
	
	/**
	 * Idea is to use another pointer last will point to the last node
	 * 1. check if the last is null
	 * 
	 * @param last: last node pointer
	 * @param a
	 * @return - the last node of the linked list
	 */
	public CircularLinkedListNode insertFirst(CircularLinkedListNode last, int a) {
		CircularLinkedListNode newNode = new CircularLinkedListNode(a);
		if(last == null) {
			newNode.next = newNode;
			return newNode;
		}
		newNode.next = last.next;
		last.next = newNode;
		return last;
	}
	
	/**
	 * Idea is to use another pointer last will point to the last node
	 * 1. check if the last is null
	 * 
	 * @param last: last node pointer
	 * @param a: new node value
	 * @param key: insert after this elememt
	 * @return - the last node of the linked list
	 */
	public CircularLinkedListNode insertMid(CircularLinkedListNode last, int key, int a) {
		CircularLinkedListNode newNode = new CircularLinkedListNode(a);
		if(last == null) {
			newNode.next = newNode;
			return newNode;
		}
		CircularLinkedListNode cn = last;
		while(last.next != cn && last.val != key) {
			last = last.next;
		}
		if(last.val == key) {
			newNode.next = last.next;
			last.next = newNode;
		}
		if(last == cn) {
			return newNode;
		}
		return cn;
	}
	
	
	/**
	 * Idea is to traverse till the key 
	 * @param last
	 * @param key
	 * @return
	 */
	public CircularLinkedListNode deleteNode(CircularLinkedListNode last, int key) {
		if(last == null || (last.next == last && last.val == key)) {
			return null;
		}
		CircularLinkedListNode cn = last;
		CircularLinkedListNode prev = last;
		last = last.next;
		while(last != cn && last.val != key) {
			last = last.next;
			prev = prev.next;
		}
		if(last.val == key) {
			System.out.println(last.val);
			prev.next = last.next;
			if(last == cn) {
				return prev;
			}
		}
		return cn;
	}
	
	/**
	 * prints the linkedlist from the provided head node till the end
	 * @param head
	 */
	private void printLinkedList(CircularLinkedListNode last) {
		CircularLinkedListNode temp = last;
		if(last == null) {
			return;
		}
		temp = temp.next;
		while(temp != last) {
			System.out.print(temp.val + "  ");
			temp = temp.next;
		}
		System.out.print(temp.val + "  ");
		System.out.println();
	}
	
	/**
	 * driver method
	 * @param args
	 */
	public static void main(String[] args) {
		CircularLinkedList cll = new CircularLinkedList();
		CircularLinkedListNode last = cll.insertFirst(null, 3);
		last = cll.insertFirst(last, 2);
		last = cll.insertFirst(last, 1);
		System.out.println("insertFirst");
		cll.printLinkedList(last);
		System.out.println();
		
		last = cll.insertLast(last, 6);
		System.out.println("insertLast");
		cll.printLinkedList(last);
		System.out.println();
		
		last = cll.insertMid(last, 3, 4);
		last = cll.insertMid(last, 4, 5);
		System.out.println("insertMid");
		cll.printLinkedList(last);
		System.out.println();
		
		last = cll.deleteNode(last, 6);
		System.out.println("deleteNode");
		cll.printLinkedList(last);
		System.out.println();
	}

}