package ds.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SmallestWindowWithDistinctCharsofItself {

	public static void main(String[] args) {
		String s = "aabcbcdbca";
//		System.out.println(findSmallestWindow(s));
		System.out.println(findSmallestWindowBySlidingWindow(s));
	}

	static int findSmallestWindow(String s) {
		Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
		
		for(int i=0; i<s.length(); i++) {
			if(!map.containsKey(s.charAt(i))){
			    map.put(s.charAt(i), 1);
			    map2.put(s.charAt(i), 1);
			}
			else{
			    map.put(s.charAt(i), map.get(s.charAt(i))+1);
			    map2.put(s.charAt(i), map2.get(s.charAt(i))+1);
			}
		}
		
		int i, j, val;
		char c;
		for(i=0; i<s.length(); ) {
			c = s.charAt(i);
			val = map.get(c);
			if(val>1) {
				map.put(c, val-1);
				i++;
			}
			else break;
		}
		
		for(j=s.length()-1; j>=i; ) {
			c = s.charAt(j);
			val = map.get(c);
			if(val>1) {
				map.put(c, val-1);
				j--;
			}
			else break;
		}
		System.out.println(i+" "+j);
		
		int i2, j2;
		for(j2=s.length()-1; j2>=0; ) {
			c = s.charAt(j2);
			val = map2.get(c);
			if(val>1) {
				map2.put(c, val-1);
				j2--;
			}
			else break;
		}
		for(i2=0; i2<j2; ) {
			c = s.charAt(i2);
			val = map2.get(c);
			if(val>1) {
				map2.put(c, val-1);
				i2++;
			}
			else break;
		}
		System.out.println(i2+" "+j2);
		
		return Math.min(j-i+1, j2-i2+1);
	}
	
	static int findSmallestWindowBySlidingWindow(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int count=0, i=0, j=1;
		int ans = Integer.MAX_VALUE;
		Set<Character> set = new HashSet<>();
		
		for(int k=0; k<s.length(); k++) {
			set.add(s.charAt(k));
		}
		
		int n  = set.size();			//no. of unique chars
		
		map.put(s.charAt(i), 1);
		count++;
		
		while(i<=j && j<s.length()) {
			if(count < n) {
				char c = s.charAt(j);
				if(!map.containsKey(c) || map.get(c)==0) {
					map.put(c, 1);
					count++;
				}
				else
					map.put(c, map.get(c)+1);
				j++;
			}
			else if(count==n) {
				ans = Math.min(ans, j-i);
				if(map.get(s.charAt(i))==1)
					count--;
				map.put(s.charAt(i), map.get(s.charAt(i))-1);
				i++;
			}
		}
		
		while(count==n) {
			ans = Math.min(ans, j-i);
			if(map.get(s.charAt(i))==1)
				count--;
			map.put(s.charAt(i), map.get(s.charAt(i))-1);
			i++;
		}
		
		return ans;
	}
}
