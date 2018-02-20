class Permutation1 {
	static int count;
	void permute(String s, int a) {
		if(a == s.length()-1) {
			System.out.println(s);
			count++;
		}
		else {
			for(int i=a; i<s.length(); i++) {
				if(!duplicate(s, a, i)) {
					s = swap(s, a, i);
					permute(s, a+1);
				}
			}
		}
	}
	String swap(String s, int i, int j) {
		char[] str = s.toCharArray();
		char temp;
		temp = str[i];
		str[i] = str[j];
		str[j] = temp;
		return String.valueOf(str);
	}
	boolean duplicate(String str, int start, int end) {
		for(int i=start; i<end; i++) {
			if(str.charAt(i) == str.charAt(end)) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] str) {
		String s = "AABC";
		int n = s.length();
		Permutation1 p = new Permutation1();
		p.permute(s, 0);
		System.out.println(count);
	}
}