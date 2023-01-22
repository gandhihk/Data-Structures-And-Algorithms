package ds.string;

import java.util.Stack;

public class MinReversalsForBalancedExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String exp = "}}}}{{";
		System.out.println(findMinReversals1(exp));
		System.out.println(findMinReversals2(exp));
	}
	
	static int findMinReversals1(String exp) {
		int len = exp.length();
		
		if(len%2 != 0)			//expression cannot be balanced if odd length
			return -1;
		
		Stack<Character> stack = new Stack<>();
		for(int i=0; i<len; i++) {			//this loop removes all balanced brackets
			char c = exp.charAt(i);
			if(c=='}' && !stack.isEmpty()) {
				if(stack.peek()=='{')
					stack.pop();
				else
					stack.push(c);
			}else {
				stack.push(c);
			}
		}
		
		//count opening brackets in stack
		int n=0;
		while(!stack.isEmpty() && stack.peek()=='{') {
			n++;
			stack.pop();
		}
		//count closing brackets in stack
		int m=0;
		while(!stack.isEmpty() && stack.peek()=='}') {
			m++;
			stack.pop();
		}
		
		return (int) (Math.ceil(m/2) + Math.ceil(n/2));
	}
	
	static int findMinReversals2(String exp) {
		int len = exp.length();
		
		if(len%2 != 0)
			return -1;
		
		int left=0, right=0;
		for(int i=0; i<len; i++) {
			char c = exp.charAt(i);
			
			if(c=='{')				//if char is left bracket, then inc left count
				left++;
			else {
				if(left==0)			//for extra right bracket, inc right count
					right++;
				else
					left--;			//for balanced exp, dec left count
			}
		}
		
		return (int)(Math.ceil(left/2) + Math.ceil(right/2));
	}
}
