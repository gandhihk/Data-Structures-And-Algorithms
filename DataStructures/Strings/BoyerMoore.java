package ds.string;

public class BoyerMoore {

	public static void main(String[] args) {
		String txt = "ABAAABCD";
        String pat = "ABCD";
        search(txt, pat);
	}

	static void search(String text, String pat) {
		int n = text.length();
		int m = pat.length();
		int[] badMatch = new int[256];
		
		//fill the badmatch array i.e. preprocessing
		fillBadMatchArray(badMatch, pat);
		
		int shift = 0;		//initially shift is 0
		
		//there can be n-m+1 shifts i.e. potential alignments of pat w.r.t. text. loop through all of them
		while(shift <= (n-m)) {
			int j = m-1;
			 
	          /* Keep reducing index j of pattern while chars of pattern and text are
	             matching at this shift s */
	          while(j >= 0 && pat.charAt(j) == text.charAt(shift+j))
	              j--;
	          
	          if(j<0) {				//if the pat is present at current shift, then j will become -1
	        	  System.out.println("Pattern found at index "+(shift+j+1));
	        	  if(shift+m < n)
	        		  shift += m;
	        	  else shift += 1;
	          }else {
	        	  if(badMatch[(int)text.charAt(shift+j)] == -1) {		//if char not present in pattern
	        		  if(shift+m < n)	
		        		  shift += m;						//then move it completely
	        		  else shift += 1;
	        	  }else {
	        		  shift += badMatch[(int)text.charAt(shift+j)];		//shift it to only specific char
	        	  }
	          }
		}
	}
	
	static void fillBadMatchArray(int[] badMatch, String pat) {
		for(int i=0; i<256; i++)				//initialize all char values as -1
			badMatch[i] = -1; 
		
		int m = pat.length();
		// Fill the actual value of last occurrence of a char 
		//(indices of table are ascii and values are shift value)
		for(int i=0; i<pat.length(); i++) {
			badMatch[(int)pat.charAt(i)] = m-i-1;
		}
	}
}
