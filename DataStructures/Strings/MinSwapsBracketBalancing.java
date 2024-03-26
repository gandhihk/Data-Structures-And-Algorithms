package ds.string;

import java.util.ArrayList;
import java.util.List;

public class MinSwapsBracketBalancing {

	public static void main(String[] args) {
		String s = "[]][][";
        System.out.println(swapCount3(s));

	}
	
	static int swapCount1(String s) {
		int count=0;
		int openCount=0, swapPos;			//to keep track of [
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)==']') {
				openCount--;				//decrement openCount
				if(openCount<0) {			//if its <0, then imbalance is present and need to swap
					swapPos = findSwapPos(s, i);			//get next [ and swap with this ]
					s = swap(s, i, swapPos);
					openCount=0;				//reset count of [
					count += swapPos-i;			//add no. of swaps to ans
					i++;						//skip next ]
				}
			}
			else if(s.charAt(i)=='[')
				openCount++;
		}
		
		return count;
	}
	
	static int findSwapPos(String s, int i) {
		int pos=i+1;
		while(pos<s.length() && s.charAt(pos)==']')
			pos++;
		return pos;
	}
	
	static String swap(String s, int i, int j) {
		char[] sArr = s.toCharArray();
		char temp = sArr[j];
		sArr[j] = sArr[i]; 
		sArr[i] = temp;
		return String.valueOf(sArr);
	}
	
	
	static int swapCount2(String s) {
		List<Integer> pos = new ArrayList<>();		//to store all positions of [
		
		int p = 0;									//to track position of next [ in pos
		int openCount = 0, count = 0, swapCount=0;				//to track no. of [, and swaps required
		
		for(int i=0; i<s.length(); i++)				//store all positions of [
			if(s.charAt(i) == '[')
				pos.add(i);
		
		char[] sArr = s.toCharArray();
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == ']') {				//if char is ]
				openCount--;						//decrement openCount
				if(openCount<0) {					//if its <0, then get position of next [ from pos
					swapCount = pos.get(p)-i;
					count += swapCount;				//add swapCount to ans
					
					char temp = sArr[pos.get(p)];	//swap that [ with this ]
					sArr[pos.get(p)] = sArr[i];
					sArr[i] = temp;
					
					p++;							//increment p to point to next position of [ in pos
					openCount=0;					//reset openCount
					i++;							//skip next ]
				}
			}
			else if(s.charAt(i) == '[') {
				openCount++;					
				p++;								//increment p to point to next position of [ in pos
			}
		}
		return count;
	}
	
	static int swapCount3(String s) {
		int openCount=0, closeCount=0;				//counts of [ and ]
		
		int imbalance=0, count=0;					//to store number of extra ] compared to [ till now
		
		for(int i=0; i<s.length(); i++) {
			//find no. of swaps required when we encounter [ instead of ]
			//instead of incrementing 1-2 swaps at each ], we go to the next [ and add all swaps that will be required till this [
			if(s.charAt(i) == '[') {
				openCount++;
				if(imbalance>0) {			//check if imbalance present
					count += imbalance;		//add that imbalance to ans
					imbalance--;			//since we solved 1 imbalance using this [
				}
			}
			else if(s.charAt(i) == ']') {
				closeCount++;
				imbalance = closeCount - openCount;		//calculate imbalance as difference between close and open brackets
			}
		}
		
		return count;
	}

}
