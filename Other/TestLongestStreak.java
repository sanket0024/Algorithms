import java.util.List;
import java.util.ArrayList;
class TestLongestStreak {
	public static void main(String[] args) {
		int[][] arr = {{12,11,10,9,8,7,3}, {180,178,182,175,174,177,173}};
		List<Integer> finalWeek = new ArrayList<Integer>();
		List<Integer> finalWeight = new ArrayList<Integer>();
		int longest = Integer.MIN_VALUE;
		int count = 1;
		for(int x = 0; x<arr.length; x++) {
			for(int i=0; i<arr[0].length; i++) {
				int k = i;
				List<Integer> week = new ArrayList<Integer>();
				List<Integer> weight = new ArrayList<Integer>();
				week.add(i+1);
				weight.add(arr[x][i]);
				for(int j = i+1; j<arr[0].length; j++) {
					if(arr[x][k] > arr[x][j]) {
						count++;
						k = j;
						weight.add(arr[x][j]);
						week.add(j+1);
					}
				}
				if(count > longest) {
					longest = count;
					finalWeight = new ArrayList<Integer>();
					finalWeek = new ArrayList<Integer>();
					for(int p=0; p<week.size(); p++) {
						finalWeight.add(weight.get(p));
						finalWeek.add(week.get(p));
					}
				}
				count = 1;
			}
		}
		System.out.println("*********Weight*********");
		for(int i=0; i<finalWeek.size(); i++) {
			//System.out.println(finalWeek.get(i));
			System.out.println(finalWeight.get(i));
		}
		System.out.println("*********Week*********");
		for(int i=0; i<finalWeek.size(); i++) {
			System.out.println(finalWeek.get(i));
			//System.out.println(finalWeight.get(i));
		}
	}
}