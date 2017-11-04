/*
@author - Sanket Mathur
*/
class ReplaceWith {
	public static void main(String args[]) {
		System.out.println(replaceWithPerTwenty("This is some string"));
	}
	public static String replaceWithPerTwenty(String str) {
		return str.replaceAll(" ", "%20");
	}
}