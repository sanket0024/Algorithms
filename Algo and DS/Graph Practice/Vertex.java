// used in prim
class Vertex {
	public int value;
	public int key;
	public Vertex parent;

	public Vertex(int value, int key, Vertex parent) {
		this.value = value;
		this.key = key;
		this.parent = parent;
	}
}