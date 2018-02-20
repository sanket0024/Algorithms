class RomanNumber {
	int romanNum(String roman) {
		int current = 0;
		int previous = Integer.MAX_VALUE;
		int sum = 0;
		for(int i=0; i<roman.length; i++) {
			switch(roman.charAt(i)) {
				case 'I': 
					current = 1;
					break;
				case 'V': 
					current = 5;
					break;
				case 'X': 
					current = 10;
					break;
				case 'L': 
					current = 50;
					break;
				case 'M': 
					current = 1000;
					break;
				case 'C': 
					current = 100;
					break;
				case 'D': 
					current = 500;
					break;
			}
			if(previous < current) {
				sum = sum + current - (2*previous);
			}
			else {
				sum += current;
			}
			previous = current;
		}
	}
}