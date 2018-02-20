import java.util.Scanner;
public class Answer {   
    public static String answer(int n) { 

        // Your code goes here.
        /*
        * 1. Generate the prime numbers and concat it into
        *    the string till the string length is equal to 
        *    10004 or greater
        *    // think of while lop
        * 2. Return str.substring(n, n+5);
        */
        StringBuilder lambdaString = new StringBuilder("23");
        int i=5;
        int count=0;
        // generate prime number and append it to the
        // lambdaString till the length of the 
        // string is less than or equal to 10004
        while(lambdaString.length() <= 10004) {
            boolean isPrime = true;
            for(int j=i-2; j>2; j-=2) {
                if(i%j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                count++;
                lambdaString.append(String.valueOf(i));
            }
            i += 2;
        }
        System.out.println("Last prime: " + count);
        return lambdaString.substring(n, n+5);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("JAVA: Enter value of n: ");
        int n = scan.nextInt();
        long startTime = System.currentTimeMillis();
        System.out.println(Answer.answer(n));
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Approx run time: " + totalTime);
    }
}