import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Strongly connected components are those which can be reached
 * 
 */

/**
 * @author sanketmathur
 *
 */
public class StronglyConnectedComponents {

	LinkedList<Integer>[] adjList;
	public List<List<Integer>> stronglyConnected(int V, LinkedList<Integer>[] adjList) {
		this.adjList = adjList;
		boolean[] visited = new boolean[V];
		List<List<Integer>> result = new ArrayList<>();
		for(int i=0; i<V; i++) {
			if(!visited[i]) {
				List<Integer> temp = new ArrayList<>();
				stronglyConnectedHelper(temp, i, visited, adjList);
				result.add(temp);
			}
		}
		return result;
	}
	
	private void stronglyConnectedHelper(List<Integer> temp, int s, boolean[] visited, LinkedList<Integer>[] adjList) {
		visited[s] = true;
		temp.add(s);
		Iterator<Integer> it = adjList[s].iterator();
		while(it.hasNext()) {
			int v = it.next();
			if(!visited[v]) {
				stronglyConnectedHelper(temp, v, visited, adjList);
			}
		}
	}
	
	private void printListofList(List<List<Integer>> ls) {
		for(int i=0; i<ls.size(); i++) {
			Iterator<Integer> it = ls.get(i).iterator();
			while(it.hasNext()) {
				System.out.print(it.next() + "  ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(8, 9);
		g.addUndirectedEdge(0, 1);
		g.addUndirectedEdge(0, 5);
		g.addUndirectedEdge(1, 2);
		g.addUndirectedEdge(2, 5);
		g.addUndirectedEdge(2, 4);
		g.addUndirectedEdge(2, 3);
		g.addUndirectedEdge(3, 4);
		g.addUndirectedEdge(4, 5);
		g.addUndirectedEdge(7, 6);
		
		StronglyConnectedComponents scc = new StronglyConnectedComponents();
		List<List<Integer>> result = scc.stronglyConnected(8, g.adjList);
		scc.printListofList(result);
	}
}
