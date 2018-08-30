import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    int testC = in.nextInt();
	int numSen;
	int totalCount, counter;
	double percentage;
    for (int a = 1; a <= testC; a ++) {
		numSen = in.nextInt();
		int [] senator = new int [numSen];
		totalCount = 0;
		int currHighest = 0;
		int secondHighest;
		double percentHighest = 0, percent = 0, secondPercent;
		for (int b = 0; b < numSen; b++) {
			senator [b] = in.nextInt();
			totalCount += senator[b];
		}
		String answer = "";
		while(totalCount > 0) {
			if (totalCount == 2) {
				for (int b = 0; b < numSen && totalCount > 0; b ++) {
					if (senator[b] > 0) {
						answer += ((char) (b + 65));
						totalCount --;
					}
				}
				break;
			}
			for (int b = 0; b < numSen; b ++) {
				percent = ((double)(senator[b]) / (totalCount));

				if (percent > percentHighest) {
					currHighest = b;
					percentHighest = percent;
				}
				
			}
			answer +=(char) (currHighest + 65);
			senator[currHighest] --;
			totalCount --;
			percentHighest = 0;
			currHighest = 0;
			secondHighest = 0;
			secondPercent = 0;
			if (totalCount > 2) {
				for (int b = 0; b < numSen; b ++) {
					percent = (senator[b] / (double) (totalCount));

					if (percent > percentHighest) {
						secondHighest = currHighest;
						currHighest = b;
						percentHighest = percent;
					} 
				}
				secondPercent = (double)(senator[secondHighest]) / (totalCount - 1);
				if (percentHighest >= 0.5 || (secondPercent <= 0.5)) {
					answer += (char) (currHighest + 65);
					senator[currHighest] --;
					totalCount --;
				}
				
			}
			answer += " ";
		}
		System.out.println ("Case #" + a + ": " + answer);
    }
    in.close();
  }
}