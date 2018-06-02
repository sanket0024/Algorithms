/**
 * Vertex of graph
 */

/**
 * @author sanketmathur
 *
 */
public class Vertex {

	public int key;
	public int val;
	
	/**
	 * default constructor
	 */
	public Vertex() {
		
	}
	
	/**
	 * Parameterized constructor
	 * @param val
	 */
	public Vertex(int val) {
		this.val = val;
		key = 0;
	}
}
