import java.util.*;
class MoveAllNegToOneSide {
  /*
    Move all -ve numbers to the start of the array. order can be changed
    Req. TC=> O(n), SC=> O(1)
    Solution:
      1. Use 2 pointers for partition- 1 for partition point and 2 pointing to next -ve number on right of partition point
      2. Iterate array by swapping next -ve number to partition point and increment partition pointer
  */
  public static void main(String[] args) {
    int nums[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
    rearrange(nums);
    System.out.println(Arrays.toString(nums));
  }

  static void rearrange(int[] arr){
    int i=-1, temp;
    /* Modify same logic to move all -ves to end of array by setting i=arr.length, iterate from right */
    for(int j=0; j<arr.length; j++){
      if(arr[j]<0){
        i++;
        temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
      }
    }
  }
}