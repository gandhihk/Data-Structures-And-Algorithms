import java.util.*;
class RotateArray {
  /*
    Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements. 
    Direction can be left or right

    Solution : Reversal algorithm
    Steps: 
      1. Reverse 1st part of array(depending on direction)
      2. Reverse 2nd part of array
      3. Reverse the whole array
    TC=> O(n), SC=> O(1)
  */
  public static void main(String[] args) {
    int ar[] = {1, 2, 3, 4, 5, 6, 7};
    int ar1[] = {1, 2, 3, 4, 5, 6, 7};
    int d = 2;
    int n = ar.length;
    rotate(ar, d, n, "left");
    rotate(ar1, d, n, "right");
  }

  public static void rotate(int[] arr, int d, int n, String dir){
    if(dir.equals("left")){
      reverse(arr, 0, d-1);
      reverse(arr, d, n-1);
      reverse(arr, 0, n-1);
      System.out.println(Arrays.toString(arr));
    }else{
      reverse(arr, 0, n-d-1);
      reverse(arr, n-d, n-1);
      reverse(arr, 0, n-1);
      System.out.println(Arrays.toString(arr));
    }
    
  }

  public static void reverse(int[] arr, int start, int end){
    int temp;
    while(start<=end){
      temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }
}
