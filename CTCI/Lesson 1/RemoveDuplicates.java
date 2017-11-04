/*
@author - Sanket Mathur
*/
class RemoveDuplicates {
	public static void main(String args[]) {
		System.out.println(makeUnique("ababababaf"));
	}
	public static String makeUnique(String str) {
		int count = 0;
		for(int i=0; i < str.length(); i++) {
			int match = str.indexOf(str.charAt(i), i+1);
			if(match != -1) {
				count++;
				str = str.substring(0, i) + str.substring(i+1, str.length());
				i--;
			}
		}
		return str;
	}
}