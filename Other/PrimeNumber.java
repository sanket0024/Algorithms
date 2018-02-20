class PrimeNumber {
	public boolean isPrime(int n) {
		if(n == 0 || n == 1) {
			return false;
		}
		if(n==2) {
			return true;
		}
		if(n%2 == 0) {
			return false;
		}
		for(int i=3; i*i<=n; i+=2) {
			if(n%i==0){
				return false;
			}
		}
		return true;
	}

	public int countPrimeSetBits(int L, int R) {
        int res = 0;
        for(int i=L; i<=R; i++) {
            int count = 0;
            String s = Integer.toString(i, 2);
            System.out.println(s);
            for(int j=0; j<s.length(); j++) {
                if(s.charAt(j) == '1') {
                    count++;
                }
            }
            if(isPrime(count)) {
                res++;
            }
        }
        return res;
    }

	public static void main(String[] args) {
		PrimeNumber p = new PrimeNumber();
		System.out.println(p.countPrimeSetBits(10, 15));
		/*assert p.isPrime(2) == true;
		assert p.isPrime(3) == true;
		assert p.isPrime(5) == true;
		assert p.isPrime(7) == true;
		assert p.isPrime(11) == true;
		assert p.isPrime(13) == true;
		assert p.isPrime(17) == true;
		assert p.isPrime(19) == true;
		assert p.isPrime(23) == true;
		assert p.isPrime(29) == true;
		assert p.isPrime(31) == true;
		assert p.isPrime(37) == true;
		assert p.isPrime(41) == true;
		assert p.isPrime(43) == true;
		assert p.isPrime(47) == true;
		assert p.isPrime(53) == true;
		assert p.isPrime(59) == true;
		assert p.isPrime(61) == true;
		assert p.isPrime(67) == true;
		assert p.isPrime(71) == true;
		assert p.isPrime(73) == true;
		assert p.isPrime(79) == true;
		assert p.isPrime(83) == true;
		assert p.isPrime(89) == true;
		assert p.isPrime(97) == true;
		assert p.isPrime(101) == true;
		assert p.isPrime(103) == true;
		assert p.isPrime(107) == true;
		assert p.isPrime(109) == true;
		assert p.isPrime(113) == true;
		assert p.isPrime(127) == true;
		assert p.isPrime(131) == true;
		assert p.isPrime(137) == true;
		assert p.isPrime(139) == true;
		assert p.isPrime(149) == true;
		assert p.isPrime(151) == true;
		assert p.isPrime(157) == true;
		assert p.isPrime(163) == true;
		assert p.isPrime(167) == true;
		assert p.isPrime(173) == true;
		assert p.isPrime(179) == true;
		assert p.isPrime(181) == true;
		assert p.isPrime(191) == true;
		assert p.isPrime(193) == true;
		assert p.isPrime(197) == true;
		assert p.isPrime(199) == true;*/
	}
}