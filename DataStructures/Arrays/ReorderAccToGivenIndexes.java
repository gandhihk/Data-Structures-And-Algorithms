import java.util.*;
class ReorderAccToGivenIndexes {
  /*
    Given two integer arrays of same size, “arr[]” and “index[]”, reorder elements in “arr[]” according to given index array. It is not allowed to given array arr’s length.
  */
  public static void main(String[] args) {
    int[] arr = {50, 40, 70, 60, 90};
    int[] index = {3,  0,  4,  1,  2};
    reorder(arr, index);
         
    System.out.println("Reordered array is: ");
    System.out.println(Arrays.toString(arr));
    System.out.println("Modified Index array is:");
    System.out.println(Arrays.toString(index));
  }

  static void reorder(int[] arr, int[] index){
    int i=0, temp;
    while(i<index.length){
      if(index[i]==i){
        i++;
      }else{
        temp = arr[i];
        arr[i] = arr[index[i]];
        arr[index[i]] = temp;
        temp = index[i];
        index[i] = index[index[i]];
        index[temp] = temp; 
      }
    }
  }
}
