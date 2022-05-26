import java.util.*;
class SubarrayWithGivenSum {
  /*
    Given an unsorted array arr of +ve/-ve integers and an integer sum, find a continuous subarray which adds to a given sum.
    Solution for +ve numbers:
    1. Similar to sliding window, keep 2 pointers left and right
    2. Keep adding elements to curr_sum. if curr_sum>target, then keep removing elements from start. else if curr_sum==target, print
    TC=> O(N), SC=>O(1)

    Solution for +ve and -ve numbers:
    1. Keep a hashmap with prefix sum as key and index as value.
    2. Traverse array and add element to curr_sum. If curr_sum==target, print subarray from 0 to i.
    3. If there is a key in hashmap as curr_sum-target, then print subarray from hashmap.get(curr_sum-target) to i. 
    4. if nothing, then add curr_sum to hashmap
    TC=> O(n), SC=>(n)

    Solution for +ve and -ve numbers in constant space:
    1. Use same technique as used in Solution 1. only difference is to make all numbers +ve by adding absolute value of smallest element(-ve) to all numbers. this is done while adding/removing number to/from window
    2. while adding element to window, add arr[i]+abs(smallest). while removing element, subtract arr[i]+abs(smallest). also, while comparing curr_sum with target, check if curr_sum>target+(i-start)*abs(smallest)
    TC=>O(n), SC=> O(1)

    Solution for getting count of such subarrays:
    1. Use same technique used in solution 2, but instead of saving value as index, save count of subarray as value in hashmap
    2. when curr_sum=target, increment count of that curr_sum-target in hashmap
    TC=> O(n), SC=>O(n)
  */
  public static void main(String[] args) {
    int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
    int arr2[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
    int target = 14;
    int target2 = 33;
    //only +ve elements
    subArraySumPositive(arr, target);
    //both +ve/-ve elements
    subArraySumBoth(arr2, target2);
    //both with constant space
    subArraySumConstantSpace(arr2, arr2.length, target2);
    //find count of such subarrays
    findSubarrayCount(arr, arr.length, target);
  }

  //only +ve numbers
  static void subArraySumPositive(int[] arr, int sum){
    int curr_sum = arr[0], start = 0, i;
    
    for (i = 1; i < arr.length; i++) {
      //If curr_sum>sum, then remove starting elements
      while (curr_sum > sum && start < i - 1) {
        curr_sum = curr_sum - arr[start];
        start++;
      }
  
      //If curr_sum becomes equal to sum, then print
      if (curr_sum == sum) {
        int p = i - 1;
        System.out.println("Sum found between indexes " + start+ " and " + p);
        return;
      }
  
      // Add this element to curr_sum
      if (i < arr.length)
        curr_sum = curr_sum + arr[i];
    }
    System.out.println("No subarray found");
  }

  //both +ve/-ve numbers
  static void subArraySumBoth(int[] arr, int sum){
    int cur_sum = 0;
    int start = 0;
    int end = -1;
    HashMap<Integer, Integer> hashMap = new HashMap<>();
 
    for (int i = 0; i < arr.length; i++) {
      cur_sum = cur_sum + arr[i];
      //check whether cur_sum=sum, if 0 it means the sub array is starting from index 0- so stop
      if (cur_sum == sum) {
        start = 0;
        end = i;
        break;
      }
      //if hashMap already has the value, means we already have subarray with the sum - so stop
      if (hashMap.containsKey(cur_sum - sum)) {
        start = hashMap.get(cur_sum - sum) + 1;
        end = i;
        break;
      }
      //if value is not present then add to hashmap
      hashMap.put(cur_sum, i);
    }
    //if end is -1 : we have reached end without the sum
    if (end == -1) {
      System.out.println("No subarray with given sum exists");
    } else {
      System.out.println("Sum found between indexes "+ start + " to " + end);
    }
  }

  //both with constant space
  static void subArraySumConstantSpace(int arr[], int n, int sum)
  {
    int minEle = Integer.MAX_VALUE;
    // Find minimum element in the array
    for (int i = 0; i < n; i++)
        minEle = Math.min(arr[i], minEle);
     
    //Initialize curr_sum as first element and starting point as 0
    int curr_sum = arr[0] + Math.abs(minEle);
    int start = 0, i;
     
    //Starting window length will be 1,
    //For generating new target sum, add abs(minEle) to sum only 1 time
    int targetSum = sum;
     
    for (i = 1; i <= n; i++){
      // If curr_sum exceeds the sum, then remove the starting elements
      while (curr_sum > targetSum+(i-start)*Math.abs(minEle) && start < i){
        curr_sum = curr_sum - arr[start] - Math.abs(minEle);
        start++;
      }
     
      // If curr_sum=sum, then return true
      if (curr_sum == targetSum + (i-start)*Math.abs(minEle)){
        System.out.println("Sum found between indexes " +start + " and " + (i - 1));
        return;
      }
     
      // Add this element to curr_sum
      if (i < n){
        curr_sum = curr_sum + arr[i]+Math.abs(minEle);
      }
    }
    // If we reach here, then no subarray
    System.out.println("No subarray found");
  }

  //count of subarrays
  static void findSubarrayCount(int arr[], int n, int sum)
  {
    HashMap<Integer, Integer> prevSum = new HashMap<>();
    int res = 0;
    int currsum = 0;
    for (int i = 0; i < n; i++) {
      currsum += arr[i];
      if (currsum == sum)
        res++;
      if (prevSum.containsKey(currsum - sum))
        res += prevSum.get(currsum - sum);
            // prevSum.put(currsum, prevSum.getOrDefault(currsum, 0)+1);
      Integer count = prevSum.get(currsum);
      if (count == null)
        prevSum.put(currsum, 1);
      else
        prevSum.put(currsum, count + 1);
    }
 
    System.out.println("Count: "+res);
  }
}
