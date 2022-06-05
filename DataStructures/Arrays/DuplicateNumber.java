class DuplicateNumber {
  /*
    Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive. Find the duplicate number.
    1st solution: If there is only 1 duplicate, others are unique
      Find sum of numbers from 1 to n as n*(n+1)/2. Find actual sum, ans will be diff between these sums
    2nd solution: Works if there are 1 or more duplicates
      Cycle method: Use 2 pointers, slow and fast and find the cycle by moving slow 1 place and fast 2 places. start of cycle is the duplicate number

    TC=> O(n), SC=> O(1)
  */
  public static void main(String[] args) {
    int[] arr1 = {3,1,3,4,2};
    int[] arr2 = {2,2,2,2,2};
    System.out.println(sumMethod(arr1));
    System.out.println(cycleMethod(arr2));
  }

  static int sumMethod(int[] arr){
    int n = arr.length-1;
    int sum = n*(n+1)/2;
    int actual_sum = 0;
    for(int i=0; i<n+1; i++){
      actual_sum+=arr[i];
    }
    return actual_sum-sum;
  }

  static int cycleMethod(int[] arr){
    //two pointers initially pointing to start
    int slow = arr[0];
    int fast = arr[0];

    //run loop till both point to same
    do{
      slow = arr[slow];    //move slow to 1 jump
      fast = arr[arr[fast]];  //move fast to 2 jumps
    }while(slow!=fast);

    //now that both point to same, we have to find the start of cycle. point fast to start 
    fast = arr[0];
    //and move both 1 jump. when they meet, that will be the duplicate number
    while(slow!=fast){
      slow = arr[slow];
      fast = arr[fast];
    }
    return slow;
  }
}
