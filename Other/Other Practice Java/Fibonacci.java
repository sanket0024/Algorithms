// Exponential complexity
class Fibonacci {
	public int fibo(int n) {
		//================================================
		//Iterative
		/*int a=1, b=1;
		//put conditions here if required
		System.out.print(a + " " + b + " ");
		for(int i=0; i<n-2; i++) {
			int temp = a+b;
			a=b;
			b=temp;
			System.out.print(temp + " ");
		}*/

		//================================================
		//Recursive
		/*if(n<=2) {
			return 1;
		}
		else {
			return fibo(n-1) + fibo(n-2);
		}*/
		return 0;
	}
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		System.out.println(f.fibo(5));
	}
}