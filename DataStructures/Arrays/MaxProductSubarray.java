class MaxProductSubarray {
  /*
    Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
    Solution:
      1. Use 3 variables for maxProd,minProd and ans
      Traverse array and
        2. If e<0, swap minProd and maxProd
        3. set minProd and maxProd values by multiplying with element
        4. set ans as max(maxProd,ans)
    TC=> O(n), SC=> O(1)
  */
  public static void main(String[] args) {
    int arr[] = {2,3,-2,-4};
    System.out.println(getMaxProduct(arr));
  }

  static int getMaxProduct(int[] arr){
    int maxProd=1;
    int minProd=1;
    int ans=Integer.MIN_VALUE;
    if(arr.length==1) return arr[0];
    for(int ele:arr){
      if(ele<0){    //if element is -ve, max will become min
        int t = maxProd;
        maxProd = minProd;
        minProd = t;
      }
      //multiply with current element, and set to maxProd, minProd
      maxProd = Math.max(maxProd*ele,ele);
      minProd = Math.min(minProd*ele,ele);
      ans = Math.max(ans,maxProd);    //maximise and set to ans
    }
    return ans;
  }
}
