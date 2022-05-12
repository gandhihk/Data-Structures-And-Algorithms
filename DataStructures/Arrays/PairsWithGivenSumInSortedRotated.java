class PairsWithGivenSumInSortedRotated {
  /*
    Given an array that is sorted and then rotated around an unknown point. Find the count of pairs with a given sum ‘x’ in the array. It may be assumed that all elements in the array are distinct.

    Solution:
    1. Find pivot using earlier method(Bin Search)
    2. Use 2 pointer method to find pairs with given sum, use pivot for getting initial pointers
  */
  public static void main(String[] args) {
    int arr[] = {11, 15, 6, 8, 9, 10};
    int sum = 16;
    System.out.println(findCount(arr, sum));
  }

  static int findCount(int[] arr, int sum){
    int n = arr.length;
    if(n==1)
      return 0;
    else if(n==2)
      if(arr[0]+arr[1]==sum)
        return 1;
      else return 0;

    int pivot = findPivot(arr, 0, n-1);
    return getPairsCount(arr, pivot, sum);
  }

  static int findPivot(int[] arr, int l, int h){
    if(l>h)
      return -1;
    if(l==h)
      return l;
    int m = (l+h)/2;
    if(l<m && arr[m-1]>arr[m])
      return m-1;
    else if(m<h && arr[m]>arr[m+1])
      return m;

    if(arr[l]<arr[m])  //left subarray is sorted=>pivot is in right subarray
      return findPivot(arr, m+1, h);
    return findPivot(arr, l, m-1);
  }

  static int getPairsCount(int[] arr, int p, int sum){
    int count = 0;
    int l=p+1, r=p;
    int n = arr.length;

    while(l!=r){
      if((arr[l]+arr[r])==sum){
        count++;
        // This condition is required
        // to be checked, otherwise
        // l and r will cross each
        // other and loop will never
        // terminate.
        if(l == (r-1+n)%n)    //check if l and r have crossed each other, so that to terminate the loop
        {
          return count;
        }
             
        l = (l + 1) % n;
        r = (r - 1 + n) % n;
      }
      
      if(sum<(arr[l]+arr[r]))  //move right pointer
        r = (r-1+n)%n;    //+n and %n is done for cyclic rotation of pointer
      else    //move left pointer
        l = (l+1)%n;    //%n is done for cyclic rotation
    }
    return count;
  }
}
