package ds.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintAllAnagramsTogether {

	public static void main(String[] args) {
		String[] wordStrings = {"cat", "dog", "tac", "god", "act"};
		printAllAnagrams(wordStrings);
	}
	
	static void printAllAnagrams(String[] words) {
		Map<String, List<String>> map = new HashMap<>();
		
		for(String s: words) {
			
			//sort the word
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			String sortedString = new String(chars);
			
			//check if s is anagram, put it in list
			if(map.containsKey(sortedString)) {
				map.get(sortedString).add(s);
			}else {
				List<String> list = new ArrayList<>();
				list.add(s);
				map.put(sortedString, list);
			}
		}
		
		for(Map.Entry<String, List<String>> entry: map.entrySet()) {
			if(entry.getValue().size()>1) 
				System.out.println(entry.getValue());
		}
	}

}
