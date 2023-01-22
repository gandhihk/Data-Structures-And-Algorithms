package ds.string;

public class KMP {

	public static void main(String[] args) {
		String pat = "ABABCABAB";
		String text = "ABABDABACDABABCABAB";
		findMatch(pat, text);
	}

	static void findMatch(String pat, String text) {
		int N = text.length();
		int M = pat.length();
		int i=0, j=0;			//indexes for text and pat
		int[] lps = new int[M];
		lps = computeLPSArray(pat);				//find lps array
		
		while((N-i) >= (M-j)) {
			if(text.charAt(i) == pat.charAt(j)) {		//matches
				i++;
				j++;
			}
			
			if(j == M) {						//complete pat found
				System.out.println("Pattern found at "+(i-j));
				j = lps[j-1];					//move j to lps loc
			}else if(i<N && text.charAt(i)!=pat.charAt(j)) {			//not matches
				if(j!=0)						//if j can go back, move j to lps loc
					j = lps[j-1];
				else							//if j cannot go back, move i to next pos
					i++;
			}
		}
	}
	
	static int[] computeLPSArray(String pat) {
		int M = pat.length();
		int[] lps = new int[M];
		int i=1, len = 0;			//length of lps
		
		while(i < M) {
			if(pat.charAt(i) == pat.charAt(len)) {		//matching char
				len++;				//increase len
				lps[i] = len;		//set lps[i] = len of lps of pat[0...i]
				i++;
			}else {
				if(len!=0)			//if len>0, go to last lps len
					len = lps[len-1];
				else {				//if len=0, then lps[i] will be
					lps[i] = len;
					i++;
				}
			}
		}
		
		return lps;
	}
}
