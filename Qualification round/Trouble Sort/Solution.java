import java.io.*;
public class Solution {
	public static void main (String [] args) throws IOException {
		
		// Using BufferedReader instead due to warning about non-buffered reader inputs
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(in.readLine());
		int size, temp, badIndex;
		int [] sequence;
		boolean changed, theEnd, finalChange;
		for (int a = 1; a <= testCases; a ++) {
			size = Integer.parseInt(in.readLine());
			sequence = new int [size];
			changed = false;
			theEnd = false;
			finalChange = false;
			badIndex = 0;
			System.out.print("Case #" + a + ": ");
			
			// Split the input based off of whitespace
			String []output = in.readLine().split("\\s");
			for (int b = 0; b < size; b++ ) {
				sequence [b] = Integer.parseInt(output[b]);
			}
			// Trouble sort the sequence until it can no longer be trouble sorted
			while (changed || !theEnd) {
				changed = false;
				for (int b = 0; b < size - 2; b ++) {
					if (sequence [b] > sequence [b + 2]) {
						changed = true;
						temp = sequence [b];
						sequence [b] = sequence [b + 2];
						sequence [b + 2] = temp;
					}
				}
				theEnd = true;
			}
			// Go through the instance and check that everything is sorted properly
			for (int b = 0; b < size - 1; b ++) {
				if (sequence[b] > sequence [b + 1]) {
					finalChange = true;
					badIndex = b;
					break;
				}
			}
			System.out.println(finalChange == true ? badIndex : "OK");
		}
		in.close();
	}
}
