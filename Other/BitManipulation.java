class BitManipulation {
	public void twoComplement (int n) {
		System.out.println("Nothing");
	}

	/*
	* 1. Find the number of bits required to represent this number
	* number of bits = floor(log2(n)) + 1
	* 2. xor n with (2^number of bits) - 1 
	*/
	public int oneComplement (int n) {
		int numBits = (int)Math.floor(Math.log(n)/Math.log(2)) + 1;
		return n ^ ((1<<numBits) - 1);
	}
	public static void main(String[] args) {
		BitManipulation bm = new BitManipulation();
		//System.out.println(bm.oneComplement(2));
		/*System.out.println(~2);
		System.out.println(~3);
		System.out.println(~4);
		System.out.println(~5);
		System.out.println(~6);
		System.out.println(~7);
		System.out.println(~8);
		System.out.println(~9);
		System.out.println(~998);
		System.out.println(~999);
		System.out.println(~12);

		System.out.println(Integer.toBinaryString(~2));
		System.out.println(Integer.toBinaryString(~3));
		System.out.println(Integer.toBinaryString(~4));
		System.out.println(Integer.toBinaryString(~5));
		System.out.println(Integer.toBinaryString(~6));
		System.out.println(Integer.toBinaryString(~7));
		System.out.println(Integer.toBinaryString(~8));
		System.out.println(Integer.toBinaryString(~9));
		System.out.println(Integer.toBinaryString(~10));

		System.out.println(Integer.highestOneBit(2));
		System.out.println(Integer.highestOneBit(3));
		System.out.println(Integer.highestOneBit(4));
		System.out.println(Integer.highestOneBit(5));
		System.out.println(Integer.highestOneBit(6));
		System.out.println(Integer.highestOneBit(7));
		System.out.println(Integer.highestOneBit(8));
		System.out.println(Integer.highestOneBit(9));
		System.out.println(Integer.highestOneBit(10));*/

		System.out.println(Integer.bitCount(3));
	}
}