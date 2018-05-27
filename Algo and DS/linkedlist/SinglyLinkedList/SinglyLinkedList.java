/**
 * SinglyLinkedList - insertion and deletion
 * 1. from last
 * 2. specified position from the start
 * 3. specified position from the end
 * 
 * Advantages:
 * 1. Dynamic size
 * 2. Ease of insertion and deletion
 * 
 * Disadvantages:
 * 1. Random access is not allowed
 * 2. Extra memory space to store pointer 
 * 
 */
package SinglyLinkedList;

/**
 * @author sanketmathur
 *
 */
public class SinglyLinkedList {
	
	/**
	 * 
	 * Idea is to traverse till the end of the linkedlist
	 * and add the new linkedlist node there
	 * 
	 * 1. null check
	 * 2. otherwise normal
	 * 
	 * Properties:
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * where n is the number of elements in the linkedlist
	 * 
	 * @param head
	 * @param a - new value
	 * @return the head of the new or updated linked list after this insertion
	 */
	public SinglyLinkedListNode insertNodeLast(SinglyLinkedListNode head, int a) {
		if(head == null) {
			return new SinglyLinkedListNode(a);
		}
		SinglyLinkedListNode sn = new SinglyLinkedListNode(Integer.MAX_VALUE);
		sn.next = head;
		while(head.next != null) {
			head = head.next;
		}
		head.next = new SinglyLinkedListNode(a);
		return sn.next;
	}
	
	/**
	 * 
	 * Idea is to traverse till the position
	 * and add the new linkedlist node there
	 * 
	 * 1. null check
	 * 2. position is 1? check
	 * 2. otherwise normal
	 * 
	 * Properties:
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * where n is the number of elements in the linkedlist
	 * 
	 * @param head
	 * @param a - new value
	 * @param position - position starting from 1
	 * @return the head of the new or updated linked list after this insertion
	 */
	public SinglyLinkedListNode insertNodeMiddleFromStart(SinglyLinkedListNode head, int a, int position) {
		if(head == null) {
			return new SinglyLinkedListNode(a);
		}
		if(position == 1) {
			SinglyLinkedListNode newNode = new SinglyLinkedListNode(a);
			newNode.next = head;
			return newNode;
		}
		int count = 2;
		SinglyLinkedListNode sn = new SinglyLinkedListNode();
		sn.next = head;
		while(head.next != null && count < position) {
			head = head.next;
			count++;
		}
		SinglyLinkedListNode newNode = new SinglyLinkedListNode(a);
		newNode.next = head.next;
		head.next = newNode;
		return sn.next;
	}
	
	
	/**
	 * 
	 * Idea is to traverse till the position
	 * and add the new linkedlist node there
	 * 
	 * 1. null check
	 * 3. position is still > 1? check
	 * 2. otherwise normal
	 * 
	 * Properties:
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * where n is the number of elements in the linkedlist
	 * 
	 * @param head
	 * @param a - new value
	 * @param position - position starting from 1
	 * @return the head of the new or updated linked list after this insertion
	 */
	public SinglyLinkedListNode insertNodeMiddleFromLast(SinglyLinkedListNode head, int a, int position) {
		if(head == null) {
			return new SinglyLinkedListNode(a);
		}
		SinglyLinkedListNode sn = new SinglyLinkedListNode();
		sn.next = head;
		SinglyLinkedListNode fast = head;
		while(fast.next != null && position > 1) {
			fast = fast.next;
			position--;
		}
		if(position > 1) {
			SinglyLinkedListNode newNode = new SinglyLinkedListNode(a);
			newNode.next = head;
			sn.next = newNode;
			return sn.next;
			
		}
		while(fast.next != null) {
			fast = fast.next;
			head = head.next;
		}
		SinglyLinkedListNode newNode = new SinglyLinkedListNode(a);
		newNode.next = head.next;
		head.next = newNode;
		return sn.next;
	}
	
	
	/**
	 * 
	 * Idea is to traverse till the end of the linkedlist
	 * and make a pointer previous which will point to the
	 * previous node of the head and then make the previous.next
	 * to null
	 * 
	 * 1. check for head is null
	 * 2. check if there is only element
	 * 3. otherwise normal
	 * 
	 * Properties:
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * where n is the number of elements in the linkedlist
	 * 
	 * @param head
	 * @param a - new value
	 * @param position - position starting from 1
	 * @return the head of the new or updated linked list after this insertion
	 */
	public SinglyLinkedListNode deleteNodeLast(SinglyLinkedListNode head) {
		if(head == null) {
			return null;
		}
		SinglyLinkedListNode sn = new SinglyLinkedListNode();
		sn.next = head;
		SinglyLinkedListNode prev = head;
		head = head.next;
		if(head == null) {
			return null;
		}
		while(head.next != null) {
			head = head.next;
			prev = prev.next;
		}
		prev.next = null;
		return sn.next;
	}
	
