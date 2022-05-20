import java.util.*;
class FirstMissingPositive {
  /*
    Given an unsorted integer array nums, return the smallest missing positive integer.
You must implement an algorithm that runs in O(n) time and uses constant extra space.
    Solution:
      1. Segregate pos and neg numbers
      2. Traverse all pos numbers, mark positions of   each element by making arr[arr[i]-1] as -1.
      3. Traverse all numbers again from left, and ans=index of first positive number
    TC=> O(n), SC=> O(1)
  */
  public static void main(String[] args) {
    int[] arr = {1,2,0};
    System.out.println(firstMissingPositive(arr));
  }

  static int firstMissingPositive(int[] arr){
    //segregate +ve and -ve
    int negIndex=0, i, j, temp;
    for(i=0; i<arr.length; i++){
      if(arr[i]>0){
        temp=arr[i];
        arr[i]=arr[negIndex];
        arr[negIndex]=temp;
        negIndex++;
      }
    }
    //Now negIndex will have pos of 1st -ve index

    //Traverse thru +ve and mark positions of present numbers as -ve
    for(i=0; i<negIndex; i++){
      temp = Math.abs(arr[i]);
      if(temp-1<negIndex && arr[temp-1]>0)    //before marking as visited, check if number is withing positive range
        arr[temp-1]=-arr[temp-1];
    }

    //finally traverse array again, ans=1st +ve number
    for(i=0; i<negIndex; i++){
      if(arr[i]>0)    //found 1st +ve
        return i+1;
    }
    return negIndex+1;
  }
}
