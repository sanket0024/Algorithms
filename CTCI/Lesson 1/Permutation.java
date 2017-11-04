/*
@author - Sanket Mathur
*/
import java.util.Set;
import java.util.HashSet;
class Permutation {
	static int count=0;
	static Set<String> sResultSet = new HashSet<String>();
	public static void main(String args[]) {
		permute("aabcdeaabcd", 0, "aabcdeaabcd".length());
		System.out.println("Count : " + sResultSet.size());
	}
	public static void permute(String str, int a, int b) {
		if(a==b) {
			count++;
			sResultSet.add(str);
			//System.out.println(str);
		}
		else {
			for(int i=a; i<b;i++) {
				str = swap(str, a, i);
				permute(str, a+1, b);
			}
		}
	}
	public static String swap(String str, int x, int y) {
		char[] tempArr = str.toCharArray();
		char temp = tempArr[x];
		tempArr[x] = tempArr[y];
		tempArr[y] = temp;
		return String.valueOf(tempArr);
	}
}