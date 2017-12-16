import java.util.LinkedList;
import java.util.ListIterator;
class BFSGraph {
	int numOfVertices;
	LinkedList<Integer>[] adj;
	BFSGraph (int v) {
		numOfVertices = v;
		adj = new LinkedList[v];
		/*for(LinkedList<Integer> ll: adj) {
			ll = new LinkedList<Integer>();
		}*/
		for (int i=0; i<numOfVertices; ++i)
            adj[i] = new LinkedList<Integer>();
	}
	void addEdge(int v1, int v2) {
		adj[v1].add(v2);
	}
	public void printGraphBFS(int s) {
		LinkedList<Integer> que = new LinkedList<Integer>();
		boolean[] visited = new boolean[numOfVertices];
		que.add(s);
		visited[s] = true;
		while(!que.isEmpty()) {
			s = que.poll();
			System.out.println(s);
			
			ListIterator<Integer> it = adj[s].listIterator();
			while(it.hasNext()) {
				int i = it.next();
				if(!visited[i]) {
					visited[i] = true;
					que.add(i);
				}
			}
		}
	}
	public static void main(String[] args) {
		BFSGraph g = new BFSGraph(4);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("BFS: Starting from 2");
        g.printGraphBFS(2);
	}
}