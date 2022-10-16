package ds.string;

public class ShuffledSubstringOfAnotherString {

	/*
	 * Given strings str1 and str2. The task is to find if str1 is a substring in the shuffled form of str2 or not. 
	 * Print “YES” if str1 is a substring in shuffled form of str2 else print “NO”. 
	 * Solution: Simpler version of anagram search
	 * 1. Keep 2 count arrays for storing frequency counts of chars in 2 strings. Size=256
	 * 2. store counts of chars in pattern in countP. store counts of chars in 1st window of text in countTW
	 * 3. for each window, compare count arrays. if equal, then pattern is present, else increment count of next char, decrement count of last char of window
	 * 4. here comparing count array will take O(1) as size of array is fix 256
	 */
	
	public static void main(String[] args) {
		String txt = "BACDGABCDA";
	    String pat = "ABDC";
	     
	    if (search(pat, txt))
	        System.out.println("Yes");
	    else
	        System.out.println("NO");
	}
	
	static boolean search(String pat, String txt) {
		int countP[] = new int[256];	//count array for pattern
		int countTW[] = new int[256];	//count array for text
		int M = pat.length();
		int N = txt.length();
		
		for(int i=0; i<M; i++) {		//get counts of pat and 1st window
			countP[pat.charAt(i)]++;
			countTW[txt.charAt(i)]++;
		}
		for(int i=M; i<N; i++) {
			if(compareCounts(countP, countTW))
				return true;
			countTW[txt.charAt(i)]++;		//add next char in window
			countTW[txt.charAt(i-M)]--;		//remove last char from window
		}
		if(compareCounts(countP, countTW))		//check for last window	
			return true;
		return false;
	}
	
	static boolean compareCounts(int[] arr1, int[] arr2) {
		for(int i=0; i<256; i++) {
			if(arr1[i]!=arr2[i])
				return false;
		}
		return true;
	}

}
