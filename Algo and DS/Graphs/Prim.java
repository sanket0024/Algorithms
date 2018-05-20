import java.util.*;

class Prim {

	Map<Integer, Edge> edgesMap = new HashMap<>();

	private void populateEdgesMao(Edge[] edges) {
		for(int i=0; i<edges.length; i++) {
			edgesMap.put(edges[i].src*10 + edges[i].dest, edges[i]);
		}
	}

	public List<Edge> primMST(LinkedList[] adj, Edge[] edges) {
		populateEdgesMao(edges);
		List<Edge> result = new ArrayList<>();
		Vertex[] vertices = new Vertex[adj.length];
		PriorityQueue<Vertex> vertxQue = new PriorityQueue<>(adj.length, new Comparator<Vertex>() {
			public int compare(Vertex v1, Vertex v2) {
				if(v1.key < v2.key) return -1;
				else return 1;
			}
		});
		for(int i=0; i<adj.length; i++) {
			vertices[i] = new Vertex(i, Integer.MAX_VALUE, null);
			vertxQue.offer(vertices[i]);
		}
		vertices[0].key = 0;
		while(!vertxQue.isEmpty()) {
			Vertex u = vertxQue.poll();
			if(u.parent == null) {
				System.out.println("null, " + u.value);
			}
			else {
				System.out.println(u.parent.value + ", " + u.value);
				result.add(findEdge(u.parent.value, u.value));
			}
			LinkedList<Integer> children = adj[u.value];
			Iterator<Integer> it = children.iterator();
			while(it.hasNext()) {
				Vertex v = vertices[it.next()];
				Edge e = findEdge(u.value, v.value);
				if(vertxQue.contains(v) && e.weight < v.key) {
					v.key = e.weight;
					v.parent = u;
				}
			}
		}
		return result;
	}

	private Edge findEdge(int u, int v) {
		return edgesMap.get(u*10 + v);
	}

	public static void main(String[] args) {
		Graph undirected = new Graph(7,10);
		undirected.addUndirectedEdge(0,1,2);
		undirected.addUndirectedEdge(0,2,4);
		undirected.addUndirectedEdge(1,4,6);
		undirected.addUndirectedEdge(1,3,3);
		undirected.addUndirectedEdge(2,4,7);
		undirected.addUndirectedEdge(2,5,7);
		undirected.addUndirectedEdge(3,4,9);
		undirected.addUndirectedEdge(3,6,11);
		undirected.addUndirectedEdge(5,4,8);
		undirected.addUndirectedEdge(5,6,1);

		Prim prim = new Prim();
		prim.primMST(undirected.adjacencyList, undirected.edges);
	}
}