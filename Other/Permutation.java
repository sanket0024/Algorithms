class Permutation {
	static int count;
	void permute(String s, int l) {
		if(l==s.length()-1) {
			System.out.println(s);
			count++;
		}
		else {
			for(int i=l; i<s.length(); i++) {
				if(!duplicate(s, l, i)) {
					s = swap(s, l, i);
					permute(s, l+1);
					// s = swap(s, l, i);
				}
			}
		}
	}
	String swap (String s, int i, int j) {
		char[] str = s.toCharArray();
		char temp;
		temp = str[i];
		str[i] = str[j];
		str[j] = temp;
		return String.valueOf(str);
	}

	boolean duplicate(String str, int s, int e) {
		for(int i=s; i<e; i++) {
			if(str.charAt(i) == str.charAt(e)) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] str) {
		String s = "AABC";
		int n = s.length();
		Permutation p = new Permutation();
		p.permute(s, 0);
		System.out.println(count);
	}
}