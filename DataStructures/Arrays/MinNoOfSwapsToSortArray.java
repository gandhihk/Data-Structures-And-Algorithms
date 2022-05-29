import java.util.*;
class MinNoOfSwapsToSortArray {
  /*
    Given an array of n distinct elements, find the minimum number of swaps required to sort the array
    Solution: imagine it like a graph
    1. Create hashmap to store elements and their indices. Sort the original array. Use a visited array
    2. Traverse sorted array and check if element is visited or its position in sorted array and hashmap is same
    3. If above is false, then run a while loop to visit all swappable nodes, and count the visited nodes
    4. Add cycles-1 to count
  */
  public static void main(String[] args) {
    int[] arr = {1, 5, 4, 3, 2};
    System.out.println(getSwapCount(arr));
  }

  static int getSwapCount(int[] arr){
    int n=arr.length;
    boolean[] visited = new boolean[n];    //visited array
    Arrays.fill(visited, false);
    
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i=0; i<n; i++)
      map.put(arr[i], i);        //insert (element, index) to map

    Arrays.sort(arr);      //sort given array

    int j, cycles=0, swaps=0;
    for(int i=0; i<n; i++){
      if(visited[i] || i==map.get(arr[i]))
        continue;      //check if element already visited or is in correct pos

      j=i; cycles=0;      //reset cycles count and j
      while(!visited[j]){
        visited[j] = true;      //make it visited
        j = map.get(arr[j]);     //get orig pos from map, this is the swappable node
        cycles++;      //increment the no. of visited nodes as cycles
      }
      
      if(cycles>0)      //check if some swap could have happened
        swaps+=cycles-1;       //swaps=cycles-1
    }
    return swaps;
  }
}
