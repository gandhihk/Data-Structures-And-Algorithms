package ds.string;

public class LongestCommonPrefix {
	
	static class TrieNode{
		TrieNode[] children = new TrieNode[256];
		boolean isLeaf;		//true if node represents end of word
		
		public TrieNode() {
			isLeaf = false;
			for(int i=0; i<26; i++)			//initializing all children as null
				children[i]= null; 
		}
		
	}

	static TrieNode root;
	static int indexes;							//used in walking trie where to move next, i.e. which child to go to next
	
	public static void main(String[] args) {
		String arr[] = {"geeksforgeeks", "geeks",
                "geek", "geezer"};
		int n = arr.length;
		
		root = new TrieNode();
		for(int i=0; i<n; i++)					//create Trie
			insert(arr[i]);
		
		System.out.println(walkTrie());

	}
	
	static void insert(String key) {
		TrieNode pNode = root;				//take handle of root
		int index;							//index to mark child in children array
		for(int j=0; j<key.length(); j++) {
			index = key.charAt(j) - 'a';		//get ascii value of char and get index to mark this char in children array
			if(pNode.children[index]==null)		//check if that child is null
				pNode.children[index] = new TrieNode();			//mark that child
		
			pNode = pNode.children[index];		//move to that child node for next iteration
		}
		
		pNode.isLeaf = true;			//mark last node as leaf
	}
	
	static String walkTrie() {
		TrieNode pNode = root;			//handle of root
		indexes = 0;					//initially at root pos
		
		String prefix = "";				//prefix which stores ans
		
		while(countChildren(pNode) == 1					//if this node has only 1 child
				&& pNode.isLeaf==false) {				//and is not a leaf node
			pNode = pNode.children[indexes];			//move to its child node
			prefix += (char)('a'+indexes);				//add this node's char to prefix
		}
		
		return prefix;
	}
	
	// Counts and returns the number of children of current node
	static int countChildren(TrieNode p) {
		int count = 0;
		
		for(int i=0; i<26; i++) {
			if(p.children[i] != null) {					//if child node present
				count++;			
				indexes = i;							//set indexes value to this child's pos
			}
		}
		return count;
	}

}
