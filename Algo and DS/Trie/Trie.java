import java.util.Map;
import java.util.HashMap;

class Trie {
	TrieNode root = new TrieNode();
	public void insert(String s) {
		TrieNode temp = root;
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(temp.map.get(ch) == null) {
				temp.map.put(ch, new TrieNode());
			}
			temp = temp.map.get(ch);
		}
		temp.isEnd = true;
	}

	public boolean search(String s) {
		TrieNode temp = root;
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(temp.map.get(ch) == null) {
				return false;
			}
			temp = temp.map.get(ch);
		}
		return temp.isEnd;
	}

	public void delete(String s) {
		TrieNode temp = root;
		delete(s, 0, temp);
	}

	private boolean delete(String s, int index, TrieNode temp) {
		if(temp == null) {
			return false;
		}
		if(s.length() == index) {
			if(!temp.isEnd) {
				return false;
			}
			temp.isEnd = false;
			return temp.map.size() == 0;
		}
		char ch = s.charAt(index);
		boolean deleteNode = delete(s, index+1, temp.map.get(ch));
		if(deleteNode) {
			temp.map.remove(ch);
			return temp.map.size() == 0;
		}
		return false;
	}

	public static void main(String[] args) {
		Trie t = new Trie();
		t.insert("abcd");
		t.insert("abde");
		t.insert("axyz");
		t.insert("abcdef");
		t.insert("xyz");

		System.out.println("Before Delete");
		System.out.println(t.search("abc"));
		System.out.println(t.search("abcde"));
		System.out.println(t.search("abde"));
		System.out.println(t.search("axyz"));
		System.out.println(t.search("axyza"));

		t.delete("abcd");
		t.delete("axyz");
		
		System.out.println("\nBefore Delete");
		System.out.println(t.search("abc"));
		System.out.println(t.search("abcde"));
		System.out.println(t.search("abde"));
		System.out.println(t.search("axyz"));
		System.out.println(t.search("axyza"));
	}
}