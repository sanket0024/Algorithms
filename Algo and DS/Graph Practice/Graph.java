import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Iterator;
class Graph {
	//representation of graph using adjacency list
	public LinkedList<Integer>[] adjacencyList;
	public int numOfVertexes;
	public int numOfEdges;
	public Edge[] edges;
	public  int edgeCount;	// count for the number of edges added so far

	// constructor
	public  Graph(int numOfVertexes, int numOfEdges) {
		this.numOfVertexes = numOfVertexes;
		this.numOfEdges = numOfEdges;
		adjacencyList = new LinkedList[numOfVertexes];
		for(int i=0; i<numOfVertexes; i++) {
			adjacencyList[i] = new LinkedList<Integer>();
		}
		edges = new Edge[numOfEdges];
		for(int i=0; i<numOfEdges; i++) {
			edges[i] = new Edge();
		}
	}

	// add undirected edge to the graph
	public void addUndirectedEdge(int v1, int v2, int weight) {
		edgeCount++;
		if(edgeCount > numOfEdges) {
			System.out.println("Number of edges exceed than allowed");
			System.exit(1);
		}
		edges[edgeCount-1].src = v1;
		edges[edgeCount-1].dest = v2;
		edges[edgeCount-1].weight = weight;
		adjacencyList[v1].add(v2);
		// because graph is undirected so we need to add the
		// src to the list of dest as well
		adjacencyList[v2].add(v1);
	}

	// add undirected edge to the graph
	public void addDirectedEdge(int v1, int v2, int weight) {
		edgeCount++;
		if(edgeCount > numOfEdges) {
			System.out.println("Number of edges exceed than allowed");
			System.exit(1);
		}
		edges[edgeCount-1].src = v1;
		edges[edgeCount-1].dest = v2;
		edges[edgeCount-1].weight = weight;
		adjacencyList[v1].add(v2);
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

	// find whether an undirected graph has cycle or not
	public boolean hasCycles() {
		boolean[] visited = new boolean[numOfVertexes];
		for(int i=0; i<numOfVertexes; i++) {
			visited[i] = false;
		}
		for(int i=0; i<numOfVertexes; i++) {
			if(!visited[i]) {
				if(isCyclic(visited, i, -1)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isCyclic(boolean[] visited, int currentNode, int parent) {
		visited[currentNode] = true;
		LinkedList<Integer> temp = adjacencyList[currentNode];
		Iterator it = temp.iterator();
		while(it.hasNext()) {
			Integer nTemp = (int)it.next();
			if(!visited[nTemp]) {
				if(isCyclic(visited, nTemp, currentNode)) {
					return true;
				}
			}
			else if(parent != nTemp) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Graph undirected = new Graph(1,2);
		undirected.addUndirectedEdge(2,3,0);
		undirected.addUndirectedEdge(3,1,0);
		undirected.addUndirectedEdge(3,4,0);
		undirected.addUndirectedEdge(4,5,0);
		undirected.addUndirectedEdge(6,1,0);
		undirected.addUndirectedEdge(7,6,0);
		undirected.addUndirectedEdge(7,8,0);
		undirected.addUndirectedEdge(8,6,0);

		// Graph directed = new Graph(5,8);
		// directed.addDirectedEdge(0,1,0);
		// directed.addDirectedEdge(1,0,0);
		// directed.addDirectedEdge(2,0,0);
		// directed.addDirectedEdge(0,0,0);
		// directed.addDirectedEdge(1,2,0);
		// directed.addDirectedEdge(1,3,0);
		// directed.addDirectedEdge(1,4,0);
		// directed.addDirectedEdge(3,4,0);
		// directed.printAdjacencyList(0);
		// directed.printAdjacencyList(1);
		// directed.printAdjacencyList(2);
		// directed.printAdjacencyList(3);
		// directed.printAdjacencyList(4);
		// directed.BFS(0);
		// directed.DFS(0);
		// System.out.println(directed.hasCycles());
	}
}