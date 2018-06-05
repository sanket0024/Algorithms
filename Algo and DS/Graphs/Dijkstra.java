import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Dijsktra
 * Single source shortest path algorithm
 * It will detect the shortest path from one source node
 * to the rest of the nodes in the graph
 * Logic is similar to Prim's algorithm
 * 
 * Time complexity: O(E log V)
 * Space complexity: O(V + E)
 * 
 * Limitations: cannot work for negative weight cycles
 */

/**
 * @author sanketmathur
 *
 */
public class Dijkstra {
	public Vertex[] dijkstra(Graph g, int source) {
		Map<Integer, Edge> edgeMap = new HashMap<>();
		populateEdgeMap(edgeMap, g.edges);
		Vertex[] vtx = new Vertex[g.V];
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
			if(i==source) {
				v.key = 0;
			}
			else {
				v.key = Integer.MAX_VALUE;
			}
			vtx[i] = v;
			pq.offer(vtx[i]);
		}
		while(!pq.isEmpty()) {
			Vertex u = pq.poll();
			Iterator<Integer> it = g.adjList[u.val].iterator();
			while(it.hasNext()) {
				int v = it.next();
				if(vtx[v].key > (vtx[u.val].key + edgeMap.get(u.val*10 + v).weight)) {
					pq.remove(vtx[v]);
					vtx[v].parent = u;
					vtx[v].key = vtx[u.val].key + edgeMap.get(u.val*10 + v).weight;
					pq.offer(vtx[v]);
				}
			}
		}
		return vtx;
	}
	
	private void populateEdgeMap(Map<Integer, Edge> edgeMap, Edge[] edges) {
		for(int i=0; i<edges.length; i++) {
			edgeMap.put(edges[i].src*10 + edges[i].dest, edges[i]);
		}
	}
	
	public void printVertex(Vertex[] vtx, int source) {
		List<Integer> ls = new LinkedList<>();
		for(int i=0; i<vtx.length; i++) {
			ls = new LinkedList<>();
			Vertex temp = vtx[i];
//			System.out.println("temp.val: " + temp.val);
//			if(temp.parent != null) {
//				System.out.println("temp.parent: " + temp.parent.val);
//			}
			while(temp != null && temp.val != source) {
//				System.out.println("Here");
				ls.add(0, temp.val);
				temp = temp.parent;
			}
//			if(!ls.isEmpty()) {
//				System.out.println(ls.get(0));
//				System.out.println(ls.get(0).val);
//			}
			if(temp.val == source) {
				printList(ls, source);
			}
		}
	}
	
	private void printList(List<Integer> ls, int source) {
		if(!ls.isEmpty()) {
			ls.add(0, source);
		}
		for(int v: ls) {
			System.out.print(v + "  ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(5, 10);
		g.addDirectedEdge(0, 1, 10);
		g.addDirectedEdge(0, 2, 5);
		g.addDirectedEdge(1, 3, 1);
		g.addDirectedEdge(1, 2, 2);
		g.addDirectedEdge(2, 1, 3);
		g.addDirectedEdge(2, 3, 9);
		g.addDirectedEdge(2, 4, 2);
		g.addDirectedEdge(3, 4, 4);
		g.addDirectedEdge(4, 3, 6);
		g.addDirectedEdge(4, 0, 7);
		
		Dijkstra dij = new Dijkstra();
		Vertex[] vs = dij.dijkstra(g, 0);
		dij.printVertex(vs, 0);
	}
}
