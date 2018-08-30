import java.util.*;
public class Solution {
	
	public static void main (String [] args) {
		Scanner in = new Scanner (System.in);
		int testCases = in.nextInt();
		int leftGoph, upGoph;
		boolean [][] matrix;
		int temp;
		int distanceX, distanceY, counterX, cap, oldValueX, oldValueY;
		for (int a = 1; a <= testCases; a ++) {
			
			// Rectangle must have a height of 3 or else it will not be considered as ready
			// Since there could be trees that disturb the rectangle shape
			int area = in.nextInt();
			cap = (int) (Math.ceil((double) (area) / 3));
			matrix = new boolean [cap + 4][3];
	
			counterX = 1;
			oldValueX = 480;
			oldValueY = 480;
temp = 0;
			// Use this as the starting point
			System.out.println(oldValueX + " " + oldValueY);
			
			while (true) {
				
				// Gopher position
				leftGoph = in.nextInt();
				upGoph = in.nextInt();
				
				// Distance away from the starting point
				distanceX = leftGoph - oldValueX;
				distanceY = upGoph - oldValueY + 1;


				if (leftGoph == 0 && upGoph == 0 ) {
					break;
				} else if (leftGoph == -1 && upGoph == -1) {
					System.exit(0);
				} else if (matrix[counterX - 1][0] && matrix[counterX - 1][1] && matrix[counterX - 1][2]
						&& matrix[counterX ][0] && matrix[counterX ][1] && matrix[counterX ][2]
						&& matrix[counterX + 1][0] && matrix[counterX + 1][1] && matrix[counterX + 1][2]) {
					// Check that the rectangle is prepared (3 x 3 from the start) and then move right

					
					oldValueX ++;
					counterX ++;
				} else {
					matrix[counterX + distanceX][distanceY] = true;
				}
				System.out.println(oldValueX + " " + oldValueY);
			}
		}
		in.close();
	}
}
