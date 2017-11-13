class TOHRecirsion {
	public void stepsForTOH(int n, String beg, String aux, String end) {
		if(n == 0) {
			return;
		}
		if(n == 1) {
			System.out.println(beg + " --> " + end);
			return;
		}
		stepsForTOH(n-1, beg, end, aux);
		System.out.println(beg + " --> " + end);
		stepsForTOH(n-1, aux, beg, end);
	}

	public static void main(String[] args) {
		TOHRecirsion toh = new TOHRecirsion();
		toh.stepsForTOH(3, "A", "B", "C");
	}
}