class Rotate90DegreeAnticlock {
	public static void main(String args[]) {
		int arr[][] = {{1,2,3,4,5}, {1,2,3,4,5}, {1,2,3,4,5}, {1,2,3,4,5}, {1,2,3,4,5}};
		System.out.println("Input");
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		int arr_new[][] = rotate(arr);
		System.out.println("\nOutput");
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr_new[i][j]);
			}
			System.out.println();
		}
	}
	public static int[][] rotate(int[][] arr) {
		int arr_new[][] = new int[5][5];
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr_new[arr[i].length-1-j][i] = arr[i][j];
			}
		}
		return arr_new;
	}
}