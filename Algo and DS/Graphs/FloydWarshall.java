/**
 * All pair shortest path algorithm
 * Floyd-Warshall
 * 
 * Work for negarive cycles
 * 
 * Time complexity: O(V^3)
 * Space complexity: O(V^2)
 */

/**
 * @author sanketmathur
 *
 */
public class FloydWarshall {

	public void floydWarshall(Graph g) {
		int[][] matrix = g.matrix;
		int[][] parent = new int[g.V][g.V];
		for(int i=0; i<g.V; i++) {
			for(int j=0; j<g.V; j++) {
				if(matrix[i][j] == 0) {
					matrix[i][j] = 99999;
				}
				if(i==j) {
					parent[i][j] = -1;
					matrix[i][j] = 0;
				}
				if(!(matrix[i][j] == 0 || matrix[i][j] == 99999)) {
					parent[i][j] = i;
				}
			}
		}
		for(int k=0; k<g.V; k++) {
			for(int i=0; i<g.V; i++) {
				for(int j=0; j<g.V; j++) {
					if(matrix[i][j] > matrix[i][k]+matrix[k][j]) {
						matrix[i][j] = matrix[i][k]+matrix[k][j];
						parent[i][j] = k;
					}
				}
			}
		}
		System.out.println("Diatance matrix");
		printMatrix(matrix);
		System.out.println("\nParent matrix");
		printMatrix(parent);
	}
	
	public void printMatrix(int[][] m) {
		for(int i=0; i<m.length; i++) {
			for(int j=0; j<m.length; j++) {
				if(m[i][j] != 99999) {
					System.out.print(m[i][j] + "  ");
				}
				else {
					System.out.print("INF  ");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(5, 9);
		g.addDirectedEdge(0, 1, 3);
		g.addDirectedEdge(0, 2, 8);
		g.addDirectedEdge(0, 4, -4);
		g.addDirectedEdge(1, 3, 1);
		g.addDirectedEdge(1, 4, 7);
		g.addDirectedEdge(2, 1, 4);
		g.addDirectedEdge(3, 0, 2);
		g.addDirectedEdge(3, 2, -5);
		g.addDirectedEdge(4, 3, 9);
		FloydWarshall fw = new FloydWarshall();
		fw.floydWarshall(g);
	}
}
