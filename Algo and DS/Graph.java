import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Stack;

class Graph {
	//representation of graph using adjacency list
	LinkedList<Integer>[] adjacencyList;
	int numOfVertexes;

	// constructor
	Graph(int numOfVertexes) {
		this.numOfVertexes = numOfVertexes;
		adjacencyList = new LinkedList[numOfVertexes];
		for(int i=0; i<numOfVertexes; i++) {
			adjacencyList[i] = new LinkedList<Integer>();
		}
	}

	// add edge to the graph
	public void addEdge(int v1, int v2) {
		adjacencyList[v1].add(v2);
		// because graph is undirected so we need to add the
		// src to the list of dest as well
		adjacencyList[v2].add(v1);
	}

	//print adjacency list for the given node
	public void printAdjacencyList(int vertex) {
		System.out.println("\nAdjacency list for node " + vertex + ":");
		for(int i=0; i<adjacencyList[vertex].size(); i++) {
			System.out.print(adjacencyList[vertex].get(i) + " ");
		}
		System.out.println();
	}

	// Graph traversal BFS 
	/*
	* 1. Initialize all the nodes with the status as NV - not visited
	* 2. Put the starting node into the queue and mark it as visited
	* 3. Repeat step 4 to 7 until queue is not empty:
	* 4.  Remove from the front of the queue
	* 5.  Process node
	* 6.  Add adjascent nodes of the current node to the queue whose
	*     status is not visited
	* 7.  Change the status of node to visited
	* 8. Exit
	*/
	public void BFS(int n) {
		Queue<Integer> q = new PriorityQueue<Integer>();
		boolean[] visited = new boolean[numOfVertexes];
		for(int i=0; i<visited.length; i++) {
			visited[i] = false;
		}
		q.offer(n);
		visited[n] = true;
		System.out.println("BFS Traversal from node " + n +": ");
		while(!q.isEmpty()) {
			int tempNode = q.poll();
			System.out.print(tempNode + " ");
			LinkedList<Integer> tempList = adjacencyList[tempNode];
			for(int i=0; i<tempList.size(); i++) {
				if(!visited[tempList.get(i)]) {
					q.offer(tempList.get(i));
					visited[tempList.get(i)] = true;
				}
			}
		}
		System.out.println();
	}

	// Graph traversal DFS
	/*
	* 1. Initialize all the nodes with the status as not visited
	* 2. Put the starting node onto the stack and mark it as visited
	* 3. Repeat steps 4 to 7 until stack is not empty
	* 4.  Pop an item from the stack
	*.5.  Process the item 
	* 6.  Add to the stack all the adjacent nodes whose status is not visited
	* 7.  Change the status of the node to visited
	* 8. Exit
	*/
	public void DFS(int n) {
		Stack<Integer> s = new Stack<Integer>();
		boolean[] visited = new boolean[numOfVertexes];
		s.push(n);
		visited[n] = true;
		System.out.println("DFS Traversal from node " + n +": ");
		while(!s.empty()) {
			int tempNode = s.pop();
			System.out.print(tempNode + " ");
			LinkedList<Integer> tempList = adjacencyList[tempNode];
			for(int i=0; i<tempList.size(); i++) {
				if(!visited[tempList.get(i)]) {
					s.push(tempList.get(i));
					visited[tempList.get(i)] = true;
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(0,3);
		g.addEdge(1,2);
		g.addEdge(1,3);
		g.addEdge(1,4);
		g.addEdge(3,4);
		g.printAdjacencyList(0);
		g.printAdjacencyList(1);
		g.printAdjacencyList(2);
		g.printAdjacencyList(3);
		g.printAdjacencyList(4);
		g.BFS(0);
		g.DFS(0);
	}
}