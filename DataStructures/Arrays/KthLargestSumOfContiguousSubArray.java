import java.util.*;
class KthLargestSumOfContiguousSubArray {
  /*
    Given an array of integers. Write a program to find the K-th largest sum of contiguous subarray within the array of numbers which has negative and positive numbers.
    Solution:
      1. Calculate all the presums of elements and store in another array(Optimization: store in same array)
      2. Run nested loop to get sum of each possible contiguous subarray. Add these sums in MinHeap till k size, then if sum>k then insert, else don't
      3. At the end, root of the heap will be the Kth largest sum
    TC=> (n^2)logn, SC=> O(k+n)
  */
  public static void main(String[] args) {
    int arr[] = {10, -10, 20, -40};
    int k=1;
    System.out.println(findKthLargestSum(arr, arr.length, k));
  }

  static int findKthLargestSum(int[] arr, int n, int k){
    //array to store prefix sums
    int sum[] = new int[n + 1];
    sum[0] = 0;
    sum[1] = arr[0];
    for (int i = 2; i <= n; i++)
      sum[i] = sum[i - 1] + arr[i - 1];

    //Using PriorityQueue for min heap
    PriorityQueue<Integer> Q = new PriorityQueue<Integer> ();

    //nested loop to get sum of all the contiguous subarrays
    for (int i = 1; i <= n; i++)
    {
      for (int j = i; j <= n; j++)    
      {
        int x = sum[j] - sum[i - 1];    //get sum of subarray from i to j
     
        if (Q.size() < k)    //if queue has less then k elements, then simply push it
          Q.add(x);
        else{
          if (Q.peek() < x){    //insert only if sum>root of heap
            Q.poll();
            Q.add(x);
          }
        }
      }
    }
         
    return Q.poll();      //top element will be the kth largest sum
  }
}
