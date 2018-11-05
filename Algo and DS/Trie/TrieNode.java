import java.util.Map;
import java.util.HashMap;

class TrieNode {
	Map<Character, TrieNode> map;
	boolean isEnd;

	public TrieNode() {
		this.map = new HashMap<>();
		this.isEnd = false;
	}
}