import java.util.*;
class MergeOverlappingIntervals {
  /*
    Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
    Solution: Sorting
    1. Sort intervals based on start 
    2. Traverse input intervals, check if next interval overlaps curr interval. If yes then merge them, else add this curr interval to list and set curr_interval=this interval.
    TC=> O(Nlogn), SC=> o(n)
  */
  public static void main(String[] args) {
    int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
    merge(arr);
  }

  static void merge(int[][] arr){
    Arrays.sort(arr ,(a,b)-> a[0]-b[0]);    //sort on start 

    Integer[] curr_int = new Integer[2];    //holds current interval with which other intervals are compared
    curr_int[0] = arr[0][0];
    curr_int[1] = arr[0][1];

    List<Integer[]> list = new ArrayList<>(); 
    for(int[] a : arr){
      if(a[0] <= curr_int[1])    //check if this int can be merged to curr_int
        curr_int[1] = Math.max(curr_int[1], a[1]);
      else{
        list.add(curr_int);    //add curr int to list
        curr_int = new Integer[2];
        curr_int[0] = a[0];    //set curr int to this int
        curr_int[1] = a[1];
      }
    }
    list.add(curr_int);
    list.forEach(array -> System.out.println(Arrays.toString(array)));
  }
}
