import java.util.Arrays;
public class Answer_New {   
    public static String answer(int n) { 

        // Your code goes here.
        /*
        * 1. Generate the prime numbers and concat it into
        *    the string till the string length is equal to 
        *    10004 or greater
        *    // think of while lop
        * 2. Return str.substring(n, n+5);
        */
        boolean[] primeArr = new boolean[20234];
        Arrays.fill(primeArr, false);
        primeArr[2] = true;
        primeArr[3] = true;
        for(int i=3; i<primeArr.length; i += 2) {
            if(primeArr[i] == false) {
                boolean isNotPrime = false;
                for(int j=i-2; j>1; j -+ 2) {
                    if(i%j == 0) {
                        isNotPrime = true;
                        break;
                    }
                }
                if(!isNotPrime) {
                    primeArr[i] = true;
                }
            }
        }
        StringBuilder lambdaString = new StringBuilder();
        for(int i=2; i<primeArr.length; i++) {
            if(primeArr[i]) {
                lambdaString.append(String.valueOf(i));
            }
        }
        return lambdaString.substring(n, n+5);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(Answer_New.answer(9997));
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }
}