package ds.string;

import java.util.HashMap;
import java.util.Map;

public class RearrangeNoTwoAdjacentSame {

	public static void main(String[] args) {
		String string = "aaabc";
		
		String reString = rearrange(string);
		if(reString.equals(""))
			System.out.println("Not possible");
		else
			System.out.println(reString);
	}

	static String rearrange(String s) {
		int n = s.length();
		if(n==0)
			return "";
		
		Map<Character, Integer> count = new HashMap<>();
		for(char c: s.toCharArray()) {
			if(count.containsKey(c))
				count.put(c, count.get(c)+1);
			else
				count.put(c, 1);
		}
		
		char c_max = getMaxCountChar(count);
		int maxCount = count.get(c_max);
		count.remove(c_max);
		
		if (maxCount > (n + 1) / 2)
            return "";
		
		StringBuilder res = new StringBuilder();
		for(int i=0; i<n; i++)
			res.append('_');
		
		int index = 0;
		while(maxCount>0 && index<n) {
			res.setCharAt(index, c_max);
			index+=2;
			maxCount--;
		}
		System.out.println(res);
		
		for(Map.Entry<Character, Integer> e: count.entrySet()) {
			
			int c = e.getValue();
			char c1 = e.getKey();
			while(c>0) {
				index = index>=n ? 1 : index;
				res.setCharAt(index, c1);
				c--;
				index+=2;
			}
			System.out.println(res);
		}
		
		return res.toString();
	}
	
	static char getMaxCountChar(Map<Character, Integer> count) {
		int max=0;
		char res=' ';
		for(Map.Entry<Character, Integer> e: count.entrySet()) {
			if(e.getValue()>max) {
				res = e.getKey();
				max = e.getValue();
			}
		}
		return res;
	}
}
