package ds.string;

public class CountAndSay {
	
	/*
	 * To generate a term using the previous term, we scan the previous term. 
	 * While scanning, we keep track of the count of all consecutive characters. 
	 * For a sequence of the same characters, we append the count followed by the character 
	 */

	public static void main(String[] args) {
		int N = 5;
        System.out.println(countAndSay(N));
	}
	
	static String countAndSay(int n) {
		if(n==1) return "1";
		if(n==2) return "11";
		
		String string="11";
		String temp;
		for(int i=3; i<=n; i++) {
			// In below for loop, previous char is processed in current iteration. 
			// So $ is added to make sure that loopruns one extra iteration.
	        string += '$';
	 
	        int cnt = 1; 		// Initialize count of matching chars
	        temp = "";
	        for(int j=1; j<string.length(); j++) {
	        	if(string.charAt(j)!=string.charAt(j-1)) {
	        		temp += Integer.toString(cnt);
	        		temp += string.charAt(j-1);
	        		cnt=1;		//reset count
	        	}else			// If matches, then increment count
	        		cnt++;
	        }
	        string = temp;		//update string
		}
		return string;
	}

}