	/**
	 * 
	 * Idea is to traverse till the key is found in the linkedlist
	 * and make a pointer previous which will point to the
	 * previous node of the head and then make the previous.next
	 * to the head.next
	 * 
	 * 1. check for head is null
	 * 2. check if head is the key
	 * 2. check if there is only element
	 * 3. otherwise normal
	 * 
	 * Properties:
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * where n is the number of elements in the linkedlist
	 * 
	 * @param head
	 * @param a - new value
	 * @param position - position starting from 1
	 * @return the head of the new or updated linked list after this insertion
	 */
	public SinglyLinkedListNode deleteNodeWithKey(SinglyLinkedListNode head, int key) {
		if(head == null) {
			return null;
		}
		if(head.val == key) {
			return head.next;
		}
		SinglyLinkedListNode sn = new SinglyLinkedListNode();
		sn.next = head;
		SinglyLinkedListNode prev = head;
		head = head.next;
		if(head ==  null) {
			return sn.next;
		}
		while(head.next != null && head.val != key) {
			prev = prev.next;
			head = head.next;
		}
		if(head.val == key) {
			prev.next = head.next;
		}
		return sn.next;
	}
	
	
	/**
	 * 
	 * Idea is to traverse till the position in the linkedlist
	 * and make a pointer previous which will point to the
	 * previous node of the head and then make the previous.next
	 * to the head.next
	 * 
	 * 1. check for head is null
	 * 2. check if position is 1
	 * 3. otherwise normal
	 * 
	 * Properties:
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * where n is the number of elements in the linkedlist
	 * 
	 * @param head
	 * @param a - new value
	 * @param position - position starting from 1
	 * @return the head of the new or updated linked list after this insertion
	 */
	public SinglyLinkedListNode deleteNodeMiddleFromStart(SinglyLinkedListNode head, int position) {
		if(head == null) {
			return null;
		}
		if(position == 1) {
			return head.next;
		}
		SinglyLinkedListNode sn = new SinglyLinkedListNode();
		sn.next = head;
		SinglyLinkedListNode prev = head;
		head = head.next;
		if(head == null) {
			return sn.next;
		}
		while(head.next != null && position > 2) {
			prev = prev.next;
			head = head.next;
			position--;
		}
		if(position == 2) {
			prev.next = head.next;
		}		
		return sn.next;
	}
	
	
	/**
	 * 
	 * Idea is to traverse till the position in the linkedlist
	 * and make a pointer previous which will point to the
	 * previous node of the head and then make the previous.next
	 * to the head.next
	 * 
	 * 1. check for head is null
	 * 2. otherwise normal
	 * 
	 * Properties:
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * where n is the number of elements in the linkedlist
	 * 
	 * @param head
	 * @param a - new value
	 * @param position - position starting from 1
	 * @return the head of the new or updated linked list after this insertion
	 */
	public SinglyLinkedListNode deleteNodeMiddleFromLast(SinglyLinkedListNode head, int position) {
		if(position < 1) {
			return head;
		}
		if(head == null) {
			return null;
		}
		SinglyLinkedListNode sn = new SinglyLinkedListNode();
		sn.next = head;
		
		SinglyLinkedListNode fast = head;
		SinglyLinkedListNode prev = head;
		head = head.next;
		while(fast.next != null && position >= 1) {
			fast = fast.next;
			position--;
		}
		if(position == 1 && fast.next == null) {
			return head;
		}
		if(position > 1) {
			return sn.next;
		}
		while(fast.next != null) {
			fast = fast.next;
			head = head.next;
			prev = prev.next;
		}
		prev.next = head.next;
		return sn.next;
	}
	
	/**
	 * prints the linkedlist from the provided head node
	 * @param head
	 */
	private void printLinkedList(SinglyLinkedListNode head) {
		while(head != null) {
			System.out.print(head.val + "  ");
			head = head.next;
		}
		System.out.println();
	}
	
	/**
	 * driver method
	 * @param args
	 */
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		SinglyLinkedListNode head = sll.insertNodeLast(null, 1);
		head = sll.insertNodeLast(head, 2);
		head = sll.insertNodeLast(head, 3);
		head = sll.insertNodeLast(head, 6);
		head = sll.insertNodeLast(head, 7);
		System.out.println("insertNodeLast");
		sll.printLinkedList(head);
		
		head = sll.insertNodeMiddleFromStart(head, 4, 4);
		System.out.println("insertNodeMiddleFromStart");
		sll.printLinkedList(head);
		
		head = sll.insertNodeMiddleFromLast(head, 5, 3);
		System.out.println("insertNodeMiddleFromLast");
		sll.printLinkedList(head);
		
		head = sll.deleteNodeLast(head);
		System.out.println("deleteNodeLast");
		sll.printLinkedList(head);
		
		head = sll.deleteNodeWithKey(head, 4);
		System.out.println("deleteNodeWithKey");
		sll.printLinkedList(head);
		
		head = sll.deleteNodeMiddleFromStart(head, 3);
		System.out.println("deleteNodeMiddleFromStart");
		sll.printLinkedList(head);
		
		head = sll.deleteNodeMiddleFromLast(head, 1);
		System.out.println("deleteNodeMiddleFromLast");
		sll.printLinkedList(head);
	}
}
