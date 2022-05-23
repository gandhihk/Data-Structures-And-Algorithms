class MinNumberOfJumps {
  /*
    Given an array of non-negative integers nums, you are initially positioned at the first index of the array. Each element in the array represents your maximum jump length at that position. Your goal is to reach the last index in the minimum number of jumps.
    Solution:
      1. Use 3 variables: maxReach, steps(available steps), jump count. initialize with 1st element value
      2. Traverse the array,
        a. see if end is reached, return jump count
        b. use step, update maxReach as (i+arr[i])
        c. if available steps become 0, then increment jump count, update available steps
    TC=> O(n), SC=> O(1)
  */
  public static void main(String[] args) {
    int arr[] = new int[] { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
    System.out.println(minJumps(arr));
  }

  static int minJumps(int arr[])
  {
    //Base cases
    if (arr.length <= 1)
      return 0;
 
    // Return -1 if not possible to jump
    if (arr[0] == 0)
      return -1;
 
    // initialization
    int maxReach = arr[0];
    int step = arr[0];
    int jump = 1;
 
    // Start traversing array
    for (int i = 1; i < arr.length; i++) {
      // Check if we have reached the end of the array
      if (i == arr.length - 1)
        return jump;

      //we used a step to get to the current index
      step--;
      
      //updating maxReach with possible reach
      maxReach = Math.max(maxReach, i + arr[i]);
 
      //If no further steps are left, we have to use a jump and update the availabel step count
      if (step == 0) {
        jump++;
 
        //Check if the current position is the maximum reach point from the previous indexes
        if (i >= maxReach)
          return -1;
 
        //update the steps to the amount of steps available to reach maxReach from position i.
        step = maxReach - i;
      }
    }
    return -1;
  }
}
