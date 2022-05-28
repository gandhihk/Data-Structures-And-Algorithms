class FindMinOrMaxInSortedRotatedArray {
  /*
    A sorted array is rotated at some unknown point, find the minimum element in it. 
The following solution assumes that all elements are distinct.
    Solution: Same as finding pivot when searching element in sorted rotated array
    TC=> O(logn), SC=> O(1)
  */
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }

  public static int findPivot(int[] arr, int l, int h){
        if(l>h)
          return 0;
        if(l==h)
          return l;
        int mid=(l+h)/2;

        // Check if mid itself is minimum element
        if(mid>l && arr[mid-1]>arr[mid])
          return mid;
        else if(mid<h && arr[mid+1]<arr[mid])    // Check if element (mid+1) is minimum element
          return mid+1;

        if(arr[h]>arr[mid]) {    //right subarray is sorted i.e. pivot is in left subarray
          return findPivot(arr, l, mid-1);
        }else{  //left subarray is sorted, that means pivot is in right subarray
          return findPivot(arr, mid+1, h);
        }
    }
}
