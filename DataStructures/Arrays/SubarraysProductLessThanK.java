class Main {
  /*
    Given an array of positive numbers, calculate the number of possible contiguous subarrays having product lesser than a given number K.
    Solution: Sliding window technique. Only difference is when we make product<k by removing elements from left, we have to count that subarray after making product<k
    1. Add element to product.
    2. make sure the product<k by removing elements from left
    3. if product<k, count the subarrays as count=end-start+1. the single array element is the only addendum as we know the product was already<k
  */
  public static void main(String[] args) {
    int[] nums = {10, 5, 2, 6};
    int k=100;
    System.out.println(getCount(nums, k));
  }

  static int getCount(int[] nums, int k){
    int count=0, p = 1;
        
    if(k==0)
      return 0;

    for (int start = 0, end = 0; end < nums.length; end++) {
      p *= nums[end];
      
      while (start < end && p >= k)
        p /= nums[start++];
 
      if (p < k) {
        count+= end - start + 1;
      }
    }
    return count;
  }
}
