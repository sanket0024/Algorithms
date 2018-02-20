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
        Arrays.fill(primeArr, true);
        //primeArr[0] = false;
        //primeArr[1] = false;
        int x = 4;
        while(x < primeArr.length) {
            primeArr[x] = false;
            x += 2;
        }
        for(int i=3; i<primeArr.length; i++) {
            if(primeArr[i] == true) {
                for(int j=i-1; j>1; j--) {
                    if(i%j == 0) {
                        int k=0;
                        int mul = 0;
                        while(mul < 20234) {
                            primeArr[mul] = false;
                            k++;
                            mul = k*i;
                        }
                        break;
                    }
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
        System.out.println(Answer_New.answer(944));
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Approx run time: "+totalTime);
    }
}