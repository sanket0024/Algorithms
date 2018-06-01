import java.util.HashMap;
import java.util.Map;

/**
 * Disjoint set using union by rand and path compression techniques
 * Supports 3 operations:
 * 1. makeset
 * 2. union
 * 3. findset
 * 
 * Time complexity: O(m * f(n))
 * Space complexity: O(n)
 * 
 * In time complexity m is the number of operations.
 * f(n) is very slowing growing function. For most cases f(n) <= 4
 * so effectively total time will be O(m)
 * 
 */

/**
 * @author sanketmathur
 *
 */
public class DisjointSet {

	Map<Integer, SetNode> map = new HashMap<>();
	
	/**
	 * creates set
	 * @param val
	 */
	public void makeset(int val) {
		SetNode sn = new SetNode();
		sn.value = val;
		sn.parent = sn;
		sn.rank = 0;
		map.put(val, sn);
	}
	
	/**
	 * find the representative node
	 * @param s
	 * @return
	 */
	public int findset(int s) {
		return getParent(map.get(s)).value;
	}
	
	/**
	 * return a setnode and perform path compression while searching
	 * @param s
	 * @return
	 */
	private SetNode getParent(SetNode s) {
		if(s.parent == s) {
			return s;
		}
		s.parent = getParent(s.parent);
		return s.parent;
	}
	
	/**
	 * 
	 * @param s1
	 * @param s2
	 */
	public void union(int s1, int s2) {
		int a = findset(s1);
		int b = findset(s2);
		if(a != b) {
			SetNode na = map.get(a);
			SetNode nb = map.get(b);
			if(na.rank >= nb.rank) {
				na.rank = (na.rank == nb.rank) ? na.rank+1 : na.rank;
				nb.parent = na;
			}
			else {
				na.parent = nb;
			}
		}
	}
}
