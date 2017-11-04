class ValidTriangle {
	public static void main(String args[]) {
		System.out.println(isValidTriangle(10,1,11));
	}
	public static Boolean isValidTriangle(int a, int b, int c) {
		if((a > 0) && (b > 0) && (c > 0)) {
			if((a+b > c) && (a+c > b) && (b+c > a))
				return true;
			else
				return false;
		}
		else
			return false;
	}
}