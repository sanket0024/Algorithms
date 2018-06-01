import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Topological sorting is the linear odering of the vertices in
 * a directed acyclic graph.
 * A directed graph should be acyclic to perform topological sort.
 * 
 * A topological sort can be visualized as a set of activities u -> v
 * where activity u should come before activity v
 * 
 * Every DAG has at least one topological ordering.
 * A single DAG can have multiple topological orderings
 *  
 * Complexity:
 * Time: O(V + E)
 * Space: O(V + E) stack space
 */

/**
 * @author sanketmathur
 *
 */
public class TopologicalSort {

	LinkedList<Integer>[] adjList;
	
	/**
	 * topological sort using DFS recursion method
	 * @param V
	 * @param adjList
	 * @return
	 */
	public List<Integer> topologocalSort(int V, LinkedList<Integer>[] adjList) {
		this.adjList = adjList;
		List<Integer> result = new LinkedList<>();
		boolean[] visited = new boolean[V];
		Arrays.fill(visited, false);
		for(int i=0; i<V; i++) {
			if(!visited[i]) {
				topologocalSortHelper(i, visited, result);
			}
		}
		return result;
	}
	
	/**
	 * Helper method for topological sort using dfs method
	 * @param s
	 * @param visited
	 * @param result
	 */
	private void topologocalSortHelper(int s, boolean[] visited, List<Integer> result) {
		visited[s] = true;
		Iterator<Integer> it = adjList[s].iterator();
		while(it.hasNext()) {
			int v = it.next();
			if(!visited[v]) {
				topologocalSortHelper(v, visited, result);
			}
		}
		result.add(0, s);
	}
	
	
	/**
	 * Topological sort using Kahn's algorithm
	 * @param V
	 * @param adjList
	 * @return
	 */
	public List<Integer> topologicalSortKahn(int V, LinkedList<Integer>[] adjList) {
		List<Integer> result = new LinkedList<>();
		this.adjList = adjList;
		int[] indegree = new int[V];
		for(int i=0; i<V; i++) {
			Iterator<Integer> it = adjList[i].iterator();
			while(it.hasNext()) {
				indegree[it.next()]++;
			}
		}
		Queue<Integer> que = new LinkedList<>();
		for(int i=0; i<V; i++) {
			if(indegree[i] == 0) {
				que.offer(i);
			}
		}
		while(!que.isEmpty()) {
			int u = que.poll();
			result.add(u);
			Iterator<Integer> it = adjList[u].iterator();
			while(it.hasNext()) {
				int p = it.next();
				if(indegree[p] > 0) {
					indegree[p]--;
					if(indegree[p] == 0) {
						que.offer(p);
					}
				}
			}
		}
		return result;
	}
	
	/**
	 * developer method
	 * @param args
	 */
	public static void main(String[] args) {
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
		TopologicalSort ts = new TopologicalSort();
		
		System.out.println("Using DFS");
		List<Integer> ls1 = ts.topologocalSort(8, g1.adjList);
		g1.printList(ls1);
		
		
		System.out.println("Using Kahn's algorithm");
		ls1 = ts.topologicalSortKahn(8, g1.adjList);
		g1.printList(ls1);
	}
}
