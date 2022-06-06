import java.util.*;
class NextPermutation {
  /*
    Given an array of integers nums, find the next permutation of nums. The next permutation of an array of integers is the next lexicographically greater permutation of its integer.
    Solution: 
    1. Traverse from right, find 1st element arr[i]<=arr[i+1]
    2. Again traverse from right, find 1st element which is > element at index found from step 1
    3. Swap these 2 elements
    4. Reverse all elements after indx found from step 1
    TC=> O(n), SC=> O(1)
  */
  public static void main(String[] args) {
    int[] arr = {1, 2, 4, 3};
    findNextPerm(arr);
  }

  static void findNextPerm(int[] arr){
    int index, n=arr.length, i=n-2;
    while(i>=0 && arr[i]>=arr[i+1])    //step 1
      i--;
    index=i;
    if(i>=0){    //condition to see if there is any next permutation, else simply reverse it and return
      i=n-1;
      while(i>=0 && arr[i]<=arr[index])    //step 2
        i--;
      swap(arr, index, i);    //step 3
    }
    reverse(arr, index+1, n-1);    //step 4
    System.out.println(Arrays.toString(arr));
  }

  static void swap(int[] arr, int i, int j){
    int temp=arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  static void reverse(int[] arr, int i, int j){
    while(i<j)
      swap(arr, i++, j--);
  }
}
