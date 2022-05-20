class MaxSumSubArray {
  /*
    Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum. Also, get start and end index of the subarray
    Solution: Kore's method(Kadane's modification)
      1. Keep 2 variables for curr_sum(sum of curr pos subarray) and max(max sum of all possible pos subarray)
      2. Traverse array, add elements to sum and check if curr_sum>max, then set max as curr_sum and set end index
      3. If sum<0, reset sum. Set start index
    TC=> O(n), SC=> O(1)
  */
  public static void main(String[] args) {
    int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
    System.out.println(getMaxSumSubarray(arr));
  }

  static int getMaxSumSubarray(int[] arr){
    int curr_sum = 0;
    int max_sum = Integer.MIN_VALUE;
    int start=0, end=0, s=0;    //initialize start of curr pos subarray from 0

    for(int i=0; i<arr.length; i++){
      curr_sum+=arr[i];    //add element to curr sum
      if(curr_sum>max_sum){
        max_sum = curr_sum;
        end = i;          //set end index to this element, so that if further elements are -ve, we can say max subarray was till this element
        start = s;        //set start index to index where curr positive subarray started
      }
      if(curr_sum<0){      //if -ve element, then reset curr_sum, start new pos subarray from next element
        curr_sum = 0;
        s = i+1;
      }
    }
    System.out.println(start+" "+end);
    return max_sum;
  }
}
