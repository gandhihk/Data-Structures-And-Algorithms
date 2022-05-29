import java.util.*;
class Main {
  /*
    Inversion Count for an array indicates – how far (or close) the array is from being sorted. If the array is already sorted, then the inversion count is 0, but if the array is sorted in the reverse order, the inversion count is the maximum. 
    Solution:
    1. Use merge sort technique
    2. while merging the array, check if arr[i](in left array)>arr[j](in right subarray). If yes then all the elements from i+1 will be > arr[j] since left array is already sorted. So, that will be the count of inversions in that merged subarray
    3. add all such counts while merging subarrays till top array
    TC=> O(nlogn), SC=> O(n)
  */
  public static void main(String[] args) {
    int[] arr = {1, 20, 6, 4, 5};
    System.out.println(mergeSort(arr, 0, arr.length-1));
  }

  static int mergeSort(int[] arr, int l, int r){
    int invCount=0, mid;
    if(l<r){
      mid = (l+r)/2;
      invCount+= mergeSort(arr, l, mid);    //sort and get inv count from left subarray
      invCount+=mergeSort(arr, mid+1, r);  //sort and get inv count from right subarray

      // Total inversion count = left subarray count + right subarray count + merge count
      invCount+= mergeAndCountInv(arr, l, mid, r);      
    }
    return invCount;
  }

  //standard merge function
  static int mergeAndCountInv(int[] arr, int l, int m, int r){
    // Left subarray
    int[] left = Arrays.copyOfRange(arr, l, m + 1);
 
    // Right subarray
    int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);
 
    int i = 0, j = 0, k = l, inv = 0;
 
    while (i < left.length && j < right.length) {
      if (left[i] <= right[j])
        arr[k++] = left[i++];
      else {
        arr[k++] = right[j++];
        inv += m-l-i+1;      //count no. of elements after i in left subarray, that will be the inv count
      }
    }
    while (i < left.length)
      arr[k++] = left[i++];
    while (j < right.length)
      arr[k++] = right[j++];
    return inv;
  }
}
