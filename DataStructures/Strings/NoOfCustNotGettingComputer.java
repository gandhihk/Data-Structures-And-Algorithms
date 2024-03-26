package ds.string;

import java.util.HashMap;
import java.util.Map;

public class NoOfCustNotGettingComputer {

	public static void main(String[] args) {
		int n = 1;
		String string = "ABCBCADEED";
		
		System.out.println(findNumberOfCustomers(n, string));

	}
	
	static int findNumberOfCustomers(int n, String s) {
		int res = 0;
		int occupied=0;
		
		//Value 0->1st time customer, 1->in cafe but no computer, 2->using computer
		Map<Character, Integer> map = new HashMap<>();
		
		for(char c: s.toCharArray()) {
			if(!map.containsKey(c)) {		//new customer
				if(occupied<n) {
					occupied++;
					map.put(c, 1);
				}else {
					res++;
					map.put(c, 0);
				}
			}else {							//already present in cafe
				if(map.get(c)==1)
					occupied--;
				map.remove(c);
			}
		}
		
		return res;
	}

}
