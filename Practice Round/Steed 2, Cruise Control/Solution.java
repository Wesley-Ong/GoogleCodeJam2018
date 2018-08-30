import java.util.*;
import java.io.*;
import java.text.*;
import java.math.RoundingMode;

public class Solution {
	public static void main (String [] args) {
		Scanner in = new Scanner (System.in);
		
		int testC = in.nextInt();
		int currStart, currSpeed, slowStart, slowSpeed, destination, numHorses;
		double hours = 0, currHours = 0;
		
		DecimalFormat formatter = new DecimalFormat("#.000000");
		formatter.setRoundingMode(RoundingMode.HALF_EVEN);
		for (int a = 1; a <= testC; ++a) {
			destination = in.nextInt();
			numHorses = in.nextInt();
			hours = 0;
			for (int b = 1; b <= numHorses; b ++) {
				currStart = in.nextInt();
				currSpeed = in.nextInt();
				currHours = ((double)(destination - currStart)) / currSpeed;
				if (currHours > hours) {
					hours = currHours;
				}
			}
			double answer = ((double) (destination))/hours;
			System.out.println ("Case #" + a + ": " + formatter.format(answer));
		}
	}
}