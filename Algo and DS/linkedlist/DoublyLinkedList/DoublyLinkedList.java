/**
 * DoublyLinkedList - insertion and deletion
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
 * Complexities will cover the search time as well
 */

package DoublyLinkedList;

/**
 * @author sanketmathur
 *
 */
public class DoublyLinkedList {
	
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
	public DoublyLinkedListNode insertNodeLast(DoublyLinkedListNode head, int a) {
		if(head == null) {
			return new DoublyLinkedListNode(a);
		}
		DoublyLinkedListNode dn = new DoublyLinkedListNode();
		dn.next = head;
		while(head.next != null) {
			head = head.next;
		}
		DoublyLinkedListNode newNode = new DoublyLinkedListNode(a);
		newNode.next = null;
		newNode.previous = head;
		head.next = newNode;
		return dn.next;
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
	public DoublyLinkedListNode insertNodeMiddleFromStart(DoublyLinkedListNode head, int a, int position) {
		if(head == null) {
			return new DoublyLinkedListNode(a);
		}
		if(position <= 1) {
			DoublyLinkedListNode newNode = new DoublyLinkedListNode(a);
			newNode.previous = null;
			newNode.next = head;
			head.previous = newNode;
			return newNode;
		}
		DoublyLinkedListNode dn = new DoublyLinkedListNode();
		dn.next = head;
		DoublyLinkedListNode front = head.next;
		while(head.next != null && position > 2) {
			head = head.next;
			if(front != null) {
				front = front.next;
			}
			position--;
		}
		DoublyLinkedListNode newNode = new DoublyLinkedListNode(a);
		newNode.previous = head;
		newNode.next = head.next;
		head.next = newNode;
		if(front != null) {
			front.previous = newNode;
		}
		return dn.next;
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
	public DoublyLinkedListNode insertNodeMiddleFromLast(DoublyLinkedListNode head, int a, int position) {
		if(head == null) {
			return new DoublyLinkedListNode(a);
		}
		DoublyLinkedListNode dn = new DoublyLinkedListNode();
		dn.next = head;
		DoublyLinkedListNode fast = head;
		DoublyLinkedListNode front = head;
		front = front.next;
		while(fast.next != null && position > 1) {
			fast = fast.next;
			position--;
		}
		if(fast.next == null && position > 1) {
			DoublyLinkedListNode newNode = new DoublyLinkedListNode(a);
			newNode.next = head;
			head.previous = newNode;
			return newNode;
		}
		while(fast.next != null) {
			fast = fast.next;
			head = head.next;
			if(front != null) {
				front = front.next;
			}
		}
		DoublyLinkedListNode newNode = new DoublyLinkedListNode(a);
		newNode.next = front;
		newNode.previous = head;
		head.next = newNode;
		if(front != null) {
			front.previous = newNode;
		}
		return dn.next;
	}
	
	
	/**
	 * 
	 * Idea is to traverse till the end of the linkedlist
	 * and make a pointer rear which will point to the
	 * previous node of the head and then make the rear.next
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
	public DoublyLinkedListNode deleteNodeLast(DoublyLinkedListNode head) {
		if(head == null) {
			return null;
		}
		DoublyLinkedListNode dn = new DoublyLinkedListNode();
		dn.next = head;
		head = head.next;
		if(head == null) {
			return null;
		}
		while(head.next != null) {
			head = head.next;
		}
		head.previous.next = null;
		return dn.next;
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
	public DoublyLinkedListNode deleteNodeWithKey(DoublyLinkedListNode head, int key) {
		if(head == null) {
			return null;
		}
		if(head.val == key) {
			DoublyLinkedListNode temp = head.next;
			head.next = null;
			if(temp != null) {
				temp.previous = null;
			}
			return temp;
		}
		DoublyLinkedListNode dn = new DoublyLinkedListNode();
		dn.next = head;
		head = head.next;
		while(head.next != null && head.val != key) {
			head = head.next;
		}
		if(head.val == key) {
			head.previous.next = head.next;
			if(head.next != null) {
				head.next.previous = head.previous;
			}
		}
		return dn.next;
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
	public DoublyLinkedListNode deleteNodeMiddleFromStart(DoublyLinkedListNode head, int position) {
		if(head == null) {
			return null;
		}
		if(position == 1) {
			DoublyLinkedListNode temp = head.next;
			head.next = null;
			if(temp != null) {
				temp.previous = null;
			}
			return temp;
		}
		if(position < 1) {
			return head;
		}
		DoublyLinkedListNode dn = new DoublyLinkedListNode();
		dn.next = head;
		while(head.next != null && position > 1) {
			head = head.next;
			position--;
		}
		head.previous.next = head.next;
		if(head.next != null) {
			head.next.previous = head.previous;
		}
		return dn.next;
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
	public DoublyLinkedListNode deleteNodeMiddleFromLast(DoublyLinkedListNode head, int position) {
		if(head == null || position < 1) {
			return head;
		}
		DoublyLinkedListNode dn = new DoublyLinkedListNode();
		dn.next = head;
		DoublyLinkedListNode fast = head;
		while(fast.next != null && position > 1) {
			fast = fast.next;
			position--;
		}
		if(fast.next == null && position > 1) {
			return head;
		}
		if(fast.next == null && position == 1) {
			DoublyLinkedListNode temp = head.next;
			head.next = null;
			temp.previous = null;
			return temp;
		}
		while(fast.next != null) {
			head = head.next;
			fast = fast.next;
		}
		head.previous.next = head.next;
		if(head.next != null) {
			head.next.previous = head.previous;
		}
		return dn.next;
	}
	
	/**
	 * prints the linkedlist from the provided head node till the end
	 * @param head
	 */
	private void printLinkedListForward(DoublyLinkedListNode head) {
		while(head != null) {
			System.out.print(head.val + "  ");
			head = head.next;
		}
		System.out.println();
	}
	
	/**
	 * prints the linkedlist from the provided end node till the start
	 * @param head
	 */
	private void printLinkedListBackword(DoublyLinkedListNode head) {
		if(head == null) {
			return;
		}
		while(head.next != null) {
			head = head.next;
		}
		while(head != null) {
			System.out.print(head.val + "  ");
			head = head.previous;
		}
		System.out.println();
	}
	
	/**
	 * driver method
	 * @param args
	 */
	public static void main(String[] args) {
		DoublyLinkedList sll = new DoublyLinkedList();
		DoublyLinkedListNode head = sll.insertNodeLast(null, 1);
		head = sll.insertNodeLast(head, 2);
		head = sll.insertNodeLast(head, 3);
		head = sll.insertNodeLast(head, 6);
		head = sll.insertNodeLast(head, 7);
		System.out.println("insertNodeLast");
		sll.printLinkedListForward(head);
		sll.printLinkedListBackword(head);
		System.out.println();
		
		head = sll.insertNodeMiddleFromStart(head, 4, 4);
		System.out.println("insertNodeMiddleFromStart");
		sll.printLinkedListForward(head);
		sll.printLinkedListBackword(head);
		System.out.println();
		
		head = sll.insertNodeMiddleFromLast(head, 5, 3);
		System.out.println("insertNodeMiddleFromLast");
		sll.printLinkedListForward(head);
		sll.printLinkedListBackword(head);
		System.out.println();
		
		head = sll.deleteNodeLast(head);
		System.out.println("deleteNodeLast");
		sll.printLinkedListForward(head);
		sll.printLinkedListBackword(head);
		System.out.println();
		
		head = sll.deleteNodeWithKey(head, 6);
		System.out.println("deleteNodeWithKey");
		sll.printLinkedListForward(head);
		sll.printLinkedListBackword(head);
		System.out.println();
		
		head = sll.deleteNodeMiddleFromStart(head, 5);
		System.out.println("deleteNodeMiddleFromStart");
		sll.printLinkedListForward(head);
		sll.printLinkedListBackword(head);
		System.out.println();
		
		head = sll.deleteNodeMiddleFromLast(head, 1);
		System.out.println("deleteNodeMiddleFromLast");
		sll.printLinkedListForward(head);
		sll.printLinkedListBackword(head);
	}
}
