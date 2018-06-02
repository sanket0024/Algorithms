import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Miniumum Spanning Tree are formed from a graph
 * connecting all the nodes
 */

/**
 * @author sanketmathur
 *
 */
public class MinimumSpanningTree {

	DisjointSet ds = new DisjointSet();
	
	/**
	 * Kruskal MST
	 * Time complexity: O(E logV)
	 * Space complexity: O(E)
	 * @param g
	 * @return
	 */
	public List<Edge> kruskal(Graph g) {
		List<Edge> result = new ArrayList<>();
		for(int i=0; i<g.V; i++) {
			ds.makeset(i);
		}
		
		Arrays.sort(g.edges, new Comparator<Edge>() {
			public int compare(Edge e1, Edge e2) {
				if(e1.weight < e2.weight) {
					return -1;
				}
				else {
					return 1;
				}
			}
		});
		
		for(int i=0; i<g.E; i++) {
			Edge e = g.edges[i];
			int sr = ds.findset(e.src);
			int dt = ds.findset(e.dest);
			if(sr != dt) {
				result.add(e);
				ds.union(sr,  dt);
			}
		}
		return result;
	}
	
	/**
	 * prim's algorithm
	 * Time complexity: O(E logV)
	 * Space complexity:O(V + E)
	 * Using Priority Queue 
	 * @param g
	 * @return
	 */
	public List<Edge> prim(Graph g) {
		List<Edge> result = new ArrayList<>();
		Vertex[] vts = new Vertex[g.V];
		Map<Integer, Edge> edgeMap = new HashMap<>();
		Map<Integer, Edge> visited = new HashMap<>();
		populateEdgeMap(g, edgeMap);
		PriorityQueue<Vertex> pq = new PriorityQueue<>(new Comparator<Vertex>() {
			public int compare(Vertex v1, Vertex v2) {
				if(v1.key < v2.key) {
					return -1;
				}
				else {
					return 1;
				}
			}
		});
		for(int i=0; i<g.V; i++) {
			Vertex v = new Vertex(i);
			if(i==0) {
				v.key = 0;
			}
			else {
				v.key = Integer.MAX_VALUE;
			}
			vts[i] = v;
			pq.offer(vts[i]);
		}
		//printPriorityQueue(pq);
		while(!pq.isEmpty()) {
			Vertex u = pq.poll();
			//System.out.println("pq.poll().key " + u.key + "       pq.poll().val: " + u.val);
			if(visited.get(u.val) != null) {
				//System.out.println("Adding " + u.val + " to result : " + visited.get(u.val).src + " to " + visited.get(u.val).dest);
				result.add(visited.get(u.val));
			}
			Iterator<Integer> it = g.adjList[u.val].iterator();
			while(it.hasNext()) {
				int v = it.next();
				//System.out.println(u.val + "  " + v);
				Edge e = getEdge(u.val, v, edgeMap);
				if(e!=null && vts[v].key > e.weight) {
					//System.out.println("removing: " + vts[v].key + "      value: " + vts[v].val);
					pq.remove(vts[v]);
					vts[v].key = e.weight;
					visited.put(v, e);
					pq.offer(vts[v]);
				}
			}
		}
		return result;
	}
	
	private void populateEdgeMap(Graph g, Map<Integer, Edge> edgeMap) {
		for(int i=0; i<g.E; i++) {
			edgeMap.put(g.edges[i].src*10 + g.edges[i].dest, g.edges[i]);
			edgeMap.put(g.edges[i].dest*10 + g.edges[i].src, g.edges[i]);
		}
	}
	
	private Edge getEdge(int src, int dest, Map<Integer, Edge> edgeMap) {
		return (edgeMap.get(src*10 + dest));
	}
	
	public void printEdges(List<Edge> edges) {
		System.out.println(edges.size());
		for(int i=0; i<edges.size(); i++) {
			System.out.println(edges.get(i).src + "->" + edges.get(i).dest);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(6, 8);
		g.addUndirectedEdge(0, 1, 4);
		g.addUndirectedEdge(0, 5, 1);
		g.addUndirectedEdge(1, 2, 2);
		g.addUndirectedEdge(2, 5, 1);
		g.addUndirectedEdge(2, 4, 9);
		g.addUndirectedEdge(2, 3, 8);
		g.addUndirectedEdge(3, 4, 8);
		g.addUndirectedEdge(4, 5, 7);
		
		MinimumSpanningTree mst = new MinimumSpanningTree();
		System.out.println("**********Kruskal**********");
		List<Edge> kru = mst.kruskal(g);
		mst.printEdges(kru);
		
		System.out.println("**********Prim**********");
		List<Edge> pri = mst.prim(g);
		mst.printEdges(pri);
	}
}
