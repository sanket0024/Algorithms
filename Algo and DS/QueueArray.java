class QueueArray {
	int front = -1;
	int rear = -1;
	public void enqueue(int[] arr, int ele) {
		/*
		Add to the queue
		1. Check if queue is full?
			YES: return queue is full. Overflow
		else increment rear to the next empty space
		and set element at the arr[rear]
		*/
		if(rear >= arr.length) {
			System.out.println("Overflow");
			return;
		}
		else {
			if(front < 0)
				front++;
			rear++;
			arr[rear] = ele;
		}
	}
	/*
	DELETE from queue
	1. Check if queue is empty?
	front<0 or front > rear
		YES: return queue is empty: Underflow
	else front++
	*/
	public void dequeue(int[] arr) {
		if(front < 0 || front > rear) {
			System.out.println("Underflow");
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
			System.out.println("Element at front of the queue is: " + arr[front]);
		}
	}
	public static void main(String[] args) {
		QueueArray q = new QueueArray();
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