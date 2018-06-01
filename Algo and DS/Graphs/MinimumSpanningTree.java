import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

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
	
	
	public List<Edge> prim(Graph g) {
		List<Edge> result = new ArrayList<>();
		Set<Vertex> set = new HashSet<>();
		Map<Integer, Edge> edgeMap = new HashMap<>();
		for(int i=0; i<g.E; i++) {
			edgeMap.put(g.edges[i].src*10+g.edges[i].dest, g.edges[i]);
		}
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
			v.parent = null;
			pq.offer(v);
		}
		while(!pq.isEmpty()) {
			Vertex v = pq.poll();
			
		}
		
		
		return result;
	}
	
	public void printEdges(List<Edge> edges) {
		for(int i=0; i<edges.size(); i++) {
			System.out.println(edges.get(i).src + "->" + edges.get(i).dest);
		}
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(8, 9);
		g.addUndirectedEdge(0, 1, 4);
		g.addUndirectedEdge(0, 5, 1);
		g.addUndirectedEdge(1, 2, 2);
		g.addUndirectedEdge(2, 5, 1);
		g.addUndirectedEdge(2, 4, 9);
		g.addUndirectedEdge(2, 3, 8);
		g.addUndirectedEdge(3, 4, 8);
		g.addUndirectedEdge(4, 5, 7);
		g.addUndirectedEdge(7, 6, 9);
		
		MinimumSpanningTree mst = new MinimumSpanningTree();
		List<Edge> kru = mst.kruskal(g);
		mst.printEdges(kru);
	}
	
}
