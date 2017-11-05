import java.util.HashSet;
import java.util.Set;
class CircularLinkedList {
	// declare head node
	LinkedListNode head;
	// Node that contains data and link to the next node
	class LinkedListNode {
		int data;
		LinkedListNode next;
		// constructor
		public LinkedListNode(int data) {
			this.data = data;
			// reference to head for circular linked list
			LinkedListNode next = null;
		}
	}
	void addNodeAtEnd(int d) {
		/*
		1. check if head is empty?
			if true: that means the linkedlist is empty
			then put the new node at head.
		*/
		if(head == null) {
			head = new LinkedListNode(d);
			head.next = head;
			return;
		}
		/*
		2. If head is the only element in the list:
			Set link to the head to the new node
			set new node's next as head for circularreference
		*/
		if(head.next == head) {
			head.next = new LinkedListNode(d);
			head.next.next = head;
			return;
		}
		/*
		3. Traverse through the linkedlist, and reach to the end
		(where the last node is linked to the head)
		*/
		LinkedListNode last = head;
		while(last.next != head) {
			last = last.next;
		}
		/* 
		4. At the last node, change the next attribute from head
			to new node
		*/
		last.next = new LinkedListNode (d);
		last.next.next = head;
	}
	void deleteNode(int d) {
		/*
		1. Check is head is empty?
			if true: that means the linkedlist is empty,
			nothing to delete
		*/
		if(head == null) {
			System.out.println("LinkedList is empty. Match not found for: " + d);
			return;
		}
		/*
		2. If head has the element
			then check if the linked list has only one node, if yes, then set head = null
			otherwise, traverse to the end of the list, set head = head.next and
			set last element of the list to refer to the new head
		*/
		if(head.data == d) {
			if(head.next == head) {
				head = null;
				System.out.println("Removing node for:" + d);
				return;
			}
			else {
				LinkedListNode currentNode = head.next;
				while(currentNode.next != head) {
					currentNode = currentNode.next;
				}
				head = head.next;
				currentNode.next = head;
				System.out.println("Removing node for:" + d);
				return;
			}
		}
		/*
		3. Search for the given element by traversing through the list
			if not found, in the whole list
			return nothing to delete

		4. Node found:
			set previousNode.next to the currentNode.next
		*/
		LinkedListNode currentNode = head.next;
		LinkedListNode previousNode = head;
		// it will delete first occurencce of the node that matches
		while(currentNode != head) {
			if(currentNode.data == d) {
				System.out.println("Removing node for:" + d);
				previousNode.next = currentNode.next;
				return;
			}
			previousNode = currentNode;
			currentNode = currentNode.next;
		}
		System.out.println("Match not found for:" + d);

	}
	void printLinkedList() {
		System.out.println("**PRINTING LINKEDLIST**");
		if(this.head == null) {
			System.out.println("Linkedlist is empty");
		}
		else {
			LinkedListNode currentNode = this.head;
			while(currentNode.next != head) {
				System.out.println(currentNode.data);
				currentNode = currentNode.next;
			}
			System.out.println(currentNode.data);
		}
		System.out.println();
	}
	LinkedListNode corrupt() {
		Set<LinkedListNode> h = new HashSet<LinkedListNode>();
		if(head.next == head) {
			return head;
		}
		LinkedListNode previousNode = head;
		LinkedListNode currentNode = head.next;
		h.add(previousNode);
		//System.out.println(h.keySet());
		while(!h.contains(currentNode)) {
			h.add(previousNode);
			previousNode = currentNode;
			currentNode = currentNode.next;
		}
		return previousNode;
	}
	public static void main(String[] args) {
		CircularLinkedList l = new CircularLinkedList();
		l.addNodeAtEnd(1);
		l.addNodeAtEnd(2);
		l.addNodeAtEnd(3);
		l.addNodeAtEnd(4);
		l.addNodeAtEnd(5);
		l.addNodeAtEnd(6);
		l.printLinkedList();
		LinkedListNode result = l.corrupt();
		System.out.println(result.data);
	}
}