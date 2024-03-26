package ds.string;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowWithOtherStringChars {

	public static void main(String[] args) {
		String s1 = "this is a test string";
		String s2 = "tist";
		System.out.println(findSmallestWindowBySlidingWindow(s1, s2));
	}
	
	static String findSmallestWindowBySlidingWindow(String s, String t) {
		Map<Character, Integer> map = new HashMap<>();
		int count=0, i=0, j=1, start=0;
		int ans = Integer.MAX_VALUE;
		
		for(int k=0; k<t.length(); k++) {
			if(!map.containsKey(t.charAt(k)))
				map.put(t.charAt(k), 1);
			else
				map.put(t.charAt(k), map.get(t.charAt(k))+1);
		}
		System.out.println(map.toString());
		
		int n  = map.size();			//no. of unique chars
		
		char c2 = s.charAt(i);
		if(map.containsKey(c2)) {
			map.put(c2, map.get(c2)-1);
			if(map.get(c2)==0)
				count++;
		}	
		
		while(i<=j && j<s.length()) {
			if(count < n) {
				char c = s.charAt(j);
				if(map.containsKey(c)) {
					map.put(c, map.get(c)-1);
					if(map.get(c)==0)
						count++;
				}
				j++;
			}
			else if(count==n) {
				if(ans>j-i)
					start=i;
				ans = Math.min(ans, j-i);
				char c1 = s.charAt(i);
				if(map.containsKey(c1)) {
					map.put(c1, map.get(c1)+1);
					if(map.get(c1)>0)
						count--;
				}
				i++;
			}
		}
		
		while(count==n) {
			if(ans > j-i) {
				start = i;
			}
			ans = Math.min(ans, j-i);
			char c1 = s.charAt(i);
			if(map.containsKey(c1)) {
				map.put(c1, map.get(c1)+1);
				if(map.get(c1)>0)
					count--;
			}
			i++;
		}
		
		return start+" "+(start+ans);
	}

}
