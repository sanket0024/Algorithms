class LinkedList {
	// declare head node
	LinkedListNode head;
	// Node that contains data and link to the next node
	class LinkedListNode {
		int data;
		LinkedListNode next;
		// constructor
		public LinkedListNode(int data) {
			this.data = data;
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
			head = new LinkedListNode (d);
			return;
		}
		/*
		2. Traverse through the linkedlist, and reach to the end
		*/
		LinkedListNode last = head;
		while(last.next != null) {
			last = last.next;
		}
		/* 
		3. At the last node, change the next attribute from null
			to new node
		*/
		last.next = new LinkedListNode (d);
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
			then make head to the head.next and return;
		*/
		if(head.data == d) {
			head = head.next;
			System.out.println("Removing node for:" + d);
			return;
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
		while(currentNode != null) {
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
			while(currentNode != null) {
				System.out.println(currentNode.data);
				currentNode = currentNode.next;
			}
		}
		System.out.println();
	}
	void removeDuplicates() {
		if(this.head.next == null) {
			return;
		}
		LinkedListNode currentNode = head.next;
		LinkedListNode previousNode = head;
		while(currentNode != null) {
			LinkedListNode runnerNode = head;
			while(runnerNode != currentNode) {
				if(runnerNode.data == currentNode.data) {
					previousNode.next = runnerNode.next;
					break;
				}
				previousNode = runnerNode;
				runnerNode = runnerNode.next;
			}
			currentNode = currentNode.next;
		}
	}
	// Assumption that there will be n element in the list
	void nthElementFromLast(int n) {
		LinkedListNode last = head.next;
		LinkedListNode nFromLast = head;
		for(int i=0; last != null; i++) {
			last = last.next;
			if(i>=n-1) {
				nFromLast = nFromLast.next;
			}
		}
		System.out.println(n + "th Node from the last is: " + nFromLast.data);
	}
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.addNodeAtEnd(1);
		l.addNodeAtEnd(3);
		l.addNodeAtEnd(2);
		l.addNodeAtEnd(2);
		l.addNodeAtEnd(2);
		l.addNodeAtEnd(3);
		l.addNodeAtEnd(3);
		l.addNodeAtEnd(4);
		l.addNodeAtEnd(3);
		l.addNodeAtEnd(6);
		l.addNodeAtEnd(7);
		//l.printLinkedList();
		l.removeDuplicates();
		l.printLinkedList();
		l.nthElementFromLast(3);
		l.nthElementFromLast(6);
		l.nthElementFromLast(1);
	}
}