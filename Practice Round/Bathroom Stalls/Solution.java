import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    int testC = in.nextInt();
	int stalls, people;
	double lowerBound, upperBound, counter;
	int max, min, previousGroup, originalPeople, addMod;
	int takenStalls, remainingStalls, modCounter, splitter;
    for (int a = 1; a <= testC; a ++) {
		stalls = in.nextInt();
		originalPeople = in.nextInt();
		people = originalPeople;
		counter = 0;
		max = 0;
		min = 0;
		remainingStalls = 0;
		takenStalls = 0;
		while (people > 0) {
				
			counter ++;
			people = people >> 1;
			if (people > 0) {
				takenStalls += (int) Math.floor((Math.pow(2, counter - 1)));

			}
		}
		remainingStalls = stalls - takenStalls;
		splitter = (int) (Math.pow(2, counter - 1));
		previousGroup = remainingStalls/ splitter;
		modCounter = remainingStalls % splitter;
		addMod = originalPeople - (int)(Math.pow(2, counter - 1)) + 1;
		if (addMod <= modCounter) {
			previousGroup++;
		}
		max = previousGroup / 2;
		min = previousGroup /2;
		if (previousGroup % 2 == 0) {
			min --; 
		}
		System.out.println ("Case #" + a + ": " + max + " " + min);
    }
    in.close();
  }
}