import java.util.*;
import java.io.*;
public class Solution {
	public static void main (String [] args) {
		Scanner in = new Scanner (System.in);
		int testCases = in.nextInt();
		int shieldStrength, currDamage, sumDamage, count, sCount, numSwitch;
		Deque <Integer> keyList = new ArrayDeque <Integer>();
		boolean sawS;
		String sequence;
		for (int a = 1; a <= testCases; a++) {
			Map<Integer, Integer> sWeight = new HashMap <Integer, Integer>();
			currDamage = 1;
			sumDamage = 0;
			shieldStrength = in.nextInt();
			sequence = in.next();
			count = 0;
			sCount = 0;
			sawS = false;
			keyList.clear();
			System.out.print("Case #" + a + ": ");
			numSwitch = 0;

			for (int x = 0; x < sequence.length(); x ++) {
				if (sequence.charAt(x) == 'C') {
					currDamage = currDamage << 1;
					count = 1;
				} else {
					if (!keyList.contains(currDamage)) {
						keyList.push(currDamage);
					}
					sumDamage += currDamage;
					sWeight.put(currDamage, count++);
					sCount++;
					if (!sawS) {
						sawS = !sawS;
					}
				}
			}

			// Check if there are any S's or if the shield strength is already strong enough
			if (!sawS || shieldStrength >= sumDamage) {
				System.out.println ("0");
				continue;
			} 
			// Check if either too many S's for the shield strength or if there any C's available to swap with
			else if (sCount > shieldStrength) {
				System.out.println("IMPOSSIBLE");
				continue;
			} 
			else {
				//Reduce strongest shots by 1/2 until sumDamage <= shieldStrength
				while (!keyList.isEmpty() && sumDamage > shieldStrength) {
					int currValue = keyList.pop();
					while (sumDamage > shieldStrength && sWeight.get(currValue) > 0) {
						int subtractionCost = currValue == 1 ? 1 : currValue >> 1;  
						for (int x = 0 ; x < sWeight.get(currValue) && sumDamage > shieldStrength; x ++) {
							sumDamage -= subtractionCost;
							numSwitch ++;
						}
						if (currValue > 1 && sumDamage > shieldStrength) {
							if (sWeight.containsKey(currValue >> 1)) {
								int previousCount = sWeight.get(currValue >> 1);
								sWeight.put((currValue >> 1), previousCount + sWeight.get(currValue));
							} 
							else {
								sWeight.put((currValue >> 1), sWeight.get(currValue));
								keyList.push(currValue >> 1);
							}
							break;
						}
					}
				}
				System.out.println(numSwitch);
			}
		}
	}
}