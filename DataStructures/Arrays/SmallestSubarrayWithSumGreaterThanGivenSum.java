class SmallestSubarrayWithSumGreaterThanGivenSum {
  /*
    Given an array of integers and a number x, find the smallest subarray with sum greater than the given value. 
    Solution:
    Exactly same as finding subarray with given sum, only difference is to not stop on getting a subarray with given sum, but keep track of the lengths of them and return min
    1. Use sliding window technique. Add elements till curr_sum<target.
    2. Keep removing elements from start till curr_sum>=target, also check if len of curr subarray is minimum
    Note: this will work only for +ve numbers
    TC=> O(n), SC=> O(1)
  */
  public static void main(String[] args) {
    int[] arr = {1, 4, 45, 6, 10, 19};
    int target=51;
    System.out.println(smallestSubWithSum(arr, arr.length, target));
  }

  static int smallestSubWithSum(int arr[], int n, int x)
  {
    int curr_sum = 0, min_len = n + 1;
    int start = 0, end = 0;
    while (end < n) {
      //Keep adding elements while curr_sum<=x
      while (curr_sum <= x && end < n)
        curr_sum += arr[end++];
 
      // If current sum becomes greater than x.
      while (curr_sum > x && start < n) {
        // Update minimum length if needed
        if (end - start < min_len)
          min_len = end - start;
 
        // remove starting elements
        curr_sum -= arr[start++];
      }
    }
    return min_len;
  }
}
