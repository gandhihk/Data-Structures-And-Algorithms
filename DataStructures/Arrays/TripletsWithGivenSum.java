import java.util.*;
class TripletsWithGivenSum {
  /*
    Given an array and a value, find if there is a triplet in array whose sum is equal to the given value
    1st Solution: Hashset
      Run 1 loop from i=start to end, inner loop from j=i+1 to n, check if there exists sum-arr[i]-arr[j] in hashmap, else add arr[j]
    TC=> O(n2), SC=> O(n)
    2nd solution: Sorting and 2-pointer
      1. Sort array
      2. Traverse array and fix 1st number
        a. run inner loop from left=i+1 to right=n
        b. use 2-pointer technique to find if arr[i]+arr[left]+arr[right]==sum
        c. if not then move pointers accordingly
    TC=> O(n2), SC=> O(1)
  */
  public static void main(String[] args) {
    int[] arr = {1, 4, 45, 6, 10, 8};
    int[] arr1 = {1, 4, 45, 6, 10, 8};
    hashing(arr, 22);
    sortingAndTwoPointer(arr1, 22);
  }

  static void hashing(int[] arr, int sum){
    int n = arr.length;
    for(int i=0; i<n-2; i++){
      HashSet<Integer> set = new HashSet<>();
      int curr_sum = sum-arr[i];
      for(int j=i+1; j<n; j++){
        if(set.contains(curr_sum-arr[j])){
          System.out.println(arr[i]+" "+arr[j]+" "+(curr_sum-arr[j]));
          return;
        }
        set.add(arr[j]);
      }
    }
  }

  static void sortingAndTwoPointer(int[] arr, int sum){
    Arrays.sort(arr);
    int n = arr.length, left, right;
    for(int i=0; i<n-2; i++){
      left = i+1; right = n-1;
      while(left<right){
        if(arr[i]+arr[left]+arr[right]==sum){
          System.out.println(arr[i]+" "+arr[left]+" "+arr[right]);
          return;
        }else if(arr[i]+arr[left]+arr[right]<sum)
          left++;
        else right--;
      }
    }
  }
}
