package ds.stacks;

import java.util.Stack;

public class LargestRectangleAreaInHistogram {

	public static void main(String[] args) {
		int hist[] = { 6, 2, 5, 4, 5, 1, 6 }; 
		  
        // Function call 
        System.out.println("Maximum area is "
                           + getMaxArea(hist, hist.length)); 
	}

	static int getMaxArea(int[] hist, int n) {
		int maxArea=0, currArea;
		
		Stack<Integer> st = new Stack<>();
		int right=0, left, X;
		
		while(right<n) {
			if(st.isEmpty() || hist[right]>=hist[st.peek()]) {		//if curr is higher than top
				st.push(right);
				right++;
			}else {												//if curr is smaller than top
				X = st.pop();									//pop it and find area where it is the smallest bar
				left = st.isEmpty() ? -1 : st.peek();			//find left limit, if stack is empty then -1
				
				currArea = hist[X] * (right-left-1);			//calculate area
				
				maxArea = Math.max(maxArea, currArea);			//update max area
			}
		}
		
		return maxArea;
	}
}
