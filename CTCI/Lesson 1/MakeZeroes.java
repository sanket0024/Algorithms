/*
@author - Sanket Mathur
*/

import java.util.Set;
import java.util.HashSet;
class MakeZeroes {
	public static void main(String[] args) {
		int[][] arr = {{1,2,3}, {4,0,0}, {6,7,2}};
		makeZeroMatrix(arr);
	}
	public static void makeZeroMatrix(int[][] arr) {
		Set<Integer> zeroRows = new HashSet<Integer>();
		Set<Integer> zeroColumns = new HashSet<Integer>();
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(arr[i][j] == 0) {
					zeroRows.add(i);
					zeroColumns.add(j);
				}
			}
		}
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length;j++) {
				if(zeroRows.contains(i) || zeroColumns.contains(j)) {
					arr[i][j] = 0;
				}
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}