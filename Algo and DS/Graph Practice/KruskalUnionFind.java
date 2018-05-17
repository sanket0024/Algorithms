import java.util.*;
class KruskalUnionFind {
	public List<Edge> kruskal(Edge[] edges, LinkedList adj[]) {
		List<Edge> result = new ArrayList<>();
		Arrays.sort(edges, new Comparator<Edge>() {
			public int compare(Edge e1, Edge e2) {
				if(e1.weight < e2.weight) {
					return 1;
				}
				else {
					return -1;
				}
			}
		});
		
		for(int i=0; i<edges.length; i++) {
			if()
		}
		return result;
	}
}