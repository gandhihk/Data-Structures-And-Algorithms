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
    System.out.println(getSwapCount1(arr));
  }

  static int getSwapCount1(int[] arr){
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
  
    public static int getSwapCount2(int[] arr)
    {
 	int N = arr.length;
        int ans = 0;
        int[] temp = Arrays.copyOfRange(arr, 0, N);
 
        // Hashmap which stores the
        // indexes of the input array
        HashMap<Integer, Integer> h
            = new HashMap<Integer, Integer>();
 
        Arrays.sort(temp);
        for (int i = 0; i < N; i++)
        {
            h.put(arr[i], i);
        }
        for (int i = 0; i < N; i++)
        {
 
            // This is checking whether
            // the current element is
            // at the right place or not
            if (arr[i] != temp[i])
            {
                ans++;
                int init = arr[i];
 
                // If not, swap this element
                // with the index of the
                // element which should come here
                swap(arr, i, h.get(temp[i]));
 
                // Update the indexes in
                // the hashmap accordingly
                h.put(init, h.get(temp[i]));
                h.put(temp[i], i);
            }
        }
        return ans;
    }
    
    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
