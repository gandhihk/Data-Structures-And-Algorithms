package ds.string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class RemoveAdjacentDuplicates {

	public static void main(String[] args) {
		String string = "acaaabbbacdddd";
		System.out.println(removeAdjacentDuplicates(string));
	}

	static String removeAdjacentDuplicates(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		char[] chars = s.toCharArray();
		
		for(int i=0; i<chars.length; ) {
			
			if(stack.isEmpty() || chars[i]!=stack.peek()) {
				stack.push(chars[i]);
				i++;
			}
			else if(!stack.isEmpty()) {
				while(i<chars.length && chars[i]==stack.peek()) {
					i++;
				}
				stack.poll();
				if(i<chars.length && chars[i]!=stack.peek()) {
					stack.push(chars[i]);
					i++;
				}
			}
		}
		
		List<Character> strings = stack.stream().toList();
		return strings.toString();
	}
}
