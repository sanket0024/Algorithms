class Queue {
	int front = -1;
	int rear = -1;
	public void enqueue(int[] arr, int ele) {
		if(rear == arr.length) {
			System.out.println("Queue is full");
		}
		else {
			if(front < 0)
				front++;
			rear++;
			arr[rear] = ele;
			for(int a: arr) {
				System.out.print(a + " ");
			}
			System.out.println("\n");
		}
	}
	public void dequeue(int[] arr) {
		if(front < 0 || front > rear) {
			System.out.println("Queue is empty");
		}
		else {
			System.out.println("Element dequeued is: " + arr[front]);
			front++;
		}
	}
	public void peek(int[] arr) {
		if(front < 0 || front > rear) {
			System.out.println("Queue is empty");
		}
		else {
			System.out.println("Element peek is: " + arr[front]);
		}
	}
	public static void main(String[] args) {
		Queue q = new Queue();
		int[] que = new int[100];
		q.enqueue(que, 101);
		q.enqueue(que, 102);
		q.enqueue(que, 103);
		q.enqueue(que, 104);
		q.dequeue(que);
		q.dequeue(que);
		q.peek(que);
	}
}