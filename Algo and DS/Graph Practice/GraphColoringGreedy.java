import java.util.*;

class GraphColoringGreedy {
	public int[] graphColoring(LinkedList adj[]) {
		int[] result = new int[adj.length];
		Arrays.fill(result, -1);
		Boolean[] colors = new Boolean[adj.length];
		Arrays.fill(colors, true);
		result[0] = 0;
		for(int i=1; i<adj.length; i++) {
			Iterator<Integer> it = adj[i].iterator();
			while(it.hasNext()) {
				int temp = it.next();
				if(result[temp] != -1) {
					colors[result[temp]] = false;
				}
			}
			int c = 0;
			while(!colors[c]) {
				c++;
			}
			Arrays.fill(colors, true);
			result[i] = c;
		}
		return result;
	}

	public static void main(String[] args) {
		Graph undirected = new Graph(7,10);
		undirected.addUndirectedEdge(0,1,0);
		undirected.addUndirectedEdge(0,2,0);
		undirected.addUndirectedEdge(1,4,0);
		undirected.addUndirectedEdge(1,3,0);
		undirected.addUndirectedEdge(2,4,0);
		undirected.addUndirectedEdge(2,5,0);
		undirected.addUndirectedEdge(3,4,0);
		undirected.addUndirectedEdge(3,6,0);
		undirected.addUndirectedEdge(5,4,0);
		undirected.addUndirectedEdge(5,6,0);
		GraphColoringGreedy gc = new GraphColoringGreedy();
		int[] result = gc.graphColoring(undirected.adjacencyList);
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i] + "  ");
		}
		System.out.println();
	}
}