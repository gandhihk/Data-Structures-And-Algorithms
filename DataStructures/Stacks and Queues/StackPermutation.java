package ds.stacks;

import java.util.Stack;

public class StackPermutation {

	public static void main(String[] args) {
		// Input Array
        int input[] = { 4, 5, 6, 7, 8 };
 
        // Output Array
        int output[] = { 8, 7, 6, 5, 4 };
 
        int n = 5;
 
        if (checkStackPermutation(input, output, n))
            System.out.println("Yes");
        else
            System.out.println("Not Possible");

	}

	static boolean checkStackPermutation(int[] input, int[] output, int n) {
		// push elements from input array to stack until top of stack matches with first
        // element of output array
        Stack<Integer> s = new Stack<Integer>();
        
        int j=0;			//pointer to iterate output array
        
        for(int i=0; i<input.length; i++) {
        	s.push(input[i]);
        	
        	// if top matches with output array then keep popping out
            // from stack until top matches with output array
        	while(!s.isEmpty() && s.peek()==output[j]) {
        		s.pop();
        		j++;
        	}
        }
        
        return s.isEmpty();
	}
}
