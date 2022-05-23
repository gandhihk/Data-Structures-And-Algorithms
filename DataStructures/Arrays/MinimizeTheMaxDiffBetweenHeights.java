import java.util.*;
class MinimizeTheMaxDiffBetweenHeights {
  /*
    Given heights of n towers and a value k. We need to either increase or decrease the height of every tower by k (only once) where k > 0. The task is to minimize the difference between the heights of the longest and the shortest tower after modifications.
    Solution:
      1. Sort array
      2. After sorting, max diff=arr[n-1]-arr[0]. Consider a and b as min and max heights.
        For each pair (x,y) we have to make x+k and y-k to minimize the diff between them. But the question is to minimize the max diff, not just any diff. So, we have to check if x+k>b(max height after sorting) and y-k<a(min height after sorting).
      3. Repeat 2 for each pair, and get the minimum of the differences.
    TC=> O(nlogn), SC=> O(1)
  */
  public static void main(String[] args) {
    int[] arr ={7, 4, 8, 8, 8, 9};
    int k =6;
    System.out.println(minimizeMaxHeight(arr, k));
  }

  static int minimizeMaxHeight(int[] arr, int k){
    Arrays.sort(arr);      //first sort

    int a = arr[0];    //min height after sorting
    int b = arr[arr.length-1];    //max height after sorting
    int ans = b-a;      //initial max diff
    int curr_min, curr_max;
    
    for(int i=1; i<arr.length; i++){    //traverse array to +/- k
      if(arr[i]<k)      //skip heights which will become -ve after subtracting k
        continue;
      
      //y=>arr[i]. check if y-k becomes min
      curr_min = Math.min(arr[i]-k, a+k);  
      //x=>arr[i-1]. check if x+k becomes max
      curr_max = Math.max(arr[i-1]+k, b-k);
      //check if this is the minimum max diff
      ans = Math.min(ans, curr_max-curr_min);
    }
    return ans;
  }
}
