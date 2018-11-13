import java.util.*;

/**
 * Articulation Point
 * @author sanketmathur
 *
 *
 * Articulation point means removing a node will disconnect the
 * graph into more disjoint graph
 * 
 * Time complexity: O(V+E)
 * Space Complexity: O(V)
 * 
 * Basically we are doing DFS.
 * There are 2 conditions which determine the articulation point:
 * 1. If current node has no parent and it has 2 or more children
 * 2. If the visitedtime of the current node is less than or equals to the
 * 	  lowtime time of adjacent node 
 */
class ArticulationPoint {
	public void articulationPoint(Graph g) {
		int[] visitedTime = new int[g.adjList.length];
		int[] lowTime = new int[g.adjList.length];
		int[] parent = new int[g.adjList.length];
		Set<Integer> visited = new HashSet<>();
		int time = -1;
		Set<Integer> res = new HashSet<>();

		parent[0] = -1;
		for(int i=0; i<g.adjList.length; i++) {
			articulationPoint(g.adjList, visitedTime, lowTime, visited, time, parent, i, res);
		}

		System.out.println("Articulation Points: ");
		print(res);
	}

	public void articulationPoint(LinkedList<Integer>[] adjList,
									int[] visitedTime,
									int[] lowTime,
									Set<Integer> visited,
									int time,
									int[] parent,
									int current,
									Set<Integer> res) {
		int children=0;
		visited.add(current);
		lowTime[current] = ++time;
		visitedTime[current] = time;
		List<Integer> neighbors = adjList[current];
		Iterator<Integer> it = neighbors.iterator();
		while(it.hasNext()) {
			int v = it.next();
			if(!visited.contains(v)) {
				parent[v] = current;
				children++;
				articulationPoint(adjList, visitedTime, lowTime, visited, time, parent, v, res);
				lowTime[current] = Math.min(lowTime[current], lowTime[v]);

				// two conditions of articulation point
				if(parent[current] == -1 && children > 1) {
					res.add(current);
				}
				if(parent[current] != -1 && visitedTime[current] <= lowTime[v]) {
					res.add(current);
				}
			}
			else if(v != parent[current]) {
				lowTime[current] = Math.min(lowTime[current], visitedTime[v]);
			}
		}
	}

	private void print(Set<Integer> ls) {
		Iterator<Integer> it = ls.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + "  ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Graph g = new Graph(5, 5);
		g.addUndirectedEdge(1, 0);
		g.addUndirectedEdge(0, 2);
		g.addUndirectedEdge(2, 1);
		g.addUndirectedEdge(0, 3);
		g.addUndirectedEdge(3, 4);

		Graph g2 = new Graph(4, 3); 
		g2.addUndirectedEdge(0, 1); 
		g2.addUndirectedEdge(1, 2); 
		g2.addUndirectedEdge(2, 3);

		Graph g3 = new Graph(7,8); 
		g3.addUndirectedEdge(0, 1); 
		g3.addUndirectedEdge(1, 2); 
		g3.addUndirectedEdge(2, 0); 
		g3.addUndirectedEdge(1, 3); 
		g3.addUndirectedEdge(1, 4); 
		g3.addUndirectedEdge(1, 6); 
		g3.addUndirectedEdge(3, 5); 
		g3.addUndirectedEdge(4, 5);

		ArticulationPoint ap = new ArticulationPoint();
		ap.articulationPoint(g);
		ap.articulationPoint(g2);
		ap.articulationPoint(g3);
	}
}