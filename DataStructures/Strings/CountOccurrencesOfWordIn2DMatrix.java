package ds.string;

public class CountOccurrencesOfWordIn2DMatrix {
	
	/*
	 * Given a 2-Dimensional character array and a string, we need to find the given string in 2-dimensional character array,
	 * such that individual characters can be present left to right, right to left, top to down or down to top.
	 * 
	 * Solution:
	 * Traverse through each character of the matrix and taking each character as a start of the string to be found. 
	 * Try to search in all the possible directions. 
	 * Whenever, a word is found, increase the count.
	 */

	public static void main(String[] args) {
		char[][] grid = { { 'G', 'E', 'E', 'K', 'S', 'F', 'O', 'R', 'G', 'E', 'E', 'K', 'S' },
                { 'G', 'E', 'E', 'K', 'S', 'Q', 'U', 'I', 'Z', 'G', 'E', 'E', 'K' },
                { 'I', 'D', 'E', 'Q', 'A', 'P', 'R', 'A', 'C', 'T', 'I', 'C', 'E' } };
		
		String word = "GEEKS";
		int ans=0, len = word.length();
		for(int i=0; i<grid.length; i++)
			for(int j=0; j<grid[0].length; j++)
				ans+= searchString(i, j, word, grid, len, 0);
		System.out.println(ans);
	}

	static int searchString(int row, int col, String word, char[][] grid, int len, int idx) {
		int found = 0;			//set found as 0 initially
		
		if(row>=0 && row<grid.length && col>=0 && col<grid[0].length		//check out of bounds
				&& word.charAt(idx)==grid[row][col]) {			//check if idx char matches with this cell
			char curr = word.charAt(idx);						//save current cell char temp
			grid[row][col] = 0;									//mark it as visited to avoid loops
			idx++;												//move to next char of word
			
			if(idx==len)										//set found=1 if already reached end of word
				found=1;
			else {												//else get occurrences in all 4 directions
				found += searchString(row+1, col, word, grid, len, idx);
				found += searchString(row-1, col, word, grid, len, idx);
				found += searchString(row, col+1, word, grid, len, idx);
				found += searchString(row, col-1, word, grid, len, idx);
			}
			grid[row][col] = curr;								//reset the current cell's char back, this will revert all marked cells in backtrack
		}
		return found;						
	}
}
