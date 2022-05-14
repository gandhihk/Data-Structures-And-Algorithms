import java.util.*;
class KthLargestElement {
  /*
    Kth largest element in array
    Solution 1: 
      1. Use quicksort algorithm to partition array
      2. After each partition, check if pivot is at kth position, else find in respective subarray
    Average TC=> O(n), WTC=> O(n2), SC=> O(1)
  */
  public static void main(String[] args) {
    int[] arr = {10, 4, 5, 8, 6, 11, 26};
    int k=3;
    System.out.println(findKthSmallest(arr, 0, arr.length-1, arr.length-k+1));
  }

  static int findKthSmallest(int[] arr, int low, int high, int k){
    int pivot = randomPartition(arr, low, high);    //find the pivot

    System.out.println(Arrays.toString(arr));
    if(pivot == k-1)    //check if pivot is kth element
      return arr[pivot];
    else if(pivot < k-1)    //if pivot<k, then kth element is in right subarray
      return findKthSmallest(arr, pivot+1, arr.length-1, k);
    else    //if pivot>k, then kth element is in left subarray
      return findKthSmallest(arr, 0, pivot-1, k);
  }

  //standard partition algorithm
  static int partition(int[] arr, int low, int high){
    int pivot = arr[high], pivotloc = low;
    for (int i = low; i <= high; i++) {
      if (arr[i] < pivot) {
        int temp = arr[i];
        arr[i] = arr[pivotloc];
        arr[pivotloc] = temp;
        pivotloc++;
      }
    }
    //swapping pivot to the final pivot location
    int temp = arr[high];
    arr[high] = arr[pivotloc];
    arr[pivotloc] = temp;
    return pivotloc;
  }

  /*
    Solution 2:
      1. Use randomized pivot for partition and do quicksort
      2. After each partition, check if pivot is at kth position, else find in respective subarray
  */
  //random partition algorithm
  static int randomPartition(int[] arr, int low, int high){
    int n = high-low+1, temp;
    int pivot = (int)(Math.random() * (n - 1));
    temp = arr[low+pivot];
    arr[low+pivot] = arr[high];
    arr[high] = temp;
    
    pivot = arr[high]; 
    int pivotloc = low;
    for (int i = low; i <= high; i++) {
      if (arr[i] < pivot) {
        temp = arr[i];
        arr[i] = arr[pivotloc];
        arr[pivotloc] = temp;
        pivotloc++;
      }
    }
    //swapping pivot to the final pivot location
    temp = arr[high];
    arr[high] = arr[pivotloc];
    arr[pivotloc] = temp;
    return pivotloc;
  }
}
