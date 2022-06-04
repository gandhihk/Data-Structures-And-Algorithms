class PeakElement {
  /*
    Given an array of integers. Find a peak element in it. An array element is a peak if it is NOT smaller than its neighbours
    1st Solution: Linear search
    2nd solution: Binary search
      Use below conditions for binary search-
      a. if mid is peak(check neighbours), return mid
      b. if mid-1>mid, it means there is atleast 1 peak in left half
      c. if mid+1>mid, it means there is atleast 1 peak in right half
    TC=> O(logn), SC=> O(1)
  */
  public static void main(String[] args) {
    int[] arr = {1,2,1,3,5,6,4};
    System.out.println(findPeak(arr, 0, arr.length-1, arr.length));
  }

  static int findPeak(int arr[], int low, int high, int n){
    int mid = low + (high - low) / 2;
 
    // Compare mid with its neighbours (if neighbours exist)
    if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == n - 1 || arr[mid + 1] <= arr[mid]))
      return mid;
    // If mid is not peak and its left neighbor>mid, then left half must have a peak element
    else if (mid > 0 && arr[mid - 1] > arr[mid])
      return findPeak(arr, low, (mid - 1), n);
    // If mid is not peak and its right neighbor>mid, then right half must have a peak element
    else
      return findPeak(arr, (mid + 1), high, n);
  }
}
