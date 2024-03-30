package ds.stacksAndQueues;

import java.util.Stack;

public class LongestValidSubstring {

	public static void main(String[] args) {
		String str = "((()()";
		 
	    // Function call
	    System.out.print(findMaxLen2(str) +"\n");
	 
	    str = "()(()))))";
	 
	    // Function call
	    System.out.print(findMaxLen2(str) +"\n");
	}

	static int findMaxLen(String s) {
		Stack<Integer> st = new Stack<>();
		st.push(-1);
		int max=0;
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			
			if(c=='(') {
				st.push(i);
			}else {
				if(!st.isEmpty())
					st.pop();
				
				if(!st.isEmpty())
					max = Math.max(max, i-st.peek());
				else
					st.push(i);
			}
		}
		
		return max;
	}
	
	static int findMaxLen2(String s) {
		int left=0, right=0, max=0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='(')
				left++;
			else
				right++;
			
			if(left==right)
				max = Math.max(max, left+right);
			else if(right>left)
				left = right = 0;
		}
		
		left = right = 0;
		for(int i=s.length()-1; i>=0; i--) {
			if(s.charAt(i)=='(')
				left++;
			else
				right++;
			
			if(left==right)
				max = Math.max(max, left+right);
			else if(left>right)
				left = right = 0;
		}
		
		return max;
	}
}
