class MinInSortedRotatedArrayDuplicates {
  public static void main(String[] args) {
    int arr1[] = { 1,1,1,1,1 };
    int n1 = arr1.length;
    System.out.println("The minimum element is "
                           + findMin(arr1, 0, n1 - 1));
  }

  public static int findMin(int arr[], int low, int high)
  {
    while (low < high) {
      int mid = low + (high - low) / 2;
        if (arr[mid] == arr[high])
          high--;
 
        else if (arr[mid] > arr[high])
          low = mid + 1;
        else
          high = mid;
      }
    return arr[high];
  }
}
