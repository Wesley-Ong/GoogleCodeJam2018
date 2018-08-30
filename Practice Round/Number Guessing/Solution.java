import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    int testC = in.nextInt();
    int low, high, numGuess, counter, guess;
    for (int a = 1; a <= testC; a ++) {
        low = in.nextInt();
		low ++;
        high = in.nextInt();
        numGuess = in.nextInt();
        for (int i = 0; i < numGuess; i ++) {
            guess = (high + low)/2;
            System.out.println(guess + "");
            String response = in.next();
            if (response.indexOf("TOO_SMALL") > - 1) {
                low = guess + 1;
            } 
            else if (response.indexOf("TOO_BIG") > -1){
                high = guess - 1;
            }
            else {
                break;
            }
        }
    }
    in.close();
  }
}