package ds.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordBreak {

	/*
	 * Given an input string and a dictionary of words, 
	 * find out if the input string can be segmented into a space-separated 
	 * sequence of dictionary words
	 * 
	 * Solution 1: Backtracking(Recursion)
	 * 1. consider each prefix and search for it in dictionary. If it is present, recur for rest of the string.
	 * 2. if the recursive call for rest of string returns true, then return true(string can be segmented), else try next prefix
	 * 3. base case for recursion: empty string, return true
	 * 4. Next prefix is nothing but substring(0,i). if all prefixes do not return true, then string cannot be segmented
	 * TC=> O(2^n)
	 * 
	 * Solution 2: DP
	 * 1. Same logic as above, only difference is store the result of recursive calls in DP array to avoid recalculations
	 * TC=> O(n3)
	 */
	
	static Set<String> dictionary = new HashSet<>();
	
	public static void main(String[] args) {
		String temp_dictionary[] = {"mobile","samsung","sam","sung",
                "man","mango","icecream","and",
                "go","i","like","ice","cream"};
		
		// loop to add all strings in dictionary set
        for (String temp :temp_dictionary)
        {
            dictionary.add(temp);
        }
        
        Map<String, Boolean> dp = new HashMap<>();
		
		System.out.println(wordBreak2("ilikesamsung", dp));
        System.out.println(wordBreak2("iiiiiiii", dp));
        System.out.println(wordBreak1(""));
        System.out.println(wordBreak1("ilikelikeimangoiii"));
        System.out.println(wordBreak1("samsungandmango"));
        System.out.println(wordBreak1("samsungandmangok"));
	}
	
	static boolean wordBreak1(String s) {
		if(s.length()==0)			//base case
			return true;
		
		for(int i=1; i<=s.length(); i++) {
			// the prefix will have a length of i and check if it is
            // present in dictionary ,if yes then we will check for
            // suffix of length size-i recursively. if both prefix and
            // suffix are present the word is found in dictionary.
			if(dictionary.contains(s.substring(0,i)) && wordBreak1(s.substring(i,s.length())))
				return true;
		}
		// if all cases failed then return false
		return false;
	}
	
	static boolean wordBreak2(String s, Map<String, Boolean> dp) {
		int n = s.length();
		
		if(n==0)			//base case
			return true;
		
		if(dp.containsKey(s))		//case to avoid recalculations
			return dp.get(s);
		
		for(int i=1; i<=n; i++) {
			if(dictionary.contains(s.substring(0,i)) && wordBreak2(s.substring(i,n), dp)) {
				dp.put(s, true);
				return true;
			}
		}
		
		dp.put(s, false);
		return false;
	}
}
