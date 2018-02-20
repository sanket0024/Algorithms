class SieveOfEratosthenes {
	void sieveOfErathosthenes(int n) {
		boolean[] prime = new boolean[n];
		for (int i=0; i<prime.length; i++) {
			prime[i] = true;
		}
		for(int i=2; i*i<n; i++) {
			if (prime[i] == true) {
				for(int j=i*2; j<n; j+=i) {
					prime[j] = false;
				}
			}
		}
		printAllPrimes(prime, n);
	}
	void printAllPrimes(boolean[] prime, int n) {
		for(int i=2; i<n; i++) {
			if(prime[i]) {
				System.out.println(i + " ");
			}
		}
	}
	public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new SieveOfEratosthenes().sieveOfErathosthenes(50);
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Approx run time: " + totalTime);
    }
}