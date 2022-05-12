import java.util.*;
class AlternateNegPosWithoutOrder {
  /*
    Rearrange the array to have -ve and +ve elements on alternate position. Order should be preserved. Any extra +ve/-ve elements will be placed last.
    TC=> O(n), SC=> O(1)
    Solution:
      1. Move all -ve numbers to the last
      2. Swap alternate +ve elements with next -ve element
  */
  public static void main(String[] args) {
    int[] arr = {2, 3, -4, -1, 6, -9, -10};
    rearrange(arr);
    System.out.println(Arrays.toString(arr));
  }

  static void rearrange(int[] arr){
    int n= arr.length;
    int i=0, j=n-1, temp;
    while(i<j){
      while(i<=n-1 && arr[i]>0)    //skip all +ve
        i++;
      while(j>=0 && arr[j]<0)      //skip all -ve
        j--;
      if(i<j){
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    
    if(i==0 || i==n)    //edge case check
      return;
      
    int k=1;
    while(k<n && i<n){    //put -ve number at each odd pos
      temp = arr[k];
      arr[k] = arr[i];
      arr[i] = temp;
      k+=2;
      i++;
    }
  }
}
