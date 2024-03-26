package ds.stacks;

import java.util.Stack;

public class ReverseStackUsingRecursion {
	
	static Stack<Integer> st = new Stack<>();

	public static void main(String[] args) {
		st.push(30);
        st.push(-5);
        st.push(18);
        st.push(14);
        st.push(-3);
 
        System.out.println("Original Stack");
 
        System.out.println(st);
 
        reverse();
 
        System.out.println("Reversed Stack");
 
        System.out.println(st);
	}
	
	static void reverse() {
		if(st.isEmpty())
			return;
		
		int X = st.pop();
		
		reverse();
		
		insertAtBottom(X);
	}
	
	static void insertAtBottom(int X) {
		if(st.isEmpty())
			st.push(X);
		else {
			int C = st.pop();
			
			insertAtBottom(X);
			
			st.push(C);
		}
	}

	static void sortedInsert(int X) {
		if(st.isEmpty() || X>st.peek())		//insert if stack is empty or element is > top of stack
			st.push(X);
		else {
			int C = st.pop();
			
			insertAtBottom(X);
			
			st.push(C);
		}
	}
}
