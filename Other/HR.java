class HR {
	public int some(int[] input) {
		int[] arr = new int[101];
		for(int i=0; i<input.length; i++) {
			arr[input[i]]++;
		}
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == 1) {
				return i;
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		int[] input = {1,1,3,2,2,3,4,4,5,5,7,7,34,34,21,21,44,44,100};
		HR h = new HR();
		System.out.println(h.some(input));
	}
}