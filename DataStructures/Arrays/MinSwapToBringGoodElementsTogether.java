class MinSwapToBringGoodElementsTogether {
  /*
    Given an array of n positive integers and a number k. Find the minimum number of swaps required to bring all the numbers less than or equal to k together.
    TC=> O(n), SC=> O(1)
    Solution:
      1. Use sliding window technique- use k as window size
      2. Check minimum of no. of bad elements in window on each slide
      3. At the end, this count wil be the ans
  */
  public static void main(String[] args) {
    int[] arr = {2, 1, 5, 6, 3};
    int k=3;
    System.out.println(minSwaps(arr, k));
  }

  static int minSwaps(int[] arr, int k){
    int bad = 0;
    int count = 0, i=0;
    for(i=0; i<arr.length; i++)    //get total count of good elements
      if(arr[i]<=k)
        count++;

    for(i=0; i<count; i++){    //get count of bad elements in 1st window
      if(arr[i]>k)
        bad++;
    }

    i=0;
    int ans = bad;      //setting ans to intial count of bad elements
    for(int j=count; j<arr.length; j++,i++){
      if(arr[i]>k)
        bad--;
      if(arr[j]>k)
        bad++;
      ans = Math.min(ans,bad);
    }
    return ans;
  }
}
