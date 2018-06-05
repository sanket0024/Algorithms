/**
 * Vertex of graph
 */

/**
 * @author sanketmathur
 *
 */
public class Vertex {

	public int key;
	public Vertex parent;
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
		parent = null;
		key = 0;
	}
}
