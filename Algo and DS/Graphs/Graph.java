import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Graph data structure stores the data in the form of:
 * 1. vertices
 * 2. edges
 * 
 * It can be represented in two forms:
 * 1. Adjacency matrix
 * 2. Adjacency list
 * 
 * For adjacency matrix:
 * Traversal complexities
 * Time complexity: O(V^2)
 * Space complexity: O(V^2)
 * Properties:
 * 1. Easier to implement and query like, add/remove an edge will
 * take O(1) time
 * 2. Queries like whether there is an edge between u and v will take O(1)
 * 3. Space required is O(V^2) even if the graph is sparse
 * 
 * For adjacency list:
 * Traversal complexities:
 * Time complexity: O(V + E)
 * Space complexity: O(V + E)
 *  
 *  This implementation uses the adjacency list
 */

/**
 * @author sanketmathur
 *
 */
public class Graph {
	
	int V;
	int E;
	LinkedList<Integer>[] adjList;
	Edge[] edges;
	int edgeCount = 0;
	public Graph(int V, int E) {
		this.V = V;
		this.E = E;
		adjList = new LinkedList[V];
		for(int i=0; i<V; i++) {
			adjList[i] = new LinkedList<>();
		}
		edges = new Edge[E];
	}
	
	/**
	 * add a directed edge from u to v by updating the adj list
	 * @param u
	 * @param v
	 */
	public void addDirectedEdge(int u, int v) {
		adjList[u].add(v);
		edges[edgeCount] = new Edge(u, v, 0);
		edgeCount++;
	}
	
	public void addDirectedEdge(int u, int v, int weight) {
		adjList[u].add(v);
		edges[edgeCount] = new Edge(u, v, weight);
		edgeCount++;
	}
	
	/**
	 * add an undirected edge from u to v by updating the adj list
	 * @param u
	 * @param v
	 */
	public void addUndirectedEdge(int u, int v) {
		adjList[u].add(v);
		adjList[v].add(u);
		edges[edgeCount] = new Edge(u, v, 0);
		edgeCount++;
	}
	
	public void addUndirectedEdge(int u, int v, int weight) {
		adjList[u].add(v);
		adjList[v].add(u);
		edges[edgeCount] = new Edge(u, v, weight);
		edgeCount++;
	}
	
	/**
	 * Breadth first search using queue
	 * @param source
	 * @return
	 */
	public List<Integer> BFS(int source) {
		List<Integer> result = new ArrayList<>();
		Queue<Integer> que = new LinkedList<>();
		Boolean[] visited = new Boolean[V];
		Arrays.fill(visited, false);
		BFSHelper(source, que, visited, result);
		for(int i=0; i<visited.length; i++) {
			if(!visited[i]) {
				BFSHelper(i, que, visited, result);
			}
		}
		
		return result;
	}
	
	/**
	 * A helper function for BFS
	 * @param s
	 * @param que
	 * @param visited
	 * @param result
	 */
	private void BFSHelper(int s, Queue<Integer> que, Boolean[] visited, List<Integer> result) {
		que.add(s);
		visited[s] = true;
		while(!que.isEmpty()) {
			int u = que.poll();
			result.add(u);
			Iterator<Integer> it = adjList[u].iterator();
			while(it.hasNext()) {
				int v = it.next();
				if(!visited[v]) {
					que.add(v);
					visited[v] = true;
				}
			}
		}
	}
	
	
	/**
	 * Depth first search using stack
	 * @param source
	 * @return
	 */
	public List<Integer> DFSStack(int source) {
		List<Integer> result = new ArrayList<>();
		Boolean[] visited = new Boolean[V];
		Arrays.fill(visited, false);
		Stack<Integer> st = new Stack<>();
		DFSStackHelper(source, st, visited, result);
		for(int i=0; i<V; i++) {
			if(!visited[i]) {
				DFSStackHelper(i, st, visited, result);
			}
		}
		return result;
	}
	
	/**
	 * DFS stack helper
	 * @param s
	 * @param st
	 * @param visited
	 * @param result
	 */
	public void DFSStackHelper(int s, Stack<Integer> st, Boolean[] visited, List<Integer> result) {
		st.push(s);
		visited[s] = true;
		while(!st.isEmpty()) {
			int u = st.pop();
			result.add(u);
			Iterator<Integer> it = adjList[u].iterator();
			while(it.hasNext()) {
				int v = it.next();
				if(!visited[v]) {
					st.push(v);
					visited[v] = true;
				}
			}
		}
	}
	
	
	/**
	 * Depth first search using recursion
	 * @param source
	 * @return
	 */
	public List<Integer> DFSRecursion(int source) {
		List<Integer> result = new ArrayList<>();
		Boolean[] visited = new Boolean[V];
		Arrays.fill(visited, false);
		DFSRecursionHelper(source, visited, result);
		for(int i=0; i<adjList.length; i++) {
			if(!visited[i]) {
				DFSRecursionHelper(i, visited, result);
			}
		}
		return result;
	}
	
	/**
	 * Helper method for DFSRecursion
	 * @param source
	 * @param visited
	 * @param result
	 */
	private void DFSRecursionHelper(int source, Boolean[] visited, List<Integer> result) {
		visited[source] = true;
		result.add(source);
		Iterator<Integer> it = adjList[source].iterator();
		while(it.hasNext()) {
			int v = it.next();
			if(!visited[v]) {
				DFSRecursionHelper(v, visited, result);
			}
		}
	}
	
	/**
	 * Prints a given list
	 * @param ls
	 */
	public void printList(List<Integer> ls) {
		for(int a: ls) {
			System.out.print(a + "  ");
		}
		System.out.println();
	}
	
	/**
	 * driver method
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("*****Undirected Graph******");
		Graph g = new Graph(8, 9);
		g.addUndirectedEdge(0, 1);
		g.addUndirectedEdge(0, 5);
		g.addUndirectedEdge(1, 2);
		g.addUndirectedEdge(2, 5);
		g.addUndirectedEdge(2, 4);
		g.addUndirectedEdge(2, 3);
		g.addUndirectedEdge(3, 4);
		g.addUndirectedEdge(4, 5);
		g.addUndirectedEdge(7, 6);
		
		List<Integer> ls = g.BFS(0);
		System.out.println("BFS");
		g.printList(ls);
		
		ls = g.DFSStack(0);
		System.out.println("DFS Stack");
		g.printList(ls);
		
		ls = g.DFSRecursion(0);
		System.out.println("DFS Recursion");
		g.printList(ls);
		
		System.out.println("*****Directed Graph******");
		
		Graph g1 = new Graph(8, 9);
		g1.addDirectedEdge(0, 1);
		g1.addDirectedEdge(0, 5);
		g1.addDirectedEdge(1, 2);
		g1.addDirectedEdge(2, 5);
		g1.addDirectedEdge(2, 4);
		g1.addDirectedEdge(2, 3);
		g1.addDirectedEdge(3, 4);
		g1.addDirectedEdge(4, 5);
		g1.addDirectedEdge(7, 6);
		
		List<Integer> ls1 = g1.BFS(0);
		System.out.println("BFS");
		g1.printList(ls1);
		
		ls1 = g1.DFSStack(0);
		System.out.println("DFS Stack");
		g1.printList(ls1);
		
		ls1 = g1.DFSRecursion(0);
		System.out.println("DFS Recursion");
		g1.printList(ls1);
	}
}
