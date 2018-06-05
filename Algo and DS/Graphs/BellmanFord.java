import java.util.LinkedList;
import java.util.List;

/**
 * Single source shortest path algorithm
 * Reports for negative weight cycles
 * 
 * Time complexity: O(VE)
 * Space complexity: O(E)
 */

/**
 * @author sanketmathur
 *
 */
public class BellmanFord {

	public void bellmanFord(Graph g, int source) {
		
		Vertex[] vtx = new Vertex[g.V];
		for(int i=0; i<g.V; i++) {
			Vertex v = new Vertex(i);
			v.key = Integer.MAX_VALUE;
			v.parent = null;
			vtx[i] = v;
		}
		vtx[source].key = 0;
		
		for(int i=0; i<g.V-1; i++) {
			for(int j=0; j<g.E; j++) {
				if(vtx[g.edges[j].src].key != Integer.MAX_VALUE && vtx[g.edges[j].dest].key > vtx[g.edges[j].src].key + g.edges[j].weight) {
					vtx[g.edges[j].dest].key = vtx[g.edges[j].src].key + g.edges[j].weight;
					vtx[g.edges[j].dest].parent = vtx[g.edges[j].src];
				}
			}
		}
		
		for(int i=0; i<g.E; i++) {
			if(vtx[g.edges[i].dest].key > vtx[g.edges[i].src].key + g.edges[i].weight) {
				return;
			}
		}
		printPath(vtx, source);
		printVertex(vtx, source);
	}
	
	public void printPath(Vertex[] vtx, int source) {
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
	
	private void printVertex(Vertex[] vtx, int source) {
		for(int i=0; i<vtx.length; i++) {
			System.out.println("Source: " + source + " to Destination: " + vtx[i].val + "   Distance: " + vtx[i].key);
		}
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(5, 10);
		g.addDirectedEdge(0, 1, 6);
		g.addDirectedEdge(0, 2, 7);
		g.addDirectedEdge(1, 3, 5);
		g.addDirectedEdge(1, 2, 8);
		g.addDirectedEdge(1, 4, -4);
		g.addDirectedEdge(2, 3, -3);
		g.addDirectedEdge(2, 4, 9);
		g.addDirectedEdge(3, 1, -2);
		g.addDirectedEdge(4, 3, 7);
		g.addDirectedEdge(4, 0, 2);
		
		BellmanFord bf = new BellmanFord();
		bf.bellmanFord(g, 0);
	}
}
