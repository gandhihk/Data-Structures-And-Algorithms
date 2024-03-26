package ds.string;

public class SearchWordIn2DMatrix {
	
	/*
	 * Given a 2D grid of characters and a single word/an array of words, find all occurrences of the given word in the grid. 
	 * Word is said to be found in a dir if all chars match in this direction (not in zig-zag form).
	 * 
	 * Solution: 
	 * Run 2 loops and traverse each cell of grid and compare with 1st char of word
	 * If this cell matches with 1st char, then check if other chars can be traced from this cell
	 * 1. Run a loop for all 8 directions. For each direction, get updated row, col
	 * 2. For this direction, run a loop for each char k of word.
	 *    If this char matches in this direction, then get updated row/col for this direction and check for next char match
	 *    If this char doesn't match in this direction, then break and go for next direction
	 * 3. If for any direction, k reaches end of the word, then we have matched the whole word in that direction
	 */

	public static void main(String[] args) {
		char[][] grid = { { 'G', 'E', 'E', 'K', 'S', 'F', 'O', 'R', 'G', 'E', 'E', 'K', 'S' },
                { 'G', 'E', 'E', 'K', 'S', 'Q', 'U', 'I', 'Z', 'G', 'E', 'E', 'K' },
                { 'I', 'D', 'E', 'Q', 'A', 'P', 'R', 'A', 'C', 'T', 'I', 'C', 'E' } };
		
		String word = "GEEKS";
		patternSearch(grid, word);
	}

	static void patternSearch(char[][] grid, String word) {
		
		for(int row=0; row<grid.length; row++) {
			for(int col=0; col<grid[0].length; col++) {
				if(word.charAt(0)==grid[row][col]		//check each cell for start of word
						&& search2DMatrix(grid, row, col, word))		//check if other chars can be traced
					System.out.println("Word found at "+row+","+col);
			}
		}
	}
	
	static boolean search2DMatrix(char[][] grid, int row, int col, String word) {
		int len = word.length();
		
		// For searching in all 8 direction
	    int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
	    int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };
	    int R = grid.length;
		int C = grid[0].length;
		
		for(int dir=0; dir<8; dir++) {			//loop for 8 directions
			int k;
			int rd = row+x[dir], cd = col+y[dir];		//get udpated row/col for this direction
			
			for(k=1; k<len; k++) {				//loop for all other chars of word
				if(rd>=R || rd<0 || cd>=C || cd<0)		//check for out of bounds
					break;
				
				if(word.charAt(k)!=grid[rd][cd])		//check if char doesn't match cell in this direction
					break;
				
				//move further in this direction since this char is matching
				rd = rd + x[dir];
				cd = cd + y[dir];
			}
			
			if(k==len)						//if reached at end of word
				return true;
		}
		return false;
	}
}
