class KadaneAllNeg {
  /*
    Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
    Solution: Kadane's modification for all neg
      1. Traverse array, add elements to sum and check if curr_sum<arr[i], then set curr_sum as arr[i] instead of resetting it to 0(since the largest -ve number will be the largest sum in case of all neg)
      3. If max_sum<curr_sum, then set max_sum as curr_sum
    TC=> O(n), SC=> O(1)
  */
  public static void main(String[] args) {
    int[] arr = {-12,-11,-3,-4,-2,-10,-6,-5,-4};
    System.out.println(getMaxSumSubarray(arr));
  }

  static int getMaxSumSubarray(int[] arr){
    int curr_sum = 0;
    int max_sum = Integer.MIN_VALUE;

    for(int i=0; i<arr.length; i++){
      curr_sum+=arr[i];    //add element to curr sum
      if(curr_sum<arr[i]){      //if -ve element, then reset curr_sum to this element
        curr_sum = arr[i];
      }
      if(curr_sum>max_sum){
        max_sum = curr_sum;
      }
    }
    return max_sum;
  }
}
