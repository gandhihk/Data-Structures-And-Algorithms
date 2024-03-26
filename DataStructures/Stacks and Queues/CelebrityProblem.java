package ds.stacks;

public class CelebrityProblem {

	public static void main(String[] args) {
		int[][] M = { { 0, 0, 1, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 1, 0 } };

	  int celebIdx = celebrity(M, 4);
	
	  if (celebIdx == -1)
	      System.out.println("No Celebrity");
	  else {
	      System.out.println("Celebrity ID " + celebIdx);
	  }
	}

	static int celebrity(int[][] M, int n) {
		int C=0;		//initial celebrity
		
		for(int i=0; i<n; i++) {		//find potential celebrity
			if(M[C][i]==1)				//eliminate if this celebrity knows someone
				C = i;					//update i as new celebrity
		}
		
		for(int i=0; i<n; i++) {			//confirm if C is celebrity
			if(C!=i && (M[C][i]==1 || M[i][C]==0))		//check if there is someone i who knows C or C knows i
				return -1;				//if yes, then return -1 as noone else can be celebrity
		}
		return C;
	}
}
