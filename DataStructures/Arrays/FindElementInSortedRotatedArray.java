import java.util.*;
class FindElementInSortedRotatedArray {
  /*
    An element in a sorted array can be found in O(log n) time via binary search. But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand. So for instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise a way to find an element in the rotated array in O(log n) time.

    Solution steps: 
      1. Find pivot using method similar to Binary search
      2. Divide array into 2 subarrays at pivot point and apply binary search in both to find key
    TC=> O(logn), SC=> O(1)
    
    Use same pivot solution to find number of rotations in a sorted array
  */
  public static void main(String[] args) {
    int[] arr = {3,5,1};
    int key = 1;
    System.out.println(find(arr, key));
  }

  public static int find(int[] arr, int key){
    if(arr.length==1)
      if(arr[0]==key)
        return 0;
      else return -1;
    else if(arr.length==2)
      if(arr[0]==key)
        return 0;
      else if(arr[1]==key)
        return 1;
      else return -1;
    int n = arr.length;
    int pivot = findPivot(arr, 0, n-1);
    System.out.println("Pivot pos:"+pivot);
    if(arr[pivot]==key)
      return pivot;
    if(arr[0]<=key)
      return binarySearch(arr, 0, pivot-1, key);
    return binarySearch(arr, pivot+1, n-1, key);
  }

  public static int findPivot(int[] arr, int l, int h){
    if(l>h)
      return -1;
    if(l==h)
      return l;
    int mid=(l+h)/2;

    if(mid>l && arr[mid-1]>arr[mid])
      return mid-1;
    else if(mid<h && arr[mid+1]<arr[mid])
      return mid;
        
    if(arr[l]>arr[mid]) {    //left subarray is not sorted i.e. pivot is in left subarray
      return findPivot(arr, l, mid-1);
    }else{  //left subarray is sorted, that means pivot is in right subarray
      return findPivot(arr, mid+1, h);
    }
  }

  /* Standard Binary Search function */
    static int binarySearch(int arr[], int low, int high, int key)
    {
        if (high < low)
            return -1;
 
        int mid = (low + high) / 2;
        if (key == arr[mid])
            return mid;
        if (key > arr[mid])
            return binarySearch(arr, (mid + 1), high, key);
        return binarySearch(arr, low, (mid - 1), key);
    }
}
