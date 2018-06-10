import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * A bipartite graph G is a graph whose vertices can be divided into two
 * disjoint and independent set (U and V) such that every edge in the graph
 * connect a vertex from set U to to a vertex from set V.
 * In other words it does not contain any odd length cycles.
 * 
 * Every tree is a bipartite
 * Cycle graphs with even number of vertices are bipartite
 * 
 * Complexity:
 * Time: O(V + E)
 * Space: O(V)
 */

/**
 * @author sanketmathur
 *
 */
public class Bipartite {

	/**
	 * Idea is to assign colours in the form of numbers to every vertex
	 * of the graph
	 * -1 = no color
	 * 1 = red
	 * 0 = blue
	 * If adjacent has same color then it is not a bipartite
	 * 
	 * @param g
	 * @param source
	 * @return
	 */
	public boolean isBipartite(Graph g, int source) {
		int group[] = new int[g.V];
		for(int i=0; i<g.V; i++) {
			group[i] = -1;
		}
		Vertex[] vtx = new Vertex[g.V];
		for(int i=0; i<g.V; i++) {
			vtx[i] = new Vertex(i);
		}
		for(int i=0; i<g.V; i++) {
			if(group[i] == -1) {
				if(!isBipartite(g, i, group, vtx)) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Helper method to check if the given graph is bipartite
	 * This is necessary if the graph is not connected
	 * @param g
	 * @param source
	 * @param group
	 * @param vtx
	 * @return
	 */
	private boolean isBipartite(Graph g, int source, int[] group, Vertex[] vtx) {
		Queue<Vertex> que = new LinkedList<>();
		group[source] = 1;
		que.add(vtx[source]);
		while(!que.isEmpty()) {
			Vertex u = que.poll();
			Iterator<Integer> it = g.adjList[u.val].iterator();
			while(it.hasNext()) {
				int v = it.next();
				if(group[v] == -1) {
					group[v] = 1-group[u.val];
					que.offer(vtx[v]);
				}
				else if(group[v] == group[u.val]) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param arr
	 */
	public void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println("\n");
	}
	
	/**
	 * driver method
	 * @param args
	 */
	public static void main(String[] args) {
		Graph g = new Graph(4, 8);
		g.addDirectedEdge(0, 1);
		g.addDirectedEdge(0, 3);
		g.addDirectedEdge(1, 0);
		g.addDirectedEdge(1, 2);
		g.addDirectedEdge(2, 1);
		g.addDirectedEdge(2, 3);
		g.addDirectedEdge(3, 0);
		g.addDirectedEdge(3, 3);
		
		Bipartite bp = new Bipartite();
		boolean result = bp.isBipartite(g, 0);
		System.out.println(result);
	}
}
