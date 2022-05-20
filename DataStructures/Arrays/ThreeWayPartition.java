import java.util.*;
class ThreeWayPartition {
  /*
    Given an array and a range [lowVal, highVal], partition the array around the range such that array is divided in three parts. 
1) All elements smaller than lowVal come first. 
2) All elements in range lowVal to highVVal come next. 
3) All elements greater than highVVal appear in the end. 

    Solution:
      1. Keep 2 pointers, for next smaller position and for next larger position
      3. Traverse array, if element<lowVal, swap element with next smaller pos, if element>highVal, swap element with next larger pos
    TC=> O(n), SC=> O(1)
  */
  public static void main(String[] args) {
    int[] arr = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};
    int lowVal=10, highVal=20;
    threeWayPartition(arr, highVal, lowVal);
  }

  static void threeWayPartition(int[] arr, int highVal, int lowVal){
    int n=arr.length-1;
    int s=0, l=n, temp;
    for(int i=0; i<l; ){  //traverse till large(right) pos only, to avoid re-swapping
      if(arr[i]<lowVal){
        temp=arr[i];    //swap with next small pos
        arr[i]=arr[s];
        arr[s]=temp;
        s++;
        i++;          //increment traversing pointer only if element is swapped at low pos
      }
      else if(arr[i]>highVal){
        temp=arr[i];      //swap with next large pos
        arr[i]=arr[l];
        arr[l]=temp;
        l--;        //decrement only right pointer
      }
      else
        i++;        //increment traversing pointer if element==lowVal|highVal
    }
    System.out.println(Arrays.toString(arr));
  }
}
